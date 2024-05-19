package Bus.Booking.App.Booking.Operators.Service;
import Bus.Booking.App.Booking.Operators.entity.BusOperator;
import Bus.Booking.App.Booking.Operators.entity.TicketCost;
import Bus.Booking.App.Booking.Operators.payload.BusOperatorDto;
import Bus.Booking.App.Booking.Operators.repository.BusOperatorRepository;
import Bus.Booking.App.Booking.Operators.repository.TicketCostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
public class BusOperatorServiceImpl implements BusOperatorService {
    @Autowired
    private BusOperatorRepository busOperatorRepository;
    @Autowired
    private ModelMapper mapper;
    @Autowired
   private TicketCostRepository ticketCostRepository;

    @Override
    public BusOperatorDto scheduleBus(BusOperatorDto busOperatorDto) {
        BusOperator busOperator = mapToEntity(busOperatorDto);
        TicketCost ticketCost = new TicketCost();
        ticketCost.setTicketId(busOperatorDto.getTicketCost().getTicketId());
        ticketCost.setCost(busOperatorDto.getTicketCost().getCost());
        ticketCost.setCode(busOperatorDto.getTicketCost().getCode());
        ticketCost.setDiscountAmount(busOperatorDto.getTicketCost().getDiscountAmount());
        busOperator.setTicketCost(ticketCost);
        // Set BusOperator for TicketCost
        ticketCost.setBusOperator(busOperator);

        // Set the same busId for BusOperator and TicketCost
        String busId = UUID.randomUUID().toString();
        busOperator.setBusId(busId);

        // Set the busId for TicketCost's BusOperator association
        ticketCost.getBusOperator().setBusId(busId);

        // Save BusOperator along with its associated TicketCost
        busOperator.setTicketCost(ticketCost);
        BusOperator savedBusSchedule = busOperatorRepository.save(busOperator);
        return mapToDto(savedBusSchedule);
    }
    @Override
    public List<BusOperatorDto> getbyBusOperatorCompanyName(String busOperatorCompanyName, int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<BusOperator> busOperators = busOperatorRepository.findByBusOperatorCompanyName(busOperatorCompanyName, pageable);
        List<BusOperator> busOperatorList = busOperators.getContent();
        List<BusOperatorDto> operatorDtos = busOperatorList.stream()
                .map(busOperator -> mapToDto(busOperator))
                .collect(Collectors.toList());
        return operatorDtos;
    }


    BusOperator mapToEntity(BusOperatorDto busOperatorDto) {
        BusOperator busOperator = mapper.map(busOperatorDto, BusOperator.class);
        return (busOperator);
    }
    BusOperatorDto mapToDto(BusOperator busOperator) {
        BusOperatorDto busOperatorDto = mapper.map(busOperator, BusOperatorDto.class);
        return busOperatorDto;
    }
}


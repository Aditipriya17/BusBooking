package Bus.Booking.App.Booking.User.Service;
import Bus.Booking.App.Booking.Operators.entity.BusOperator;
import Bus.Booking.App.Booking.Operators.repository.BusOperatorRepository;
import Bus.Booking.App.Booking.User.Payload.BusListDto;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class SearchBusesService {

    private BusOperatorRepository busOperatorRepository;

    public SearchBusesService(BusOperatorRepository busOperatorRepository) {
        this.busOperatorRepository = busOperatorRepository;
    }

    public List<BusListDto>searchBuses(String departureCity, String arrivalCity, Date departureDate) {
       List<BusOperator> busesAvalaible = busOperatorRepository.findByDepartureCityAndArrivalCityAndDepartureDate(departureCity, arrivalCity, departureDate);
       List<BusListDto> dtos = busesAvalaible.stream().map(bus -> mapTODto(bus)).collect(Collectors.toList());
       return dtos;
   }
      BusListDto mapTODto(BusOperator busOperator){
        BusListDto busListDto=new BusListDto();
        busListDto.setBusId(busOperator.getBusId());
        busListDto.setBusNumber(busOperator.getBusNumber());
        busListDto.setBusType(busOperator.getBusType());
        busListDto.setArrivalDate(busOperator.getArrivalDate());
        busListDto.setArrivalCity(busOperator.getArrivalCity());
        busListDto.setDepartureCity(busOperator.getDepartureCity());
        busListDto.setDepartureDate(busOperator.getDepartureDate());
        busListDto.setAmenities(busOperator.getAmenities());
        busListDto.setTotalTravelTime(busOperator.getTotalTravelTime());
        busListDto.setArrivalTime(busOperator.getArrivalTime());
        busListDto.setDepartureTime(busOperator.getDepartureTime());
        busListDto.setNumberSeats(busOperator.getNumberSeats());
        return busListDto;

   }
}

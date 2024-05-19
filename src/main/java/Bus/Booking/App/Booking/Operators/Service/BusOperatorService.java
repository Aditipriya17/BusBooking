package Bus.Booking.App.Booking.Operators.Service;


import Bus.Booking.App.Booking.Operators.payload.BusOperatorDto;

import java.util.List;

public interface BusOperatorService {
    BusOperatorDto scheduleBus(BusOperatorDto busOperatorDto);

    List<BusOperatorDto> getbyBusOperatorCompanyName(String busOperatorCompanyName, int pageNo, int pageSize);

}



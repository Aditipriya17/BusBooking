package Bus.Booking.App.Booking.Operators.controller;

import Bus.Booking.App.Booking.Operators.Service.BusOperatorService;
import Bus.Booking.App.Booking.Operators.payload.BusOperatorDto;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/bus-operator")
public class BusOperatorController {
    @Autowired
    private BusOperatorService busOperatorService;

    @PostMapping
    public ResponseEntity<?> scheduleBus(@Valid @RequestBody BusOperatorDto busOperatorDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // Handle validation errors here
            return new ResponseEntity<>(bindingResult.getFieldError().getDefaultMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        BusOperatorDto dto = busOperatorService.scheduleBus(busOperatorDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    //http://localhost:8080/api/bus-operator?busOperatorCompanyName=SuperiorTransit
    @GetMapping
    public ResponseEntity<List<BusOperatorDto>> getByBusOperatorCompanyName(
            @RequestParam String busOperatorCompanyName,
            @RequestParam(name = "pageNo", required = false, defaultValue = "0") int pageNo,
            @RequestParam(name = "pageSize", required = false, defaultValue = "2") int pageSize

    ) {
        List<BusOperatorDto> Dtos = busOperatorService.getbyBusOperatorCompanyName(busOperatorCompanyName,pageNo,pageSize);
        return new ResponseEntity<>(Dtos,HttpStatus.OK);
    }
}

    //http://localhost:8080/api/bus-operator?busOperatorCompanyName=SuperiorTransit&pageNo=0&pageSize=2

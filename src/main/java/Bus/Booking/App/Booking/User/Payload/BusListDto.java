package Bus.Booking.App.Booking.User.Payload;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalTime;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusListDto {
    @Id
    private String busId;
    @NotEmpty(message = " please enter busNumber")
    private String busNumber;
    @NotEmpty(message = " please enter busOperatorCompanyName")
    private String busOperatorCompanyName;
    @NotEmpty(message = " please enter numberSeats")
    private int numberSeats;
    @NotEmpty(message = " please enter departureTime")
    private LocalTime departureTime;
    @NotEmpty(message = " please enter arrivalTime")
    private LocalTime arrivalTime;
    @NotEmpty(message = " please enter departureDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date departureDate;
    @NotEmpty(message = " please enter arrivalDate ")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date arrivalDate;
    @NotEmpty(message = " please enter departureCity")
    private String departureCity;
    @NotEmpty(message = " please enter arrivalCity ")
    private String arrivalCity;
    @NotEmpty(message = " please enter amenities")
    private String amenities;
    @NotEmpty(message = " please enter busType")
    private String busType;
    @NotEmpty
    private Double totalTravelTime;

}

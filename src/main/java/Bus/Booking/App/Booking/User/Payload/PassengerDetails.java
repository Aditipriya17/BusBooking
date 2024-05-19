package Bus.Booking.App.Booking.User.Payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PassengerDetails {
    private String firstName;
    private String lastName;
    private String email;
    private String mobile;
}


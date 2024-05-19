package Bus.Booking.App.Booking.Operators.Exception;

import lombok.Getter;

import java.util.Date;

@Getter
public class ErrorDetails {
    private Date timestamp;
    private String message;
    private String details;
    public ErrorDetails(Date timestamp ,String message ,String details){
        this.timestamp= timestamp;
        this.message =message;
        this.details=details;
    }


    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}

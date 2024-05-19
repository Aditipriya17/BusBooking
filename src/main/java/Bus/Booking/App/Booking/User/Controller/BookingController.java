package Bus.Booking.App.Booking.User.Controller;
import Bus.Booking.App.Booking.User.Payload.BookingDetailsDto;
import Bus.Booking.App.Booking.User.Payload.PassengerDetails;
import Bus.Booking.App.Booking.User.Service.BookingService;
import Bus.Booking.App.Booking.User.Util.EmailService;
import Bus.Booking.App.Booking.User.Util.PdfGenerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping ("/api/user")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private PdfGenerationService pdfGenerationService;

    @PostMapping("/bookings")
    public ResponseEntity<String> bookBus(
            @RequestParam("busId") String busID,
            @RequestParam("ticketId") String ticketId,
            @RequestBody PassengerDetails passengerDetails) {

        // Assuming you have logic to validate and process the booking
        BookingDetailsDto bookingDetails = bookingService.createBooking(busID, ticketId, passengerDetails);

        // Generate PDF for booking details
        byte[] pdfAttachment = pdfGenerationService.generatePassengerDetailsPdf(bookingDetails);

        // Send email with the PDF attachment
        String toEmail = passengerDetails.getEmail();
        String subject = "Bus Booking Details";
        String body = "Thank you for booking with us! Find your booking details attached.";

        emailService.sendEmailWithAttachment(toEmail, subject, body, pdfAttachment, "BookingDetails.pdf");

        return ResponseEntity.ok("Booking successful. Confirmation email sent.");
    }
}
package Bus.Booking.App.Booking.User.Util;
import Bus.Booking.App.Booking.User.Payload.BookingDetailsDto;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;

@Service
public class PdfGenerationService {

    public byte[] generatePassengerDetailsPdf(BookingDetailsDto bookingDetailsDto) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        try (PdfWriter writer = new PdfWriter(outputStream);
             PdfDocument pdfDocument = new PdfDocument(writer)) {

            Document document = new Document(pdfDocument);
            document.add(new Paragraph("Booking Details"));
            document.add(new Paragraph("Booking Id: " + bookingDetailsDto.getBookingId()));
            document.add(new Paragraph("First Name: " + bookingDetailsDto.getFirstName()));
            document.add(new Paragraph("Last Name: " + bookingDetailsDto.getLastName()));
            document.add(new Paragraph("Email: " + bookingDetailsDto.getEmail()));
            document.add(new Paragraph("Mobile: " + bookingDetailsDto.getMobile()));
            document.add(new Paragraph("Bus Company: " + bookingDetailsDto.getBusCompany()));
            document.add(new Paragraph("Form: " + bookingDetailsDto.getFrom()));
            document.add(new Paragraph("To: " + bookingDetailsDto.getTo()));
            document.add(new Paragraph("Price: " + bookingDetailsDto.getPrice()));


            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return outputStream.toByteArray();
    }
}

package Bus.Booking.App.Booking.User.Repository;
import Bus.Booking.App.Booking.User.Entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking,String> {



}


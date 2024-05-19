package Bus.Booking.App.Booking.User.Repository;

import Bus.Booking.App.Booking.User.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<User,Integer> {

}


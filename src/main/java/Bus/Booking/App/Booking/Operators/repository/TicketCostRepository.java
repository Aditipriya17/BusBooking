package Bus.Booking.App.Booking.Operators.repository;

import Bus.Booking.App.Booking.Operators.entity.TicketCost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketCostRepository extends JpaRepository<TicketCost,String> {
}

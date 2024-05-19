package Bus.Booking.App.Booking.Operators.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ticket_cost")
public class TicketCost {
    @Id
    @NotNull
    @Column(name = "ticket_id", unique = true)
    private  String ticketId;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bus_id")
    private BusOperator busOperator;
    @NotNull
    @Column(name = "code", nullable = false)
    private String code;

    @NotNull
    @Column(name = "cost", nullable = false)
    private Double cost;

    @Column(name = "discount_amount")
    private Double discountAmount;


}


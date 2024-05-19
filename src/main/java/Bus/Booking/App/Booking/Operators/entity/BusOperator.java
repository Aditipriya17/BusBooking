package Bus.Booking.App.Booking.Operators.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name = "bus_operator")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BusOperator {
    @Id
    @Column(name = "bus_id")
    private String busId;
    @NotNull
    @Column(name = "bus_number", nullable = false, unique = true)
    private String busNumber;

    @NotNull
    @Column(name = "bus_operator_company_name", nullable = false)
    private String busOperatorCompanyName;

    @NotNull
    @Column(name = "driver_name", nullable = false)
    private String driverName;

    @NotNull
    @Column(name = "number_seats", nullable = false)
    private int numberSeats;

    @NotNull
    @Column(name = "support_staff", nullable = false)
    private String supportStaff;

    @NotNull
    @Column(name = "departure_time", nullable = false)
    private LocalTime departureTime;

    @NotNull
    @Column(name = "arrival_time", nullable = false)
    private LocalTime arrivalTime;

    @NotNull
    @Column(name = "departure_date", nullable = false)
   @Temporal(TemporalType.DATE)
    private Date departureDate;

    @NotNull
    @Column(name = "arrival_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date arrivalDate;

    @NotNull
    @Column(name = "departure_city", nullable = false)
    private String departureCity;

    @NotNull
    @Column(name = "arrival_city", nullable = false)
    private String arrivalCity;

    @NotNull
    @Column(name = "amenities", nullable = false)
    private String amenities;

    @NotNull
    @Column(name = "bus_type", nullable = false)
    private String busType;

    @NotNull
    @Column(name = "total_travel_time", nullable = false)
    private Double totalTravelTime;
    @OneToOne(mappedBy = "busOperator", cascade = CascadeType.ALL)
    private TicketCost ticketCost;
}

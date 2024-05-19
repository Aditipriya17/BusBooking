package Bus.Booking.App.Booking.Operators.repository;
import Bus.Booking.App.Booking.Operators.entity.BusOperator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Date;
import java.util.List;

public interface BusOperatorRepository extends JpaRepository<BusOperator,String> {


    Page<BusOperator> findByBusOperatorCompanyName(String operatorCompanyName, Pageable busOperatorCompanyName);


    List<BusOperator> findByDepartureCityAndArrivalCityAndDepartureDate(String departureCity, String arrivalCity, Date departureDate);

    //YOU CAN ALSO USE CUSTOM JPQL QUERY
  // @Query("SELECT bo FROM BusOperator bo departureCity=:departureCity And bo arrivalCity=:arrivalCity AND bo departureDate =:departureDate")
    //List<BusOperator>SearchByCitiesDate(@Param("departureCity")String departureCity,@Param("arrivalCity") String arrivalCity,@Param("departureDate")Date departureDate);
}
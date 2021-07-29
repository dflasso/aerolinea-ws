package ec.edu.espe.monster.aerolineacondor.model.DAO;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import ec.edu.espe.monster.aerolineacondor.model.entity.Flights;
import ec.edu.espe.monster.aerolineacondor.model.entity.GeographicLocation;

public interface FlightsDAO extends JpaRepository<Flights, Long> {

	List<Flights> findByCityOriginAndCityDestinyAndTimestampTakeOff(GeographicLocation cityOrigin, GeographicLocation cityDestiny, Date timestampTakeOfStart);
	
	List<Flights> findByCityOriginAndCityDestinyAndTimestampTakeOff(GeographicLocation cityOrigin, GeographicLocation cityDestiny, Date timestampTakeOfStart, Sort sort);
}

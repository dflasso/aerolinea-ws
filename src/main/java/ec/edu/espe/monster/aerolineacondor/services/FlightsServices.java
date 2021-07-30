package ec.edu.espe.monster.aerolineacondor.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import ec.edu.espe.monster.aerolineacondor.model.DAO.FlightsDAO;
import ec.edu.espe.monster.aerolineacondor.model.entity.Flights;
import ec.edu.espe.monster.aerolineacondor.model.entity.GeographicLocation;
import lombok.extern.slf4j.Slf4j;

@Service
@Primary
@Slf4j
public class FlightsServices {

	@Autowired
	private FlightsDAO flightsDAO;
	
	@Autowired
	private GeographicLocationService geographicLocationSevices;
	
	public List<Flights> findByCitiesAndDate(Long idCityOrigin, Long idCityDestiny, Date date ){
		GeographicLocation origin = geographicLocationSevices.findById(idCityOrigin);
		GeographicLocation destiny = geographicLocationSevices.findById(idCityDestiny);
		return flightsDAO.findByCityOriginAndCityDestinyAndTimestampTakeOff(origin, destiny, date, Sort.by(Sort.Direction.DESC, "costTicket"));
				
	}
	
	public Flights findById(Long id) {
		Optional<Flights> fliOpt = flightsDAO.findById(id);
		
		if(!fliOpt.isPresent()) {
			GeographicLocation origin = geographicLocationSevices.findById(1L);
			GeographicLocation destiny = geographicLocationSevices.findById(2L);
			Flights fl = new Flights();
			fl.setCostTicket(80.50);
			fl.setNumTicketAviable(50);
			fl.setNumTicketTotal(50);
			fl.setCityOrigin(origin);
			fl.setCityDestiny(destiny);
			
			try {
				fl = flightsDAO.save(fl);
				fliOpt = Optional.of(fl);
			} catch (DataAccessException e) {
				log.info("[ERROR SAVE NEW Flight]  DataAccessException: " + e.getMessage());
				fl.setId(1L);
				fliOpt = Optional.of(fl);
			}
		}
		return fliOpt.get();
	}
}

package ec.edu.espe.monster.aerolineacondor.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import ec.edu.espe.monster.aerolineacondor.model.DAO.GeographicLocationDAO;
import ec.edu.espe.monster.aerolineacondor.model.constants.TypeGeograficLocation;
import ec.edu.espe.monster.aerolineacondor.model.entity.GeographicLocation;
import lombok.extern.slf4j.Slf4j;

@Service
@Primary
@Slf4j
public class GeographicLocationService {

	@Autowired
	private GeographicLocationDAO geographicLocationDAO;
	
	public List<GeographicLocation> findByType(String type){
		TypeGeograficLocation typeGeo = Stream.of(TypeGeograficLocation.values()).filter(state -> state.getCode().equals(type))
		.findFirst()
		.orElseThrow(IllegalArgumentException::new);
		
		return this.findByType(typeGeo);
	}
	
	public List<GeographicLocation> findByType(TypeGeograficLocation type){
		return geographicLocationDAO.findByType(type);
	}
	
	public List<GeographicLocation> findByIdPertainingTerritory(GeographicLocation location){
		return geographicLocationDAO.findByPertainingTerritory(location);
	}
	
	public List<GeographicLocation> findByNameOrCountryAndType(String type, String NameOrCountry){
		TypeGeograficLocation typeGeo = Stream.of(TypeGeograficLocation.values()).filter(state -> state.getCode().equals(type))
				.findFirst()
				.orElseThrow(IllegalArgumentException::new);
		
		return this.findByNameOrCountryAndType(typeGeo, NameOrCountry);
	}
	
	public List<GeographicLocation> findByNameOrCountryAndType(TypeGeograficLocation type, String NameOrCountry){
		return geographicLocationDAO.findByNameOrCountryAndType(NameOrCountry, NameOrCountry, type);
	}
	
	public GeographicLocation findById(Long id) {
		Optional<GeographicLocation> optpLocation =  geographicLocationDAO.findById(id);
		
		if(!optpLocation.isPresent()) {
			GeographicLocation newLocations = new GeographicLocation();
			newLocations.setName("Quito");
			newLocations.setCountry("Ecuador");
			newLocations.setType(TypeGeograficLocation.CITY);
			try {
				newLocations = geographicLocationDAO.save(newLocations);
				optpLocation = Optional.of(newLocations);
			} catch (DataAccessException e) {
				log.info("[ERROR SAVE NEW CITY]  DataAccessException: " + e.getMessage());
				newLocations.setId(1L);
				optpLocation = Optional.of(newLocations);
			}
		}
		return optpLocation.get();
	}
}

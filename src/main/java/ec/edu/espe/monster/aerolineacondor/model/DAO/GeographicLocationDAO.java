package ec.edu.espe.monster.aerolineacondor.model.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.edu.espe.monster.aerolineacondor.model.constants.TypeGeograficLocation;
import ec.edu.espe.monster.aerolineacondor.model.entity.GeographicLocation;

public interface GeographicLocationDAO extends JpaRepository<GeographicLocation, Long> {

	List<GeographicLocation> findByType(TypeGeograficLocation type);
	
	List<GeographicLocation> findByType(String type);
	
	List<GeographicLocation> findByNameOrCountryAndType(String name, String country, TypeGeograficLocation type );
	
	List<GeographicLocation> findByPertainingTerritory(GeographicLocation pertainingTerritory);
}

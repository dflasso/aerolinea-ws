package ec.edu.espe.monster.aerolineacondor.controllers.v1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.monster.aerolineacondor.model.entity.GeographicLocation;
import ec.edu.espe.monster.aerolineacondor.services.GeographicLocationService;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/v1/geographic-location")
@Api(tags = "Ciudades")
@CrossOrigin("*")
public class GeographicLocationController {

	@Autowired
	private GeographicLocationService geographicLocationService;
	
	
	
	@GetMapping("/{nameOrCountry}/{type}/find-all")
	public List<GeographicLocation> findByNameOrCountryAndType(@PathVariable String nameOrCountry, @PathVariable String type){
		return geographicLocationService.findByNameOrCountryAndType(type, nameOrCountry);
	}
	
	@GetMapping("/-/{type}/by-type")
	public List<GeographicLocation> findAll(@PathVariable String type){
		return geographicLocationService.findByType(type);
	}
}

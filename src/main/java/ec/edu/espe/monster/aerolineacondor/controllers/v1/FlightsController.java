package ec.edu.espe.monster.aerolineacondor.controllers.v1;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.monster.aerolineacondor.model.entity.Flights;
import ec.edu.espe.monster.aerolineacondor.services.FlightsServices;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/v1/flights")
@Api(tags = "Vuelos")
@CrossOrigin("*")
public class FlightsController {
	
	@Autowired
	private FlightsServices flightsServices;
	
	@GetMapping("/{idCityOrigin}/{idCityDestiny}/{date}/find-all")
	public List<Flights> findByCitiesAndDate(@PathVariable Long idCityOrigin,@PathVariable Long idCityDestiny,@PathVariable  @DateTimeFormat(pattern = "dd-MM-yyyy") Date date ){
		return flightsServices.findByCitiesAndDate(idCityOrigin, idCityDestiny, date);
	}

}

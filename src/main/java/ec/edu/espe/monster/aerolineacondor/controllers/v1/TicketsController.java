package ec.edu.espe.monster.aerolineacondor.controllers.v1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.monster.aerolineacondor.model.DTO.SellTicketRequest;
import ec.edu.espe.monster.aerolineacondor.services.TicketsServices;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/v1/tickets")
@Api(tags = "Boletos de Avión")
@CrossOrigin("*")
public class TicketsController {

	@Autowired
	private TicketsServices  ticketsServices;
	
	@PostMapping("/sell")
	public void sellTickets(@RequestBody List<SellTicketRequest> request) {
		ticketsServices.sellTicket(request);
	}
	
}

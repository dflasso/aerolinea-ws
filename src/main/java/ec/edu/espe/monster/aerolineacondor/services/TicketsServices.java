package ec.edu.espe.monster.aerolineacondor.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import ec.edu.espe.monster.aerolineacondor.model.DAO.FlightsDAO;
import ec.edu.espe.monster.aerolineacondor.model.DAO.TicketsDAO;
import ec.edu.espe.monster.aerolineacondor.model.DTO.SellTicketRequest;
import ec.edu.espe.monster.aerolineacondor.model.entity.Agency;
import ec.edu.espe.monster.aerolineacondor.model.entity.Client;
import ec.edu.espe.monster.aerolineacondor.model.entity.Flights;
import ec.edu.espe.monster.aerolineacondor.model.entity.Tickets;
import lombok.extern.slf4j.Slf4j;

@Service
@Primary
@Slf4j
public class TicketsServices {

	@Autowired
	private TicketsDAO ticketsDAO;
	
	@Autowired
	private FlightsDAO flightsDAO; 
	
	@Autowired
	private ClientServices clientServices; 
	
	@Autowired
	private FlightsServices flightsServices;
	
	@Autowired
	private AgenciaServices agenciaServices;
	
	
	public void sellTicket(List<SellTicketRequest> request) {
		
		List<Tickets> tickets = new ArrayList<Tickets>();
		
		for(SellTicketRequest reqTic : request) {
			Flights fl = flightsServices.findById(reqTic.getIdFlight());
			Client cl =  clientServices.findById(reqTic.getIdClient());
			Agency ag = agenciaServices.findByRUC(reqTic.getIdRucAgency());
			
			Tickets ticket = new Tickets();
			ticket.setAgency(ag);
			ticket.setClient(cl);
			ticket.setFlight(fl);
			ticket.setNumInvoice(reqTic.getNumFactura());
			
			try {
				fl.setNumTicketAviable(fl.getNumTicketAviable() -1);
				flightsDAO.save(fl);
			} catch (DataAccessException e) {
				log.info("NOT UPDATE Flights: " + fl.getId());
			}
			
			tickets.add(ticket);
		}
		
		try {
			ticketsDAO.saveAll(tickets);
		} catch (DataAccessException e) {
			log.info("NOT UPDATE TICKETS: " + tickets.size());
		}
		
	}
	
}

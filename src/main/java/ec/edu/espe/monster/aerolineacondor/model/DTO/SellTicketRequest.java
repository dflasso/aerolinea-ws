package ec.edu.espe.monster.aerolineacondor.model.DTO;

import lombok.Data;

@Data
public class SellTicketRequest {

	private Long idFlight;
	private Long idClient;
	private String IdRucAgency;
	private String numFactura;
}

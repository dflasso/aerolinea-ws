package ec.edu.espe.monster.aerolineacondor.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import ec.edu.espe.monster.aerolineacondor.model.DAO.AgenciaDAO;
import ec.edu.espe.monster.aerolineacondor.model.entity.Agency;

@Service
@Primary
public class AgenciaServices {

	@Autowired
	private AgenciaDAO agenciaDAO;
	
	public Agency findByRUC(String RUC) {
		Optional<Agency> agOpt =  agenciaDAO.findByRUC(RUC);
		
		if(agOpt.isEmpty()) {
			Agency agency = new Agency();
			agency.setId(1L);
			agOpt = Optional.of(agency);
		}
		
		return agOpt.get();
	}
}

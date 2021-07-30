package ec.edu.espe.monster.aerolineacondor.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import ec.edu.espe.monster.aerolineacondor.model.DAO.ClientDAO;
import ec.edu.espe.monster.aerolineacondor.model.entity.Client;

@Service
@Primary
public class ClientServices {

	@Autowired
	private ClientDAO clientDAO;
	
	public Client findById(Long id) {
		Optional<Client> clOpt = clientDAO.findById(id);
		
		if(clOpt.isEmpty()) {
			Client cl = new Client();
			cl.setId(1L);
			clOpt = Optional.of(cl);
		}
		
		return clOpt.get();
	}
}

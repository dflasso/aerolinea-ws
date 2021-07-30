package ec.edu.espe.monster.aerolineacondor.model.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.edu.espe.monster.aerolineacondor.model.entity.Client;

public interface ClientDAO extends JpaRepository<Client, Long> {

}
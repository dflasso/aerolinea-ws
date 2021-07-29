package ec.edu.espe.monster.aerolineacondor.model.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.edu.espe.monster.aerolineacondor.model.entity.Tickets;

public interface TicketsDAO extends JpaRepository<Tickets, Long> {

}

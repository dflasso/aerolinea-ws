package ec.edu.espe.monster.aerolineacondor.model.DAO;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.edu.espe.monster.aerolineacondor.model.entity.Agency;

public interface AgenciaDAO extends JpaRepository<Agency, Long> {

	Optional<Agency> findByRUC(String rUC);
}

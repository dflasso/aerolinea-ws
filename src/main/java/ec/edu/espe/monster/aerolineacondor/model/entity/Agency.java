package ec.edu.espe.monster.aerolineacondor.model.entity;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name = "Agencia")
@Data
public class Agency {

	@Id
	@Column(name = "id_agencia")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
		
	@Column(name = "agencia_RUC",  length = 20)
	private String RUC;
	
	@Column(name = "agencia_razon_social",  length = 300)
	private String name;
	
	@JsonIgnore
	@OneToMany(mappedBy = "agency", fetch = FetchType.LAZY)
	private List<Tickets> tickets;
}

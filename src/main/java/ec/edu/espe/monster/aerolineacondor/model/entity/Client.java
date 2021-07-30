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
@Table(name = "CLIENTE")
@Data
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_Cliente")
	private Long id;
	
	@Column(length = 300, name = "nombre_cliente")
	private String name;
	
	@Column(length = 300, name = "apellido_cliente")
	private String lastname;
	
	@Column(length = 50, name = "num_identification_cliente")
	private String numIdentification;
	
	@Column(length = 10, name = "tipo_identificacion")
	private String typeIdentification;
	
	@Column(length = 300, name = "correo_cliente")
	private String email;
	
	@Column(name = "telefono_cliente")
	private String phone;
	
	@JsonIgnore
	@OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
	private List<Tickets> tickets;
	
}
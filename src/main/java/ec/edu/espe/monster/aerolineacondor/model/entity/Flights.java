package ec.edu.espe.monster.aerolineacondor.model.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name = "Vuelos")
@Data
public class Flights {


	@Id
	@Column(name = "id_vuelo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
		
	@Column(name = "fecha_hora_salida",  length = 10)
	private Date timestampTakeOff;
	
	@Column(name = "ticket_costo")
	private Double costTicket;
	
	@Column(name = "ticket_disponibles")
	private Integer numTicketAviable;
	
	@Column(name = "ticket_total")
	private Integer numTicketTotal;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_ciudad_origen")
	private GeographicLocation cityOrigin;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_ciudad_destino")
	private GeographicLocation cityDestiny;
	
	@JsonIgnore
	@OneToMany(mappedBy = "flight", fetch = FetchType.LAZY)
	private List<Tickets> tickets;
	
}

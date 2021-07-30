package ec.edu.espe.monster.aerolineacondor.model.entity;

import java.util.List;
import java.util.Set;

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

import ec.edu.espe.monster.aerolineacondor.model.constants.TypeGeograficLocation;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Ubicacion_Geo")
@Data
@NoArgsConstructor
public class GeographicLocation {

	@Id
	@Column(name = "id_ubicacion")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
		
	@Column(name = "codigo_ubicacion",  length = 10)
	private String code;
	
	@Column(name = "nombre_ubicacion",  length = 300)
	private String name;
	
	@Column(name = "pais_ubicacion",  length = 300)
	private String country;
	
	@Column(name = "tipo_ubicacion")
	private TypeGeograficLocation type;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "id_territorio_perteneciente", referencedColumnName = "id_ubicacion")
	private GeographicLocation pertainingTerritory;
	
	@OneToMany(mappedBy = "pertainingTerritory", fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<GeographicLocation> partialTerritories;
	
	@JsonIgnore
	@OneToMany(mappedBy = "cityOrigin", fetch = FetchType.LAZY)
	private List<Flights> flightsOrigin;

	@JsonIgnore
	@OneToMany(mappedBy = "cityDestiny", fetch = FetchType.LAZY)
	private List<Flights> flightsDestiny;

	public GeographicLocation(Long id) {
		super();
		this.id = id;
	}
	
	
}

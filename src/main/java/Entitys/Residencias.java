package Entitys;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.mapping.Set;

@Entity
@Table(name = "residencias")
public class Residencias {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codResidencia;

	@Column(columnDefinition = "varchar(30)")
	private String nomResidencia;

	@Column(columnDefinition = "varchar(6)")
	private String codUniversidad;

	@Column(columnDefinition = "integer")
	private Integer precioMensual;

	@Column(columnDefinition = "boolean")
	private boolean comedor;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	// (cascade={CascadeType.PERSIST,CascadeType.REMOVE})
	@PrimaryKeyJoinColumn(name = "codResidencia") // no crea el campo
	private ResidenciaObservacion residenciaObservacionX;
	
	@OneToMany(mappedBy = "Residencias", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	List<Estancias> estancias = new ArrayList<Estancias>(); 
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "codUniversidad")
	
	public ResidenciaObservacion getResidenciaObservacionX() {
		return residenciaObservacionX;
	}

	public void setResidenciaObservacionX(ResidenciaObservacion residenciaObservacionX) {
		this.residenciaObservacionX = residenciaObservacionX;
	}

	public Integer getCodResidencia() {
		return codResidencia;
	}

	public void setCodResidencia(Integer codResidencia) {
		this.codResidencia = codResidencia;
	}

	public String getNomResidencia() {
		return nomResidencia;
	}

	public void setNomResidencia(String nomResidencia) {
		this.nomResidencia = nomResidencia;
	}

	public String getCodUniversidad() {
		return codUniversidad;
	}

	public void setCodUniversidad(String codUniversidad) {
		this.codUniversidad = codUniversidad;
	}

	public Integer getPrecioMensual() {
		return precioMensual;
	}

	public void setPrecioMensual(Integer precioMensual) {
		this.precioMensual = precioMensual;
	}

	public boolean isComedor() {
		return comedor;
	}

	public void setComedor(boolean comedor) {
		this.comedor = comedor;
	}

}

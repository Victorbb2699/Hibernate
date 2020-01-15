package clases;

import java.io.Serializable;
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

import com.sun.javafx.scene.CssFlags;

@Entity
@Table(name = "residencias")
public class Residencias implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codResidencia;

	@Column(columnDefinition = "varchar(30)")
	private String nomResidencia;

//	@Column(columnDefinition = "varchar(6)")
//	private String codUniversidad;

	@Column(columnDefinition = "integer")
	private Integer precioMensual;

	@Column(columnDefinition = "boolean")
	private boolean comedor;

	public Universidades getCodUniversidad() {
		return codUniversidad;
	}

	public void setCodUniversidad(Universidades codUniversidad) {
		this.codUniversidad = codUniversidad;
	}

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@PrimaryKeyJoinColumn(name = "codResidencia")
	private ResidenciaObservacion residenciaObservacionX;

	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name = "codResidencia")
	List<Estancias> estancias = new ArrayList<Estancias>();

	@ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
	@JoinColumn(name = "codUniversidad")
	private Universidades codUniversidad;
	
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

	public ResidenciaObservacion getResidenciaObservacionX() {
		return residenciaObservacionX;
	}

	public void setResidenciaObservacionX(ResidenciaObservacion residenciaObservacionX) {
		this.residenciaObservacionX = residenciaObservacionX;
	}

	public List<Estancias> getEstancias() {
		return estancias;
	}

	public void setEstancias(List<Estancias> estancias) {
		this.estancias = estancias;
	}

	public Universidades getUniversidad() {
		return codUniversidad;
	}

	public void setUniversidad(Universidades universidad) {
		this.codUniversidad = universidad;
	}

	
}
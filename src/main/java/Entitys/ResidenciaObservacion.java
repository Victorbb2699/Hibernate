	package Entitys;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "residenciasobservaciones")
public class ResidenciaObservacion implements Serializable{
	
	@Id
	@GeneratedValue(generator = "myForeign")
	@GenericGenerator(name = "myForeign", strategy = "foreign",
	parameters = {@org.hibernate.annotations.Parameter(name = "property", value = "residenciaXXX")})
	private Integer codResidencia;
	
	@Column(columnDefinition = "varchar(200)")
	private String observaciones;

	@OneToOne(cascade= {CascadeType.PERSIST, CascadeType.REMOVE})
	@PrimaryKeyJoinColumn
	private Residencias residenciaXXX;

	public Integer getCodResidencia() {
		return codResidencia;
	}

	public void setCodResidencia(Integer codResidencia) {
		this.codResidencia = codResidencia;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Residencias getResidenciaXXX() {
		return residenciaXXX;
	}

	public void setResidenciaXXX(Residencias residenciaXXX) {
		this.residenciaXXX = residenciaXXX;
	}
	

	
	
	
}

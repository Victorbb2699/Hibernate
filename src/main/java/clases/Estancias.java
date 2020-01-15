package clases;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "estancias")
public class Estancias implements Serializable {

	@Id
	@Column(columnDefinition = "integer")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codEstancia;

//	@Column(columnDefinition = "integer")
//	private Integer codEstudiante;
//
//	@Column(columnDefinition = "integer")
//	private Integer codResidencia;

	@Column(columnDefinition = "date")
	private LocalDate fechaInicio;

	@Column(columnDefinition = "date")
	private LocalDate fechaFin;

	@Column(columnDefinition = "integer")
	private Integer preciopagado;
	
	@ManyToOne
	@JoinColumn(name="codResidencia")
	private Residencias codResidencia;

	
	@ManyToOne
	@JoinColumn(name="codEstudiante")
	private Estudiantes codEstudiantes;


	public Integer getCodEstancia() {
		return codEstancia;
	}


	public void setCodEstancia(Integer codEstancia) {
		this.codEstancia = codEstancia;
	}


	public LocalDate getFechaInicio() {
		return fechaInicio;
	}


	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}


	public LocalDate getFechaFin() {
		return fechaFin;
	}


	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}


	public Integer getPreciopagado() {
		return preciopagado;
	}


	public void setPreciopagado(Integer preciopagado) {
		this.preciopagado = preciopagado;
	}


	public Residencias getCodResidencia() {
		return codResidencia;
	}


	public void setCodResidencia(Residencias codResidencia) {
		this.codResidencia = codResidencia;
	}


	public Estudiantes getCodEstudiantes() {
		return codEstudiantes;
	}


	public void setCodEstudiantes(Estudiantes codEstudiantes) {
		this.codEstudiantes = codEstudiantes;
	}
	
	

}

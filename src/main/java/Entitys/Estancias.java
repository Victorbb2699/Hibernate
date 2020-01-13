package Entitys;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "estancias")
public class Estancias implements Serializable {

	@Id
	@Column(columnDefinition = "integer")
	private Integer codEstancia;

	@Column(columnDefinition = "integer")
	private Integer codEstudiante;

	@Column(columnDefinition = "integer")
	private Integer codResidencia;

	@Column(columnDefinition = "date")
	private LocalDate fechaInicio;

	@Column(columnDefinition = "date")
	private LocalDate fechaFin;

	@Column(columnDefinition = "integer")
	private Integer preciopagado;
	
	@ManyToOne
	@JoinColumn(name="codResidencia")
	private Residencias residencia;

	
	@ManyToOne
	@JoinColumn(name="codEstudiante")
	private Estudiantes estudiantes;
	
	public Integer getCodEstancia() {
		return codEstancia;
	}

	public void setCodEstancia(Integer codEstancia) {
		this.codEstancia = codEstancia;
	}

	public Integer getCodEstudiante() {
		return codEstudiante;
	}

	public void setCodEstudiante(Integer codEstudiante) {
		this.codEstudiante = codEstudiante;
	}

	public Integer getCodResidencia() {
		return codResidencia;
	}

	public void setCodResidencia(Integer codResidencia) {
		this.codResidencia = codResidencia;
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

}

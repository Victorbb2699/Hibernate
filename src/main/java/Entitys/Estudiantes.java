package Entitys;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "estudiantes")
public class Estudiantes implements Serializable {

	@Id
	@Column(columnDefinition = "integer")
	private Integer codEstudiante;

	@Column(columnDefinition = "varchar(9)")
	private String dni;

	@Column(columnDefinition = "varchar(50)")
	private String nomEstudiante;

	@Column(columnDefinition = "varchar(9)")
	private String telefonoEstudiante;

	@OneToMany (cascade=CascadeType.ALL, fetch=FetchType.EAGER )
	@JoinColumn(name="codEstudiante")
	List<Estancias> estancias = new ArrayList<Estancias>(); 
	
	
	public Integer getCodEstudiante() {
		return codEstudiante;
	}

	public void setCodEstudiante(Integer codEstudiante) {
		this.codEstudiante = codEstudiante;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNomEstudiante() {
		return nomEstudiante;
	}

	public void setNomEstudiante(String nomEstudiante) {
		this.nomEstudiante = nomEstudiante;
	}

	public String getTelefonoEstudiante() {
		return telefonoEstudiante;
	}

	public void setTelefonoEstudiante(String telefonoEstudiante) {
		this.telefonoEstudiante = telefonoEstudiante;
	}

	

}
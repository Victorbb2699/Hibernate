package clases;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "universidades")
public class Universidades implements Serializable {

	
	@Id
	@Column(columnDefinition = "varchar(6)")
	private String codUniversidad;

	@Column(columnDefinition = "varchar(30)")
	private String nomUniversidad;

	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.EAGER)
	@JoinColumn(name = "codUniversidad")
	List<Residencias> residencias = new ArrayList<Residencias>();

	public List<Residencias> getResidencias() {
		return residencias;
	}

	public void setResidencias(List<Residencias> residencias) {
		this.residencias = residencias;
	}

	public String getCodUniversidad() {
		return codUniversidad;
	}

	public void setCodUniversidad(String codUniversidad) {
		this.codUniversidad = codUniversidad;
	}

	public String getNomUniversidad() {
		return nomUniversidad;
	}

	public void setNomUniversidad(String nomUniversidad) {
		this.nomUniversidad = nomUniversidad;
	}

}

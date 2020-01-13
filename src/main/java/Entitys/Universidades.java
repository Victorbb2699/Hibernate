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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "universidades")
public class Universidades implements Serializable {

	@Id
	@Column(columnDefinition = "varchar(6)")
	private String codUniversidad;

	@Column(columnDefinition = "varchar(30)")
	private String nomUniversidad;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "universidades", cascade = {CascadeType.ALL})
	List<Residencias> residencias = new ArrayList<Residencias>();
	
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

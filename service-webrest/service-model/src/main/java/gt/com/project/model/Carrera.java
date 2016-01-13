package gt.com.project.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the carrera database table.
 * 
 */
@Entity
@NamedQuery(name="Carrera.findAll", query="SELECT c FROM Carrera c")
public class Carrera implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="COD_CARRERA")
	private int codCarrera;

	@Column(name="NOMBRE_CARRERA")
	private String nombreCarrera;

	//bi-directional many-to-one association to Facultad
	@ManyToOne
	@JoinColumn(name="FACULTAD")
	private Facultad facultadBean;

	public Carrera() {
	}

	public int getCodCarrera() {
		return this.codCarrera;
	}

	public void setCodCarrera(int codCarrera) {
		this.codCarrera = codCarrera;
	}

	public String getNombreCarrera() {
		return this.nombreCarrera;
	}

	public void setNombreCarrera(String nombreCarrera) {
		this.nombreCarrera = nombreCarrera;
	}

	public Facultad getFacultadBean() {
		return this.facultadBean;
	}

	public void setFacultadBean(Facultad facultadBean) {
		this.facultadBean = facultadBean;
	}

}
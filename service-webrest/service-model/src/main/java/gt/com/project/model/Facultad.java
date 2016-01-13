package gt.com.project.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the facultad database table.
 * 
 */
@Entity
@NamedQuery(name="Facultad.findAll", query="SELECT f FROM Facultad f")
public class Facultad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="COD_FACULTAD")
	private int codFacultad;

	@Column(name="NOMBRE_FACULTAD")
	private String nombreFacultad;

	//bi-directional many-to-one association to Carrera
	@OneToMany(mappedBy="facultadBean")
	private List<Carrera> carreras;

	public Facultad() {
	}

	public int getCodFacultad() {
		return this.codFacultad;
	}

	public void setCodFacultad(int codFacultad) {
		this.codFacultad = codFacultad;
	}

	public String getNombreFacultad() {
		return this.nombreFacultad;
	}

	public void setNombreFacultad(String nombreFacultad) {
		this.nombreFacultad = nombreFacultad;
	}

	public List<Carrera> getCarreras() {
		return this.carreras;
	}

	public void setCarreras(List<Carrera> carreras) {
		this.carreras = carreras;
	}

	public Carrera addCarrera(Carrera carrera) {
		getCarreras().add(carrera);
		carrera.setFacultadBean(this);

		return carrera;
	}

	public Carrera removeCarrera(Carrera carrera) {
		getCarreras().remove(carrera);
		carrera.setFacultadBean(null);

		return carrera;
	}

}
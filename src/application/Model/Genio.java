package application.Model;

public class Genio {
	
	private Integer idGenio;
	private String nombre;
	private Integer nacimiento;
	private String profesion;
	
	
	
	public String getProfesion() {
		return profesion;
	}

	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}

	public Genio() {

	}
	
	public Genio(Integer idGenio, String nombre, Integer nacimiento,String profesion) {
		super();
		this.idGenio = idGenio;
		this.nombre = nombre;
		this.nacimiento = nacimiento;
		this.profesion = profesion;
	}

	public Integer getIdGenio() {
		return idGenio;
	}

	public void setIdGenio(Integer idGenio) {
		this.idGenio = idGenio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(Integer nacimiento) {
		this.nacimiento = nacimiento;
	}

}

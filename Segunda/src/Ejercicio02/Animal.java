package Ejercicio02;

public class Animal {

	protected String fechaNacimiento;
	protected int id;
	protected String nombre;
	protected boolean vacunado;

	public Animal(int id, String nombre, String fechaNacimiento, boolean vacunado) {

		this.id = id;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.vacunado = vacunado;
	}

	public int getId() {

		return id;
	}

	public void setId(int id) {

		this.id = id;
	}

	public String getFechaNacimiento() {

		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {

		this.fechaNacimiento = fechaNacimiento;
	}

	public boolean isVacunado() {

		return vacunado;
	}

	public void setVacunado(boolean vacunado) {

		this.vacunado = vacunado;
	}

	public String getNombre() {

		return nombre;
	}

	public void setNombre(String nombre) {

		this.nombre = nombre;
	}

}

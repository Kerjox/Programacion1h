package Ejercicio02;

public class Perro extends Animal {

	private String raza;

	public Perro(int id, String nombre, String fechaNacimiento, boolean vacunado, String raza) {

		super(id, nombre, fechaNacimiento, vacunado);
		this.raza = raza;
	}

	public String getRaza() {

		return raza;
	}

	public void setRaza(String raza) {

		this.raza = raza;
	}

	public void habla() {

		System.out.println("Guau, soy un perro");

	}

}

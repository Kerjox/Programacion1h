package Ejercicio02;

public class Perro extends Animal {

	private boolean peligroso;
	private String raza;

	public Perro(int id, String nombre, String fechaNacimiento, boolean vacunado, String raza, boolean peligroso) {

		super(id, nombre, fechaNacimiento, vacunado);
		this.raza = raza;
		this.peligroso = peligroso;
	}

	public boolean isPeligroso() {

		return peligroso;
	}

	public void setPeligroso(boolean peligroso) {

		this.peligroso = peligroso;
	}

	public String getRaza() {

		return raza;
	}

	public void setRaza(String raza) {

		this.raza = raza;
	}

	public void habla() {

		System.out.printf("Guau, soy un perro, me llamo %s, nací el %s, %s estoy vacunado, soy de la raza %s, %s soy peligroso \n",
				this.nombre,
				this.fechaNacimiento,
				(this.vacunado)?"si":"no",
				this.raza,
				(this.peligroso)?"si":"no");

	}

}

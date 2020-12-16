package Ejercicio02;

public class Canguro extends Animal {

	private int salto;
	private int velocidad;

	public Canguro(int id, String nombre, String fechaNacimiento, boolean vacunado, int salto, int velocidad) {

		super(id, nombre, fechaNacimiento, vacunado);
		this.salto = salto;
		this.velocidad = velocidad;
	}

	public int getVelocidad() {

		return velocidad;
	}

	public void setVelocidad(int velocidad) {

		this.velocidad = velocidad;
	}

	public int getSalto() {

		return salto;
	}

	public void setSalto(int salto) {

		this.salto = salto;
	}

	public void habla() {

		System.out.printf("Soy un canguro, me llamo %s, naci el %s, %s estoy vacunado \n", this.nombre, this.fechaNacimiento, (this.vacunado)?"si":"no");

	}

}

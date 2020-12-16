package Ejercicio01;

public class Chalet extends Casa {

	private int metros_Jardin;
	private boolean piscina;

	public Chalet(String nombre, String direccion, int num_Habitaciones, int num_Metros, int banos, int metros_Jardin, boolean piscina) {

		super(nombre, direccion, num_Habitaciones, num_Metros, banos);
		this.metros_Jardin = metros_Jardin;
		this.piscina = piscina;
	}

	public Chalet(String nombre, int metros_Jardin, boolean piscina) {

		super(nombre);
		this.metros_Jardin = metros_Jardin;
		this.piscina = piscina;
	}

	public int getMetros_Jardin() {

		return metros_Jardin;
	}

	public void setMetros_Jardin(int metros_Jardin) {

		this.metros_Jardin = metros_Jardin;
	}

	public boolean isPiscina() {

		return piscina;
	}

	public void setPiscina(boolean piscina) {

		this.piscina = piscina;
	}

	public void printInfo() {

		System.out.println("--------------------------");
		System.out.println(this.nombre);
		System.out.println("--------------------------");
		System.out.printf("La dirección es: %s \n", this.direccion);
		System.out.printf("Tiene %d habitaciones \n", this.num_Habitaciones);
		System.out.printf("Tiene %d metros de planta \n", this.num_Metros);
		System.out.printf("Tiene %d baños \n", this.num_Banyos);
		System.out.printf("Tiene %d metros de jardín \n", this.metros_Jardin);
		System.out.printf("%s tiene piscina \n", (this.piscina)?"Si":"No");
		System.out.println("--------------------------");
	}

}

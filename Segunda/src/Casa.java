public class Casa {

	protected String direccion;
	protected String nombre;
	protected int num_Habitaciones;
	protected int num_Metros;
	protected int num_Banyos;

	public Casa(String nombre, String direccion, int num_Habitaciones, int num_Metros, int banos) {

		this.direccion = direccion;
		this.nombre = nombre;
		this.num_Habitaciones = num_Habitaciones;
		this.num_Metros = num_Metros;
		this.num_Banyos = banos;
	}

	public Casa(String nombre) {

		this.direccion = "null";
		this.nombre = nombre;
		this.num_Habitaciones = 0;
		this.num_Metros = 0;
		this.num_Banyos = 0;
	}

	public int getNum_Banyos() {

		return num_Banyos;
	}

	public void setNum_Banyos(int num_Banyos) {

		this.num_Banyos = num_Banyos;
	}

	public String getDireccion() {

		return direccion;
	}

	public void setDireccion(String direccion) {

		this.direccion = direccion;
	}

	public String getNombre() {

		return nombre;
	}

	public void setNombre(String nombre) {

		this.nombre = nombre;
	}

	public int getNum_Habitaciones() {

		return num_Habitaciones;
	}

	public void setNum_Habitaciones(int num_Habitaciones) {

		this.num_Habitaciones = num_Habitaciones;
	}

	public int getNum_Metros() {

		return num_Metros;
	}

	public void setNum_Metros(int num_Metros) {

		this.num_Metros = num_Metros;
	}

	public void printInfo() {

		System.out.println("--------------------------");
		System.out.println(nombre);
		System.out.println("--------------------------");
		System.out.printf("La dirección es: %s \n", direccion);
		System.out.printf("Tiene %d habitaciones \n", num_Habitaciones);
		System.out.printf("Tiene %d metros de planta \n", num_Metros);
		System.out.printf("Tiene %d baños \n", num_Banyos);
		System.out.println("--------------------------");
	}

}

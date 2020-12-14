public class Casa {

	private String direccion;
	private String nombre;
	private int num_Habitaciones;
	private int num_Metros;


	public Casa(String nombre, String direccion, int num_Habitaciones, int num_Metros) {

		this.direccion = direccion;
		this.nombre = nombre;
		this.num_Habitaciones = num_Habitaciones;
		this.num_Metros = num_Metros;
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

	public void printInfo(){

		System.out.println("--------------------------");
		System.out.println(nombre);
		System.out.println("--------------------------");
		System.out.printf("La dirección es: %s \n", direccion);
		System.out.printf("Número de habitaciones: %s \n", num_Habitaciones);
		System.out.printf("Tiene %d metros \n", num_Metros);
		System.out.println("--------------------------");
	}

}

public class Segunda {

	public static void main(String[] args) {

		Casa Casa1 = new Casa("Casa1", "Calle de los Árboles", 4, 100);
		Casa Casa2 = new Casa("Casa2", "Calle del Tornado", 8, 500);

		Casa1.printInfo();
		Casa2.printInfo();

		Casa1.setNum_Habitaciones(10);

		Casa1.printInfo();

	}

}
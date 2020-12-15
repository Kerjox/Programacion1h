public class Segunda {

	public static void main(String[] args) {

		Casa casa1 = new Casa("Casa1", "Calle de los Árboles", 4, 100, 1);
		Casa casa2 = new Casa("Casa2", "Calle del Tornado", 8, 500, 3);
		Casa casa3 = new Casa("Casa3");
		Chalet chalet1 = new Chalet("Chalet1", "Calle Chaletera 1", 14, 300, 5, 10, true);
		Chalet agustinChalet = new Chalet("Agustin Chalet", 20, false);

		casa1.printInfo();
		casa2.printInfo();

		casa1.setNum_Habitaciones(10);

		casa1.printInfo();

		casa3.printInfo();

		casa3.setDireccion("a");
		casa3.setNombre("HHHH");
		casa3.setNum_Habitaciones(1);
		casa3.setNum_Metros(1);

		casa3.printInfo();

		chalet1.printInfo();

		agustinChalet.setNum_Metros(50);
		agustinChalet.setNum_Habitaciones(3);
		agustinChalet.setNum_Banyos(2);

		agustinChalet.printInfo();

	}

}
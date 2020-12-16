package Ejercicio02;

public class SobreAnimales {

	public static void main(String[] args) {

		Perro animal1 = new Perro(1, "Federico", "05-04-15", true, "Caniche", false);
		Canguro animal2 = new Canguro(2, "Alfredo","02-1-12", true, 2, 12);

		animal1.habla();
		animal2.habla();
	}

}

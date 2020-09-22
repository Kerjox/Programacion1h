/*
    Sacar el mayor de 3 números y mostrarlo por pantalla
 */
public class Ejercicio04 {
    public static void main(String[] args) {
        int x,y,z;
        x = 23;
        y = 44;
        z = 96;
        if (x > y && x > z){
            System.out.println("x que es " + x + " es el mayor");
        }else if (y > x && y > z){
            System.out.println("y que es " + y + " es el mayor");
        }else {
            System.out.println("z que es " + z + " es el mayor");
        }
    }
}
/*
public static void main(String[] args) {
        int x,y,z;
        x = 23;
        y = 44;
        z = 96;
        if (x > y){
            if (x > z) {
                System.out.println("x que es " + x + " es el mayor");
            } else {
                System.out.println("z que es " + z + " es el mayor");
            }
        } else {
            if (y > z){
                System.out.println("y que es " + y + " es el mayor");
            } else {
                System.out.println("z que es " + z + " es el mayor");
            }
        }
    }
 */

/*

 */
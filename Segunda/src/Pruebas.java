import java.security.SecureRandom;
import java.util.Arrays;

public class Pruebas {
	public static void main(String[] args) {
		SecureRandom rng = new SecureRandom();
		byte[] randomBytes = new byte[64];
		rng.nextBytes(randomBytes); // Fills randomBytes with random bytes (duh)
		System.out.println(Arrays.toString(randomBytes));
	}
}

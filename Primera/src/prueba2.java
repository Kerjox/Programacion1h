public class prueba2 {

	public static void main(String[] args) {
		String phrase1 = "En un lugar de la mancha de ";
		String phrase2 = "de cuyo nombre no quiero acordarme ";
		String phrase3 = copyIntercalatedPhrases(phrase1, phrase2);

		System.out.println(phrase3);
	}

	private static String copyIntercalatedPhrases (String phrase1, String phrase2) {
		String phrase3 = "";
		int phrase1Searching = phrase1.indexOf(" "), phrase1OldSearching = 0;
		int phrase2Searching = phrase1.indexOf(" "), phrase2OldSearching = 0;

		while(phrase1Searching != -1 || phrase2Searching != -1) {
			if (phrase1Searching != -1) {
				phrase3 = phrase3.concat(phrase1.substring(phrase1OldSearching, ++phrase1Searching));
				phrase1OldSearching = phrase1Searching;
				phrase1Searching = phrase1.indexOf(" ", phrase1OldSearching);
			}
			if (phrase2Searching != -1) {
				phrase3 = phrase3.concat(phrase2.substring(phrase2OldSearching, ++phrase2Searching));
				phrase2OldSearching = phrase2Searching;
				phrase2Searching = phrase2.indexOf(" ", phrase2OldSearching);
			}
		}

		return phrase3;
	}

}

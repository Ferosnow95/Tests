import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class APP {

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] s = reader.readLine().split(" ");
		int noOfLines = Integer.parseInt(s[0]);

		ArrayList arrayInput = new ArrayList();
		for (int i = 0; i < noOfLines; i++) {
			String[] sInput = reader.readLine().split("");

			for (int j = 0; j < sInput.length; j++) {
				if (sInput[j].equals(" ") || sInput[j].equals(",") || sInput[j].equals(".")) {
					continue;

				} else {
					arrayInput.add(sInput[j]);
				}
			}
			arrayInput.add("%");
		}

		String[] snGram = reader.readLine().split("");
		int nGram = Integer.parseInt(snGram[0]);
		String gram = null;
		// get Array Number 1
		ArrayList lineInput = new ArrayList();

		for (int m = 0; m < arrayInput.size(); m++) {
			if (arrayInput.get(m) != "%") {
				lineInput.add(arrayInput.get(m));
			} else {

				if (lineInput.get(0).equals(lineInput.get(nGram))) {

				}

				if (gram != null) {
					if (nGram == 1) {
						System.out.println("Unigram " + gram);
					} else if (nGram == 2) {
						System.out.println("Bigram " + gram);
					} else if (nGram == 3) {
						System.out.println("Trigram " + gram);
					}
				}
				lineInput.clear();
			}
		}
		System.out.println(gram);
	}

}

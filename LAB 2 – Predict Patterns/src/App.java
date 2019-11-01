import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class App {

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] s = reader.readLine().split(" ");
		int noOfLines = Integer.parseInt(s[0]);

		ArrayList arrayList = new ArrayList();
		for (int i = 0; i < noOfLines; i++) {
			String[] sInput = reader.readLine().split("");

			for (int j = 0; j < sInput.length; j++) {
				arrayList.add(sInput[j]);

			}
			arrayList.add(" ");
		}

		String[] snGram = reader.readLine().split("");
		int nGram = Integer.parseInt(snGram[0]);
		String gram = null;

		// get Array Number 1
		String temp = "";
		ArrayList filteredList = new ArrayList();
		for (int i = 0; i < arrayList.size(); i++) {
			temp = "";
			for (int j = i; j < i + nGram; j++) {
				// System.out.println(arrayList.get(j));
				if (arrayList.get(j).equals(" ") || arrayList.get(j).equals(",") || arrayList.get(j).equals(".")) {
					temp = "";
					break;
				} else {
					temp = temp + arrayList.get(j);
				}
			}
			if (temp != "") {
				// System.out.println(temp);
				filteredList.add(temp);
			}
		}
//		for (int i = 0; i < filteredList.size(); i++) {
//			System.out.print(filteredList.get(i) + " ");
//		}
		filteredList.sort(null);
		int maxNo = -1;
		gram = (String) filteredList.get(0);
		int count = 0;
		for (int i = 0; i < filteredList.size(); i++) {
			count = 0;
			for (int j = i + 1; j < filteredList.size(); j++) {

				if (filteredList.get(i).equals(filteredList.get(j))) {
					count++;
				}
			}
			// System.out.println(count);

			if (count > maxNo) {
				maxNo = count;
				gram = (String) filteredList.get(i);
			}
		}

		if (nGram == 1) {
			System.out.println("Unigram " + gram);
		} else if (nGram == 2) {
			System.out.println("Bigram " + gram);
		} else if (nGram == 3) {
			System.out.println("Trigram " + gram);
		}

		// System.out.println(gram);
	}

}

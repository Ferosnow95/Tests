import java.util.ArrayList;
import java.util.Scanner;

public class MinString {
	static String[] input;
	static String[] temp;

	public static void main(String[] args) {

		ArrayList<Integer> index = new ArrayList<Integer>();
		int shortestWindow = 72;
		String shortestLetters = null;
		Scanner scanner = new Scanner(System.in);
		String inputLine = scanner.nextLine();
		input = inputLine.split("");
		String[] str = scanner.nextLine().split("");
		int counter = 0;

		// loop thru input array
		for (int i = 0; i < input.length; i++) {
			// if any letter in str was found increase counter
			// till traverse the whole str array
			temp = str.clone();

			for (int j = i; j < input.length; j++) {
				if (FoundInStr(j)) {
					index.add(j);
				}
			}

			if (index.size() == str.length) {
				if ((index.get(index.size() - 1) - index.get(0)) < shortestWindow) {
					shortestWindow = index.get(index.size() - 1) - index.get(0);
					shortestLetters = inputLine.substring(index.get(0), index.get(index.size() - 1) + 1);
				}
			}

			index.clear();
		}

		System.out.print(shortestLetters);

	} // End of main

	private static boolean FoundInStr(int index) {
		for (int i = 0; i < temp.length; i++) {
			if (temp[i].equals(input[index])) {
				temp[i] = "NA";
				return true;
			}
		}
		return false;
	}
}

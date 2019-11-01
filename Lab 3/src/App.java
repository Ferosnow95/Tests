import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

class Node {

	String Key;
	Node left, right;

	Node(String k) {
		this.Key = k;
		left = right = null;
	}
}

public class App {

	public static void main(String[] args) throws IOException {
		Node root = null;
		Stack<Node> parent = new Stack<Node>();

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = reader.readLine();

		// line = line.replace(" ", "");
		line = line.replace("(", " ( ");
		line = line.replace(")", " )");

		String[] sInput = line.trim().split(" ");

//		for (int i = 0; i < sInput.length; i++) {
//			System.out.println(sInput[i]);
//		}
		int countOpen = 0;
		int countClose = 0;
		boolean flag = false;

		ArrayList arrayList = new ArrayList();

		for (int k = 0; k < sInput.length; k++) {

			countOpen = 0;
			countClose = 0;
			flag = false;

			if (!sInput[k].equals("(") && (!sInput[k].equals(")"))) {
				countOpen++;
				for (int i = k; i < sInput.length; i++) {

					if (sInput[i].equals("(")) {
						countOpen++;
					} else if (sInput[i].equals(")")) {
						countClose++;
					}

					if (countOpen == countClose) {

						countClose = 0;
						countOpen = 0;

						if (flag == false) {
							// System.out.print(sInput[k]);
							if (!sInput[k].contains(")") && !sInput[k].contains("(")) {
								arrayList.add(sInput[k]);
								flag = true;
							}
						}

						if ((i < sInput.length - 2)) {

							if (!sInput[i - 1].contains(")") && !sInput[i - 1].contains("(")
									&& !sInput[i + 2].contains(")") && !sInput[i + 2].contains("("))

								arrayList.add(sInput[i - 1]);
							arrayList.add(sInput[i + 2]);
						}
					}
				}
			}
		}

		String node = reader.readLine();
		String s_distance = reader.readLine();
		int distance = Integer.parseInt(s_distance);

		for (int k = 0; k < sInput.length; k++) {

			countOpen = 0;
			countClose = 0;

			if (sInput[k].equals(node)) {
				break;
			}

			if (!sInput[k].equals("(") && (!sInput[k].equals(")"))) {

				for (int i = k; i < sInput.length; i++) {

					if (sInput[i].equals(node)) {
						break;
					}

					if (sInput[i].equals("(")) {
						countOpen++;
					} else if (sInput[i].equals(")")) {
						countClose++;
					}

				}

				if ((countOpen - countClose == distance) || ((countOpen == countClose) && (countOpen == 1))) {
					System.out.println(sInput[k]);
				}
			}
		}

		for (int k = 0; k < sInput.length; k++) {

			countOpen = 0;
			countClose = 0;

			if (!sInput[k].equals(node)) {
				continue;
			}

			if (!sInput[k].equals("(") && (!sInput[k].equals(")")) && (!sInput[k].equals(" "))) {

				for (int i = k; i < sInput.length; i++) {

					if (sInput[i].equals("(")) {
						countOpen++;
					} else if (sInput[i].equals(")")) {
						countClose++;
					}

					if (countOpen - countClose == distance) {
						System.out.println(sInput[i] + " " + countOpen + " " + countClose);

					}

				}

			}
		}

		System.out.println();

		ArrayList newList = new ArrayList();
		for (int m = 0; m < arrayList.size(); m++) {
			if (!newList.contains(arrayList.get(m)) && !arrayList.get(m).equals(")") && !arrayList.get(m).equals("("))
				newList.add(arrayList.get(m));
		}

		for (int i = 0; i < newList.size(); i++)
			System.out.print(newList.get(i) + " ");

	}
}

//int temp = 0;
//int count = 0;
//for (int i = 0; i < treeArray.length; i++) {
//
//	temp = i - 1 % 2;
//
//	while (temp == 0) {
//		temp = temp - 1 % 2;
//		count++;
//	}
//	// check children
//	int index = 2 * i + 1;
//	while (treeArray[index] != null) {
//		if (treeArray[index].equals(node) && count == distance)
//			System.out.println(treeArray[index]);
//		else {
//			count++;
//			index = 2 * index + 1;
//		}
//	}
//	count = 0;
//
//	temp = i - 1 % 2;
//
//	while (temp == 0) {
//		temp = temp - 1 % 2;
//		count++;
//	}
//	index = 2 * i + 1;
//
//	while (treeArray[index] != null) {
//		if (treeArray[index].equals(node) && count == distance - 1) {
//			System.out.println(treeArray[i]);
//			break;
//		} else {
//			count++;
//			index = 2 * index + 2;
//		}
//	}
//
//}

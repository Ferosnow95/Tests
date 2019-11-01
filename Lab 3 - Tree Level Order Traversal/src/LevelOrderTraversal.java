import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class LevelOrderTraversal {

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = reader.readLine();
		line = line.trim();
		line = line.replace("(", " ( ");
		line = line.replace(")", " ) ");
		line = line.replaceAll(" +", " ");

		String[] sInput = line.trim().split(" ");

		ArrayList treeArray = new ArrayList();
		Stack parent = new Stack();

		for (int i = 0; i < sInput.length; i++) {

			if (sInput[i].equals("(") && !sInput[i + 1].equals(")")) {

				if (treeArray.isEmpty())
					treeArray.add(sInput[i + 1]);
				else {
					for (int j = 0; j < treeArray.size(); j++) {
						if (treeArray.get(j).equals(parent.peek())) {

							if ((2 * j + 1) >= treeArray.size())
								treeArray.add(2 * j + 1, sInput[i + 1]);
							else {

								if (!treeArray.get(2 * j + 1).equals(null))
									treeArray.add(2 * j + 1, sInput[i]);
								else
									treeArray.add(2 * j + 2, sInput[i]);
							}
						}
					}

				}
				parent.add(sInput[i + 1]);
			} else if (sInput[i].equals(")")) {
				parent.pop();
			}

		}

		for (int i = 0; i < treeArray.size(); i++)
			System.out.println(treeArray.get(i));

	} // End of main

}// End of class

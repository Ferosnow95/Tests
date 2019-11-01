import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class App {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = reader.readLine();
		line = line.trim();
		line = line.replace("(", " ( ");
		line = line.replace(")", " ) ");
		line = line.replaceAll(" +", " ");

		String[] sInput = line.trim().split(" ");

		String[] treeArray = new String[300];
		Stack parent = new Stack();

		String node = reader.readLine();
		String s_distance = reader.readLine();
		int distance = Integer.parseInt(s_distance);
		for (int i = 0; i < sInput.length; i++) {

			if (sInput[i].equals("(") && !sInput[i + 1].equals(")")) {

			}

		}
	}

}

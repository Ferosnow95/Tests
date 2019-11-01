import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

class Node {
	boolean visited;
	List<Node> neighbours;

	String key;
	Node left, right;

	public Node(String key) {
		this.key = key;
		left = right = null;
		this.neighbours = new ArrayList<>();

	}

	public void addneighbours(Node neighbourNode) {
		this.neighbours.add(neighbourNode);
	}

	public List<Node> getNeighbours() {
		return neighbours;
	}

	public void setNeighbours(List<Node> neighbours) {
		this.neighbours = neighbours;
	}

}

public class App {
	static Node root = null;
	private static Queue<Node> queue;
	static ArrayList<Node> nodes = new ArrayList<Node>();

	public static <E> void main(String[] args) throws IOException {

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
		Node target = new Node(node);

		for (int i = 0; i < sInput.length; i++) {

			if (sInput[i].equals("(") && !sInput[i + 1].equals(")")) {

				if (treeArray[0] == null)
					treeArray[0] = sInput[i + 1];
				else {
					for (int j = 0; j < treeArray.length; j++) {
						if (parent.peek().equals(treeArray[j])) {

							if (treeArray[2 * j + 1] == null) {
								treeArray[2 * j + 1] = sInput[i + 1];
								break;
							} else {
								treeArray[2 * j + 2] = sInput[i + 1];
								break;
							}
						}
					}
				}
				parent.add(sInput[i + 1]);
			} else if (sInput[i].equals(")") && !sInput[i - 1].equals("(")) {
				if (!parent.isEmpty())
					parent.pop();
			}
		}

		for (int i = 0; i < treeArray.length; i++)
			if (treeArray[i] != null) {
				// System.out.print(treeArray[i] + " ");
				root = insert(root, treeArray[i]);
			}

		printLevelOrder();
		printkdistanceNode(root, target, distance);

	} // End of main

	static void printLevelOrder() {
		int h = height(root);
		int i;
		for (i = 1; i <= h; i++)
			printGivenLevel(root, i);
	}

	static int height(Node root) {
		if (root == null)
			return 0;
		else {
			/* compute height of each subtree */
			int lheight = height(root.left);
			int rheight = height(root.right);

			/* use the larger one */
			if (lheight > rheight)
				return (lheight + 1);
			else
				return (rheight + 1);
		}
	}

	static void printGivenLevel(Node root, int level) {
		if (root == null)
			return;
		if (level == 1)
			System.out.print(root.key + " ");
		else if (level > 1) {
			printGivenLevel(root.left, level - 1);
			printGivenLevel(root.right, level - 1);
		}
	}

	public static void bfs(Node root) {
		if (root == null)
			return;

		System.out.print(root.key + " ");
		bfs(root.left);
		bfs(root.right);

	}

	static Node insert(Node root, String key) {
		/* If the tree is empty, return a new node */
		if (root == null) {
			root = new Node(key);
			return root;
		}
		/* Otherwise, recur down the tree */
		if (key.compareTo(root.key) < 0) {
			root.left = insert(root.left, key);
		} else if (key.compareTo(root.key) > 0) {
			root.right = insert(root.right, key);
		}
		/* return the (unchanged) node pointer */
		return root;

	}

	static int printkdistanceNode(Node node, Node target, int k) {
		// Base Case 1: If tree is empty, return -1
		if (node == null)
			return -1;

		// If target is same as root. Use the downward function
		// to print all nodes at distance k in subtree rooted with
		// target or root
		if (node.key.equals(target.key)) {
			printkdistanceNodeDown(node, k);
			return 0;
		}

		// Recur for left subtree
		int dl = printkdistanceNode(node.left, target, k);

		// Check if target node was found in left subtree
		if (dl != -1) {

			// If root is at distance k from target, print root
			// Note that dl is Distance of root's left child from
			// target
			if (dl + 1 == k) {
				System.out.print(node.key);
				System.out.print(" ");
			}

			// Else go to right subtree and print all k-dl-2 distant nodes
			// Note that the right child is 2 edges away from left child
			else
				printkdistanceNodeDown(node.right, k - dl - 2);

			// Add 1 to the distance and return value for parent calls
			return 1 + dl;
		}

		// MIRROR OF ABOVE CODE FOR RIGHT SUBTREE
		// Note that we reach here only when node was not found in left
		// subtree
		int dr = printkdistanceNode(node.right, target, k);
		if (dr != -1) {
			if (dr + 1 == k) {
				System.out.print(node.key);
				System.out.print(" ");
			} else
				printkdistanceNodeDown(node.left, k - dr - 2);
			return 1 + dr;
		}

		// If target was neither present in left nor in right subtree
		return -1;
	}

	static void printkdistanceNodeDown(Node node, int k) {
		// Base Case
		if (node == null || k < 0)
			return;

		// If we reach a k distant node, print it
		if (k == 0) {
			System.out.print(node.key);
			System.out.print(" ");
			return;
		}

		// Recur for left and right subtrees
		printkdistanceNodeDown(node.left, k - 1);
		printkdistanceNodeDown(node.right, k - 1);
	}

}// End of class

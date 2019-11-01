import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Node {

	int data;
	Node left, right;

	public Node(int data) {
		this.data = data;
		left = right = null;
	}
}

public class AVL {

	static Node root = null;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] sInput = br.readLine().split(" ");
		int[] input = new int[sInput.length];

		for (int i = 0; i < sInput.length; i++) {
			input[i] = Integer.parseInt(sInput[i]);
			if (input[i] != -1 & i != sInput.length - 1)
				root = Insert(root, input[i]);
		}

		if (isAVL(root))
			PreOrderTraversal(root);
		else
			System.out.print("Not");
	}

	public static void PreOrderTraversal(Node root) {
		if (root == null)
			return;

		System.out.print(root.data + " ");
		PreOrderTraversal(root.left);
		PreOrderTraversal(root.right);

	}

	private static Node Insert(Node root, int data) {

		if (root == null) {
			root = new Node(data);
			return root;
		} else if (root.data > data)
			root.left = Insert(root.left, data);
		else if (root.data < data)
			root.right = Insert(root.right, data);

		return root;
	}

	public static boolean isAVL(Node root) {
		if (root == null)
			return true;
		int heightdifference = getHeight(root.left) - getHeight(root.right);
		if (Math.abs(heightdifference) > 1) {
			return false;
		} else {
			return isAVL(root.left) && isAVL(root.right);
		}
	}

	public static int getHeight(Node root) {

		if (root == null)
			return 0;
		return (1 + Math.max(getHeight(root.left), getHeight(root.right)));
	}
}

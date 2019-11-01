import java.util.ArrayList;
import java.util.Scanner;

public class App {
	static Node root = null;

	static class Node<E> {
		E data;
		Node left, right;

		public Node(E data) {
			this.data = data;
			left = right = null;
		}
	}

	static boolean flagSibling = false;
	static boolean flagChild = false;
	static boolean flagAncestor = false;
	static boolean flagDescendant = false;
	static boolean flagInsert = false;
	static boolean flagParent = false;

	static ArrayList traversal = new ArrayList();
	static ArrayList nodes = new ArrayList();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String line = sc.nextLine();
		int numberOfLine = Integer.parseInt(line);

		String[] familyLine;
		for (int i = 0; i < numberOfLine; i++) {
			familyLine = sc.nextLine().split(" ");
			if (root == null)
				root = new Node(familyLine[0]);

//			for (int k = 0; k < nodes.size(); k = k + 2) {
//				root = Insert(root, nodes.get(k), nodes.get(k + 1));
//
//				if (flagInsert) {
//					nodes.remove(k);
//					nodes.remove(k);
//					flagInsert = false;
//
//				}

			// }

			root = Insert(root, familyLine[0], familyLine[1]);

//			if (!flagInsert) {
//				nodes.add(familyLine[0]);
//				nodes.add(familyLine[1]);
//
//			}
//			flagInsert = false;

		}

		line = sc.nextLine();
		numberOfLine = Integer.parseInt(line);

		for (int i = 0; i < numberOfLine; i++) {
			familyLine = sc.nextLine().split(" ");

			if (familyLine[1].equals("child")) {
				Child(root, familyLine[0], familyLine[2]);
				if (flagChild) {
					result.add("T");
					flagChild = false;
				} else {
					result.add("F");
				}
			} else if (familyLine[1].equals("sibling")) {
				Sibling(root, familyLine[0], familyLine[2]);
				if (flagSibling) {
					result.add("T");
					flagSibling = false;
				} else {
					result.add("F");
				}

			} else if (familyLine[1].equals("descendant")) {
				descendant(root, familyLine[0], familyLine[2]);
				if (flagDescendant) {
					result.add("T");
					flagDescendant = false;
				} else {
					result.add("F");
				}

			} else if (familyLine[1].equals("ancestor")) {
				ancestor(root, familyLine[0], familyLine[2]);
				if (ancestorList.contains(familyLine[0])) {
					result.add("T");
					flagAncestor = false;
					ancestorList.clear();
				} else {
					result.add("F");
				}

			} else if (familyLine[1].equals("parent")) {
				parent(root, familyLine[0], familyLine[2]);
				if (flagParent) {
					result.add("T");
					flagAncestor = false;
					ancestorList.clear();
				} else {
					result.add("F");
				}
			}
		}

		for (int i = 0; i < result.size(); i++) {
			if (i < result.size() - 1)
				System.out.print(result.get(i) + " ");
			else if (i == result.size() - 1)
				System.out.println(result.get(i));
		}

		PreOrderTraversal(root);

		for (int i = 0; i < traversal.size(); i++) {
			if (i < traversal.size() - 1)
				System.out.print(traversal.get(i) + " ");
			else if (i == traversal.size() - 1)
				System.out.println(traversal.get(i));
		}

	}

	private static void parent(Node root, String parent, String child) {

		if (root == null)
			return;

		if (root.left != null) {
			if (root.left.data.equals(child))
				flagParent = true;
		}
		if (root.right != null) {
			if (root.right.data.equals(null))
				flagParent = true;
		}
		parent(root.left, parent, child);
		parent(root.right, parent, child);

	}

	private static void PreOrderTraversal(Node root) {
		if (root == null)
			return;

		traversal.add(root.data);
		PreOrderTraversal(root.left);
		PreOrderTraversal(root.right);

	}

	static ArrayList result = new ArrayList();

	static void Child(Node root, String child, String parent) {

		if (root == null)
			return;

		if (root.data.equals(parent)) {
			if (root.left != null) {
				if (root.left.data.equals(child)) {
					flagChild = true;

				} else if (root.right != null) {
					if (root.right.data.equals(child)) {
						flagChild = true;
					}
				}
			}
		}
		Child(root.left, parent, child);
		Child(root.right, parent, child);

	}

	static boolean flag = false;

	static void descendant(Node root, String descendant, String parent) {
		if (root == null)
			return;

		if (flag == true) {
			if (root.data.equals(descendant))
				flagDescendant = true;
		}

		if (root.data.equals(parent)) {
			flag = true;
			descendant(root.left, descendant, parent);
			descendant(root.right, descendant, parent);
		}

		descendant(root.left, descendant, parent);
		descendant(root.right, descendant, parent);
		return;

	}

	static void Sibling(Node root, String child1, String child2) {

		if (root == null)
			return;

		if (root.left != null && root.right != null) {
			if (root.left.data.equals(child1) && root.right.data.equals(child2)) {
				flagSibling = true;
				return;
			}
		}
		Sibling(root.left, child1, child2);
		Sibling(root.right, child1, child2);
	}

	static ArrayList ancestorList = new ArrayList();

	static boolean ancestor(Node root, String ancestor, String child) {
		if (root == null)
			return false;
		if (root.data.equals(child))
			return true;
		if (ancestor(root.left, ancestor, child) || ancestor(root.right, ancestor, child)) {
			ancestorList.add(root.data);
			return true;
		}
		return false;
	}

	static Node Insert(Node root, Object parent, Object child) {

		if (root == null)
			return root;

		if (root.data.equals(parent) && root.left == null) {
			root.left = new Node(child);
			// flagInsert = true;
		} else if (root.data.equals(parent) && root.right == null) {
			// flagInsert = true;
			root.right = new Node(child);
		}
		Insert(root.left, parent, child);
		Insert(root.right, parent, child);

		return root;
	}
}

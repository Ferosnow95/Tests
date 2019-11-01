import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class App {
	static Graph graph = null;
	static int count = 0;
	static int nextNode = 0;
	static ArrayList<Node> connectedGraph = new ArrayList<Node>();

	static class Node {
		int key;
		String value;
		boolean visited;
		ArrayList<Node> neighbours = new ArrayList<Node>();

		public Node(int Key, String value) {
			this.key = key;
			this.value = value;
		}

		public Iterator<Node> listIterator() {
			// TODO Auto-generated method stub
			return null;
		}
	}

	static class Graph {
		int v;
		ArrayList<Node> Nodes = new ArrayList<Node>();

		public Graph(int v) {
			this.v = v;
			for (int i = 0; i < v; i++) {
				Nodes.add(new Node(i, "Empty"));
			}
		}
	}

	public static void DFS(int s) {
		Node node = graph.Nodes.get(s);
		node.visited = true;
		Stack<Node> stack = new Stack<Node>();
		stack.add(node);

		while (!stack.isEmpty()) {

			Node n = stack.pop();
			Iterator<Node> iterator = n.neighbours.listIterator();
			if (iterator.hasNext()) {
				Node entry = iterator.next();
				if (!entry.visited) {
					entry.visited = true;
					stack.add(entry);
				}
			}
		}
	}

	static void printSCCs(int v) {
		Stack<Node> stack = new Stack<Node>();

		// Mark all the vertices as not visited (For first DFS)
		for (Node entry : graph.Nodes) {
			entry.visited = false;
		}

		// Fill vertices in stack according to their finishing
		// times
		for (Node entry : graph.Nodes) {
			if (entry.visited == false) {
				fillOrder(entry.key, entry.visited, stack);
			}
		}

		// Create a reversed graph
		Graph gr = getTranspose(v);

		// Mark all the vertices as not visited (For second DFS)
		for (Node entry : graph.Nodes) {
			entry.visited = false;
		}

		// Now process all vertices in order defined by Stack
		while (stack.empty() == false) {
			// Pop a vertex from stack
			Node n = stack.pop();

			// Print Strongly connected component of the popped vertex
			if (n.visited == false) {
				DFS(n.key);
				System.out.println();
			}
		}
	}

	static void fillOrder(int v, boolean visited, Stack stack) {
		// Mark the current node as visited and print it
		visited = true;
		Node node = graph.Nodes.get(v);

		// Recur for all the vertices adjacent to this vertex
		Iterator<Node> i = node.neighbours.listIterator();
		while (i.hasNext()) {
			Node n = i.next();
			if (!node.visited)
				fillOrder(n.key, node.visited, stack);
		}

		// All vertices reachable from v are processed by now,
		// push v to Stack
		stack.push(new Integer(v));
	}

	static Graph getTranspose(int V) {
		Graph g = new Graph(V);
		for (Node entry : graph.Nodes) {
			// Recur for all the vertices adjacent to this vertex
			Iterator<Node> i = entry.neighbours.listIterator();
			while (i.hasNext())
				g.Nodes.get(i.next().key).value = entry.value;
//			g.adj[i.next()].add(v);
		}
		return g;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String vertex = sc.nextLine();
		graph = new Graph(Integer.parseInt(vertex));
		String edge = sc.nextLine();
		String line[];

		for (int i = 0; i < Integer.parseInt(edge); i++) {

			line = sc.nextLine().split(" ");

			ChangeNodeName(line[0]);
			ChangeNodeName(line[1]);
			addEdge(line[0], line[1]);
		}

		printSCCs(Integer.parseInt(vertex));

	}

	static int connectedNodes = 0;

	private static void isConnected(int v) {
		for (Node entry : graph.Nodes) {
			if (entry.visited) {
				connectedNodes++;
			}
		}
		if (connectedNodes == v) {
			System.out.print(1 + " ");
		} else {
			System.out.print(0 + " ");
		}
	}

	static void BFS(int s) {

		Node node = graph.Nodes.get(s);

		if (node.visited)
			return;

		count++;
		LinkedList<Node> queue = new LinkedList<Node>();

		node.visited = true;
		queue.add(node);

		while (queue.size() != 0) {
			Node m = queue.poll();
			Iterator<Node> i = m.neighbours.listIterator();
			while (i.hasNext()) {
				Node n = i.next();
				if (!n.visited) {
					n.visited = true;
					queue.add(n);
				}
			}
		}
	}

	private static void addEdge(String Node1, String Node2) {

		Node parent = null;
		Node child = null;

		for (Node entry : graph.Nodes) {
			if (entry.value.equals(Node1)) {
				parent = entry;
			} else if (entry.value.equals(Node2)) {
				child = entry;
			}
		}
		parent.neighbours.add(child);
	}

	private static void ChangeNodeName(String nodeValue) {

		boolean isExist = false;
		for (Node entry : graph.Nodes) {
			if (entry.value.equals(nodeValue)) {
				isExist = true;
			}
		}

		if (!isExist) {
			graph.Nodes.get(nextNode).value = nodeValue;
			nextNode++;
		}
	}
}

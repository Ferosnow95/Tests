import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

// This class represents a directed graph using adjacency list 
// representation 
class Graph {
	private int V; // No. of vertices
	private LinkedList<Integer> adj[]; // Adjacency Lists
	static boolean visited[];
	static int count;

	// Constructor
	Graph(int v) {
		V = v;
		adj = new LinkedList[v];
		visited = new boolean[v];
		for (int i = 0; i < v; ++i)
			adj[i] = new LinkedList();
	}

	// Function to add an edge into the graph
	void addEdge(int v, int w) {
		adj[v].add(w);
	}

	// prints BFS traversal from a given source s
	void BFS(int s) {
		// Mark all the vertices as not visited(By default
		// set as false)
		if (visited[s])
			return;

		count++;
		// Create a queue for BFS
		LinkedList<Integer> queue = new LinkedList<Integer>();

		// Mark the current node as visited and enqueue it
		visited[s] = true;
		queue.add(s);

		while (queue.size() != 0) {
			// Dequeue a vertex from queue and print it
			s = queue.poll();
//			System.out.print(s + " ");

			// Get all adjacent vertices of the dequeued vertex s
			// If a adjacent has not been visited, then mark it
			// visited and enqueue it
			Iterator<Integer> i = adj[s].listIterator();
			while (i.hasNext()) {
				int n = i.next();
				if (!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			}
		}
	}

	// Driver method to
	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		String line1 = sc.nextLine();
		String line2 = sc.nextLine();

		int v = Integer.parseInt(line1);
		int edge = Integer.parseInt(line2);

		int connected = 0;
		int countVisited = 0;

		Graph g = new Graph(v);

		for (int i = 0; i < edge; i++) {
			String[] line = sc.nextLine().split("");
			g.addEdge(Integer.parseInt(line[0]), Integer.parseInt(line[2]));
		}
		for (int i = 0; i < edge; i++) {
			g.BFS(i);
			if (i == 0) {
				for (int k = 0; k < visited.length; k++) {
					if (visited[k] == true) {
						countVisited++;
					}
				}
				if (countVisited == v) {
					connected = 1;
					break;
				} else
					connected = 0;
			}
		}

		System.out.print(connected + " " + count);

	}
}

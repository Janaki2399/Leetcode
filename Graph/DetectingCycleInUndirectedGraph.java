                                                            // Using BFS //


import java.util.ArrayList; 
import java.util.Arrays; 
import java.util.LinkedList; 
import java.util.Queue; 

// Java program to detect cycle in 
// an undirected graph using BFS. 
class cycle 
{ 
	
	public static void main(String arg[]) 
	{ 

		int V = 4; 
		ArrayList <Integer> adj[] = new ArrayList[V]; 
		for(int i = 0; i < 4; i++) 
			adj[i] = new ArrayList<Integer>(); 

		addEdge(adj, 0, 1); 
		addEdge(adj, 1, 2); 
		addEdge(adj, 2, 0); 
		addEdge(adj, 2, 3); 

		if (isCyclicDisconntected(adj, V)) 
			System.out.println("Yes"); 
		else
			System.out.println("No"); 


	} 

	static void addEdge(ArrayList<Integer> adj[], int u, int v) 
	{ 
		adj[u].add(v); 
		adj[v].add(u); 
	} 

		static boolean isCyclicConntected(ArrayList<Integer> adj[], int s, 
											int V, boolean visited[]) 
		{ 
			
			// Set parent vertex for every vertex as -1. 
			int parent[] = new int[V]; 
			Arrays.fill(parent, -1); 

			// Create a queue for BFS 
			Queue<Integer> q = new LinkedList<>(); 

			// Mark the current node as 
			// visited and enqueue it 
			visited[s] = true; 
			q.add(s); 

			while (!q.isEmpty()) 
			{ 

				// Dequeue a vertex from 
				// queue and print it 
				int u = q.poll(); 


				// Get all adjacent vertices 
				// of the dequeued vertex u. 
				// If a adjacent has not been 
				// visited, then mark it visited 
				// and enqueue it. We also mark parent 
				// so that parent is not considered 
				// for cycle. 
				for (int i=0; i<adj[u].size();i++) 
				{ 
					int v = adj[u].get(i); 
					if (!visited[v]) 
					{ 
						visited[v] = true; 
						q.add(v); 
						parent[v] = u; 
					} 
					else if (parent[u] != v) 
						return true; 
				} 
			} 
			return false; 
		} 


		static boolean isCyclicDisconntected(ArrayList<Integer> adj[], int V) 
		{ 
			
			// Mark all the vertices as not visited 
			boolean visited[] = new boolean[V]; 
			Arrays.fill(visited,false); 

			for (int i = 0; i < V; i++) 
				if (!visited[i] && 
					isCyclicConntected(adj, i, V, visited)) 
					return true; 
			return false; 
		} 
} 


								//USING DFS //

// A Java Program to detect cycle in an undirected graph 
import java.io.*; 
import java.util.*; 

// This class represents a directed graph using adjacency list 
// representation 
class Graph 
{ 
	private int V; // No. of vertices 
	private LinkedList<Integer> adj[]; // Adjacency List Represntation 

	// Constructor 
	Graph(int v) { 
		V = v; 
		adj = new LinkedList[v]; 
		for(int i=0; i<v; ++i) 
			adj[i] = new LinkedList(); 
	} 

	// Function to add an edge into the graph 
	void addEdge(int v,int w) { 
		adj[v].add(w); 
		adj[w].add(v); 
	} 

	// A recursive function that uses visited[] and parent to detect 
	// cycle in subgraph reachable from vertex v. 
	Boolean isCyclicUtil(int v, Boolean visited[], int parent) 
	{ 
		// Mark the current node as visited 
		visited[v] = true; 
		Integer i; 

		// Recur for all the vertices adjacent to this vertex 
		Iterator<Integer> it = adj[v].iterator(); 
		while (it.hasNext()) 
		{ 
			i = it.next(); 

			// If an adjacent is not visited, then recur for that 
			// adjacent 
			if (!visited[i]) 
			{ 
				if (isCyclicUtil(i, visited, v)) 
					return true; 
			} 

			// If an adjacent is visited and not parent of current 
			// vertex, then there is a cycle. 
			else if (i != parent) 
				return true; 
		} 
		return false; 
	} 

	// Returns true if the graph contains a cycle, else false. 
	Boolean isCyclic() 
	{ 
		// Mark all the vertices as not visited and not part of 
		// recursion stack 
		Boolean visited[] = new Boolean[V]; 
		for (int i = 0; i < V; i++) 
			visited[i] = false; 

		// Call the recursive helper function to detect cycle in 
		// different DFS trees 
		for (int u = 0; u < V; u++) 
			if (!visited[u]) // Don't recur for u if already visited 
				if (isCyclicUtil(u, visited, -1)) 
					return true; 

		return false; 
	} 


	// Driver method to test above methods 
	public static void main(String args[]) 
	{ 
		// Create a graph given in the above diagram 
		Graph g1 = new Graph(5); 
		g1.addEdge(1, 0); 
		g1.addEdge(0, 2); 
		g1.addEdge(2, 1); 
		g1.addEdge(0, 3); 
		g1.addEdge(3, 4); 
		if (g1.isCyclic()) 
			System.out.println("Graph contains cycle"); 
		else
			System.out.println("Graph doesn't contains cycle"); 

		Graph g2 = new Graph(3); 
		g2.addEdge(0, 1); 
		g2.addEdge(1, 2); 
		if (g2.isCyclic()) 
			System.out.println("Graph contains cycle"); 
		else
			System.out.println("Graph doesn't contains cycle"); 
	} 
} 
// This code is contributed by Aakash Hasija 



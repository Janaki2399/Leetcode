
							//BFS

/*Steps involved in detecting cycle in a directed graph using BFS.

Step-1: Compute in-degree (number of incoming edges) for each of the vertex present in the graph and initialize the count of visited nodes as 0.

Step-2: Pick all the vertices with in-degree as 0 and add them into a queue (Enqueue operation)

Step-3: Remove a vertex from the queue (Dequeue operation) and then.

Increment count of visited nodes by 1.
Decrease in-degree by 1 for all its neighboring nodes.
If in-degree of a neighboring nodes is reduced to zero, then add it to the queue.
Step 4: Repeat Step 3 until the queue is empty.

Step 5: If count of visited nodes is not equal to the number of nodes in the graph has cycle, otherwise not.*/


// Java program to check if there is a cycle in 
// directed graph using BFS. 
import java.io.*; 
import java.util.*; 

class GFG 
{ 

	// Class to represent a graph 
	static class Graph 
	{ 
		int V; // No. of vertices' 

		// Pointer to an array containing adjacency list 
		Vector<Integer>[] adj; 

		@SuppressWarnings("unchecked") 
		Graph(int V) 
		{ 
			// Constructor 
			this.V = V; 
			this.adj = new Vector[V]; 
			for (int i = 0; i < V; i++) 
				adj[i] = new Vector<>(); 
		} 

		// function to add an edge to graph 
		void addEdge(int u, int v) 
		{ 
			adj[u].add(v); 
		} 

		// Returns true if there is a cycle in the graph 
		// else false. 

		// This function returns true if there is a cycle 
		// in directed graph, else returns false. 
		boolean isCycle() 
		{ 

			// Create a vector to store indegrees of all 
			// vertices. Initialize all indegrees as 0. 
			int[] in_degree = new int[this.V]; 
			Arrays.fill(in_degree, 0); 

			// Traverse adjacency lists to fill indegrees of 
			// vertices. This step takes O(V+E) time 
			for (int u = 0; u < V; u++) 
			{ 
				for (int v : adj[u]) 
					in_degree[v]++; 
			} 

			// Create an queue and enqueue all vertices with 
			// indegree 0 
			Queue<Integer> q = new LinkedList<Integer>(); 
			for (int i = 0; i < V; i++) 
				if (in_degree[i] == 0) 
					q.add(i); 

			// Initialize count of visited vertices 
			int cnt = 0; 

			// Create a vector to store result (A topological 
			// ordering of the vertices) 
			Vector<Integer> top_order = new Vector<>(); 

			// One by one dequeue vertices from queue and enqueue 
			// adjacents if indegree of adjacent becomes 0 
			while (!q.isEmpty()) 
			{ 

				// Extract front of queue (or perform dequeue) 
				// and add it to topological order 
				int u = q.poll(); 
				top_order.add(u); 

				// Iterate through all its neighbouring nodes 
				// of dequeued node u and decrease their in-degree 
				// by 1 
				for (int itr : adj[u]) 
					if (--in_degree[itr] == 0) 
						q.add(itr); 
				cnt++; 
			} 

			// Check if there was a cycle 
			if (cnt != this.V) 
				return true; 
			else
				return false; 
		} 
	} 

	// Driver Code 
	public static void main(String[] args) 
	{ 

		// Create a graph given in the above diagram 
		Graph g = new Graph(6); 
		g.addEdge(0, 1); 
		g.addEdge(1, 2); 
		g.addEdge(2, 0); 
		g.addEdge(3, 4); 
		g.addEdge(4, 5); 

		if (g.isCycle()) 
			System.out.println("Yes"); 
		else
			System.out.println("No"); 
	} 
} 

							//dfs

// A Java Program to detect cycle in a graph 
import java.util.ArrayList; 
import java.util.LinkedList; 
import java.util.List; 

class Graph { 
	
	private final int V; 
	private final List<List<Integer>> adj; 

	public Graph(int V) 
	{ 
		this.V = V; 
		adj = new ArrayList<>(V); 
		
		for (int i = 0; i < V; i++) 
			adj.add(new LinkedList<>()); 
	} 
	
	
	private boolean isCyclicUtil(int i, boolean[] visited, boolean[] recStack) 
	{ 
		
		// Mark the current node as visited and 
		// part of recursion stack 
		if (recStack[i]) 
			return true; 

		if (visited[i]) 
			return false; 
			
		visited[i] = true; 

		recStack[i] = true; 
		List<Integer> children = adj.get(i); 
		
		for (Integer c: children) 
			if (isCyclicUtil(c, visited, recStack)) 
				return true; 
				
		recStack[i] = false; 

		return false; 
	} 

	private void addEdge(int source, int dest) { 
		adj.get(source).add(dest); 
	} 

	// Returns true if the graph contains a 
	// cycle, else false. 
	private boolean isCyclic() 
	{ 
		
		// Mark all the vertices as not visited and 
		// not part of recursion stack 
		boolean[] visited = new boolean[V]; 
		boolean[] recStack = new boolean[V]; 
		
		
		// Call the recursive helper function to 
		// detect cycle in different DFS trees 
		for (int i = 0; i < V; i++) 
			if (isCyclicUtil(i, visited, recStack)) 
				return true; 

		return false; 
	} 

	// Driver code 
	public static void main(String[] args) 
	{ 
		Graph graph = new Graph(4); 
		graph.addEdge(0, 1); 
		graph.addEdge(0, 2); 
		graph.addEdge(1, 2); 
		graph.addEdge(2, 0); 
		graph.addEdge(2, 3); 
		graph.addEdge(3, 3); 
		
		if(graph.isCyclic()) 
			System.out.println("Graph contains cycle"); 
		else
			System.out.println("Graph doesn't "
									+ "contain cycle"); 
	} 
} 




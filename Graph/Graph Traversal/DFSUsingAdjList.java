// Java program to print DFS traversal from a given given graph 
import java.io.*; 
import java.util.*; 

// This class represents a directed graph using adjacency list 
// representation 
class Graph 
{ 
	private int V; // No. of vertices 

	// Array of lists for Adjacency List Representation 
	private LinkedList<Integer> adj[]; 

	// Constructor 
	Graph(int v) 
	{ 
		V = v; 
		adj = new LinkedList[v]; 
		for (int i=0; i<v; ++i) 
			adj[i] = new LinkedList(); 
	} 

	//Function to add an edge into the graph 
	void addEdge(int v, int w) 
	{ 
		adj[v].add(w); // Add w to v's list. 
	} 

	// A function used by DFS 
	void DFSUtil(int v,boolean visited[]) 
	{ 
		// Mark the current node as visited and print it 
		visited[v] = true; 
		System.out.print(v+" "); 

		// Recur for all the vertices adjacent to this vertex 
		Iterator<Integer> i = adj[v].listIterator(); 
		while (i.hasNext()) 
		{ 
			int n = i.next(); 
			if (!visited[n]) 
				DFSUtil(n, visited); 
		} 
	} 

	// The function to do DFS traversal. It uses recursive DFSUtil() 
	void DFS(int v) 
	{ 
		// Mark all the vertices as not visited(set as 
		// false by default in java) 
		boolean visited[] = new boolean[V]; 

		// Call the recursive helper function to print DFS traversal 
		DFSUtil(v, visited); 
	} 

	public static void main(String args[]) 
	{ 
		Graph g = new Graph(4); 

		g.addEdge(0, 1); 
		g.addEdge(0, 2); 
		g.addEdge(1, 2); 
		g.addEdge(2, 0); 
		g.addEdge(2, 3); 
		g.addEdge(3, 3); 

		System.out.println("Following is Depth First Traversal "+ 
						"(starting from vertex 2)"); 
		g.DFS(2); 
	} 
} 


					//ITERATIVE DFS 

      void DFS(int s) 
        { 
            // Initially mark all vertices as not visited 
            Vector<Boolean> visited = new Vector<Boolean>(V); 
            for (int i = 0; i < V; i++) 
                visited.add(false); 
      
            // Create a stack for DFS 
            Stack<Integer> stack = new Stack<>(); 
              
            // Push the current source node 
            stack.push(s); 
              
            while(stack.empty() == false) 
            { 
                // Pop a vertex from stack and print it 
                s = stack.peek(); 
                stack.pop(); 
                  
                // Stack may contain same vertex twice. So 
                // we need to print the popped item only 
                // if it is not visited. 
                if(visited.get(s) == false) 
                { 
                    System.out.print(s + " "); 
                    visited.set(s, true); 
                } 
                  
                // Get all adjacent vertices of the popped vertex s 
                // If a adjacent has not been visited, then push it 
                // to the stack. 
                Iterator<Integer> itr = adj[s].iterator(); 
                  
                while (itr.hasNext())  
                { 
                    int v = itr.next(); 
                    if(!visited.get(v)) 
                        stack.push(v); 
                } 
                  
            } 
        } 
    }

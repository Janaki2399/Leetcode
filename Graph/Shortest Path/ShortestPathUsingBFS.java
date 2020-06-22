 	// Java program to find shortest path in an undirected and unweighted graph
// graph 
import java.util.*; 
import java.util.Iterator; 
import java.util.LinkedList; 

public class Graph { 

	// Driver Program 
	public static void main(String args[]) 
	{ 
		// No of vertices 
		int v = 8; 

		// Adjacency list for storing which vertices are connected 
		ArrayList<ArrayList<Integer>> adj = 
							new ArrayList<ArrayList<Integer>>(v); 
		for (int i = 0; i < v; i++) { 
			adj.add(new ArrayList<Integer>()); 
		} 

		// Creating graph given in the above diagram. 
		// add_edge function takes adjacency list, source 
		// and destination vertex as argument and forms 
		// an edge between them. 
		addEdge(adj, 0, 1); 
		addEdge(adj, 0, 3); 
		addEdge(adj, 1, 2); 
		addEdge(adj, 3, 4); 
		addEdge(adj, 3, 7); 
		addEdge(adj, 4, 5); 
		addEdge(adj, 4, 6); 
		addEdge(adj, 4, 7); 
		addEdge(adj, 5, 6); 
		addEdge(adj, 6, 7); 
		int source = 0, dest = 7; 
		printShortestDistance(adj, source, dest, v); 
	} 

	// function to form edge between two vertices 
	// source and dest 
	private static void addEdge(ArrayList<ArrayList<Integer>> adj, int i, int j) 
	{ 
		adj.get(i).add(j); 
		adj.get(j).add(i); 
	} 

	// function to print the shortest distance and path 
	// between source vertex and destination vertex 
	private static void printShortestDistance( 
					ArrayList<ArrayList<Integer>> adj, 
							int s, int dest, int v) 
	{ 
		int[] pred=new int[v];
		int[] dis=new int[v];
		if(BFS(adj,s,dest,v,pred,dis))
		{
			System.out.println("the nodes are not connected");
		}
		ArrayList<Integer> path=new ArrayList<Integer>();
	
		int crawl=dest;
		path.add(dest);
		
		while(pred[crawl]!=-1) //since source pred is -1
		{
			path.add(pred[crawl]);
			crawl=pred[crawl];
			
		}		
		System.out.println("Shortest path length is: " + dis[dest]); 
  
        // Print path 
        System.out.println("Path is ::"); 
        for (int i = path.size() - 1; i >= 0; i--) { 
            System.out.print(path.get(i) + " "); 
        } 
	} 

	// a modified version of BFS that stores predecessor 
	// of each vertex in array pred 
	// and its distance from source in array dist 
	private static boolean BFS(ArrayList<ArrayList<Integer>> adj, int s, 
								int dest, int v, int prev[], int dist[]) 
	{ 
		boolean[] visited =new boolean[v];
		for(int i=0;i<v;i++)
		{
			visited[i]=false;
			prev[i]=-1;
			dist[i]=Integer.MAX_VALUE;
		}
		
		Queue<Integer> q=new LinkedList<Integer>();

		q.add(s);
		visited[s]=true;
		dist[s]=0;
		
		while(!q.isEmpty())
		{
			int u=q.poll();
			ArrayList<Integer> ls=adj.get(u);
			for(int i=0;i<ls.size();i++)
			{
				if(visited[ls.get(i)]==false)
				{
					visited[ls.get(i)]=true;
					prev[ls.get(i)]=u;
					dist[ls.get(i)]=dist[u]+1;
					q.add(ls.get(i));
				if(ls.get(i)==dest)
				{
					return true;
				}
				}
			}
		 }
		return false;

	} 
} 



//representing using adjacency list

import java.io.*;
import java.util.*;

class BuildTrees2
{
ArrayList<ArrayList<Integer>> arr=new ArrayList<>();
  private int numVertices;

  // Initialize the matrix
  public BuildTrees2 (int numVertices) 
 {
   this.numVertices = numVertices;
   for(int i=0;i<numVertices;i++)
		{
			arr.add(new ArrayList<Integer>());
		}
  }

  // Add edges
  public void addEdge(int u, int v) {
   arr.get(u).add(v);
	arr.get(v).add(u);
  }

// Print the matrix

public void print()
{
 for(int i=0;i<arr.size();i++)
	{
		for(int j=0;j<arr.get(i).size();j++)
		{
			System.out.print(arr.get(i).get(j));
		}
	System.out.println();
	}
}
  
 

  public static void main(String args[]) {
    BuildTrees2 g = new BuildTrees2(4);

    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(1, 2);
    g.addEdge(2, 0);
    g.addEdge(2, 3);

    g.print();
  }
}


//representing using matrix://

import java.io.*;
import java.util.*;

class BuildTrees2
{

 // Adjacency Matrix representation in Java

public class Graph {
  private boolean adjMatrix[][];
  private int numVertices;

  // Initialize the matrix
  public Graph(int numVertices) {
    this.numVertices = numVertices;
    adjMatrix = new boolean[numVertices][numVertices];
  }

  // Add edges
  public void addEdge(int i, int j) {
    adjMatrix[i][j] = true;
    adjMatrix[j][i] = true;
  }

  // Remove edges
  public void removeEdge(int i, int j) {
    adjMatrix[i][j] = false;
    adjMatrix[j][i] = false;
  }

  // Print the matrix
  public String toString() {
    StringBuilder s = new StringBuilder();
    for (int i = 0; i < numVertices; i++) {
      s.append(i + ": ");
      for (boolean j : adjMatrix[i]) {
        s.append((j ? 1 : 0) + " ");
      }
      s.append("\n");
    }
    return s.toString();
  }

  public static void main(String args[]) {
    BuildTree2 g = new BuildTree(4);

    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(1, 2);
    g.addEdge(2, 0);
    g.addEdge(2, 3);

    System.out.print(g.toString());
  }
}


}

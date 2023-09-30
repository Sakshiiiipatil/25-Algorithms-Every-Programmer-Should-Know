/*Given an undirected graph with V vertices and E edges and a node X, The task is to find the level of node X in the undirected graph. If X does not exist in the graph then return -1.

Note: Traverse the graph starting from vertex 0.*/

// Java code to implement the approach

import java.util.*;
class GFG {

	// Driver code
	public static void main(String[] args)
	{
		int V = 5;
		int[][] edges
			= { { 0, 1 }, { 0, 2 }, { 1, 3 }, { 2, 4 } };
		int X = 3;

		// Function call
		int level = findLevel(V, edges, X);
		System.out.println(level);
	}

	// Function to find the level of the node
	public static int findLevel(int N, int[][] edges, int X)
	{
		int maxVertex = 0;
		for (int[] it : edges) {
			maxVertex = Math.max(maxVertex,
								Math.max(it[0], it[1]));
		}

		// Creating adjacency list
		ArrayList<Integer>[] adj
			= new ArrayList[maxVertex + 1];

		for (int i = 0; i <= maxVertex; i++)
			adj[i] = new ArrayList<>();

		for (int i = 0; i < edges.length; i++) {
			adj[edges[i][0]].add(edges[i][1]);
			adj[edges[i][1]].add(edges[i][0]);
		}

		// X is not present
		if (X > maxVertex || adj[X].size() == 0)
			return -1;

		// Queue for BFS traversal
		LinkedList<Integer> q = new LinkedList<>();
		q.offer(0);
		int level = 0;

		boolean[] visited = new boolean[maxVertex + 1];

		// BFS traversal
		while (!q.isEmpty()) {
			int sz = q.size();
			while (sz-- > 0) {
				int currentNode = q.poll();

				if (currentNode == X)
					return level;

				for (int it : adj[currentNode]) {
					if (!visited[it]) {
						q.offer(it);
						visited[it] = true;
					}
				}
			}
			level++;
		}

		return -1;
	}
}

/*main method:

In the main method, an example undirected graph is created with 5 vertices (V) and the edges specified in the edges array. The task is to find the level of node X, which is set to 3.
The program calls the findLevel function to perform this task.
The level of node X is then printed to the console.
findLevel method:

The findLevel method takes the following parameters:

N: The number of vertices in the graph.
edges: A 2D array representing the edges between vertices.
X: The node for which the level needs to be found.
The method first calculates the maximum vertex number (maxVertex) by iterating through the edges to determine the highest vertex number.

It then creates an adjacency list adj to represent the graph, where each vertex is associated with its adjacent vertices.

The adjacency list is populated based on the information from the edges.

If X is greater than maxVertex (i.e., it exceeds the maximum vertex number) or if X has no adjacent vertices, it returns -1 because X does not exist in the graph.

The method uses a queue (q) for breadth-first search (BFS) traversal. It starts the traversal from vertex 0 and initializes the level to 0.

A boolean array visited is used to keep track of visited vertices.

The BFS traversal continues until the queue is empty. At each level of the traversal, it checks if the current node is equal to X. If it is, it returns the current level as the result.

Otherwise, it explores the adjacent nodes of the current node and marks them as visited. The traversal continues to the next level, and the level variable is incremented.

Output:

The program outputs the level of node X in the graph or -1 if X is not present in the graph.*/

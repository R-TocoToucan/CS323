	// THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING
	// A TUTOR OR CODE WRITTEN BY OTHER STUDENTS - Minseok Choi
	// Tall Trucks, passed all tests. 
	// If you finish the "Bellman-Ford" TODO below, then this passes
	// the smaller tests, but it may timeout in the last few tests.

	// Note we map each input vertex number X to X-1 internally.
	// In particular, the start vertex 1 becomes 0 here.
	import java.util.Scanner;

	public class Solution {
	    // We represent an edge (road) using two DEdge objects,
	    // one in each adjacency list.
	    static class DEdge {
	        int v, h;           // other endpoint, and height
	        DEdge next;         // next in this adjacency list
	        DEdge(int v, int h, DEdge n) { this.v = v; this.h = h; next = n; }
	    }
	    public static void main(String[] args) {
	        // read first line of input (N=#vertices, M=#edges)
	        Scanner sc = new Scanner(System.in);
	        int N = sc.nextInt(), M = sc.nextInt();

	        // ht[v] is tallest known height of a truck route to v. 
	        // Initially ht[v] is 0 everywhere, except at the start.
	        int[] ht = new int[N];
	        ht[0] = 1000;   // max possible height

	        DEdge[] adj = new DEdge[N]; // N empty adjacency lists
	        for (int i=0; i<M; ++i) {
	            // read edge u, v, h (mapping each vertex number X to X-1)
	            int u = sc.nextInt()-1, v = sc.nextInt()-1, h = sc.nextInt();
	            adj[u] = new DEdge(v, h, adj[u]); // add (v,h) to u's list
	            adj[v] = new DEdge(u, h, adj[v]); // add (u,h) to v's list
	        }

	        for (int i=0; i<30; i++) {
	        	for (int j=0; j<N; j++) {
	        		for (DEdge e=adj[j]; e!=null; e=e.next) {
	        			relax(e, j, ht);
	        		}
	        	}
	        }
	        
	        // TODO: Bellman-Ford style approach (slow):
	        //    Repeat N-1 times: relax all the edges!
	        // To relax a single edge (u,v,h), try to improve 
	        // ht[v], using a truck routed from u on this edge.

	        
	        // Print result (ht[v] for every vertex v except the start)
	        for (int v=1; v<N-1; ++v) System.out.print(ht[v]+" ");
	        System.out.println(ht[N-1]);
	    }
	    static void relax(DEdge n, int i, int[] ht) {

	    	if (Math.min(ht[i], n.h) > ht[n.v]) {
	    		ht[n.v] = Math.min(ht[i], n.h);
	    	}
	    }
	}


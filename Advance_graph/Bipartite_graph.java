import java.io.*;
import java.util.*;
class Bipartite_graph {
	public static boolean bipartite(ArrayList<ArrayList<Integer>> g, int n) {
		int visited[] = new int[n]; // This is usefull when dealing with disconnected graph.
		//first we need to define two sets.
		int set[] = new int[n];
		
		for(int i = 0; i<n; i++) {
			if(visited[i] == 0) {
				// now we need to have a queue.
				ArrayList<Integer> queue = new ArrayList<Integer>();
				queue.add(i);// i'th vertex is added to the queue.
				set[i] = 1;
				for(int j = i; j<queue.size(); j++) {
					int cur = queue.get(j);
					//we need to traverse through all the neighbours of this vertex.
					int set_of_neighbour = (set[cur] == 1)? 2:1;
					for(int k = 0; k<g.get(cur).size(); k++) {
						int neighbour = g.get(cur).get(k);
						if(set[neighbour] == set[cur]) {
							//this Graph cannot be bipartite.
							return false;
						}else {
							if(set[neighbour] == 0) {
								//we add this neighbour to the queue so as to explore its neighbour.
								queue.add(neighbour);
							}
							set[neighbour] = set_of_neighbour;	
						}
					}
				}
			}
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		while(true) {
			int n = sc.nextInt();
			if(n == 0) {
				break;
			}
			int e = sc.nextInt();
			ArrayList<ArrayList<Integer>> g = new ArrayList<ArrayList<Integer>>(n);
			for(int i = 0; i<n; i++) {
				g.add(new ArrayList<Integer>());
			}
			for(int i = 0; i<e; i++){
				int x = sc.nextInt();
				int y = sc.nextInt();
				g.get(x).add(y);
			}
			System.out.println(g);
			boolean ans = bipartite(g, n);
			if(ans) {
				System.out.println("Bipartite Graph");
			}else {
				System.out.println("Not a Bipartite Graph");
			}
		}
	}
}
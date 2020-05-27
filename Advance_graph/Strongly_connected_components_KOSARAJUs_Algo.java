import java.io.*;
import java.util.*;
class Strongly_connected_components_KOSARAJUs_Algo {
	public static void dfs(int cur, ArrayList<ArrayList<Integer>> g, Stack<Integer> st, int visited[]) {
		visited[cur] = 1;
		for(int i = 0; i<g.get(cur).size(); i++) {
			int adjacent = g.get(cur).get(i);
			if(visited[adjacent] == 0) {
				dfs(adjacent, g, st, visited);
			}
		}
		st.push(cur);
	}
	public static void dfs2(int cur, ArrayList<ArrayList<Integer>> gt, int visited[], ArrayList<Integer> ans) {
		visited[cur] = 1;
		ans.add(cur+1);
		for(int i = 0; i<gt.get(cur).size(); i++) {
			int adjacent = gt.get(cur).get(i);
			if(visited[adjacent] == 0) {
				dfs2(adjacent, gt, visited, ans);
			}
		}
	}
	public static void getSCC(ArrayList<ArrayList<Integer>> g, ArrayList<ArrayList<Integer>> gt, int n) {
		int visited[] = new int[n];
		Stack<Integer> st = new Stack<Integer>();
		for(int i = 0; i<n; i++) {
			if(visited[i] == 0) {
				//call dfs with this vertex.
				dfs(i, g, st, visited);
			}
		}
		Arrays.fill(visited, 0);
		int count = 0;
		//System.out.println(st);
		// now we need to traverse the transpose of the graph using the stack that we created, and finally we gwt the Strongly Connected Componenets.
		while(st.size()>0) {
			int cur = st.pop();
			ArrayList<Integer> ans = new ArrayList<Integer>();
			if(visited[cur] != 0)
				continue;
			dfs2(cur, gt, visited, ans);
			System.out.print(ans+" ");
			count++;
		}
		System.out.println();
		System.out.println("Number of Strongly Connected Components are : "+count);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
			int n = sc.nextInt();
			ArrayList<ArrayList<Integer>> g = new ArrayList<ArrayList<Integer>>(n);
			ArrayList<ArrayList<Integer>> gt = new ArrayList<ArrayList<Integer>>(n);
			for(int i = 0; i<n; i++) {
				g.add(new ArrayList<Integer>());
				gt.add(new ArrayList<Integer>());
			}
			int m = sc.nextInt();
			for(int i = 0; i<m; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				g.get(x-1).add(y-1);
				gt.get(y-1).add(x-1);
			}
            System.out.println("Graph = "+g+"\n"+"Transpose Graph = "+gt);
			getSCC(g, gt, n);
		}
	}
}
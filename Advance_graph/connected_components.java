import java.io.*;
import java.util.*;
class connected_compnents {
	public static HashSet<Integer> dfs(HashMap<Integer, List<Integer>> graph, boolean visited[], int i, int n, HashSet<Integer> result)
	{
		visited[i] = true;
		result.add(i);
		for(int j = 0; j<graph.get(i).size(); j++)
		{
			if(!visited[graph.get(i).get(j)])
				dfs(graph, visited, graph.get(i).get(j), n, result);
		}
		return result;
	}
	public static HashSet<HashSet<Integer>> getComponents(HashMap<Integer, List<Integer>> graph, int n)
	{
		boolean visited[] = new boolean[n];
		HashSet<HashSet<Integer>> hs = new HashSet<>();
		//start dfs
		for(int i = 0; i<n; i++)
		{
			if(!visited[i])
			{
				HashSet<Integer> result = new HashSet<>();
				dfs(graph, visited, i, n, result);
				hs.add(result);
			}
		}
		return hs;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		//HashMap<Integer, HashSet<Integer>> graph = new HashMap<> (n);
		//HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>(n);
	//	|------->
		LinkedList<Integer> ob[] = new LinkedList[n];
		ob[0].add(5);
		ob[2].add(7);
		System.out.println(ob);
		HashMap<Integer, List<Integer>> graph = new HashMap<>(n);
	//	<-------|
		int m = sc.nextInt();
		while(m-- > 0)
		{
			int x = sc.nextInt();
			int y = sc.nextInt();
			if(!graph.containsKey(x)) {
				// if x is already created in graph.
				graph.put(x, new LinkedList<Integer>());
				graph.get(x).add(y);
				if(!graph.containsKey(y))
				{
					//if graph does not contain Y then new entry Y is created and X is added as a adjacent vertex.
					graph.put(y, new LinkedList<Integer>());
					graph.get(y).add(x);
				}
				else
				{
					//if graph already contains entry Y, we just add the adjacent edge to x.
					graph.get(y).add(x);
				}
			}
			else
			{
				// if graph already contains x, we just add adjacent edge to y after checking below conditions.
				if(!graph.get(x).contains(y))
				{
					// check if entry X contains Y, if yes then do not add Y again otherwise add.
					graph.get(x).add(y);
					if(!graph.containsKey(y))
					{
						// if entry Y is not present, create a new entry.
						graph.put(y, new LinkedList<Integer>());
						graph.get(y).add(x);
					}
					else
					{
						// if entry Y is already present,
						if(!graph.get(y).contains(x))
						{
							// check if Y is linked to X or not.
							graph.get(y).add(x);
						}
					}
				}
			}
		}
		HashSet<HashSet<Integer>> ans = getComponents(graph, n);
		System.out.println(ans);
		System.out.println("Graph is : "+graph);
	}
}

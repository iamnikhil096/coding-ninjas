import java.io.*;
import java.util.*;
class minimum_cost_for_jobs {
	public static int minCost(int cost[][], int dp[], int n, int person, int mask) {
		if(person >= n)
			return 0;
		if(dp[mask] != Integer.MAX_VALUE){
			return dp[mask];
		}
		int minimum = Integer.MAX_VALUE;
		for(int j = 0; j<n; j++) {
			if((mask&(1<<j)) == 0) {
				int ans = cost[person][j] + minCost(cost, dp, n, person+1, mask|(1<<j));
				if(ans < minimum)
					minimum = ans;
			}
		}
		dp[mask] = minimum;
		return minimum;
	}
	public static void main(String[] args) {
		int n = 4;
		int cost[][] = {{10, 2, 6, 5}, {1, 15, 12, 8}, {7, 8, 9, 3}, {15, 13, 4, 10}};
		int dp[] = new int[(1<<n)];
		Arrays.fill(dp, Integer.MAX_VALUE);
		System.out.println(minCost(cost, dp, n, 0, 0));
		System.out.println(dp[0]);
	}
}
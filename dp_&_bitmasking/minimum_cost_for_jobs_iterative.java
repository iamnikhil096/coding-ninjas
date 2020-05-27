import java.io.*;
import java.util.*;
class minimum_cost_for_jobs_iterative {
	public static int minCost(int cost[][], int dp[], int n, int p) {

		for(int mask = 0; mask<=(1<<n)-2; mask++) {
			int setBits = countSetBits(mask);
			for(int j = 0; j<n; j++) {
				if((mask&(1<<j)) == 0) {
					dp[mask | (1<<j)] = Math.min(dp[mask | (1<<j)], cost[setBits][j] + dp[mask]);
				}
			}
		}
		return dp[(1<<n)-1];
	}
	public static int countSetBits(int mask) {
		int count = 0;
		while(mask!=0){
			count++;
			mask = (mask&(mask-1));
		}
		return count;
	}
	public static void main(String[] args) {
		int p = 4;
		int n = 4;
		int cost[][] = {{10, 2, 6, 5}, {1, 15, 12, 8}, {7, 8, 9, 3}, {15, 13, 4, 10}};
		int dp[] = new int[(1<<n)];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		System.out.println(minCost(cost, dp, n, p));
	}
}
import java.util.*;
import java.io.*;
class KCON
{
	static long Kadane(int a[], int n)
	{
		long cur_sum = 0, max_sum = Integer.MIN_VALUE;
		for(int i = 0; i<n; i++)
		{
			cur_sum += a[i];
			if(max_sum < cur_sum)
				max_sum = cur_sum;
			if(cur_sum < 0)
				cur_sum = 0;
		}
		return max_sum;
	}
	static long max_sum_subarray(int a[], int n, int k)
	{
		long Kadane_sum = Kadane(a, n);
		if(k == 1)
			return Kadane_sum;
		long prefix_sum = 0, max_prefix_sum = Integer.MIN_VALUE, suffix_sum = 0, max_suffix_sum = Integer.MIN_VALUE, total_sum = 0;
		for(int i = 0; i<n; i++)
		{
			prefix_sum += a[i];
			max_prefix_sum = Math.max(prefix_sum, max_prefix_sum);
		}
		for(int i = n-1; i>=0; i--)
		{
			suffix_sum += a[i];
			max_suffix_sum = Math.max(suffix_sum, max_suffix_sum);
		}
		total_sum = prefix_sum;
		if(total_sum < 0)
			return Math.max(max_suffix_sum + max_prefix_sum, Kadane_sum);
		else
			return Math.max(max_suffix_sum + max_prefix_sum + (total_sum * (k-2)), Kadane_sum);
	}
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0)
		{
			int n = sc.nextInt();
			int k = sc.nextInt();
			int a[] = new int[n];
			for(int i = 0; i < n; i++)
				a[i] = sc.nextInt();
			System.out.println(max_sum_subarray(a, n, k));
			t--;
		}
	}
}
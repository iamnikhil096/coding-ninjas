import java.util.*;
class trieNode {
	trieNode left;
	trieNode right;
	public trieNode() {
		left = null;
		right = null;
	}
}
class maximum_xor_pair {
	public static void insert(int value, trieNode head)
	{
		trieNode cur = head;
		for(int i = 31; i>=0; i--)
		{
			int bit = (value >> i) & 1;
			if(bit == 0)
			{
				if(cur.left == null)
				{
					cur.left = new trieNode();
				}
				cur = cur.left;
			} else {
				if(cur.right == null)
				{
					cur.right = new trieNode();
				}
				cur = cur.right;
			}
		}
	}
	public static int findMax(int a[], int n, trieNode head)
	{
		int max_xor = Integer.MIN_VALUE;
		for(int i = 0; i<n; i++)
		{
			int value = a[i];
			trieNode cur = head;
			int xor_pair = 0;
			for(int j = 31; j>=0; j--)
			{
				int bit = (value>>j) & 1;
				if(bit == 0) {
					//bcz (0^1) = 1 so,  we get the maximum value by going right.
					if(cur.right != null) {
						xor_pair += (1<<j);
						cur = cur.right; 
					} else {
						cur = cur.left;
					}
				} else {
					//bcz (1^0) = 1 so,  we get the maximum value by going right.
					if(cur.left != null) {
						xor_pair += (1<<j);
						cur = cur.left;
					} else {
						cur = cur.right;
					}
				}
			}
			max_xor = Math.max(xor_pair, max_xor);
		}
		return max_xor;
	}
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		for(int i = 0; i<n; i++)
			a[i] = sc.nextInt();
		trieNode head = new trieNode();
		for(int i = 0; i<n; i++)
		{
			insert(a[i], head);
		}
		System.out.println(findMax(a, n, head));
	}
}
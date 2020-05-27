import java.io.*;
import java.util.*;
class Lazy_propagation_min_in_a_range_example {
	public static void buildTree(int a[], int t[], int s, int e, int i) {
		if(s == e) {
			t[i] = a[s];
			return;
		}
		int mid = s + (e-s)/2;
		buildTree(a, t, s, mid, 2*i);
		buildTree(a, t, mid+1, e, 2*i + 1);
		t[i] = Math.min(t[2*i], t[2*i + 1]);
		return;
	}
	public static void updateTreeLazy(int t[], int lazy[], int s, int e, int leftR, int rightR, int i, int updateFactor) {
		if(s > e) {
			return;
		}
		if(lazy[i] != 0) {
			//if there is an update needed for this particular node then update this node and tell its immediate child to remember updates for its child nodes.
			t[i] += lazy[i];
			if(s != e) {
				//this means this node is not a leaf.
				lazy[2*i] += lazy[i];
				lazy[2*i + 1] += lazy[i];
			}
			lazy[i] = 0;
		}
		//now we need to check for completely outside the range.
		if(leftR > e || rightR < s) {
			return;
		}
		//else check for completely inside the range.
		if(s>=leftR && e<=rightR) {
			t[i] += updateFactor;
			if(s != e) {
				lazy[2*i] += updateFactor;
				lazy[2*i + 1] += updateFactor;
			}
			return;
		}
		int mid = s + (e-s)/2;
		updateTreeLazy(t, lazy, s, mid, leftR, rightR, 2*i, updateFactor);
		updateTreeLazy(t, lazy, mid+1, e, leftR, rightR, 2*i + 1, updateFactor);
		t[i] = Math.min(t[2*i], t[2*i + 1]);
	}
	public static int queryTree(int lazy[], int t[], int s, int e, int leftR, int rightR, int i) {
		if(s > e) {
			return Integer.MAX_VALUE;
		}
		if(lazy[i] != 0) {
			//if there is an update needed for this particular node then update this node and tell its immediate child to remember updates for its child nodes.
			t[i] += lazy[i];
			if(s != e) {
				//this means this node is not a leaf.
				lazy[2*i] += lazy[i];
				lazy[2*i + 1] += lazy[i];
			}
			lazy[i] = 0;
		}
		if(leftR>e || rightR<s) {
			//completely outside range.
			return Integer.MAX_VALUE;
		}
		if(s >= leftR && e <= rightR) {
			//completely inside the range.
			return t[i];
		}
		int mid = s + (e-s)/2;
		int ans1 = queryTree(lazy, t, s, mid, leftR, rightR, 2*i);
		int ans2 = queryTree(lazy, t, mid+1, e, leftR, rightR, 2*i + 1);
		return Math.min(ans1, ans2);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		for(int i = 0; i<n; i++) {
			a[i] = sc.nextInt();
		}
		int t[] = new int[4*n];
		int lazy[] = new int[4*n];
		System.out.println(Arrays.toString(t));
		buildTree(a, t, 0, n-1, 1);
		System.out.println(Arrays.toString(t));
		updateTreeLazy(t, lazy, 0, n-1, 0, n-1, 1, 3);
		System.out.println(Arrays.toString(t));
		updateTreeLazy(t, lazy, 0, n-1, 1, 3, 1, 2);
		System.out.println(Arrays.toString(t));
		System.out.println(queryTree(lazy, t, 0, n-1, 1, 5, 1));
		System.out.println(queryTree(lazy, t, 0, n-1, 3, 7, 1));
		System.out.println(queryTree(lazy, t, 0, n-1, 6, 7, 1));
		System.out.println(queryTree(lazy, t, 0, n-1, 0, 1, 1));
	}
}
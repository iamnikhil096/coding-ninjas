import java.util.*;
class trieNode {
    trieNode left;
    trieNode right;
    int leaf;
    public trieNode() {
        left = null;
        right = null;
        leaf = 0;
    }
}
class Xor_Subarrays_less_than_K {
    public static void insert(int v, trieNode cur) {
        for(int i = 31; i>=0; i--) {
            int bit = (v>>i)&1;
            if(bit == 0) {
                if(cur.left == null) {
                    cur.left = new trieNode();
                }
                cur.leaf += 1;
                cur = cur.left;
            }else {
                if(cur.right == null) {
                    cur.right = new trieNode();
                }
                cur.leaf += 1;
                cur = cur.right;
            }
        }
        cur.leaf += 1; // this is for the leaf node.
    }
    public static long calcSubarray(int v, int k, trieNode head) {
        trieNode cur = head;
        long count = 0;
        for(int i = 31; i>=0; i--) {
            int bitK = (k>>i)&1;
            int bitV = (v>>i)&1;
            if(bitK == 1 && bitV == 1) {
                if(cur.right!=null)
                    count += cur.right.leaf;
                if(cur.left!=null)
                    cur = cur.left;
                else
                    return count;
            }else if(bitK == 1 && bitV == 0) {
                if(cur.left!=null)
                    count += cur.left.leaf;
                if(cur.right!=null)
                    cur = cur.right;
                else
                    return count;
            }else if(bitK == 0 && bitV == 1) {
                if(cur.right != null)
                    cur = cur.right;
                else
                    return count;
            }else {
                if(cur.left != null)
                    cur = cur.left;
                else
                    return count;
            }
        }
        return count;
    }
    public static long subXor(int a[], int n, int k, trieNode head) {
        int xorValue = 0;
        long count = 0;
        for(int i = 0; i<n; i++)
        {
            insert(xorValue, head);
            
            xorValue = xorValue^a[i];
            count += calcSubarray(xorValue, k, head);
            //System.out.println("    "+count);
        }
        return count;
    }
	public static void main(String[] args) {
		// Write your code here
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int a[] = new int[n];
            for(int i = 0; i<n; i++)
                a[i] = sc.nextInt();
            trieNode head = new trieNode();
            System.out.println(subXor(a, n, k, head));
        }
	}
}
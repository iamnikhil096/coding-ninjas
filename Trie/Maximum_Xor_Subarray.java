import java.util.*;
class trieNode {
    trieNode left;
    trieNode right;
    public trieNode() {
        left = null;
        right = null;
    }
}
class Maximum_Xor_Subarray {
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
    public static int maxSubarray(int a[], int n, trieNode head) {
        int xor = 0;
        int max_so_far = Integer.MIN_VALUE;
        insert(0, head);
        for(int i = 0; i<n; i++)
        {
            xor = xor ^ a[i];
            //find max.
            trieNode cur = head;
            int max_xor = 0;
            for(int j = 31; j>=0; j--)
            {
                int bit = (xor>>j)&1;
                if(bit == 0)
                {
                    if(cur.right != null)
                    {
                        max_xor += (1<<j);
                        cur = cur.right;
                    }
                    else
                    {
                        cur = cur.left;
                    }
                }
                else
                {
                    if(cur.left != null)
                    {
                        max_xor += (1<<j);
                        cur = cur.left;
                    }
                    else
                    {
                        cur = cur.right;
                    }
                }
            }
            insert(xor, head);
            max_so_far = Math.max(max_so_far, max_xor);
        }
        return max_so_far;
    }
    public static void main(String[] args) {
        // Write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i = 0; i<n; i++)
            a[i] = sc.nextInt();
        trieNode head = new trieNode();
        System.out.println(maxSubarray(a, n, head));
    }
}
import java.util.*;
class trieNode {
    trieNode alpha[];
    int weight;
    public trieNode() {
        alpha = new trieNode[26];
        for(int i = 0; i<26; i++)
            alpha[i] = null;
        weight = 0;
    }
}
class Search_engine_problem {
    public static void insert(String s, int w, trieNode head) {
        int l = s.length();
        trieNode cur = head;
        for(int i = 0 ; i<l; i++) {
            char ch = s.charAt(i);
            int j = ch-97;
            if(cur.alpha[j] == null) {
                cur.alpha[j] = new trieNode();
            }
            cur = cur.alpha[j];
            if(w > cur.weight)
                cur.weight = w;
        }
    }
    public static int query(String s, trieNode head) {
        trieNode cur = head;
        int l = s.length();
        int w = 0;
        for(int i = 0; i<l; i++) {
            char ch = s.charAt(i);
            int j = ch-97;
            if(cur.alpha[j] == null)
                return -1;
            else {
                cur = cur.alpha[j];
                w = cur.weight;
            }
        }
        return w;
    }
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        trieNode head = new trieNode();
        while(n-- > 0) {
            String s = sc.next();
            int w = sc.nextInt();
            insert(s, w, head);
        }
        while(q-- > 0) {
            String s = sc.next();
            int ans = query(s, head);
            System.out.println(ans);
        }
    }
}
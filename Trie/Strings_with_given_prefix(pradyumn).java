import java.util.*;
import java.io.*;
class trieNode {
    trieNode a[];
    boolean terminal[];
    public trieNode() {
        a = new trieNode[26];
        terminal = new boolean[26];
    }
}
class Strings_with_given_prefix {
    public static void insert(String s, trieNode head) {
        trieNode cur = head;
        int l = s.length();
        int i;
        for(i = 0; i<l-1; i++){
            char ch = s.charAt(i);
            int j = ch-'a';
            if(cur.a[j] == null) {
                cur.a[j] = new trieNode();
            }
            cur = cur.a[j];
        }
        char ch = s.charAt(i);
        int j = ch-'a';
        cur.terminal[j] = true;//this node is a terminl node i.e. here a particular word ends.
    }
    public static void dfs(String pre, trieNode node, ArrayList<String> l) {
        if(node == null)
            return;
        for(int i = 0; i<26; i++) {
            if(node.a[i] != null && node.terminal[i] == false) {
                char ch = (char)('a'+i);
                dfs(pre+Character.toString(ch), node.a[i], l);
            } else if(node.a[i] == null && node.terminal[i] == true) {
                char ch = (char)('a'+i);
                l.add(pre+Character.toString(ch));
            } else if(node.a[i] != null && node.terminal[i] == true) {
                char ch = (char)('a'+i);
                l.add(pre+Character.toString(ch));
                dfs(pre+Character.toString(ch), node.a[i], l);
            }
        }
        return;
    }
    public static ArrayList<String> query(String s, trieNode head) {
        trieNode cur = head;
        int len = s.length();
        ArrayList<String> l = new ArrayList<String>();
        int i;
        for(i = 0; i<len-1; i++)
        {
            int j = s.charAt(i) - 'a';
            if(cur.a[j] == null) {
                return l;
            }
            cur = cur.a[j];
        }
        int j = s.charAt(i) - 'a';
        if(cur.a[j] == null && cur.terminal[j] == false) {
            return l;
        } else if(cur.a[j] == null && cur.terminal[j] == true) {
            l.add(s); // this means there is only 1 string ending here.
            return l;
        } else if(cur.terminal[j] == true) {
            l.add(s); // this means there is 1 string ending here but there are more strings with this as prefix.
        }
        cur = cur.a[j];
        dfs(s, cur, l);
        return l;
    }
	public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        trieNode head = new trieNode();
        while(n-- > 0) {
            String s = br.readLine().trim();
            insert(s, head);
        }
        int q = Integer.parseInt(br.readLine().trim());
        while(q-- > 0) {
            String s = br.readLine().trim();
            ArrayList<String> l = new ArrayList<String>();
            l = query(s, head);
            if(l.size() == 0){
                System.out.println("No suggestions");
                insert(s, head);
            }
            else {
                //Collections.sort(l);
                for(int i = 0; i<l.size(); i++) {
                    System.out.println(l.get(i));
                }
            }
        }
	}
}
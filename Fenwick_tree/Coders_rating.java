import java.util.*;
import java.io.*;
class coder {
    int index;
    int x;
    int y;
    public coder(int i, int x, int y) {
        index = i;
        this.x = x;
        this.y = y;
    }
}
class Coders_rating {
    public static int query(int i, int bit[]) {
        int count = 0;
        for( ; i>0; i -= (i &(-i))) {
            count = count + bit[i];
        }
        return count;
    }
    public static void update(int i, int bit[]) {
        for( ; i<=300000; i += (i&(-i))) {
            bit[i]++;
        }
    }
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<coder> li = new ArrayList<coder>(n);
        for(int i = 0; i<n;i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            coder obj = new coder(i, x, y);
            li.add(obj);
        }
        Collections.sort(li, new Comparator<coder>() {
            public int compare(coder c1, coder c2) {
                if(c1.x == c2.x) {
                    if(c1.y == c2.y)
                        return -1; //no swap.
                    return c1.y - c2.y; //swap in assending order of Y.
                }
                return c1.x - c2.x; //else arrange in assending order of X.
            }
        });
        int bit[] = new int[300001];
        int ans[] = new int[n];
        for(int i = 0; i<n; ) {
            int endIndex = i;
            while(endIndex < n && li.get(i).x == li.get(endIndex).x && li.get(i).y == li.get(endIndex).y) {
                endIndex++; // for all the coders whose X and Y both ratings are equal, they all will have same answer to query,
                			// but each of them will contribute (1) to the answer.
            }
            for(int j = i; j<endIndex; j++) {
                ans[li.get(j).index] = query(li.get(j).y, bit);
            }
            for(int j = i; j<endIndex; j++) {
                update(li.get(j).y, bit);
            }
            i = endIndex; // now i is pointing to the index just after that 
        }
        for(int i = 0; i<n; i++) {
            System.out.println(ans[i]);
        }
	}
}
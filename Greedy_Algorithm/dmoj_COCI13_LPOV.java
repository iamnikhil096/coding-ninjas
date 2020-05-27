import java.io.*;
import java.util.*;
class jwellery {
	int mass, value;
	public jwellery(int m, int v) {
		mass = m; 
		value = v;
	}
}
class dmoj_COCI13_LPOV {
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		int n = sc.nextInt();
		int k = sc.nextInt();
		ArrayList<jwellery> al = new ArrayList<jwellery>(n);
		for(int i = 0; i<n; i++) {
			int m = sc.nextInt();
			int v = sc.nextInt();
			jwellery ob = new jwellery(m, v);
			al.add(ob);
		}
		Collections.sort(al, new Comparator<jwellery>() {
			public int compare(jwellery j1, jwellery j2) {
				if(j1.value < j2.value)  {
					return 1;
				}
				return -1;
			}
		});
		ArrayList<Integer> bags = new ArrayList<Integer>(k);
		for(int i = 0; i<k; i++) {
			int x = sc.nextInt();
			bags.add(x);
		}
		Collections.sort(bags);
		long ans = 0;
		for(int i = 0; i<n; i++) {
			if(bags.isEmpty() == false) {
				int upper_bound = Collections.binarySearch(bags, al.get(i).mass);
				if(upper_bound < 0) {
					upper_bound = Math.abs(upper_bound) - 1;
					if(upper_bound < k && upper_bound >= 0) {
						// we found a bag.
						ans += (long)al.get(i).value;
						bags.remove(upper_bound);
						k--;
					}
				}else {
					ans += (long)al.get(i).value;
					bags.remove(upper_bound);
					k--;
				}
			}else {
				break;
			}
		}
		System.out.println(ans);
	}
	static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 
  
        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 
  
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    }
}
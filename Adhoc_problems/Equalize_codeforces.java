import java.io.*;
import java.util.*;
public class Equalize_codeforces {
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		int n = sc.nextInt();
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();
		int cost = 0;
		for(int i = 0; i<n; i++) {
			if(s1.charAt(i) != s2.charAt(i)) {
				//to decide wheteher to flip or swap with the very next char, as swapping with any other chaharacter will cost more.
				if((i!=n-1) && (s1.charAt(i+1)!=s1.charAt(i) && s1.charAt(i+1)!=s2.charAt(i+1))) {
					//swap.
					cost += 1;
					i += 1;
				}else {
					//flip.
					cost += 1;
				}
			}
		}
		System.out.println(cost);
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
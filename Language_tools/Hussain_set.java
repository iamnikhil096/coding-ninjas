import java.io.*;
import java.util.*;
class Hussain_set
{
	public static void main(String[] args) throws IOException{ 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n, m;
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		long a[] = new long[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<n; i++)
			a[i] = Long.parseLong(st.nextToken());
		Queue<Long> q = new LinkedList<>();
		Arrays.sort(a);
		int c = 0, end = n-1;
		long max = 0;
		while(m > 0)
		{
			int t = Integer.parseInt(br.readLine());
			while(c < t)
			{
				if(end >= 0 && (q.peek() == null || a[end] >= q.peek()))
				{
					max = a[end];					
					end--;
				}
				else
				{
					max = q.remove();
				}
				q.add(max/2);
				c++;
			}
			System.out.println(max);
			m--;
		}
		/*FastReader s = new FastReader();
		int n, m;
		n = s.nextInt();
		m = s.nextInt();
		long a[] = new long[n];
		for(int i = 0; i<n; i++)
			a[i] = s.nextLong();
		Queue<Long> q = new LinkedList<>();
		Arrays.sort(a);
		int c = 0, end = n-1;
		long max = 0;
		while(m > 0)
		{
			int t = s.nextInt();
			while(c < t)
			{
				if(end >= 0 && (q.peek() == null || a[end] >= q.peek()))
				{
					max = a[end];					
					end--;
				}
				else
				{
					max = q.remove();
				}
				q.add(max/2);
				c++;
			}
			System.out.println(max);
			m--;
		}*/
	}
/*
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
    } */
}
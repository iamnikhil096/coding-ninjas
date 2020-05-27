import java.io.*;
import java.util.*;
class Sudoku_Codechef_AX06 {
	public static boolean possible_to_fill(int k, int i, int j, int b[][]) {
		int row = i, col = j;
		for(int l = 0; l<9; l++) {
			if(b[row][l] == k)
				return false;
		}
		for(int l = 0; l<9; l++) {
			if(b[l][col] == k)
				return false;
		}
		int grid_row = (i/3)*3;
		int grid_col = (j/3)*3;
		int l = grid_row;
		for( ; l<grid_row+3; l++) {
			int m = grid_col;
			for( ; m<grid_col+3; m++) {
				if(b[l][m] == k)
					return false;
			}
		}
		return true;
	}
	public static boolean solve(int b[][], int i, int j) {
		if(i == 8 && j >= 9)
			return true;
		if(j >= 9) {
			j = 0;
			i += 1;
		}
		if(b[i][j] == 0) {
			int k = 1;
			while(k <= 9) {
				if(possible_to_fill(k, i, j, b) == true) {
					b[i][j] = k;
					if(solve(b, i, j+1) == true) {
						break;
					}
					b[i][j] = 0;
				}
				k++;
			}
			if(k > 9) {
				return false;
			}
			return true;
		}
		return solve(b, i, j+1);
	}
	public static void print_sudoku_board(int b[][]) {
		for(int i = 0; i<9; i++) {
			for(int j = 0; j<9; j++)
				System.out.print(b[i][j]);
			System.out.println();
		}
	}
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		int b[][] = new int[9][9];
		for(int i = 0; i<9; i++) {
			String in = sc.nextLine();
			for(int j = 0; j<9; j++) {
				int x = in.charAt(j) - 48;
				b[i][j] = x;
			}
		}
		solve(b, 0, 0);
		print_sudoku_board(b);
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
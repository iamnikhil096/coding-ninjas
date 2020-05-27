import java.io.*;
import java.util.*;
//the complexity of this algorithm is : O(N + M).
	// To get Longest Prefix that is also a Suffix it takes : O(M) time,
	// while to search the pattern int the given Text string using the LPS[] array it takes : O(N) time.  
class KMP {
	public static void getLPS(String pattern, int LPS[]) {
		int j = 0, i = 1;
		int n = pattern.length();
		LPS[0] = 0;
		while(i<n) {
			if(pattern.charAt(i) == pattern.charAt(j)) {
				LPS[i] = j+1;
				j++; i++;
			}else {
				if(j == 0) {
					LPS[i] = 0;
					i++;
				} else {
					j = LPS[j-1];
				}	
			}
		}
	}
	public static boolean KMP_Search(String s, String pattern) {
		int n = s.length();
		int m = pattern.length();
		int i = 0, j = 0;
		//first calculate the LONGEST PREEFIX SUFFIX ARRAY for the Pattern string.
		int LPS[] = new int[m];
		getLPS(pattern, LPS);
		while(i<n && j<m) {
			if(s.charAt(i) == pattern.charAt(j)) {
				i++;
				j++;
			}else {
				//if this char is not same then we check for the longest prefix of pattern string 
					//that we have already encountered ending at this char in the given text string.
				if(j != 0) {
					j = LPS[j-1];
				}else {
					// if (j == 0) then we just increment i as no prefix of pattern string exists at this index in text string.
					i++;
				}
			}
		}
		if(j == m) {
			// if we have reached the end of pattern sting that means, we have found an occurence of the pattern string in the given text string.
			return true;
		}
		//else.
		return false;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String pattern = sc.nextLine();
		System.out.println(KMP_Search(s, pattern));
	}
}
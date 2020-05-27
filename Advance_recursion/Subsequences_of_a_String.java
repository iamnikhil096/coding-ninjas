import java.io.*;
import java.util.*;
class Subsequences_of_a_String {
	//abc
	public static int subsequence(String s, String output[]) {
		if(s == "") {
			output[0] = "";
			return 1;
		}
		String sub = (s.length() == 1)? "" : s.substring(1);
		int len = subsequence(sub, output);
		for(int i = 0; i<len; i++) {
			output[len+i] = s.charAt(0) + output[i];
		}
		return 2*len; // since we are traversing the array and appending first charcter of substring to each element and storing it in another 
					//index therefore twice the size of array elements.
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int n = s.length();
		String output[] = new String[1<<n];
		int len = subsequence(s, output);
		for(int i = 0; i<len; i++) {
			System.out.println(output[i]);
		}
	}
}
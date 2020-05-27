import java.io.*;
import java.util.*;
class Diophantine_Triplet {
	int x;
	int y;
	int gcd;
	public Diophantine_Triplet() {
		x = 0;
		y = 0;
		gcd = 0;
	}
}
public class extendedEuclidAlgorithm {
	public static Diophantine_Triplet extendedEuclid(int a, int b) {
		if(b == 0) {
			//base case is reached.
			Diophantine_Triplet ans = new Diophantine_Triplet();
			ans.x = 1;
			ans.y = 0;
			ans.gcd = a;
			return ans;
		}
		Diophantine_Triplet smallAns = extendedEuclid(b, a%b);
		Diophantine_Triplet ans = new Diophantine_Triplet();
		ans.x = smallAns.y;
		ans.y = smallAns.x - (a/b)*smallAns.y;
		//since gcd remains same for the whole equation;
		ans.gcd = smallAns.gcd;
		return ans;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		// Extended Euclid algorithm is used to calculate the gcd of (a & b) for which (ax + by = c) holds, it also returns the value of the
			//coefficients of a & b for which gcd(a, b) divides c.
		Diophantine_Triplet answer = extendedEuclid(a, b);
		System.out.println(answer.x + "	" + answer.y + "	" + answer.gcd);
	}
}
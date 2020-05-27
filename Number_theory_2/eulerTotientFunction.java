import java.io.*;
import java.util.*;
class eulerTotientFunction {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int phi[] = new int[n+1];
		for(int i = 1; i<=n; i++) {
			phi[i] = i;
		}
		phi[0] = 0;
		for(int i = 2; i<=n; i++) {
			if(phi[i] == i) {
				phi[i] -= 1; 
				for(int j = 2*i; j<=n; j += i) {
					phi[j] = phi[j] * (i - 1)/i;
				}
			}
		}
		for(int i = 1; i<=n; i++) {
			System.out.print(" i : "+phi[i]+"  ");
		}
		System.out.println();
	}
}
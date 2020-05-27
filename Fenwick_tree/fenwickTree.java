import java.io.*;
import java.util.*;
class fenwickTree {
	public static void update(int index, int value, int BIT[], int n) {
		//whenever we perform an update on any node then we done go to its children, but to another node that is not its childen and whose ibdex is more.
			//same is followed till we reach t the end of the BIT[] array.
		for( ; index<=n; index += (index&(-index))) {
			BIT[index] += value;
		}
	}
	public static int query(int index, int BIT[]) {
		int sum = 0;
		for( ; index>0; index -= (index&(-index))) {
			sum += BIT[index];
		}
		return sum;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n+1]; // for simplicity of calculations we keep the original array of (n+1) size and we start our index from 1.
		int BIT[] = new int[n+1]; //(n+1) because our indexing starts from 1.
		for(int i = 1; i<=n; i++) {
			a[i] = sc.nextInt();
			update(i, a[i], BIT, n);
		}
		System.out.println("Sum of First 5 elements : "+query(5, BIT));
		System.out.println("Sum of elements from 2 to 6 index is : "+(query(6, BIT)-query(1, BIT)));
	}
}





// import java.io.*;
// import java.util.*;
// class fenwickTree {
// 	public static void update(int index, int value, int BIT[], int n) {
// 		for( ; index<=n; index += index & (-index)) {
// 			BIT[index] += value;
// 		}
// 	}
// 	public static int query(int index, int BIT[]) {
// 		int sum = 0;
// 		for( ; index > 0; index -= index & (-index)) {
// 			sum += BIT[index];
// 		}
// 		return sum;
// 	}
// 	public static void main(String[] args) {
// 		Scanner sc = new Scanner(System.in);
// 		int n = sc.nextInt();
// 		int a[] = new int[on+1];
// 		int BIT[] = new int[n+1];
// 		for(int i = 1; i<=n; i++) {
// 			a[i] = sc.nextInt();
// 			update(i, a[i], BIT, n);
// 		}
// 		System.out.println("from 0 to 6 " + query(6, BIT));
// 		System.out.println("from 2 to 7 " + (query(7, BIT) - query(2, BIT)));
// 	}
// }
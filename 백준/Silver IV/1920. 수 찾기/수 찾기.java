import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		arr = new int[N];
		for(int i = 0 ; i < N ; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		int M = sc.nextInt();
		for(int i = 0 ; i < M ; i++) {
			System.out.println(binarySerach(sc.nextInt()));
		}
		
	}
	private static int binarySerach(int v) {
		int start = 0, end = arr.length-1, mid;
		while(start <= end) {
			mid = (start + end) / 2;
			if(v == arr[mid]) return 1;
		
			if(v > arr[mid]) start = mid+1;
			else end = mid-1;
		}
		
		return 0;
	}
}

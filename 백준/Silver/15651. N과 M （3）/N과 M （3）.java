import java.util.Scanner;

public class Main {

	static int N,M;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		numbers = new int[M];
		Permutation(0);
		System.out.println(sb);
	}

	static int[] numbers;
	static StringBuilder sb = new StringBuilder();
	private static void Permutation(int cnt) {
		if(cnt==M) {
			for(int i = 0 ; i < M ; i++) {
				sb.append(numbers[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for(int i = 1 ; i <= N ; i++) {
			numbers[cnt] = i;
			Permutation(cnt+1);
		}
	}

}

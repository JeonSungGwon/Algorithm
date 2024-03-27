import java.util.Scanner;

public class Solution {
	static int N;
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1 ; tc<=T ; tc++) {
			N = sc.nextInt();
			arr = new int[N];
			
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			int[] dp = new int[N];
			int max = 1;
			
			for (int i = 0; i < N; i++) {
				dp[i] = 1;
				for (int j = 0; j < i; j++) {
					if (arr[j] < arr[i]) {
						dp[i] = Math.max(dp[i], dp[j] + 1);
					}
				}
				max = Math.max(max, dp[i]);
			}
			System.out.println("#" + tc + " " + max);
		}
	}
}
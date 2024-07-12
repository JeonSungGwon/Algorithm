import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
	static int[][] dp;
	static final int MOD = 10007;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			arr.add(new ArrayList<Integer>());
		}
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				int a = Integer.parseInt(st.nextToken());
				arr.get(i).add(a);
			}
		}

		dp = new int[N + 1][H + 1];
		dp[0][0] = 1;
		
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j <= H; j++) {
				dp[i][j] = dp[i - 1][j];
				for (int v : arr.get(i - 1)) {
					if (j >= v) {
						dp[i][j] = (dp[i][j] + dp[i - 1][j - v]) % MOD;
					}
				}
			}
		}

		System.out.println(dp[N][H]);
	}
}

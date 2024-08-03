import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc = 0; tc < T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            int[] sum = new int[N+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                sum[i+1] = sum[i] + arr[i];
            }
            int[][] dp = new int[N][N];
            for(int len = 1; len < N; len++) {
                for(int i = 0; i + len < N; i++) {
                    int j = i + len;
                    dp[i][j] = Integer.MAX_VALUE;
                    for(int k = i; k < j; k++) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k+1][j] + sum[j+1] - sum[i]);
                    }
                }
            }
            System.out.println(dp[0][N-1]);
        }
    }
}

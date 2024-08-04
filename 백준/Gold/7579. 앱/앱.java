import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] memory;
    static int[] cost;
    static int N, M;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dp = new int[N + 1][10001];
        memory = new int[N];
        cost = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int j = 0 ; j < N ; j++){
            memory[j] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int j = 0 ; j < N ; j++){
            cost[j] = Integer.parseInt(st.nextToken());
        }

        knapsack();
        System.out.println(result);
    }
    static int result = Integer.MAX_VALUE;
    private static void knapsack() {
        for (int i = 0; i < N; i++) {
            int cost_v = cost[i];
            int memory_v = memory[i];

            for (int j = 0; j <= 10000; j++) {
                if (i == 0) {
                    if (j >= cost_v) dp[i][j] = memory_v;
                } else {
                    if (j >= cost_v) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - cost_v] + memory_v);
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
                if (dp[i][j] >= M) {
                    result = Math.min(result, j);
                }
            }
        }
    }
}

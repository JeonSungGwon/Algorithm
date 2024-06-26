import java.io.*;
import java.util.*;
public class Main {
    static int[][] schedule;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        schedule = new int[N + 1][2];
        dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            schedule[i][0] = Integer.parseInt(st.nextToken());
            schedule[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            int time = schedule[i][0], price = schedule[i][1];

            if (i + time - 1 <= N) {
                dp[i + time - 1] = Math.max(dp[i + time - 1], dp[i - 1] + price);
            }
            
            dp[i] = Math.max(dp[i], dp[i - 1]);

        }
        System.out.println(dp[N]);
    }
}

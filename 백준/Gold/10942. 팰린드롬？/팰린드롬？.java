import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] nums;
    static boolean[][] dp;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        nums = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        dp = new boolean[n+1][n+1];

        preprocess();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (dp[a][b]) {
                sb.append(1).append('\n');
            } else {
                sb.append(0).append('\n');
            }
        }
        System.out.println(sb);
    }

    private static void preprocess() {
        for (int i = 1; i <= n; i++) {
            dp[i][i] = true; // 길이가 1인 경우
        }

        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i+1]) {
                dp[i][i+1] = true; // 길이가 2인 경우
            }
        }

        for (int length = 3; length <= n; length++) { // 길이가 3 이상인 경우
            for (int start = 1; start <= n - length + 1; start++) {
                int end = start + length - 1;
                if (nums[start] == nums[end] && dp[start+1][end-1]) {
                    dp[start][end] = true;
                }
            }
        }
    }
}

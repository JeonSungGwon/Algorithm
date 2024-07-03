import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] board;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            board = new int[2][N+1];
            dp = new int[2][N+1];
            for(int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 1; j <= N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            dp[0][1] = board[0][1];
            dp[1][1] = board[1][1];

            for(int i = 2; i <= N; i++) {
                dp[0][i] = Math.max(board[0][i]+dp[1][i-1], board[0][i]+dp[1][i-2]);
                dp[1][i] = Math.max(board[1][i]+dp[0][i-1], board[1][i]+dp[0][i-2]);
            }

            int result = Math.max(dp[0][N], dp[1][N]);
            System.out.println(result);
        }
    }
}

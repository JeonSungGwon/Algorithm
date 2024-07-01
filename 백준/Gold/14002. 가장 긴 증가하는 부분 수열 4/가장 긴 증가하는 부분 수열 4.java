import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int[] board;
    static ArrayList<Integer>[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        board = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int index = 0;
        while (st.hasMoreTokens()) {
            board[index] = Integer.parseInt(st.nextToken());
            index++;
        }

        dp = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            dp[i] = new ArrayList<>();
        }

        dp[0].add(board[0]);

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (board[j] < board[i] && dp[i].size() < dp[j].size() + 1) {
                    dp[i] = new ArrayList<>(dp[j]);
                }
            }
            dp[i].add(board[i]);
        }

        ArrayList<Integer> lis = dp[0];
        for (int i = 1; i < N; i++) {
            if (lis.size() < dp[i].size()) {
                lis = dp[i];
            }
        }

        System.out.println(lis.size());
        for (int num : lis) {
            System.out.print(num + " ");
        }
    }
}

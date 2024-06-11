import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] board;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        board = new int[N+1][3];
        for(int i = 1; i <= N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
 
        int[][] minDp = new int[N+1][3];
        int[][] maxDp = new int[N+1][3];
        for(int i = 1; i <= N; i++) {
            maxDp[i][0] += Math.max(maxDp[i - 1][0], maxDp[i - 1][1]) + board[i][0];
            maxDp[i][1] += Math.max(Math.max(maxDp[i - 1][0], maxDp[i - 1][1]), maxDp[i - 1][2]) + board[i][1];
            maxDp[i][2] += Math.max(maxDp[i - 1][1], maxDp[i - 1][2]) + board[i][2];
            
            minDp[i][0] += Math.min(minDp[i - 1][0], minDp[i - 1][1]) + board[i][0];
            minDp[i][1] += Math.min(Math.min(minDp[i - 1][0], minDp[i - 1][1]), minDp[i - 1][2]) + board[i][1];
            minDp[i][2] += Math.min(minDp[i - 1][1], minDp[i - 1][2]) + board[i][2];
        }
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < 3; i++) {
            min = Math.min(min, minDp[N][i]);
            max = Math.max(max, maxDp[N][i]);
        }
        System.out.println(max + " " + min);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] board;
	static int[][] dpB;
	static final int INF = 1000 * 1000 + 1; // 충분히 큰 수를 사용합니다.
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		board = new int[N+1][3];
		dpB = new int[N+1][3];
		
		for(int i = 1 ; i <= N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < 3 ; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int result = INF;
		
		// 첫 번째 집을 빨강으로 고정하는 경우
		result = Math.min(result, solve(N, 0));
		// 첫 번째 집을 초록으로 고정하는 경우
		result = Math.min(result, solve(N, 1));
		// 첫 번째 집을 파랑으로 고정하는 경우
		result = Math.min(result, solve(N, 2));
		
		System.out.println(result);
	}
	
	static int solve(int N, int firstColor) {
		for(int i = 0; i < 3; i++) {
			if(i == firstColor) {
				dpB[1][i] = board[1][i];
			} else {
				dpB[1][i] = INF;
			}
		}
		
		for(int i = 2; i <= N; i++) {
			dpB[i][0] = Math.min(dpB[i-1][1], dpB[i-1][2]) + board[i][0];
			dpB[i][1] = Math.min(dpB[i-1][0], dpB[i-1][2]) + board[i][1];
			dpB[i][2] = Math.min(dpB[i-1][0], dpB[i-1][1]) + board[i][2];
		}
		
		int minCost = INF;
		for(int i = 0; i < 3; i++) {
			if(i != firstColor) {
				minCost = Math.min(minCost, dpB[N][i]);
			}
		}
		
		return minCost;
	}
}

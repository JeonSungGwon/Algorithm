import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] board;
	static int[][] dMax;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		board = new int[N][];
		dMax = new int[N][];
		for(int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			board[i] = new int[i+1];
			dMax[i] = new int[i+1];
			for(int j = 0 ; j <= i ; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dMax[0][0] = board[0][0];
		for(int i = 1 ; i < N ; i++ ) {
			for(int j = 0 ; j <= i ; j++) {
				if(j-1>=0 && j != i)
				dMax[i][j] = Math.max(board[i][j]+dMax[i-1][j], board[i][j]+dMax[i-1][j-1]);
				else if(j == i){
					dMax[i][j] = board[i][j]+dMax[i-1][j-1];
				}
				else 
					dMax[i][j] = board[i][j]+dMax[i-1][j];
			}
		}
		int max = 0;
		for(int v : dMax[N-1]) {
			if (v > max) {
		        max = v;
		    }
		}
		System.out.println(max);
	}

}

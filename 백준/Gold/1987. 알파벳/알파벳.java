import java.io.*;
import java.util.*;

public class Main {

	
	static int R,C;
	static char[][] board;
	static int[] dx = {0, 1, -1, 0};
	static int[] dy = {1, 0, 0, -1};
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		board = new char[R][C];
		
		for(int i = 0 ; i < R ; i++) {
			String str = br.readLine();
			for(int j = 0 ; j < C ; j++) {
				board[i][j] = str.charAt(j);
			}
		}
		Set<Character> set = new HashSet<Character>();
		set.add(board[0][0]);
		DFS(0,0, set);
		System.out.println(result);
	}
	
	static int result = 0;
	private static void DFS(int i, int j, Set<Character> set) {
		
		if(set.size() > result) {
			result = set.size();
		}
		
		for(int idx = 0 ; idx < 4 ; idx++) {
			int nx = i + dx[idx];
			int ny = j + dy[idx];
			if(nx >= 0 && ny >= 0 && nx < R && ny < C) {
				if (!set.contains(board[nx][ny])) {
				    set.add(board[nx][ny]);
				    DFS(nx, ny, set);
				    set.remove(board[nx][ny]); 
				}

			}
		}
	}

}

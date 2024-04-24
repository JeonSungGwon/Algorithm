import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	
	static int R, C;
	static char[][] map;
	static boolean[][] visited;
	static int startX, startY;
	static int ansX, ansY, tmpX, tmpY;
	static char ansChar;
	static int count = 0;
	static int[] dx = {0, 1, -1, 0};
	static int[] dy = {1, 0, 0, -1};
	static boolean finish = false;
	static char[] arr = {'|', '-', '+', '1', '2', '3', '4'};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new boolean[R][C];
		
		for(int i = 0 ; i < R ; i++) {
			String str = br.readLine();
			for(int j = 0 ; j < C ; j++) {
				map[i][j] = str.charAt(j);
				
				if(map[i][j] == 'M') {
					startX = i;
					startY = j;
				}
				
				if(map[i][j] != 'M' && map[i][j] != 'Z' && map[i][j] !='.') {
					count++;
				}
			}
		}
		count++;
		for(int i = 0 ; i < 4 ; i++) {
			int nx = startX + dx[i];
			int ny = startY + dy[i];
			if(nx<0 || ny<0 || nx>=R || ny>=C) continue;
			dfs(nx, ny, i, 0, true);
		}
		ansX++;
		ansY++;
		System.out.println(ansX + " " + ansY + " " + ansChar);
		
	}
	private static void dfs(int x, int y, int d, int cnt, boolean isBoolean) {
		if(finish) return;
		if(cnt==count) {
			ansX = tmpX;
			ansY = tmpY;
			ansChar = map[ansX][ansY];
			finish = true;
			return;
		}
		
		int nd = change(d, map[x][y]);
		if(nd == -1) return;
		int nx = x + dx[nd];
		int ny = y + dy[nd];
		if(nx<0 || ny<0 || nx>=R || ny>=C) return;
		
		if(map[nx][ny] == '.') {
			if(isBoolean) {
				for(int i = 0 ; i < 7 ; i++) {
					map[nx][ny] = arr[i];
					visited[nx][ny] = true;
					tmpX = nx;
					tmpY = ny;
					dfs(nx, ny, nd, cnt+1, false);
					map[nx][ny] = '.';
					visited[nx][ny] = false;
				}
			}
		}else {
			if(visited[nx][ny]) {
				dfs(nx, ny, nd, cnt, isBoolean);
			}else {
				visited[nx][ny] = true;
				dfs(nx, ny, nd, cnt+1, isBoolean);
				visited[nx][ny] = false;
			}
		}
	}
	
//	static int[] dx = {0, 1, -1, 0};
//	static int[] dy = {1, 0, 0, -1};
	private static int change(int d, char c) {
		if(c == '|') {
			if(d == 1 || d == 2) return d;
		}else if(c == '-') {
			if(d == 0 || d == 3) return d;
		}else if(c == '+') {
			return d;
		}else if(c == '1') {
			if(d == 2) return 0;
			if(d == 3) return 1;
		}else if(c == '2') {
			if(d == 1) return 0;
			if(d == 3) return 2;
		}else if(c == '3') {
			if(d == 0) return 2;
			if(d == 1) return 3;
		}else if(c == '4') {
			if(d == 0) return 1;
			if(d == 2) return 3;
		}
		return -1;
	}
}

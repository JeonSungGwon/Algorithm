import java.io.*;
import java.util.*;

public class Main {

	static char[][] map;
	static Queue<int[]> fire = new ArrayDeque<int[]>();
	static int[] dx = {1, 0 ,0 ,-1};
	static int[] dy = {0, 1, -1, 0};
	static int R, C;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		visited = new boolean[R][C];
		map = new char[R][C];
		int currentX = 0, currentY = 0;
		for(int i = 0 ; i < R ; i++) {
			String str = br.readLine();
			for(int j = 0 ; j < C ; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'F') {
					fire.offer(new int[] {i,j});
				}
				else if(map[i][j] == 'J') {
					currentX = i;
					currentY = j;
				}
			}
		}
		if(currentX == 0 || currentX == R-1 || currentY == 0 || currentY == C-1) {
			System.out.println(result+1);
		}
		else {
			BFS(currentX, currentY, 0);
			if(result == 0) System.out.println("IMPOSSIBLE");
			else System.out.println(result+1);
		}
		
	}
	static boolean[][] visited;
	static int result = 0;
	private static void BFS(int currentX, int currentY, int time) {
		Queue<int[]> queue = new ArrayDeque<int[]>();
		queue.offer(new int[] {currentX, currentY, time});
		visited[currentX][currentY] = true;
		while(!queue.isEmpty()) {
			
			int fireSize = fire.size();
			for(int i = 0 ; i < fireSize ; i++) {
				int[] fArr = fire.poll();
				int fx = fArr[0];
				int fy = fArr[1];
				for(int idx = 0 ; idx < 4 ; idx++) {
					int nfx = fx + dx[idx];
					int nfy = fy + dy[idx];
					if(nfx >= 0 && nfx < R && nfy >= 0 && nfy < C && map[nfx][nfy] != '#' && map[nfx][nfy] != 'F') {
						map[nfx][nfy] = 'F';
						fire.offer(new int[] {nfx,nfy});
					}
				}
			}
			
			int jiSize = queue.size();
			for(int i = 0 ; i < jiSize ; i++) {
				int[] arr = queue.poll();
				int ax = arr[0];
				int ay = arr[1];
				int aTime = arr[2];
				for(int idx = 0 ; idx < 4 ; idx++) {
					int nx = ax + dx[idx];
					int ny = ay + dy[idx];
					if(nx >= 0 && nx < R && ny >= 0 && ny < C && map[nx][ny] == '.' && !visited[nx][ny]) {
						visited[nx][ny] = true;
						queue.offer(new int[] {nx, ny, aTime+1});
						if(nx == 0 || nx == R-1 || ny == 0 || ny == C-1) {
							result = aTime+1;
							return;
						}
					}
				}
			}
		}
		
	}

}

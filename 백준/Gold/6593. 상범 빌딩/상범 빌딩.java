import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static char[][][] map;
	static int[] dz = {0, 0, 0, 0, -1, 1};
	static int[] dx = {0, -1, 1, 0, 0, 0};
	static int[] dy = {1, 0, 0, -1, 0, 0};
	static int L, R, C;
	static int endX, endY, endZ;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		while(L != 0 && R != 0 && C != 0) {
			cnt = Integer.MAX_VALUE;
			map = new char[L][R][C];
			visited = new boolean[L][R][C];
			int startZ=0, startX=0, startY=0;
			for(int i = 0 ; i<L ; i++) {
				for(int j = 0 ; j<R ; j++) {
					String str = br.readLine();
					for(int k = 0 ; k<C ; k++) {
						map[i][j][k] = str.charAt(k);
						if(map[i][j][k] == 'S') {
							startZ = i;
							startX = j;
							startY = k;
						}
						if(map[i][j][k] == 'E') {
							endZ = i;
							endX = j;
							endY = k;
						}
					}
				}
				br.readLine();
			}
			
			BFS(startZ, startX, startY, 0);
			if(cnt == Integer.MAX_VALUE) {
				sb.append("Trapped!").append("\n");
			}else {
				sb.append("Escaped in ").append(cnt).append(" minute(s).").append("\n");
			}
			st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
		}
		System.out.println(sb);
	}
	static boolean[][][] visited;
	static int cnt;
	static StringBuilder sb = new StringBuilder();
	private static void BFS(int startZ, int startX, int startY, int count) {
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.offer(new int[] {startZ, startX, startY, count});
		visited[startZ][startX][startY] = true;
		while(!q.isEmpty()) {
			int[] arr = q.poll();
			int az = arr[0];
			int ax = arr[1];
			int ay = arr[2];
			int c = arr[3];
			if(az == endZ && ax == endX && ay == endY) {
				cnt = Math.min(cnt, c);
			}
			
			for(int i = 0 ; i<6 ; i++) {
				int nz = az + dz[i];
				int nx = ax + dx[i];
				int ny = ay + dy[i];
				
				
				if(nz>=0 && nx>=0 && ny>=0 && nz<L && nx<R && ny<C && !visited[nz][nx][ny] && map[nz][nx][ny] != '#') {
					q.offer(new int[] {nz,nx,ny, c+1});
					visited[nz][nx][ny] = true;
				}
				
				
			}
		}
		
		
	}
}

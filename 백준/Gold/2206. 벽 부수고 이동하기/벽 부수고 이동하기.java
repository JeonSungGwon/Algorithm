import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static int[] dx = {0, 1, -1, 0};
	static int[] dy = {1, 0, 0, -1};
	static int N, M;
	static boolean[][][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[2][N][M];
		arr = new int[N][M];
		for(int i = 0 ; i < N ; i++) {
			String str = br.readLine();
			for(int j = 0 ; j < M ; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		BFS(0, 0, 0, 0);
		System.out.println(result);
		
	}
	static int result = -1;
	private static void BFS(int x, int y, int cnt, int num) {
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.offer(new int[] {x,y,cnt, num});
		visited[0][x][y] = true;
		while(!q.isEmpty()) {
			int list[] = q.poll();
			int ax = list[0];
			int ay = list[1];
			int count = list[2];
			int number = list[3];
			if(ax == N-1 && ay == M-1) {
				result = number + 1;
				break;
			}
			for(int i = 0 ; i < 4 ; i++) {
				int nx = ax + dx[i];
				int ny = ay + dy[i];
				if(nx>=0 && ny>=0 && nx<N && ny<M) {
					if(arr[nx][ny] == 0) {
						if(!visited[count][nx][ny]) {
							q.offer(new int[] {nx,ny, count, number+1});
							visited[count][nx][ny] = true;
						}
					}else if(arr[nx][ny] == 1) {
						if(count == 0 && !visited[count+1][nx][ny]) {
							q.offer(new int[] {nx,ny, count+1, number+1});
							visited[count+1][nx][ny] = true;
						}
					}
				}

		}
		
		}
	}
}

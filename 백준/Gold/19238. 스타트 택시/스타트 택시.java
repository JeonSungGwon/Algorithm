import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static class Destination{
		int startX;
		int startY;
		int endX;
		int endY;
		
		public Destination(int startX, int startY, int endX, int endY) {
			this.startX = startX;
			this.startY = startY;
			this.endX = endX;
			this.endY = endY;
		}

	}
	static int[][] map;
	static int[][] start;
	static int[][] end;
	static Destination[] arr;
	static int[] dx = {-1, 0, 0, 1};
	static int[] dy = {0, -1, 1, 0};
	static int N, M, startGauge, texiX, texiY;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		startGauge = Integer.parseInt(st.nextToken());
		map = new int[N+1][N+1];
		visited = new boolean[N+1][N+1];
		arr = new Destination[M];
		for(int i = 1 ; i <= N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1 ; j <= N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()); 
				
			}
		}
		
		st = new StringTokenizer(br.readLine());
		texiX = Integer.parseInt(st.nextToken());
		texiY = Integer.parseInt(st.nextToken());
		
		
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());
			int endX = Integer.parseInt(st.nextToken());
			int endY = Integer.parseInt(st.nextToken());
			arr[i]= new Destination(startX, startY, endX, endY);
		}
		for(int i = 0 ; i<M ; i++) {
			useGauge = 0;
			goStart(texiX, texiY, 0);
			goEnd(texiX, texiY, 0);
			
		}
		for(int i = 0; i<M ; i++) {
			if(arr[i].startX != -100 || arr[i].startY != -100 || arr[i].endX != -100 || arr[i].endY != -100) {
				startGauge = -1;
			}
		}
		
		System.out.println(startGauge);
	}
		
	
	static boolean[][] visited;
	static int num = 5;
	static int useGauge;
	static boolean isBoolean;
	public static void goStart(int x, int y, int cnt) {
		isBoolean = false;
		Queue<int[]> q = new ArrayDeque<int[]>();
		visited = new boolean[N+1][N+1]; 
		visited[x][y] = true;
		q.offer(new int[] {x, y, cnt});
		int kx = Integer.MAX_VALUE;
		int ky = Integer.MAX_VALUE;
		while(!q.isEmpty()) {
			int qSize = q.size();
			int count = q.peek()[2];
			if(startGauge < count) {
				startGauge = -1;
				break;
			}
			for(int i = 0 ; i<qSize ; i++) {
				int[] texi = q.poll();
				int ax = texi[0];
				int ay = texi[1];
				
				for(int a = 0 ; a < 4 ; a++) {
					int nx = ax + dx[a];
					int ny = ay + dy[a];
					if(nx>=1 && ny>=1 && nx<=N && ny<=N && map[nx][ny] != 1 && !visited[nx][ny]) {
						q.offer(new int[] {nx,ny,count+1});
						visited[nx][ny] = true;
					}
				}
				
				for(int a = 0 ; a<M ; a++) {
					//if(arr[a].endX == -100 && arr[a].endY == -100) continue;
					
					if(arr[a].startX == ax && arr[a].startY == ay) {
						isBoolean = true;
						if(kx > ax || (kx == ax && ky > ay)) {
							kx = ax;
							ky = ay;
							currentPeople = a;
							
						}
						
					}
				}
			}
			
			if(isBoolean) {
				arr[currentPeople].startX = -100;
				arr[currentPeople].startY = -100;
				texiX = kx;
				texiY = ky;
				startGauge -= count;
				useGauge += count;
				break;
			}
			
		}
	}
	static int currentPeople;
	public static void goEnd(int x, int y, int cnt) {
		isBoolean = false;
		Queue<int[]> q = new ArrayDeque<int[]>();
		visited = new boolean[N+1][N+1];
		visited[x][y] = true;
		q.offer(new int[] {x, y, cnt});
		
		while(!q.isEmpty()) {
			int[] texi = q.poll();
			int ax = texi[0];
			int ay = texi[1];
			int count = texi[2];
			if(startGauge < count) {
				startGauge = -1;
				break;
			}
			if(arr[currentPeople].endX == ax && arr[currentPeople].endY == ay) {
				arr[currentPeople].endX = -100;	
				arr[currentPeople].endY = -100;
				texiX = ax;
				texiY = ay;
				useGauge += count;
				startGauge -= count;
				startGauge += count*2;
				break;
			}
			
			for(int i = 0 ; i < 4 ; i++) {
				int nx = ax + dx[i];
				int ny = ay + dy[i];
				if(nx>=1 && ny>=1 && nx<=N && ny<=N && map[nx][ny] != 1 && !visited[nx][ny]) {
					q.offer(new int[] {nx,ny,count+1});
					visited[nx][ny] = true;
				}
			}
		}
		
	}
}

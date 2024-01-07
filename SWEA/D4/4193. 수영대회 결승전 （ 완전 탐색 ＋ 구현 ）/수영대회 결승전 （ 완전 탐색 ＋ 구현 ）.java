
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int[][] matrix;
	static int[] endArr;
	static int[] startArr;
	static boolean[][] visited;
	static int N;
	static int dx[] = {1,0,-1,0};
	static int dy[] = {0,1,0,-1};
	static int minTime = 10000;
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int T = Integer.parseInt(br.readLine());
    	for(int tc = 1 ; tc<=T ; tc++) {
	    	N = Integer.parseInt(br.readLine());
	    	visited = new boolean[N][N];
	    	matrix = new int[N][N];
	    	minTime = 10000;
	    	for(int x = 0 ; x<N ; x++) {
	    		StringTokenizer st = new StringTokenizer(br.readLine());
	    		for(int y = 0 ; y<N ; y++) {
	    			matrix[x][y] = Integer.parseInt(st.nextToken());
	    		}
	    	}
	    	StringTokenizer st = new StringTokenizer(br.readLine());
	    	startArr = new int[2];
	    	startArr[0] = Integer.parseInt(st.nextToken());
	    	startArr[1] = Integer.parseInt(st.nextToken());
	    	endArr = new int[2];
	    	st = new StringTokenizer(br.readLine());
	    	endArr[0] = Integer.parseInt(st.nextToken());
	    	endArr[1] = Integer.parseInt(st.nextToken());
	    	
	    	BFS();
	    	
	    	if(minTime == 10000) {
	    		System.out.println("#"+tc+" "+"-1");
	    	}
	    	else {
	    		System.out.println("#"+tc+" "+minTime);
	    	}
    	}
    }

	private static void BFS(){
		// TODO Auto-generated method stub
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {startArr[0], startArr[1], 0});
		
		while(!q.isEmpty()) {
			int[] arr = q.poll();
			int nowX = arr[0];
			int nowY = arr[1];
			int time = arr[2];
			visited[nowX][nowY] = true;
			
			if(nowX == endArr[0] && nowY == endArr[1]) {
				minTime = Math.min(minTime, time);
				continue;
			}
			for(int i = 0 ; i<4; i++) {
				int nx = nowX + dx[i];
				int ny = nowY + dy[i];
				if(nx>=0 && ny>=0 && nx<N && ny<N && matrix[nx][ny] != 1 && !visited[nx][ny]) {
					if(matrix[nx][ny] == 2) {      
						if((time + 1) % 3 == 0) {
							q.offer(new int[] {nx,ny,time+1});
						}
						else if((time + 1) % 3 == 1) {
							q.offer(new int[] {nx,ny,time+3});
						}
						else if((time + 1) % 3 == 2) {
							q.offer(new int[] {nx,ny,time+2});
						}
					}
					else {
						q.offer(new int[] {nx,ny,time+1});
					}
				}
			}
		}
	}
}
			

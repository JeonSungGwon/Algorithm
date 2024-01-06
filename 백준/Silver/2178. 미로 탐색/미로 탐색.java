
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int N, M;
	static int[][] matrix;
	static boolean[][] visited;
	static int[] dx = { -1, 1, 0, 0 }; 
	static int[] dy = { 0, 0, -1, 1 }; 
	static int my_count = 0;

    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	matrix = new int[N+1][M+1];
    	visited = new boolean[N+1][M+1];
    	for(int i = 1 ; i< N+1 ; i++) {
    		String s = br.readLine();
    		for(int j = 1 ; j < M+1 ; j++) {
    			matrix[i][j] = s.charAt(j-1) - '0';

    		}
    	}
    	
    	BFS(1, 1, 1);
    	System.out.println(my_count);
    	
    }

	private static void BFS(int i, int j, int c) {
		// TODO Auto-generated method stub
		Deque<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] {i,j, c});
		visited[i][j] = true;
		
		while(!q.isEmpty()) {
			int now[] = q.poll();
			int aX = now[0];
			int aY = now[1];
			int count = now[2];
			if(aX == N && aY ==M) {
				my_count = count;
				break;
			}
			
			for(int x = 0 ; x<4 ; x++) {
				int nx = aX + dx[x];
				int ny = aY + dy[x];
				if(nx >= 1 && ny >= 1 && nx < N+1 && ny < M+1 && !visited[nx][ny] && matrix[nx][ny] == 1) {
					q.offer(new int[] {nx,ny, count+1});
					visited[nx][ny] = true;
				}
			}
		}
		
	}
}

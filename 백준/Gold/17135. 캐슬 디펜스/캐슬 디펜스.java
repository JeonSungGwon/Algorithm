import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static ArrayList<Integer> arrX = new ArrayList<Integer>();
	static ArrayList<Integer> arrY = new ArrayList<Integer>();
	static int[] dx = {1, 0, 0, -1};
	static int[] dy = {0, -1, 1, 0};
	static int N, M, D;
	static int count = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1][M+1];
		visited = new boolean[N][M+1];
		for(int i = 0 ; i<N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j<M ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 1) {
					arrX.add(i);
					arrY.add(j);
				}
			}
		}
		
		combinations(0, 0);
		System.out.println(result);
		
	}
	static int result = 0;
	static int[][] copyArr;
    public static void combinations(int index, int cnt) {
    	if(index >= M+1) return;
    	if(cnt > 3) return;
        if (cnt == 3) {
        	copyArr = new int[arr.length][];
        	for (int i = 0; i < arr.length; i++) {
        	    copyArr[i] = Arrays.copyOf(arr[i], arr[i].length);
        	}
        	count = 0;
        	for(int l = 0 ; l<N+1 ; l++) {
        		for(int i = 0 ; i<M ; i++) {
            		if(copyArr[N][i] == 2) {
            			BFS(N, i, 0);
            		}
        		}
        		
        		for(int i = N-1 ; i > 0 ; i--) {
        			for(int j = 0 ; j < M ; j++) {
        				copyArr[i][j] = copyArr[i-1][j];
        			}
        		}
        		Arrays.fill(copyArr[0], 0);
        		for(int i = 0 ; i < N ; i++) {
        			for(int j = 0 ; j < M ; j++) {
        				if(copyArr[i][j] == -1) {
        					copyArr[i][j] = 0;
        				}
        			}
        		}
        	}
        	
        	result = Math.max(result, count);
            return;
        }
        arr[N][index] = 2; 
        combinations(index + 1, cnt+1);
        
        arr[N][index] = 0;
        combinations(index + 1, cnt);

        
    }
    

    static boolean isBoolean;
	private static void BFS(int a, int b, int ccc) {
		Queue<int[]> q = new ArrayDeque<int[]>();
		isBoolean = false;
		q.offer(new int[] {a,b, ccc});
		visited = new boolean[N][M];
		
		while(!q.isEmpty()) {
			int kx = Integer.MAX_VALUE;
			int ky = Integer.MAX_VALUE;
			int qSize = q.size();
			int cou = q.peek()[2];
			if(cou > D) break;
			for(int i = 0 ; i<qSize ; i++){
				int[] abc = q.poll();
				int ax = abc[0];
				int ay = abc[1];
				for(int idx = 0 ; idx<4 ; idx++) {
					int nx = ax + dx[idx];
					int ny = ay + dy[idx];
					if(isIn(nx, ny)) {
						visited[nx][ny] = true;
						q.offer(new int[] {nx, ny, cou+1});
					}
				}
																		
				if(copyArr[ax][ay] == -1 || copyArr[ax][ay] == 1) {
					isBoolean = true;
					if(ay<ky) {
						kx = ax;
						ky = ay;
					}
				}
			}
			if(isBoolean) {
				if((kx<30 && ky<30) && copyArr[kx][ky] != -1) {
					copyArr[kx][ky] = -1;
					count++;
					
				}
				break;
			}
		}
	}
	
	static boolean visited[][];
	public static boolean isIn(int nx, int ny) {
		return nx>=0 && nx<N  && ny>=0 && ny<M && !visited[nx][ny];
		
	}
}

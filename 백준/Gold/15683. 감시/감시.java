import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class CCTV {
		int x;
		int y;
		public CCTV(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	static int[] dx = {0, 1, -1, 0}; //우 , 하, 상,  좌 
	static int[] dy = {1, 0, 0, -1};
	static int[][] map;
	static int N, M;
	static ArrayList<CCTV> arr = new ArrayList<CCTV>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		tempArr = new int[N][M];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] !=0 && map[i][j] != 6) {
					arr.add(new CCTV(i, j));
				}
				if(map[i][j] == 5) {
					move2(i,j, 3);
					move2(i,j, 2);
					move2(i,j, 1);
					move2(i,j, 0);
				}
			}
		}
		numbers = new int[arr.size()];
		중복순열(0);
		System.out.println(result);
		
	}
	static int[] numbers;
	static int[][] tempArr;
	static int result = Integer.MAX_VALUE;
	private static void 중복순열(int cnt) {
		if(cnt == arr.size()) {
			for(int i = 0 ; i < N ; i++) {
				tempArr[i] = map[i].clone();
			}
			cctv();
			int sum = 0;
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < M ; j++) {
					if(tempArr[i][j] == 0) {
						sum++;
					}
				}
			}
			result = Math.min(result, sum);
			return;
		}
		
		for(int i = 0 ; i < 4 ; i++) { // numbers안에는 각 인덱스의 가야할 정보가 들어있다. 그 인덱스 순서는 arr의 순서와 같다.
			numbers[cnt] = i;
			중복순열(cnt + 1);
		}
	}
	private static void cctv() { // 중복 순열 정보를 받아서 이동시켜보자 arr.get()으로 가져온 값은 좌표, numbers[] 으로 가져온 값은 각 인덱스의 이동
		
		for(int i = 0 ; i < arr.size() ; i++) {
			if(map[arr.get(i).x][arr.get(i).y] == 1) {
				move(arr.get(i), numbers[i]);
			}
			else if(map[arr.get(i).x][arr.get(i).y] == 2) {
				if(numbers[i] == 0 || numbers[i] == 3) {
					move(arr.get(i), 0);
					move(arr.get(i), 3);
				}else {
					move(arr.get(i), 1);
					move(arr.get(i), 2);
				}
			}
			else if(map[arr.get(i).x][arr.get(i).y] == 3) {
				if(numbers[i] == 0) {
					move(arr.get(i), 0);
					move(arr.get(i), 2);
				}else if (numbers[i] == 1){
					move(arr.get(i), 1);
					move(arr.get(i), 0);
				}else if (numbers[i] == 2){
					move(arr.get(i), 3);
					move(arr.get(i), 2);
				}else if (numbers[i] == 3){
					move(arr.get(i), 3);
					move(arr.get(i), 1);
				}
			}
			else if(map[arr.get(i).x][arr.get(i).y] == 4) {
				if(numbers[i] == 0) { // 우일때 
					move(arr.get(i), 0);
					move(arr.get(i), 2);
					move(arr.get(i), 3);
				//우 하 상 좌 
				}else if (numbers[i] == 1){ // 하일때 
					move(arr.get(i), 1);
					move(arr.get(i), 0);
					move(arr.get(i), 2);
				}else if (numbers[i] == 2){ // 상일때 
					move(arr.get(i), 3);
					move(arr.get(i), 2);
					move(arr.get(i), 1);
				
				}else if (numbers[i] == 3){ //좌 일때 
					move(arr.get(i), 3);
					move(arr.get(i), 1);
					move(arr.get(i), 0);
				}
			}
			else if(map[arr.get(i).x][arr.get(i).y] == 5) {
				move(arr.get(i), 3);
				move(arr.get(i), 2);
				move(arr.get(i), 1);
				move(arr.get(i), 0);
			}
		}
	}
	private static void move(CCTV cctv, int i) {
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.offer(new int[] {cctv.x, cctv.y});
		while(!q.isEmpty()) {
			int[] list = q.poll();
			int ax = list[0];
			int ay = list[1];
			if(tempArr[ax][ay] == 0) {
				tempArr[ax][ay] = 100;
			}
			int nx = ax + dx[i];
			int ny = ay + dy[i];
			
			if(nx>=0 && nx<N && ny>=0 && ny < M && tempArr[nx][ny] != 6) {
				q.offer(new int[] {nx,ny});
			}
		}
	}
	private static void move2(int a, int b, int i) {
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.offer(new int[] {a, b});
		while(!q.isEmpty()) {
			int[] list = q.poll();
			int ax = list[0];
			int ay = list[1];
			if(map[ax][ay] == 0) {
				map[ax][ay] = 100;
			}
			int nx = ax + dx[i];
			int ny = ay + dy[i];
			
			if(nx>=0 && nx<N && ny>=0 && ny < M && map[nx][ny] != 6) {
				q.offer(new int[] {nx,ny});
			}
		}
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Shark implements Comparable<Shark>{
		int r,c,s,d,z;

		public Shark(int r, int c, int s, int d, int z) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
		
		
		@Override
		public int compareTo(Shark o) {
			if(this.c == o.c) {
				if(this.r == o.r) return o.z - this.z;
				return this.r - o.r;
			}
				
			return this.c - o.c;
		}
	}
	static Shark[] sharks;
	static int[][] map;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	static int R, C, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[R+1][C+1];
		sharks = new Shark[M];
		map[0][0] = 1;
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			if(d == 1)
				d = 0;
			else if(d == 4)
				d = 1;
			sharks[i] = new Shark(r, c, s, d, z);
		}
		
		int cnt = 0;
		int result = 0;
		for(int j = 1 ; j <= C ; j++) {
			int[][] tempMap = new int[R+1][C+1];
			Arrays.sort(sharks); // 상어의 열순으로 정렬 같으면 행순 정렬 
			for(int i = 0 ; i < M; i++) {
				if(sharks[i].c == 10000) break;
				if(j == sharks[i].c) { // 상어와 사람이 같은 열에 있을때 죽임 
					result += sharks[i].z;
					sharks[i].c = 10000;
					cnt++;
					break;
				}
			}
			
			for(int i = 0 ; i < M; i++) {	
				if(sharks[i].c == 10000) continue;
				
				int speed = sharks[i].s;
				if(sharks[i].d == 0 || sharks[i].d == 2) //상 하
					speed %= (R -1) * 2; 
				else if(sharks[i].d == 1 || sharks[i].d == 3) //좌 우
					speed %= (C -1) * 2;
				
				moveShark(sharks[i], speed); // 상어 움직임
				
				if(tempMap[sharks[i].r][sharks[i].c] > sharks[i].z) { // 같은위치에 있을때 이전 상어 크기보다 현재 상어 크기가 작으면 현재 상어 죽임 
					sharks[i].c = 10000; 
					cnt++;
				}else {
					if(tempMap[sharks[i].r][sharks[i].c] != 0) {	
						for(int a = 0 ; a<i ; a++) {
							if((sharks[a].r == sharks[i].r && sharks[a].c == sharks[i].c)) { //a는 상어 i는 현재 사라
								sharks[a].c = 10000;
							}
						}
					}
					tempMap[sharks[i].r][sharks[i].c] = sharks[i].z; // 같은 위치에 있을 때 상어 크기정보 저장 
				}
			}
			
				if(cnt >= M) break; //상어가 다 죽으면 종료  
		}
		
		System.out.println(result);
		
	}
	
	static void moveShark(Shark shark, int moveNum) {
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.offer(new int[] {shark.r, shark.c, moveNum});
		
		while(!q.isEmpty()) {
			int[] arr = q.poll();
			int aR = arr[0];
			int aC = arr[1];
			int aMoveNum = arr[2];
			if (aMoveNum == 0) {
				shark.r = aR;
				shark.c = aC;
				break;
			}
			int nR = aR + dx[shark.d];
			int nC = aC + dy[shark.d];
			if(nR == 0 || nC == 0 || nR == R+1 || nC == C+1) {
				shark.d = (shark.d + 2) % 4; 
				nR = aR + dx[shark.d];
				nC = aC + dy[shark.d];
			}
			
			q.offer(new int[] {nR, nC, aMoveNum - 1});
			
		}
	}
}

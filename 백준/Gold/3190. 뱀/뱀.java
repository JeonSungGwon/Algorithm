import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static class Snake{
		int x;
		int y;
		int d;
		Snake(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1,  0};
	static int[][] map;
	static Snake snake;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		map = new int[N][N];
		
		for(int i = 0 ; i < K ; i++)  {
			int x = sc.nextInt() - 1;
			int y = sc.nextInt() - 1;
			map[x][y] = 2; // 사과 위치
		}
		snake = new Snake(0, 0, 0);
		int L = sc.nextInt();
		
		Queue<Integer> iq = new ArrayDeque<Integer>();
		Queue<Character> cq = new ArrayDeque<Character>();
		
		for(int i = 0 ; i < L ; i++) {
			iq.offer(sc.nextInt());
			cq.offer(sc.next().charAt(0));
		}
		
		map[snake.x][snake.y] = 1;
		int curtime = 0;
		int ax = snake.x;
		int ay = snake.y;
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.offer(new int[] {ax,ay});
		while(true) {
			
			if(!iq.isEmpty() && iq.peek() == curtime) {
				iq.poll();
				char cd = cq.poll();
				if(cd == 'D') snake.d = (snake.d + 1) % 4;
				if(cd == 'L') snake.d = (snake.d - 1 + 4) % 4;
			}
			
			int nx = ax + dx[snake.d];
			int ny = ay + dy[snake.d];
			if(nx < 0 || ny < 0 || nx >= N || ny >= N || map[nx][ny] == 1) break;
			q.offer(new int[] {nx,ny});
			if(map[nx][ny] != 2) { // 사과가 없을
				map[nx][ny] = 1;
				int arr[] = q.poll();
				map[arr[0]][arr[1]] = 0;
			} else {
				map[nx][ny] = 1;
				
			}
			ax = nx;
			ay = ny;
			curtime++;
		}
		
		System.out.println(curtime + 1);
		
	}
}

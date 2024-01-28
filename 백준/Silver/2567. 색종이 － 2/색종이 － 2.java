import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = {0, 1, -1 ,0};
	static int[] dy = {1, 0, 0, -1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[100][100];
		for(int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			for(int x = (99-b)-9 ; x<=(99-b) ; x++) {
				for(int y = a  ;  y<a+10 ; y++) {
					arr[x][y] = 1;
				}
			}
		}
		
		int cnt = 0;
		for(int x = 0 ; x<100 ; x++) {
			for(int y = 0 ; y<100 ; y++) {
				if(arr[x][y] == 1) {
					for(int j = 0 ; j<4 ; j++) {
						int nx = x + dx[j];
						int ny = y + dy[j];
						if(nx >= 0 && nx<100 && ny >= 0 && ny <100 && arr[nx][ny] == 0) {
							cnt++;
						}
						if(nx == -1 || ny == -1 || nx == 100 || ny == 100) {
							cnt++;
						}
					}
				}
			}
			
		}
		System.out.println(cnt);
	
	}
}

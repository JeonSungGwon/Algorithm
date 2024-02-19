import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[]arr;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		arr = new int[N+1];
		visited = new boolean[N+1][N+1];
		int cnt = 0;
		StringBuilder sb = new StringBuilder();
		for(int i = 1 ; i<=N ; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i = 1 ; i<=N ; i++) {
			visited[i][arr[i]] = true;
		}
	
		for(int i = 1 ; i<=N ; i++) {
			for(int j = 1 ; j<=N ; j++) {
				if(!visited[i][j]) continue;
				if(visited[i][j] && visited[j][i]) {
					cnt++;
					sb.append(i+"\n");
				} else {
				int count = 0;
				int a = j;
				while(count<=N) {
					if(arr[a] == i) {
						cnt++;
						sb.append(i+"\n");
						break;
					}
					a = arr[a];
					count++;
					
				}
				}
			}
				
		}
		System.out.println(cnt);
		System.out.println(sb);
	}
}

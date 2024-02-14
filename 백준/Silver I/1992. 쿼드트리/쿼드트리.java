import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i = 0 ; i < N ; i++) {
			String str = br.readLine();
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		solve(0, 0, N);
		
		System.out.println(sb.toString());
	}
	static StringBuilder sb = new StringBuilder();
	private static void solve(int i, int j, int n) {
		int sum = 0;
		for(int r = i ; r<i+n ; r++) {
			for(int c = j ; c<j+n ; c++) {
				sum += map[r][c];
			}
		}
		if(sum == 0) {
			sb.append("0");
		}else if(sum == n*n) {
			sb.append("1");
		}else {
			int size = n/2;
			sb.append("(");
			solve(i, j, size); 
			solve(i, j + size, size); 
			solve(i + size, j, size); 
			solve(i + size, j + size, size); 
			sb.append(")");
		}
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int [n][2];
		int[][] matrix = new int[100][100];
		for(int i = 0 ; i < n ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j <2 ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0 ; i < n ; i++) {

			int startX = (99-arr[i][1])-9;
			int endX = startX+10;
			int startY = arr[i][0];
			int endY = arr[i][0]+10;
			
			for(int x = startX ; x<endX ; x++) {
				for(int y = startY ; y<endY ; y++) {
					matrix[x][y] = 1;
				}
			}
		}
		int sum = 0;
		for(int i = 0 ; i<100 ; i++) {
			for(int j = 0 ; j<100 ; j++) {
				if(matrix[i][j] == 1) {
					sum++;
				}
			}
		}
		System.out.println(sum);
	}

}

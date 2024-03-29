import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main {
	
 static int INF = 10000001;
 public static void main(String[] args) throws IOException {
	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	 StringBuilder sb = new StringBuilder();
	 StringTokenizer st;
	 int n = Integer.parseInt(br.readLine());
	 int m = Integer.parseInt(br.readLine());
	 int[][] arr = new int[n + 1][n + 1];
	 for (int i = 1; i < n + 1; i ++){
		 Arrays.fill(arr[i], INF);
	 }
	 for (int i = 0; i < m; i ++){
		 st = new StringTokenizer(br.readLine());
		 int start = Integer.parseInt(st.nextToken());
		 int end = Integer.parseInt(st.nextToken());
		 int cost = Integer.parseInt(st.nextToken());
		 if (arr[start][end] > cost){
			 arr[start][end] = cost;
		 }
		 else {
			 arr[start][end] = arr[start][end];
		 }
	 }
	 for (int k = 1; k < n + 1; k ++){
		 for (int i = 1; i < n + 1; i ++){
			 for (int j = 1; j < n + 1; j ++){
				 if (i != j && arr[i][j] > arr[i][k] + arr[k][j]){
					 arr[i][j] = arr[i][k] + arr[k][j];
				 }
			 }
		 }
	 }
	 for (int i = 1; i < n + 1; i ++) {
		 for (int j = 1; j < n + 1; j++) {
			 if (arr[i][j] == INF) sb.append(0).append(' ');
			 else sb.append(arr[i][j]).append(' ');
		 }
		 sb.append('\n');
	 }
	 System.out.println(sb);
  }
}
 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][2];
		for(int i = 0 ; i<N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		recursion(0, 0);
		System.out.println(result);
		
	}
	static int result;
	private static void recursion(int current, int cnt) {
		if (current == N) {
			result = Math.max(result, cnt);
			
			return;
		}
		if (arr[current][0] <= 0 || cnt == N - 1) {
			recursion(current + 1, cnt);
			return;
		}
		
		for (int i = 0; i < N; i++) { 
			if (i != current && arr[i][0] > 0) { 
				arr[i][0] -= arr[current][1];
				arr[current][0] -= arr[i][1];

				recursion(current + 1, cnt + (arr[current][0] <= 0 ? 1 : 0) + (arr[i][0] <= 0 ? 1 : 0));
				arr[i][0] += arr[current][1];
				arr[current][0] += arr[i][1];
			}
		}
	}
}

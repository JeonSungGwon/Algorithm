import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0 ; tc < T ; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i<N ; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int maxNum = arr[N-1];
			long result = 0;
			for(int i = N-2 ; i>=0 ; i--) {
				if(arr[i] > maxNum) {
					maxNum = arr[i];
				} else if(arr[i] < maxNum) {
					result += (maxNum - arr[i]);
				}
			}
			System.out.println(result);
		}
	}
}

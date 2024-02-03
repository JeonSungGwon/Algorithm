import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		
		for(int tc = 1 ; tc<=T ; tc++) {
			int N = Integer.parseInt(br.readLine());
			boolean[] isBoolean = new boolean[N];
			int[] arr = new int[N+1];
			for(int i = 0 ; i<N ; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				arr[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
			}
			
			int cnt = 1;
			int current = arr[1];
			for(int i = 2 ; i<=N ; i++) {
				if(current > arr[i]) {
					cnt++;
					current=arr[i];
				}
			}
			
			System.out.println(cnt);
			
		}
	}
}

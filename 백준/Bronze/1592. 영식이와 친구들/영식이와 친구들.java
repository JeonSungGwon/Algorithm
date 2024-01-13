import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int[] arr = new int[N+1];
		int now = 1;
		arr[now] = 1;
		int cnt = 0;
		while(arr[now] != M) {
			if((arr[now] % 2) != 0) {
				now = (now+L) % N;
				if(now == 0) {
					now = N;
				}
				cnt++;
			}
			else {
				now = (now-L+N) % N;
				if(now == 0) {
					now = N;
				}
				cnt++;
			}
			arr[now] += 1;
		}
		System.out.println(cnt);
	}

}

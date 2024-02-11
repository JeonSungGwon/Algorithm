import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		arr = new int[N][2];
		Integer[] arrB = new Integer[K];
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> {
			return b[1] - a[1];
		});
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
	
		for(int i = 0 ; i < K ; i++) {
			arrB[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr, (a, b) -> {
			return a[0] - b[0];
		});
		Arrays.sort(arrB);
	    int idx = 0;
	    long result = 0;
	    for (int i = 0; i < K; i++) {

			while (idx < N) {
				if (arr[idx][0] <= arrB[i]) {
					pq.add(arr[idx]);
					idx++;
				} else {
					break;
				}
			}
			if(!pq.isEmpty()) {
				result += pq.poll()[1];
			}
		}
		
		System.out.println(result);
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class Main {

	static int max = 1000001;
	public static void main(String[] args) throws IOException{
		boolean[] board = new boolean[max];
	 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] result = new int[max];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			int a = Integer.parseInt(st.nextToken());
			board[a] = true;
			arr[i] = a;
		}
		int[] rArr = Arrays.copyOf(arr, N);
		Arrays.sort(arr);
		for(int i = 0 ; i < N ; i++) {
			for(int j = arr[i] ; j <= arr[N-1] ; j+=arr[i]) {
				if(board[j] && j != arr[i]) {
					result[arr[i]]++;
					result[j]--;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i  < N ; i++) {
			if(board[rArr[i]])
			sb.append(result[rArr[i]]).append(" ");
		}
		System.out.println(sb);	
	}

}

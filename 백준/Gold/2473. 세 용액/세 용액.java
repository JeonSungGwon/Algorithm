import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static long[] board;
	static int start;
	static int end;
	static int mid;
	static long[] result;
	static long min = Long.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		board = new long[N];
		result = new long[3];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			board[i] = Long.parseLong(st.nextToken());
		}
		
		Arrays.sort(board);
		for(int i = 0 ; i < N-2 ; i++) {
			start = i;
			mid = start + 1;
			end = N-1;
			while(mid < end) {
				long sum = board[start] + board[mid] + board[end];
				
				if(Math.abs(sum) < min) {
					min = Math.abs(sum);
					result[0] = board[start];
					result[1] = board[mid];
					result[2] = board[end];
				}
				
				if(sum == 0) {
					i = N;
					break;
				}
				else if(sum < 0) {
					mid++;
				}
				else {
					end--;
				}
				
			}
		}
		System.out.println(result[0] + " " + result[1] + " " + result[2]);
		
	}
}

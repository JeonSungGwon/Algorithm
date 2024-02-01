import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int[][] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 1 ; i<=T ; i++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			for(int j = 0 ; j < N ; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int k = 0 ; k<N ; k++) {
					arr[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			isSelected = new boolean[N];
			input = new int[N/2];
			visited = new boolean[N];
            minDiv = Integer.MAX_VALUE;
			조합(0, 0);
			System.out.println("#"+i+" "+minDiv);
		}
	}
	static int[] numbers, input;
	static boolean[] isSelected;
	static boolean[] visited;
	static int cookA;
	static int cookB;
	static int cook;
	static int minDiv;
	private static void 조합(int cnt, int start) {
		// TODO Auto-generated method stub
		if(cnt == N/2) {
			cookA = 0;
			cook = 0;
			visited2 = new boolean[N/2];
			재조합(0,0, input);
			cookA = cook;
			int[] inputB = new int[N/2];
			int idx = 0;
			for(int i = 0 ; i<N ; i++) {
				if(visited[i]) continue;
				inputB[idx++] = i;
			}
			cook = 0;
			cookB = 0;
			재조합(0,0, inputB);
			cookB = cook;
			minDiv = Math.min(minDiv, Math.abs(cookA-cookB));
			return;
		}
		
		
		for(int i = start ; i<N ; i++) {
			input[cnt] = i;
			visited[i] = true;
			조합(cnt+1, i+1);
			visited[i] = false;
		}
		
	}
	
	static int[] input2 = new int[2];
	static boolean[] visited2;
	private static void 재조합(int cnt, int start, int[] input) {
		if(cnt == 2) {
			cook += arr[input2[0]][input2[1]];
			cook += arr[input2[1]][input2[0]];
			return;
		}
		
		for(int i = start ; i<N/2 ; i++) {
			input2[cnt] = input[i];
			재조합(cnt+1, i+1, input);
		}
		
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int sum = 0;
	static int[] arr;
	static int[] result;
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[9];
		result = new int[7];
		for(int i = 0 ; i<9 ; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		DFS(-1,0);
	}

	private static void DFS(int idx, int cnt) {
		// TODO Auto-generated method stub
		if(cnt == 7){
			if(sum == 100) {
				Arrays.sort(result);
				for (int i = 0; i < 7; i++) {
                    System.out.println(result[i]);
                }
				System.exit(0);
			}
			return ;
		}
		
		for(int i = 0; i<9 ; i++) {
			if(i <= idx) continue;
			
			sum += arr[i];
			result[cnt] = arr[i];
			DFS(i, cnt+1);
			sum -= arr[i];
		}
	}
}

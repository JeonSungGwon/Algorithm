import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[26];
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < str.length(); j++) {
				char c = str.charAt(j);
				arr[c-'A'] += (int)Math.pow(10, str.length() - 1 - j);
			}
		}
		
		Arrays.sort(arr);
		
		int num = 9;
		int idx = 25;
		int result = 0;
		while(arr[idx] != 0) {
			result += arr[idx]*num;
			idx--;
			num--;
		}
		
		System.out.print(result);
	}
}


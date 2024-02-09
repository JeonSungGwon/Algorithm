import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		boolean[] visited = new boolean[1000001];

		for (int j = 2; j < 1000001; j++) {
			if (visited[j])
				continue;
			for (int i = j * 2; i < 1000001; i += j) {
				visited[i] = true;
			}
		}
		while (true) {
			boolean isBoolean = false;
			int n = Integer.parseInt(br.readLine());
			if (n == 0)
				break;

			for (int i = 3; i <  n - 1; i += 2) {
				if (i % 2 != 0 && (n - i) % 2 != 0) {
					if (!visited[i] && !visited[n - i]) {
						sb.append(n).append(" = ").append(i).append(" + ").append(n-i).append("\n");
						isBoolean = true;
						break;
					}
				}
			}
			if (!isBoolean) {
				sb.append("Goldbach's conjecture is wrong.").append("\n");
			} 
		}
		System.out.println(sb);
		
	}

}
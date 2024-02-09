import java.util.Scanner;

public class Main {

	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		visited = new boolean[N+1];
		int cnt = 0;
		for(int i = 2 ; i<=N ; i++) {
			if(visited[i]) continue;
			
			for(int j = i ; j<=N ; j+=i) {
				if(!visited[j]) {
					visited[j] = true;
					cnt++;
				}
				if(cnt == K) {
					System.out.println(j);
					return;
				}
			}
		}
	}
}



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int M;
	static boolean[][] graph;
	static boolean[] visited;
	static int my_count = 0;
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	N = Integer.parseInt(br.readLine());
    	M = Integer.parseInt(br.readLine());
    	graph = new boolean[N+1][N+1];
    	visited = new boolean[N+1];
    	for(int i = 0 ; i<M ; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		int a = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
    		graph[a][b] = true;
    		graph[b][a] = true;
    	}
    	
    	DFS(1);
    	System.out.println(my_count);
    }
	private static void DFS(int i) {
		// TODO Auto-generated method stub
		visited[i] = true;
		for(int x = 2 ; x < N+1 ; x++) {
			if(!visited[x] && graph[i][x]) {
				DFS(x);
				my_count += 1;
			}
		}
	}

}

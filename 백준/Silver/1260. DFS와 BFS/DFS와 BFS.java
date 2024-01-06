
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;


public class Main {
	static boolean[] visited1;
	static boolean[] visited2;
	static boolean[][] graph;
	static int N;
	static int M; 
	static int V;
	

    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	V = Integer.parseInt(st.nextToken());
    	
    	graph = new boolean[N+1][N+1];
    	
    	for(int i = 0 ; i < M ; i++) {
    		st = new StringTokenizer(br.readLine());
    		int a = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
    		graph[a][b] = true;
    		graph[b][a] = true;
    	}
    	
    	visited1 = new boolean[N+1];
    	visited2 = new boolean[N+1];
    	
    	DFS(V);
    	System.out.println();
    	BFS();
    }

	private static void BFS() {
		// TODO Auto-generated method stub
		Deque<Integer> q =  new ArrayDeque<Integer>();
		q.offer(V);
		visited2[V] = true;
		while(!q.isEmpty()){
			V = q.poll();
			System.out.print(V + " ");
			for(int i = 1 ; i < N+1 ; i++) {
				if(!visited2[i] && graph[V][i]) {
					q.offer(i);
					visited2[i] = true;
				}
			}
		}
		
	}

	private static void DFS(int a) {
		// TODO Auto-generated method stub
		visited1[a] = true;
		System.out.print(a + " ");
		for(int i = 1 ; i < N+1 ; i++) {
			
			if(!visited1[i] && graph[a][i]) {
				DFS(i);
			}
		}
		
	}
}

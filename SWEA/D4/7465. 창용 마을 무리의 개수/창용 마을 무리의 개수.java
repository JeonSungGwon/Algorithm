
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int M;
	static boolean[][] graph;
	static boolean[] visited;
	static int count = 0;
	static int group;
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int T = Integer.parseInt(br.readLine());
    	for(int tc = 1 ; tc<= T ; tc++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
        	N = Integer.parseInt(st.nextToken());
        	M = Integer.parseInt(st.nextToken());
        	graph = new boolean[N+1][N+1];
        	visited = new boolean[N+1];
        	for(int i = 0 ; i<M ; i++) {
        		st = new StringTokenizer(br.readLine());
        		int a = Integer.parseInt(st.nextToken());
        		int b = 0;
        		if(st.hasMoreTokens()) {
        			b = Integer.parseInt(st.nextToken());
        		}
        		graph[a][b] = true;
        		graph[b][a] = true;
        	}
        	group = N;
        	for(int j = 1 ; j<= N ; j++) {
        		BFS(j);
        	}
        	for(int i = 1 ; i<=N ; i++) {
        		if(!visited[i]) {
        			group -= 1;
        		}
        	}
        	System.out.println("#"+tc+" "+group);
    	}
    
    }
	private static void BFS(int j) {
		// TODO Auto-generated method stub
		Deque<Integer> q = new LinkedList<Integer>();
		q.offer(j);
		visited[j] = true;
		while (!q.isEmpty()){
			int ax = q.poll();
			
			for(int i = 1 ; i <= N ; i++) {
				if(graph[ax][i] && !visited[i]) {
					visited[i] = true;
					q.offer(i);
					group -= 1; 
				}
			}
		}
		
	}

}

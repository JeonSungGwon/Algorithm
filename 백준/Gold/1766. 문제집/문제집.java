import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] degree = new int[N+1];
	
		for(int i = 0 ; i <= N ; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			degree[b]++;
		}
		
		Queue<Integer> pq = new PriorityQueue<Integer>();
		
		for(int i = 1 ; i <= N ; i++) {
			if(degree[i] == 0) pq.offer(i);
			
		}
		
		StringBuilder sb = new StringBuilder();
		while(!pq.isEmpty()) {
			
			int value = pq.poll();
			sb.append(value).append(" ");
			for(int a : graph.get(value)) {
				degree[a]--;
				if(degree[a] == 0) pq.offer(a);
			}
		}
		System.out.println(sb);
	}

}

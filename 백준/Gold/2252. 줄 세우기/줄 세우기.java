import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[] edgeCount;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Queue<Integer> q = new LinkedList<Integer>();
		edgeCount = new int[N+1];
		for(int i = 0 ; i <= N ; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			edgeCount[b]++;
			graph.get(a).add(b);
		}
		
		for(int i = 1 ; i <= N ; i++) {
			if(edgeCount[i] == 0) {
				q.offer(i);
			}
		}
		
		
		StringBuilder sb = new StringBuilder();
		while(!q.isEmpty()) {
			int edge = q.poll();
			sb.append(edge).append(" ");
			ArrayList<Integer> list = graph.get(edge);
			for(int i = 0 ; i < list.size() ; i++) {
				int index = list.get(i);
				edgeCount[index]--;
				if(edgeCount[index] == 0) {
					q.offer(index);
				}
			}
		}
		System.out.println(sb.toString().trim());
	}
}

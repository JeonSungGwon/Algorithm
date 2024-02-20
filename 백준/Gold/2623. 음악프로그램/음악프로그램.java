import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] in = new int[N+1];
		ArrayList<Integer>[] list = new ArrayList[N+1];
		for(int i = 1 ; i<=N ; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 1; i<=M ; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			for(int j = 0 ; j<num-1 ; j++) {
				int e = Integer.parseInt(st.nextToken());
				list[s].add(e);
				in[e]++;
				s = e;
			}
			
		}
	
		
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i = 1;  i<=N ; i++) {
			if(in[i] == 0) {
				q.offer(i);
			}
			
		}
		
		StringBuilder sb = new StringBuilder();
		while(!q.isEmpty()) {
			int v = q.poll(); 
			sb.append(v).append("\n");
			for(int i = 0 , size = list[v].size() ; i<size; i++) {
				int e = list[v].get(i);
				
				if(--in[e] == 0) {
					q.offer(e);
				}
			}
		}
	    for (int i = 1; i <= N; i++)
	        if (in[i] != 0)
	            sb = new StringBuilder("0");
		System.out.println(sb);
		
	}

}

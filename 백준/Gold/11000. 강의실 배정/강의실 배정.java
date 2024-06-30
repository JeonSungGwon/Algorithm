import java.io.*;
import java.util.*;

public class Main {
	
	static class Class implements Comparable<Class>{
		int start;
		int end;
		
		public Class(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(Class o) {
			
			if(this.start == o.start) {
				return this.end - o.end;
			}
			
			return this.start - o.start;
		}
		
	}
	
	static ArrayList<Class> arr = new ArrayList<Class>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			arr.add(new Class(start, end));
		}
		Collections.sort(arr);
		Queue<Integer> q = new PriorityQueue<>();
		int endTime = 0;
		for(Class c : arr) {
			endTime = c.end;
			
			if(!q.isEmpty() && q.peek() <= c.start) {
				q.poll();
			}
			q.add(endTime);
		}
		System.out.println(q.size());
	}
}

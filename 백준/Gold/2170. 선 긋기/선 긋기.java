import java.util.*;
import java.io.*;

public class Main {
	
	static class Line implements Comparable<Line>{
		int x;
		int y;
		
		public Line(int x, int y){
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(Line o) {
			if(this.x == o.x)
				return o.y - this.y;
			return this.x - o.x;
		}
	}
	static ArrayList<Line> arr = new ArrayList<Line>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr.add(new Line(x,y));
		}
		
		Collections.sort(arr);
		
		int sum = 0;
		int start = arr.get(0).x;
		int end = arr.get(0).y;
		for(int i = 1 ; i < N ; i++) {
			if(end < arr.get(i).x) {
				sum += end - start;
				start = arr.get(i).x;
				end = arr.get(i).y;
			}
			else if(end < arr.get(i).y){
				end = arr.get(i).y;
			}
		}
		sum += end - start;
		System.out.println(sum);
	}
}

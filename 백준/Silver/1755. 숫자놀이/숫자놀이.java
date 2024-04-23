import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	
	static class Words implements Comparable<Words>{
		int num;
		String word;
		public Words(int num, String word) {
			super();
			this.num = num;
			this.word = word;
		}
		@Override
		public int compareTo(Words o) {
			return this.word.compareTo(o.word);
		}
		
	}
	static String[] word = {"zero", "one", "two", "three", "four", "five", "six", "seven","eight", "nine"};
	static ArrayList<Words> arr = new ArrayList<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		for(int i = M ; i <= N ; i++) {
			String tmp = Integer.toString(i); 
			char[] nums = tmp.toCharArray(); //
			tmp="";
			for(int j = 0 ; j < nums.length ; j++) {
				tmp+=word[nums[j]-'0'];
			}
			arr.add(new Words(i, tmp));
		}
		
		Collections.sort(arr);
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < arr.size() ; i++) {
			sb.append(arr.get(i).num + " ");
			if((i+1) % 10 == 0) {
				sb.append("\n");
			}
		}
		System.out.println(sb);
		
		
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringBuilder sb = new StringBuilder();
		Deque<Character> dq =new ArrayDeque<Character>();
		String rS = "";
		boolean b = false;
		for(int i = 0 ; i<str.length() ; i++) {
			//System.out.println(rS);
			if(str.charAt(i) == '<') {
				b = true;
				while(!dq.isEmpty()) sb.append(dq.removeFirst());
				
			}
			if(b) {
				dq.addFirst(str.charAt(i));
				//rS += str.charAt(i);
				if(str.charAt(i) == '>') {
					b = false;
					while(!dq.isEmpty()) sb.append(dq.removeLast());
				}
			} else{
				if(str.charAt(i) == ' ') {
					while(!dq.isEmpty()) sb.append(dq.removeFirst());
					sb.append(" ");
				}
				else {
					dq.addFirst(str.charAt(i));
					//s += str.charAt(i);
				}
				
			}
			
		}

		while(!dq.isEmpty()) sb.append(dq.removeFirst());

		System.out.println(sb);
		
	
	}
}

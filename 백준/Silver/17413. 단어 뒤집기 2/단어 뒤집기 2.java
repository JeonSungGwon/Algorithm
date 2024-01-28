import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static String[] spS;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String[] strArr = str.split(" ");
		StringBuilder sb = new StringBuilder();
		String rS = "";
		String s = "";
		boolean b = false;
		for(int i = 0 ; i<str.length() ; i++) {
			//System.out.println(rS);
			if(str.charAt(i) == '<') {
				b = true;
				if(s != "") {
					StringBuffer ssb = new StringBuffer(s);
			        sb.append(ssb.reverse().toString());
			        s = "";
				}
				
			}
			if(b) {
				rS += str.charAt(i);
				if(str.charAt(i) == '>') {
					b = false;
					sb.append(rS);
					rS = "";
				}
			} else{
				if(str.charAt(i) == ' ') {
					StringBuffer ssb = new StringBuffer(s);
			        sb.append(ssb.reverse().toString());
					sb.append(" ");
					s = "";
				}
				else {
					s += str.charAt(i);
				}
				
			}
			
		}
		
		if(s != "") {
			StringBuffer ssb = new StringBuffer(s);
			sb.append(ssb.reverse().toString());
		}
		System.out.println(sb);
		
	
	}
}

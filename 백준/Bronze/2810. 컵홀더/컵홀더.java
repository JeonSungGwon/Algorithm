import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	String str = br.readLine();
    	String myStr = "";
    	int cnt = 0;
    	for(int i = 0 ; i<N ; i++) {
    		if(str.charAt(i) == 'S') {
    			myStr += "*S";
    		}
    		else {
    			myStr +="*LL";
    			i++;
    		}
    	}
    	myStr += '*';
    	for(int i = 0 ; i<myStr.length() ; i++) {
    		if(myStr.charAt(i) == '*') {
    			cnt++;
    		}
    	}
    	if(cnt>= N) {
    		System.out.println(N);
    	}
    	else {
    		System.out.println(cnt);
    	}
    
    	
    }
}
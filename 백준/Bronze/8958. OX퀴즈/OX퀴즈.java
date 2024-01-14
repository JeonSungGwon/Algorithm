import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int t = Integer.parseInt(br.readLine());
    	String[] str = new String[t];
    	int[] result = new int[t];
    	for(int i = 0 ; i<t ; i++) {
    		str[i] = br.readLine();
    	}
    	
    	for(int i = 0 ; i<t ; i++) {
    		int add = 1;
    		for(int j = 0 ; j<str[i].length() ; j++) {
    			if(str[i].charAt(j) == 'O') {
    				result[i] += add;
    				add++;
    			}
    			if(str[i].charAt(j) == 'X') {
    				add = 1;
    			}
    		}
    	}
    	
    	for(int i = 0 ; i<result.length ; i++) {
    		System.out.println(result[i]);
    	}
    }
    	
}
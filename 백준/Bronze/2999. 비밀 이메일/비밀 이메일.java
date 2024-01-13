import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	String str = br.readLine();
    	int R = 0;
    	int C = 0; 
    	for(int i = 1 ; i <= 100 ; i++) {
    		if(str.length()%i == 0) {
    			if(str.length()/i >= i) {
	    			R = i; 
	    			C = str.length()/i; 
    			}
    			else break;
    		}
    	}
    	Character[][] arr = new Character[R][C];
    	int index = 0;
    	for(int i = 0 ; i < C; i++) {
    		for(int j = 0 ; j<R ; j++) {
    			char a = str.charAt(index++);
    			arr[j][i] = a;
    		}
    	}
    	for(int i = 0 ; i<R; i++) {
    		for(int j = 0 ; j<C ; j++) {
    			System.out.print(arr[i][j]);
    		}
    	}
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N  = Integer.parseInt(br.readLine());
    	int[][] arr = new int[N][4];
    	int[][] matrix = new int[1001][1001];

    	for(int i = 0 ; i<N ; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		for(int j = 0 ; j<4 ; j++) {
    			arr[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	for(int i = 0 ; i < N ; i++) { 
    		int cnt = 0;
    		for(int x = arr[i][0] ; x< arr[i][0] + arr[i][2] ; x++) {
    			for(int y = arr[i][1]  ; y < arr[i][1] + arr[i][3] ; y++) {
    				matrix[x][y] = i+1;
    			}
    		}
    	}
    	for(int l = 1 ; l<=N ; l++) {
    		int cnt = 0;
	    	for(int i = 0 ; i<1001; i++) {
	    		for(int j = 0 ; j<1001 ; j++) {
	    			if(matrix[i][j] == l) {
	    				cnt++;
	    			}
	    		}
	    	}
	    	System.out.println(cnt);
    	}
    }
    	
}
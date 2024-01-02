import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws Exception {

    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int T = Integer.parseInt(br.readLine());
    	
    	for (int tc = 1 ; tc<=T ; tc++) {
    		int N = Integer.parseInt(br.readLine());
    		int[][] arr = new int[N][N];
    		
    		int[][] arr_90 = new int[N][N];
    		int[][] arr_180 = new int[N][N];
    		int[][] arr_270 = new int[N][N];
    		
    		for(int x = 0 ; x<N ; x++) {
    			StringTokenizer st = new StringTokenizer(br.readLine());
    			for(int y = 0 ; y<N ; y++) {
    				arr[x][y] = Integer.parseInt(st.nextToken());
    			}
    		}
    		for(int x = 0 ; x<N ; x++) {
    			for(int y = 0 ; y<N ; y++) {
    				arr_90[x][y] = arr[N-1-y][x]; 
    			}
    		}
    		for(int x = 0 ; x<N ; x++) {
    			for(int y = 0 ; y<N ; y++) {
    				arr_180[x][y] = arr_90[N-1-y][x];
    			}
    		}
    		for(int x = 0 ; x<N ; x++) {
    			for(int y = 0 ; y<N ; y++) {
    				arr_270[x][y] = arr_180[N-1-y][x];
    			}
    		}
    		System.out.println("#"+tc+" ");
    		for(int x = 0 ; x<N ; x++) {
    			for(int y = 0 ; y<N ; y++) {
        			System.out.print(arr_90[x][y]);
        		}
    			System.out.print(" ");
    			for(int y = 0 ; y<N ; y++) {
        			System.out.print(arr_180[x][y]);
        		}
    			System.out.print(" ");
    			for(int y = 0 ; y<N ; y++) {
        			System.out.print(arr_270[x][y]);
        		}
    			System.out.println();
    		}
    	}
    }
}

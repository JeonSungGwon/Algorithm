
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int T = Integer.parseInt(br.readLine());
    	
    	for (int tc = 1 ; tc<=T ; tc++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		int N = Integer.parseInt(st.nextToken());
    		int M = Integer.parseInt(st.nextToken());
    	
    		int[] A = new int[N];
    		int[] B = new int[M];
    		st = new StringTokenizer(br.readLine());
    		for(int i = 0 ; i<N ; i++) {
    			A[i] = Integer.parseInt(st.nextToken());
    		}
    		st = new StringTokenizer(br.readLine());
    		for(int i = 0 ; i<M ; i++) {
    			B[i] = Integer.parseInt(st.nextToken());
    		}
    		int result = 0;
    	
    		if(N>M) {
    			for (int x = 0 ; x+M-1<N ; x++) {
    				int mul = 0;
    				for(int y = 0 ; y<M ; y++) {
    					mul += A[x + y] * B[y];
    				}
    				result = Math.max(result, mul);
    			}
    		}
    		else {
    			for (int x = 0 ; x+N-1<M ; x++) {
    				int mul = 0;
    				for(int y = 0 ; y<N ; y++) {
    					mul += A[y] * B[x+y];
    				}
    				result = Math.max(result, mul);
    			}
    		
    		}
    	
    		System.out.println("#"+tc+" "+result);
    	}
    }
}

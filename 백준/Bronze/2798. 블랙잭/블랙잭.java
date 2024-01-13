import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	int [] card = new int [N];
    	
    	st = new StringTokenizer(br.readLine());
    	for(int i=0; i<N; i++) {
    		card[i] = Integer.parseInt(st.nextToken());
    	}
    	int cnt = 0;
    	for(int i=0; i<=N-3; i++) {
    		for(int j=i+1; j<=N-2; j++) {
    			for(int k=j+1; k<N; k++) {
    				int sum = card[i]+card[j]+card[k];
    				if(sum == M) {
    					System.out.println(sum);
    					return;
    				}
    				if(cnt < sum && sum < M) {
    					cnt = sum;
    				}
    			}
    		}
    	}
    	System.out.println(cnt);
    }
}
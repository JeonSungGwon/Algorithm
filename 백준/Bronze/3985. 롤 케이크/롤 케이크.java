import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int L = Integer.parseInt(br.readLine());
    	int N = Integer.parseInt(br.readLine());
    	boolean[] bread = new boolean[L+1];
    	int arr[][] = new int[N+1][2];
    	int cnt[] = new int[N+1];
    	int expect = 0;
    	int result = 0;
    	for(int i = 1 ; i<=N;  i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		for(int j = 0 ; j<2 ; j++) {
    			arr[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	for(int i = 1 ; i<=N ; i++) {
    		for(int j = arr[i][0] ; j<=arr[i][1] ; j++) {
    			if(bread[j] == false) {
    				bread[j] = true;
    				cnt[i] += 1;
    			}
    		}
    	}
    	
    	for(int i = 1 ; i<=N ; i++) {
    		expect = arr[i][1] - arr[i][0] > arr[expect][1] - arr[expect][0] ? i : expect;
    		result = cnt[i] > cnt[result] ? i : result; 
    	}
    	System.out.println(expect);
    	System.out.println(result);
    }
}
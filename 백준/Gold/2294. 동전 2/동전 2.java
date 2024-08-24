import java.util.*;
import java.io.*;

public class Main {
    static int[] dp;
    static int[] nums;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        dp = new int[k+1];
        nums = new int[n];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i = 0 ; i < n ; i++){
            nums[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 1 ; i <= k ; i++){
            for(int j = 0 ; j < n ; j++){
                if(i >= nums[j] && dp[i-nums[j]] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i-nums[j]] + 1, dp[i]);
                }
            }
        }

        if(dp[k] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(dp[k]);
        }
    }
}
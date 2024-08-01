import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] triangle) {
        
        int n = triangle.length;
        int[][] dp = new int[n][n];
        dp[0][0] = triangle[0][0];
        for(int i = 1 ; i < n ; i++){
            for(int j = 0 ; j < triangle[i].length ; j++){
                if(j == 0){
                    dp[i][j] = triangle[i][j] + dp[i-1][j];
                }
                else if(j == triangle[i].length-1){
                    dp[i][j] = triangle[i][j] + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = triangle[i][j] + Math.max(dp[i-1][j-1], dp[i-1][j]);
                }
            }
        }
        int answer = 0;
        
        for(int i = 0 ; i < n ; i++){
            if(answer < dp[n-1][i]){
                answer = dp[n-1][i];
            }
        }
        return answer;
    }
}
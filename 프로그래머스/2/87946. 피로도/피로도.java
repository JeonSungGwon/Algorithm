import java.util.*;
import java.io.*;

class Solution {
    static int len;
    static int[] numbers;
    static boolean[] visited;
    static int answer = -1;
    public int solution(int k, int[][] dungeons) {
        len = dungeons.length;
        numbers = new int[len];
        visited = new boolean[len];
        playGame(0, dungeons, k);
  
        return answer;
    }
    
    public static void playGame(int cnt, int[][] dungeons, int k){
        if(cnt == len){
            int count = 0;
            int currentK = k;
            for(int i = 0 ; i < len ; i++){
                int index = numbers[i];
                if(dungeons[index][0] <= currentK){
                    count++;
                    currentK -= dungeons[index][1];
                } 
            }
            answer = Math.max(answer, count);
            return;
        }
        
        for(int i = 0 ; i < len ; i++){
            if(visited[i]) continue;
            numbers[cnt] = i;
            visited[i] = true;
            playGame(cnt+1, dungeons, k);
            visited[i] = false;
        }
        
    }
}
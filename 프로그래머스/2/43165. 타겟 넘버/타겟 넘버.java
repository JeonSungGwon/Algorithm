import java.util.*;
import java.io.*;
class Solution {
    public int solution(int[] numbers, int target) {
        Queue<int[]> queue = new ArrayDeque<>();
        
        queue.offer(new int[]{numbers[0], 0});
        queue.offer(new int[]{-numbers[0], 0});
        
        int count = 0;
        while(!queue.isEmpty()){
            int[] arr = queue.poll();
            int num = arr[0];
            int idx = arr[1];
            
            if(idx == (numbers.length - 1) && num == target){
                count++;
                continue;
            }
            if(idx+1 < numbers.length){
                queue.offer(new int[]{num+numbers[idx+1], idx+1});
                queue.offer(new int[]{num-numbers[idx+1], idx+1});
            }
            
        }
        
        
        return count;
    }
}
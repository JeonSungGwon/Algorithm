import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long sum1 = 0;
        long sum2 = 0;
        long totalSum = 0;
        int num = 0;
        Queue<Integer> q1 = new ArrayDeque<Integer>();
        Queue<Integer> q2 = new ArrayDeque<Integer>();
        
        for(int i = 0 ; i < queue1.length ; i++){
            q1.offer(queue1[i]);
            q2.offer(queue2[i]);
            
            sum1 += queue1[i];
            sum2 += queue2[i];
        }
        totalSum = sum1+sum2;
        if(totalSum%2 != 0){
            return -1;
        }
        
        long target = totalSum/2;
        long limit = queue1.length * 3;
        while(sum1 != target && limit > answer){
            if(sum1 > sum2){
                num = q1.poll();
                q2.offer(num);
                answer++;
                sum1 -= num;
                sum2 += num;
            }else if(sum1 < sum2){
                num = q2.poll();
                q1.offer(num);
                answer++;
                sum2 -= num;
                sum1 += num;
            }
        }
        if(sum1 != target) return -1;
        
        return answer;
    }
}


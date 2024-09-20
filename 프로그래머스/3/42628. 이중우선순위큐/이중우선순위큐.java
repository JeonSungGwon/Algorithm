import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> maxPQ = new PriorityQueue<Integer>((a,b) -> b - a);
        PriorityQueue<Integer> minPQ = new PriorityQueue<Integer>(); 
        int[] answer = new int[2];
        
        for(String str : operations){
            if(str.charAt(0) == 'I'){  
                int a = Integer.parseInt(str.split(" ")[1]);
                maxPQ.offer(a);
                minPQ.offer(a);
            } else if(str.charAt(0) == 'D'){ 
                if (minPQ.isEmpty()) continue;
                
                int b = Integer.parseInt(str.split(" ")[1]);
                if(b > 0){ 
                    int max = maxPQ.poll();
                    minPQ.remove(max); 
                } else { 
                    int min = minPQ.poll();
                    maxPQ.remove(min);
                }
            }
        }
        
        if(maxPQ.isEmpty()) {  // 큐가 비어 있을 경우
            answer[0] = 0;
            answer[1] = 0;
        } else {  // 큐에 값이 남아 있을 경우
            answer[0] = maxPQ.poll();  // 최댓값
            answer[1] = minPQ.poll();  // 최솟값
        }
        
        return answer;
    }
}
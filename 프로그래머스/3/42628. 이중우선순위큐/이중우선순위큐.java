import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> maxPQ = new PriorityQueue<Integer>((a,b) -> b - a); // 최대 힙
        PriorityQueue<Integer> minPQ = new PriorityQueue<Integer>(); // 최소 힙
        int[] answer = new int[2];
        
        for(String str : operations){
            if(str.charAt(0) == 'I'){  // 삽입 연산
                int a = Integer.parseInt(str.split(" ")[1]);
                maxPQ.offer(a);
                minPQ.offer(a);
            } else if(str.charAt(0) == 'D'){  // 삭제 연산
                if (maxPQ.isEmpty()) continue;  // 큐가 비어 있으면 아무것도 하지 않음
                
                int b = Integer.parseInt(str.split(" ")[1]);
                if(b > 0){  // 최댓값 삭제
                    int max = maxPQ.poll();
                    minPQ.remove(max);  // minPQ에서도 동일한 값 제거
                } else {  // 최솟값 삭제
                    int min = minPQ.poll();
                    maxPQ.remove(min);  // maxPQ에서도 동일한 값 제거
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
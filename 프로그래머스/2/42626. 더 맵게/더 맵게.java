import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        int a,b;
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();

        for (int i = 0; i < scoville.length; i++) {
            queue.add(scoville[i]);
        }

        while(queue.peek() < K) {
            if (queue.size() < 2) {
                return -1;
            }
            else {
                a = queue.poll();
                b = queue.poll();

                a += (b * 2);
                queue.offer(a);
                answer += 1;
            }
        }
        return answer;
    }
}
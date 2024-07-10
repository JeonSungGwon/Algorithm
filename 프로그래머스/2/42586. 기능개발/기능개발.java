import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int n = progresses.length;
        ArrayList<Integer> list = new ArrayList<>();
        
        int daysToCompleteFirstTask = (int) Math.ceil((100.0 - progresses[0]) / speeds[0]);
        int count = 1;
        
        for (int i = 1; i < n; i++) {
            int daysToCompleteCurrentTask = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
            
            if (daysToCompleteFirstTask >= daysToCompleteCurrentTask) {
                count++;
            } else {
                list.add(count);
                daysToCompleteFirstTask = daysToCompleteCurrentTask;
                count = 1;
            }
        }
        
        list.add(count);
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}

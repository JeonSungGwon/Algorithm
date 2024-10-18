import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int left = 1; 
        int right = 100000; 
        int answer = right;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (carculator(diffs, times, mid, limit)) {
                answer = mid;
                right = mid - 1; 
            } else {
                left = mid + 1;  
            }
        }

        return answer;
    }

    public boolean carculator(int[] diffs, int[] times, int level, long limit) {
        long totalTime = 0; 
        long prevTime = 0; 

        for (int i = 0; i < diffs.length; i++) {
            if (diffs[i] <= level) {
                totalTime += times[i];
            } else {
                int mistakes = diffs[i] - level; 
                totalTime += mistakes * (times[i] + prevTime) + times[i];
            }
            if (totalTime > limit) {
                return false;
            }
            prevTime = times[i];
        }

        return true;
    }
}
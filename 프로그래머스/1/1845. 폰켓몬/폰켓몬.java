import java.util.*;
import java.io.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        Set<Integer> set = new HashSet<Integer>();
        int l = nums.length/2;
        for(int i = 0 ; i < nums.length ; i++){
            set.add(nums[i]);
            if(set.size() == l) break;
        }
        answer = set.size();
        return answer;
    }
}
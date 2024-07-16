import java.util.*;
import java.io.*;
class Solution {
    public int solution(int[] people, int limit) {
        int n = people.length;
        int left, right;
        Arrays.sort(people);
        left = 0;
        right = n-1;
        int count = 0;
        while(left<=right){
            if(people[left] + people[right] > limit) {
                right--;
                count++;
            }
            else{
                left++;
                right--;
                count++;
            }
        }
        
        
        
        return count;
    }
}
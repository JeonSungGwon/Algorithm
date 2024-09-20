import java.util.*;
import java.io.*;
    
class Solution {
    boolean solution(String s) {
        boolean answer = false;
        Stack<Character> stack = new Stack<>();
        for(int i = s.length()-1 ; i >= 0 ; i--){
            stack.add(s.charAt(i));
        }
        
        int result = 0;
        
        while(!stack.isEmpty()){
            char c = stack.pop();
            if(c == '(') result++;
            else if(c== ')') result--;
            
            if(result < 0) break;
        }
        
        if(result == 0){
            answer = true;
        }
        

        return answer;
    }
}
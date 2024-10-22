import java.util.*;
import java.io.*;
//order: [1, 2, 4, 3, 5] 일때 답이 5가 나오는지 확인해보세요.

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for(int i = 1 ; i <= order.length ; i++){
            if(!stack.isEmpty() && stack.peek() == order[index]){
                stack.pop();
                answer++;
                index++;
                i--;
                continue;
            }
            
            if(order[index] != i){
                stack.add(i);
            }else{
                index++;
                answer++;
            }
            
        }
        while(!stack.isEmpty() && stack.peek() == order[index]){
            stack.pop();
            index++;
            answer++;
        }
       
        return answer;
    }
}

    
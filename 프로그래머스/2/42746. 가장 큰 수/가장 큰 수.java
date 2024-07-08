import java.util.*;
import java.io.*;

class Solution {
    public String solution(int[] numbers) {
        String[] strNumbers = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strNumbers[i] = Integer.toString(numbers[i]);
        }

        
        Arrays.sort(strNumbers, (o1,o2) -> {
                String order1 = o1 + o2;
                String order2 = o2 + o1;
                return order2.compareTo(order1);
        });
        
        String answer = String.join("", strNumbers);
        
        if (answer.charAt(0) == '0') {
            return "0";
        }
        
        return answer;
    }
}
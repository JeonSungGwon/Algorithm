import java.util.*;
import java.io.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String,Integer> map = new HashMap<>();
        
        for(String name : participant){
            map.put(name,map.getOrDefault(name,0)+1);
        }
        
        for(String name : completion){
            map.put(name,map.get(name)-1);
        }
        
        for(String v : map.keySet()){
            if(0 < map.get(v)){
                answer = v;
            }
        }
        return answer;
    }
}
import java.util.*;
import java.io.*;
class Solution {
    public String[] solution(String[] record) {
        int n = record.length;
        String chat[][] = new String[n][3];
        for(int i = 0 ; i < n ; i++){
            chat[i] = record[i].split(" ");
        }
        Map<String, String> map = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            if(chat[i][0].equals("Enter") || chat[i][0].equals("Change")){
                map.put(chat[i][1], chat[i][2]);
            }
        }
        
        List<String> answer = new ArrayList<>();
        
        for(int i = 0 ; i < n ; i++){
            if(chat[i][0].equals("Enter")){
                answer.add(map.get(chat[i][1]) + "님이 들어왔습니다.");
            }
            else if(chat[i][0].equals("Leave")){
                answer.add(map.get(chat[i][1]) + "님이 나갔습니다.");
            }
        }
        
            
        return answer.toArray(new String[answer.size()]);
    }
}
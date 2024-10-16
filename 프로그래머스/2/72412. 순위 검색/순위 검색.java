import java.util.*;
import java.io.*;

class Solution {
    
    static HashMap<String, ArrayList<Integer>> hashMap = new HashMap<>();
    static ArrayList<Integer> score = new ArrayList<>();
    public int[] solution(String[] info, String[] query) {
        int[] answer = {};
        
        // 해쉬맵으로 모든 경우의 수 만들기
        for(String i : info){
            dfs(0, "", i.split(" "));
        }
        
        for(ArrayList<Integer> list : hashMap.values()){
            Collections.sort(list);
        }
        
        answer = new int[query.length];
        int i = 0;
        for (String q : query){
            String[] data = q.split(" and ");
            
            // 마지막 다시 split
            String[] s = data[3].split(" ");
            int target = Integer.parseInt(s[1]);
            data[3] = s[0];
            String key = String.join("",data);
            
            if(hashMap.containsKey(key)){
                ArrayList<Integer> list = hashMap.get(key);
                int start = 0;
                int end = list.size() - 1;
                
                while(start <= end){
                    int mid = (start+end) / 2;
                    if(list.get(mid) < target) {
                        start = mid + 1;
                    }else{
                        end = mid - 1;
                    }
                }
                answer[i] = list.size() - start;
            }
            i++;
        }
        return answer;
    }
    
    static void dfs(int depth, String query, String[] info){
        if(depth == 4){
            if(!hashMap.containsKey(query)){
                score = new ArrayList<>();
                score.add(Integer.parseInt(info[4]));
                hashMap.put(query, score);
            }else{
                hashMap.get(query).add(Integer.parseInt(info[4]));
            }
            return;
        }
        
        dfs(depth+1, query + "-", info);
        dfs(depth+1, query + info[depth], info);
    }
}
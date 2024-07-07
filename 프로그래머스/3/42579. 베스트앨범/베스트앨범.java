import java.util.*;
import java.io.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0 ; i < genres.length ; i++){
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }
        ArrayList<String> genreArr = new ArrayList<String>();
        for(String str : map.keySet()){
            genreArr.add(str);
        }
        Collections.sort(genreArr, (o1,o2) -> map.get(o2) - map.get(o1));
        
        ArrayList<Integer> answer = new ArrayList<Integer>();
        for(int i = 0 ; i < genreArr.size() ; i++){
            String str = genreArr.get(i);
            
            int max = 0;
            int firstIdx = -1;
            for(int j = 0 ; j < genres.length ; j++){
                if(str.equals(genres[j]) && max < plays[j]){
                    max = plays[j];
                    firstIdx = j;
                }
            }
            
            max = 0;
            int secondIdx = -1;
             for(int j = 0 ; j < genres.length ; j++){
                if(str.equals(genres[j]) && max < plays[j] && j != firstIdx){
                    max = plays[j];
                    secondIdx = j;
                }
            }
            
            answer.add(firstIdx);
            if(secondIdx >= 0)answer.add(secondIdx);
        }
        int[] answers = new int[answer.size()];
        for(int i = 0 ; i < answer.size() ; i++){
            answers[i] = answer.get(i);
        }
        
        return answers;
    }
}
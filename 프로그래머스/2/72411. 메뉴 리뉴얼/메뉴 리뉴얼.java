import java.util.*;

class Solution {
    static Map<String, Integer> map = new HashMap<>();
    static char[] strArr;
    
    public String[] solution(String[] orders, int[] course) {
        List<String> answerList = new ArrayList<>();

        for (int i = 0; i < orders.length; i++) {
            char[] chars = orders[i].toCharArray();
            Arrays.sort(chars);
            orders[i] = new String(chars);
        }

        for (int c : course) {
            map.clear();
            for (String order : orders) {
                if (order.length() >= c) {
                    strArr = new char[c]; 
                    createCombination(0, 0, c, order); 
                }
            }

            int maxCount = 2; 
            List<String> candidates = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getValue() > maxCount) {
                    maxCount = entry.getValue();
                    candidates.clear();
                    candidates.add(entry.getKey());
                } else if (entry.getValue() == maxCount) {
                    candidates.add(entry.getKey());
                }
            }
            answerList.addAll(candidates); 
        }

        Collections.sort(answerList);
        return answerList.toArray(new String[0]);
    }

    public static void createCombination(int cnt, int start, int limit, String str) {
        if (cnt == limit) {
            String combination = new String(strArr);
            map.put(combination, map.getOrDefault(combination, 0) + 1);
            return;
        }

        for (int i = start; i < str.length(); i++) {
            strArr[cnt] = str.charAt(i);
            createCombination(cnt + 1, i + 1, limit, str); 
        }
    }
}
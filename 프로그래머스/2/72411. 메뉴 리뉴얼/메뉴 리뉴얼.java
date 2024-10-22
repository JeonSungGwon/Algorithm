import java.util.*;

class Solution {
    static Map<String, Integer> map = new HashMap<>();
    static char[] strArr;
    
    public String[] solution(String[] orders, int[] course) {
        List<String> answerList = new ArrayList<>();

        // 각 주문 정렬
        for (int i = 0; i < orders.length; i++) {
            char[] chars = orders[i].toCharArray();
            Arrays.sort(chars);
            orders[i] = new String(chars);
        }

        for (int c : course) {
            map.clear(); // 매번 조합 길이별로 카운팅 초기화
            for (String order : orders) {
                if (order.length() >= c) {
                    strArr = new char[c]; // 조합의 크기에 맞게 배열 초기화
                    createCombination(0, 0, c, order); // 조합 생성
                }
            }

            // 가장 많이 선택된 조합 추출
            int maxCount = 2; // 최소 2번 이상 등장한 조합만 고려
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
            answerList.addAll(candidates); // 후보들을 정답 리스트에 추가
        }

        // 결과 정렬 후 배열로 변환
        Collections.sort(answerList);
        return answerList.toArray(new String[0]);
    }

    // 부분 조합을 생성하는 함수
    public static void createCombination(int cnt, int start, int limit, String str) {
        if (cnt == limit) {
            String combination = new String(strArr);
            map.put(combination, map.getOrDefault(combination, 0) + 1);
            return;
        }

        for (int i = start; i < str.length(); i++) {
            strArr[cnt] = str.charAt(i);
            createCombination(cnt + 1, i + 1, limit, str); // 재귀 호출로 부분 조합 생성
        }
    }
}
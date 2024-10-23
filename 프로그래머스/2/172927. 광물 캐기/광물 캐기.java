import java.util.*;

class Solution {
    static int pc = 0; 
    static int[] picksCount;
    static String[] pickArr = {"diamond", "iron", "stone"};
    static String[] mineralsG;
    static int answer = Integer.MAX_VALUE; 
    
    public int solution(int[] picks, String[] minerals) {
        mineralsG = minerals;
        picksCount = picks.clone(); // 곡괭이 개수 복사
        
        // 곡괭이 총 개수
        for (int i = 0; i < picks.length; i++) {
            pc += picks[i];
        }
        
        // 순열 탐색
        backtrack(0, 0, 0);
        
        return answer;
    }
    
    static void backtrack(int cnt, int index, int fatigue) {
        // 현재 피로도가 최소 피로도보다 크다면 가지치기
        if (fatigue >= answer) {
            return;
        }
        
        // 모든 곡괭이를 사용했거나, 광물을 다 캤을 때
        if (cnt == pc || index >= mineralsG.length) {
            answer = Math.min(answer, fatigue);
            return;
        }

        // 각 곡괭이를 사용해보는 순열 생성
        for (int i = 0; i < 3; i++) {
            if (picksCount[i] > 0) { // 사용 가능한 곡괭이가 있는지 확인
                picksCount[i]--; // 곡괭이 사용
                
                // 5번까지 캘 수 있는 광물 계산
                int currentFatigue = 0;
                int nextIndex = index;
                for (int j = 0; j < 5 && nextIndex < mineralsG.length; j++, nextIndex++) {
                    currentFatigue += calculateFatigue(pickArr[i], mineralsG[nextIndex]);
                }
                
                // 다음 순열 탐색
                backtrack(cnt + 1, nextIndex, fatigue + currentFatigue);
                
                picksCount[i]++; // 곡괭이 복구
            }
        }
    }
    
    static int calculateFatigue(String pick, String mineral) {
        if (pick.equals("diamond")) {
            return 1; // 다이아 곡괭이는 모든 광물에서 피로도 1
        } else if (pick.equals("iron")) {
            if (mineral.equals("diamond")) return 5; // 철 곡괭이는 다이아에서 피로도 5
            return 1; // 그 외에는 피로도 1
        } else {
            // 돌 곡괭이
            if (mineral.equals("diamond")) return 25; // 돌 곡괭이는 다이아에서 피로도 25
            if (mineral.equals("iron")) return 5; // 철에서 피로도 5
            return 1; // 돌에서 피로도 1
        }
    }
}
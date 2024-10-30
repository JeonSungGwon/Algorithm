import java.util.*;

class Solution {
    static int[] numbers = new int[11];
    static int[] infoG;
    static int maxDiff = 0;
    static int[] answer = {-1};

    public int[] solution(int n, int[] info) {
        infoG = info;
        dfs(0, n);
        return answer;
    }
    
    public void dfs(int idx, int arrowsLeft){
        if (idx == 10) {
            numbers[10] = arrowsLeft; // 남은 화살을 0점에 배정
            calculator();
            numbers[10] = 0; // 백트래킹
            return;
        }
        
        // 어피치를 이기기 위해 필요한 최소 화살 수
        int needArrows = infoG[idx] + 1;
        
        // 해당 점수를 얻는 경우
        if (needArrows <= arrowsLeft) {
            numbers[idx] = needArrows;
            dfs(idx + 1, arrowsLeft - needArrows);
            numbers[idx] = 0; // 백트래킹
        }
        
        // 해당 점수를 포기하는 경우
        dfs(idx + 1, arrowsLeft);
    }
    
    public void calculator() {
        int lionScore = 0;
        int apeachScore = 0;
        
        for (int i = 0 ; i < 11 ; i++) {
            if (numbers[i] == 0 && infoG[i] == 0) continue;
            if (numbers[i] > infoG[i]) {
                lionScore += 10 - i;
            } else {
                apeachScore += 10 - i;
            }
        }
        
        int scoreDiff = lionScore - apeachScore;
        
        if (scoreDiff > 0) {
            if (scoreDiff > maxDiff) {
                maxDiff = scoreDiff;
                answer = Arrays.copyOf(numbers, 11);
            } else if (scoreDiff == maxDiff) {
                // 낮은 점수를 더 많이 맞힌 경우로 업데이트
                for (int i = 10; i >= 0; i--) {
                    if (numbers[i] > answer[i]) {
                        answer = Arrays.copyOf(numbers, 11);
                        break;
                    } else if (numbers[i] < answer[i]) {
                        break;
                    }
                }
            }
        }
    }
}
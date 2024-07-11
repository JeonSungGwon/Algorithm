import java.util.*;

class Solution {
    static int n;
    static int m;
    static String[] wor;
    static boolean[] visited;
    static int answer;

    public int solution(String begin, String target, String[] words) {
        n = words.length;
        m = begin.length();
        wor = words;
        visited = new boolean[n];
        answer = Integer.MAX_VALUE;
        
        boolean isTargetInWords = false;
        for (String word : words) {
            if (word.equals(target)) {
                isTargetInWords = true;
                break;
            }
        }
        
        if (!isTargetInWords) {
            return 0; // target이 words 배열에 없으면 변환할 수 없으므로 0을 반환
        }
        
        DFS(begin, target, 0);
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }

    static void DFS(String word, String target, int count) {
        if (word.equals(target)) {
            answer = Math.min(answer, count);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;

            int diffCount = 0;
            for (int j = 0; j < m; j++) {
                if (word.charAt(j) != wor[i].charAt(j)) {
                    diffCount++;
                }
            }

            if (diffCount == 1) { // 단 한 글자만 다른 경우
                visited[i] = true;
                DFS(wor[i], target, count + 1);
                visited[i] = false;
            }
        }
    }
}

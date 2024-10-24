class Solution {
    public int solution(String name) {
        int n = name.length();
        int answer = 0;
        int minMove = n - 1; // 최대 가능한 이동 수로 초기화

        for (int i = 0; i < n; i++) {
            // 각 문자에 대한 상하 이동 계산
            char c = name.charAt(i);
            int upDown = Math.min(c - 'A', 'Z' - c + 1);
            answer += upDown;

            // 다음 'A'가 아닌 문자 인덱스 찾기
            int next = i + 1;
            while (next < n && name.charAt(next) == 'A') {
                next++;
            }

            // 최소 좌우 이동 계산
            minMove = Math.min(minMove, i + n - next + Math.min(i, n - next));
        }

        answer += minMove;
        return answer;
    }
}

import java.util.*;

class Solution {
    static int[] sale = {10, 20, 30, 40};
    static int[] numbers;
    static int length;
    static int[] emoticonsG;
    static int[][] usersG;
    static int n;
    static int[] answer;

    public int[] solution(int[][] users, int[] emoticons) {
        usersG = users;
        length = emoticons.length;
        emoticonsG = emoticons;
        n = users.length;
        numbers = new int[length];
        answer = new int[2]; // answer[0] = 가입자 수, answer[1] = 총 매출액

        permutation(0);

        return answer;
    }

    public static void permutation(int cnt){
        if (cnt == length) {
            double[] emoticonsL = new double[length];
            int[] localPay = new int[n];
            int localJoinCount = 0;

            // 이모티콘 할인 가격 계산
            for (int i = 0; i < length; i++) {
                emoticonsL[i] = emoticonsG[i] * (1 - numbers[i] / 100.0);
            }

            // 각 사용자별로 구매 금액 계산 및 구독 여부 판단
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < length; j++) {
                    if (usersG[i][0] <= numbers[j]) { // 할인율 기준 만족
                        localPay[i] += emoticonsL[j]; // 구매 금액 누적
                    }
                }
                if (localPay[i] >= usersG[i][1]) { // 가격 기준 이상이면 구독
                    localPay[i] = 0;
                    localJoinCount++;
                }
            }

            // 총 매출액 계산
            int totalPay = 0;
            for (int i = 0; i < n; i++) {
                totalPay += localPay[i]; // 각 사용자의 구매 금액 합산
            }

            // 최적의 결과 업데이트
            if (localJoinCount > answer[0] || (localJoinCount == answer[0] && totalPay > answer[1])) {
                answer[0] = localJoinCount;
                answer[1] = totalPay;
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            numbers[cnt] = sale[i];
            permutation(cnt + 1);
        }
    }
}

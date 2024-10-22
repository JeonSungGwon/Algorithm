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
        answer = new int[2];

        permutation(0);

        return answer;
    }
    
    public static void permutation(int cnt){
        if (cnt == length) {
            double[] emoticonsL = new double[length];
            int[] localPay = new int[n];
            int localJoinCount = 0;

            for (int i = 0; i < length; i++) {
                emoticonsL[i] = emoticonsG[i] * (1 - numbers[i] / 100.0);
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < length; j++) {
                    if (usersG[i][0] <= numbers[j]) { 
                        if (usersG[i][1] > (localPay[i] + emoticonsL[j])) {
                            localPay[i] += emoticonsL[j]; 
                        } else { 
                            localPay[i] = 0;
                            localJoinCount++;
                            break;
                        }
                    }
                }
            }

            int totalPay = 0;
            for (int i = 0; i < n; i++) {
                totalPay += Math.round(localPay[i]);
            }

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
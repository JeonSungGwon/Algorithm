class Solution {
    public int[] solution(int brown, int yellow) {
        int area = brown + yellow; 
        int[] answer = new int[2];
        
        for (int i = 1; i <= Math.sqrt(area); i++) {
            if (area % i == 0) {
                int j = area / i;
                if ((i - 2) * (j - 2) == yellow) {
                    answer[0] = j; 
                    answer[1] = i;
                    return answer;
                }
            }
        }
        
        return answer;
    }
}
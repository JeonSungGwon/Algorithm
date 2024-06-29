class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int[] dx = {0, 1, -1, 0};
        int[] dy = {1 ,0 ,0, -1};
        
        String color = board[h][w];
        for(int idx = 0 ; idx < 4 ; idx++){
            int nx = h + dx[idx];
            int ny = w + dy[idx];
            if(nx >= 0 && nx < board.length && ny >= 0 && ny < board.length
                && board[nx][ny].equals(color)){
                answer++;
            }
        }
        
        return answer;
    }
}
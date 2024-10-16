import java.util.*;

class Solution {
    
    static int[] dx = {0, 1, 0, -1}; // 오른쪽, 아래, 왼쪽, 위
    static int[] dy = {1, 0, -1, 0};
    static int n;
    
    public int solution(int[][] board) {
        n = board.length;
        int[][][] cost = new int[n][n][4]; // 각 위치와 방향별 비용을 저장하는 3차원 배열
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(cost[i][j], Integer.MAX_VALUE);
            }
        }
        
        Queue<Node> queue = new LinkedList<>();
        for (int i = 0; i < 4; i++) {
            queue.add(new Node(0, 0, i, 0));
            cost[0][0][i] = 0;
        }
        
        int answer = Integer.MAX_VALUE;
        
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            int x = current.x;
            int y = current.y;
            int direction = current.direction;
            int currentCost = current.cost;
            
            if (x == n - 1 && y == n - 1) {
                answer = Math.min(answer, currentCost);
                continue;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx >= 0 && ny >= 0 && nx < n && ny < n && board[nx][ny] == 0) {
                    int newCost = currentCost + ((direction == i) ? 100 : 600);
                    
                    if (newCost < cost[nx][ny][i]) {
                        cost[nx][ny][i] = newCost;
                        queue.add(new Node(nx, ny, i, newCost));
                    }
                }
            }
        }
        
        return answer;
    }
    
    static class Node {
        int x, y, direction, cost;
        
        public Node(int x, int y, int direction, int cost) {
            this.x = x;
            this.y = y;
            this.direction = direction;
            this.cost = cost;
        }
    }
}

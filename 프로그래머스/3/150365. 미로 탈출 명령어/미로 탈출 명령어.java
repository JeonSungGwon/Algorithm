import java.util.*;

class Solution {
    static int[] dx = {1, 0, 0, -1}; // d, l, r, u 순
    static int[] dy = {0, -1, 1, 0}; // d, l, r, u 순
    static String[] directions = {"d", "l", "r", "u"};
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        int remainingDistance = Math.abs(x - r) + Math.abs(y - c);

        // 남은 이동 횟수로 목적지에 도달할 수 없다면 불가능
        if (remainingDistance > k || (k - remainingDistance) % 2 != 0) {
            return "impossible";
        }

        // 방문 여부를 체크하는 3차원 배열 (x좌표, y좌표, 이동 횟수)
        boolean[][][] visited = new boolean[n + 1][m + 1][k + 1];
        
        // BFS 탐색을 위한 우선순위 큐 (사전순 경로 탐색을 위해 경로를 먼저 비교)
        Queue<Node> pq = new PriorityQueue<>(Comparator.comparing(o -> o.path));
        pq.offer(new Node(x, y, 0, ""));
        visited[x][y][0] = true;

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int cx = current.x, cy = current.y, steps = current.steps;
            String path = current.path;

            // 목적지 도달 및 이동 횟수 정확히 맞으면 반환
            if (cx == r && cy == c && steps == k) {
                return path;
            }

            if (steps >= k) continue;

            // 네 방향으로 이동
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (nx >= 1 && ny >= 1 && nx <= n && ny <= m && !visited[nx][ny][steps + 1]) {
                    visited[nx][ny][steps + 1] = true;
                    pq.offer(new Node(nx, ny, steps + 1, path + directions[i]));
                }
            }
        }

        return "impossible";
    }

    // 좌표와 경로 상태를 저장하는 클래스
    static class Node {
        int x, y, steps;
        String path;
        Node(int x, int y, int steps, String path) {
            this.x = x;
            this.y = y;
            this.steps = steps;
            this.path = path;
        }
    }
}
import java.util.*;
import java.io.*;

public class Main {
    static int[][] map;
    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {1, 0, 0, -1};
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        System.out.println(BFS());
    }

    static int BFS() {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        boolean[][] visited = new boolean[N][M];
        pq.offer(new int[]{0, 0, 0});
        visited[0][0] = true;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int x = cur[0];
            int y = cur[1];
            int count = cur[2];

            if (x == N - 1 && y == M - 1) {
                return count;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    if (map[nx][ny] == 0) {
                        pq.offer(new int[]{nx, ny, count});
                    } else {
                        pq.offer(new int[]{nx, ny, count + 1});
                    }
                }
            }
        }
        return -1;
    }
}

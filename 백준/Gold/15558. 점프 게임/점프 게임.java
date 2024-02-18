import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {-1, 0, 0, 1};
    static int N, k;
    static int clear = 0;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[2][N];
        visited = new boolean[2][N];

        for (int i = 0; i < 2; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        BFS(0, 0, 0);
        System.out.println(clear);
    }

    private static void BFS(int x, int y, int Time) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x, y, Time});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] xy = q.poll();

            int ax = xy[0];
            int ay = xy[1];
            int aTime = xy[2];

            if (ay < aTime) {
            	continue;
            }

            for (int i = 0; i < 4; i++) {
                int nx, ny;

                if (i == 1 || i == 2) {
                    nx = ax + dx[i];
                    ny = ay + dy[i] + k;
                } else {
                    nx = ax + dx[i];
                    ny = ay + dy[i];
                }

                if (nx >= 0 && ny >= 0 && nx < 2 && ny >= N) {
                    clear = 1;
                    break;
                }

                if (nx >= 0 && ny >= 0 && nx < 2 && ny < N && map[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny, aTime + 1});
                }
            }

            if (clear == 1) {
                break;
            }
        }
    }
}

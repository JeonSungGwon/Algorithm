import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static char[][] board;
    static boolean[][] visited;
    static boolean[][] finished; // DFS가 끝난 노드를 체크
    static int N, M;
    static int count = 0;

    static int[] dx = {-1, 1, 0, 0}; // U, D, L, R
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        visited = new boolean[N][M];
        finished = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                }
            }
        }

        System.out.println(count);
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;

        int nx = x, ny = y;
        switch (board[x][y]) {
            case 'U':
                nx = x + dx[0];
                ny = y + dy[0];
                break;
            case 'D':
                nx = x + dx[1];
                ny = y + dy[1];
                break;
            case 'L':
                nx = x + dx[2];
                ny = y + dy[2];
                break;
            case 'R':
                nx = x + dx[3];
                ny = y + dy[3];
                break;
        }

        if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
            if (!visited[nx][ny]) {
                dfs(nx, ny);
            } else if (!finished[nx][ny]) {
                // 사이클 발견
                count++;
            }
        }

        finished[x][y] = true; // DFS가 끝난 노드로 표시
    }
}

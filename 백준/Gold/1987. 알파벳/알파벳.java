import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int R, C;
    static char[][] board;
    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {1, 0, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R][C];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        boolean[] visited = new boolean[26];
        visited[board[0][0] - 'A'] = true;
        System.out.println(DFS(0, 0, visited));
    }

    private static int DFS(int i, int j, boolean[] visited) {

        int maxResult = 1; 
        
        for (int idx = 0; idx < 4; idx++) {
            int nx = i + dx[idx];
            int ny = j + dy[idx];
            if (nx >= 0 && ny >= 0 && nx < R && ny < C) {
                int charIndex = board[nx][ny] - 'A';
                if (!visited[charIndex]) {
                    visited[charIndex] = true;
                    maxResult = Math.max(maxResult, 1 + DFS(nx, ny, visited));
                    visited[charIndex] = false;
                }
            }
        }
        
        return maxResult;
    }
}

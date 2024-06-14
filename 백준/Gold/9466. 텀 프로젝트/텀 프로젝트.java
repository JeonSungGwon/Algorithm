import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] board;
    static boolean[] visited, finished;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int tc = 0; tc < T; tc++) {
            int n = Integer.parseInt(br.readLine());
            board = new int[n + 1];
            visited = new boolean[n + 1];
            finished = new boolean[n + 1];
            count = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                board[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    dfs(i);
                }
            }

            sb.append(n - count).append("\n");
        }

        System.out.println(sb);
    }

    private static void dfs(int current) {
        visited[current] = true;
        int next = board[current];

        if (!visited[next]) {
            dfs(next);
        } else if (!finished[next]) { // 사이클 발견
            for (int temp = next; temp != current; temp = board[temp]) {
                count++;
            }
            count++;
        }

        finished[current] = true; // 현재 노드 방문 완료
    }
}

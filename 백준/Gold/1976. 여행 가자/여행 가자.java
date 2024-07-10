import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int[][] graph;
    static int[] course;
    static int N, M;
    static boolean[] visited;
    static boolean result = true;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        
        graph = new int[N+1][N+1];
        
        for(int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        course = new int[M];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < M ; i++) {
            course[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M - 1; i++) {
            visited = new boolean[N + 1];
            if (!DFS(course[i], course[i + 1])) {
                result = false;
                break;
            }
        }

        if(result) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static boolean DFS(int start, int goal) {
        if (start == goal) {
            return true;
        }

        visited[start] = true;

        for (int next = 1; next <= N; next++) {
            if (graph[start][next] == 1 && !visited[next]) {
                if (DFS(next, goal)) {
                    return true;
                }
            }
        }

        return false;
    }
}

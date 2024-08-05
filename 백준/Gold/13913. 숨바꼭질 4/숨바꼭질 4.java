import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static boolean[] visited = new boolean[100001];
    static int[] prev = new int[100001];
    static Queue<int[]> q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        BFS(N);
    }

    static void BFS(int start) {
        q.offer(new int[]{start, 0});
        visited[start] = true;
        prev[start] = -1; 

        while (!q.isEmpty()) {
            int[] arr = q.poll();
            int num = arr[0];
            int cnt = arr[1];

            if (num == K) {
                System.out.println(cnt);
                printPath(num);
                return;
            }

            int[] nextPositions = {num - 1, num + 1, num * 2};
            for (int next : nextPositions) {
                if (next >= 0 && next <= 100000 && !visited[next]) {
                    q.offer(new int[]{next, cnt + 1});
                    visited[next] = true;
                    prev[next] = num; 
                }
            }
        }
    }

    static void printPath(int end) {
        List<Integer> path = new ArrayList<>();
        for (int at = end; at != -1; at = prev[at]) {
            path.add(at);
        }

        for (int i = path.size() - 1; i >= 0; i--) {
            System.out.print(path.get(i) + " ");
        }
        System.out.println();
    }
}

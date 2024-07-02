import java.io.*;
import java.util.*;

public class Main {

    static int[][] map;
    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {1, 0, 0, -1};
    static int N,M;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        map = new int[M][N];

        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            int lx = Integer.parseInt(st.nextToken());
            int ly = Integer.parseInt(st.nextToken());
            int rx = Integer.parseInt(st.nextToken());
            int ry = Integer.parseInt(st.nextToken());
            for(int a = ly ; a < ry ; a++){
                for(int b = lx ; b < rx ; b++){
                    map[a][b]++;
                }
            }
        }
        visited = new boolean[M][N];
        Queue<Integer> q = new PriorityQueue<>();
        for(int i = 0 ; i < M ; i++){
            for(int j = 0 ; j < N ; j++){
                if(map[i][j] == 0 && !visited[i][j]){
                    int cnt = BFS(i,j);
                    q.offer(cnt);
                }
            }
        }
        System.out.println(q.size());
        while (!q.isEmpty()){
            System.out.print(q.poll() + " ");
        }

    }
static boolean[][] visited;
    private static int BFS(int i, int j) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{i, j});
        visited[i][j] = true;
        int cnt = 1;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int ax = cur[0];
            int ay = cur[1];

            for (int idx = 0; idx < 4; idx++) {
                int nx = ax + dx[idx];
                int ny = ay + dy[idx];
                if (nx >= 0 && ny >= 0 && nx < M && ny < N && !visited[nx][ny] && map[nx][ny] == 0) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                    cnt++;
                }
            }
        }
        return cnt;
    }
}

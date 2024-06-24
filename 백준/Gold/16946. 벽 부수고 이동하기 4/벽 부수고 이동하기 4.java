import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] board;
    static int[][] result;
    static int[][] component;
    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {1, 0, 0 ,-1};
    static int N, M;
    static int componentIndex = 0;
    static Map<Integer, Integer> componentSize = new HashMap<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        result = new int[N][M];
        component = new int[N][M];
        
        for(int i = 0 ; i < N ; i++) {
            String str = br.readLine();
            for(int j = 0 ; j < M ; j++) {
                board[i][j] = str.charAt(j) - '0';
            }
        }
        
        boolean[][] visited = new boolean[N][M];
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(board[i][j] == 0 && !visited[i][j]) {
                    int size = BFS(i, j, component, visited);
                    componentSize.put(componentIndex++, size);
                }
            }
        }
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(board[i][j] == 1) {
                    result[i][j] = calculateNewValue(i, j);
                } else {
                    result[i][j] = 0; // For the output format requirement
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                sb.append(result[i][j] % 10);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
    
    private static int BFS(int x, int y, int[][] component, boolean[][] visited) {
        Queue<int[]> q = new ArrayDeque<>();
        visited[x][y] = true;
        q.offer(new int[] {x, y});
        int size = 0;
        
        while(!q.isEmpty()) {
            int[] arr = q.poll();
            int ax = arr[0];
            int ay = arr[1];
            component[ax][ay] = componentIndex;
            size++;
            
            for(int idx = 0; idx < 4; idx++) {
                int nx = ax + dx[idx];
                int ny = ay + dy[idx];
                if(nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny] && board[nx][ny] == 0) {
                    visited[nx][ny] = true;
                    q.offer(new int[] {nx, ny});
                }
            }
        }
        
        return size;
    }
    
    private static int calculateNewValue(int x, int y) {
        Set<Integer> uniqueComponents = new HashSet<>();
        
        for(int idx = 0; idx < 4; idx++) {
            int nx = x + dx[idx];
            int ny = y + dy[idx];
            if(nx >= 0 && ny >= 0 && nx < N && ny < M && board[nx][ny] == 0) {
                uniqueComponents.add(component[nx][ny]);
            }
        }
        
        int newValue = 1;
        for(int comp : uniqueComponents) {
            newValue += componentSize.get(comp);
        }
        
        return newValue;
    }
}

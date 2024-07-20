import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] ladder;
    static int N, M, H;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        ladder = new int[H+1][N+1];

        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());
            ladder[a][b] = 1;
            ladder[a][b+1] = 2;
        }
        
        if (M == 0) {
            if (check()) {
                System.out.println(0);
            } else {
                System.out.println(-1);
            }
            return;
        }

        for(int i = 0 ; i <= 3 ; i++){
            dfs(0, i);
            if(result){
                answer = i;
                break;
            }
        }

        if(answer == Integer.MAX_VALUE){
            answer = -1;
        }
        System.out.println(answer);
    }

    static boolean result;
    static int answer = Integer.MAX_VALUE;
    private static void dfs(int cnt, int lad) {
        if(cnt == lad){
            result = check();
            return;
        }
        if(result) {
            return;
        }
        for(int i = 1 ; i <= H ; i++){
            for(int j = 1 ; j < N ;j++){
                if(ladder[i][j] != 0)continue;
                if(ladder[i][j+1] != 0) continue;
                ladder[i][j] = 1;
                ladder[i][j+1] = 2;
                dfs(cnt+1, lad);
                ladder[i][j] = 0;
                ladder[i][j+1] = 0;
                if (result) return;
            }
        }
    }

    static boolean check(){

        for(int i = 1 ; i <= N ; i++){
            int x = 1;
            int y = i;
            while(x <= H){
                if(ladder[x][y] == 1) y++;
                else if(ladder[x][y] == 2) y--;
                x++;
            }

            if(y != i) return false;
        }
        return true;
    }
}

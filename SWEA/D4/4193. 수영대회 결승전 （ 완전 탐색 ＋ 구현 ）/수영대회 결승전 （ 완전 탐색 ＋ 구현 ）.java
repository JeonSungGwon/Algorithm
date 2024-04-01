import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {


    static int N;
    static boolean[][] visit;
    static int[][] arr;
    static int cnt;
    static int start_x, start_y, end_x, end_y;
    static int[] dy = {-1,0,1,0};
    static int[] dx = {0,-1,0,1};


    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stf = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(stf.nextToken());
//        int T = 10;
        for(int test_case = 1; test_case <= T; test_case++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());


            arr = new int[N][N];
            visit = new boolean[N][N];

            cnt = N*N;

            for (int i = 0; i < N; i++) {
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st2.nextToken());
                }
            }

            StringTokenizer start = new StringTokenizer(br.readLine());
            start_y = Integer.parseInt(start.nextToken());
            start_x = Integer.parseInt(start.nextToken());
            StringTokenizer end = new StringTokenizer(br.readLine());
            end_y = Integer.parseInt(end.nextToken());
            end_x = Integer.parseInt(end.nextToken());

//            visit[start_y][start_x] = true;
//            dfs(start_y, start_x, 0);


            int time = N*N;
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{start_y, start_x, 0});

            while (!queue.isEmpty()){
                int[] po = queue.poll();
                int y = po[0]; int x = po[1]; int t = po[2];
                visit[y][x] = true;

                if(y==end_y && x==end_x){
                    time = t; break;
                }

                for (int d = 0; d < 4; d++) {
                    int py = y+dy[d];
                    int px = x+dx[d];


                    if(py<0||py>=N||px<0||px>=N) continue;
                    if(!visit[py][px]){

                        if(arr[py][px]==1) continue;
                        else if(arr[py][px]==2){
//                    System.out.println("다음에 소용돌이 만남" + py + ", "+ px+", "+(t+1)+"초");
                            if((t)%3==0){
                                visit[y][x] = true;
                                queue.add(new int[]{y, x, t+1});
                            }
                            else if((t)%3==1){
                                visit[y][x] = true;
                                queue.add(new int[]{y, x, t+1});
                            }
                            else if((t)%3==2){
                                visit[py][px] = true;
                                queue.add(new int[]{py, px, t+1});
                            }
                        }
                        else {
                            visit[py][px] = true;
                            queue.add(new int[]{py, px, t+1});
                        }
                    }


                }
            }




            int ans = time;
            if(time == N*N) ans = -1;

            System.out.println("#"+test_case+" "+ans);



        }


    }
}
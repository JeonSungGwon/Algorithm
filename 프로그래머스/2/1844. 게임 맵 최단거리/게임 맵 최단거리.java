import java.util.*;
import java.io.*;

class Solution {
    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {1, 0 ,0 ,-1};
    static boolean[][] visited;
    static int answer = -1;
    static int n,m;
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        visited = new boolean[n][m];
        BFS(maps);
        return answer;
    }
    public static void BFS(int[][] maps){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0,0,1});
        visited[0][0] = true;
        
        while(!q.isEmpty()){
            int[] arr = q.poll();
            int ax = arr[0];
            int ay = arr[1];
            int count = arr[2];
            if(ax == n-1 && ay == m-1){
                answer = count;
                return;
            }
            
            for(int i = 0 ; i < 4 ; i++){
                int nx = ax+dx[i];
                int ny = ay+dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<m && !visited[nx][ny] && maps[nx][ny] == 1){
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx,ny,count+1});
                }
            }
        }
    }
}
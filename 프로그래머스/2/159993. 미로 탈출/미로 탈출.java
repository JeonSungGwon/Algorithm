import java.util.*;
import java.io.*;

class Solution {
    static boolean[][] visited;
    static char[][] charMap;
    static int n, m;
    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {1, 0, 0, -1};
    
    public int solution(String[] maps) {
        int answer = 0;
        int currentX = 0, currentY = 0;
        int leverX = 0, leverY = 0;
        int exitX = 0, exitY = 0;
        charMap = new char[maps.length][maps[0].length()];
        
        for(int i = 0 ; i < maps.length ; i++){
            charMap[i] = maps[i].toCharArray();
        }
        
        n = charMap.length;
        m = charMap[0].length;
        visited = new boolean[n][m];
        
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(charMap[i][j] == 'S'){
                    currentX = i;
                    currentY = j;
                }else if(charMap[i][j] == 'L'){
                    leverX = i;
                    leverY = j;
                }else if(charMap[i][j] == 'E'){
                    exitX = i;
                    exitY = j;
                }
            }
        }
        
        answer = BFSL(currentX, currentY, leverX, leverY, exitX, exitY);
        
        
        return answer;
    }
    
    public int BFSL(int currentX, int currentY, int leverX, int leverY, int exitX, int exitY){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{currentX, currentY, 0});
        
        while(!q.isEmpty()){
            int[] arr = q.poll();
            int ax = arr[0];
            int ay = arr[1];
            int cnt = arr[2];
            if(ax == leverX && ay == leverY){
                visited = new boolean[n][m];
                int bcnt = BFSE(ax, ay, exitX, exitY);
                if(bcnt == -1) return -1;
                return bcnt + cnt;
            }
            for(int i = 0 ; i < 4 ; i++){
                int nx = ax + dx[i];
                int ny = ay + dy[i];
                if(nx>=0 && ny>=0 && nx<n && ny<m && !visited[nx][ny] && charMap[nx][ny] != 'X'){
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny, cnt+1});
                }
            }
        }
        return -1;
        
    }
    public int BFSE(int currentX, int currentY, int exitX, int exitY){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{currentX, currentY, 0});
        
        while(!q.isEmpty()){
            int[] arr = q.poll();
            int ax = arr[0];
            int ay = arr[1];
            int cnt = arr[2];
            if(ax == exitX && ay == exitY){
                return cnt;
            }
            for(int i = 0 ; i < 4 ; i++){
                int nx = ax + dx[i];
                int ny = ay + dy[i];
                if(nx>=0 && ny>=0 && nx<n && ny<m && !visited[nx][ny] && charMap[nx][ny] != 'X'){
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny, cnt+1});
                }
            }
        }
        
        return -1;
        
    }
}
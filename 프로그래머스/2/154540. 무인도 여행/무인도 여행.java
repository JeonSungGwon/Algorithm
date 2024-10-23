import java.util.*;
import java.io.*;

class Solution {
    static char[][] cMaps;
    static boolean[][] visited;
    static int n, m;
    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {1, 0, 0, -1};
    static ArrayList<Integer> list = new ArrayList<>();
    public int[] solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        cMaps = new char[n][m];
        visited = new boolean[n][m];
        
        for(int i = 0 ; i < maps.length ; i++){
            cMaps[i] = maps[i].toCharArray();
        }
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(cMaps[i][j] != 'X' && !visited[i][j]){
                    visited[i][j] = true;
                    int foods = BFS(i, j);
                    list.add(foods+cMaps[i][j] - '0');
                }
            }
        }
        
        if(list.size() == 0) return new int[]{-1};
        Collections.sort(list);
        int[] answer = new int[list.size()];
        for(int i = 0 ; i < list.size() ; i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
    
    static int BFS(int currentX, int currentY){
        
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {currentX, currentY});
        int result = 0;
        while(!q.isEmpty()){
            int[] arr = q.poll();
            int ax = arr[0];
            int ay = arr[1];
            for(int i = 0 ; i < 4 ; i++){
                int nx = ax+dx[i];
                int ny = ay+dy[i];
                if(nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny] && cMaps[nx][ny] != 'X'){
                    visited[nx][ny] = true;
                    result += cMaps[nx][ny] - '0';
                    q.offer(new int[] {nx, ny});
                }
            }
        }
        
        return result;
    }
}
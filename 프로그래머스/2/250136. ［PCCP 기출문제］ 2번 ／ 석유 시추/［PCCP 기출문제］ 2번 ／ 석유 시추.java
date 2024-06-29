import java.util.*;

class Solution {
    static boolean[][] v;
    static int[][] map;
    static int[] memo;
    static int N, M, cnt, ans;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    public int solution(int[][] land) {
        M = land[0].length;
        N = land.length;
        ans = 0;
        
        map = land;
        memo = new int[M];
        v = new boolean[N][M];
        
        for(int j = 0 ; j < M ; j ++){
            
            for(int i = 0 ; i < N ; i ++){
                if(v[i][j] || map[i][j] == 0) continue;
                bfs(i, j);
            }
        }
        int ans = 0;
        for(int i = 0 ; i < M ; i ++)
            ans = Math.max(ans, memo[i]);
        
        return ans;
    }
    static int bfs(int sr, int sc){
        Queue<int[]> q = new ArrayDeque<>();
        Set<Integer> set = new LinkedHashSet<>();
        q.offer(new int[] {sr, sc});
        v[sr][sc] = true;
        int cnt = 1;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            set.add(cur[1]);
            
            for(int d = 0 ; d < 4 ; d ++){
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];
                
                if(!isValid(nr, nc) || map[nr][nc] == 0 || v[nr][nc]) continue;
                
                v[nr][nc] = true;
                cnt ++;
                q.offer(new int[] {nr, nc});
            }
        }
        
        for(int cur: set)
            memo[cur] += cnt;
        
        return cnt;
    }
    static boolean isValid(int nr, int nc){
        return (nr>=0 && nr<N && nc>=0 && nc<M);
    }
}

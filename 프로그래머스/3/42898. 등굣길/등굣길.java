import java.util.*;

class Solution {
    static int[] dx = {0, 1};
    static int[] dy = {1, 0};
    static int[][] map;

    public int solution(int m, int n, int[][] puddles) {
        map = new int[n][m];

        for(int[] puddle : puddles) {
            map[puddle[1] - 1][puddle[0] - 1] = -1;
        }

        map[0][0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
        
                if (map[i][j] == -1) {
                    map[i][j] = 0; 
                    continue;
                }
      
                if (i > 0) {
                    map[i][j] += map[i - 1][j];
                }

                if (j > 0) {
                    map[i][j] += map[i][j - 1];
                }

                map[i][j] %= 1_000_000_007;
            }
        }

        return map[n - 1][m - 1];
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int [][] edges;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        edges = new int[V+1][V+1];
        for(int[] arr : edges){
            Arrays.fill(arr, 987654321);
        }

        for(int i = 0 ; i < E ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges[a][b] = c;
        }


        for(int k = 1 ; k <= V ; k++){
            for(int i = 1 ; i <= V ; i++){
                for(int j = 1 ; j <= V ; j++){
                    edges[i][j] = Math.min(edges[i][k] + edges[k][j], edges[i][j]);
                }
            }
        }

        int min = 987654321;
        for(int i=1;i<=V;i++) {
            min = Math.min(min, edges[i][i]);
        }
        if(min==987654321) min = -1;
        System.out.println(min);

    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Pos implements Comparable<Pos> {
        int from;
        int to;
        int cost;

        Pos(int to, int cost){
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pos o) {
            return this.cost - o.cost ;
        }

    }
    static ArrayList<ArrayList<Pos>> go = new ArrayList<>();
    static int N, M, X;
    static int INF = 1_000_000_000;
    static ArrayList<ArrayList<Pos>> back = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < N+1 ; i++){
            go.add(new ArrayList<>());
            back.add(new ArrayList<>());
        }

        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            go.get(from).add(new Pos(to, cost));
            back.get(to).add(new Pos(from, cost));
        }

        int[] time1 = dijkstra(go, X);
        int[] time2 = dijkstra(back, X);

        int result  = Integer.MIN_VALUE;
        for(int i = 1 ; i < N+1 ; i++){
            int dis = time1[i] + time2[i];
            if(result < dis){
                result = dis;
            }
        }

        System.out.println(result);
    }

    private static int[] dijkstra(ArrayList<ArrayList<Pos>> back, int x) {
        boolean[] visited = new boolean[N+1];
        int[] dp = new int[N+1];
        Queue<Pos> q = new PriorityQueue<>();
        Arrays.fill(dp, INF);

        q.add(new Pos(x, 0));
        dp[x] = 0;

        while(!q.isEmpty()){
            Pos pos = q.poll();
            int to = pos.to;
            if(visited[to]) continue;

            visited[to] = true;

            for(Pos next : back.get(to)) {
                if (dp[to] + next.cost < dp[next.to]) {
                    dp[next.to] = dp[to] + next.cost;
                    q.add(new Pos(next.to, dp[next.to]));
                }
            }


        }
        return dp;
    }
}

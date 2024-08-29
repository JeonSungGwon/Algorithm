import java.util.*;
import java.io.*;

public class Main {

    static class Node implements Comparable<Node> {
        int end, cost;
        public Node(int end, int cost){
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
    static ArrayList<Node>[] graph;
    static int[][] cost;

    static int N, E;
    static int MAX_VALUE = 200_000_100;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for(int i = 0 ; i <= N ; i++){
            graph[i] = new ArrayList<Node>();
        }

        for(int i = 0 ; i < E ; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b,c));
            graph[b].add(new Node(a, c));
        }
        st = new StringTokenizer(br.readLine());
        int value1 = Integer.parseInt(st.nextToken());
        int value2 = Integer.parseInt(st.nextToken());

        int dist1 = 0;
        int dist2 = 0;

        dist1 += dijkstra(1, value1);
        dist1 += dijkstra(value1, value2);
        dist1 += dijkstra(value2, N);

        dist2 += dijkstra(1, value2);
        dist2 += dijkstra(value2, value1);
        dist2 += dijkstra(value1, N);

        int result = Math.min(dist1, dist2);
        if(result >= MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }

    }

    public static int dijkstra(int start , int end){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] distance = new int[N+1];

        for(int i = 0 ; i <= N ; i++){
            distance[i] = MAX_VALUE;
        }

        pq.add(new Node(start, 0));
        distance[start] = 0;

        while(!pq.isEmpty()){
            Node node = pq.poll();

            int num = node.end;
            int dist = node.cost;

            if(distance[num] < dist){
                continue;
            }
            for(Node n : graph[num]) {
                int nextNum = n.end;
                int nextDist = n.cost;

                int cost = dist + nextDist;

                if(cost < distance[nextNum]){
                    distance[nextNum] = cost;
                    pq.add(new Node(nextNum, cost));
                }
            }
        }
        return distance[end];
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int end;
        int time;

        Node(int end, int time) {
            this.end = end;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return this.time - o.time;
        }
    }

    static ArrayList<Node>[] arr;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); 
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            arr = new ArrayList[n + 1];
            distance = new int[n + 1];
            Arrays.fill(distance, Integer.MAX_VALUE);

            for (int i = 1; i <= n; i++) {
                arr[i] = new ArrayList<>();
            }

            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                arr[b].add(new Node(a, s));
            }

            dijkstra(c);

            int infectedComputers = 0;
            int maxTime = 0;

            for (int i = 1; i <= n; i++) {
                if (distance[i] != Integer.MAX_VALUE) {
                    infectedComputers++;
                    maxTime = Math.max(maxTime, distance[i]);
                }
            }

            System.out.println(infectedComputers + " " + maxTime);
        }
    }

    static public void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        distance[start] = 0;

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int curNode = current.end;
            int curTime = current.time;

            if (curTime > distance[curNode]) continue;

            for (Node next : arr[curNode]) {
                if (distance[next.end] > curTime + next.time) {
                    distance[next.end] = curTime + next.time;
                    pq.add(new Node(next.end, distance[next.end]));
                }
            }
        }
    }
}
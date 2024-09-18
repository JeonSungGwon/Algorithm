import java.util.*;

class Solution {
    static class Node implements Comparable<Node> {
        int vertex;
        int distance;
        
        public Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
        
        @Override
        public int compareTo(Node o) {
            return this.distance - o.distance;
        }
    }

    public int solution(int n, int[][] edge) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] e : edge) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]); 
        }

    
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE); 
        dist[1] = 0;
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0)); 
        
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int currentNode = current.vertex;
            int currentDist = current.distance;
            
            if (currentDist > dist[currentNode]) continue; 
            
            for (int neighbor : graph.get(currentNode)) {
                int newDist = currentDist + 1; 
                if (newDist < dist[neighbor]) {
                    dist[neighbor] = newDist;
                    pq.add(new Node(neighbor, newDist));
                }
            }
        }
        
        int maxDist = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] != Integer.MAX_VALUE) {
                maxDist = Math.max(maxDist, dist[i]);
            }
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == maxDist) {
                answer++;
            }
        }

        return answer;
    }
}
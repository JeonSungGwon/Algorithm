import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static class Node implements Comparable<Node>{
        int start, end, value;
        public Node(int start, int end, int value) {
            this.start = start;
            this.end = end;
            this.value = value;
        }
        @Override
        public int compareTo(Node o) {
            return this.value - o.value;
        }
    }
    static int[] parent;	
    static StringBuilder answer = new StringBuilder();
    static ArrayList<Node> road = new ArrayList<>();	
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parent = new int[N+1];

        for(int i=1;i<=N;i++)
            parent[i] = i;

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            road.add(new Node(A,B,C));
        }
        Collections.sort(road);
        int sum = 0;	
        int max = -1;
        //크루스칼 알고리즘으로 탐색!
        for(Node n : road) {
            //연결 가능한지.
            if(find(n.start) != find(n.end)) {
                union(n.start, n.end);	
                sum += n.value;
                max = Math.max(max, n.value);	
            }
        }
        sum -= max;
        System.out.println(sum);

    }
    static int find(int a) {
        if(parent[a] == a)
            return a;
        return parent[a] = find(parent[a]);
    }
    static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if(pa <= pb)
            parent[pb] = parent[pa];
        else
            parent[pa] = parent[pb];
    }
}

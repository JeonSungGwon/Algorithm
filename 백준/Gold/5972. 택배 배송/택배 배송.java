import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node {
	int idx;
	int cost;

	public Node(int idx, int cost) {
		this.idx = idx;
		this.cost = cost;
	}
}

public class Main {

	static boolean[] visited;
	static int[] dist;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		visited = new boolean[N + 1];
		dist = new int[N + 1];
		ArrayList<Node>[] graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int cost = sc.nextInt();
			graph[b].add(new Node(a, cost));
			graph[a].add(new Node(b, cost));
		}

		Arrays.fill(dist, Integer.MAX_VALUE);

		PriorityQueue<Node> q = new PriorityQueue<Node>((o1, o2) -> o1.cost - o2.cost);

		q.add(new Node(1, 0));
		dist[1] = 0;

		while (!q.isEmpty()) {
			Node now = q.poll();

			if (!visited[now.idx]) {
				visited[now.idx] = true;
			}

			for (Node next : graph[now.idx]) {
				if (!visited[next.idx] && dist[next.idx] > now.cost + next.cost) {
					dist[next.idx] = now.cost + next.cost;
					q.add(new Node(next.idx, dist[next.idx]));
				}
			}
		}
		System.out.println(dist[N]);

	}
}

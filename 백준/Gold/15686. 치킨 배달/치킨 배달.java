import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int[][] matrix;
	static ArrayList<int[]> chickenList = new ArrayList<int[]>();
	static ArrayList<int[]> houseList = new ArrayList<int[]>();
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		matrix = new int[N][N];
		for(int i = 0 ; i<N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j<N ; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
				if(matrix[i][j] == 1) houseList.add(new int[] {i,j});
                else if(matrix[i][j] == 2) chickenList.add(new int[] {i,j});
			}
		}
		visited = new boolean[chickenList.size()];
		치킨거리구하기(0, 0);
		
		System.out.println(result);
	}
	static boolean[] visited;
	static int result = Integer.MAX_VALUE;
	private static void 치킨거리구하기(int cnt, int idx) {
		if(cnt == M) {
			int sum = 0;
			for(int i = 0 ; i<houseList.size() ; i++) {
				int length = Integer.MAX_VALUE;
				for(int j = 0 ; j<chickenList.size() ; j++) {
					if(visited[j]) {
						int abc = Math.abs(houseList.get(i)[0] - chickenList.get(j)[0]) +
								Math.abs(houseList.get(i)[1] - chickenList.get(j)[1]);
						length = Math.min(length, abc);
					}
				}
				sum += length;
			}
			result = Math.min(result,sum);
			
			return;
		}
		
		for(int i = idx ; i<chickenList.size() ; i++) {
			if(visited[i]) continue;
			
			visited[i] = true;
			치킨거리구하기(cnt + 1, i + 1);
			visited[i] = false;
		}
		
	}

}

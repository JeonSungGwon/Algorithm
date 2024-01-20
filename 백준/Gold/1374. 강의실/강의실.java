import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine());

        int[][] matrix = new int[N][3];

        for (int i = 0; i < N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	matrix[i][0] = Integer.parseInt(st.nextToken());
            matrix[i][1] = Integer.parseInt(st.nextToken());
            matrix[i][2] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(matrix, Comparator.comparingInt(index -> index[1]));

        Queue<Integer> classRoom = new PriorityQueue<>();
        
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (!classRoom.isEmpty() && classRoom.peek() <= matrix[i][1]) { //끝나는 시간보다 시작 시간이 클 경
                classRoom.poll();
            } else {
                cnt++;
            }
            classRoom.offer(matrix[i][2]);
        }

        System.out.println(cnt);
    }
}
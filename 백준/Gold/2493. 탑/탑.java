import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] heights = new int[N];
        int[] result = new int[N];

        for (int i = 0; i < N; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] < heights[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                result[i] = stack.peek() + 1;
            } else {
                result[i] = 0;
            }
            stack.push(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(result[i]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}

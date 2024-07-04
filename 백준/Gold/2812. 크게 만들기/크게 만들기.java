import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String number = br.readLine();
        Stack<Integer> stack = new Stack<>();

        int toRemove = K; 
        for (int i = 0; i < N; i++) {
            int digit = number.charAt(i) - '0';
            while (!stack.isEmpty() && stack.peek() < digit && toRemove > 0) {
                stack.pop();
                toRemove--;
            }
            stack.push(digit);
        }

        while (toRemove > 0) {
            stack.pop();
            toRemove--;
        }

        StringBuilder sb = new StringBuilder();
        for (int digit : stack) {
            sb.append(digit);
        }

        System.out.println(sb.toString());
    }
}

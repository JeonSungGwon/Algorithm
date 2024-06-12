import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    static long[] board;
    static long result = Long.MAX_VALUE;
    static long a, b;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        board = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < N; i++) {
            board[i] = Long.parseLong(st.nextToken());
        }
        
        Arrays.sort(board);
        
        int left = 0;
        int right = N - 1;
        
        while (left < right) {
            long sum = board[left] + board[right];
            
            if (Math.abs(sum) < result) {
                result = Math.abs(sum);
                a = board[left];
                b = board[right];
            }
            
            if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }
        
        System.out.println(a + " " + b);
    }
}

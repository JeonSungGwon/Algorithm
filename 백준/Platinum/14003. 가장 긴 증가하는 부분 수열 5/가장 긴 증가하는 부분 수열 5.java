import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] board = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            board[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> lis = new ArrayList<>();
        int[] predecessor = new int[N];
        int[] lisIndices = new int[N];

        int length = 0;

        for (int i = 0; i < N; i++) {
            int pos = Collections.binarySearch(lis, board[i]);
            if (pos < 0) pos = -(pos + 1);

            if (pos < lis.size()) {
                lis.set(pos, board[i]);
            } else {
                lis.add(board[i]);
            }
            lisIndices[pos] = i;
            predecessor[i] = pos > 0 ? lisIndices[pos - 1] : -1;
            if (pos == length) length++;
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = lisIndices[length - 1]; i >= 0; i = predecessor[i]) {
            result.add(board[i]);
        }
        Collections.reverse(result);

        System.out.println(length);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}

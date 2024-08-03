import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] board = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            board[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> lis = new ArrayList<>();
        int[] lisIndices = new int[N];
        int[] predecessor = new int[N];

        int length = 0;

        for (int i = 0; i < N; i++) {
            int pos = binarySearch(lis, board[i]);
            if (pos < 0) pos = -(pos + 1);

            if (pos >= lis.size()) {
                lis.add(board[i]);
            } else {
                lis.set(pos, board[i]);
            }

            lisIndices[pos] = i;
            predecessor[i] = pos > 0 ? lisIndices[pos - 1] : -1;
            if (pos == length) length++;
        }

        int[] result = new int[length];
        for (int i = lisIndices[length - 1], k = length - 1; i >= 0; i = predecessor[i], k--) {
            result[k] = board[i];
        }

        System.out.println(length);
        for (int i = 0; i < length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    private static int binarySearch(List<Integer> list, int target) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (list.get(mid) == target) {
                return mid;
            } else if (list.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -(low + 1);
    }
}

import java.io.*;
import java.util.*;

public class Main {
    static Integer[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new Integer[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int index = 0;

        while (st.hasMoreTokens()) {
            map[index++] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(map);

        int count = 0;

        for (int i = 0; i < N; i++) {
            int target = map[i];
            int start = 0;
            int end = N - 1;

            while (start < end) {
                if (map[start] + map[end] == target) {
                    if (start != i && end != i) {
                        count++;
                        break;
                    } else if (start == i) {
                        start++;
                    } else if (end == i) {
                        end--;
                    }
                } else if (map[start] + map[end] < target) {
                    start++;
                } else {
                    end--;
                }
            }
        }

        System.out.println(count);
    }
}

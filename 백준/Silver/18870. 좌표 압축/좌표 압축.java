import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] sortedArr = new int[N];
        

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = sortedArr[i] = Integer.parseInt(st.nextToken());
        }

        HashMap<Integer, Integer> indexMap = new HashMap<>();
        Arrays.sort(sortedArr);
        
        int idx = 0;
        for (int a : sortedArr) {
            if (!indexMap.containsKey(a)) {
                indexMap.put(a, idx++);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int a : arr) {
            int zip = indexMap.get(a);
            sb.append(zip).append(' ');
        }
        System.out.println(sb);
    }
}

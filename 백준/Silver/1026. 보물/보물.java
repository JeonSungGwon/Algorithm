import java.util.*;
import java.io.*;

public class Main {
    static Integer[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new Integer[2][N];

        for(int i = 0 ; i < 2 ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Arrays.sort(arr[0]);
        Arrays.sort(arr[1], Collections.reverseOrder());

        int result = 0;
        for(int j = 0 ; j < N ; j++){
            result += arr[0][j]*arr[1][j];
        }
        System.out.println(result);

    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n,m,l,k;
    static ArrayList<int[]> star = new ArrayList<int[]>();
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int cnt;
        int answer = 0;
        for (int i = 0; i < k; i++) {
        	st = new StringTokenizer(br.readLine()); 
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            star.add(new int[] {x,y});
        }
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                int x = star.get(i)[0];
                int y = star.get(j)[1];
                cnt = 0;
                for (int[] dot : star) {
                    if (x <= dot[0] && x + l >= dot[0] && y <= dot[1] && y + l >= dot[1])
                        cnt++;
                }
                answer = Math.max(answer, cnt);

            }
        }
        System.out.println(k - answer);
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<String> arr = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            ArrayList<String> aray = new ArrayList<>();
            for (int j = 123; j < 1000; j++) {
                int aa = 0;
                int bb = 0;
                int digit1 = j % 10;
                int digit2 = (j / 10) % 10;
                int digit3 = j / 100;

                if (digit1 != digit2 && digit2 != digit3 && digit1 != digit3 &&(digit1 != 0 && digit2 != 0 && digit3 !=0)) {
                    String format = String.format("%03d", j);
                    if (format.charAt(0) == str.charAt(0)) {
                        aa++;
                    } else if (str.indexOf(format.charAt(0)) != -1) {
                        bb++;
                    }
                    if (format.charAt(1) == str.charAt(1)) {
                        aa++;
                    } else if (str.indexOf(format.charAt(1)) != -1) {
                        bb++;
                    }
                    if (format.charAt(2) == str.charAt(2)) {
                        aa++;
                    } else if (str.indexOf(format.charAt(2)) != -1) {
                        bb++;
                    }

                    if (aa == a && bb == b) {
                        aray.add(format);
                    }
                }
            }

            if (i == 0) {
                arr.addAll(aray);
            } else {
                List<String> toRemove = new ArrayList<>();
                for (String s : arr) {
                    if (!aray.contains(s)) {
                        toRemove.add(s);
                    }
                }
                arr.removeAll(toRemove);
            }

            
        }
        System.out.println(arr.size());
    }
}

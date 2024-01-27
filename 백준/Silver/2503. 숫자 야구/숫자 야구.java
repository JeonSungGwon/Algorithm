import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[1000];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            for (int j = 123; j < 1000; j++) {
                int strik = 0;
                int ball = 0;
                String s = Integer.toString(j);
                if (s.contains("0")) continue;
                if (s.charAt(0) == s.charAt(1) || s.charAt(0) == s.charAt(2) || s.charAt(1) == s.charAt(2)) continue;
                
                if (s.charAt(0) == str.charAt(0)) {
                    strik++;
                } else if (str.indexOf(s.charAt(0)) != -1) {
                    ball++;
                }
                if (s.charAt(1) == str.charAt(1)) {
                    strik++;
                } else if (str.indexOf(s.charAt(1)) != -1) {
                    ball++;
                }
                if (s.charAt(2) == str.charAt(2)) {
                    strik++;
                } else if (str.indexOf(s.charAt(2)) != -1) {
                    ball++;
                }

                if (strik == a && ball == b) {
                	if(i == 0) arr[j] = 1;
                	else {
                		if(arr[j] == 1) 
                			arr[j] = 1;
                		else arr[j] = 0;
                		
                	}
                	
                }
                else arr[j] = 0;
                
                
            }
            
        }
        int sum = 0;
        for(int i = 123 ; i<1000 ; i++) {
        	if(arr[i] == 1) {
        		sum++;
        	}
        }
        System.out.println(sum);
    }
}

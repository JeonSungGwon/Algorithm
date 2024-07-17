import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] dp = new int[str.length()+1];
        int[] nums = new int[str.length()+1];

        if (str.charAt(0) == '0') {
            System.out.println(0);
            return;
        }

        for(int i = 1 ; i <= str.length() ; i++){
            nums[i] = str.charAt(i-1) - '0';
        }

        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2 ; i <= str.length() ; i++){
            int current = nums[i];
            int previous = nums[i-1];

            if (current != 0) {
                dp[i] = dp[i-1] % 1000000;
            }

            int twoDigit = previous * 10 + current;
            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] = (dp[i] + dp[i-2]) % 1000000;
            }
        }

        System.out.println(dp[str.length()] % 1000000);
    }
}
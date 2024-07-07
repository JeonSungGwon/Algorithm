import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        for(int tc = 0 ; tc < T ; tc++) {
            String str  = br.readLine();
            int n = isPalindrome(str);
            sb.append(n).append("\n");
        }
        System.out.println(sb);
    }

    private static int isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        int answer = 0;
        while(left < right) {
            if(str.charAt(left) == str.charAt(right)) {
                left++;
                right--;
            } else {
                if(isStrictPalindrome(str, left + 1, right)) {
                    return 1;
                } else if(isStrictPalindrome(str, left, right - 1)) {
                    return 1;
                } else {
                    return 2;
                }
            }
        }
        return answer;
    }

    private static boolean isStrictPalindrome(String str, int left, int right) {
        while(left < right) {
            if(str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
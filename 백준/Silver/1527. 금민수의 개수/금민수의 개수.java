
import java.util.Scanner;

public class Main {
    static long A;
    static long B;
    static long cnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        A = sc.nextLong();
        B = sc.nextLong();
        String characters = "74";
        long minLength = Long.toString(A).length();
        long maxLength = Long.toString(B).length();
        for (long length = minLength; length <= maxLength; length++) {
            generateCombinations(characters, (int) length, "");
        }
        System.out.println(cnt);
    }

    private static void generateCombinations(String characters, int length, String string) {
        if (string.length() == length) {
            if (A <= Long.parseLong(string) && B >= Long.parseLong(string)) {
                cnt++;
            }
            return;
        }
        for (int i = 0; i < characters.length(); i++) {
            generateCombinations(characters, length, string + characters.charAt(i));
        }
    }
}

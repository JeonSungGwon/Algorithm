import java.util.Scanner;

public class Main {
	static int A;
	static int B;
	static int cnt = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		A = sc.nextInt();
		B = sc.nextInt();
		String characters = "74";
		int minLength = Integer.toString(A).length();
		int maxLength = Integer.toString(B).length();
		for (int length = minLength; length <= maxLength; length++) {
            generateCombinations(characters, length, "");
        }
		System.out.println(cnt);
	}

	private static void generateCombinations(String characters, int length, String string) {
		if (string.length() == length) {
			if(A <= Integer.parseInt(string) && B>= Integer.parseInt(string)) {
				cnt++;	
			}
            return;
        }
		for (int i = 0; i < characters.length(); i++) {
			if(B>=Long.parseLong(string + characters.charAt(i))) {
				generateCombinations(characters, length, string + characters.charAt(i));
			}
        }
	}

}

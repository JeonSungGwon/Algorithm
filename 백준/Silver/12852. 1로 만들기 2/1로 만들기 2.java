import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();
		Recursion(X, 0, X+"");
		System.out.println(result);
		System.out.println(myStr);
	}
	public static int result = 1000;
	public static String myStr;
	public static void Recursion(int currentX, int cnt, String str) {
		
		if(currentX == 1) {
			if(cnt < result) {
				result =  cnt;
				myStr = str;
			}
			return;
		}
		if(cnt >= result) return;
		if(currentX % 3 == 0) {
			Recursion(currentX/3, cnt + 1, str+" " +currentX/3);
		}
		if(currentX % 2 == 0) {
			Recursion(currentX/2, cnt + 1, str+" " +currentX/2);
		}
		Recursion(currentX - 1, cnt + 1, str+" " +(currentX-1));
	}
}

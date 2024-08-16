import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int rcpt= sc.nextInt();
		int n = sc.nextInt();
		int item = 0;
		int count = 0;
		int sum = 0;
		
		for(int i=0;i<n;i++) {
			item = sc.nextInt();
			count = sc.nextInt();
			sum += item * count;
		}
		
		if(sum==rcpt) System.out.println("Yes");
		else System.out.println("No");
	}
}
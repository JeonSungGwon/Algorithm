import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        long mul = (long)a*b;
        long num1 = 0;
        long num2 = 0;
        
        for(int i = a; i<=Math.sqrt(mul); i+=a) {
			if(mul % i == 0 && gcd(i, mul / i) == a) {
				num1 = i;
				num2 = (mul / i);
			}
		}
        

        System.out.println(num1 + " " + num2);
    }

    public static long gcd(long a, long b) {
		long c = a % b;
		if(c == 0) {
			return b;
		}
		return gcd(b,c);
	}
}

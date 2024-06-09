import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		sc.close();
		
		str = str.trim();
		String[] str_arr = str.split(" ");
		
		if(str_arr[0].equals("")) System.out.println(0);
		else System.out.println(str_arr.length);
	
		
		
	}
}
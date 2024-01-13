import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) throws IOException{
    	Scanner sc = new Scanner(System.in);
    	int[] arr = new int[10];
    	int sum = 0;
    	int result = 0;
    	for(int i = 0; i<10 ; i++) {
    		arr[i] = sc.nextInt();
    	}
    	for(int i = 0 ; i<10 ; i++) {
    		sum += arr[i];
    		if(sum>=100) {
    			sum = Math.abs(100-sum) <= Math.abs(100-(sum-arr[i])) ? sum : sum-arr[i];
    			break;
    		}
    	}
    	System.out.println(sum);
    }
}
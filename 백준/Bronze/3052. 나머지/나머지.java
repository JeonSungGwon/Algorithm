import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String args[]) throws IOException{
    	Scanner sc = new Scanner(System.in);
    	Set<Integer> mySet = new HashSet<Integer>();
    	for(int i = 0 ; i <10 ; i++) {
    		int N = sc.nextInt();
    		mySet.add(N%42);
    	}
    	System.out.println(mySet.size());
    }
}
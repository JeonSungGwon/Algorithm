import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		for(int i = 0 ; i < N ; i++) {
			int v = sc.nextInt();
			q.offer(v);
		}
		
		int result = 0;
		while(q.size() >= 2) {
			int a = q.poll();
			int b = q.poll();
			int sum = a+b;
			result += sum;
			if(q.isEmpty()) break;
			q.offer(sum);
		}
		
		System.out.println(result);
	
	}

}

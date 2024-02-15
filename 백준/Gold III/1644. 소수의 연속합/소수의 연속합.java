import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static boolean[] prime;
	static ArrayList<Integer> arrayList = new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		prime = new boolean[N+1];
		prime[0] = prime[1] = true;
		
		for(int i = 2 ; i <= N ; i++) {
            if(prime[i]) continue;
            
            for(long j = (long)i*i; j < prime.length; j += i){
            	if(prime[(int) j]) continue;
                prime[(int) j] = true;
            }
		}
		
		for(int i = 2 ; i < prime.length ; i++) {
			if(prime[i]) continue;
			arrayList.add(i);
		}
		
		int start = 0;
		int end = 0;
		int cnt = 0;
		int sum = 0;
		while (start < arrayList.size()) {
			if (sum > N || end == arrayList.size()) {
				sum -= arrayList.get(start);
				start++;
			} else { 
				sum += arrayList.get(end);
				end++;
			}
			if (sum == N) 
				cnt++;
		}
		System.out.println(cnt);
		
	}

}

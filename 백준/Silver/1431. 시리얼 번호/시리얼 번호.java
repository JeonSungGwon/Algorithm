import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int N = Integer.parseInt(br.readLine());
	String[] arr = new String[N];
	
	for(int i = 0 ; i<N ; i++) {
		arr[i] = br.readLine();
	}
	Arrays.sort(arr, (o1, o2) -> {
        if (o1.length() != o2.length()) {
            return Integer.compare(o1.length(), o2.length());
        } else {
        	int cnt1 = 0;
        	int cnt2 = 0;
        	for(int i = 0 ; i<o1.length() ; i++) {
        		if(Character.isDigit(o1.charAt(i))) {
        			cnt1 += o1.charAt(i) - '0';
        		}
        		if(Character.isDigit(o2.charAt(i))) {
        			cnt2 += o2.charAt(i) - '0';
        		}
        	}
        	
        	if(cnt1 == cnt2) {
        		return o1.compareTo(o2);
        	}
        	return Integer.compare(cnt1, cnt2);
        }
    });
	for(int i = 0 ; i < N ; i++) {
		System.out.println(arr[i]);
	}
	}
}

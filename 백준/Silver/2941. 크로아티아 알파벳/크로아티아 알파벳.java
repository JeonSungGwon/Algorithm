import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
	public static void main(String[] args) throws IOException {
		String[] croList = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		for(int i = 0 ; i < 8 ; i++) {
			if(str.contains(croList[i])) {
				str = str.replace(croList[i], ",");
			}
		}
		System.out.println(str.length());
	}
}
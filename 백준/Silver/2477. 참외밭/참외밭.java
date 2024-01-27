import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[9][2];
		String str = "";
		for(int i = 0 ; i < 6 ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String a = st.nextToken();
			str += a;
			arr[i][0] = Integer.parseInt(a);
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		arr[6][0] = arr[0][0];
		str += arr[0][0];
		arr[6][1] = arr[0][1];
		arr[7][0] = arr[1][0];
		str += arr[1][0];
		arr[7][1] = arr[1][1];
		arr[8][0] = arr[2][0];
		str += arr[2][0];
		arr[8][1] = arr[2][1];
		int index = 0;
		int sum = 0;
		if(str.indexOf("3131") != -1) {
			index = str.indexOf("3131");
			sum = (arr[index][1] * arr[index+1][1]) + ((arr[index+2][1]+arr[index][1]) * arr[index+3][1]);
 		}else if(str.indexOf("4242") != -1) {
 			index = str.indexOf("4242");
 			sum = (arr[index][1] * arr[index+1][1]) + ((arr[index+2][1]+arr[index][1]) * arr[index+3][1]);
 		}else if(str.indexOf("1414") != -1) {
 			index = str.indexOf("1414");
 			sum = (arr[index][1] * arr[index+1][1]) + ((arr[index+2][1]+arr[index][1]) * arr[index+3][1]);
 		}else if(str.indexOf("2323") != -1) {
 			index = str.indexOf("2323");
 			sum = (arr[index][1] * arr[index+1][1]) + ((arr[index+2][1]+arr[index][1]) * arr[index+3][1]);
 		}
		
		System.out.println(sum*N);
		
		
	}

}

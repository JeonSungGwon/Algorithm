import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String xywh  = br.readLine();
		String[] xywh_array = xywh.split(" ");
		int x = Integer.parseInt(xywh_array[0]);
		int y = Integer.parseInt(xywh_array[1]);
		int w = Integer.parseInt(xywh_array[2]); 
		int h = Integer.parseInt(xywh_array[3]);
		int[] answer = {w-x, h-y, x, y};
		int min = w-x;
		
		for(int i = 1 ; i < 4 ; i++) {
			min = Math.min(min, answer[i]);
		}
		
		bw.write(String.valueOf(min));
		
        br.close();
		bw.flush();
		bw.close();
	}

}
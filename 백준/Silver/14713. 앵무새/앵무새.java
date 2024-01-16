import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static List<List<String>> strArrayList;
	static int arrLength = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		strArrayList = new ArrayList<>();
		boolean sentence = true;
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			List<String> currentLine = new ArrayList<>();
			while (st.hasMoreTokens()) {
				arrLength++;
				currentLine.add(st.nextToken());
			}
			strArrayList.add(currentLine);
		}
		String[] l = br.readLine().split(" ");
		sentence = checkPossible(l);

		if (sentence) {
			System.out.println("Possible");
		} else {
			System.out.println("Impossible");
		}

	}

	static boolean checkPossible(String[] l) {
		if (l.length != arrLength) {
			return false;
		}
		for (String word : l) {
			boolean mySentence = false;
			for (List<String> line : strArrayList) {
				if (line.contains(word)) {
					line.subList(0, line.indexOf(word)).clear();
					mySentence = true;
					break;
				}
			}
			if (!mySentence) {
				return false;
			}
		}
		return true;

	}
}
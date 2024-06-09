import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] arr;
	private static final int RIGHT = 0;
    private static final int UP = 1;
    private static final int LEFT = 2;
    private static final int DOWN = 3;
	private static boolean[][] map = new boolean[101][101];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][4];
		
		for(int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < 4 ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0 ; i < N ; i++) {
			draw(arr[i][0], arr[i][1], getDirections(arr[i][2], arr[i][3]));
		}
		
		 System.out.println(getNumberOfSquares());
	}
	
	public static List<Integer> getDirections(int d, int g) {
		 List<Integer> directions = new ArrayList<>();
		 directions.add(d);
		 for(int i = 0 ; i < g ; i++) {
			 for(int j = directions.size()-1 ; j >= 0 ; j--) {
				 int direction = (directions.get(j) + 1) % 4;
	             directions.add(direction);
			 }
		 }
		 return directions;
	}

	public static void draw(int x, int y, List<Integer> directions) {
		map[x][y] = true;
		 
        for (int direction : directions) {
            switch (direction) {
                case RIGHT:
                    map[++x][y] = true;
                    break;
                case UP:
                    map[x][--y] = true;
                    break;
                case LEFT:
                    map[--x][y] = true;
                    break;
                case DOWN:
                    map[x][++y] = true;
                    break;
            }
        }
	}
	
	private static int getNumberOfSquares() {
        int count = 0;
 
        for (int x = 0; x < 100; x++) {
            for (int y = 0; y < 100; y++) {
                if (map[x][y] && map[x + 1][y] && map[x][y + 1] && map[x + 1][y + 1])
                    count++;
            }
        }
 
        return count;
    }

}

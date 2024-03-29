import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static int R, C, ax, ay;
	static char[][] board;
	static String input;
	static int[] tmp;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static Queue<int[]> water = new LinkedList<int[]>(); 
	static Queue<int[]> beaver = new LinkedList<int[]>(); 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new char[R+2][C+2]; 
		for (int i = 1; i <= R; i++) {
			input = br.readLine();
			for (int j = 0; j < C; j++) {
				if(input.charAt(j) == '*') water.add(new int[] {i,j+1});
				if(input.charAt(j) == 'S') beaver.add(new int[] {i,j+1});
				board[i][j+1] = input.charAt(j);
			}
		}
        
        // 테두리 두르기
		Arrays.fill(board[0], 'X');
		Arrays.fill(board[R+1], 'X');
		for (int i = 1; i < R+1; i++) {
			board[i][0] = 'X';
			board[i][C+1] = 'X';
		}
        
        
		int day = 0; 
		while(true) {
			day ++;
			int size = water.size(); 
			for (int i = 0; i < size; i++) {
				tmp = water.poll(); 
				for (int j = 0; j < 4; j++) {
					ax = tmp[0] + dx[j];
					ay = tmp[1] + dy[j];
					if(board[ax][ay] != '.') continue;
					board[ax][ay] = '*';
					water.add(new int[] {ax, ay});
				}
			}
			
			
			size = beaver.size();
			if(size == 0) { 
				System.out.println("KAKTUS");
				return;
			}
            
       
			for (int i = 0; i < size; i++) {
				tmp = beaver.poll();
				for (int j = 0; j < 4; j++) {
					ax = tmp[0] + dx[j];
					ay = tmp[1] + dy[j];
					if (board[ax][ay] == 'D') { 
						System.out.println(day);
						return;
					}
					if(board[ax][ay] != '.') continue; 
					board[ax][ay] = 'S'; 
					beaver.add(new int[] {ax, ay}); 
				}
			}
			
		}
		
		
	}
	
}
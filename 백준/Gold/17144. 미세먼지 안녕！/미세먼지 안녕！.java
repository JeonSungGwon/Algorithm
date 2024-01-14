import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] matrix;
	static int[][] copyMatrix;
	static int R;
	static int C;
    public static void main(String args[]) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	R = Integer.parseInt(st.nextToken());
    	C = Integer.parseInt(st.nextToken());
    	int T = Integer.parseInt(st.nextToken());
    	int[] dx = {0, 1, 0, -1};
    	int[] dy = {1, 0, -1, 0};
    	int idx = 0;
    	matrix = new int[R][C];
    	copyMatrix = new int[R][C];
    	
    	for(int i = 0 ; i<R ; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j = 0 ; j<C ; j++) {
    			matrix[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}

    	for(int t = 0 ; t<T ; t++) {
    		copyMatrix();
	    	for(int i = 0 ; i<R ; i++) {
	    		for(int j = 0 ; j<C ; j++) {
	    			int cnt= 0;
	    			int aaa = matrix[i][j]/5;
	    			if(matrix[i][j] != 0 && matrix[i][j] != -1) {
	    				for(int a = 0; a<4; a++) {
	    					int ax = dx[a]+i;
	    					int ay = dy[a]+j;
	    					if(ax>=0 && ax<R && ay>=0 && ay<C && matrix[ax][ay] != -1) {
	    						cnt++;
	    						copyMatrix[ax][ay] += aaa;
	    					}
	    				}
	    				copyMatrix[i][j] = (copyMatrix[i][j] - matrix[i][j]) + (matrix[i][j] - (aaa*cnt));
	    			}
	    			if(matrix[i][j] == -1) {
	    				idx = i;
	    			}
	    		}
	    	}
	    	myMatrix();
	    
	    	for(int i = 2 ; i<C ; i++) {
	    		copyMatrix[idx][i] = matrix[idx][i-1];
	    		copyMatrix[idx-1][i] = matrix[idx-1][i-1];
	    	}
	    	copyMatrix[idx][1] = 0;	
	    	copyMatrix[idx-1][1] = 0;
	    	
	    	for(int i = C-1 ; i>0 ; i--) {
	    		copyMatrix[0][i-1] = matrix[0][i];
	    		copyMatrix[R-1][i-1] = matrix[R-1][i];
	    	}
	    	
	    	for(int i = R-1 ; i>idx+1 ; i--) {
	    		copyMatrix[i-1][0] = matrix[i][0];
	    		
	    	}
	    	for(int i = idx-1 ; i>=1 ; i--) {
	    		copyMatrix[i-1][C-1] = matrix[i][C-1];
	    	}
	    	for(int i = idx ; i<R-1 ; i++) {
	    		copyMatrix[i+1][C-1] = matrix[i][C-1];
	    	}
	    	
	    	for(int i = 0 ; i<idx-2 ; i++) {
	    		copyMatrix[i+1][0] = matrix[i][0];
	    	}
	    	myMatrix();
	    	
    	}
    
    	int sum = 0;
    	for(int i = 0 ; i < R ; i++) {
    		for(int j = 0 ; j < C ; j++) {
    			if(matrix[i][j] != -1) {
    				sum += matrix[i][j];
    			}
    		}
    	}
    	System.out.println(sum);
    }
    
   public static void copyMatrix() {
	   for(int i = 0 ; i<R ; i++) {
		   for(int j = 0 ; j<C ; j++) {
			   copyMatrix[i][j] = matrix[i][j];
		   }
	   }
   }
   public static void myMatrix() {
	   for(int i = 0 ; i<R ; i++) {
		   for(int j = 0 ; j<C ; j++) {
			   matrix[i][j] = copyMatrix[i][j];
		   }
	   }
   }
    	
}
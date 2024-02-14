import java.io.IOException;
import java.util.Scanner;

public class Main {
    static int x = 0;
    static int y = 0;
    static int count = 0;

    public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        int result = Z((int)Math.pow(2, N), r, c);
        System.out.println(result);
    }

    public static int Z(int n, int r, int c) {
        //리턴될때마다 칸을 줄여준다. 1이 될때까지
        n /= 2;
        //왼쪽 위에 위치할때
        if(r < x + n && c < y + n) {
            count += (n * n * 0);
        //오른쪽 위에 위치할때
        }else if(r < x + n && c >= y + n) {
            count += (n * n * 1);
            y += n;
        //왼쪽 아래에 위치할때
        }else if(c < y + n) {
            count += (n * n * 2);
            x += n;
        //오른쪽 아래에 위치할때
        }else {
            count += (n * n * 3);
            x += n;
            y += n;
        }
        if(n == 1) return count;
        return Z(n, r, c);
    }

}

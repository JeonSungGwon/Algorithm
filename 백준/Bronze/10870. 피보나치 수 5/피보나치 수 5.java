import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int N = Integer.parseInt(br.readLine());
        System.out.println(fibo(N));
    }
    static int fibo(int n){
        if(n < 2) return n;
        return fibo(n-1) + fibo(n-2);
    }
}
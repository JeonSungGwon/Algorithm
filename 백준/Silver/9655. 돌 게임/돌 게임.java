import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] dp = new int[N+1];

        dp[1] = 0;
        for(int i = 2 ; i <= N ; i++){
            dp[i] = Math.abs(dp[i-1]-1);
        }
        if(dp[N] == 0){
            System.out.println("SK");
        }else{
            System.out.println("CY");
        }
    }
}

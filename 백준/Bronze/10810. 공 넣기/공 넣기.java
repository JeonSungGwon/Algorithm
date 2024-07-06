import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] basket = new int[n];
        for (int x = 0; x < m; x++) {
            int i = sc.nextInt();
            int j = sc.nextInt();
            int k = sc.nextInt();
            for (int y = i; y <= j; y++) {
                basket[y - 1] = k;
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(basket[i] + " ");
        }

        sc.close();
    }
}

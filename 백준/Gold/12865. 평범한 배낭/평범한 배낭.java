import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        int[][] stuff = new int[N + 1][2];
        int[][] knapsack = new int[N + 1][K + 1];

        for (int i = 1; i <= N; i++) {
            stuff[i][0] = sc.nextInt();
            stuff[i][1] = sc.nextInt();
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                int weight = stuff[i][0];
                int value = stuff[i][1];

                if (j < weight) {
                    knapsack[i][j] = knapsack[i - 1][j];
                } else {
                    knapsack[i][j] = Math.max(value + knapsack[i - 1][j - weight], knapsack[i - 1][j]);
                }
            }
        }

        System.out.println(knapsack[N][K]);
    }
}

import java.util.Scanner;

public class Main {
    static int N, M;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        numbers = new int[M];
        visited = new boolean[N];
        조합(0, 0);
    }

    static int[] numbers;
    static boolean[] visited;
    private static void 조합(int cnt, int start) {
        if(cnt == M) {
            for(int i = 0 ; i < M ; i++) {
                System.out.print(numbers[i] + " ");
            }
            System.out.println();
            return;
        }
        
        for(int i = start ; i < N ; i++) {
            visited[i] = true;
            numbers[cnt] = i + 1;
            조합(cnt + 1, i + 1); 
            visited[i] = false;
        }
    }
}

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> myQueue = new ArrayDeque<>();

        int N = scanner.nextInt();

        for (int i = 1; i <= N; i++) {
            myQueue.addLast(i);
        }

        for (int i = 1; i < N; i++) {
            myQueue.removeFirst();
            if (myQueue.size() == 1) {
                break;
            }
            myQueue.addLast(myQueue.removeFirst());
        }

        System.out.println(myQueue.removeLast());
    }
}



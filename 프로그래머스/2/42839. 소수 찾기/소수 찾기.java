import java.util.HashSet;
import java.util.Set;

class Solution {
    static int[] number;
    static boolean[] visited;
    static Set<Integer> primes = new HashSet<>(); 

    public int solution(String numbers) {
        int n = numbers.length();
        
        for (int i = 1; i <= n; i++) {
            number = new int[i];
            visited = new boolean[n];
            부분집합(numbers, i, 0);
        }
        
        int answer = 0;
        for (int prime : primes) {
            if (isPrime(prime)) {
                answer++;
            }
        }
        
        return answer;
    }

    public static void 부분집합(String numbers, int m, int cnt) {
        if (m == cnt) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m; i++) {
                sb.append(number[i]);
            }
            primes.add(Integer.parseInt(sb.toString()));
            return;
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (visited[i]) continue;
            visited[i] = true;
            number[cnt] = numbers.charAt(i) - '0'; 
            부분집합(numbers, m, cnt + 1);
            visited[i] = false;
        }
    }


    public static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}

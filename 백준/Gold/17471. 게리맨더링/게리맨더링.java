import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
 
    static int n;
    static int[] numList, dangArr;
    static ArrayList<Integer>[] list;
    static int min = Integer.MAX_VALUE;
    static boolean[] visited;
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        n = sc.nextInt();

        numList = new int[n + 1];
        list = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
            numList[i] = sc.nextInt();
        }
 
        for(int i = 1; i <= n; i++) {
            int num = sc.nextInt();
            for(int j = 0; j < num; j++) {
                list[i].add(sc.nextInt());
            }
        }
 
        dangArr = new int[n + 1]; 
        dfs(1); 
 
        if(min == Integer.MAX_VALUE) System.out.println("-1");
        else System.out.println(min);
    } 
 
    public static void dfs(int k) {
        if(k == n + 1) { 
            int num1 = 0;
            int num2 = 0;
            for(int i = 1; i <= n; i++) {
                if(dangArr[i] == 1) num1 += numList[i];
                else num2 += numList[i];
            }

            visited = new boolean [n + 1];
            int dang = 0; 
            for(int i = 1; i <= n; i++) {
                if(!visited[i]) {
                    bfs(i, dangArr[i]); 
                    dang++;
                }
            }
            if(dang == 2) min = Math.min(min, Math.abs(num1 - num2)); 
 
            return;
        } 
 
        dangArr[k] = 1;
        dfs(k + 1);
 
        dangArr[k] = 2; 
        dfs(k + 1);
    }
 
    public static void bfs(int idx, int dangNum) {
        Queue<Integer> q = new ArrayDeque<Integer>();
        visited[idx] = true;
        q.offer(idx);
 
        while(!q.isEmpty()) {
            int current = q.poll();

            for(int i = 0; i < list[current].size(); i++) {
                int next = list[current].get(i);
                if(dangArr[next] == dangNum && !visited[next]) {
                    q.offer(next);
                    visited[next] = true;
                }
            }
        }
    }
}
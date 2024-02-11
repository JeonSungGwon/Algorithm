
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, R;
    static int[][] map, tempMap;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            int idx = 0;
            while (st.hasMoreTokens())
                map[n][idx++] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) {
            switch (Integer.parseInt(st.nextToken())) {
                case 1:
                    test1();
                    break;
                case 2:
                    test2();
                    break;
                case 3:
                    test3();
                    break;
                case 4:
                    test4();
                    break;
                case 5:
                    test5();
                    break;
                case 6:
                    test6();
                    break;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void test1() {
        tempMap = new int[N][M];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                tempMap[r][c] = map[N - 1 - r][c];
            }
        }
        map = tempMap;
    }

    private static void test2() {
        tempMap = new int[N][M];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                tempMap[r][c] = map[r][M - 1 - c];
            }
        }
        map = tempMap;
    }

    private static void test3() {
        tempMap = new int[M][N];
        for (int c = 0; c < M; c++) {
            for (int r = 0; r < N; r++)
                tempMap[c][r] = map[N - 1 - r][c];

        }
        map = tempMap;
        int temp = N;
        N = M;
        M = temp;

    }

    private static void test4() {
        tempMap = new int[M][N];
        for (int c = 0; c < M; c++) {
            for (int r = 0; r < N; r++) {
                tempMap[c][r] = map[r][M - 1 - c];
            }
        }
        map = tempMap;
        int temp = N;
        N = M;
        M = temp;
    }

    private static void test5() {
        tempMap = new int[N][M];
        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < M / 2; j++) {
                tempMap[i][M / 2 + j] = map[i][j];
            }
        }

        for (int i = 0; i < N / 2; i++) {
            for (int j = M / 2; j < M; j++) {
                tempMap[N / 2 + i][j] = map[i][j];
            }
        }

        for (int i = N / 2; i < N; i++) {
            for (int j = M / 2; j < M; j++) {
                tempMap[i][j - M / 2] = map[i][j];
            }
        }

        for (int i = N / 2; i < N; i++) {
            for (int j = 0; j < M / 2; j++) {
                tempMap[i - N / 2][j] = map[i][j];
            }
        }
        map = tempMap;
    }

    private static void test6() {
        tempMap = new int[N][M];

        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < M / 2; j++) {
                tempMap[i + N / 2][j] = map[i][j];
            }
        }

        for (int i = N / 2; i < N; i++) {
            for (int j = 0; j < M / 2; j++) {
                tempMap[i][j + M / 2] = map[i][j];
            }
        }

        for (int i = N / 2; i < N; i++) {
            for (int j = M / 2; j < M; j++) {
                tempMap[i - N / 2][j] = map[i][j];
            }
        }

        for (int i = 0; i < N / 2; i++) {
            for (int j = M / 2; j < M; j++) {
                tempMap[i][j - M / 2] = map[i][j];
            }
        }

        map = tempMap;
    }
}
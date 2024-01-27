
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[1000];

        // 가능한 정답의 경우 check 배열을 true로, 가능하지 않은 경우 false로 설정
        for (int i = 123; i < 1000; i++) {
            String str = Integer.toString(i);

            // 문제에 따르면 숫자 내부에 0이 있을 경우는 정답으로 가능하지 않으므로 제외
            if (str.contains("0")) continue;

            // 문제에 따르면 모든 자릿수의 숫자가 달라야 하기 때문에 같은 숫자가 있을 경우 제외
            if (str.charAt(0) == str.charAt(1) || str.charAt(0) == str.charAt(2) || str.charAt(1) == str.charAt(2))
                continue;

            arr[i] = 1;
        }

        for (int i = 0; i < N; i++) {
            // 입력받은 값과 정답과의 스트라이크와 볼 값
            StringTokenizer st = new StringTokenizer(br.readLine());
            int req = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 예상 가능한 모든 정답을 탐색
            for (int ans = 123; ans < 1000; ans++) {
                // 만약 정답 가능성이 있는 수라면
                if (arr[ans] == 1) {
                    int ns = 0;
                    int nb = 0;

                    // 정답 가능성이 있는 수와 입력받은 수와 스트라이크와 볼 비교
                    // 이 때 입력받은 수, 정답 가능성이 있는 수 각각을 반복문을 돌려 각 자리수와 값을 비교
                    String reqStr = Integer.toString(req);
                    String ansStr = Integer.toString(ans);
                    
                    for (int idx = 0; idx < 3; idx++) {
                        char reqSplit = reqStr.charAt(idx);
                        char ansSplit = ansStr.charAt(idx);

                        // 자리수도 같고 값도 같다면 스트라이크
                        // 자리수는 다른데 값은 같다면 볼
                        if (reqSplit == ansSplit) ns++;
                        else if (reqStr.indexOf(ansSplit) != -1) nb++;
                    }

                    // 입력받은 스트라이크, 볼 값과 계산한 값이 같다면 정답 가능성이 있는 수
                    if (ns == s && nb == b) {
                        if (i == 0) arr[ans] = 1;
                        else {
                            if (arr[ans] == 1) arr[ans] = 1;
                            else arr[ans] = 0;
                        }
                    } else {
                        arr[ans] = 0;
                    }
                }
            }
        }

        // 정답 가능성이 있는 수를 세서 카운트 및 출력
        int sum = 0;
        for (int i = 123; i < 1000; i++) {
            if (arr[i] == 1) {
                sum++;
            }
        }
        System.out.println(sum);
    }
}

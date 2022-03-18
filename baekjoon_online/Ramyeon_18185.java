import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ramyeon_18185 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int factory[] = new int[N + 2];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            factory[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        for(int i = 0; i < N; i++) {
            if(factory[i] > 0) {
                // i + 1, i + 2 번 가게의 라면 유무를 확인
                // 현재 살 수 있는 가장 많은 라면을 산다.
                int min = 0;

                if(factory[i + 1] > factory[i + 2]) {
                    // i + 1의 수가 i + 2의 수보다 크면,
                    // 맨 앞의 두개를 묶어서 먼저 사고, 세 개를 묶어서 사는게 싸다.
                    // 이 때, [i] > [i+1] - [i+2] 의 값을 비교하여 최소값으로 구매
                    min = Math.min(factory[i], factory[i + 1] - factory[i + 2]);
                    answer += min * 5;
                    factory[i] -= min;
                    factory[i + 1] -= min;

                    min = Math.min(factory[i], Math.min(factory[i + 1], factory[i + 2]));
                    answer += min * 7;
                    factory[i] -= min;
                    factory[i + 1] -= min;
                    factory[i + 2] -= min;
                } else {    // 반대는 세개 묶어 사고, 두개 묶어 사는게 싸다.
                    min = Math.min(factory[i], Math.min(factory[i + 1], factory[i + 2]));
                    answer += min * 7;
                    factory[i] -= min;
                    factory[i + 1] -= min;
                    factory[i + 2] -= min;

                    min = Math.min(factory[i], factory[i + 1]);
                    answer += min * 5;
                    factory[i] -= min;
                    factory[i + 1] -= min;
                }
                answer += factory[i] * 3;
                factory[i] = 0;
            }
        }

        System.out.println(answer);
    }
}

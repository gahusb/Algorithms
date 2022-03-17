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
        for(int i = 0; i < N;) {
            if(factory[i] > 0) {
                // i + 1, i + 2 번 가게의 라면 유무를 확인
                // 현재 살 수 있는 가장 많은 라면을 산다.
                boolean excep = false;
                if(factory[i + 1] > 0) {
                    int min = Integer.MAX_VALUE;
                    min = Math.min(min, factory[i]);
                    min = Math.min(min, factory[i + 1]);
                    
                    int two = min * 5;
                    if(factory[i + 2] > 0) {
                        // 예외 케이스
                        if(factory[i + 1] > factory[i + 2]) {
                            if(factory[i] > factory[i + 1] - factory[i + 2]) {
                                min = factory[i + 1] - factory[i + 2];
                                two = min * 5;
                            }
                            factory[i] -= min;
                            factory[i + 1] -= min;
                            answer += two;
                            excep = true;
                        } else {
                            int three = 0;
                            min = Math.min(min, factory[i + 2]);
                            three = min * 7;    // 각각 1개씩 구매

                            factory[i] -= min;
                            factory[i + 1] -= min;
                            factory[i + 2] -= min;
                            answer += three;
                        }
                    } else {
                        factory[i] -= min;
                        factory[i + 1] -= min;
                        answer += two;
                    }
                }

                // 현재 위치에서 남은 라면의 개수만큼 모두 산다.
                if(!excep) {
                    answer += factory[i] * 3;
                    i++;
                }
            }
        }

        System.out.println(answer);
    }
}

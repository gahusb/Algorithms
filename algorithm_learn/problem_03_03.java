import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class problem_03_03 {
    public int solution(int n, int k, int[] in) {
        int max = 0;
        int tmp = 0;
        for(int i = 0; i < k; i++) {
            tmp += in[i];
        }
        max = tmp;
        for(int i = k - 1; i < n - 1; i++) {
            tmp -= in[i - k + 1];
            tmp += in[i + 1];
            if(max < tmp) max = tmp;
        }

        return max;
    }
    public static void main(String[] args) throws IOException {
        problem_03_03 mc = new problem_03_03();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] income = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            income[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(mc.solution(N, K, income));
    }
}

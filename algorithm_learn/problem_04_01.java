import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class problem_04_01 {
    public int solution(int n, int k, int[] arr) {
        int result = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++) {
            int tmp = k;
            int tmpLen = 0;
            for(int j = i; j < n; j++) {
                if(arr[j] == 0) {
                    if(tmp == 0) break;
                    tmp--;
                    tmpLen++;
                } else tmpLen++;
            }
            if(result < tmpLen) result = tmpLen;
        }

        return result;
    }
    public static void main(String[] args) throws IOException {
        problem_04_01 mc = new problem_04_01();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(mc.solution(N, K, arr));
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class problem_03_04 {
    public int solution(int n, int m, int[] arr) {
        int result = 0;
        int tmp = 0;
        int prev = 0;

        int i = 0;
        while(i < n) {
            if(tmp == m) {
                result++;
                tmp -= arr[prev++];
            } else if(tmp > m) {
                tmp -= arr[prev++];
            } else {
                tmp += arr[i++];
            }
        }
        if(tmp == m) result++;

        return result;
    }
    public static void main(String[] args) throws IOException {
        problem_03_04 mc = new problem_03_04();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(mc.solution(N, M, arr));
    }
}

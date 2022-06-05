import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class problem_06_03 {
    public void solution(int N, int[] arr) {
        for(int i = 1; i < N; i++) {
            int tmp = arr[i], j;
            for(j = i - 1; j >= 0; j--) {
                if(arr[j] > tmp) arr[j + 1] = arr[j];
                else break;
            }
            arr[j + 1] = tmp;
        }

        for(int x : arr) {
            System.out.print(x + " ");
        }
    }
    public static void main(String[] args) throws IOException {
        problem_06_03 mc = new problem_06_03();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        mc.solution(N, arr);
    }
}
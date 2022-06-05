import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class problem_06_02 {
    public void solution(int N, int[] arr) {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N - 1; j++) {
                if(arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }

        for(int x : arr) {
            System.out.print(x + " ");
        }
    }
    public static void main(String[] args) throws IOException {
        problem_06_02 mc = new problem_06_02();
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
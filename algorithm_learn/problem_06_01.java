import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class problem_06_01 {
    public void solution(int N, int[] arr) {
        for(int i = 0; i < N - 1; i++) {
            int idx = i;
            for(int j = i; j < N; j++) {
                if(arr[idx] > arr[j]) idx = j;
            }

            int tmp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = tmp;
        }

        for(int x : arr) {
            System.out.print(x + " ");
        }
    }
    public static void main(String[] args) throws IOException {
        problem_06_01 mc = new problem_06_01();
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
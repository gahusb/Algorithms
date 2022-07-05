import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class problem_06_05 {
    public String solution(int N, int[] arr) {
        String answer = "U";
        Arrays.sort(arr);
        for(int i = 0; i < N - 1; i++) {
            if(arr[i] == arr[i + 1]) answer = "D";
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        problem_06_05 mc = new problem_06_05();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] num = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(mc.solution(N, num));
    }
}
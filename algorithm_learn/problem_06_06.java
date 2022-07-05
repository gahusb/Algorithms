import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class problem_06_06 {
    public static void solution(int N, int[] arr) {
        int cheolsu = 0;
        int partner = 0;
        int[] tmp = arr.clone();    // 깊은 복사
        Arrays.sort(tmp);

        for(int i = 0; i < N; i++) {
            if(arr[i] != tmp[i]) {
                if(partner == 0) partner = i + 1;
                else cheolsu = i + 1;
            }
        }

        System.out.println(partner + " " + cheolsu);
    }
    public static void main(String[] args) throws IOException {
        problem_06_06 mc = new problem_06_06();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] height = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }

        mc.solution(N, height);
    }
}
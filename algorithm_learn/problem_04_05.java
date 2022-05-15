import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeSet;

class problem_04_05 {
    public int solution(int N, int K, int[] arr) {
        int answer = -1;
        TreeSet<Integer> ts = new TreeSet<>(Collections.reverseOrder());
        for(int i = 0; i < N; i++) {
            for(int j = i + 1; j < N; j++) {
                for(int k = j + 1; k < N; k++) {
                    ts.add(arr[i] + arr[j] + arr[k]);
                }
            }
        }

        int cnt = 0;
        for(int x : ts) {
            cnt++;
            if(cnt == K) {
                answer = x;
                break;
            }
        }

        return answer;
    }
    public static void main(String[] args) throws IOException {
        problem_04_05 mc = new problem_04_05();
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

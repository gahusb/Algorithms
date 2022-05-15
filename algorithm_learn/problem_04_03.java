import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

class problem_04_03 {
    public void solution(int N, int K, int[] in) {
        StringBuilder sb = new StringBuilder();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i = 0; i < K; i++) {
            if(map.containsKey(in[i])) map.put(in[i], map.get(in[i]) + 1);
            else map.put(in[i], 1);
        }
        sb.append(map.size() + " ");

        for(int i = K; i < N; i++) {
            if(map.get(in[i - K]) == 1) map.remove(in[i - K]);
            else map.put(in[i - K], map.get(in[i - K]) - 1);

            if(map.containsKey(in[i])) map.put(in[i], map.get(in[i]) + 1);
            else map.put(in[i], 1);

            sb.append(map.size() + " ");
        }

        System.out.println(sb.toString());
    }
    public static void main(String[] args) throws IOException {
        problem_04_03 mc = new problem_04_03();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int input[] = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        mc.solution(N, K, input);
    }
}

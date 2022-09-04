import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class problem_08_01 {
    static int[] num;
    static int[] group;
    static int N;
    static String answer;
    public void DFS(int v) {
        if(v == N) {
            int a, b;
            a = b = 0;
            for(int i = 0; i < N; i++) {
                if(group[i] == 0) a += num[i];
                else b += num[i];
            }
            if(a == b) answer = "YES";
        } else {
            for(int i = v; i < N; i++) {
                group[i] = 1;
                DFS(v+1);
                group[i] = 0;
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        problem_08_01 mc = new problem_08_01();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        num = new int[N];
        group = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        
        answer = "NO";
        mc.DFS(0);
        System.out.println(answer);
    }
}
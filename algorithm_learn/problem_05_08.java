import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class problem_05_08 {
    public int solution(int M, Queue<Integer> qu) {
        int answer = 0;

        while(true) {
            int max = 0, tmp = 0;
            for(int i = 0; i < qu.size(); i++) {
                tmp = qu.poll();
                if(max < tmp) max = tmp;
                qu.add(tmp);
            }

            while(true) {
                tmp = qu.poll();
                if(tmp != max) qu.add(tmp);
                else {
                    answer++;
                    break;
                }
            }

            if(tmp == M) break;
        }

        return answer;
    }
    public static void main(String[] args) throws IOException {
        problem_05_08 mc = new problem_05_08();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Queue<Integer> qu = new LinkedList<Integer>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            qu.add(Integer.parseInt(st.nextToken()));
        }

        System.out.println(mc.solution(M, qu));
    }
}

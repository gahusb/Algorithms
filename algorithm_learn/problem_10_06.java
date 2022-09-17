import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class problem_10_06 {
    static class Problem implements Comparable<Problem> {
        int score, time;
        Problem(int score, int time) {
            this.score = score;
            this.time = time;
        }

        @Override
        public int compareTo(Problem o) {
            return o.time - this.time;
        }
    }

    static int[] dy;
    static ArrayList<Problem> problems;

    public int solution(int n, int m) {
        dy[0] = 0;
        for(int i = 0; i < n; i++) {
            int tmp = problems.get(i).time;
            for(int j = m; j >= tmp; j--) {
                dy[j] = Math.max(dy[j], dy[j - tmp] + problems.get(i).score);
            }
        }

        return dy[m];
    }
    
    public static void main(String[] args) throws IOException {
        problem_10_06 mc = new problem_10_06();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        problems = new ArrayList<Problem>();
        dy = new int[M + 1];

        for(int i = 0; i < N; i++) {
            if(!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            problems.add(new Problem(s, t));
        }
        Collections.sort(problems);

        System.out.println(mc.solution(N, M));
    }
}
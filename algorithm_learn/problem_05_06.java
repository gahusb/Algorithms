import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class problem_05_06 {
    public int solution(int N, int K) {
        int answer = 0;
        Queue<Integer> qu = new LinkedList<Integer>();

        for(int i = 1; i <= N; i++) qu.add(i);

        int cnt = 1;
        while(qu.size() > 1) {
            int tmp = qu.poll();
            if(cnt != K) {
                qu.add(tmp);
                cnt++;
            } else cnt = 1;
        }

        answer = qu.poll();

        return answer;
    }
    public static void main(String[] args) throws IOException {
        problem_05_06 mc = new problem_05_06();
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        int K = scanner.nextInt();

        System.out.println(mc.solution(N, K));
        scanner.close();
    }
}

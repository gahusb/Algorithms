import java.util.Scanner;

class problem_02_05 {
    public int solution(int N) {
        int answer = 0;
        int[] ch = new int[N + 1];

        for(int i = 2; i <= N; i++) {
            if(ch[i] == 0) {
                answer++;
                for(int j = i; j <= N; j += i) ch[j] = 1;
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        problem_02_05 mc = new problem_02_05();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println(mc.solution(N));
    }
}

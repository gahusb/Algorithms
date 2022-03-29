import java.util.Scanner;

class problem_02_07 {
    public int solution(int[] ox) {
        int answer = 0;
        int prev = 0;
        
        for(int i = 0; i < ox.length; i++) {
            if(ox[i] == 1) {
                answer += 1 + 1 * prev;
                prev++;
            } else {
                prev = 0;
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        problem_02_07 mc = new problem_02_07();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] ox = new int[N];
        for(int i = 0; i < N; i++) {
            ox[i] = sc.nextInt();
        }

        System.out.println(mc.solution(ox));
    }
}

import java.util.ArrayList;
import java.util.Scanner;

class problem_02_08 {
    public ArrayList<Integer> solution(int[] kor) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        int len = kor.length;
        
        for(int i = 0; i < len; i++) {
            int tmp = 1;
            for(int j = 0; j < len; j++) {
                if(i == j) continue;
                if(kor[i] < kor[j]) tmp++;
            }
            answer.add(tmp);
        }

        return answer;
    }
    public static void main(String[] args) {
        problem_02_08 mc = new problem_02_08();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] kor = new int[N];
        for(int i = 0; i < N; i++) {
            kor[i] = sc.nextInt();
        }

        for(int x : mc.solution(kor)) {
            System.out.print(x + " ");
        }
    }
}

import java.io.IOException;
import java.util.Scanner;

class problem_10_03 {
    static int[] dy, arr;
    public int solution(int n) {
        int answer = Integer.MIN_VALUE;
        dy[0] = 1;
        for(int i = 1; i < n; i++) {
            int max = 0;
            for(int j = i - 1; j >= 0; j--) {
                if(arr[i] > arr[j] && dy[j] > max) {
                    max = dy[j];
                }
            }
            dy[i] = max + 1;
            answer = answer < dy[i] ? dy[i] : answer;
        }

        return answer;
    }
    
    public static void main(String[] args) throws IOException {
        problem_10_03 mc = new problem_10_03();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        arr = new int[N];
        dy = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(mc.solution(N));
        sc.close();
    }
}
import java.util.Scanner;

class problem_02_04 {
    public void solution(int N, int[] arr, int idx) {
        if(idx == N - 2) return;

        arr[idx + 2] = arr[idx] + arr[idx + 1];
        solution(N, arr, idx+1);
    }
    public static void main(String[] args) {
        problem_02_04 mc = new problem_02_04();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];

        arr[0] = 1; arr[1] = 1;
        mc.solution(N, arr, 0);

        String answer = "";
        for(int i = 0; i < N; i++) {
            answer += arr[i] + " ";
        }
        System.out.println(answer);

        sc.close();
    }
}

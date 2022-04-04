import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class problem_03_02 {
    public ArrayList<Integer> solution(int[] arr1, int[] arr2) {
        ArrayList<Integer> solution = new ArrayList<Integer>();
        int p1 = 0, p2 = 0;

        while(p1 < arr1.length && p2 < arr2.length) {
            if(arr1[p1] > arr2[p2]) {
                p2++;
            } else if(arr1[p1] == arr2[p2]) {
                solution.add(arr1[p1]);
                p1++; p2++;
            } else {
                p1++;
            }
        }

        return solution;
    }
    public static void main(String[] args) throws IOException {
        problem_03_02 mc = new problem_03_02();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] arr1 = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr1);

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int[] arr2 = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr2);

        for(int x : mc.solution(arr1, arr2)) {
            System.out.print(x + " ");
        }
    }
}

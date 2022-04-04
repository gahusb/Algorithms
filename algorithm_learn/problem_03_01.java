import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class problem_03_01 {
    public int[] solution(int[] arr1, int[] arr2) {
        int len = arr1.length + arr2.length;
        int[] arr = new int[len];
        int p1 = 0, p2 = 0, idx = 0;

        while(p1 < arr1.length && p2 < arr2.length) {
            if(arr1[p1] < arr2[p2]) {
                arr[idx++] = arr1[p1++];
            } else {
                arr[idx++] = arr2[p2++];
            }
        }

        while(p1 < arr1.length) arr[idx++] = arr1[p1++];
        while(p2 < arr2.length) arr[idx++] = arr2[p2++];

        return arr;
    }
    public static void main(String[] args) throws IOException {
        problem_03_01 mc = new problem_03_01();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] arr1 = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int[] arr2 = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        for(int x : mc.solution(arr1, arr2)) {
            System.out.print(x + " ");
        }
    }
}

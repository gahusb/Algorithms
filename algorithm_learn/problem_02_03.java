import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class problem_02_03 {
    public void solution(int[] a, int[] b) {
        // 1 : si, 2 : ba, 3 : bo
        for(int i = 0; i < a.length; i++) {
            if(a[i] == b[i]) System.out.println("D");
            else if(a[i] < b[i]) {
                if(a[i] == 1 && b[i] == 3) System.out.println("A");
                else System.out.println("B");
            } else {
                if(a[i] == 3 && b[i] == 1) System.out.println("B");
                else System.out.println("A");
            }
        }
    }
    public static void main(String[] args) throws IOException {
        problem_02_03 mc = new problem_02_03();
        BufferedReader br = new BufferedReader(new  InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] A = new int[n];
        int[] B = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
        
        mc.solution(A, B);
    }
}

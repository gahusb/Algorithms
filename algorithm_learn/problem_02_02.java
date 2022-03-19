import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class problem_02_02 {
    public int solution(int[] arr) {
        int answer = 1;

        int max = arr[0];
        for(int i = 1; i < arr.length; i++) {
            if(max < arr[i]) {
                max = arr[i];
                answer++;
            }
        }

        return answer;
    }
    public static void main(String[] args) throws IOException {
        problem_02_02 mc = new problem_02_02();
        BufferedReader br = new BufferedReader(new  InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        System.out.println(mc.solution(arr));
    }
}

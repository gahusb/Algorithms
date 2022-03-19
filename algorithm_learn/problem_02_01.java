import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class problem_02_01 {
    public String solution(int[] arr) {
        String answer = "";

        answer += arr[0] + " ";
        for(int i = 1; i < arr.length; i++) {
            if(arr[i - 1] < arr[i]) answer += arr[i] + " ";
        }

        return answer;
    }
    public static void main(String[] args) throws IOException {
        problem_02_01 mc = new problem_02_01();
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

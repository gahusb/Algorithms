import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TheLonDecParSequence_11722 {
    // dp에 가장 긴 감소 수열의 값을 담는다.
    // 현재 값이 이전 값보다 작으면 +1 해주는 원리로 담기.
    public static int solution(int len, int[] arr) {
        int answer = 0;

        int[] leng = new int[len + 1];

        for(int i = 0; i < len; i++) {
            leng[i] = 1;
            for(int j = i - 1; j >= 0; j--) {
                if(arr[i] < arr[j] && leng[i] <= leng[j])
                    leng[i] = leng[j] + 1;
            }
            answer = Math.max(answer, leng[i]);
        }

        for(int i = 0; i < len; i++) {
            System.out.print(leng[i] + " ");
        }
        System.out.println();

        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int[] sequen = new int[A + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < A; i++) {
            sequen[i] = Integer.parseInt(st.nextToken());
        }

        int answer = solution(A, sequen);
        System.out.println(answer);
    }
}

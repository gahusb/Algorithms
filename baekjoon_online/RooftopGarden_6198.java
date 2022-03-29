import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class RooftopGarden_6198 {
    public long solution(long[] b) {
        long answer = 0;
        int bLen = b.length;
        Stack<Long> st = new Stack<>();

        for(int i = 0; i < bLen; i++) {
            
            while(!st.isEmpty()) {
                if(st.peek() <= b[i]) st.pop();
                else break;
            }

            answer += st.size();
            st.add(b[i]);
        }

        return answer;
    }
    public static void main(String[] args) throws IOException {
        RooftopGarden_6198 mc = new RooftopGarden_6198();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        long[] building = new long[N];
        for(int i = 0; i < N; i++) {
            building[i] = sc.nextLong();
        }

        System.out.println(mc.solution(building));
    }
}

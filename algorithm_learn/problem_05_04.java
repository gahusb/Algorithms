import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class problem_05_04 {
    static int N, M;
    public int solution(String str) {
        char[] cArr = str.toCharArray();
        Stack<Integer> st = new Stack<>();

        for(char c : cArr) {
            if(c >= '0' && c <= '9') {
                int tmp = c - '0';
                st.push(tmp);
            } else {
                int second = st.pop();
                int first = st.pop();
                int after = 0;
                if(c == '+') after = first + second;
                else if(c == '-') after = first - second;
                else if(c == '*') after = first * second;
                else if(c == '/') after = first / second;

                st.push(after);
            }
        }

        return st.pop();
    }
    public static void main(String[] args) throws IOException {
        problem_05_04 mc = new problem_05_04();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String str = br.readLine();

        System.out.println(mc.solution(str));
    }
}

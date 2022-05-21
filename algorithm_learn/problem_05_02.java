import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class problem_05_02 {
    public String solution(String str) {
        StringBuilder sb = new StringBuilder();
        char[] cArr = str.toCharArray();

        Stack<Character> st = new Stack<>();

        for(char x : cArr) {
            if(x == ')') {
                while(true) {
                    char c = st.pop();
                    if(c == '(') break;
                }
            } else if(st.isEmpty() && x != '(') {
                sb.append(x);
            } else {
                st.push(x);
            }
        }

        return sb.toString();
    }
    public static void main(String[] args) throws IOException {
        problem_05_02 mc = new problem_05_02();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String str = br.readLine();

        System.out.println(mc.solution(str));
    }
}

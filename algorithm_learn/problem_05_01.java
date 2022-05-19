import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class problem_05_01 {
    public String solution(String str) {
        String answer = "YES";
        char[] cArr = str.toCharArray();

        Stack<Character> st = new Stack<>();

        for(char x : cArr) {
            if(x == '(') st.push(x);
            else {
                char c = st.peek();
                if(c == '(') st.pop();
                else st.push(x);
            }
        }

        if(st.size() == 0) return "NO";

        return answer;
    }
    public static void main(String[] args) throws IOException {
        problem_05_01 mc = new problem_05_01();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String str = br.readLine();

        System.out.println(mc.solution(str));
    }
}

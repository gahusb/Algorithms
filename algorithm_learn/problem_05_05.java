import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class problem_05_05 {
    public int solution(String str) {
        int answer = 0;
        char[] cArr = str.toCharArray();
        Stack<Character> st = new Stack<>();

        for(char c : cArr) {
            if(c == '(') {
                st.push(c);
            } else {
                char x = st.pop();
                answer += st.size();
            }
        }

        return answer;
    }
    public static void main(String[] args) throws IOException {
        problem_05_05 mc = new problem_05_05();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String str = br.readLine();

        System.out.println(mc.solution(str));
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class problem_05_05 {
    public int solution(String str) {
        int answer = 0;
        Stack<Character> st = new Stack<>();

        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '(') {
                st.push('(');
            } else {
                st.pop();
                if(str.charAt(i-1) == '(') answer += st.size();
                else answer++;
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

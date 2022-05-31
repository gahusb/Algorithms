import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class problem_05_07 {
    public String solution(String sequence, String sign) {
        String answer = "YES";
        Queue<Character> qu = new LinkedList<Character>();

        for(int i = 0; i < sequence.length(); i++) {
            qu.add(sequence.charAt(i));
        }

        for(char c : sign.toCharArray()) {
            if(c == qu.peek()) qu.poll();
            if(qu.isEmpty()) break;
        }

        if(!qu.isEmpty()) answer = "NO";

        return answer;
    }
    public static void main(String[] args) throws IOException {
        problem_05_07 mc = new problem_05_07();
        Scanner scanner = new Scanner(System.in);
        
        String N = scanner.next();
        String K = scanner.next();

        System.out.println(mc.solution(N, K));
        scanner.close();
    }
}

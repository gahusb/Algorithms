import java.util.Scanner;

class problem_01_09 {
    public int solution(String str) {
        int answer = 0;

        char[] ch = str.toCharArray();
        for(char c : ch) {
            if(c >= '0' && c <= '9') {
                answer = answer * 10 + (c - '0');
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        problem_01_09 mc = new problem_01_09();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(mc.solution(str));
    }
}

import java.util.Scanner;

class problem_01_02 {
    public String solution(String str) {
        String answer = "";

        for(char x : str.toCharArray()) {
//            if(Character.isLowerCase(x)) answer += Character.toUpperCase(x);
//            else answer += Character.toLowerCase(x);
            if(97 <= x && x <= 122) answer += (char)(x - ('a' - 'A'));
            else answer += (char)(x + ('a' - 'A'));
        }

        return answer;
    }
    public static void main(String[] args) {
        problem_01_02 mc = new problem_01_02();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(mc.solution(str));
        sc.close();
    }
}

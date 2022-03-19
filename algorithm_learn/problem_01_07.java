import java.util.Scanner;

class problem_01_07 {
    public String solution(String str) {
        String answer = "YES";

        int len = str.length();
        str = str.toUpperCase();
        for (int i = 0; i < len / 2; i++) {
            if(str.charAt(i) != str.charAt(len - i - 1)) {
                return answer = "NO";
            }
        }

        return answer;
    }

    public String solution1(String str) {
        String answer = "YES";
        String tmp = new StringBuilder(str).reverse().toString();
        if(!str.equalsIgnoreCase(tmp)) return "NO";
        else return answer;
    }
    public static void main(String[] args) {
        problem_01_07 mc = new problem_01_07();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(mc.solution1(str));
    }
}

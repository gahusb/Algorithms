import java.util.Scanner;

class problem_01_06 {
    public String solution(String str) {
        String answer = "";

        for(int i = 0; i < str.length(); i++) {
            // System.out.println(str.charAt(i) + " " + i + " " + str.indexOf(str.charAt(i)));
            // indexOf : 처음 만나는 index를 리턴해준다.
            if(i == str.indexOf(str.charAt(i))) {
                answer += str.charAt(i);
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        problem_01_06 mc = new problem_01_06();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(mc.solution(str));
    }
}

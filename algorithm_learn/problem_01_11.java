import java.util.Scanner;

class problem_01_11 {
    public String solution(String str) {
        String answer = "";
        char[] chars = str.toCharArray();

        int p = 1;
        char tmp = chars[0];
        for(int i = 1; i < chars.length; i++) {
            if(chars[i] == tmp) {
                p++;
                if(i == chars.length - 1) {
                    answer += tmp;
                    answer += p;
                }
            } else {
                answer += tmp;
                if(p != 1) answer += p;

                if(i == chars.length - 1) answer += chars[i];
                else {
                    p = 1;
                    tmp = chars[i];
                }
            }
        }

        return answer;
    }

    public String solution1(String str) {
        String answer = "";
        str = str + " ";
        int cnt = 1;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == str.charAt(i + 1)) cnt++;
            else {
                answer += str.charAt(i);
                if(cnt > 1) answer += cnt;
                cnt = 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        problem_01_11 mc = new problem_01_11();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(mc.solution(str));

        sc.close();
    }
}

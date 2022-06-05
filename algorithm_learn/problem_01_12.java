import java.util.Scanner;

class problem_01_12 {
    public char decrypt(char[] data) {
        char result = 0;

        for(int i = data.length - 1; i >= 0; i--) {
            if(data[i] == '#') {
                result += (int)Math.pow(2, data.length - i - 1);
            }
        }
        return result;
    }
    public String solution(int n, String str) {
        String answer = "";

        for(int i = 0; i < n; i++) {
            char[] tmp = str.substring(i * 7, i * 7 + 7).toCharArray();
            answer += decrypt(tmp);
        }

        return answer;
    }

    public String solution1(int n, String str) {
        String answer = "";

        for(int i = 0; i < n; i++) {
            String tmp = str.substring(0, 7).replace('#', '1').replace('*', '0');
            int num = Integer.parseInt(tmp, 2);
            answer += (char)num;
            str = str.substring(7);
        }

        return answer;
    }

    public static void main(String[] args) {
        problem_01_12 mc = new problem_01_12();
        Scanner sc = new Scanner(System.in);
        int su = sc.nextInt();
        String str = sc.next();
        System.out.println(mc.solution(su, str));

        sc.close();
    }
}

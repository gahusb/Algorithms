import java.util.Scanner;

class problem_01_03 {
    public String solution(String str) {
        String answer = "";

        int max = Integer.MIN_VALUE;

        // String arr[] = str.split(" ");
        // for(String x : arr) {
        //     int len = x.length();
        //     if(len > max) {
        //         max = len;
        //         answer = x;
        //     }
        // }
        int pos = 0;
        while((pos = str.indexOf(' ')) != -1) {
            String subStr = str.substring(0, pos);
            int len = subStr.length();
            if(len > max) {
                max = len;
                answer = subStr;
            }
            str = str.substring(pos + 1);
        }
        if(str.length() > max) answer = str;

        return answer;
    }
    public static void main(String[] args) {
        problem_01_03 mc = new problem_01_03();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(mc.solution(str));

        sc.close();
    }
}

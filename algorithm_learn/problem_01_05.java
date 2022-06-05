import java.util.Scanner;

class problem_01_05 {
    public String solution(String str) {
        String answer = "";
        char[] charArr = str.toCharArray();

        int lt = 0, rt = charArr.length - 1;

        while(lt < rt) {
            //if(!(charArr[lt] >= 'a' && charArr[lt] <= 'z') && !(charArr[lt] >= 'A' && charArr[lt] <= 'Z')) {
            if(!Character.isAlphabetic(charArr[lt])) {
                lt++;
            } else if(!Character.isAlphabetic(charArr[rt])) {
                rt--;
            } else {
                char tmp = charArr[lt];
                charArr[lt] = charArr[rt];
                charArr[rt] = tmp;
                lt++; rt--;
            }
        }

        answer = String.valueOf(charArr);

        return answer;
    }
    public static void main(String[] args) {
        problem_01_05 mc = new problem_01_05();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        System.out.println(mc.solution(str));

        sc.close();
    }
}

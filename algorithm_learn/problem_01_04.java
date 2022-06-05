import java.util.ArrayList;
import java.util.Scanner;

class problem_01_04 {
    public ArrayList<String> solution(int n, String[] arr) {
        ArrayList<String> answer = new ArrayList<String>();

        for(String x : arr) {
            // String tmp = new StringBuilder(x).reverse().toString();
            // answer.add(tmp);
            char[] tmp = x.toCharArray();
            for(int i = 0; i < tmp.length / 2; i++) {
                char temp = tmp[i];
                tmp[i] = tmp[tmp.length - i - 1];
                tmp[tmp.length - i - 1] = temp;
            }
            String str = String.valueOf(tmp);
            answer.add(str);
        }
        return answer;
    }
    public static void main(String[] args) {
        problem_01_04 mc = new problem_01_04();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] words = new String[n];
        for (int i = 0; i < words.length; i++) {
            words[i] = sc.next();
        }
        for(String word : mc.solution(n, words)) {
            System.out.println(word);
        }

        sc.close();
    }
}

import java.util.Scanner;

class problem_01_08 {
    public String solution(String str) {
        str = str.toUpperCase().replaceAll("[^A-Z]", "");
        String tmp = new StringBuilder(str).reverse().toString();
        if(str.equals(tmp)) return "YES";
        else return "NO";
    }

    public static void main(String[] args) {
        problem_01_08 mc = new problem_01_08();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(mc.solution(str));
    }
}

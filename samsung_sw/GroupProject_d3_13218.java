import java.util.Scanner;

public class GroupProject_d3_13218 {
    public static int solution(int x) {
        return x / 3;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < T; i++) {
            int tmp = sc.nextInt();
            sb.append("#" + (i+1) + " " + solution(tmp) + "\n");
        }

        System.out.println(sb.toString());
    }
}

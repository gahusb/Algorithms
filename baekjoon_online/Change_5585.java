import java.util.Scanner;

public class Change_5585 {
    static int[] coin = {500, 100, 50, 10, 5, 1};

    public static void main(String[] args) {
        int money = 1000;

        Scanner sc = new Scanner(System.in);

        int price = sc.nextInt();
        int change = money - price;

        int answer = 0;

        for (int i = 0; i < 6; i++) {
            answer += change / coin[i];
            change = change % coin[i];
        }

        System.out.println(answer);
    }
}
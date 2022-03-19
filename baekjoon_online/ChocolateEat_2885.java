import java.util.Scanner;

public class ChocolateEat_2885 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        int D = 0;
        int i = 0;
        
        while(D < K) {
            D = (int)Math.pow(2, i);  // 1, 2, 4, 8, 16...
            i++;
        }

        int size = D, cnt = 0;
        while(K > 0) {
            if(K >= D) {
                K -= D;
            } else {
                D /= 2;
                cnt++;
            }
        }

        System.out.println(size + " " + cnt);
    }
}

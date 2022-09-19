package kakako;

// k 진수에서 수수의 개수 구하기
public class BlindRecruit_2022_2 {
    public int solution(int n, int k) {
        int answer = -1;

        int number = 0;
        while(n > k) {
            number = (number * 10) + (n / k);
        }

        return answer;
    }
    public static void main(String[] args) throws Exception {
        BlindRecruit_2022_2 mc = new BlindRecruit_2022_2();

        System.out.println(mc.solution(437674, 3));
        System.out.println(mc.solution(110011, 10));
    }
}

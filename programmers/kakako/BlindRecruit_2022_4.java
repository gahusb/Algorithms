package kakako;

// 양궁대회
public class BlindRecruit_2022_4 {
    static int max;
    public void DFS(int n, int[] info, int[] tmp, int[] answer) {
        if(n <= 0) {
            int score = 0;
            for(int i = 0; i < info.length; i++) {
                if(info[i] < tmp[i]) {
                    score += (10 - i);
                }
            }
            if(max < score) {
                for(int i = 0; i < tmp.length; i++) {
                    answer[i] = tmp[i];
                }
                max = score > max ? score : max;
            }
            return;
        }

        for(int i = 0; i < info.length; i++) {
            tmp[i]++;
            DFS(n - 1, info, tmp, answer);
            tmp[i]--;
        }
    }
    public int[] solution(int n, int[] info) {
        int[] answer = new int[11];
        int[] tmp = new int[11];
        max = Integer.MIN_VALUE;
        DFS(n, info, tmp, answer);
        return answer;
    }
    public static void main(String[] args) throws Exception {
        BlindRecruit_2022_4 mc = new BlindRecruit_2022_4();

        int[] info1 = {2,1,1,1,0,0,0,0,0,0,0};
        int[] info2 = {1,0,0,0,0,0,0,0,0,0,0};
        int[] info3 = {0,0,1,2,0,1,1,1,1,1,1};
        int[] info4 = {0,0,0,0,0,0,0,0,3,4,3};

        int[] result1 = mc.solution(5, info1);
        int[] result2 = mc.solution(1, info2);
        int[] result3 = mc.solution(9, info3);
        int[] result4 = mc.solution(10, info4);

        for(int i = 0; i < result1.length; i++) {
            System.out.print(result1[i] + ", ");
        }
        System.out.println();
        for(int i = 0; i < result2.length; i++) {
            System.out.print(result2[i] + ", ");
        }
        System.out.println();
        for(int i = 0; i < result3.length; i++) {
            System.out.print(result3[i] + ", ");
        }
        System.out.println();
        for(int i = 0; i < result4.length; i++) {
            System.out.print(result4[i] + ", ");
        }
        System.out.println();
    }
}

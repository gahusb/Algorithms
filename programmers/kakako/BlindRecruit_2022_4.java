package kakako;

// 양궁대회
public class BlindRecruit_2022_4 {
    static int max;
    public void DFS(int n, int[] info, int[] tmp, int[] answer, int depth) {
        if(depth == 10) {
            tmp[depth] = n;
            int apeach = 0, ryan = 0;
            for(int i = 0; i < 11; i++) {
                if(info[i] == 0 && tmp[i] == 0) continue;
                if(info[i] < tmp[i]) ryan += (10 - i);
                else apeach += (10 - i);
            }

            if(ryan > apeach && max <= (ryan - apeach)) {
                boolean c = true;
                if(max != 0 && max == (ryan - apeach)) {
                    for(int i = 10; i >= 0; --i) {
                        if(answer[i] == tmp[i]) continue;
                        if(answer[i] > tmp[i]) {
                            c = false;
                        }
                        break;
                    }
                }
                if(c) {
                    for(int i = 0; i < 11; i++) answer[i] = tmp[i];
                    max = (ryan - apeach) >= max ? (ryan - apeach) : max;
                }
            }
            return;
        }
        for(int i = n; i >= 0; --i) {
            tmp[depth] = i;
            DFS(n - i, info, tmp, answer, depth + 1);
        }
    }

    public int[] solution(int n, int[] info) {
        int[] answer = new int[11];
        int[] tmp = new int[11];
        max = 0;
        DFS(n, info, tmp, answer, 0);

        boolean check = false;
        for(int i = 0; i < 11; i++) {
            if(answer[i] != 0) {
                check = true;
                break;
            }
        }
        if(!check) {
            answer = new int[1];
            answer[0] = -1;
        }
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

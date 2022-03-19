import java.util.Scanner;

class problem_01_10 {
    public String solution(String str, char c) {
        String answer = "";
        char[] cArr = str.toCharArray();
        int[] dist = new int[cArr.length];
        int prev = 0;
        for(int i = 0; i < cArr.length; i++) {
            if(cArr[i] == c) {
                dist[i] = 0;
                prev = i;
                continue;
            }
            for(int j = i + 1; j < cArr.length; j++) {
                if(cArr[j] == c) {
                    if(i == 0) dist[i] = j - i;
                    else dist[i] = (i - prev) > (j - i) ? (j - i) : (i - prev);
                    break;
                }
                if(j == cArr.length - 1) dist[i] = i - prev;
            }
        }

        for(int i : dist) {
            answer += (i + " ");
        }

        return answer;
    }

    public String solution1(String str, char c) {
        String answer = "";
        int len = str.length();
        char[] cArr = str.toCharArray();
        int[] dist = new int[len];
        int p = 101;
        for(int i = 0; i < len; i++) {
            if(cArr[i] == c) {
                p = 0;
                dist[i] = p;
            } else {
                p++;
                dist[i] = p;
            }
        }
        
        p = 101;
        for(int i = len - 1; i >= 0; i--) {
            if(cArr[i] == c) {
                p = 0;
            } else {
                p++;
                dist[i] = dist[i] > p ? p : dist[i];
            }
        }
        
        for(int su : dist) {
            answer += su + " ";
        }

        return answer;
    }

    public static void main(String[] args) {
        problem_01_10 mc = new problem_01_10();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char c = sc.next().charAt(0);
        System.out.println(mc.solution(str, c));
    }
}

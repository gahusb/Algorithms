import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GroupPhoto_level2 {
    // 어피치, 콘, 프로도, 제이지, 무지, 네오, 라이언, 튜브
    static char[] kakaoFriends = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    static int totalcnt;

    public static int findFriend(char[] kakao, char pick) {
        for(int i = 0; i < kakao.length; i++) {
            if(kakao[i] == pick) return i;
        }
        return -1;
    } 

    public static void checkOrder(char[] kakao, String[] data) {
        int len = data.length;
        for(int i = 0; i < len; i++) {
            char[] tmp = data[i].toCharArray();
            int first = findFriend(kakao, tmp[0]);
            int second = findFriend(kakao, tmp[2]);
            int gap = tmp[4] - '0';
            if(tmp[3] == '=') {
                if(Math.abs(first - second) != gap + 1) return;
            } else if(tmp[3] == '<') {
                if(Math.abs(first - second) >= gap + 1) return;
            } else if(tmp[3] == '>') {
                if(Math.abs(first - second) <= gap + 1) return;
            }
        }

        totalcnt++;
    }

    public static void swap(char[] data, int depth, int i) {
        char tmp = data[depth];
        data[depth] = data[i];
        data[i] = tmp;
    }

    public static void permutation(char[] arr, int depth, int n, int r, String[] data) {
        if(depth == r) {
            checkOrder(arr, data);
            return;
        }

        for(int i = depth; i < n; i++) {
            swap(arr, depth, i);
            permutation(arr, depth + 1, n, r, data);
            swap(arr, depth, i);
        }
    }
    public static int solution(int n, String[] data) {
        totalcnt = 0;
        permutation(kakaoFriends, 0, 8, 8, data);
        return totalcnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        String[] data = new String[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            data[i] = st.nextToken();
        }

        System.out.println(solution(N, data));
    }
}

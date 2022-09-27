package kakako;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class BlindRecruit_2023_6 {

    class Point {
        int r, c, len;
        String str;
        Point(int r, int c, int len, String str) {
            this.r = r;
            this.c = c;
            this.len = len;
            this.str = str;
        }
    }

    // u, l, d, r
    public int[][] dir = {
        {-1, 0, 1, 0},
        {0, -1, 0, 1}
    };

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        String answer = "";

        char[][] board = new char[n + 1][m + 1];
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                board[i][j] = '.';
            }
        }
        board[x][y] = 'S';
        board[r][c] = 'E';

        Queue<Point> qu = new LinkedList<Point>();
        qu.add(new Point(x, y, 0, ""));

        while(!qu.isEmpty()) {
            Point tmp = qu.poll();
            for(int i = 0; i < 4; i++) {
                int nr = tmp.r + dir[0][i];
                int nc = tmp.c + dir[1][i];
                if(nr < 1 || nc < 1 || nr > n || nc > m) continue;
                if(Math.abs(nr - r) + Math.abs(nc - c) > k - tmp.len - 1) continue; // 앞으로 남은거리보다 거리가 길면 패스
                if(board[nr][nc] == 'E') {
                    if( (k - tmp.len - 1) % 2 != 0) continue; // 현 위치가 End 지나는데, 남은 거리가 홀수 이면, 도달 못 함
                }

                String tmpStr = tmp.str;
                if(i == 0) tmpStr += "u";
                else if(i == 1) tmpStr += "l";
                else if(i == 2) tmpStr += "d";
                else tmpStr += "r";

                if(tmp.len + 1== k) {
                    if(nr == r && nc == c) {
                        // 사전 순
                        if(answer.equals("") || answer.compareTo(tmpStr) > 0) answer = tmpStr;
                    }
                } else {
                    qu.add(new Point(nr, nc, tmp.len + 1, tmpStr));
                } 
            }
        }

        if(answer.equals("")) answer = "impossible";

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BlindRecruit_2023_6 mc = new BlindRecruit_2023_6();

        System.out.println(mc.solution(3, 4, 2, 3, 3, 1, 5));
        System.out.println(mc.solution(2, 2, 1, 1, 2, 2, 2));
        System.out.println(mc.solution(3, 3, 1, 2, 3, 3, 4));
    }
}

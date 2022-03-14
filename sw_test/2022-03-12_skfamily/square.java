public class square {
    static int[][] dir = {
        // 위, 오른, 왼쪽위 대각, 오른쪽 아래 대각
        {0, 1, -1, 1},
        {-1, 0, -1, 1}
    };

    static int[][] map;

    static int diagCal(int x, int y, int dix, int diy) {
        int wid = map.length;
        int height = map[0].length;

        for(int i = 0; i < wid; i++) {
            for(int j = height - 1; j >= 0; j--) {
                if(i == dix && j == diy) {  // 사용 대각선
                    for(int z = 0; z < 4; z++) {
                        int nx = x + dir[i][0];
                        int ny = y + dir[i][1];
                        if((nx >= 0 && ny >= 0 && nx < map.length && ny < map.length)) {
                            map[nx][ny] = map[x+dir[i][0]][y] + map[x][y+dir[i][1]];
                            x = nx;
                            y = ny;
                        }
                    }
                } else {
                    for(int z = 0; z < 2; z++) {
                        int nx = x + dir[i][0];
                        int ny = y + dir[i][1];
                        if((nx >= 0 && ny >= 0 && nx < map.length && ny < map.length)) {
                            map[nx][ny] = map[x+dir[i][0]][y] + map[x][y+dir[i][1]];
                            x = nx;
                            y = ny;
                        }
                    }
                }
            }
        }

        return map[wid - 1][0];
    }

    public static int solution(int width, int height, int[][] diagonals) {
        int answer = 0;
        map = new int[width][height];

        for(int i = 0; i < diagonals.length; i++) {
            answer += diagCal(0, height - 1, diagonals[i][0], diagonals[i][1]);
        }

        return answer;
    }
    public static void main(String[] args) {
        int[][] diag = {
            {1, 1},
            {2, 2}
        };
        int ans = 0;
        ans = solution(2, 2, diag);
        System.out.println(ans);
    }
}

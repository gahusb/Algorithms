import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class problem_05_03 {
    static int N, M;
    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < M; i++) {
            int tmp = moves[i] - 1;
            for(int j = 0; j < N; j++) {
                if(board[j][tmp] != 0) {
                    int x = board[j][tmp];
                    board[j][tmp] = 0;
                    if(!st.isEmpty()) {
                        int stTmp = st.peek();
                        if(x == stTmp) {
                            st.pop();
                            answer += 2;
                        } else {
                            st.push(x);
                        }
                    } else {
                        st.push(x);
                    }

                    break;
                }
            }
        }

        return answer;
    }
    public static void main(String[] args) throws IOException {
        problem_05_03 mc = new problem_05_03();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());

        int[][] board = new int[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        int[] moves = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            moves[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(mc.solution(board, moves));
    }
}

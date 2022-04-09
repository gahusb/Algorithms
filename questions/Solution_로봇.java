import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution_로봇 {
	static int[][][] direction = {
			{ {0, 1}	},	// A
			{ {0, -1}, {0, 1}	},	// B
			{ {-1, 0}, {1, 0}, {0, -1}, {0, 1}	}, // C
	};
	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input1.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();
			char[][] map = new char[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					// 'A' "A"
					map[i][j] = sc.next().charAt(0);
				}
			}
			
			int answer = 0;
			int newI = 0, newJ = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int robot = map[i][j] - 'A';
					if(robot > 2) continue; // 길이나 벽은 건너 뜀
					// 로봇의 타입에 맞는 이동
					for (int d = 0; d < direction[robot].length; d++) {
						newI = i;
						newJ = j;
						while(true) {
							newI += direction[robot][d][0];
							newJ += direction[robot][d][1];
							if(newI < 0 && newI >= N && newJ < 0 && newJ >= N) break;
							if(map[newI][newJ] == 'S') answer++;
							else break;
						}
					}
				}
			}
			System.out.println("#" + (t+1) + " " + answer);
		}
	}
}

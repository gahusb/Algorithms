import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution_미로 {
	static int N, Si, Sj, P, D;
	static int[][] direction = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input3.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			Si = sc.nextInt();
			Sj = sc.nextInt();
			P = sc.nextInt();
			boolean[][] map = new boolean[N + 1][N + 1];
			for (int k = 0; k < P; k++) { // 점퍼를 입력
				map[sc.nextInt()][sc.nextInt()] = true;			
			}
			
			D = sc.nextInt();
			int Dd[] = new int[D]; // 방향 모음
			int Da[] = new int[D]; // 이동 칸수 모음
			for (int k = 0; k < D; k++) { // 방향, 이동칸수 입력
				Dd[k] = sc.nextInt()-1;
				Da[k] = sc.nextInt();
			}
			//////////////////////////
			/////// 알고리즘 ////////////
			/////////////////////////
			int newI = 0, newJ = 0;
			for (int k = 0; k < D; k++) { // 이동 지시 수 만큼 반복
				int dir = Dd[k]; // 방향
				int dirCnt = Da[k]; // 이동 수
				
				for (int d = 0; d < dirCnt; d++) {
					newI = Si + direction[dir][0];
					newJ = Sj + direction[dir][1];
					
					// 경계 밖이거나 점퍼인가
					if(newI < 1 || newI > N || newJ < 1 || newJ > N
							|| map[newI][newJ]) {
						Si = Sj = 0;
						break;
					} else { // 그렇지 않으면 이동
						Si = newI;
						Sj = newJ;
					}
				}
			}
			System.out.println("#" + t + " " + Si + " " + Sj);
		}
		
	}
}

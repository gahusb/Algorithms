package book;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution_소금쟁이 {
	static int[][] map;
	static int[][] salt;
	static int N, su;
	static boolean[][] check;
	static int[] dx = {0, 1, 0}; // 0 하 우
	static int[] dy = {0, 0, 1};
	
	static int move() {
		int number = 0;
		for (int i = 0; i < su; i++) { // 소금쟁이 번호
			int nx = salt[i][0];
			int ny = salt[i][1];
			int rot = salt[i][2];
			// 시작 위치가 이미 뛰었던 자리라면 출력
			if(map[nx][ny] == 1) {
				return i + 1;
			}
			
			saltfor:
			for (int j = 3; j > 0; j--) { // 3 2 1 칸 뛰기
				nx = nx + dx[rot] * j;
				ny = ny + dy[rot] * j;
				if(nx >= 0 && nx < N && ny >= 0 && ny < N) {
					// 이미 뛰었던 자리면 해당 소금쟁이 출력
					if(map[nx][ny] == 1) return i + 1;
					else { // 아니면 뛰었던 자리 표시
						map[nx][ny] = 1;
					}
				} else break saltfor; // 연못을 나가면 끝
			}
		}
		return number;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input2.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			map = new int[N][N];
			su = sc.nextInt();
			salt = new int[su][3];
			for (int i = 0; i < su; i++) {
				salt[i][0] = sc.nextInt();
				salt[i][1] = sc.nextInt();
				salt[i][2] = sc.nextInt();
			}
			System.out.println("#" + t + " " + move());
		}
	}
}

package d4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ladder2_1211 {
	static int[][] map;
	static int[] dx = { 0, 1, -1 };
	static int[] dy = { -1, 0, 0 };
	static int result, count;

	private static void solve(int y, int x, int dir, int cnt) {
		if (y == 0) {
			if (cnt <= count) {
				result = x;
				count = cnt;
				return;
			}
		}
		if (dir == 0) {
			for (int i = 1; i < 3; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx < 0 || nx >= 100 || ny < 0 || ny >= 100 || map[ny][nx] == 0)
					continue;
				solve(ny, nx, i, cnt + 1);
				return;
			}
		} else if (dir == 1 || dir == 2) {
			for (int i = 0; i < 1; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx < 0 || nx >= 100 || ny < 0 || ny >= 100 || map[ny][nx] == 0)
					continue;
				solve(ny, nx, i, cnt + 1);
				return;
			}
		}
		int nx = x + dx[dir];
		int ny = y + dy[dir];
		if (nx < 0 || nx >= 100 || ny < 0 || ny >= 100 || map[ny][nx] == 0)
			return;
		solve(ny, nx, dir, cnt + 1);
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("ladder.txt"));
		Scanner sc = new Scanner(System.in);

		for (int i = 1; i <= 10; i++) {
			int t = sc.nextInt();
			map = new int[100][100];
			result = Integer.MAX_VALUE;
			count = Integer.MAX_VALUE;
			for (int j = 0; j < map.length; j++) {
				for (int j2 = 0; j2 < map.length; j2++) {
					map[j][j2] = sc.nextInt();
				}
			}
			for (int j = 0; j < 100; j++) {
				if (map[99][j] == 1) {
					solve(99, j, 0, 0);
				}
			}
			System.out.println("#" + t + " " + result);
		}
	}
}

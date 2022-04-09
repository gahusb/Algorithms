import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Robot_run {
	static int[][] map;
	static boolean[][] check;
	static int N;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0}; // 우 좌 하 상
	static void move(int tc) {
		int result = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 'A') {
					result += A(i, j);
				} else if(map[i][j] == 'B') {
					result += B(i, j);
				} else if(map[i][j] == 'C') {
					result += C(i, j);
				}
			}
		}
		System.out.println("#" + tc + " " + result);
	}
	static int A(int i, int j) {
		int nx, ny;
		int reA = 0;
		nx = i + dx[0];
		ny = j + dy[0];
		if(nx >= 0 && nx < N && ny >= 0 && ny < N) {
			while(true) {
				if(map[nx][ny] == 'S') {
					reA++;
					nx = nx + dx[0];
					ny = ny + dy[0];
				}
				if(nx < 0 || nx >= N || ny < 0 || ny >= N) break;
				if(map[nx][ny] == 'W' | check[nx][ny] == true) break;
			}
		}
		return reA;
	}
	static int B(int i, int j) {
		int nx, ny;
		int reB = 0;
		for (int k = 0; k < 2; k++) {
			nx = i + dx[k];
			ny = j + dy[k];
			if(nx >= 0 && nx < N && ny >= 0 && ny < N) {
				while(true) {
					if(map[nx][ny] == 'S') {
						reB++;
						nx = nx + dx[k];
						ny = ny + dy[k];
					}
					if(nx < 0 || nx >= N || ny < 0 || ny >= N) break;
					if(map[nx][ny] == 'W' | check[nx][ny] == true) break;
				}
			}
		}
		return reB;
	}
	static int C(int i, int j) {
		int nx, ny;
		int reC = 0;
		for (int k = 0; k < 4; k++) {
			nx = i + dx[k];
			ny = j + dy[k];
			if(nx >= 0 && nx < N && ny >= 0 && ny < N) {
				while(true) {
					if(map[nx][ny] == 'S') {
						reC++;
						nx = nx + dx[k];
						ny = ny + dy[k];
					}
					if(nx < 0 || nx >= N || ny < 0 || ny >= N) break;
					if(map[nx][ny] == 'W' | check[nx][ny] == true) break;
				}
			}
		}
		return reC;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		if(!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
		
		for (int i = 1; i <= T; i++) {
			if(!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			check = new boolean[N][N];
			
			for (int j = 0; j < N; j++) {
				if(!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
				char tmp;
				for (int k = 0; k < N; k++) {
					tmp = st.nextToken().charAt(0);
					if(tmp == 'A'|| tmp == 'B'|| tmp =='C') check[j][k] = true;
					map[j][k] = tmp;
				}
			}
			move(i);
		}
	}
}

package book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Mirro {
	static int[][] map;
	static int[][] jumper;
	static int N;
	static int[][] cmd; // 이동 지시(방향, 이동칸수)
	static int[] dx = {0, -1, 0, 1, 0};
	static int[] dy = {0, 0, 1, 0, -1}; // 0 상 우 하 좌
	
	static void move(int tc, int cx, int cy) {
		int row = cx, col = cy;
		int nx, ny;
		int rot, go;
		
		command:
		for (int i = 0; i < cmd.length; i++) {
			rot = cmd[i][0];
			go = cmd[i][1];
			
			for (int k = 1; k <= go; k++) {
				nx = row + dx[rot];
				ny = col + dy[rot];
				if(nx > 0 && nx <= N && ny > 0 && ny <= N) {
					for (int j = 0; j < jumper.length; j++) { // 점퍼인지 검사
						if(nx == jumper[j][0] && ny == jumper[j][1]) {
							row = 0;
							col = 0;
							break command;
						}
					}
					row = nx;
					col = ny;
				} else {
					row = 0;
					col = 0;
					break;
				}
			}
		}
		
		System.out.println("#" + tc + " " + row + " " + col);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		if(!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
		
		for (int i = 1; i <= T; i++) {
			if(!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int rx = Integer.parseInt(st.nextToken());
			int ry = Integer.parseInt(st.nextToken());			
			int jp = Integer.parseInt(st.nextToken());
			
			map = new int[N + 1][N + 1];
			jumper = new int[jp][2];
			
			for (int j = 0; j < jp; j++) {
				if(!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
				jumper[j][0] = Integer.parseInt(st.nextToken());
				jumper[j][1] = Integer.parseInt(st.nextToken());
			}
			
			if(!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
			int mob = Integer.parseInt(st.nextToken());
			cmd = new int[mob][2];
			
			for (int j = 0; j < mob; j++) {
				if(!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
				cmd[j][0] = Integer.parseInt(st.nextToken());
				cmd[j][1] = Integer.parseInt(st.nextToken());
			}
			
			move(i, rx, ry);
		}
	}
}

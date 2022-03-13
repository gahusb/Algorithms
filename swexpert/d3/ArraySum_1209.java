package d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ArraySum_1209 {
	static int max(int[][] map) {
		int max = 0;
		int rowsum = 0;
		int colsum = 0;
		int diagonalsum = 0;
		int redisum = 0;
		
		int len = map.length;
		
		for (int j = 0; j < len; j++) { // row sum
			for (int k = 0; k < len; k++) {
				rowsum += map[j][k];
			}
			if(rowsum > max) max = rowsum;
		}
		
		for (int j = 0; j < len; j++) { // col sum
			for (int k = 0; k < len; k++) {
				colsum += map[k][j];
			}
			if(colsum > max) max = colsum;
		}
		
		for (int k = 0; k < len; k++) {
			diagonalsum += map[k][k];
		}
		if(diagonalsum > max) max = diagonalsum;
		
		for (int j = 0; j < len; j++) {
			for (int k = len - 1; k >= 0; k--) {
				redisum += map[j][k];
			}
			if(redisum > max) max = redisum;
		}
		
		return max;
	}
	public static void main(String[] args) throws IOException, FileNotFoundException {
		System.setIn(new FileInputStream("arraysum.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[][] map = new int[100][100];
		int max = 0;
		for (int i = 1; i <= 10; i++) {
			if(!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
			int tc = Integer.parseInt(st.nextToken());
			
			if(!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
			
			int cnt = 0;
			while(st.hasMoreTokens()) {
				System.out.print(st.nextToken() + " ");
				cnt++;
			}
			System.out.println();
			System.out.println(cnt);
			for (int j = 0; j < map.length; j++) { // row sum
				for (int k = 0; k < map[j].length; k++) {
					map[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			max = max(map);
			System.out.println("#" + tc + " " + max);
		}
	}
}

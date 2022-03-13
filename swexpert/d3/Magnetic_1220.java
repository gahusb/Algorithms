package d3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/*
 * JAVA 언어
 * 98,732 kb 메모리
 * 362 ms 실행시간
 * 1,138 코드길이
 * 
 */
public class Magnetic_1220 {
	static final int N = 100;
	static int[][] map = new int[N][N];
	
	static int magnetic() {
		int deadlock = 0;
		ArrayList<Integer> arrList;
		for (int col = 0; col < N; col++) {
			arrList = new ArrayList<Integer>();
			for (int row = 0; row <= N-1; row++) {
				if(map[row][col] != 0) {
					arrList.add(map[row][col]);
				}
			}
			
			int size = arrList.size();
			boolean check = false;
			for (int i = 0; i < size; i++) {
				if(!check && arrList.get(i) == 2) {
					check = true;
				} else if(check && arrList.get(i) == 1) {
					check = false;
				}
				if(i > 0 && check && arrList.get(i-1) != 2) deadlock++;
			}
		}
		return deadlock;
	}
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("magnetic.txt"));
		Scanner sc = new Scanner(System.in);
		int row;
		for (int t = 1; t <= 10; t++) {
			row = sc.nextInt();
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			System.out.println("#" + t + " " + magnetic());
		}
		
	}
}

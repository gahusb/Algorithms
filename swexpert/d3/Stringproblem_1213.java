package d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * JAVA 언어
 * 15,912 kb 메모리
 * 110 ms 실행시간
 * 1,035 코드길이
 * 
 */
public class Stringproblem_1213 {
	public static void main(String[] args) throws IOException, FileNotFoundException {
		System.setIn(new FileInputStream("Stringproblem"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t <= 10; t++) {
			t = Integer.parseInt(br.readLine());
			String tmp = br.readLine();
			String compare = br.readLine();
			int result = 0;
			int tlen = tmp.length();
			int comlen = compare.length();
			
			char[] tm = new char[tlen];
			char[] cm = new char[comlen];
			
			tm = tmp.toCharArray();
			cm = compare.toCharArray();
			
			for (int i = 0; i < comlen; i++) {
				if(tm[0] == cm[i]) {
					for (int j = 0; j < tlen; j++) {
						if(i+j < comlen) {
							if(tm[j] != cm[i+j]) break;
							
							if(j == tlen - 1) {
								if(tm[j] == cm[i+j]) result++;
							}
						}
					}
				}
			}
			
			System.out.println("#" + t + " " + result);
		}
	}
}

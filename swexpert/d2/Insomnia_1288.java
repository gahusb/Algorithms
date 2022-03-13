package d2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
/*
 * JAVA 언어
 * 20,284 kb 메모리
 * 146 ms 실행시간
 * 785 코드길이
 * 
 */
public class Insomnia_1288 {
	private static int sem(int n) {
		boolean[] check = new boolean[10];
		
		int count = 1;

		int tmp = 0;
		int cal = n;
		while (true) {
			tmp = cal;
			while(tmp > 0) {
				check[tmp % 10] = true;
				tmp = tmp / 10;
			}
			boolean ch = true;
			for (int i = 0; i < check.length; i++) {
				if(check[i] == false) {
					ch = false;
					break;
				}
			}
			if(ch) return cal;
			count++;
			cal += n;
		}
	}
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("insomnia.txt"));
		Scanner sc =  new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();
			System.out.println("#" + (t+1) + " " + sem(N));
		}
	}
}

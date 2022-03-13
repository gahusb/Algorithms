package d2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Palindrome_1989 {
	public static void solve(String text, int t) {
		int middle = text.length() / 2;
		char[] c;
		char[] c1;
		if(middle % 2 == 0) { // 길이가 짝수
			c = new char[middle];
			c1 = new char[middle];
			for (int i = 0; i < middle; i++) {
				c[i] = text.charAt(i);
			}
			int k = 0;
			for (int i = text.length() - 1; i >= middle; i--) {
				c1[k++] = text.charAt(i);
			}
		} else { // 길이가 홀수
			c = new char[middle];
			c1 = new char[middle];
			for (int i = 0; i < middle; i++) {
				c[i] = text.charAt(i);
			}
			int k = 0;
			for (int i = text.length() - 1; i > middle; i--) {
				c1[k++] = text.charAt(i);
			}
		}
		int tmp = 0;
		boolean bt = false;
		for (int i = 0; i < middle; i++) {
			if(c[i] != c1[i]) {
				bt = true;
				break;
			}
		}
		if(!bt) tmp++;
		System.out.println("#" + t + " " + tmp);
	}
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("palindrome.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		for (int t = 1; t <= T; t++) {
			String S = sc.next();
			solve(S, t);
		}
	}
}

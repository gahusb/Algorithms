package d2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
/**
 * solve
 * but, 제출 불가......
 * @author student
 *
 */
public class RockThrow_1285 {
	public static void solve(int[] people, int t) {
		Arrays.sort(people);
		int tmp = people[0];
		int cnt = 0;
		for (int i = 0; i < people.length; i++) {
			if(tmp == people[i]) cnt++;
		}
		System.out.println("#" + t + " " + tmp + " " + cnt);
	}
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("rockthrows.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] people;
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			people = new int[N];
			for (int i = 0; i < people.length; i++) {
				people[i] = Math.abs(sc.nextInt());
			}
			solve(people, t);
		}
	}
}

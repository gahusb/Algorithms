package d2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Score_1983 {
	static int N;
	private static String check(double[] stu, int target) {
		double tmp = stu[target]; // 누구를 찾을 것인지 찾는 인덱스
		System.out.println(stu.length + "명의 학생중 "+ target +"인덱스 학생 점수는 : " + tmp);
		LinkedList<Double> list = new LinkedList<Double>();
		Arrays.sort(stu);
		for (int i = 0; i < stu.length; i++) {
			list.add(stu[i]);
		}
		Collections.reverse(list);
		int rank = 0;
		for (int i = 0; i < list.size(); i++) {
			if(tmp == list.get(i)) rank = i;
		}
		System.out.println(rank+ "등 학생을 찾아라!");
		switch (N / 10) {
			case 0:
				return "A+";
			case 1:
				return "A0";
			case 2:
				return "A-";
			case 3:
				return "B+";
			case 4:
				return "B0";
			case 5:
				return "B-";
			case 6:
				return "C+";
			case 7:
				return "C0";
			case 8:
				return "C-";
			default:
				return "D0";
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("score.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		double[] student;
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			int num = sc.nextInt();
			student = new double[N];
			double tmp = 0;
			for (int i = 0; i < student.length; i++) {
				tmp = (double)sc.nextInt();
				student[i] += (tmp * 0.35);
				tmp = (double)sc.nextInt();
				student[i] += (tmp * 0.45);
				tmp = (double)sc.nextInt();
				student[i] += (tmp * 0.2);
			}
			System.out.println("#" + t + " " + check(student, num - 1));
		}
	}
}

package kr.or.ddit.util;

import java.util.Scanner;

public class ScanUtil {
	
	public static Scanner scan = new Scanner(System.in);
	
	public static String nextLine() {
		return scan.nextLine();
	}
	
	public static int nextInt() {
		return Integer.parseInt(scan.nextLine());
	}
}

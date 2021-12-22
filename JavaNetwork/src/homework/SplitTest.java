package homework;

public class SplitTest {
	public static void main(String[] args) {
		
		String t1 = "/w woo 보낸다 받아라";
		
		String[] t2 = t1.split(" ", 3);
		
		System.out.print(t2[1] + "님이 당신에게 : " + t2[2]);
		
	}
}

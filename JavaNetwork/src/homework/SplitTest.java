package homework;

public class SplitTest {
	public static void main(String[] args) {
		
		String t1 = "/w woo 보낸다 받아라";
		System.out.println(t1);
		
		System.out.println("--------------------------------");

		String[] t2 = t1.split(" ", 3);
		for (String str : t2) {
			System.out.println(str.toString());
		}
		
		System.out.println("--------------------------------");
		
		System.out.print(t2[1] + "님이 당신에게 : " + t2[2]);
		
	}
}

package JavaIO.kr.or.ddit.basic;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;

/*
	프린터기능 제공 보조 스트림 예제
*/
public class T14_PrintStream {
	public static void main(String[] args) throws IOException {
		
		FileOutputStream fos1 = new FileOutputStream("D:/D_Other/print.txt");
		
		FileOutputStream fos2 = new FileOutputStream("D:/D_Other/print2.txt");
		
		/*
			PrintStream 은 모든 자료형을 출력할 수 있는 기능을 제공하는
			보조 스트림이다.
		*/
		PrintStream out = new PrintStream(fos1);
		out.print("안녕하세요. PrintStream 입니다.\n");
		out.println("안녕하세요. PrintStream 입니다.2");
		out.println("안녕하세요. PrintStream 입니다.3");
		out.println(out); // 객체 출력
		out.println(3.14);
		out.println(true);
		
		out.close();
		
		/*
			PrintStream은 데이터를 문자로 출력하는 기능을 수행함. (System.out)
			향상된 기능의 PrintWriter가 추가 되었지만 계속 사용함.
			
			PrintWriter가 PrintStream보다 다양한 언어의 문자를 처리하는데
			적합하다.
		*/
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(fos2, "UTF-8"));
		pw.print("안녕하세요. PrinterWriter 입니다.\r\n");
		pw.println("안녕하세요. PrinterWriter 입니다.2");
		pw.println("안녕하세요. PrinterWriter 입니다.3");
		
		pw.close();
		
	}
}

package JavaIO.kr.or.ddit.basic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*	
	성능향상을 위한 보조 스트림 예제2
	(문자기반의 Buffered스트림 사용)
 */	
public class T12_BufferedIO {
	public static void main(String[] args) {
		
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader("src/JavaIO/kr/or/ddit/basic/T11_BufferedIO.java");
			
//			int c;
//			while ((c = fr.read()) != -1) {
//				System.out.print((char)c);
//			}
			
//			한줄씩 읽을 수 있도록 해주는 readline 메서드를 이용하기 위해
//			BufferedReader 사용함.
			br = new BufferedReader(fr);
			String temp = "";
			for (int i = 1; (temp = br.readLine()) != null; i++) {
				System.out.printf("%4d : %s\n", i, temp);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
//				fr.close();
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}

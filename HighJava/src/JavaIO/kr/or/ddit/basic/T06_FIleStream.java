package JavaIO.kr.or.ddit.basic;

import java.io.FileOutputStream;
import java.io.IOException;

/*
	File 쓰기(Output) 예제
*/
public class T06_FIleStream {
	public static void main(String[] args) {
		
		// 파일에 출력하기
		FileOutputStream fos = null;
		
		try {
			// 출력용 OutputStream 객체 생성
			fos = new FileOutputStream("d:/D_Other/out.txt");
			
			for (char ch = 'a'; ch < 'z'; ch++) {
				fos.write(ch);
			}
			
			System.out.println("파일에 쓰기 작업 완료...");
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}


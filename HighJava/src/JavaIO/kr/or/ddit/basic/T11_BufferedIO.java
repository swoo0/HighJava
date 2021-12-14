package JavaIO.kr.or.ddit.basic;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
	성능향상을 위한 보조 스트림 예제
	(바이트 기반의 Buffered 스트림)
*/
public class T11_BufferedIO {
	public static void main(String[] args) throws IOException {
		
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		
		try {
//							     	   경로, apend
//			fos = new FileOutputStream("  ", boolean);
//			fos = new FileOutputStream("D:/D_Other/buffer.txt");
			fos = new FileOutputStream("D:/D_Other/buffer.txt", true);
//															  , true 는 연속 실행시 해당 파일에 내용 추가.
//															  , false는 연속 실행시 해당 파일에 덮어쓰기.
//															  , default 는 false
			
			
			// 버퍼의 크기를 지정하지 않으면 기본적으로 버퍼의 크기가
			// 8192byte(8KB)로 설정된다.
			
			// 버퍼 크기가 5인 스트림 생성
			bos = new BufferedOutputStream(fos, 5);
			
			for (int i = '1'; i <= '9'; i++) {
				// 숫자 자체를 문자로 저장하기 위해 ' 사용함.
				bos.write(i);
				System.out.println("작업중... " + i);
			}
			
			bos.flush(); // 작업을 종료하기 전에 버퍼에 남아있는 데이터를 모두
						 // 출력시킨다. (close시 자동으로 호출됨)
			
			System.out.println("작업 끝 !");
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bos.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

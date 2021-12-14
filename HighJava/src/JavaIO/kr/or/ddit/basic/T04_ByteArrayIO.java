package JavaIO.kr.or.ddit.basic;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class T04_ByteArrayIO {
	public static void main(String[] args) throws IOException {
		
		byte[] inSrc = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		byte[] outSrc = null;
		
		byte[] temp = new byte[4]; // 자료를 익을 때 사용할 버퍼용 배열
		
		ByteArrayInputStream bais = new ByteArrayInputStream(inSrc);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		// available() => 읽어올 수 있는 byte 수를 반환함.
		while (bais.available() > 0) {
			// 4 byte 단위로 읽어 오기 때문에 읽어올 데이터가 4의 배수이면 괜찮겠지만 그외에는 문제가 생김. 
//			bais.read(temp); // temp배열 크기 만큼 자료를 읽어와 temp배열에 저장
//			baos.write(temp); // temp배열의 내용을 출력한다.
			
			// 버퍼로 읽어 들인 byte수를 반환한다.
			int len = bais.read(temp);
			
			// temp배열의 내용 중에서 0번째부터 len 개수만큼 출력한다.
			baos.write(temp, 0, len);
			
			System.out.println("temp : " + Arrays.toString(temp));
		}
		
		System.out.println();
		
		outSrc = baos.toByteArray();
		
		System.out.println("inSrc => " + Arrays.toString(inSrc));
		System.out.println("outSrc => " + Arrays.toString(outSrc));
		
		bais.close();
		baos.close();
	}
}

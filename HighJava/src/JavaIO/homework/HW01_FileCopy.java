package JavaIO.homework;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class HW01_FileCopy {
	public static void main(String[] args) throws IOException {

		FileInputStream fis = null;
		FileOutputStream fos = null;

		try {
			fis = new FileInputStream("D:/D_Other/Tulips.jpg");
			fos = new FileOutputStream("D:/D_Other/복사본_Tulips.jpg");

			int cnt;

			while ((cnt = fis.read()) != -1) {
				fos.write(cnt);
			}

			System.out.println("복사 완료 !");
			
		} catch (IOException e) {
			e.printStackTrace();
			
		} finally {
			
			try {
				fis.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}

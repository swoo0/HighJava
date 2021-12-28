package homework;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class test {

	public static void main(String[] args) {
		LocalDate now = LocalDate.now();
		String toDay = now.minusDays(2).format(DateTimeFormatter.ofPattern("yyyyMMdd"));
		String threeDaysAgo = now.minusDays(3).format(DateTimeFormatter.ofPattern("yyyyMMdd"));
		
		int hour = LocalTime.now().getHour();
		
		String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 E요일 a hh시 mm분 ss초"));
		System.out.println(dateTime);
	}
}

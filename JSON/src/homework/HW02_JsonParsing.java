package homework;

import java.io.InputStreamReader;
import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class HW02_JsonParsing {
	public void parse() {
		try {
			// 대전 모범식당 목록 조회
			String serviceKey = "Rf9G%2BcLLWZRQpIuZ6CabjWX%2FHOzJtOqHc2bbLi5LV48Acs7w%2Fjw2p4zvKwQXkWGsz0xM2HfHW2SGZUZnanmIhQ%3D%3D"; // 공공데이터포털에서 받은 일반 키 (Encoding)
			long pageNo = 1;
			long numOfRows = 10;
			String dgu = "C0605";  // 지역구분코드  C0605 => 중구
//			String searchCondition = "4";  // 업소명구분코드
			String searchKeyword = "";  // 검색키워드 음식 종류
			
			long totalCount = 0;

			URL url = new URL("http://apis.data.go.kr/6300000/tourFoodDataService/tourFoodDataListJson"
					+ "?serviceKey=" + serviceKey
					+ "&pageNo=" + pageNo
					+ "&numOfRows=" + numOfRows
					+ "&dgu=" + dgu
//					+ "&searchCondition=" + searchCondition
					+ "&searchKeyword=" + searchKeyword);
			
			System.out.println(url);
			
			// JSON 파서로 부터 입력 받은 파일을 파싱하도록 요청
			// + totalCount 가져오기
			JSONParser parser = new JSONParser();
			
			JSONObject jsonObject = (JSONObject) parser.parse(new InputStreamReader(url.openStream()));
			JSONObject comObject = (JSONObject) jsonObject.get("comMsgHeader");
			JSONObject headerObject = (JSONObject) jsonObject.get("msgHeader");
			totalCount = (long) headerObject.get("totalCount");
			numOfRows = totalCount;
			System.out.println("totalCount : " + totalCount);
			
			
			url = new URL("http://apis.data.go.kr/6300000/tourFoodDataService/tourFoodDataListJson"
					+ "?serviceKey=" + serviceKey
					+ "&pageNo=" + pageNo
					+ "&numOfRows=" + numOfRows
					+ "&dgu=" + dgu
//					+ "&searchCondition=" + searchCondition
					+ "&searchKeyword=" + searchKeyword);
			
			System.out.println(url);

			jsonObject = (JSONObject) parser.parse(new InputStreamReader(url.openStream()));
			comObject = (JSONObject) jsonObject.get("comMsgHeader");
			headerObject = (JSONObject) comObject.get("msgHeader");
			
			String returnCode = (String) comObject.get("returnCode");
			String successYN = (String) comObject.get("successYN");
			
			if (returnCode.equals("00") && successYN.equals("Y")) {  // 정상이면..
				
				JSONArray list = (JSONArray) jsonObject.get("msgBody");
				
				System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
				
				for (Object obj : list) {
					
					JSONObject jObj = (JSONObject) obj;
					
					String formatStr = String.format("%s %s idx=%s seq=%s 상호명=%s 코드=%s 지역코드=%s 대표메뉴=%s 전화번호=%s-%s-%s\n소개 = %s",
							jObj.get("dGuNm"), jObj.get("dCodeNm"), jObj.get("idx"), jObj.get("foodSeq"), jObj.get("name"), jObj.get("dCode"), 
							jObj.get("dGu"), jObj.get("topMenu"), jObj.get("telCode"), jObj.get("telKuk"), jObj.get("telNo"), jObj.get("contents1"));

					System.out.println(formatStr);
					System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new HW02_JsonParsing().parse();
	}
}
			
			
			
			
			
			
			
			

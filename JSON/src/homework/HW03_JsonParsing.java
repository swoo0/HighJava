package homework;

import java.io.InputStreamReader;
import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class HW03_JsonParsing {
	public void parse() {
		try {
			// 대전 모범식당 상세 조회
			String serviceKey = "Rf9G%2BcLLWZRQpIuZ6CabjWX%2FHOzJtOqHc2bbLi5LV48Acs7w%2Fjw2p4zvKwQXkWGsz0xM2HfHW2SGZUZnanmIhQ%3D%3D"; // 공공데이터포털에서 받은 일반 키 (Encoding)
			String foodSeq = "FH0000057";
			
			URL url = new URL("http://apis.data.go.kr/6300000/tourFoodDataService/tourFoodDataItemJson"
					+ "?serviceKey=" + serviceKey
					+ "&foodSeq=" + foodSeq);
			
			System.out.println(url);
			
			// JSON 파서로 부터 입력 받은 파일을 파싱하도록 요청
			// + totalCount 가져오기
			JSONParser parser = new JSONParser();
			
			JSONObject jsonObject = (JSONObject) parser.parse(new InputStreamReader(url.openStream(), "UTF-8"));
			JSONObject comObject = (JSONObject) jsonObject.get("comMsgHeader");
			
			String returnCode = (String) comObject.get("returnCode");
			String successYN = (String) comObject.get("successYN");
			
			if (returnCode.equals("00") && successYN.equals("Y")) {  // 정상이면..
				
				JSONObject BodyObj = (JSONObject) jsonObject.get("msgBody");
				
				JSONArray menuList = (JSONArray) BodyObj.get("foodMenuList");
				JSONArray etcList = (JSONArray) BodyObj.get("foodMenuEtcList");
					
				String formatStr = String.format(" 음식점코드 : %s%n 음식분류: %s%n 상호명 : %s%n 주소 : %s %s%n 전화번호 : %s - %s - %s%n 조회수 : %s회%n 요약정보 :%s%n "
						+ "영업시간 : %s ~ %s%n 동행자별 분류 : %s%n 좌석수 : %s%n 방수 : %s%n 좌식테이블수 : %s%n 입식테이블수 : %s%n 어린이놀이방 : %s%n 화장실개수 : %s%n "
						+ " 화장실구분 : %s%n 지역간대중교통 : %s%n 지역내대중교통1 : %s%n 지역내대중교통2 : %s%n 주변음식점 : %s%n Index : %s%n",
						BodyObj.get("foodSeq"), BodyObj.get("dCodeNm"), BodyObj.get("name"), BodyObj.get("addr1"), BodyObj.get("addr2"), BodyObj.get("telCode"), 
						BodyObj.get("telKuk"), BodyObj.get("telNo"), BodyObj.get("hitCnt"), BodyObj.get("contents1"), BodyObj.get("openTime"), BodyObj.get("closeTime"),
						BodyObj.get("together"), BodyObj.get("seatCnt"), BodyObj.get("room"), BodyObj.get("table1"), BodyObj.get("table2"), BodyObj.get("kidJoyroomFlag"),
						BodyObj.get("restRoom1"), BodyObj.get("restRoom2"), BodyObj.get("ownerDriver"), BodyObj.get("publicTraffic1"), BodyObj.get("publicTraffic2"),
						BodyObj.get("mapFood"), BodyObj.get("idx"));
						
				System.out.println(formatStr);
				
				for (Object mObj : menuList) {
					JSONObject mList = (JSONObject) mObj;
					
					String formatStr2 = String.format("메뉴명 : %s%n 메뉴소개 : %s%n 가격 : %s%n 이미지1 : %s%n 이미지2 : %s%n 이미지3 : %s%n 이미지4 : %s%n "
							+ "이미지명1 : %s%n 이미지명2 : %s%n 이미지명3 : %s%n 이미지명4 : %s%n",
							mList.get("title"), mList.get("intro"), mList.get("price"), mList.get("path1"), mList.get("path2"), mList.get("path3"),
							mList.get("path4"), mList.get("tFilename1"), mList.get("tFilename2"), mList.get("tFilename3"), mList.get("tFilename4"));

					System.out.println(formatStr2);
				}
				
				for (Object eObj : etcList) {
					JSONObject eList = (JSONObject) eObj;
					
					String formatStr3 = String.format("메뉴명 : %s%n 가격 : %s%n 메뉴소개 : %s%n",
							eList.get("title"),eList.get("price"), eList.get("basis"));
					System.out.println(formatStr3);
				}
					
				System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
					
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new HW03_JsonParsing().parse();
	}
}

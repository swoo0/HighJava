package homework;

import java.io.InputStreamReader;
import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonParsing {
	public void parse() {
		try {
			
			String ServiceKey = "Rf9G%2BcLLWZRQpIuZ6CabjWX%2FHOzJtOqHc2bbLi5LV48Acs7w%2Fjw2p4zvKwQXkWGsz0xM2HfHW2SGZUZnanmIhQ%3D%3D&"; // 공공데이터포털에서 받은 일반 키 (Encoding)
			String pageNo = "10";  // 페이지 번호 Default : 10
			String numOfRows = "1";  // 한 페이지 결과 수 Default : 1
			String dateType = "JSON";  // 자료요청형식 (XML/JSON) Default : XML
			String dataCd = "ASOS";  // 자료 분류 코드(ASOS)
			String dateCd = "HR";  // 날짜 분류 코드(HR)
			String startDt = "20191111";  // 조회 기간 시작일(YYYYMMDD)
			String startHh = "01";  // 조회 기간 시작시(HH)
			String endDt = "20191112";  // 조회 기란 종료일(YYYYMMDD) (전일(D-1) 까지 제공)
			String endHh = "01";  // 조회 기간 종료시(HH)
			String stnIds = "108";  // 종관기상관측 지점 번호(108 == 서울)

			URL url = new URL("http://apis.data.go.kr/1360000/AsosHourlyInfoService/getWthrDataList" 
					+ "?ServiceKey=" + ServiceKey
					+ "&pageNo=" + pageNo
					+ "&numOfRows=" + numOfRows
					+ "&dateType=" + dateType
					+ "&dataCd=" + dataCd
					+ "&dateCd=" + dateCd
					+ "&startDt=" + startDt
					+ "&startHh=" + startHh
					+ "&endDt=" + endDt
					+ "&endHh=" + endHh
					+ "&stnIds=" + stnIds);
			
			System.out.println(url);
			
//			// DOM 파서로 부터 입력 받은 파일을 파싱하도록 요청
//			Document xmlDoc = builder.parse(url.toString());
			
			// JSON 파서로 부터 입력 받은 파일을 파싱하도록 요청
			JSONParser parser = new JSONParser();
			JSONObject jsonObject = (JSONObject) parser.parse(new InputStreamReader(url.openStream(),("utf-8")));
			
			JSONObject svcObject = (JSONObject) jsonObject.get(ServiceKey);
			

			
//			long totalCount = (long) svcObject.get("totalCount");
//			endHh = totalCount + "";
			
			/**
			 *  원하는 자료 지정하여 출력하기.
			 */
//			pageNo = "1";     // 총 페이지 수
//			numOfRows = "5";  // 페이지당 들어갈 시간단위 내용 갯수
//			startDt = "20201111";  // ~일
//			startHh = "01";		// ~시 부터
//			endDt = "20201112";  // ~일
//			endHh = "01";      // ~ 시 까지
//			stnIds = "133";	 //	대전 (대전지방기상청)
			
			
			
			
			url = new URL("http://apis.data.go.kr/1360000/AsosHourlyInfoService/getWthrDataList" 
					+ "?ServiceKey=" + ServiceKey
					+ "&pageNo=" + pageNo
					+ "&numOfRows=" + numOfRows
					+ "&dateType=" + dateType
					+ "&dataCd=" + dataCd
					+ "&dateCd=" + dateCd
					+ "&startDt=" + startDt
					+ "&startHh=" + startHh
					+ "&endDt=" + endDt
					+ "&endHh=" + endHh
					+ "&stnIds=" + stnIds); 
			
			System.out.println(url);

			
			jsonObject = (JSONObject) parser.parse(new InputStreamReader(url.openStream(), ("utf-8")));
			
			svcObject = (JSONObject) jsonObject.get(ServiceKey);
			
			JSONObject responseObject = (JSONObject) svcObject.get("response");
			
			JSONObject bodyObject = (JSONObject) responseObject.get("body");
			
			JSONObject itemsObject = (JSONObject) bodyObject.get("items");

			JSONObject header = (JSONObject) svcObject.get("header");
			
			String resultCode = (String) header.get("resultCode");
			
			JSONArray list = (JSONArray) itemsObject.get("item");

			if (resultCode.equals("00")) {  // 정상이면..
				
				for (Object obj : list) {
					
					JSONObject jObj = (JSONObject) obj;
					
					String formatStr = String.format(
							" 시간 = %s%n 목록 순서 = %s%n 지점 번호 = %s%n 지점명 = %s%n 기온 = %s%n 기온 품질검사 플래그 = %s%n 강수량 = %s%n 강수량 품질검사 플래그 = %s%n "
							+ "풍속 = %s%n 풍속 품질검사 플래그 = %s%n 풍향 = %s%n 풍향 품질검사 플래그 = %s%n 습도 = %s%n 습도 품질검사 플래그 = %s%n 증기압 = %s%n 이슬점온도 = %s%n "
							+ "현지기압 = %s%n 현지기 품질검사 플래그 = %s%n 해면기압 = %s%n 해면기압 품질검사 플래그 = %s%n 일조 = %s%n 일조 품질검사 플래그 = %s%n 일사 = %s%n 적설 = %s%n "
							+ "3시간 신적설 = %s%n 전운량 = %s%n 중하층운량 = %s%n 운형 = %s%n 최저운고 = %s%n 시정 = %s%n 지면상태 = %s%n "
							+ "현상번호 = %s%n 지면온도 = %s%n 지면온도 품질검사 플래그 = %s%n 5cm 지중온도 = %s%n 10cm 지중온도 = %s%n 20cm 지중온도 = %s%n 30cm 지중온도 = %s%n", 
							jObj.get("tm"), jObj.get("rnum"), jObj.get("stnId"), jObj.get("stnNm"), jObj.get("ta"), jObj.get("taQcflg"), jObj.get("rn"), jObj.get("rnQcflg"), jObj.get("ws"), jObj.get("wsQcflg"),
							jObj.get("wd"), jObj.get("wdQcflg"), jObj.get("hm"), jObj.get("hmQcflg"), jObj.get("pv"), jObj.get("td"), jObj.get("pa"), jObj.get("paQcflg"), jObj.get("ps"), jObj.get("psQcflg"),
							jObj.get("ss"), jObj.get("ssQcflg"), jObj.get("icsr"), jObj.get("dsnw"), jObj.get("hr3Fhsc"), jObj.get("dc10Tca"), jObj.get("dc10LmcsCa"), jObj.get("clfmAbbrCd"), jObj.get("lcsCh"), jObj.get("vs"),
							jObj.get("gndSttCd"), jObj.get("dmstMtphNo"), jObj.get("ts"), jObj.get("tsQcflg"), jObj.get("m005Te"), jObj.get("m01Te"), jObj.get("m02Te"), jObj.get("m03Te"));
							
					System.out.println(formatStr);
					System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
					
				} 

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new JsonParsing().parse();
	}
}

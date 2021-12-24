package homework;

import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/*
	XML DOM을 이용한 XML문서 파싱 과제(날씨 정보 조회 API)
*/
public class XmlParsing {
	public void parse() {
		try {
			// DOM Document 객체 생성하기
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = dbf.newDocumentBuilder();
			
			String ServiceKey = "Rf9G%2BcLLWZRQpIuZ6CabjWX%2FHOzJtOqHc2bbLi5LV48Acs7w%2Fjw2p4zvKwQXkWGsz0xM2HfHW2SGZUZnanmIhQ%3D%3D&"; // 공공데이터포털에서 받은 일반 키 (Encoding)
			String pageNo = "10";  // 페이지 번호 Default : 10
			String numOfRows = "1";  // 한 페이지 결과 수 Default : 1
			String dateType = "XML";  // 자료요청형식 (XML/JSON) Default : XML
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
			
			// DOM 파서로 부터 입력 받은 파일을 파싱하도록 요청
			Document xmlDoc = builder.parse(url.toString());
			
			// 루트 엘리먼트 객체 가져오기
			Element root = xmlDoc.getDocumentElement();
			System.out.println("루트 엘리먼트 태그명 : " + root.getTagName());
			
			
			
			/**
			 *  원하는 자료 지정하여 출력하기.
			 */
			pageNo = "1";     // 총 페이지 수
			numOfRows = "5";  // 페이지당 들어갈 시간단위 내용 갯수
			startDt = "20201111";  // ~일
			startHh = "01";		// ~시 부터
			endDt = "20201112";  // ~일
			endHh = "01";      // ~ 시 까지
			stnIds = "133";	 //	대전 (대전지방기상청)
						
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
			
			xmlDoc = builder.parse(url.toString());
			
			root = xmlDoc.getDocumentElement();
			
			// 하위 엘리먼트 접근하기
			NodeList itemNodeList = root.getElementsByTagName("item");
			
			String resultCode = root.getElementsByTagName("resultCode").item(0).getTextContent();
			
			if (resultCode.equals("00")) {  // 정상이면..
				
				for (int i=0; i<itemNodeList.getLength(); i++) {
					Element itemEl = (Element) itemNodeList.item(i);
					
					String tm = itemEl.getElementsByTagName("tm").item(0).getTextContent();
					String rnum = itemEl.getElementsByTagName("rnum").item(0).getTextContent();
					String stnId = itemEl.getElementsByTagName("stnId").item(0).getTextContent();
					String stnNm = itemEl.getElementsByTagName("stnNm").item(0).getTextContent();
					String ta = itemEl.getElementsByTagName("ta").item(0).getTextContent();
					String taQcflg = itemEl.getElementsByTagName("taQcflg").item(0).getTextContent();
					String rn = itemEl.getElementsByTagName("rn").item(0).getTextContent();
					String rnQcflg = itemEl.getElementsByTagName("rnQcflg").item(0).getTextContent();
					String ws = itemEl.getElementsByTagName("ws").item(0).getTextContent();
					String wsQcflg = itemEl.getElementsByTagName("wsQcflg").item(0).getTextContent();
					String wd = itemEl.getElementsByTagName("wd").item(0).getTextContent();
					String wdQcflg = itemEl.getElementsByTagName("wdQcflg").item(0).getTextContent();
					String hm = itemEl.getElementsByTagName("hm").item(0).getTextContent();
					String hmQcflg = itemEl.getElementsByTagName("hmQcflg").item(0).getTextContent();
					String pv = itemEl.getElementsByTagName("pv").item(0).getTextContent();
					String td = itemEl.getElementsByTagName("td").item(0).getTextContent();
					String pa = itemEl.getElementsByTagName("pa").item(0).getTextContent();
					String paQcflg = itemEl.getElementsByTagName("paQcflg").item(0).getTextContent();
					String ps = itemEl.getElementsByTagName("ps").item(0).getTextContent();
					String psQcflg = itemEl.getElementsByTagName("psQcflg").item(0).getTextContent();
					String ss = itemEl.getElementsByTagName("ss").item(0).getTextContent();
					String ssQcflg = itemEl.getElementsByTagName("ssQcflg").item(0).getTextContent();
					String icsr = itemEl.getElementsByTagName("icsr").item(0).getTextContent();
					String dsnw = itemEl.getElementsByTagName("dsnw").item(0).getTextContent();
					String hr3Fhsc = itemEl.getElementsByTagName("hr3Fhsc").item(0).getTextContent();
					String dc10Tca = itemEl.getElementsByTagName("dc10Tca").item(0).getTextContent();
					String dc10LmcsCa = itemEl.getElementsByTagName("dc10LmcsCa").item(0).getTextContent();
					String clfmAbbrCd = itemEl.getElementsByTagName("clfmAbbrCd").item(0).getTextContent();
					String lcsCh = itemEl.getElementsByTagName("lcsCh").item(0).getTextContent();
					String vs = itemEl.getElementsByTagName("vs").item(0).getTextContent();
					String gndSttCd = itemEl.getElementsByTagName("gndSttCd").item(0).getTextContent();
					String dmstMtphNo = itemEl.getElementsByTagName("dmstMtphNo").item(0).getTextContent();
					String ts = itemEl.getElementsByTagName("ts").item(0).getTextContent();
					String tsQcflg = itemEl.getElementsByTagName("tsQcflg").item(0).getTextContent();
					String m005Te = itemEl.getElementsByTagName("m005Te").item(0).getTextContent();
					String m01Te = itemEl.getElementsByTagName("m01Te").item(0).getTextContent();
					String m02Te = itemEl.getElementsByTagName("m02Te").item(0).getTextContent();
					String m03Te = itemEl.getElementsByTagName("m03Te").item(0).getTextContent();
					
					// 38개
					String formatStr = String.format(
//							"%15s %4s %4s %8s %6s %6s %6s %6s %6s %6s %6s %6s %6s %6s %6s %6s %6s %6s %6s %6s %6s %6s %6s %6s %6s %6s %6s %6s %6s %6s %6s %6s %6s %6s %6s %6s %6s %6s", 
							" 시간 = %s%n 목록 순서 = %s%n 지점 번호 = %s%n 지점명 = %s%n 기온 = %s%n 기온 품질검사 플래그 = %s%n 강수량 = %s%n 강수량 품질검사 플래그 = %s%n "
							+ "풍속 = %s%n 풍속 품질검사 플래그 = %s%n 풍향 = %s%n 풍향 품질검사 플래그 = %s%n 습도 = %s%n 습도 품질검사 플래그 = %s%n 증기압 = %s%n 이슬점온도 = %s%n "
							+ "현지기압 = %s%n 현지기 품질검사 플래그 = %s%n 해면기압 = %s%n 해면기압 품질검사 플래그 = %s%n 일조 = %s%n 일조 품질검사 플래그 = %s%n 일사 = %s%n 적설 = %s%n "
							+ "3시간 신적설 = %s%n 전운량 = %s%n 중하층운량 = %s%n 운형 = %s%n 최저운고 = %s%n 시정 = %s%n 지면상태 = %s%n "
							+ "현상번호 = %s%n 지면온도 = %s%n 지면온도 품질검사 플래그 = %s%n 5cm 지중온도 = %s%n 10cm 지중온도 = %s%n 20cm 지중온도 = %s%n 30cm 지중온도 = %s%n", 
							tm,rnum,stnId,stnNm,ta,taQcflg,rn,rnQcflg,ws,wsQcflg,
							wd,wdQcflg,hm,hmQcflg,pv,td,pa,paQcflg,ps,psQcflg,
							ss,ssQcflg,icsr,dsnw,hr3Fhsc,dc10Tca,dc10LmcsCa,clfmAbbrCd,lcsCh,vs,
							gndSttCd,dmstMtphNo,ts,tsQcflg,m005Te,m01Te,m02Te,m03Te);
					
					System.out.println(formatStr);
					System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new XmlParsing().parse();
	}
}

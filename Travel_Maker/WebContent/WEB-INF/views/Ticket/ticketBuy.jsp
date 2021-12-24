<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String buyName = (String)request.getAttribute("buyName");
	int totalPrice1 = (Integer)request.getAttribute("totalPrice1");
	String memEmail = (String)request.getAttribute("memEmail");
	String memName = (String)request.getAttribute("memName");
	String memTel = (String)request.getAttribute("memTel");
	String memAddr = (String)request.getAttribute("memAddr");
	String memZip = (String)request.getAttribute("memZip");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script>
		IMP.init('imp31931496');
	
		IMP.request_pay({
		    pg : 'inicis', // version 1.1.0부터 지원.
		    pay_method : 'card',
		    merchant_uid : 'merchant_' + new Date().getTime(),
		    name : '<%=buyName%>',
		    amount : <%=totalPrice1%>, //판매 가격
		    buyer_email : '<%=memEmail%>',
		    buyer_name : '<%=memName%>',
		    buyer_tel : '<%=memTel%>',
		    buyer_addr : '<%=memAddr%>',
		    buyer_postcode : '<%=memZip%>'
		}, function(rsp) {
		    if ( rsp.success ) {
		        var msg = '결제가 완료되었습니다.';
		        msg += '고유ID : ' + rsp.imp_uid;
		        msg += '상점 거래ID : ' + rsp.merchant_uid;
		        msg += '결제 금액 : ' + rsp.paid_amount;
		        msg += '카드 승인번호 : ' + rsp.apply_num;
		    } else {
		        var msg = '결제에 실패하였습니다.';
		        msg += '에러내용 : ' + rsp.error_msg;
		    }
		    alert(msg);
		});

</script>
<title>결제창</title>
</head>
<body>


</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%-- 숫자만 입력받도록 검증.
	 exam3.jsp 에서 결과를 출력하기.	
 --%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>간단한 계산기</title>
<script type="text/javascript">
	function cal(o,op){
		if(isNaN(o.num1.value || o.num2.value)){
			alert("숫자만 입력하세요");
			o.num1.focus();
			o.num.value="";
			return false;
		}
		o.op.value = op;
		o.submit();
	}

</script>
</head>
<body>
<form action="exam3.jsp" method="post">
<input type="hidden" name="op" value="0">
숫자1:<input type="text" name="num1"><br>
숫자2:<input type="text" name="num2"><br>
<input type="button" value="+" onclick="cal(this.form,this.value)">
<input type="button" value="-" onclick="cal(this.form,this.value)" >
<input type="button" value="*" onclick="cal(this.form,this.value)">
<input type="button" value="/" onclick="cal(this.form,this.value)">
</form>
</body>
</html>
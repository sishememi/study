<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%-- ���ڸ� �Է¹޵��� ����.
	 exam3.jsp ���� ����� ����ϱ�.	
 --%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>������ ����</title>
<script type="text/javascript">
	function cal(o,op){
		if(isNaN(o.num1.value || o.num2.value)){
			alert("���ڸ� �Է��ϼ���");
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
����1:<input type="text" name="num1"><br>
����2:<input type="text" name="num2"><br>
<input type="button" value="+" onclick="cal(this.form,this.value)">
<input type="button" value="-" onclick="cal(this.form,this.value)" >
<input type="button" value="*" onclick="cal(this.form,this.value)">
<input type="button" value="/" onclick="cal(this.form,this.value)">
</form>
</body>
</html>
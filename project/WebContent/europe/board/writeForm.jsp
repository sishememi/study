<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>게시판 글쓰기</title>
<link rel="stylesheet" href="../../css/write.css">
<script type="text/javascript">
function inputcheck(){
	
	f = document.f;
	if(f.type.value==""){
		alert("게시판을 선택하세요");
		f.type.focus();
		return;
	}
	if(f.n.value==""){
		alert("국가를 선택하세요");
		f.n.focus();
		return;
	}
	if(f.subject.value==""){
		alert("제목을 입력하세요");
		f.subject.focus();
		return;
	}
	if(f.content.value==""){
		alert("내용을 입력하세요");
		f.content.focus();
		return;
	}
	f.submit();
}
</script>
</head>
<body>
<form action="write.do" method="post" enctype="multipart/form-data" name="f">
	<table border="1">
 	<tr><th>게시판 구분</th><td colspan="3">
			<select name="type" id="nation">
			<c:set var="arr" value='<%=new String[]{"Tour Info","Restaurant Info","Etc Info","Photo Spot"}%>' />
			<c:forEach var="b" items="${arr}" varStatus="stat">
				<option value="" selected disabled hidden >Tour Info</option>
		   		<option>${b}</option>
		    </c:forEach></select></td></tr>
	<tr><th>국가 선택</th>
	 <td>
      	 <select name="n" id="nation">
			<c:set var="arr" value='<%=new String[]{"영국","프랑스","스위스","오스트리아","스페인","이탈리아","동유럽","그 외국가"} %>' />
			<c:forEach var="d" items="${arr}">
				<option value="" selected disabled hidden >국가</option>
		   		<option>${d}</option>
		    </c:forEach></select>
    </td> 
	<th>작성자</th><td><input type="text" name="name" value="${login}"></td></tr>
	<tr><th>제목</th><td colspan="3"><input type="text" name="subject" style="width:100%"></td></tr>
	<tr><th>내용</th><td colspan="3"><textarea rows="10" name="content" id="content1" style="width:100%"></textarea></td></tr>
	<tr><th>첨부파일</th><td colspan="3"><input type="file" name="file1"></td></tr>
	<tr><td colspan="4" >&nbsp;</td></tr>
	<tr><td colspan="2"><a href="tourForm.do">취소</a></td><td colspan="2"><a href="javascript:inputcheck()"> 등록</a></td></tr>
</table>
</form>
</body>
</html>
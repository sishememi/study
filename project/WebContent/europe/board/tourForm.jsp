<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Tour Info :)</title>
<link rel="stylesheet" href="../../css/list.css">
<script type="text/javascript">
	function listdo(page){
		document.sh.pageNum.value=page;
		document.sh.submit();
	}   
</script>
</head>
<body>
<table id="board">
   <c:if test="${boardcnt == 0}">
      <tr>
         <td colspan="5">��ϵ� �Խñ��� �����ϴ�.</td>
      </tr>
   </c:if>
      <c:if test="${boardcnt > 0}">
      <tr> 
      	 <td>���� ����</td>
      	 <td>
      	 <select name="n" id="nation">
			<c:set var="arr" value='<%=new String[]{"����","������","������","����Ʈ����","������","��Ż����","������","�� �ܱ���"} %>' />
			<c:forEach var="d" items="${arr}">
				<option value="" selected disabled hidden >����</option>
		   		<option>${d}</option>
		    </c:forEach></select>
      	 </td>
      </tr>
      <tr>
         <th width="8%">��ȣ</th>
         <th width="50%">����</th>
         <th width="14%">�ۼ���</th>
         <th width="17%">�ۼ���</th>
         <th width="11%">��ȸ</th>
      </tr>
  	 <c:forEach var="b" items="${list}">
         <c:set var="boardnum" value="${boardnum -1 }" />
 
      <!-- ÷������ǥ�� 
      <c:if test="${!empty b.file1}">
            <a href="file/${b.file1}" style="text-decoration: none;">@</a>
      </c:if>
      <c:if test="${empty b.file1}">&nbsp;&nbsp;&nbsp;</c:if>-->
  
        <tr><td><a href="info.do?bnum=${b.bnum}">${b.subject}</a>
         </td><td>${b.id}</td>
         <td>
         <c:set var="today" value="<%=new java.util.Date() %>" />
         <fmt:formatDate value="${today}" pattern="yyyyMMdd" var="today"/>
          <fmt:formatDate value="${b.regdate}" pattern="yyyyMMdd" var="wrday"/>
          <c:choose>
         	<c:when test="${today-wrday < 1}">
         		<fmt:formatDate value="${b.regdate}" pattern="yyyy-MM-dd HH:mm:ss"/>
         	</c:when>
         	<c:otherwise>
         		<fmt:formatDate value="${b.regdate}" pattern="yy-MM-dd HH:mm"/>
         	</c:otherwise>
  		  </c:choose>
          </td>
         <td>${b.readcnt}</td></tr>
     </c:forEach>
      <tr><td colspan="5">
      <c:if test="${pageNum <= 1}">[����]</c:if>
      <c:if test="${pageNum > 1 }">
      <a href="javascript:listdo(${pageNum - 1})">[����]</a> 
	  </c:if>
    <c:forEach var = "a" begin="${startpage}" end="${endpage}" >
    	<c:if test="${a==pageNum}">[${a}]</c:if>
    	<c:if test="${a!=pageNum}">
    	<a href="javascript:listdo(${a})">[${a}]</a> 
    	</c:if>
   	</c:forEach>
<c:if test="${pageNum >= maxpage}">[����]</c:if>
<c:if test="${pageNum < maxpage}">
	<a href="javascript:listdo(${pageNum + 1})">[����]</a> 
</c:if>
</td></tr>
</c:if>
      <tr>
         <td colspan="5" style="text-align: right"><a href="writeForm.do">[�۾���]</a></td>
      </tr>
</table>
<form action ="list.do" method="post" name="sh">
<input type="hidden" name="pageNum" value="1">
<table id="search"><tr><td style="border-width:0px;">
<select name="column">
	<option value="">�����ϼ���</option>
	<option value="subject">����</option>
	<option value="name">�ۼ���</option>
	<option value="content">����</option>
	<option value="subject,name">����,�ۼ���</option>
	<option value="subject,content">����,����</option>
	<option value="name,content">�ۼ���,����</option></select>
<script>document.sh.column.value="${param.column}";</script>
<input type="text" name="find" value="${param.find}" style="width:50%">
<input type="submit" value="�˻�"></td>
</tr> 
</table>
</form>
</body>
</html>
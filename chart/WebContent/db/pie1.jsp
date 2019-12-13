<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR" >
<title>Pie graph</title>
<script type="text/javascript" src="https://www.chartjs.org/dist/2.9.3/Chart.min.js"> </script> 
</head>
<sql:setDataSource var="conn" driver="org.mariadb.jdbc.Driver" url="jdbc:mariadb://localhost:3306/classdb"
user="scott" password="1234"/>
<sql:query var="rs" dataSource="${conn}"> 
	select name,count(*) cnt from board
	group by name having count(*) > 1 order by cnt
</sql:query>
<body>
		<div id="container" style="width: 75%">
		<canvas id="canvas"></canvas>
	</div>
<script type="text/javascript">
	var randomColorFactor = function(){
		return Math.round(Math.random()* 255); //0~255����
	}
	
	var randomColor = function(opacity){
		return "rgba(" + randomColorFactor() + "," + randomColorFactor() + "," + randomColorFactor() + ","
				+ (opacity || '.3') + ")";
	};
	var config = {
		type:'pie',
		data :  {
			datasets : [{
				data: [<c:forEach items="${rs.rows}" var="m"> "${m.cnt}",</c:forEach>], //ȭ�鿡 ����ؾ��Ϥ��� ������*/
				backgroundColor:[<c:forEach items="${rs.rows}" var="m"> randomColor(1),</c:forEach>],}],/*randomColor(1) ����, ������ ����*/
				labels:[<c:forEach items="${rs.rows}" var="m"> "${m.cnt}",</c:forEach>] /* label �÷� , db������ �̸�?*/
			},
			options:{reponsive:true}
		};
	window.onload=function(){
		var ctx = document.getElementById("canvas").getContext("2d");
		new Chart(ctx,config);
	}
</script>	
</body>
</html>
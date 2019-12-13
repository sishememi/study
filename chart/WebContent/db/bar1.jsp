<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR" >
<title>막대 / 선 그래프로 게시글 작성자의 건수 출력하기</title>
<script type="text/javascript" src="https://www.chartjs.org/dist/2.9.3/Chart.min.js"> </script>
<style>
	canvas { /* 그림이 그려지는 부분 */
		-moz-user-select: none;
		-webkit-user-select: none;
		-ms-user-select: none;
	}
</style>
<sql:setDataSource var="conn" driver="org.mariadb.jdbc.Driver" url="jdbc:mariadb://localhost:3306/classdb"
user="scott" password="1234"/>
<sql:query var="rs" dataSource="${conn}"> <%-- 데이터를 가져옴 --%>  
	select name,count(*) cnt from board 
	group by name 
	having count(*) > 1 order by cnt desc
</sql:query>
</head>
<body>
	<div style="width: 75%">
		<canvas id="canvas"></canvas>
	</div>
<script type="text/javascript">
	var randomColorFactor = function(){
		return Math.round(Math.random()* 255); //0~255색상
	}
	
	var randomColor = function(opacity){
		return "rgba(" + randomColorFactor() + "," + randomColorFactor() + "," + randomColorFactor() + ","
				+ (opacity || '.3') + ")";
	};
	var chartData = {
			labels: [<c:forEach items="${rs.rows}" var="m"> "${m.cnt}",</c:forEach>],  /* x축  ,m.cnt = 글쓴이 이름..?*/
			datasets : [{  //두개의 그래프를 그림 1.라인,2.바
					type:'line',
					borderWidth:2,
					borderColor:[<c:forEach items="${rs.rows}" var="m"> randomColor(1),</c:forEach>], //갯수만큼 색상이 필요해서 문 
					label:'건수',
					fill:false, //선으로 만들기위해서 밑으로 칠해지는 색상 제거
					data:[<c:forEach items="${rs.rows}" var="m"> "${m.cnt}",</c:forEach>],
			},{
				type:'bar',
				label:'건수',
				backgroundColor:[<c:forEach items="${rs.rows}" var="m"> randomColor(1),</c:forEach>], 
				data:[<c:forEach items="${rs.rows}" var="m"> "${m.cnt}",</c:forEach>], 
				borderWidth:2
			}]
};

	window.onload=function(){
		var ctx = document.getElementById("canvas").getContext("2d");
		new Chart(ctx,{
			type:'bar',
			data: chartData,
			options:{     
				responsive:true,
				title: {
					display:true, text:'게시판 등록 건수'
					},
				legend:{
					display : false
					},     
				scales: { //x,y축
					xAxes:[{
						display:true,
						scaleLabel:{
							display:true,   
							labelString:"게시물 작성자"
						},
						stacked:true
					}],
					yAxes:[{
						display: true,
						scaleLabel:{
							display:true,
							labelString:"게시물 작성 건수"
						},
						stacked:true
					}]
				}
			}
		})
	};
</script>	
</body>
</html>
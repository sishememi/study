<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%-- /WebContent/decorator/decorator3.jsp --%>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath }" />

<!DOCTYPE html>
<html lang="en">
<title><decorator:title/></title>
<meta charset="EUC-KR">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-black.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<style>
html,body,h1,h2,h3,h4,h5,h6 {font-family: "Roboto", sans-serif;}
.w3-sidebar {
  z-index: 3;
  width: 250px;
  top: 30px;
  bottom: 0;
  height: inherit;
}
</style>
   <decorator:head/>
   
<script type="text/javascript"
src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
   var randomColorFactor = function() {
      return Math.round(Math.random() * 255);
   }
   var randomColor = function(opacity) {
      return "rgba(" + randomColorFactor() + ","
            + randomColorFactor() + ","
            + randomColorFactor() + ","
            + (opacity || '.3') + ")";
   }
  $(function() {
      exchangeRate(); // �����ε尡 �Ϸ�� ���
     // setInerval(exchangeRate, 1000*60)
    })
    function exchangeRate() {
       $.ajax("${path}/model2/ajax/exchange2.do",   {
           success : function(data) {  // �ݹ� �Լ�
              console.log(data)
               $("#exchange").html(data);
            },
            error : function(e) {
               alert("���� ���� :" + e.status);
            }
         })
   }; 

   $(document).ready(function() { //���� �ε尡 �Ϸ�� ���
      exchangeRate();  //ȯ������ ũ�Ѹ����� �ε�
//      setInterval(exchangeRate, 1000*60)
      graphs();  //�׷����� ���� �����͸� ajax���� ��������
   })
   function graphs() {
      $.ajax("${path}/model2/ajax/graph.do",{
         success: function(data) {
            console.log(data);
            pieGraphprint(data);
            barGraphprint(data);
         },
         error: function(e) {
            alert("���� ����:" + e.status);
         }
      })
   }
   function pieGraphprint(data) {
      //data : �������� ������ JSON ���� ������
      //[{"name":"ȫ�浿","cnt":10},{"name":"���","cnt":9}]
      var rows = JSON.parse(data);
         var names = [];  //�� ������
         var datas = [];  //�Ǽ� ������
         var colors = []; //����
         //json ������ �м��Ͽ� �ʿ��� �����ͷ� ����
         $.each(rows, function(index,item) {
            names[index] = item.name;
            datas[index] = item.cnt;
            colors[index] = randomColor(1);
         })
         var config = {
            type: 'pie',
            data: {
               datasets: [{
                  data: datas,
                  backgroundColor: colors,
               }],
               labels: names
            },
            options: {
               responsive: true,
               legend: {
                  position: 'top'
               },
               title: {
                  display: true,
                  text: '�۾��̺� �Խ��� ��� �Ǽ�'
               }
            }
         };
         var ctx = document.getElementById("canvas2").getContext("2d");
      new Chart(ctx, config);
   }
   function barGraphprint(data) {
      var rows = JSON.parse(data);
         var names = [];
         var datas = [];
         var colors = [];
         $.each(rows, function(index,item) {
            names[index] = item.name;
            datas[index] = item.cnt;
            colors[index] = randomColor(1);
         })
         var chartData = {
            labels: names,
            datasets: [
               {
                  type: 'line',
                  borderWidth: 2,
                  borderColor: colors,
                  label: '�Ǽ�',
                  fill: false,
                  data: datas,
               }, {
                  type: 'bar',
                  label: '�Ǽ�',
                  backgroundColor: colors,
                  data: datas,
                  borderWidth: 2
               }
            ]
         }
         var ctx = document.getElementById('canvas1').getContext('2d');
         new Chart(ctx, {
            type: 'bar',
            data: chartData,
            options: {
               responsive: true,
               title: {
                  display: true,
                  text: '�۾��̺� �Խ��� ��� �Ǽ�'
               },
               legend: {
                  display: false
               },
               scales: {
                  xAxes: [{
                     display: true,
                     scaleLabel: {
                        display: true,
                        labelString: "�Խù� �ۼ���"
                     },
                     stacked: true
                  }],
                  yAxes: [{
                     display: true,
                     scaleLabel: {
                        display: true,
                        labelString: "�Խù� �ۼ� �Ǽ�"
                     },
                     stacked: true
                  }]
               }
            }
         });
   }
</script>
<script type="text/javascript" src="https://www.chartjs.org/dist/2.9.3/Chart.min.js"> </script>
<!-- <script src="https://www.chartjs.org/samples/latest/utils.js"></script> -->
<body>
<!-- Navbar -->
<div class="w3-top">
  <div class="w3-bar w3-theme w3-top w3-right-align w3-large">
   <c:choose>
      <c:when test="${!empty sessionScope.login}">
         ${sessionScope.login}���� �α����ϼ̽��ϴ� &nbsp;&nbsp;
         <a href="logout.me"> �α׾ƿ�</a>
      </c:when>
      <c:otherwise>
         <a href="loginForm.me"> �α���</a>
         <a href="joinForm.me"> ȸ������</a>
      </c:otherwise>
   </c:choose>
  </div>
</div>

<!-- Sidebar -->
<nav class="w3-sidebar w3-bar-block w3-collapse w3-large w3-theme-l5 w3-animate-left" id="mySidebar">
  <a href="javascript:void(0)" onclick="w3_close()" class="w3-right w3-xlarge w3-padding-large w3-hover-black w3-hide-large" title="Close Menu">
    <i class="fa fa-remove"></i>
  </a>
  <h4 class="w3-bar-item"><b>Menu</b></h4>
  <a class="w3-bar-item w3-button w3-hover-black" href="${path}/model2/member/main.me">ȸ������</a>
  <a class="w3-bar-item w3-button w3-hover-black" href="${path}/model2/board/list.do">�Խ���</a>
  <div class="w3-container">
       <div class="w3-clear"></div>
       <%-- ajax�� ���� ���� ȯ�� ���� ���� ��� --%>
       <div id="exchange"></div>
  </div>   
</nav>
<div class="w3-overlay w3-hide-large" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>
<div class="w3-main" style="margin-left:250px">


  <div class="w3-row w3-padding-64">
    <div class="w3-twothird w3-container">
    <div class="w3-half">
          <div class="w3-container w3-padding-16">
             <div class="w3-left"><i class="fa fa-comment w3-xxxLarge"></i>
                <div id="container" style="width: 75%;">
                <canvas id="canvas1"></canvas>
                </div>
             </div>
          </div>
       </div>
    <div class="w3-half">
          <div class="w3-container w3-padding-16">
             <div class="w3-left"><i class="fa fa-eye w3-xxxLarge"></i>
                <div id="barcontainer" style="width: 75%;">
                <canvas id="canvas2"></canvas>
                </div>
             </div>
          </div>
       </div>
     <decorator:body/>
    </div>
  </div>

  <footer id="myFooter">
    <div class="w3-container w3-theme-l2 w3-padding-32">
      <h4>���� ��ī����</h4>
    </div>

    <div class="w3-container w3-theme-l1">
      <p>Powered by <a href="https://www.goodee.co.kr" target="_blank">������</a></p>
    </div>
    
  </footer>
<!-- END MAIN -->
</div>
<script>
// Get the Sidebar
var mySidebar = document.getElementById("mySidebar");

// Get the DIV with overlay effect
var overlayBg = document.getElementById("myOverlay");

// Toggle between showing and hiding the sidebar, and add overlay effect
function w3_open() {
  if (mySidebar.style.display === 'block') {
    mySidebar.style.display = 'none';
    overlayBg.style.display = "none";
  } else {
    mySidebar.style.display = 'block';
    overlayBg.style.display = "block";
  }
}

// Close the sidebar with the close button
function w3_close() {
  mySidebar.style.display = "none";
  overlayBg.style.display = "none";
}
</script>
<script>
/*
var MONTHS = ['1�б�', '2�б�', '3�б�', '4�б�'];
var ChartData = {
   labels: MONTHS,
   datasets: [{ //������ �κ�
         label: '��',
         fill : false,
         backgroundColor:"#D499B9",
         borderColor: "#9055A2",  
         borderWidth: 1,
         data: [10,95,70,25]
      }, {
         label: '��',
         fill : false,
         backgroundColor:"#0DDDF3",
         borderColor: "#A0FD4F",
         borderWidth: 1,
         data: [40,80,24,25]
      }]//dataset ���� ��
   };
window.onload = function() {
   var ctx1 = document.getElementById('linecanvas').getContext('2d');
   var ctx2 = document.getElementById('barcanvas').getContext('2d');
   window.myLine = new Chart(ctx1, {
      type:'line',//���׷���
      data: ChartData,//������
      options: {
         responsive: true //��������
      }
   });
   window.myBar = new Chart(ctx2, {
      type: 'bar', //����׷���
      data: ChartData, //������
      options: {
         responsive: true, //������ ��
      }
   });
}
*/
</script>
</body>
</html>
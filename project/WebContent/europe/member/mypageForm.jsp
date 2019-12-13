<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="euc-kr">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  
  <title>MyPage :-)</title>
<%--  <% String css = "C:/Users/%EC%9C%A4%EC%A0%95/eclipse-workspace/project2/WebContent/css/mypage.min.css";
  	String css2 ="C:/Users/%EC%9C%A4%EC%A0%95/eclipse-workspace/project2/WebContent/css/mypage.css";
  	css = java.net.URLDecoder.decode(css ,"UTF-8");
  	css2 = java.net.URLDecoder.decode(css2 ,"UTF-8");%> 
  <link href="../../css/mypage.min.css" rel="stylesheet">
  <link href="../../css/mypage.css" rel="stylesheet"> --%>
<!--   <script type="text/javascript">
	function win_update(){
		var op = "width=500,height=550,left=300,top=150";
		nw = open("updateForm.me?id=${login}","update",op)
	}
  </script> -->
</head>
<body>
  <!-- Page Content -->
  <div class="container">
    <div class="row">
      <div class="col-lg-3">
        <h1 class="my-4" style="text-align:center">My Info</h1>   
        <div class="list-group">
          <table border="1" style="text-align:center"> 
          	<tr><th>아이디</th><td>${info.id}</td></tr>
          	<tr><th>닉네임</th><td>${info.nickname}</td></tr>
          	<tr><th>성별</th><td>${info.gender==1?"남":"여"}</td></tr>
          	<tr><th>email</th><td>${info.email}</td></tr>
          	<tr><th>생년월일</th><td>${info.birth}</td></tr>
          	<tr><th>준비중인 여행 예정일(월)</th><td>${info.travel}월</td></tr>
        	<tr><th>선호(예정) 유럽여행지</th><td>${info.national}</td></tr>  
      	 	<tr><td colspan="2" style="text-align:center">
      	 	<a href="updateForm.me?id=${info.id}">[수정]</a>&nbsp;
      	 	 <c:if test="${info.id !='admin' && sessionScope.login != 'admin'}">
      	 		<a href="deleteForm.me?id=${info.id}">[탈퇴]</a>
      	 	</c:if></td></tr>
          </table> 
        </div>
      </div>
   
      <div class="col-lg-9">
        <div id="carouselExampleIndicators" class="carousel slide my-4" data-ride="carousel">
          <ol class="carousel-indicators">
            <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
          </ol>
          <div class="carousel-inner" role="listbox">
            <div class="carousel-item active">
              <img class="d-block img-fluid" src="http://placehold.it/900x350" alt="First slide">
            </div>
            <div class="carousel-item">
              <img class="d-block img-fluid" src="http://placehold.it/900x350" alt="Second slide">
            </div>
            <div class="carousel-item">
              <img class="d-block img-fluid" src="http://placehold.it/900x350" alt="Third slide">
            </div>
          </div>
          <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
          </a>
          <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
          </a>
        </div>

        <div class="row">
          <div class="col-lg-4 col-md-6 mb-4">
            <div class="card h-100">
              <div class="card-body">
                <h4 class="card-title">
                  <a href="#">Item One</a>
                </h4>
                <h5>$24.99</h5>
                <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet numquam aspernatur!</p>
              </div>
              <div class="card-footer">
                <small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9734;</small>
              </div>
            </div>
          </div>
          <div class="col-lg-4 col-md-6 mb-4">
            <div class="card h-100">
              <div class="card-body">
                <h4 class="card-title">
                  <a href="#">Item One</a>
                </h4>
                <h5>$24.99</h5>
                <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet numquam aspernatur!</p>
              </div>
              <div class="card-footer">
                <small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9734;</small>
              </div>
            </div>
          </div>
          <div class="col-lg-4 col-md-6 mb-4">
            <div class="card h-100">
              <div class="card-body">
                <h4 class="card-title">
                  <a href="#">Item One</a>
                </h4>
                <h5>$24.99</h5>
                <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet numquam aspernatur!</p>
              </div>
              <div class="card-footer">
                <small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9734;</small>
              </div>
            </div>
          </div>
        </div>
      </div>
   </div>
</div>

   
  <!-- Footer -->
  <!-- Bootstrap core JavaScript -->
<!-- <script src="../../mypage/vendor/jquery/jquery.min.js"></script>
  <script src="../../mypage/vendor/bootstrap/js/bootstrap.bundle.min.js"></script> -->
</body>
</html>

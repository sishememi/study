<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ȸ�� ���� ����</title>
<%--  <% String css = "C:/Users/%EC%9C%A4%EC%A0%95/eclipse-workspace/project2/WebContent/css/mypage.min.css";
  	String css2 ="C:/Users/%EC%9C%A4%EC%A0%95/eclipse-workspace/project2/WebContent/css/mypage.css";
  	css = java.net.URLDecoder.decode(css ,"UTF-8");
  	css2 = java.net.URLDecoder.decode(css2 ,"UTF-8");
  <link href="D:\190812\project\WebContent\css\mypage.min.css" rel="stylesheet">
  <link href="D:\190812\project\WebContent\css\mypage.css" rel="stylesheet">--%>
 <script type="text/javascript">
  function inputcheck(f){
		<c:if test="${sessionScope.login != 'admin'}" >
			if(f.pass.value==""){
				alert("��й�ȣ�� �Է��ϼ���")
				f.pass.focus()
				return false
			}
		</c:if> 
	}
  </script>
</head>
<body>
  <!-- Page Content -->
  <div class="container">
    <div class="row">
      <div class="col-lg-3">
        <h1 class="my-4" style="text-align:center">My Info</h1>   
        <div class="list-group">
        <form action="update.me" name="f" method="post" onsubmit="return inputcheck(this)">
		<table border="1" style="text-align:center">
		<tr>
		<th>���̵�</th><td><input type="text" name="id" value="${info.id}" readonly></td><%--�о���°͸� ���� --%>
		</tr>
		<tr><th>��й�ȣ</th><td><input type="password" name="pass"></td></tr> <%--��й�ȣ�� �Է¹��� --%>
		<tr><th>�г���</th><td><input type="text" name="nickname" value="${info.nickname }"></td></tr>
		<tr><th>����</th>
			<td>
			<input type="radio" name="gender" value="1" ${info.gender==1?"checked":""}>��
			<input type="radio" name="gender" value="2" ${info.gender==2?"checked":""}>��
			</td>
		</tr>
			<tr><th>�������</th><td>${info.birth}</td></tr>
			<tr><th>�̸���</th><td colspan="2"><input type="email" name="email" value="${info.email }"></td></tr>
			<tr><th>�غ����� ���� ������(��)</th><td colspan="2">
			<select name="travle">
				<c:forEach var="start" begin="1" end="12">
					<option value="" selected disabled hidden > ${info.travel}</option>
					<option> ${start}</option>
				</c:forEach></select></td></tr>
 			<tr><th>��ȣ(����) ����������</th><td colspan="2">
				<input type="checkbox" name="national" value="����" > ����
				<input type="checkbox" name="national" value="������" >������
				<input type="checkbox" name="national" value="������" >������<br>
				<input type="checkbox" name="national" value="����Ʈ����" >����Ʈ����
				<input type="checkbox" name="national" value="������" >������
				<input type="checkbox" name="national" value="��Ż����" >��Ż����<br>
				<input type="checkbox" name="national" value="������" >������
				<input type="checkbox" name="national" value="�� ��" >�� ��
			</td></tr> 
			<tr><td colspan="3"><input type="submit" value="����"></td></tr> 
	</table>
</form>
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
<%-- <script type="text/javascript">
function inputcheck(f){
	<c:if test="${sessionScope.login != 'admin'}" >
		if(f.pass.value==""){
			alert("��й�ȣ�� �Է��ϼ���")
			f.pass.focus()
			return false
		}
	</c:if>

}
</script>
</head>
<body>
<form action="update.me" name="f" method="post" onsubmit="return inputcheck(this)">
	<table>
		<caption>ȸ����������</caption>
		<tr>
		<th>���̵�</th><td><input type="text" name="id" value="${info.id}" readonly></td>�о���°͸� ����
		</tr>
		<tr><th>��й�ȣ</th><td><input type="password" name="pass"></td></tr> ��й�ȣ�� �Է¹���
		<tr><th>�г���</th><td><input type="text" name="nickname" value="${info.nickname }"></td></tr>
		<tr><th>����</th>
			<td>
			<input type="radio" name="gender" value="1" ${info.gender==1?"checked":""}>��
			<input type="radio" name="gender" value="2" ${info.gender==2?"checked":""}>��
			</td>
		</tr>
			<tr><th>�������</th><td>${info.birth}</td></tr>
			<tr><th>�̸���</th><td colspan="2"><input type="email" name="email" value="${info.email }"></td></tr>
			<tr><th>�غ����� ���� ������(��)</th><td colspan="2"><select name="travle">
				<c:forEach var="start" begin="1" end="12">
					<option> ${info.travel}</option>
				</c:forEach></select></td></tr>
			<tr><th>��ȣ(����) ����������</th><td colspan="2">
			<c:set var="n" value="${info.national}"/> <!-- ����,������ -->
			<c:set var="arr" value="${fn:split(n,',')}" />
				<input type="checkbox" name="national" value="����" checked='${arr[0]=="����"?"checked":"unchecked"}'> ����
				<input type="checkbox" name="national" value="������" >������
				<input type="checkbox" name="national" value="������" checked='${arr[0]=="������"?"checked":"unchecked"}'>������<br>
				<input type="checkbox" name="national" value="����Ʈ����" >����Ʈ����
				<input type="checkbox" name="national" value="������" >������
				<input type="checkbox" name="national" value="��Ż����" >��Ż����<br>
				<input type="checkbox" name="national" value="������" >������
				<input type="checkbox" name="national" value="�� ��" >�� ��
				</td></tr>
			<tr><td colspan="3"><input type="submit" value="���� ����"></td></tr>
	</table>
</form>
</body>
</html> --%>
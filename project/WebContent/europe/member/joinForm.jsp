<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>	
<!DOCTYPE html>
<html lang="en">
<head>
<title>login page ;-)</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="../../css/util.css">
<link rel="stylesheet" type="text/css" href="../../css/main.css">
<script type="text/javascript">
function inputcheck(){
	if(f.id.value==""){
		alert("���̵� �Է��ϼ���");
		f.id.focus();
		return;
	}
	 if(f.pass.value==""){
			alert("��й�ȣ�� �Է��ϼ���.");
			f.pass.focus();
			return false;
		  }
	if(f.nickname.value==""){
			alert("�г����� �Է��ϼ���.");
			f.nickname.focus();
			return false;
		}
	if(f.email.value==""){
			alert("email�� �Է��ϼ���.");
			f.email.focus();
			return false;
		}
	if(f.year.val()==""){
			alert("����⵵�� �����ϼ���");
			return false;
		}
	if(f.month.value==""){
			alert("����⵵�� �����ϼ���");
			return false;
		}
	if(f.day.value==""){
			alert("����⵵�� �����ϼ���");
			return false;
		}
	if(f.gender.value==""){
			alert("������ �����ϼ���");
			return false;
		}
	if($("input[name='national']").is(":checked"){
			alert("��ȣ�ϴ� ���� ��� �Ѱ� üũ���ּ���")
			$("input[name='national']").eq(0).focus();
			return false;
		}
	f.submit();
}
</script>
</head>
<body>
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100 p-t-50 p-b-90" style="">
				<form class="login100-form validate-form flex-sb flex-w" action="join.me" method="post" name="f">
					<span class="login100-form-title p-b-51"> Join Us! ;-D </span>
				  
 					<table style="table-layout:fixed; margin:auto; text-align:center;" >
					<tr><th width=30%>���̵�</th>
					<td width=70%> 
					<div class="wrap-input100 validate-input m-b-16" data-validate = "Username is required">
						<input class="input100" type="text" name="id" id="id" placeholder="���̵� �Է��ϼ���">
						<span class="focus-input100"></span>  
					</div></td></tr>
					    
					<tr>
					<th>��й�ȣ</th>
						<td>
						<div class="wrap-input100 validate-input m-b-16" data-validate = "Password is required">
						<input class="input100" type="password" name="pass" id="pass" placeholder="��й�ȣ�� �Է��ϼ���">
						<span class="focus-input100"></span>
					</div></td></tr>
					
					<tr>
						<th>�г���</th>
						<td>
						<div class="wrap-input100 validate-input m-b-16" data-validate = "nickname is required">
						<input class="input100" type="text" name="nickname"  id="nickname" placeholder="�г����� �Է��ϼ���">
						<span class="focus-input100"></span>
					</div></td></tr>
					
					<tr>
						<th>email</th>
						<td>
						<div class="wrap-input100 validate-input m-b-16" data-validate = "email is required">
						<input class="input100" type="email" name="email" id="email" placeholder="�̸����� �Է��ϼ���">
						<span class="focus-input100"></span>
					</div></td></tr>
					
					<tr>
						<th>�������</th>
						<td>
						<div  class="wrap-input101 validate-input m-b-16" data-validate = "email is required" style="margin:auto;">
						<!-- <input class="input100" type="date" name="birth" > -->
						<select name="year" id="year">
						 <c:forEach var="y" begin="1930" end="2019">
							 <option> ${y}</option>
						  </c:forEach>
						  </select>
						  <select name="month" id="month">
						  <c:forEach var="m" begin="1" end="12">
							    <option> ${m}</option>
						  </c:forEach>
						  </select> 
						  <select name="day" id="day">
						   <c:forEach var="d" begin="1" end="31">
						   		<option> ${d}</option>
						  </c:forEach></select><br>
						<span class="focus-input100"></span>
					</div></td></tr>
					<tr> 
						<td colspan="2">&nbsp;</td>
					</tr>
					<tr>
						<th>����</th>
						<td class="wrap-input101 validate-input m-b-16"><input type="radio" name="gender" id="gender" value="1" checked>��&nbsp;
							<input type="radio" name="gender" id="gender" value="2">��</td>
					</tr>
					<tr>
						<th colspan="2" style="font-size:26px; color:#403866">������ ����</th>
					</tr>
					<tr>
						<td colspan="2" style="font-size:13px; color:#FF0066">�ءٿ����� ������������
						  '��� ������'�� '������'��<br> üũ���ּ���.�١�<br>�ءڿ����ȹ�� ���°�� ��ȣ�ϴ� �������� üũ���ּ���!�ڡ�
						</td>
					</tr>
					
					<tr class="wrap-input101 validate-input m-b-16">
						<td colspan="2">���� ��� ������(��):&nbsp;
						<select name="travel" id="travel">
						   <c:forEach var="start" begin="1" end="12">
						   	 <option value="" selected disabled hidden >-----</option>
							 <option> ${start}</option>
						  </c:forEach></select><br>
					</td>
					</tr>    
					<tr class="wrap-input101 validate-input m-b-16">
					<td colspan="2" height=100% id="chkTd">
					<input type="checkbox" name="national"  value="����" >����
					<input type="checkbox" name="national"  value="������">������
					<input type="checkbox" name="national"  value="������">������
					<input type="checkbox" name="national"  value="����Ʈ����">����Ʈ����<br>
					<input type="checkbox" name="national"  value="������">������
					<input type="checkbox" name="national"  value="��Ż����">��Ż����
					<input type="checkbox" name="national"  value="������">������
					<input type="checkbox" name="national"  value="�� ��">�� ��
					</td>
					</tr> 
					<tr>
					<td colspan="2"> 
					 <div class="container-login100-form-btn m-t-17">
					 <input type="submit" id="btn" class="login100-form-btn" value="Login" onclick="javascript:inputcheck()">
					 </div></td></tr>
				</table> 
				</form>
			</div>
		</div>
	</div>
</body>
</html>
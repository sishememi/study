<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ȸ�� Ż�� :(</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="../../css/util.css">
	<link rel="stylesheet" type="text/css" href="../../css/main.css">  
</head>
<body>
<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100 p-t-50 p-b-90" style="">
				<form action="delete.me" method="post" class="login100-form validate-form flex-sb flex-w" style="text-align:center;">
					<input type="hidden" name="id" value='${param.id}'>
					<span class="login100-form-title p-b-51">
						Ż���ϱ�
					</span>
					<p>Ż�� ����</p> ${param.id}<p>�� ��й�ȣ�� �Է��ϼ���</p>

					<div class="wrap-input100 validate-input m-b-16">
						<input class="input102" type="password" name="pw" placeholder="password">
						<span class="focus-input102"></span>
					</div>			

					<div class="container-login100-form-btn m-t-17">
					   <button class="login100-form-btn"  style="background:#f9c00c; cusor:pointer">Ż���ϱ� </button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
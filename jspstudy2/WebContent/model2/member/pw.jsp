<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>��й�ȣã��</title>
<link rel="stylesheet" href="css/main3.css">
<script type="text/javascript">
   function pwclose() {
	   self.close();
   }
</script>
</head>
<body>
<table>
  <tr><th>��й�ȣ</th>
    <td>**${pass}</td>
  </tr>
  <tr><td colspan="2">
     <input type="button" value="�ݱ�" onclick="pwclose()">
  </td>
  </tr>
</table>
</body>
</html>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>회원가입</title>

  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootswatch@4.5.2/dist/minty/bootstrap.min.css" integrity="sha384-H4X+4tKc7b8s4GoMrylmy2ssQYpDHoqzPa9aKXbDwPoPUA3Ra8PA5dGzijN+ePnH" crossorigin="anonymous">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<!-- 이메일 -->
<form accept-charset="UTF-8" method="post" action="/Login">
  <input type="text" id="userid" name="email" placeholder="E-mail을 입력하세요" />

  <!-- 비밀번호 -->
  <input type="password" id="password"  name="pw" placeholder="비밀번호를 입력하세요"  />

  <!--제출 -->
  <button type="submit"/>로그인</button>
</form>
</body>
</html>
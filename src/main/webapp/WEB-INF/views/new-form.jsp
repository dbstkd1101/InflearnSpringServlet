<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<!-- action의 값이 상대경로를 사용. action의 값(URL 경로)로 "/"로 시작 안함 = 상대경로-->
<form action="save" method="post">
     username: <input type="text" name="username" />
     age: <input type="text" name="age" />
     <button type="submit">전송</button>
</form>
</body>
</html>
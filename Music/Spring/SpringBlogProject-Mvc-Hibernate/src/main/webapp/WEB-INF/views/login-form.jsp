<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page isELIgnored="false" %> 
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#container{
border:2px solid black;
margin-left: 600px;
margin-right: 600px;
height:300px;
margin-top:300px;
text-align: center;
}
.form{
height:30px;
}
</style>
</head>
<body>
<div id="container">

<h1>Login</h1>
<form action="loginUser">
<input name="email" placeholder="Email" class="form"> 
<br>
<br>
<input name="password" placeholder="password" class="form">
<br>
<br>
<input type="submit" value="Submit" class="form">

</div>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
           <%@ page isELIgnored="false" %> 
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#container{
text-align: center;
border:2px solid black;
margin-left: 600px;
margin-right: 600px;
margin-top: 200px;

}
.form{
height: 30px;
}
.error{
color:red;
}
</style>

</head>
<body>
<div id="container">
<h1>Create Account</h1>
<form:form action="signup" modelAttribute="user">
<form:input path="name" placeholder="Name" class="form"/>
<form:errors path="name" cssClass="error"></form:errors>
<br>
<br>
<form:input path="email" placeholder="Email" class="form"/>
<br>
<br>
<form:input path="password" placeholder="Password" class="form"/>
<br>
<br>

<form:input path="confirmPassword" placeholder="Confirm Password" class="form"/>
<br>
<br>
<input type="submit" value="Sign Up" class="form">
<br>
<br>
</form:form>


</div>

</body>
</html>
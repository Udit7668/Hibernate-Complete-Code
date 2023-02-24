<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="java.util.List" import="com.udit.entity.*"%>
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
border:2px solid black;
padding: 20px;
margin-left:500px;
margin-right:500px;
margin-top:30px;
width: 500px;
text-align: center;
}

</style>
</head>
<body>

<%

  List<String> comments=(List<String>)request.getAttribute("comments");

%>

<div id="container">
<h1>Make You post Here</h1>
<form:form  action="updatepost"   modelAttribute="post">

<!-- Need to associate the customer id with form data -->
<form:hidden path="id"/>

  Enter Title:: <br>
  <form:input path="title"/>
  <br>
  <br>
  Enter Excrept::<br>
  <form:input path="excrept"/>
  <br>
  <br>
  
  Enter Content::<br>
  <form:textarea path="content"/>
  <br>
  <br>
  
  Author::<br>
  <form:input path="author"/>
  <br>
  <br>
  
   <form:form action="check" modelAttribute="tags">
  Enter Tag:<br>
 Cricket:: <form:checkbox path="name" value="Cricket"/>
 Hockey:: <form:checkbox path="name" value="Hockey"/>
 Politics:: <form:checkbox path="name" value="Politics"/>
 Business:: <form:checkbox path="name" value="Business"/> 
  
 
   <input type="hidden" value="${comments}" name="commentsold">
  <input type="submit" value="Pulblish Now">

</form:form>

</form:form>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
       <%@ page isELIgnored="false" %> 
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
#container{
margin-left:400px;
margin-right:400px;
margin-top:20px;
border:2px solid black;
height:900px;
padding: 30px;
}
#comments{
diplay:inline:block;
width:20%;
border:2px solid;
padding: 10px;
}

#delete{
display: flex;
}


</style>
</head>
<body>
<div id="container">

<div id="content"><h1>Created by:-${post.author}</h1>
<h3>Created At:-${post.creationDate}</h3>
<h4>Updated At:${post.updateDate }</h4>
<h4>Tags::
<c:forEach items="${post.tags}" var="tag">
   ${tag.name} 
</c:forEach>

</h4>
<h1>Content</h1>
<br>
<p>${post.content} </p>

<form action="delete">
  <button type="submit" value="${post.id}" name="deleteId">Delete</button>
</form>
<br>
<br>
<td>

<form action="update">
 <input type="hidden" value="${post.comments}" name="comments">
  <button type="submit" value="${post.id}" name="updateId">Update</button>
</form>
</td>
<br>
<br>
</div>

<div id="content">

<div id="comments">
  <c:forEach items="${post.comments}" var="single">
  <p>${single.name}</p>
  <p>${single.comment} </p>
  <div id="delete"> 
<form action="deleteComment">
  <input type="hidden" value="${post.id}" name="postId">
  <button type="submit" value="${single.id}" name="deleteId">Delete</button>
</form>
<form action="updateComment">
  <input type="hidden" value="${post.id}" name="postId">
  <button type="submit" value="${single.id}" name="updateId">Update</button>
</form>
</div>
  
  <hr>
  </c:forEach>

</div>

</div>
<form:form action="comment" modelAttribute="comment">
<form:hidden path="id"/>
Name:
<br>
<form:input path="name"/>
<br>
Email:
<br>
<form:input path="email"/>
<br>
Comment:
<br>
<form:textarea path="comment"/>
<br>
<button type="submit" value="${post.id}" name="viewId">Comment</button>
</form:form>





</div>

</body>
</html>
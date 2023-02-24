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

<style>
td,th{
border:2px solid black;
}

#nav{
display: flex;
justify-content: space-between;
}

#action{
display: flex;
padding: 10px;
}

.pagination{
display: flex;
padding:10px;
}
.pagination li{
margin: 20px;
}

.button{
display: flex;
justify-content: space-around;
}
</style>
</head>
<body>

<h1>All posts are</h1>
<div id="nav">
<div id="add">
<form action="newpost">
<button type="submit">Add Post</button>
</form>
</div>
<div id="action">
<div id="search">
<form action="search">
 Search::<input type="text" name="title">
<button type="submit">Search</button>
</form>
</div>
<div id="sort">
<form action="sort">
Sort:: <select name="sortby">
<option value="asc" label="Ascending">
<option value="desc" label="Descending">
<select>
<button type="submit">Sort</button>
</form>
</div>
</div>
</div>
<table>


<tr>
<th>Post Title</th>
<th>Post Excrept</th>
<th>Post Published</th>
<th>Post Author</th>
<th>Post Tags</th>
<th>Post Creation Date</th>
<th>Post Update Date</th>
</tr>
<c:forEach items="${posts}" var="post">
<tr>
<td>${post.title}</td>
<td>${post.excrept}</td>
<td>${post.isPublished}</td>
<td>${post.author}</td>
<td><c:forEach items="${post.tags}" var="tag">
      ${tag.name} 
</c:forEach>
</td>
<td>${post.creationDate}</td>
<td>${post.updateDate}</td>
<td>
<form action="delete">
  <button type="submit" value="${post.id}" name="deleteId">Delete</button>
</form>
</td>



<td>
<form action="view">
  <button type="submit" value="${post.id}" name="viewId">View Post</button>
</form>
</td>



</tr>
</c:forEach>
</table>
Filter::
<form action="filter">
<select name="author">
<c:forEach items="${posts}" var="post">
<option value="${post.author}" label="${post.author}">
</c:forEach>
<c:forEach items="${posts}" var="post">
 <c:forEach items="${post.tags}" var="tag">
 <option value="${tag.name}" label="${tag.name}"> 
 </c:forEach>
</c:forEach>
</select>
<input type="submit" value="Filter">
</form>


<div  class="button">
<form action="previous">
<button type="submit" value="previous" name="previous">Previous</button>

<form action="next">
<button type="submit" value="next" name="next">Next</button>

</form>
</div>

</body>
</html>
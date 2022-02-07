<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"		uri="http://java.sun.com/jsp/jstl/core"			%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
<p>list Board !</p>
<div>
<input type="button" onclick="createBoard();" value="글 작성">
<input type="button" onclick="listBoard();" value="목록">
</div>


<form action="/searchBoard" method="GET">
    <select id="searchType" name="searchType">
   		 <option value="">검색조건</option>
    	<option value="title">Title</option>
    	<option value="content">Content</option>
    	<option value="userName">UserName</option>
    </select>
    <input type="text" id="searchKey" name="searchKey" placeholder="검색키워드">
    <button>검색하기</button>
</form>
<div class="container">
    <table class="table table-hover">
        <tr>
        	<th>No</th>
            <th>Title</th>
            <th>Content</th>
            <th>Name</th>
        </tr>
          <c:forEach var="l" items="${list}">
              <tr>
              	  <td>${l.id}</td>
                  <td>${l.title}</td>
                  <td>${l.content}</td>
                  <td>${l.userName}</td>
              </tr>
          </c:forEach>
          
    </table>
</div>
</body>
</html>
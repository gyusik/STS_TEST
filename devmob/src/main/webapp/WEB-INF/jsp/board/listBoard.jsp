<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"		uri="http://java.sun.com/jsp/jstl/core"			%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board</title>
</head>
<body>
<div style="text-align: right; margin-right: 10%;">
	<input type="button" class="btn btn-primary" onclick="createBoard();" value="글 작성">
	<input type="button" class="btn btn-default" onclick="listBoard();" value="목록">
</div>

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
              	  <td><a href="viewBoard?id=${l.id}">${l.id}</a></td>
                  <td>${l.title}</td>
                  <td>${l.content}</td>
                  <td>${l.userName}</td>
              </tr>
          </c:forEach>
          
    </table>
    <div style="text-align: center;">
    <c:if test="${page ne 0}">
    	<c:forEach var="i" begin="0" end="${page-1}">
    		<a href="listBoard?page=${i}">${i+1}</a>
    	</c:forEach>
    </c:if>
    </div>
</div>

<form action="/searchBoard" method="GET">
	<div style="text-align: center;">
		  <label for="searchType">검색조건:</label>
		  	<select id="searchType" name="searchType">
		   		<option value="">선택</option>
		    	<option value="title">Title</option>
		    	<option value="content">Content</option>
		    	<option value="userName">UserName</option>
	    	</select>
	    <input type="text" id="searchKey" name="searchKey" placeholder="검색키워드" >
	    <button class="btn btn-success">검색하기</button>
    </div>
</form>
</body>
</html>
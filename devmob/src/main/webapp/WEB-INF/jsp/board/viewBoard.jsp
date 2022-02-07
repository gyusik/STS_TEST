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
<input type="hidden" id="userId" name="userId" value="${data.id }">
<div style="text-align: right; margin-right: 50px;">
	<c:if test="${isCreater eq true}">
		<input type="button" class="btn btn-primary" value="수정" onclick="updateBoard();">
		<input type="button" class="btn btn-default" value="삭제" onclick="deleteBoard();">
	</c:if>
	<input type="button" class="btn btn-default" onclick="listBoard();" value="목록">
</div>

<div class="container">
	<div class="form-group">
	  <label for="userName">Name:</label>
	  <input type="text" class="form-control" id="userName" readonly="readonly" value="${data.userName }">
	</div>
	<div class="form-group">
	  <label for="title">Title:</label>
	  <input type="text" class="form-control" id="title" value="${data.title }">
	</div>
	<div class="form-group">
	  <label for="content">Content:</label>
	  <input type="text" class="form-control" id="content" value="${data.content }">
	</div>
</div>
</body>
<script type="text/javascript">
function updateBoard(){
	var param = new Object();
	param["userId"] = $("#userId").val();
	param["userName"] = $("#userName").val();
	param["title"] = $("#title").val();
	param["content"] = $("#content").val();
	param = JSON.stringify(param);
	$.ajax({
		type : "POST",
		url : "/updateBoard",
		dataType : "JSON",
		crossDomain: true,
		data : param,
		contentType : "application/json; charset=UTF-8",
		complete : function(data, flag) {
			location.href="listBoard";
		},
	});
}

function deleteBoard(){
	var param = new Object();
	param["userId"] = $("#userId").val();
	param = JSON.stringify(param);
	$.ajax({
		type : "POST",
		url : "/deleteBoard",
		dataType : "JSON",
		crossDomain: true,
		data : param,
		contentType : "application/json; charset=UTF-8",
		complete : function(data, flag) {
			location.href="listBoard";
		},
	});
}
</script>
</html>
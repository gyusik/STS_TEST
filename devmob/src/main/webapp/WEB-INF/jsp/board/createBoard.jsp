<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
<p>create Board !</p>
<!-- <input type="text" id="userName" name="userName" placeholder="Name"> -->
<input type="text" id="title" name="title" placeholder="Title">
<input type="text" id="content" name="content" placeholder="Content">
<input type="button" value="저장" onclick="saveBoard();">
<script type="text/javascript">
function saveBoard(){
	var param = new Object();
	//param["userName"] = $("#userName").val();
	param["title"] = $("#title").val();
	param["content"] = $("#content").val();
	param = JSON.stringify(param);
	
	$.ajax({
		type : "POST",
		url : "/saveBoard",
		dataType : "JSON",
		crossDomain: true,
		data : param,
		contentType : "application/json; charset=UTF-8",
		complete : function(data, flag) {
			opener.location.reload(); 
			self.close();
		},
	});
}
</script>
</body>
</html>
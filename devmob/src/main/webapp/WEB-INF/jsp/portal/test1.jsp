<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<!-- JQUERY -->
<script type=text/javascript>
$(document).ready(function(){
	
	$("#getdata").click(function() {
		getGetData();
	});
	$("#postdata").click(function() {
		getPostData();
	});
});


function getGetData(){
	var params = new Object();
	params["oid"] = encodeURI("id");
	params["sendUrl"] = encodeURI("get");
	params["param1"] = encodeURI("param1");
	params["param2"] = encodeURI("param2");
	let url = "/sendGET";
	
	//params = JSON.stringify(params);
	//params = encodeURI(params);
	console.log(params);
	
	$.ajax({
		type : "GET",
		url : url,
		dataType : "JSON",
		crossDomain: true,
		data : params,
		contentType : "application/json; charset=UTF-8",
		complete : function(data, flag) {
		
		},
		success : function(data) {
			console.log("---------------------");
			console.log(data);
        },
	});
}

function getPostData(){
	var params = new Object();
	params["oid"] = "id";
	params["sendUrl"] = "post";
	params["param1"] = "param1";
	params["param2"] = "param2";
	let url = "/sendPOST";
	
	params = JSON.stringify(params);
	//params = encodeURI(params);
	console.log(params);
	
	$.ajax({
		type : "POST",
		url : url,
		dataType : "JSON",
		crossDomain: true,
		data : params,
		contentType : "application/json; charset=UTF-8",
		async : false, 
		complete : function(data, flag) {
		
		},
		success : function(data) {
			console.log("---------------------");
			console.log(data);
        },
	});
}
</script>
<body>
<input type="button" value="get" id="getdata"/>
<input type="button" value="post" id="postdata"/>
</body>
</html>
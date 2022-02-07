function popupBtnClick(){
	window.open("portal-popup");
}

function listBoard(){
	location.href="listBoard";
}
function createBoard(){
	window.open("createBoard");
}
function searchBoard(){
	var param = new Object();
	param["searchKey"] = $("#searchKey").val();
	param = JSON.stringify(param);
	
	$.ajax({
		type : "POST",
		url : "/searchBoard",
		dataType : "JSON",
		crossDomain: true,
		data : param,
		contentType : "application/json; charset=UTF-8",
		complete : function(data, flag) {
		
		},
		success : function(data) {
			var list = JSON.parse(data);
			console.log(list);
        },
	});
}
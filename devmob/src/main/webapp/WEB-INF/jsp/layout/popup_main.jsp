<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main</title>
<!--<meta name="viewport" content="width=device-width, initial-scale=1.0">-->
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<script type="text/javascript" src="/webjars/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript" src="/js/main.js"></script>

<!-- 부트스트랩 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</head>
   <body>
    <section class="content">
      <tiles:insertAttribute name="popup_header"/>
      <tiles:insertAttribute name="popup_body"/>
      <tiles:insertAttribute name="popup_footer"/>
    </section>
  </body>
</html>
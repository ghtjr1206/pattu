<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
<%-- <link rel="stylesheet" href="${pageContext.request.contextPath}/front/common.css"> --%>
<%-- <script src="${pageContext.request.contextPath}/front/common.js"></script> --%>
<%-- ${pageContext.request.contextPath}  : 해당 페이지의 contextPath를 가져와라. --%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common.css">
<script src="${pageContext.request.contextPath}/resources/js/common.js"></script>
</head>
<body>
	<h1>인터셉터 메뉴 가기</h1>
	<a href="/home">인터셉터 메뉴</a>


	<h1>pathvar 인덱스</h1>
	<a href="/pathvar/page/one">page1</a>
	<a href="/pathvar/page/two">page2</a>
	<a href="/pathvar/byGet?key1=111&key2=zzz">byGet쿼리스트링</a>
	<a href="/pathvar/byPath/qaz/987">byPath Restful 1</a>
	<a href="/pathvar/byPath/key1/123/key2/aza">byPath Restful 2</a>
</body>
</html>




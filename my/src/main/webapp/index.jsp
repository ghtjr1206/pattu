<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<body>
<div class="jumbotron">
   <h1>환영합니다.</h1>      
</div>
<%@ include file="menu.jsp" %>
<p id="timeBox"></p>
<script>
	$(document).ready(function(){
		$.ajax({
			url : "test.do",
			type : "GET",
			success : function(res){
				$("#timeBox").text(res);
			},
			error : function(err){
				console.log(err);
			}
		});
	});
</script>  
</body>
</html>
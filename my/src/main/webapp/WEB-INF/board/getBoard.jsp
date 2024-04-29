<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../header.jsp" %>
<%
	String sts = "";
	if(session.getAttribute("userId") == null){
		 sts = "disabled";
	}
	
%>
<body>
<div class="jumbotron">
   <h1>상세 보기</h1>      
</div>
<%@ include file="../../menu.jsp" %>  
<div class="container-fluid">
<%
	if (request.getParameter("error")!=null) {
		out.println("<div class='alert alert-danger'>");
		out.println("해당 글은 작성자만이 수정할 수 있습니다.");
		out.println("</div>");
	}
%>
  <form name="fm" action="updateBoard.do" method="post">
  <input type="hidden" name="seq" value="${board.seq}">
    <div class="input-group mb-3">
      <div class="input-group-prepend">
        <span class="input-group-text">제목</span>
      </div>
      <input type="text" class="form-control innm" name="title" value="${board.title}" <%=sts %>>      
    </div>
    <div class="input-group mb-3">
      <div class="input-group-prepend">
        <span class="input-group-text">작성자</span>
      </div>
<%--       <input type="text" class="form-control innm" name="writer" value="${board.writer}" readonly <%=sts %>>       --%>
      <input type="text" class="form-control innm" value="${board.writer}" readonly <%=sts %>>      
    </div>
    <div class="input-group mb-3">
      <div class="input-group-prepend">
        <span class="input-group-text">내용</span>
      </div>
      <textarea class="form-control innm" rows="10" id="comment" name="content" <%=sts %>>${board.content}</textarea>      
    </div>  
    <div class="input-group mb-3">
      <div class="input-group-prepend">
        <span class="input-group-text">파일선택</span>
      </div>
      <input type="file" class="form-control innm" name="filename" value="${board.filename}" <%=sts %>>      
    </div>
    <div class="input-group mb-3">
      <div class="input-group-prepend">
        <span class="input-group-text">등록일</span>
      </div>
      <input type="text" class="form-control innm" name="regDate" value="${board.regdate}" readonly <%=sts %>>      
    </div>
    <div class="input-group mb-3">
      <div class="input-group-prepend">
        <span class="input-group-text">조회수</span>
      </div>
      <input type="text" class="form-control innm" name="cnt" value="${board.cnt}" readonly <%=sts %>>      
    </div>
    <div id="footer">
	  	<button type="submit" class="btn btn-primary" <c:if test="${ !(userRole eq 'Admin' || userRole eq 'Super'  || userName eq board.writer)}">disabled</c:if>>글수정</button>
	  	<button id="conWrite" type="button" class="btn btn-primary"  <c:if test="${ userId eq null }">disabled</c:if>>글쓰기</button>
	  	<button id="conDel" type="button" class="btn btn-primary" <c:if test="${ !(userRole eq 'Admin' || userRole eq 'Super' || userName eq board.writer)}">disabled</c:if>>글삭제</button>
	  	<button id="conList" type="button" class="btn btn-primary">글목록</button>
	</div>
  </form>  
</div>


</body>
</html>

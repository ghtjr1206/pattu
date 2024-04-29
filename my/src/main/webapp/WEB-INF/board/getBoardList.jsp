<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../../header.jsp" %>
<style>
#searchNav{-webkit-justify-content: flex-end; justify-content: flex-end; }
</style>
<body>
<div class="jumbotron">
   <h1>공지 사항 ${userRole }</h1>      
</div>
<%@ include file="../../menu.jsp" %>
<nav id="searchNav" class="navbar navbar-expand-sm navbar-dark">
  <form class="form-inline" action="getBoardList.do" method="post">
  	<select class="form-control" id="sel1" name="searchCondition" style="display:inline-block!important;margin-right:10px;">
        <c:forEach items="${conditionMap}" var="option">
	        <option value="${option.value}">${option.key}</option>
        </c:forEach>
<!-- 		<option value="TITLE">제목</option> -->
<!-- 		<option value="CONTENT">내용</option> -->
    </select>
    <input class="form-control mr-sm-2" type="text" name="searchKeyword" placeholder="검색어를 입력하세요.">
    <button class="btn btn-success" type="submit">검색</button>
  </form>
</nav>
<div class="container-fluid">
  <table class="table table-hover">
    <thead class="btn-primary">
      <tr>
        <th>번호</th>
        <th>제목</th>
        <th>작성자</th>
        <th>등록일</th>
        <th>조회수</th>
      </tr>
    </thead>
    <tbody>
<c:forEach items="${boardList}" var="board">
	<tr onclick="selTr(${board.seq})" style="cursor:pointer;">
	  <td class="tdCenter">${board.seq}</td>
	  <td>${board.title}</td>
	  <td class="tdCenter">${board.writer}</td>
	  <td class="tdCenter">${board.regdate}</td>
	  <td class="tdCenter">${board.cnt}</td>
	</tr>
</c:forEach>
    </tbody>
  </table><br><br>
  <div id="footer">
  	<button type="button" id="conWrite" class="btn btn-primary"<c:if test="${ userId eq NULL}">disabled</c:if>>글쓰기</button>
  </div>
</div>

</body>
</html>

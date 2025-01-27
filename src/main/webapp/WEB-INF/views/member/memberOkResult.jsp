<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${result==1}">
	<script>
		alert("회원이 정상등록되었습니다.\n로그인 페이지로 이동합니다.");
		location.href="${pageContext.request.contextPath}/member/login";
	</script>
</c:if>

<c:if test="${result==0}">
	<script>
		alert("회원등록실패하였습니다.\n이전 페이지로 이동합니다.");
		history.back();
	</script>
</c:if>



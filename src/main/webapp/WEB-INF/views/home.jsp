<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P> The time on the server is ${serverTime}. </P>
<p> 스프링 홈페이지 </p>
<img src="img/01.jpg" width="200"/>

<h1>mapping Test</h1>

<pre>
	*Handler Mapping에게 요청

	*get 방식
	html - a태그 
	js - location.href
	jsp - response.sendRedirect
	
	*get 방식/post 방식 둘 다 가능
	form태그
	
	*Controller를 생성하는 법 연습 -> TestController.java로
</pre>

<div>
	<a href="/myapp/test1?num=1234&name=홍길동">접속하기(GET)</a>
	<!-- /test1 - 맵핑주소, Dispatcher Servlet이 주소를 받고 실행 - 먼저 TestController에서 메소드 생성한다. -->
	
	<a href="/myapp/test2?num=55&name=이순신">접속하기2(GET)</a>
	<a href="/myapp/test3?num=111&name=안중근&tel=010-5043-2500">접속하기3(GET)</a>
</div>

<div>
	username : ${username}<br>
	hi : ${hi}
</div>

</body>
</html>

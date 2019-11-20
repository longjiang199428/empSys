<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body {
	text-align: center;
	margin: 0;
}

hr {
	width: 90%;
	margin-top: 30px
}
h1{
	margin: 0;
	font-size: 60px
}

a {
	text-decoration: none;
	font-size: 18px;
	color: black;
}

a:hover {
	font-size: 22px;
	background-color: darksalmon;
}

#box {
	position:relative;
	left: 85%;
	margin-top: -40px;
	height: 25px;
	width: 60px;
}

#box1 {
	position:relative;
	left: 90%;
	margin-top: -45px;
	height: 20px;
	width: 60px;
}

#box2 {
	position:relative;
	left: 45%;
	margin-top: -24px;
	width: 200px;
	height: 20px;
	font-size: 24px;
	
	
}

#box3 {
	position:relative;
	left: 75%;
	margin-top: 10px;
	width: 90px;
	height: 20px;
}

#box4 {
	position:relative;
	right: -85%;
	margin-top: -20px;
	width: 90px;
	height: 20px;
}
#maxdiv{
	background-color:#FFFAF0 ;
	width: 80% ;
	margin: 0 auto ;
	height: 700px
</style>

</head>

<body>
	<div id="maxdiv">
		<h1>员工管理软件</h1>

		<hr>

		<c:if test="${emp ==null }">

			<div id="box">

				<a href="${pageContext.request.contextPath }/login.jsp">登录</a>
			</div>
			&emsp;
			<div id="box1">
				<a href="${pageContext.request.contextPath}/doSubmitServlet">注册</a>
			</div>
		</c:if>

		<c:if test="${emp != null }">
			<div id="box2">欢迎: ${emp.name } 登录</div>
			<div id="box3">
				<a href="${pageContext.request.contextPath }/listEmpServlet">员工列表</a>
			</div>
			<div id="box4">
				<a href="${pageContext.request.contextPath }/logoutServlet">安全退出</a>
			</div>
		</c:if>
	</div>
</body>

</html>
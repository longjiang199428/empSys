<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
	body{
		text-align: center;
	}
	
	hr{
		width: 80%;
	}
	
	table{
		width: 750px;
		margin: 0 auto;
		border-collapse: collapse;
		text-align: center;
	}
	
</style>

</head>
<body>

	<h1>员工列表</h1>

	<hr>
	<div id="tiaojian">
	<form action="${pageContext.request.contextPath }/searchServlet" method="post">
	检索条件:<input type="text" name="cname" placeholder="如:赵%">
	
	<input type="submit" value="确定">
	</form>
	</div>
	<br/>
	
	<table border="1">
		<thead>
			<tr>
				<th>序号</th>
				<th>id</th>
				<th>姓名</th>
				<th>密码</th>
				<th>性别</th>
				<th>年龄</th>
				<th>入职日期</th>
				<th>工资</th>
				<th>电话</th>
				<th>邮箱</th>
				<th colspan="2">操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listEmp }" var="e" varStatus="vs">
				<tr>
					<td>${vs.count }</td>
					<td>${e.id }</td>
					<td>${e.name }</td>
					<td>${e.password }</td>
					<td>${e.gender }</td>
					<td>${e.age }</td>
					<td>${e.hiredate }</td>
					<td>${e.salary }</td>
					<td>${e.phone }</td>
					<td>${e.email }</td>
					<td><a href="${pageContext.request.contextPath }/updateServlet?id=${e.id}">修改</a></td>
					<td><a href="${pageContext.request.contextPath }/deleteServlet?id=${e.id}">删除</a></td>
				</tr>
			</c:forEach>
		</tbody>
		
	</table>

</body>
</html>
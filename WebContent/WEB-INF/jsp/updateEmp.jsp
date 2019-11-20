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
		.put {
			height: 25px;
		}
		#box1 {
			margin-left: -12px;
		}

		#box2 {
			margin-left: -30px;
		}

		#box3 {
		margin-left: -5px;
		height: 25px;
		}
		#box{
		margin-left: 12px;
		}
		#pt {
			width: 250px;
			height: 40px;
			font-size: 25px;
			border-radius: 10px;
		}

		a {
			text-decoration: none;
			color: black;
		}
		.pwdSpan1{
			margin-left: 775px;
			height: 35px;
			width: 110px;
			margin-top: -50px;
	
		}
		.pwdyhm{
			margin-left: 340px;
			height: 30px;
			width: 120px;
			margin-top: -32px;
		}
	</style>

	<script type="text/javascript">
		function checkPwd(){
			var p1 = document.getElementById("p1").value;
			// alert(p1);
			var p2 = document.getElementById("p2").value;
			
			// 获取到span对象
			var pwdSpan = document.getElementById("pwdSpan");
			
			if(p1 !== p2){
				pwdSpan.innerHTML="<font color='red'>两次密码不一致, 请重新输入</font>";
			} else {
				pwdSpan.innerHTML="<font color='green'>√</font>";
			}
		}
	</script>

</head>
<body>
	<h1> 修改页面 </h1>
	
	<hr>
	
	<c:if test="${updateMsg == null }">
		${updateMsg }
	</c:if>
	
	<c:if test="${empty updateMsg }">
		<form action="${pageContext.request.contextPath }/saveUpdateServlet" method="post" onsubmit="">
		<div id="box">
			I D:<input type="text" name="id" class="put" value="${emp.id }" disabled="disabled">
			<input type="hidden" name="id" value="${emp.id }">
			</div>
			<P/>
			<div id="box1">
			用户名:<input type="text" name="name" class="put" maxlength="14" value="${emp.name }" required="required"/>
			 <div class="pwdyhm">
			<span style="color:red">${msg }</span>
			</div>
			</div>
			<P/>
			密 码:<input type="password" id="p1" name="password" class="put" placeholder="密码" maxlength="6" required="required"/>
			<div class="pwdSpan1">
			<span id="pwdSpan"></span>
			</div>
			<P/>
			<div id="box2">
			确认密码:<input type="password" id="p2" name="password2" placeholder="确认密码" class="put" maxlength="6" onblur="checkPwd()" required="required"/>
			</div>
			<P/>
			性 别:<input type="radio" name="gender" value="女" <c:if test="${emp.gender=='f' }">checked="checked"</c:if>>女 &emsp;&emsp;
				<input type="radio" name="gender" value="0" checked <c:if test="${emp.gender=='m' }">checked="checked"</c:if>>男
			<P/>
			年 龄:<input type="number" name="age" class="put" value="${emp.age }" required="required">
			<P/>
			<div id="box3">
			入职日期:<input type="date" name="hiredate" class="put" value="${emp.hiredate }" required="required"/>
			</div>
			<P/>
			工 薪:<input type="text" name="salary" class="put" value="${emp.salary }" required="required"/>
			<P/>
			电 话:<input type="text" name="phone" class="put" maxlength="11" value="${emp.phone }" required="required"/>
			<P/>
			邮 箱:<input type="email" name="email" class="put" value="${emp.email }" required="required"/>
			
			<br>
			<br>
			<input type="submit" value="保存修改" id="pt">
			<p/>
			
			<a href="${pageContext.request.contextPath }/listEmpServlet"><input type="button" id="pt" value="返 &emsp;&emsp;回"></a>
			
		
		</form>
	</c:if>

</body>
</html>
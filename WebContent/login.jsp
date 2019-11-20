<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	body {
		text-align: center;
	}

	hr {
		width: 80%;
	}
	img{
		cursor: pointer;
	}
	#yzmimage{
		margin-left: 150px;
		margin-top: -30px;
		font-size: 18px;
		height:25px;
		width:300px;
	}
	a {
		text-decoration: none;
		color: black;
	}
	#pt{
		width:150px;
		height: 30px;
		font-size: 20px;
		border-radius: 10px ;
	}
	.put{
		height:25px;
		border-radius: 0 10px 10px 0;
		margin-top: 10px;
	}
	.put1{
		height:25px;
		border-radius:  10px;
		width:120px;
		margin-left: -30px
	}
	#lgbox{
		width: 400px;
		height: 330px;
		position:relative;
		right: -50%;
		background-color: #FFE4E1;
		margin: 0 px;
		border-radius: 10px;
		margin-top: 90px;
		
	}
	
</style>
<script type="text/javascript">
	function changeImg(){
		var validateImg=document.getElementById("validateImg");
		validateImg.src = "${pageContext.request.contextPath }/validateImgServlet?time=" + new Date();
	}
	//获取到xhr
	var xhr = new XMLHttpRequest();
	 function checkName(){
		 //获取到请求参数值
		 var name = document.getElementById("name").value;
		 //设置请求
		 xhr.open("POST","/empSys/XhrServlet",true);
		 //设置状态事件
		 xhr.onreadystatechange = function(){
			 if(xhr.readyState == 4 && xhr.status == 200){
				 var str = xhr.responseText;
				 //获取到span对象
				 var nameSpan = document.getElementById("nameSpan");
				 
				 if(str == 1){
					 nameSpan.innerHTML="<font color='green'>√</font>"
				 }else{
					 nameSpan.innerHTML="<font color='red'>该用户不存在</font>"
				 }
			 }
		 }
		 //设置响应消息
		 xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		 //发送请求
		 xhr.send("name=" + name);
	 }
	
</script>

</head>
<body>
	<h1>登录页面</h1>
	<hr>
	<div id="lgbox">
	<form action="${pageContext.request.contextPath }/loginServlet" method="post">

		用户名: <input type="text" name="name" id="name" class= "put" placeholder="员工姓名"  required="required" onblur="checkName()"/> <br><br>

		密&emsp;码: <input type="password" name="password" id="password" class= "put" placeholder="密码" required="required" />
		<br><br>
		 <input type="text" name="validateCode" placeholder="验证码" id="yzm" class= "put1" required="required">
		<div id="yzmimage">
		<img alt="验证码" src="${pageContext.request.contextPath }/validateImgServlet" id="validateImg" onclick="changeImg()">
		<br>
		<span style="color:red">${validateMsg }</span>
		</div>
		<br> 
		 <span style="color: red" id="nameSpan">${msg }</span>
		<br> 
		<input type="submit" id="pt" value="登 &emsp;录" /><br><br>
		<a href="${pageContext.request.contextPath }/index.jsp"><input type="button" id="pt" value="返 &emsp;回"></a><br><br>
		<a href="${pageContext.request.contextPath }/doSubmitServlet"><input type="button" id="pt" value="还没有注册"></a>
	</form>
	</div>
</body>
</html>
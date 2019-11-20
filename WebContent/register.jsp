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

form {
	text-align: center;
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

.put {
	height: 25px;
	border-radius: 0 10px 10px 0;
	margin-top: 1px;
}

#box1 {
	margin-left: -12px;
}

.box2 {
	margin-right: 30px;
}

#box3 {
	margin-left: -5px;
	height: 25px;
}
#box{
	width: 450px;
	height: 660px;
	position:relative;
	right: -52%;
	background-color: #FFE4E1;
	margin: 0 px;
	border-radius: 10px;
	margin-top: 20px;
}
.pwdSpan1{
	margin-left: 330px;
	height: 30px;
	width: 120px;
	margin-top: -48px;
	
}
.pwdyhm{
	margin-left: 340px;
	height: 30px;
	width: 120px;
	margin-top: -32px;
}
</style>

<script type="text/javascript">
	function checkPwd() {
		var p1 = document.getElementById("p1").value;
		
		var p2 = document.getElementById("p2").value;

		// 获取到span对象
		var pwdSpan = document.getElementById("pwdSpan");
		
		if (p1 !== p2) {
			pwdSpan.innerHTML = "<font color='red'>两次密码不一致, 请重新输入</font>";
		} else if(p1=="" && p2==""){
			pwdSpan.innerHTML = "<font color='red'>密码不能为空,请输入密码</font>";
		}else{
			pwdSpan.innerHTML = "<font color='green'>√</font>";
		}
	}
	//当获取到焦点的时候,信息提示
	function checkusernamemsg() {
		//获取到span控件
	var spanName = document.getElementById("spanName");
		spanName.innerHTML = "<font color ='bule'>请输入2到6个字符的汉字用户名<font/>";
	}
	
	//当空件失去焦点的时候,对输入的内容进行校验
	function checkusername() {
		var usernameEle = document.getElementById("username");
		var usernameValue = usernameEle.value;
		
		var spanName =document.getElementById("spanName");
		var reg= /[\u4e00-\u9fa5]/;
		var flag = reg.test(usernameValue);
		var len = usernameValue.length;
		
		var flangLen=true;
		if (len>=2) {
			flangLen = true;
		}else {
			flangLen = false;
		}
		if (flag && flangLen) {
			spanName.innerHTML="<font color='green'>√</font>"
		}else{
			spanName.innerHTML="<font color='red'>用户名非法,请检查后输入</font>"
			
		}
	}
</script>

</head>
<body>
	<h1>注册页面</h1>

	<hr>
	<div id="box">
		<form action="${pageContext.request.contextPath }/registerServlet"
			method="post" onsubmit="">
			<div id="box1">
				用户名:<input type="text" id="username" name="name" class="put" maxlength="6" placeholder="员工姓名"  onclick="checkusernamemsg()" onblur="checkusername()" required="required"/> 
				 <div  class="pwdyhm">
				 <span id="spanName" style="color: red" >${msg }</span>
				 </div>
			</div>
			<!-- 通过隐藏控件发送token -->
			<input style="color:red" type="hidden" name="token" value="${token_in_request }"> 
			<p /><p />
			密 码:<input type="password" id="p1" name="password" class="put" placeholder="密码" maxlength="6" required="required" />
			 <div class="pwdSpan1">
			 <span id="pwdSpan"></span>
			 </div>
			<p />
			<div class="box2">
			确认密码:<input type="password" id="p2" name="password2" class="put" placeholder="确认密码" maxlength="6" onblur="checkPwd()"required="required" />
			</div>
			<p />
			性 别:<input type="radio" name="gender" value="女">女&emsp;&emsp; 
			<input type="radio" name="gender" value="男" checked>男
			<p />
			年 龄:<input type="number" name="age" class="put" required="required">
			<p />
			<div id="box3">
				入职日期:<input type="date" name="hiredate" class="put"required="required" />
			</div>
			<p /><p />
			工 薪:<input type="text" name="salary" class="put" />
			<p />
			电 话:<input type="text" name="phone" class="put" maxlength="11"required="required">
			<p />
			邮 箱:<input type="email" name="email" class="put" required="required" />

			<br> <br>
			<input type="submit" value="注&emsp; &emsp; 册"id="pt"> <br>
			<br> 
			<input type="reset" value="重&emsp; &emsp; 置" id="pt">
			<br>
			<br>
			<a href="${pageContext.request.contextPath }/index.jsp"><input type="button" id="pt" value="返 &emsp;&emsp;回"></a>
				
			<br>
			<br>
			${tokenMsg }
			
		</form>
	</div>
</body>
</html>
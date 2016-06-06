<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/lib/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#btnUseless").click(function() {
			var name = $("#username").val();		
			var password = $("#pwd").val();			

			if (name != "" && password != "") {
				var url = "${pageContext.request.contextPath}/web/login";
				var args = {
					"name" : name,
					"password" : password
				};

				$.post(url, args, function(data) {
					
					if (data.result==1) {
						
					window.location.href="${pageContext.request.contextPath}/web/test";

					} else {
						alert("账号密码不存在，请重新登录！");
						return false;
					}
				},"json");
			} else {
				alert("账号密码不能为空！");
				return false;
			}

		});
		//	return true;
		$("#btn").click(function() {
			//alert("haha");
			var name = $("#username").val();		
			var password = $("#pwd").val();	
			var studentData={
					"name" : name,
					"password" : password
			}
			$.ajax({
				type : "POST",
				url : "${pageContext.request.contextPath}/web/login",
				dataType : "json",
				contentType:"application/json", 
			    data:JSON.stringify(studentData),
				success : function(data) {
					if (data.result!=null) {
						
						window.location.href="${pageContext.request.contextPath}/web/test";

						} else {
							alert("账号密码不存在，请重新登录！");
							return false;
						}
				},
				error : function(data) {
					alert(data.msg);
				}
			});
		});		
	});
</script>
</head>
<body>
	<div
		style="width: auto; height: 500px; text-align: center; padding-top: 200px;">
		<form action="" method="post">
			NI用户名：<input id="username" type="text" name="username"><br>
			<br> 密码：<input id="pwd" type="password" name="pwd"><br>
			<br> <input id="btn" type="button" value="登录"> <input
				type="reset" value="重置">
		</form>
	</div>
</body>
</html>
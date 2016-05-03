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
		$("#btn").click(function() {
			var name = $("#name").val();		
			var password = $("#password").val();			

			if (name != "" && password != "") {
				var url = "${pageContext.request.contextPath}/web/login";
				var args = {
					"name" : name,
					"password" : password					
				};

				$.post(url, args, function(data) {
					
					if (data.result!=null) {
						
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

	});
</script>
</head>
<body>
	<div
		style="width: auto; height: 500px; text-align: center; padding-top: 200px;">
		<form action="" method="post">
			用户名：<input id="name" type="text" name="name"><br>
			<br> 密码：<input id="password" type="password" name="password"><br>
			<br> <input id="btn" type="button" value="登录"> <input
				type="reset" value="重置">
		</form>
	</div>
</body>
</html>
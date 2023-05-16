<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng ký tài khoản</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js" integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz" crossorigin="anonymous"></script>
<style type="text/css">
	.red {
		color: red;
	}
</style>
</head>
<body>

	<%@include file="../header.jsp" %>
	<%
		String errorMsg = request.getAttribute("error") + "";
		String username = request.getAttribute("username") + "";
		String fullName = request.getAttribute("fullName") + "";
		String birthdate = request.getAttribute("birthdate") + "";
		String gender = request.getAttribute("gender")+"";
		String address = request.getAttribute("address") + "";
		String orderAddress = request.getAttribute("orderAddress") + "";
		String deliveryAddress = request.getAttribute("deliveryAddress") + "";
		String sdt = request.getAttribute("sdt") + "";
		String email = request.getAttribute("email") + "";
		String getMessage = request.getAttribute("getMessage") + "";
		
		errorMsg = (!errorMsg.equals("null")) ? errorMsg : "";
		username = (!username.equals("null")) ? username : "";
		fullName = (!fullName.equals("null")) ? fullName : "";
		birthdate = (!birthdate.equals("null")) ? birthdate : "";
		gender = (!gender.equals("null")) ? gender : "";
		address = (!address.equals("null")) ? address : "";
		orderAddress = (!orderAddress.equals("null")) ? orderAddress : "";
		deliveryAddress = (!deliveryAddress.equals("null")) ? deliveryAddress : "";
		sdt = (!sdt.equals("null")) ? sdt : "";
		email = (!email.equals("null")) ? email : "";
		getMessage = (!getMessage.equals("null")) ? getMessage : "";
		boolean msg = Boolean.valueOf(getMessage);
		
	%>
	<div class="container">
		<h1 class="text-center mt-4">Đăng ký tài khoản</h1>
		<div class="red" id="error"><%= errorMsg %></div>
		<%
			String newUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
		%>
		<form action="<%= newUrl %>/customer-controller" method="post">
			<input type="hidden" name="action" value="sign-up">
		<div class="row">
			<div class="col-sm-6">
				<h3>Thông tin tài khoản</h3>
				<div class="mb-3">
					<label for="username" class="form-label">Tên đăng nhập</label><span class="red">*</span>
				    <input type="text" class="form-control" id="username" name="username" required="required" value="<%= username %>">
				</div>
			 	<div class="mb-3">
				    <label for="password" class="form-label">Mật khẩu</label><span class="red">*</span>
				    <input type="password" class="form-control" id="password" name="password" required="required" onkeyup="checkPassword()">
				</div>
				<div class="mb-3">
				    <label for="rePassword" class="form-label">Nhập lại mật khẩu</label><span class="red">*</span><span class="red" id="msg"></span>
				    <input type="password" class="form-control" id="rePassword" name="rePassword" required="required" onkeyup="checkPassword()">
				</div>
				<h3>Thông tin khách hàng</h3>
				<div class="mb-3">
					<label for="fullName" class="form-label">Họ và tên</label><span class="red">*</span>
				    <input type="text" class="form-control" id="fullName" name="fullName" value="<%= fullName %>" required>
				</div>
				<div class="mb-3">
					<label for="birthdate" class="form-label">Ngày sinh</label>
				    <input type="date" class="form-control" id="birthdate" name="birthdate" value="<%= birthdate %>">
				</div>
				<label for="birthdate" class="form-label">Giới tính</label>
				<select class="mb-3 form-control" id="gender" name="gender">
					<option>Chọn một giới tính</option>
					<option value="Nam" <%= (gender.equals("Nam"))?"selected='selected'":"" %>>Nam</option>
					<option value="Nữ" <%= (gender.equals("Nữ"))?"selected='selected'":"" %>>Nữ</option>
					<option value="Khác" <%= (gender.equals("Khác"))?"selected='selected'"	:"" %>>Khác</option>
				</select>
			</div>
			<div class="col-sm-6">
				<h3>Địa chỉ</h3>
				<div class="mb-3">
					<label for="address" class="form-label">Địa chỉ</label>
				    <input type="text" class="form-control" id="address" name="address" value="<%= address %>">
				</div>
				<div class="mb-3">
					<label for="orderAddress" class="form-label">Nơi đặt hàng</label>
				    <input type="text" class="form-control" id="orderAddress" name="orderAddress" value="<%= orderAddress %>">
				</div>
				<div class="mb-3">
					<label for="deliveryAddress" class="form-label">Nơi nhận hàng</label><span class="red">*</span>
				    <input type="text" class="form-control" id="deliveryAddress" name="deliveryAddress" value="<%= deliveryAddress %>" required>
				</div>
				<div class="mb-3">
					<label for="sdt" class="form-label">Số điện thoại</label><span class="red">*</span>
				    <input type="text" class="form-control" id="sdt" name="sdt" required="required" value="<%= sdt %>">
				</div>
				<div class="mb-3">
					<label for="email" class="form-label">Email</label><span class="red">*</span>
				    <input type="email" class="form-control" id="email" name="email" value="<%= email %>" required>
				</div>
				<div class="mb-3">
					<label for="getMessage" class="form-label">Đăng ký nhận email</label>
				    <input type="checkbox" id="getMessage" name="getMessage" <%= msg?"checked":"" %>>
				</div>	
				<div class="mb-3">
					<label for="agreeRule" class="form-label">Đồng ý với <a href="http://google.com">các điều khoản</a></label><span class="red">*</span>
				    <input class="form-check-input" type="checkbox" id="agreeRule" name="agreeRule" required="required" onchange="checkAgreeRule()">
				</div>				
			</div>
		</div>
		<input type="submit" class="btn btn-primary form-control" value="Đăng ký" id="registerBtn" name="registerBtn" style="visibility: hidden">
		</form>
	</div>
	<jsp:include page="../footer.jsp" />
</body>
<script>
	function checkPassword() {
		pwd = document.getElementById("password").value;
		rePwd = document.getElementById("rePassword").value;
		
		if(pwd != rePwd) {
			document.getElementById("msg").innerHTML = "Mật khẩu không khớp";
			return false;
		} else {
			document.getElementById("msg").innerHTML = "";
			return true;
		}
	}
	
	function checkAgreeRule() {
		agreeRule = document.getElementById("agreeRule");
		if (agreeRule.checked == true) {
			document.getElementById("registerBtn").style.visibility = "visible";
		} else {

			document.getElementById("registerBtn").style.visibility = "hidden";
		}
	}
</script>
</html>
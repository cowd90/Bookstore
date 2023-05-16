<%@page import="model.KhachHang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thay Đổi Thông Tin</title>
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
	<jsp:include page="../header.jsp" />
	<%
		Object obj = session.getAttribute("khachHang");
		KhachHang kh = null;
		
		if (obj != null) {
			kh = (KhachHang) obj;
		}
		
		if (kh == null) {
	%>
		<h1>Vui lòng đăng nhập!</h1>
	<% } else { %>
	<div class="container">
	<%
		String msg = request.getAttribute("msg") + "";
		msg = msg.equals("null")?"":msg;
		
		String fullName = kh.getTenKH();
		String dob = "";
		try {
			dob = kh.getNgaySinh().toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		String gender = kh.getGioiTinh();
		String address = kh.getDiaChi();
		String orderAddress = kh.getDiaChiMuaHang();
		String deliveryAddress = kh.getDiaChiNhanHang();
		String sdt = kh.getSdt();
		String email = kh.getEmail();
		boolean getMessage = kh.isDangKyNhanBangTin();
		
	%>
		<h1 class="text-center mt-4">Thay đổi thông tin tài khoản</h1>
		<%= msg %>
		<%
			String newUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
		%>
		<form action="<%= newUrl %>/customer-controller" method="post">
			<input type="hidden" name="action" value="change-customer-infor">
		<div class="row">
			<div class="col-sm-6">
				<h3>Thông tin khách hàng</h3>
				<div class="mb-3">
					<label for="fullName" class="form-label">Họ và tên</label>
				    <input type="text" class="form-control" id="fullName" name="fullName" value="<%= fullName %>">
				</div>
				<div class="mb-3">
					<label for="birthdate" class="form-label">Ngày sinh</label>
				    <input type="date" class="form-control" id="birthdate" name="birthdate" value="<%= dob %>">
				</div>
				<div class="mb-3">
					<label for="gender" class="form-label">Giới tính</label>
					<select class="form-control" id="gender" name="gender">
						<option></option>
						<option value="Nam" <%= (gender.equals("Nam"))?"selected='selected'":"" %>>Nam</option>
						<option value="Nữ" <%= (gender.equals("Nữ"))?"selected='selected'":"" %>>Nữ</option>
						<option value="Khác" <%= (gender.equals("Khác"))?"selected='selected'":"" %>>Khác</option>
					</select>
				</div>
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
					<label for="deliveryAddress" class="form-label">Nơi nhận hàng</label>
				    <input type="text" class="form-control" id="deliveryAddress" name="deliveryAddress" value="<%= deliveryAddress %>">
				</div>
				<div class="mb-3">
					<label for="sdt" class="form-label">Số điện thoại</label>
				    <input type="text" class="form-control" id="sdt" name="sdt" required="required" value="<%= sdt %>">
				</div>
				<div class="mb-3">
					<label for="email" class="form-label">Email</label>
				    <input type="email" class="form-control" id="email" name="email" value="<%= email %>">
				</div>
				<div class="mb-3">
					<label for="getMessage" class="form-label">Đăng ký nhận email</label>
				    <input type="checkbox" class="form-check-input" id="getMessage" name="getMessage" <%= getMessage?"checked":"" %>>
				</div>			
			</div>
		</div>
		<input type="submit" class="btn btn-primary form-control" value="Lưu thông tin" id="saveInforChangeBtn" name="saveInforChangeBtn">
		</form>
		<% } %>
	</div>
	<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>
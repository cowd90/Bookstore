<%@page import="model.KhachHang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thay đổi mật khẩu</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js" integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz" crossorigin="anonymous"></script>
</head>
<body>
	<jsp:include page="../header.jsp" />
	<%
		Object obj = session.getAttribute("khachHang");
		KhachHang khachHang = null;
		
		if (obj != null) {
			khachHang = (KhachHang) obj;
		}
		
		if (khachHang == null) {
	%>
		<h1>Vui lòng đăng nhập để thực hiện chức năng!</h1>
	<% } else { 
				String msg = request.getAttribute("msg") + "";
				msg = (msg.equals("null")) ? "" : msg;
	%>
	<div class="container">
		<h3 class="mb-4 mt-4">Thay đổi mật khẩu</h3>
		<div style="color: red;"><%= msg %></div>
		<%
			String newUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
		%>
		<form action="<%= newUrl %>/customer-controller" method="post">
			<input type="hidden" name="action" value="change-pwd">
			<div class="mb-3">
				<label for="oldPassword" class="form-label">Mật khẩu cũ</label>
				<input type="password" class="form-control" id="oldPassword" name="oldPassword" required="required">
			</div>
			<div class="mb-3">
				<label for="newPassword" class="form-label">Mật khẩu mới</label>
				<input type="password" class="form-control" id="newPassword" name="newPassword" required="required">
			</div>
			<div class="mb-3">
				<label for="reNewPassword" class="form-label">Nhập lại mật khẩu mới</label>
				<input type="password" class="form-control" id="reNewPassword" name="reNewPassword" required="required">
			</div>
			<input class="btn btn-primary" type="submit" id="changePwdBtn" name="changePwdBtn" value="Đổi mật khẩu">
		</form>
	</div>
	<% } %>
	<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>
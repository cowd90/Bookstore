<%@page import="model.KhachHang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
%>
<nav class="navbar navbar-expand-lg bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" href="<%=url%>/index.jsp"> 
			<img src="<%=url%>/img/logo/bookstore-logo.png"
				alt="Book store logo" width="34">
			</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="<%=url%>/index.jsp">Trang chủ</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Combo
							giảm giá</a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" role="button"
						data-bs-toggle="dropdown" aria-expanded="false"> Thể loại </a>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item" href="#">Phiêu lưu</a></li>
							<li><a class="dropdown-item" href="#">Tình yêu</a></li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item" href="#">Khác</a></li>
						</ul></li>
				</ul>
				<form class="d-flex" role="search">
					<input class="form-control me-2" type="search"
						placeholder="Nội dung tìm kiếm" aria-label="Search">
					<button class="btn btn-outline-success" type="submit">Tìm</button>
					<% 
						Object obj = session.getAttribute("khachHang");
					 	KhachHang kh = null;
						if (obj != null) {
							kh = (KhachHang) obj;
						}
						if (kh == null) {
					%>
					<a class="btn btn-primary" style="white-space: nowrap; margin-left: 3em;" href="<%=url%>/customer/signin.jsp">Đăng nhập</a>
					<% } else { %>
					<div class="row text-center" style="margin-left: 3em">
						<div class="row" style="white-space: nowrap;"></div>
						<div class="row"></div>
					</div>
					<ul class="navbar-nav me-auto mb-2 mb-lg-0 bg-infor">
						<li class="nav-item dropdown dropstart"><a
							class="nav-link dropdown-toggle" href="#" role="button"
							data-bs-toggle="dropdown" aria-expanded="false">Hi, <b><%= kh.getTenKH() %></b></a>
							<ul class="dropdown-menu">
								<li><a class="dropdown-item" href="#">Thông báo</a></li>
								<li><a class="dropdown-item" href="#">Giỏ hàng</a></li>
								<li><a class="dropdown-item" href="<%=url%>/customer/ChangeInfor.jsp">Thay đổi thông tin</a></li>
								<li><a class="dropdown-item" href="<%=url%>/customer/ChangePassword.jsp">Đổi mật khẩu</a></li>
								<li><a class="dropdown-item" href="<%=url%>/customer-controller?action=sign-out">Đăng xuất</a></li>
							</ul>
						</li>
					</ul>
					<% } %>
				</form>
			</div>
		</div>
	</nav>
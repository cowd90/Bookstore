<%@page import="model.KhachHang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>The Scott Bookstore</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
	integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js"
	integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz"
	crossorigin="anonymous"></script>
</head>
<link rel="icon" type="image/png" href="img/logo/book-favicon.png">
<body>
	<!-- Navbar -->
	<%@include file="header.jsp"%>
	<!-- End Navbar -->

	<!-- Page content -->
	<div class="container mt-4">
		<div class="row">
			<!-- Menu left -->
			<%@include file="left-menu.jsp"%>
			<!-- End Menu left -->

			<!-- Slider and Products -->
			<div class="col-lg-9">
				<!-- Slider -->
				<div id="carouselExampleIndicators" class="carousel slide mb-4"
					data-bs-ride="true">
					<div class="carousel-indicators">
						<button type="button" data-bs-target="#carouselExampleIndicators"
							data-bs-slide-to="0" class="active" aria-current="true"
							aria-label="Slide 1"></button>
						<button type="button" data-bs-target="#carouselExampleIndicators"
							data-bs-slide-to="1" aria-label="Slide 2"></button>
						<button type="button" data-bs-target="#carouselExampleIndicators"
							data-bs-slide-to="2" aria-label="Slide 3"></button>
					</div>
					<div class="carousel-inner">
						<div class="carousel-item active">
							<img src="img/slider/slider1.jpg" class="d-block w-100" alt="...">
						</div>
						<div class="carousel-item">
							<img src="img/slider/slider2.jpg" class="d-block w-100" alt="...">
						</div>
					</div>
					<button class="carousel-control-prev" type="button"
						data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
						<span class="carousel-control-prev-icon" aria-hidden="true"></span>
						<span class="visually-hidden">Previous</span>
					</button>
					<button class="carousel-control-next" type="button"
						data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
						<span class="carousel-control-next-icon" aria-hidden="true"></span>
						<span class="visually-hidden">Next</span>
					</button>
				</div>
				<!-- End Slider -->
				<!-- Products -->
				<div class="row">
					<div class="col-lg-4 col-md-6 mb-4">
						<div class="card h-100">
							<a href="#"><img class="card-img-top" src="img/product/1.jpg"
								alt=""></a>
							<div class="card-body">
								<h4 class="card-title">
									<a href="#">Tôi thấy hoa vàng trên cỏ xanh</a>
								</h4>
								<h5>87.000</h5>
								<p class="card-text"><i>Nguyễn Nhật Ánh</i></p>
							</div>
							<div class="card-footer">
								<small class="text-muted">&#9733; &#9733; &#9733;
									&#9733; &#9734;</small>
							</div>
						</div>
					</div>

					<div class="col-lg-4 col-md-6 mb-4">
						<div class="card h-100">
							<a href="#"><img class="card-img-top" src="img/product/2.jpg"
								alt="" ></a>
							<div class="card-body">
								<h4 class="card-title">
									<a href="#">Hoa hồng xứ khác</a>
								</h4>
								<h5>80.000</h5>
								<p class="card-text"><i>Nguyễn Nhật Ánh</i></p>
							</div>
							<div class="card-footer">
								<small class="text-muted">&#9733; &#9733; &#9733;
									&#9733; &#9734;</small>
							</div>
						</div>
					</div>


					<div class="col-lg-4 col-md-6 mb-4">
						<div class="card h-100">
							<a href="#"><img class="card-img-top" src="img/product/3.jpg"
								alt="" ></a>
							<div class="card-body">
								<h4 class="card-title">
									<a href="#">Có hai con mèo ngồi bên cửa sổ</a>
								</h4>
								<h5>75.000</h5>
								<p class="card-text"><i>Nguyễn Nhật Ánh</i></p>
							</div>
							<div class="card-footer">
								<small class="text-muted">&#9733; &#9733; &#9733;
									&#9733; &#9734;</small>
							</div>
						</div>
					</div>

					<div class="col-lg-4 col-md-6 mb-4">
						<div class="card h-100">
							<a href="#"><img class="card-img-top" src="img/product/4.jpg"
								alt="" ></a>
							<div class="card-body">
								<h4 class="card-title">
									<a href="#">Cô gái đến từ hôm qua</a>
								</h4>
								<h5>30.000</h5>
								<p class="card-text"><i>Nguyễn Nhật Ánh</i>.</p>
							</div>
							<div class="card-footer">
								<small class="text-muted">&#9733; &#9733; &#9733;
									&#9733; &#9734;</small>
							</div>
						</div>
					</div>
					<div class="col-lg-4 col-md-6 mb-4">
						<div class="card h-100">
							<a href="#"><img class="card-img-top" src="img/product/5.jpg"
								alt="" ></a>
							<div class="card-body">
								<h4 class="card-title">
									<a href="#">Đảo mộng mơ</a>
								</h4>
								<h5>129.000</h5>
								<p class="card-text"><i>Nguyễn Nhật Ánh</i>.</p>
							</div>
							<div class="card-footer">
								<small class="text-muted">&#9733; &#9733; &#9733;
									&#9733; &#9734;</small>
							</div>
						</div>
					</div>
					<div class="col-lg-4 col-md-6 mb-4">
						<div class="card h-100">
							<a href="#"><img class="card-img-top" src="img/product/6.jpg"
								alt="" ></a>
							<div class="card-body">
								<h4 class="card-title">
									<a href="#">Ngồi khóc trên cây</a>
								</h4>
								<h5>110.000</h5>
								<p class="card-text"><i>Nguyễn Nhật Ánh</i>.</p>
							</div>
							<div class="card-footer">
								<small class="text-muted">&#9733; &#9733; &#9733;
									&#9733; &#9734;</small>
							</div>
						</div>
					</div>
				</div>
				<!-- End Products -->
			</div>
			<!-- End Slider and Products -->
		</div>
	</div>
	<!-- End Page content -->

	<!-- Footer -->
	<%@include file="footer.jsp"%>
	<!-- End footer -->
	
	
	<div class="input-group mb-3">
	 
	  <div class="form-floating">
	    <input type="text" class="form-control" id="floatingInputGroup1" placeholder="Username">
	    <label for="floatingInputGroup1">Username</label>
	  </div>
	  
	   <span class="input-group-text">@gmail.com</span>
	</div>
</body>
</html>
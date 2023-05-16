CREATE DATABASE bookstore;

CREATE TABLE theloai (
	matheloai VARCHAR(255) NOT NULL,
	tentheloai NVARCHAR(255),
	PRIMARY KEY (matheloai)
);

CREATE TABLE tacgia (
	matacgia VARCHAR(255) NOT NULL,
	tentacgia NVARCHAR(255),
	ngaysinh DATE,
	tieusu TEXT,
	PRIMARY KEY (matacgia)
);

CREATE TABLE sanpham (
	masanpham VARCHAR(255) NOT NULL,
	tensanpham NVARCHAR(512),
	matacgia VARCHAR(255),
	namxuatban INT,
	gianhap DOUBLE,
	giagoc DOUBLE,
	giaban DOUBLE,
	soluong INT,
	matheloai VARCHAR(255),
	ngonngu VARCHAR(255),
	mota TEXT,
	PRIMARY KEY (masanpham),
	FOREIGN KEY (matacgia) REFERENCES tacgia (matacgia)
);

CREATE TABLE khachhang (
	makhachhang VARCHAR(255) NOT NULL,
	tendangnhap VARCHAR(255),
	matkhau VARCHAR(255),
	tenkhachhang NVARCHAR(255),
	gioitinh NVARCHAR(50),
	diachi NVARCHAR(512),
	diachinhanhang NVARCHAR(512),
	diachimuahang NVARCHAR(512),
	ngaysinh DATE,
	sdt VARCHAR(50),
	email VARCHAR(255),
	dangkynhanbangtin BIT,
	maxacthuc VARCHAR(100),
	thoigianhieulucmaxacthuc TIMESTAMP,
	daxacthuc BIT,
	PRIMARY KEY (makhachhang)
);

CREATE TABLE hoadon (
	madonhang VARCHAR(255) NOT NULL,
	makh VARCHAR(255),
	diachimuahang NVARCHAR(512),
	diachinhanhang NVARCHAR(512),
	trangthai NVARCHAR(512),
	hinhthucthanhtoan NVARCHAR(512),
	sotiendathanhtoan DOUBLE,
	sotienconthieu DOUBLE,
	ngaydathang DATE,
	ngaygiaohang DATE,
	PRIMARY KEY (madonhang),
	FOREIGN KEY (makh) REFERENCES khachhang (makhachhang)
);

CREATE TABLE chitietdh (
	machitietdh VARCHAR(255) NOT NULL,
	madonhang VARCHAR(255),
	masp VARCHAR(255),
	soluong INT,
	giagoc DOUBLE,
	giamgia DOUBLE,
	giaban DOUBLE,
	vat DOUBLE,
	tongtien DOUBLE,
	PRIMARY KEY (machitietdh),
	FOREIGN KEY (madonhang) REFERENCES hoadon (madonhang)
);
create database DuanCoffee;
use DuanCoffee;
create table Loai(
	MaLoai nvarchar(7) primary key,
	TenLoai nvarchar(100),
);
select * from Loai
CREATE TABLE Ban(
    MaBan nvarchar(10) primary key,
	TrangThai bit 
);
create table SanPham(
    MaSP nvarchar(7) primary key,
	TenSP nvarchar(100),
	Gia DECIMAL(10, 2) ,
	MaLoai nvarchar(7) references Loai(MaLoai),
	MoTa nvarchar(150),
	HinhAnh VARBINARY(MAX) ,

);
CREATE TABLE KhachHang (
    MaKH nvarchar(10) PRIMARY KEY,
    TenKH NVARCHAR(50),
    SDT NVARCHAR(10),
	MaBan nvarchar(10) REFERENCES Ban(MaBan)
);
CREATE TABLE NhanVien(
    MaNV Nvarchar(7) primary key,
	MatKhau nvarchar(50),
	TenNV nvarchar(50) ,
	SDT nvarchar(10),
	DiaChi nvarchar(100),
	ChucVu bit,
	GioiTinh bit,
	Hinhanh VARBINARY(MAX)
);
CREATE TABLE HoaDon (
    MaHD nvarchar(7) PRIMARY KEY,
    MaKH nvarchar(10) REFERENCES KhachHang(MaKH),
	MaNV nvarchar(7) REFERENCES NhanVien(MaNV),
    NgayDonHang DATE,
	MaBan nvarchar(10) REFERENCES Ban(MaBan),
    ThanhTien DECIMAL(10, 2),
	TrangThai bit,
);
CREATE TABLE ChiTietHoaDon (
    MaHDCT int PRIMARY KEY identity(1,1),
    MaHD nvarchar(7) REFERENCES HoaDon(MaHD),
    MaSP nvarchar(7) REFERENCES SanPham(MaSP),
    SoLuong INT,
	GiaTien DECIMAL(10, 2),
);
--Thêm vào bảng Loại
insert into Loai values ('L010',N'Cà Phê');
insert into Loai values ('L123',N'Trà Sửa');
insert into Loai values ('L012',N'Nước ngọt');
-- Thêm vào bảng Bàn
insert into Ban values (N'Ban1',1);
insert into Ban values (N'Ban2',0);
insert into Ban values (N'Ban3',0);
insert into Ban values (N'Ban4',0);
insert into Ban values (N'Ban5',0);
insert into Ban values (N'Ban6',0);
insert into Ban values (N'Ban7',0);
insert into Ban values (N'Ban8',0);
insert into Ban values (N'Ban9',0);
insert into Ban values (N'Ban10',0);
insert into Ban values (N'Ban11',0);
insert into Ban values (N'Ban12',0);
insert into Ban values (N'Ban13',0);
insert into Ban values (N'Ban14',0);
insert into Ban values (N'Ban15',0);
--thêm vào bảng sản phẩm
insert into SanPham values ('SP001',N'Cà phê muối',30.0000,'L010',N'Cà phê đậm chất miền trung',CAST(N'H:\MonDuAnMau\BaiTap\DuAnCoffee\src\main\resources\Image\buttonmenu.png' AS VARBINARY(MAX)));
insert into SanPham values ('SP002',N'Cà Phê sữa đặc',20.0000,'L123',N'có vị ngọt của sữa',CAST(N'H:\MonDuAnMau\BaiTap\DuAnCoffee\src\main\resources\Image\icons8-coffee-96.png' AS VARBINARY(MAX)));
insert into SanPham values ('SP003',N'Trà sữa chân châu đường đen',25.0000,'L010',N'Trà sữa quá ngon',CAST(N'H:\MonDuAnMau\BaiTap\DuAnCoffee\src\main\resources\Image\parkseoJun.jpg' AS VARBINARY(MAX)));
insert into SanPham values ('SP004',N'Cocacola',12.0000,'L012',N'Cocacola không calo',CAST(N'H:\MonDuAnMau\BaiTap\DuAnCoffee\src\main\resources\Image\anhcoffeetrengoogle.png' AS VARBINARY(MAX)));
--thêm vào bảng khách hàng
insert into KhachHang values ('KH1',N'Nguyễn Văn A','0893738482','Ban1');
insert into KhachHang values ('KH2',N'Nguyễn Văn B','0345982845','Ban2');
insert into KhachHang values ('KH3',N'Nguyễn Văn C','0919247357','Ban3');
--thêm vào bảng nhân viên
insert into NhanVien values ('Quyetnv','1234',N'Nguyễn Văn Quyết','0345204733',N'Triệu phong, Quảng trị',1,1,CAST(N'H:\MonDuAnMau\BaiTap\DuAnCoffee\src\main\resources\Image\buttonmenu.png' AS VARBINARY(MAX)));
insert into NhanVien values ('Ducnv','1234',N'Bùi Minh Đức','099804652',N'Mỹ Đức,Quảng Bình',0,1,CAST(N'H:\MonDuAnMau\BaiTap\DuAnCoffee\src\main\resources\Image\buttonmenu.png' AS VARBINARY(MAX)));
insert into NhanVien values ('Trungpq','1234',N'Phạm Quốc Trung','0345204733',N'Tam kỲ , Quảng Nam',0,0,CAST(N'H:\MonDuAnMau\BaiTap\DuAnCoffee\src\main\resources\Image\buttonmenu.png' AS VARBINARY(MAX)));
--thêm vào bảng hóa đơn
insert into HoaDon values ('HD01','KH1','Ducnv','2023-08-08','Ban1',900000,1);
insert into HoaDon values ('HD02','KH2','Ducnv','2023-01-11','Ban2',200000,0);
insert into HoaDon values ('HD03','KH3','Quyetnv','2023-11-08','Ban3',900000,1);
--thêm vào bảng chi tiết hóa đơn
insert into ChiTietHoaDon values ('HD01','SP001',2,60000);
insert into ChiTietHoaDon values ('HD02','SP003',1,20000);
insert into ChiTietHoaDon values ('HD03','SP002',2,120000);
select * from NhanVien
--pro doanhthu theo năm
CREATE PROCEDURE Doanhthunam 
    @nam INT
AS
BEGIN
    SELECT sum(Thanhtien) as Doanhthunam
    FROM HoaDon	
    WHERE YEAR(NgayDonHang) = @nam;
END;
--------
select * from HoaDon
select COUNT(mahd) from HoaDon where YEAR(NgayDonHang) = '2023'
--proc tonghoadontheonam
CREATE PROCEDURE TonghoadonNam 
    @nam INT
AS
BEGIN
    SELECT COUNT(mahd) as TonghoadonNam
    FROM HoaDon
    WHERE YEAR(NgayDonHang) = @nam;
END;
exec TonghoadonNam 2021
--proc tongkhachhangtheoNam
CREATE PROCEDURE tongkhachhangtheoNam 
    @nam INT
AS
BEGIN
   select COUNT(KhachHang.MaKH) as Tongkhachhang
   from KhachHang inner join
   HoaDon on HoaDon.MaKH = KhachHang.MaKH
   where YEAR(NgayDonHang) = @nam 
END;
exec tongkhachhangtheoNam 2021
--------------------
--proc lọc theo ngày tháng năm
CREATE PROCEDURE TinhNgayThangNam 
    @ngay int ,@thang int , @nam INT
AS
BEGIN
   select COUNT(mahd) as tonghoadon,COUNT(KhachHang.MaKH) as tongkhachang,sum(ThanhTien) as tongdoanhthu from HoaDon
   inner join KhachHang on HoaDon.MaKH = KhachHang.MaKH
   where day(NgayDonHang) = @ngay
   and MONTH(NgayDonHang) =@thang
   and YEAR(NgayDonHang)= @nam
END;	
exec TinhNgayThangNam 08 ,08, 2023




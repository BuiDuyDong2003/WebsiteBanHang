<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<form  class="row" action="/khach-hang/update?id=${kh.id}" method="post">
    <div class="col-md-3">
        <label class="form-label">Mã</label>
        <input type="text" class="form-control" name="ma" value="${kh.ma}">
    </div>
    <div class="col-md-3">
        <label class="form-label">Họ</label>
        <input type="text" class="form-control" name="ho" value="${kh.ho}">
    </div>
    <div class="col-md-3">
        <label class="form-label">Tên Đệm</label>
        <input type="text" class="form-control" name="tenDem" value="${kh.tenDem}">
    </div>
    <div class="col-md-3">
        <label class="form-label">Tên</label>
        <input type="text" class="form-control" name="ten" value="${kh.ten}">
    </div>
    <p></p>
    <div class="col-md-3">
        <label class="form-label">Ngày Sinh</label>
        <input type="date" class="form-control" name="ngaySinh" value="${kh.ngaySinh}">
    </div>
    <div class="col-md-3">
        <label class="form-label">Số Điện Thoai</label>
        <input type="text" class="form-control" name="sdt" value="${kh.sdt}">
    </div>
    <div class="col-md-3">
        <label class="form-label">Địa Chỉ</label>
        <input type="text" class="form-control" name="diaChi" value="${kh.diaChi}">
    </div>
    <div class="col-md-3">
        <label class="form-label">Thành Phố</label>
        <input type="text" class="form-control" name="thanhPho" value="${kh.thanhPho}">
    </div>
    <p></p>
    <div class="col-md-3">
        <label class="form-label">Quốc Gia</label>
        <input type="text" class="form-control" name="quocGia" value="${kh.quocGia}">
    </div>
    <div class="col-md-3">
        <label class="form-label">Mật Khẩu</label>
        <input type="text" class="form-control" name="matKhau" value="${kh.matKhau}">
    </div>
    <div class="col-12" style="margin-top: 10px">
        <button class="btn btn-primary" type="submit">Update</button>
    </div>
</form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
        integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"
        integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD"
        crossorigin="anonymous"></script>
</body>
</html>

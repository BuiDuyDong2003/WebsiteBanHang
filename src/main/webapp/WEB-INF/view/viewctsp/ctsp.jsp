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
<form class="row" action="/chi-tiet-san-pham/add" method="post">
    <div class="col-md-3">
        <label class="form-label">Sản Phẩm</label>
        <select name="sanPham" class="form-select">
            <c:forEach items="${listSP}" var="sp">
                <option value="${sp.id}" ${ctsp.sanPham.ten == sp.ten ? "Selected":""}>${sp.ten}</option>
            </c:forEach>
        </select>
    </div>
    <div class="col-md-3">
        <label class="form-label">Màu Sắc</label>
        <select name="mauSac" class="form-select">
            <c:forEach items="${listMS}" var="ms">
                <option value="${ms.id}" ${ctsp.mauSac.ten == ms.ten ? "Selected":""}>${ms.ten}</option>
            </c:forEach>
        </select>
    </div>
    <div class="col-md-3">
        <label class="form-label">Dòng Sản Phẩm</label>
        <select name="dongSP" class="form-select">
            <c:forEach items="${listDSP}" var="dsp">
                <option value="${dsp.id}" ${ctsp.dongSP.ten == dsp.ten ? "Selected":""}>${dsp.ten}</option>
            </c:forEach>
        </select>
    </div>
    <p></p>

    <div class="col-md-3">
        <label class="form-label">Nhà Sản Xuất</label>
        <select name="nhaSanXuat" class="form-select">
            <c:forEach items="${listNSX}" var="nsx">
                <option value="${nsx.id}" ${ctsp.nhaSanXuat.ten == nsx.ten ? "Selected":""}>${nsx.ten}</option>
            </c:forEach>
        </select>
    </div>
    <div class="col-md-3">
        <label class="form-label">Mô Tả</label>
        <input type="text" class="form-control" name="moTa" value="${ctsp.moTa}">
    </div>
    <div class="col-md-3">
        <label class="form-label">Năm Bảo Hành</label>
        <input type="text" class="form-control" name="namBH" value="${ctsp.namBH}">
    </div>
    <p></p>

    <div class="col-md-3">
        <label class="form-label">Số Lượng Tồn</label>
        <input type="text" class="form-control" name="soLuong" value="${ctsp.soLuong}">
    </div>
    <div class="col-md-3">
        <label class="form-label">Giá Nhập</label>
        <input type="text" class="form-control" name="giaNhap" value="${ctsp.giaNhap}">
    </div>
    <div class="col-md-3">
        <label class="form-label">Giá Bán</label>
        <input type="text" class="form-control" name="giaBan" value="${ctsp.giaBan}">
    </div>
    <p></p>
    <div class="col-12" style="margin-top: 10px">
        <button class="btn btn-primary" type="submit">Add</button>
    </div>
</form>
<table class="table table-hover">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Sản Phẩm</th>
        <th scope="col">Màu Sắc</th>
        <th scope="col">Dòng Sản Phẩm</th>
        <th scope="col">Nhà Sản Xuât</th>
        <th scope="col">Mô Tả</th>
        <th scope="col">Năm BH</th>
        <th scope="col">Số Lượng Tồn</th>
        <th scope="col">Giá Nhập</th>
        <th scope="col">Giá Bán</th>
        <th scope="col-3">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listCTSP}" var="o" varStatus="i">
        <tr>
            <th>${i.index}</th>
            <th>${o.sanPham.ten}</th>
            <th>${o.mauSac.ten}</th>
            <th>${o.dongSP.ten}</th>
            <th>${o.nhaSanXuat.ten}</th>
            <th>${o.moTa}</th>
            <th>${o.namBH}</th>
            <th>${o.soLuong}</th>
            <th>${o.giaNhap}</th>
            <th>${o.giaBan}</th>
            <td>
                <button class="btn btn-outline-success"><a style="text-decoration: none"
                                                           href="/chi-tiet-san-pham/remove/${o.id}">Remove</a>
                </button>
                <button class="btn btn-outline-success"><a style="text-decoration: none"
                                                           href="/chi-tiet-san-pham/view-update/${o.id}">Update</a>
                </button>
                <button class="btn btn-outline-success"><a style="text-decoration: none"
                                                           href="/chi-tiet-san-pham/detail/${o.id}">Detail</a>
                </button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
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

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
<form  class="row" action="/dong-san-pham/add" method="post">
    <div class="col-md-3">
        <label class="form-label">Id</label>
        <input type="text" class="form-control" name="id" value="${dsp.id}" disabled>
    </div>
    <div class="col-md-3">
        <label class="form-label">Mã</label>
        <input type="text" class="form-control" name="ma" value="${dsp.ma}">
    </div>
    <div class="col-md-3">
        <label class="form-label">Tên</label>
        <input type="text" class="form-control" name="ten" value="${dsp.ten}">
    </div>
    <div class="col-12" style="margin-top: 10px">
        <button class="btn btn-primary" type="submit">Add</button>
    </div>
</form>
<table class="table table-hover">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Id</th>
        <th scope="col">Mã</th>
        <th scope="col">Tên</th>
        <th scope="col-3">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listDSP}" var="o" varStatus="i">
        <tr>
            <th>${i.index}</th>
            <th>${o.id}</th>
            <th>${o.ma}</th>
            <th>${o.ten}</th>
            <td>
                <button class="btn btn-outline-success"><a style="text-decoration: none"
                                                           href="/dong-san-pham/remove/${o.id}">Remove</a>
                </button>
                <button class="btn btn-outline-success"><a style="text-decoration: none"
                                                           href="/dong-san-pham/view-update/${o.id}">Update</a>
                </button>
                <button class="btn btn-outline-success"><a style="text-decoration: none"
                                                           href="/dong-san-pham/detail/${o.id}">Detail</a>
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

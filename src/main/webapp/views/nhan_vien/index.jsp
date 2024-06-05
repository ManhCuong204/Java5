<%@page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Document</title>
    <H2>Quản Lý Nhân Viên</H2>
</head>
<body>
<div>

</div>
<table class="table table-hover table-bordered">
    <thead class="table-primary">
    <tr>
        <th>ID</th>
        <th>Ten</th>
        <th>Ma</th>
        <th>Ten dang nhap</th>
        <th>Mat khau</th>
        <th>Trang thai</th>
        <th colspan="2">Thao tac</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${ds}" var="nv">
        <tr>
            <td>${nv.id}</td>
            <td>${nv.ten}</td>
            <td>${nv.ma}</td>
            <td>${nv.tenDN}</td>
            <td>${nv.MK}</td>
            <td>${nv.trangThai == 1?"Dang hoat dong" :"Ngung hoat dong"}</td>
            <td>
                <a href="/nhan-vien/delete/${nv.id}" class="btn btn-danger"> Delete</a>
            </td>
            <td>
                <a href="/nhan-vien/edit/${nv.id}" class="btn btn-warning"> update</a>
            </td>

        </tr>
    </c:forEach>

    </tbody>
</table>
<button><a href="/nhan-vien/create" class="btn btn-success" >Thêm</a></button>
<button><a href="/trang-chu">
    <button class="btn btn-primary">Trở về</button>
</a></button>
</body>
</html>
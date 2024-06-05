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
    <h2>Quản Lý Khách Hàng</h2>
</head>
<body>
    <table class="table table-hover table-bordered">
        <thead class="table-primary">
        <tr>
            <th>ID</th>
            <th>Ma</th>
            <th>Ten</th>
            <th>SDT</th>
            <th>Trang thai</th>
            <th colspan="2">Thao tac</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items = "${ds}" var="kh">
            <tr>
                <td>${kh.id}</td>
                <td>${kh.ma}</td>
                <td>${kh.ten}</td>
                <td>${kh.sdt}</td>
                <td>${kh.trangThai ==1 ?"Dang hoat dong" :"Dung hoat dong"}</td>
                <td>
                    <a href="/khach-hang/delete/${kh.id}" class="btn btn-success" >Delete</a>
                </td>
                <td>
                    <a href="/khach-hang/edit/${kh.id}" class="btn btn-warning">Update</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <button><a href="/khach-hang/create" class="btn btn-success" >Thêm</a></button>
    <button><a href="/trang-chu">
        <button class="btn btn-primary">Trở về</button>
    </a></button>
</body>
</html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="jakarta.tags.core" prefix="c" %>

<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
</head>
<body>
<h1>Bảng chi tiết sản phẩm</h1>
<a href="/ct-san-pham/create">
    <button class="btn btn-success">Thêm</button>
</a>
<form action="/ct-san-pham/index" method="get">
    <label> Sản phẩm </label>
    <select class="form-select" aria-label="Default select example" name="idSP" >
        <c:forEach items="${listSP}" var="sp">
            <option value="${sp.id}">${sp.ma}</option>
        </c:forEach>
    </select>
    <button type="submit" class="btn btn-success">Lọc</button>
</form>
<table class="table table-hover">
    <thead>
    <th>ID</th>
    <th>Mã chi tiết</th>
    <th>ID kích thước</th>
    <th>ID Màu sắc</th>
    <th>ID Sản phẩm</th>
    <th>Số lượng</th>
    <th>Đơn giá</th>
    <th>Trạng thái</th>
    </thead>
    <tbody>
    <c:forEach items="${ listCTSP }" var="ctsp">
        <tr>
            <td>${ctsp.id}</td>
            <td>${ ctsp.maSPCT }</td>
            <td>${ ctsp.idKT }</td>
            <td>${ ctsp.idMS }</td>
            <td>${ ctsp.tenSP }</td>
            <td>${ ctsp.soLuong }</td>
            <td>${ ctsp.donGia }</td>
            <td>
                    ${ ctsp.trangThai == 1 ?"Hoạt động" :"không hoạt động"}
            </td>
            <td>
                <a href="/ct-san-pham/edit/${ ctsp.id }">
                    <button class="btn btn-primary">Update</button>
                </a>
                <a href="/ct-san-pham/delete/${ ctsp.id }">
                    <button class="btn btn-warning">Delete</button>
                </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="/san-pham/index">
    <button class="btn btn-primary">Trở về</button>
</a>
</body>
</html>

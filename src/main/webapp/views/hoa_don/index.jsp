<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Quản lý Hóa Đơn</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <h1 class="text-center">Quản lý Hóa Đơn</h1>
    <br/>
    <form action="/hoa-don/index" method="get">
        <button type="submit" name="all" value="true" class="btn btn-secondary">Làm mới</button>
    </form>
    <a href="/hoa-don/create"><button class="btn btn-warning">Thêm</button></a>

    <table class="table table-hover table-bordered">
        <thead class="table-primary">
        <th>ID hóa đơn</th>
        <th>ID khách hàng</th>
        <th>ID nhân viên</th>
        <th>Ngày lập</th>
        <th>Trạng thái</th>
        <th>Thao tác</th>
        </thead>
        <tbody>
        <c:forEach items="${ds}" var="hd">
            <tr>
                <td>${hd.id}</td>
                <td>${hd.idKH}</td>
                <td>${hd.idNV}</td>
                <td>${hd.ngayMuaHang}</td>
                <td>${hd.trangThai == 1 ? "Đang hoạt động" : "Ngưng hoạt động"}</td>
                <td>
                    <a href="/hoa-don/edit/${hd.id}"><button class="btn btn-danger">Update</button></a>
                    <a href="/hoa-don/delete/${hd.id}"><button class="btn btn-warning">Delete</button></a>
                    <a href="/ct-hoa-don/index?idHD=${ hd.id }">
                        <button class="btn btn-dark">Chi tiết</button>
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <c:if test="${not empty message}">
        <div class="alert alert-warning message-alert" role="alert">
                ${message}
        </div>
    </c:if>

    <nav aria-label="Page navigation example">
        <ul class="pagination">
            <li class="page-item ${currentPage-1== 0 ? 'disabled' : ''}">
                <a class="page-link" href="?page=${currentPage - 1}&size=${size}&keyword=${keyword}">Previous</a>
            </li>
            <c:if test="${currentPage-1>0}">
                <li class="page-item ">
                    <a class="page-link" href="?page=${currentPage - 1}&size=${size}&keyword=${keyword}">${currentPage-1}</a>
                </li>
            </c:if>
            <li class="page-item active ">
                <a class="page-link" href="?page=${currentPage}&size=${size}&keyword=${keyword}">${currentPage}</a>
            </li>
            <c:if test="${currentPage + 1 <= totalPages}">
                <li class="page-item ">
                    <a class="page-link" href="?page=${currentPage + 1}&size=${size}&keyword=${keyword}">${currentPage+1}</a>
                </li>
            </c:if>
            <li class="page-item ${currentPage + 1 > totalPages ? 'disabled' : ''}">
                <a class="page-link" href="?page=${currentPage + 1}&size=${size}&keyword=${keyword}">Next</a>
            </li>
        </ul>
    </nav>
</div>
</body>
</html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="jakarta.tags.core" prefix="c" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
    <title>Quản lý Sản phẩm</title>
    <style>
        body {
            background-color: #f8f9fa;
            display: flex;
            justify-content: center;
            padding: 20px;
        }
        .container {
            background-color: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 1200px;
        }
        .table-hover tbody tr:hover {
            background-color: #f1f1f1;
        }
        .form-inline {
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        .form-inline .form-control {
            width: auto;
            margin-right: 10px;
        }
        .pagination {
            justify-content: center;
        }
        .message-alert {
            margin-top: 20px;
        }
    </style>
</head>
<body>
<div class="container">
    <div >
        <div>
            <a href="/san-pham/create" >Thêm</a>
        </div>
        <div><a href="/trang-chu">
            <button class="btn btn-primary">Trở về</button>
        </a></div>
    </div>

    <h1 class="text-center">Quản lý Sản phẩm</h1>
    <c:if test="${not empty errorDN}">
        <div class="alert alert-danger text-center">${errorDN}</div>
    </c:if>

    <div class="form-inline mb-4">
        <form action="/san-pham/index" method="get" class="d-flex">
            <input type="text" name="keyword" value="${keyword}" placeholder="Tìm kiếm sản phẩm" class="form-control"/>
            <button type="submit" class="btn btn-warning">Tìm kiếm</button>
        </form>
    </div>

    <table class="table table-hover table-bordered">
        <thead class="table-primary">
        <tr>
            <th>ID sản phẩm</th>
            <th>Mã sản phẩm</th>
            <th>Tên sản phẩm</th>
            <th>Trạng thái</th>
            <th>Thao tác</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${sp.content}" var="sp">
            <tr>
                <td>${sp.id}</td>
                <td>${sp.ma}</td>
                <td>${sp.ten}</td>
                <td>${sp.trangThai == 1 ? "Đang hoạt động" : "Ngưng hoạt động"}</td>
                <td>
                    <a href="/san-pham/edit/${sp.id}" class="btn btn-success btn-sm">Update</a>
                    <a href="/san-pham/delete/${sp.id}" class="btn btn-danger btn-sm">Delete</a>
                    <a href="/ct-san-pham/index?idSP=${sp.id}">
                        <button class="btn btn-dark btn-sm">Chi tiết</button>
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

<%--    <c:if test="${not empty message}">--%>
<%--        <div class="alert alert-warning message-alert" role="alert">--%>
<%--                ${message}--%>
<%--        </div>--%>
<%--    </c:if>--%>

<%--    <nav aria-label="Page navigation example">--%>
<%--        <ul class="pagination">--%>
<%--            <li class="page-item ${currentPage-1== 0 ? 'disabled' : ''}">--%>
<%--                <a class="page-link" href="?page=${currentPage - 1}&size=${size}&keyword=${keyword}">Previous</a>--%>
<%--            </li>--%>
<%--            <c:if test="${currentPage-1>0}">--%>
<%--                <li class="page-item ">--%>
<%--                    <a class="page-link" href="?page=${currentPage - 1}&size=${size}&keyword=${keyword}">${currentPage-1}</a>--%>
<%--                </li>--%>
<%--            </c:if>--%>
<%--            <li class="page-item active ">--%>
<%--                <a class="page-link" href="?page=${currentPage}&size=${size}&keyword=${keyword}">${currentPage}</a>--%>
<%--            </li>--%>
<%--            <c:if test="${currentPage + 1 <= totalPages}">--%>
<%--                <li class="page-item ">--%>
<%--                    <a class="page-link" href="?page=${currentPage + 1}&size=${size}&keyword=${keyword}">${currentPage+1}</a>--%>
<%--                </li>--%>
<%--            </c:if>--%>
<%--            <li class="page-item ${currentPage + 1 > totalPages ? 'disabled' : ''}">--%>
<%--                <a class="page-link" href="?page=${currentPage + 1}&size=${size}&keyword=${keyword}">Next</a>--%>
<%--            </li>--%>
<%--        </ul>--%>
<%--    </nav>--%>

<%--&lt;%&ndash;    <c:if test="${not empty erQuyen}">&ndash;%&gt;--%>
<%--&lt;%&ndash;        <div class="alert alert-danger text-center">${erQuyen}</div>&ndash;%&gt;--%>
<%--&lt;%&ndash;    </c:if>&ndash;%&gt;--%>
<%--</div>--%>
<%--</body>--%>
<%--</html>--%>
<div class="row">
    <!-- Previous Button -->
    <div class="col">
        <a   onclick="page(${currentPage - 1})"  class="btn ${currentPage == 1 ? 'disabled' : ''}" >Previous</a>
    </div>

    <!-- Page Numbers -->
    <div class="col">
        <ul class="pagination">
            <c:forEach begin="1" end="${totalPage}" var="page">
                <c:if test="${page == 1 || (page >= currentPage - 1 && page <= currentPage + 1) || page == totalPage}">
                    <li class="page-item ${page == currentPage ? 'active' : ''}">
                        <a  class="page-link"  href="?page=${page}">${page}</a>
                    </li>
                </c:if>
            </c:forEach>
        </ul>
    </div>

    <!-- Next Button -->
    <div class="col">
        <a   onclick="page(${currentPage + 1})"  class="btn ${currentPage == totalPage ? 'disabled' : ''}" >Next</a>
    </div>
</div>
<div class="row">
    <div class="col">
        <a class="btn btn-success "  href="/cua-hang/san-pham/create">Thêm Mới Sản Phẩm</a>
    </div>
</div>
</div>
</body>
</html>

<script>
    var links = document.getElementsByClassName("page-link");
    // Lặp qua từng liên kết và gắn sự kiện click
    for (var i = 0; i < links.length; i++) {
        links[i].addEventListener("click", function(event) {
            event.preventDefault(); // Ngăn chặn hành vi mặc định khi click vào liên kết

            var currentPage = window.location.href; // Lấy URL hiện tại
            var url = new URL(currentPage); // Tạo một đối tượng URL từ URL hiện tại

            // Thêm tham số page vào query string
            var params = new URLSearchParams(url.search);
            params.set('page', this.innerText); // Sử dụng nội dung của liên kết làm số trang

            // Cập nhật query string trong URL
            url.search = params.toString();

            // Chuyển hướng đến URL mới
            window.location.href = url.toString();
        });
    }
    function page(page) {
        var currentPage = window.location.href; // Lấy URL hiện tại
        var url = new URL(currentPage); // Tạo một đối tượng URL từ URL hiện tại

        // Thêm tham số page vào query string
        var params = new URLSearchParams(url.search);
        params.set('page', page); // Sử dụng nội dung của liên kết làm số trang
        console.log(page)
        // Cập nhật query string trong URL
        url.search = params.toString();

        // Chuyển hướng đến URL mới
        window.location.href = url.toString();
    }
</script>


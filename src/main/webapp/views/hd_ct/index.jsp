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
<h1>Bảng chi tiết hóa đơn</h1>
<%--<a href="/ct-hoa-don/create">--%>
<%--    <button class="btn btn-success">Thêm</button>--%>
<%--</a>--%>
<form action="/ct-hoa-don/index" method="get">
    <label> Hóa đơn </label>
    <select class="form-select" aria-label="Default select example" name="idHD" >
        <c:forEach items="${listHD}" var="hd">
            <option value="${hd.id}">${hd.id} , ${hd.ngayMuaHang}</option>
        </c:forEach>
    </select>
    <button type="submit" class="btn btn-success">Lọc</button>
</form>
<table class="table table-hover">
    <thead>
    <th>ID</th>
    <th>ID Hóa đơn</th>
    <th>ID Chi tiết sp</th>
    <th>Số lượng</th>
    <th>Đơn giá</th>
    <th>Thời gian</th>
    <th>Trạng thái</th>
    </thead>
    <tbody>

    <c:forEach items="${ listCTHD }" var="cthd">
        <tr>
            <td>${ cthd.id }</td>
            <td>${ cthd.idHD }</td>
            <td>${ cthd.idCTSP }</td>
            <td>${ cthd.sl }</td>
            <td>${ cthd.donGia }</td>
            <td>${ cthd.thoiGian }</td>
            <td><script>
                var tt = ${ cthd.trangThai }
                var st = tt == 1 ?"Hoạt động" :"không hoạt động"
                document.write(st);
            </script></td>
            <td>
                <a href="/ct-hoa-don/edit/${ cthd.id }">
                    <button class="btn btn-primary">Update</button>
                </a>
                <a href="/ct-hoa-don/delete/${ cthd.id }">
                    <button class="btn btn-warning">Delete</button>
                </a>
            </td>
        </tr>
    </c:forEach>
    <a href="/hoa-don/index">
        <button class="btn btn-primary">Trở lại</button>
    </a>
    </tbody>
</table>

</body>

</html>
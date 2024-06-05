<%--
  Created by IntelliJ IDEA.
  User: TAI LUU
  Date: 3/7/2024
  Time: 10:57 PM
  To change this template use File | Settings | File Templates.
--%>
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
<form action="/ct_hoa_don/update?id=${cthd.id}" method="Post" class="container" style="width: 50%">
    <div>
        <h1 style="text-align: center">Update chi tiết hóa đơn</h1>

        <div class="mt-4">
            <label> ID hóa đơn </label>
            <input type="text" name="idHD" class="form-control" value="${cthd.idHD}" readonly>
        </div>
        <div class="mt-4">
            <label> ID chi tiết sản phẩm </label>
            <select class="form-select" aria-label="Default select example" name="idctsp">
                <c:forEach items="${listCTSP}" var="ctsp">
                    <option value="${ctsp.id}" ${ctsp.id eq cthd.idCTSP ? "selected" : ""} ${ctsp.id eq idCTSP ? "selected" : ""}>${ctsp.id} </option>
                </c:forEach>
            </select>
        </div>
        <div class="mt-4">
            <label> Số lượng </label>
            <input type="text" name="sl" class="form-control"  value="${cthd.sl}">
            <span id="slError" style="color: #ff0000;"></span>
        </div>
        <div class="mt-4">
            <label> Thời gian </label>
            <input type="datetime-local" id="thoiGian" value="${cthd.thoiGian}" name="thoiGian" readonly class="form-control">
        </div>
        <div class="mt-4">
            <label> Đơn giá </label>
            <input type="text" name="donGia" class="form-control" value="${cthd.donGia}">

            <span id="donGiaError" style="color: red;"></span>
        </div>
        <div class="mt-4" style="display: flex">
            <label style="padding-right: 7px"> Trạng thái </label>
            <div class="form-check mx-3">
                <input class="form-check-input" type="radio" name="trangThai" id="flexRadioDefault1" value="1"
                ${cthd.trangThai == 1 ? "checked" : "" }  />
                <label class="form-check-label" for="flexRadioDefault1">
                    Hoạt động
                </label>
            </div>
            <div class="form-check mx-3">
                <input class="form-check-input" type="radio" name="trangThai" id="flexRadioDefault2" value="0"
                ${cthd.trangThai == 0 ? "checked" : "" }  />
                <label class="form-check-label" for="flexRadioDefault2">
                    Không hoạt động
                </label>
            </div>
        </div>
        <div class="mt-4">
            <button class="btn btn-primary">Sửa</button>
        </div>
    </div>
</form>
<div class="mt-4">
    <a href="/ct-hoa-don/index"> <button class="btn btn-primary">Trở lại</button></a>
</div>
</body>
<script>
    var currentDate = new Date();
    var formattedDate = currentDate.toISOString().slice(0, 16);
    document.getElementById('thoiGian').value = formattedDate;
</script>
</html>

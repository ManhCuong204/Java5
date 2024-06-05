<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Trang Chủ</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
</head>
<body>
<h1 >Trang chủ!</h1>
<br/>
<div class="text-align: center">
    <c:choose>
        <c:when test="${not empty sessionScope.tentk}">
            <c:choose>
                <c:when test="${sessionScope.quyentk == 1}">
                    <a href="/hoa-don/index" >Hóa đơn</a>
                </c:when>
                <c:otherwise>
                    <span >Hóa đơn (chỉ dành cho Admin)</span>
                </c:otherwise>
            </c:choose>
            <br/>
            <a href="/khach-hang/index" >Khách hàng</a>
            <br/>
            <a href="/kich-thuoc/index">Kích thước</a>
            <br/>
            <a href="/mau-sac/index" >Màu sắc</a>
            <br/>
            <a href="/nhan-vien/index" >Nhân viên</a>
            <br/>
            <a href="/san-pham/index" >Sản phẩm</a>
            <br/>
<%--            <a href="/ct-san-pham/index" >Chi tiết Sản phẩm</a>--%>
<%--            <br/>--%>
        </c:when>
        <c:otherwise>
            <a href="/login/formdn" class="btn btn-primary">Đăng nhập</a>
        </c:otherwise>
    </c:choose>
</div>
<c:if test="${param.error == 'accessDenied'}">
    <div class="alert alert-danger" role="alert">
    </div>
</c:if>
</body>
</html>
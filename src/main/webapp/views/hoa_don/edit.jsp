<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Chỉnh Sửa Hóa Đơn</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container mt-5">
    <h2>Sửa Hóa Đơn</h2>
    <form method="POST" action="/hoa-don/update/${hd.id}">
        <div class="mb-3">
            <label class="form-label"> ID Nhân Viên</label>
            <input type="text" name="idNV" value="${nv.ten}">
        </div>
        <div class="mb-3">
            <label class="form-label"> IDKhách Hàng</label>
            <input type="text" name="idKH" value="${kh.ten}">

        </div>
        <div class="mb-3">
            <label class="form-label">Ngày Mua Hàng</label>
            <input type="text" class="form-control" name="ngayMuaHang" value="${hd.ngayMuaHang}">
        </div>
        <div class="mb-3">
            <label class="form-label">Trạng Thái</label>
            <select class="form-control" name="trangThai">
                <option value="1" ${hd.trangThai == 1 ? 'selected' : ''}>Đang hoạt động</option>
                <option value="0" ${hd.trangThai == 0 ? 'selected' : ''}>Ngừng hoạt động</option>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Cập Nhật</button>
    </form>
</div>
</body>
</html>

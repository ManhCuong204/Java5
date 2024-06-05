<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
    <h2>Khach hang</h2>
<form method="post" action="/khach-hang/store">
    <div>
        <label class="form-label">Ma</label>
            <input type="text" name="ma">
    </div>
    <div>
        <label class="form-label">Ten</label>
            <input type="text" name="ten">
    </div>
    <div>
        <label class="form-label">SDT</label>
        <input type="number" name="sdt">
    </div>
    <div>
        <label class="form-label">Trang thai</label>
        <select name="trangThai">
            <option value="1">Dang hoat dong</option>
            <option value="0">Dung hoat dong</option>
        </select>
    </div>
    <div>
        <button>Luu</button>
    </div>

</form>
</body>
</html>
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
</head>
<body>
<H2>QLSP</H2>
<form method="POST" action="/san-pham/update/${sp.id}">
    <div class="mb-3">
        <label class="form-label">Ma</label>
        <input type="text"  name="ma" value="${sp.ma}" >
        <c:if  test="${not empty errors['ma']}">
            <small style="color: red">${errors['ma']}</small>

        </c:if>
    </div>
    <div class="mb-3">
        <label class="form-label">Ten</label>
        <input type="text" name="ten" value="${sp.ten}">
        <c:if  test="${not empty errors['ten']}">
            <small style="color: red">${errors['ten']}</small>

        </c:if>
    </div>
    <div class="mb-3">
        <label class="form-label">Trang Thai</label>
        <select name="trangThai" >
            <option value="1" ${sp.trangThai ==1? "selected": ""}
            >Dang hoat dong </option>
            <option value="0"
            ${sp.trangThai ==0? "selected": ""}>Dung hoat dong </option>
        </select>
    </div>
    <div>
        <button >Luu</button>
    </div>
</form>
</body>
</html>
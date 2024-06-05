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
<h2>Khach hang</h2>
<form method="post" action="/kich-thuoc/update/${ds.id}">
    <div>
        <label class="form-label">Ma</label>
        <input type="text" name="ma" value="${ds.ma}">
    </div>
    <div>
        <label class="form-label">Ten</label>
        <input type="text" name="ten" value="${ds.ten}">
    </div>
    <div>
        <label class="form-label">Trang thai</label>
        <select name="trangThai">
            <option value="1"
            ${ds.trangThai ==1? "selected": ""}
            >Dang hoat dong</option>
            <option value="0" ${ds.trangThai ==0? "selected": ""}>Dung hoat dong</option>
        </select>
    </div>
    <div>
        <button>Luu</button>
    </div>

</form>
</body>
</html>
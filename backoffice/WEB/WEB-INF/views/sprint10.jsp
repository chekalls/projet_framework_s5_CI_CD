<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h3>sprint 10</h3>
    <form action="${pageContext.request.contextPath}/sprint10" method="post" enctype="multipart/form-data">
        <input type="text" name="test" id="">
        <input type="file" name="myFile" id="">
        <input type="file" name="myFile1" id="">
        <input type="file" name="myFile2" id="">
        <input type="submit" value="envoyer">
    </form>
</body>
</html>
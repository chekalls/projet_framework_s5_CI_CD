<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.Map,java.nio.file.Path,mg.miniframework.modules.File" %>
<%
    Map<String,Object> data = (Map<String,Object>) request.getAttribute("data");
    Map<String,Object> requestData = (Map<String,Object>) data.get("requestData");
    Map<Path,File> filesMap = (Map<Path,File>) data.get("fileMap");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    file uploaded :
    <ul>
        <% for(Map.Entry<Path,File> file : filesMap.entrySet()) {%>
            <li><a href="${pageContext.request.contextPath}<%= file.getKey().toString() %>"><%= file.getValue().getAbsolutePath().toString() %></a></li>
        <% } %>
    </ul>

    request data:
    <ul>
        <% for (Map.Entry<String,Object> dataEntry : requestData.entrySet()) { %>
            <%= dataEntry.getKey() %>
        <% } %>
    </ul>

</body>
</html>
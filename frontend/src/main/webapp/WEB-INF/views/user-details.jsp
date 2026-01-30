<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Détails de l'utilisateur</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            max-width: 800px;
            margin: 50px auto;
            padding: 20px;
            background-color: #f5f5f5;
        }
        .container {
            background-color: white;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
        }
        h1 {
            color: #333;
        }
        .user-info {
            margin-top: 20px;
        }
        .info-row {
            display: flex;
            padding: 12px;
            border-bottom: 1px solid #eee;
        }
        .info-label {
            font-weight: bold;
            width: 150px;
            color: #555;
        }
        .info-value {
            color: #333;
        }
        .nav {
            margin-top: 20px;
        }
        .nav a {
            display: inline-block;
            margin-right: 10px;
            padding: 10px 20px;
            background-color: #007bff;
            color: white;
            text-decoration: none;
            border-radius: 4px;
        }
        .nav a:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Détails de l'utilisateur</h1>
        
        <div class="user-info">
            <div class="info-row">
                <div class="info-label">ID:</div>
                <div class="info-value">${user.id}</div>
            </div>
            <div class="info-row">
                <div class="info-label">Nom:</div>
                <div class="info-value">${user.name}</div>
            </div>
            <div class="info-row">
                <div class="info-label">Email:</div>
                <div class="info-value">${user.email}</div>
            </div>
        </div>
        
        <div class="nav">
            <a href="${pageContext.request.contextPath}/views/users">Retour à la liste</a>
            <a href="${pageContext.request.contextPath}/views/home">Accueil</a>
        </div>
    </div>
</body>
</html>

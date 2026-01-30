<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Accueil - Frontend</title>
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
        .nav {
            margin-top: 20px;
        }
        .nav a {
            display: inline-block;
            margin-right: 15px;
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
        <h1>${message}</h1>
        <p>Date et heure: ${date}</p>
        
        <div class="nav">
            <a href="${pageContext.request.contextPath}/views/users">Liste des utilisateurs</a>
            <a href="${pageContext.request.contextPath}/views/form">Nouveau utilisateur</a>
            <a href="${pageContext.request.contextPath}/views/about">À propos</a>
        </div>
    </div>
</body>
</html>

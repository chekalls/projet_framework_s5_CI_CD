<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>À propos</title>
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
        .info {
            margin-top: 20px;
            line-height: 1.6;
        }
        .info-item {
            padding: 10px;
            background-color: #f8f9fa;
            margin-bottom: 10px;
            border-radius: 4px;
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
        <h1>À propos de l'application</h1>
        
        <div class="info">
            <div class="info-item">
                <strong>Nom de l'application:</strong> ${appName}
            </div>
            <div class="info-item">
                <strong>Version:</strong> ${version}
            </div>
            <div class="info-item">
                <strong>Description:</strong> Application Spring Boot frontend avec support JSP
            </div>
            <div class="info-item">
                <strong>Technologie:</strong> Spring Boot (sans gestionnaire de dépendances)
            </div>
        </div>
        
        <div class="nav">
            <a href="${pageContext.request.contextPath}/views/home">Accueil</a>
            <a href="${pageContext.request.contextPath}/views/users">Liste des utilisateurs</a>
        </div>
    </div>
</body>
</html>

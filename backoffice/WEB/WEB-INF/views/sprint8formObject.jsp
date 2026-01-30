<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulaire Étudiant</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            padding: 20px;
        }

        form {
            max-width: 400px;
            margin: 0 auto;
            padding: 15px;
            border: 1px solid #ccc;
            border-radius: 8px;
            background-color: #f9f9f9;
        }

        label {
            display: block;
            margin-bottom: 10px;
        }

        /*
        label input {
            display: block;
            width: 100%;
            padding: 6px;
            margin-top: 4px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            padding: 8px 16px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }

        h2 {
            text-align: center;
        } */
    </style>
</head>

<body>
    <h1>ETU 3104</h1>
    <h2>Formulaire Étudiant</h2>
    <form action="${pageContext.request.contextPath}/sprint8ObjectPost" method="post">
        <label for="nom">
            Nom
            <input type="text" name="etudiant.nom" id="nom">
        </label>

        <label for="prenom">
            Prénom
            <input type="text" name="etudiant.prenom" id="prenom">
        </label>

        <label for="departement">
            Département
            <input type="text" name="departement.nom" id="departement">

        </label>

        <label for="etudiant_departement">
            etudiant departement :
            <input type="text" name="departement.etudiant[0].nom" id="">
            <input type="text" name="departement.etudiant[1].nom" id="">
        </label>

        <label>
            Matières
            <input type="text" name="departement.matieres[0]">
            <input type="text" name="departement.matieres[1]">
        </label>

        <input type="submit" value="Envoyer">
    </form>
</body>

</html>
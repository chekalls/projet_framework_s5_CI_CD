<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="entity.Etudiant" %>
<%@ page import="entity.Departement" %>
<%@ page import="java.util.ArrayList" %>
<%
    Etudiant etudiant = (Etudiant) request.getAttribute("etudiant");
    Departement departement = (Departement) request.getAttribute("departement");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Informations Étudiant</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            padding: 20px;
            background-color: #f5f5f5;
        }

        .container {
            max-width: 500px;
            margin: 0 auto;
            padding: 15px;
            border: 1px solid #ccc;
            border-radius: 8px;
            background-color: #fff;
        }

        h2 {
            text-align: center;
        }

        p {
            margin: 5px 0;
        }

        ul {
            padding-left: 20px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Informations Étudiant</h2>

        <% if (etudiant != null) { %>
            <p><strong>Nom :</strong> <%= etudiant.getNom() %></p>
            <p><strong>Prénom :</strong> <%= etudiant.getPrenom() %></p>
        <% } else { %>
            <p>Aucun étudiant trouvé.</p>
        <% } %>

        <% if (departement != null) { %>
            <p><strong>Département :</strong> <%= departement.getNom() %></p>
            <% ArrayList<String> matieres = departement.getMatieres(); %>
            <% if (matieres != null && !matieres.isEmpty()) { %>
                <p><strong>Matières :</strong></p>
                <ul>
                    <% for (String matiere : matieres) { %>
                        <li><%= matiere %></li>
                    <% } %>
                </ul>
            <% } else { %>
                <p>Aucune matière disponible.</p>
            <% } %>
            etudiants enregistrer
            <% ArrayList<Etudiant> etudiants = departement.getEtudiants(); %>
            <% if (etudiants != null && !etudiants.isEmpty()) { %>
                <p><strong>Étudiants :</strong></p>
                <ul>
                    <% for (Etudiant etu : etudiants) { %>
                        <li><%= etu.getNom() + " " + etu.getPrenom() %></li>
                    <% } %>
                </ul>
            <% } else { %>
                <p>Aucun étudiant disponible.</p>
            <% } %>

        <% } else { %>
            <p>Aucun département trouvé.</p>
        <% } %>
    </div>
</body>
</html>
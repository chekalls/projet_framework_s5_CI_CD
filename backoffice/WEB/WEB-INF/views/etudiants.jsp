<%@ page import="java.util.List" %>
<%@ page import="entity.Etudiant" %>
<%
    List<Etudiant> listeEtudiant = (List<Etudiant>) request.getAttribute("etudiants");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    liste etudiants 
    <table border="1">
        <tr>
            <th>nom</th>
            <th>prenom</th>
        </tr>

        <% for(Etudiant etudiant : listeEtudiant) { %>
            <tr>
                <td><%= etudiant.getNom() %></td>
                <td><%= etudiant.getPrenom() %></td>
            </tr>
        <% } %>
    </table>
</body>
</html>
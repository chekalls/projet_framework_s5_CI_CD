<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Test POST - sprint8</title>
    <style>body{font-family:Arial,Helvetica,sans-serif;padding:16px;}label{display:block;margin:8px 0;}</style>
</head>
<body>
    <h1>Test POST vers /sprint8Post</h1>

    <form action="${pageContext.request.contextPath}/sprint8Post" method="post" enctype="application/x-www-form-urlencoded">
        <label>Nom étudiant
            <input type="text" name="nomEtudiant" value="Dupont">
        </label>

        <label>Prénom étudiant
            <input type="text" name="prenomEtudiant" value="Jean">
        </label>

        <label>Age
            <input type="number" name="age" value="21">
        </label>

        <label>Sexe
            <input type="radio" name="sexe" value="M" checked> M
            <input type="radio" name="sexe" value="F"> F
        </label>

        <label>Intérêts
            <input type="checkbox" name="interets" value="sport" checked> sport
            <input type="checkbox" name="interets" value="musique"> musique
            <input type="checkbox" name="interets" value="art"> art
        </label>

        <label>Classes (sélection multiple)
            <select name="classes" multiple size="3">
                <option value="A">A</option>
                <option value="B" selected>B</option>
                <option value="C">C</option>
            </select>
        </label>

        <label>Commentaire
            <textarea name="comment" rows="4">Commentaire de test</textarea>
        </label>

        <input type="hidden" name="hiddenToken" value="tok_12345">

        <label>Notes (même name répété)
            <input type="text" name="note" value="12">
            <input type="text" name="note" value="14">
        </label>

        <div style="margin-top:12px;">
            <button type="submit">Envoyer (POST)</button>
        </div>
    </form>

</body>
</html>
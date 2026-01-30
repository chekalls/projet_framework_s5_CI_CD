<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Résultat POST - sprint8</title>
	<style>
		/* style réduit : juste un peu d'espace autour du contenu */
		body { padding: 8px; font-family: Arial, Helvetica, sans-serif; }
	</style>
</head>
<body>
	<h1>Résultat du formulaire POST</h1>

	<div class="section">
		<h2>Paramètres reçus</h2>
		<%
			// The controller places the processed request data inside the ModelView as attribute "requestData".
			Object requestDataObj = request.getAttribute("requestData");
			if (requestDataObj != null && requestDataObj instanceof java.util.Map) {
				java.util.Map dataMap = (java.util.Map) requestDataObj;
				if (dataMap.isEmpty()) {
		%>
				<p><em>Le controller a renvoyé une map vide.</em></p>
		<%
				} else {
		%>
				<table>
					<thead>
						<tr><th>Nom</th><th>Valeur(s)</th></tr>
					</thead>
					<tbody>
					<%
					for (Object _k : dataMap.keySet()) {
						String k = String.valueOf(_k);
						Object v = dataMap.get(k);
						String display;
						if (v == null) {
							display = "null";
						} else if (v.getClass().isArray()) {
							display = java.util.Arrays.toString((Object[]) v);
						} else if (v instanceof java.util.Collection) {
							display = v.toString();
						} else {
							display = v.toString();
						}
					%>
					<tr>
						<td><%= k %></td>
						<td><%= display %></td>
					</tr>
					<%
					}
					%>
					</tbody>
				</table>
		<%
				}
			} else {
				// Fallback: show raw request parameters
				java.util.Map params = request.getParameterMap();
				if (params == null || params.isEmpty()) {
		%>
				<p><em>Aucun paramètre reçu.</em></p>
		<%
				} else {
		%>
				<table>
					<thead>
						<tr><th>Nom</th><th>Valeur(s)</th></tr>
					</thead>
					<tbody>
					<%
					for (Object _k : params.keySet()) {
						String k = (String) _k;
						String[] vals = (String[]) params.get(k);
					%>
					<tr>
						<td><%= k %></td>
						<td><%= java.util.Arrays.toString(vals) %></td>
					</tr>
					<%
					}
					%>
					</tbody>
				</table>
		<%
				}
			}
		%>
	</div>

	<div class="section">
		<h2>Attributs de la requête (si présents)</h2>
		<%
			java.util.Enumeration attrNames = request.getAttributeNames();
			if (attrNames == null || !attrNames.hasMoreElements()) {
		%>
			<p><em>Aucun attribut de requête.</em></p>
		<%
			} else {
		%>
			<table>
				<thead><tr><th>Nom</th><th>Valeur (toString)</th></tr></thead>
				<tbody>
				<%
					while (attrNames.hasMoreElements()) {
						String a = (String) attrNames.nextElement();
						Object v = request.getAttribute(a);
				%>
					<tr>
						<td><%= a %></td>
						<td><%= (v==null?"null":v.toString()) %></td>
					</tr>
				<%
					}
				%>
				</tbody>
			</table>
		<%
			}
		%>
	</div>

	<div class="section">
		<a href="${pageContext.request.contextPath}/sprint8form">Retour au formulaire de test (POST)</a>
	</div>

</body>
</html>

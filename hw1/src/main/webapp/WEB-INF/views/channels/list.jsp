<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Channels</title>
</head>
<body>

	<c:forEach items="${channels}" var="channel">
		<p> ID: ${channel.id}, Name: ${channel.name} Topic: ${channel.topic}</p>
	</c:forEach>
	
</body>
</html>
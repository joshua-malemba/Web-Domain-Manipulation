<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Shows</title>
</head>
<body>

	<c:forEach items="${shows}" var="show">
		
		<p>Title is ${show.title} </p>
 		
 		<p>Producer is topic ${show.producer}.</p>
 		
 		<p>Category is ${show.category}.</p>
 		
 	</c:forEach>
 	
 	<p> <a href="/newShow?channel=1"> Add Channel </a> </p>

</body>

</html>

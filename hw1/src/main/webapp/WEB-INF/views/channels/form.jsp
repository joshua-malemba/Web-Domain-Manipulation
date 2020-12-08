<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Channels</title>
</head>
<body>

<form:form action="/addChannel" modelAttribute="channel">
	<form:label path="name">Enter name of Channel:</form:label>
	<form:input path="name"/>
	<form:errors path="name"/><br/>
	
	<form:label path="topic">Enter topic:</form:label>
	<form:input path="topic"/>
	<form:errors path="topic"/><br/>

	<form:label path="id">Enter id:</form:label>
	<form:input path="id"/>
	<form:errors path="id"/><br/>
	
	<input type="submit"/><form:errors/>
</form:form>
</body>
</html>
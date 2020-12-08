<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Shows</title>
</head>

<body>

<form:form action="/addShow" modelAttribute="show">

	<input name="channel" value=<%=request.getParameter("channel")%>/><br/>
	
	<form:label path="title">Enter title of Show:</form:label>
	<form:input path="title"/>
	<form:errors path="title"/><br/>
	
	<form:label path="producer">Enter producer:</form:label>
	<form:input path="producer"/>
	<form:errors path="producer"/><br/>

	<form:label path="category">Enter category:</form:label>
	<form:input path="category"/>
	<form:errors path="category"/><br/><form:errors/>
	
	<form:label path="episodes">Enter episodes:</form:label>
	<form:input path="episodes"/>
	<form:errors path="episodes"/><br/><form:errors/>
	
	<input type="submit"/>
</form:form>

</body>
</html>

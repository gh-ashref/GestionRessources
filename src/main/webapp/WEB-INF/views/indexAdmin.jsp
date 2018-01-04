<%@ taglib prefix = "c" uri = "http://java.sun.com/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<%@ include file="includes/css.jsp"%>
</head>
<body class="menubar-hoverable header-fixed ">
	<%
		String url = (String) request.getAttribute("page");
	System.out.println("cas"+url);
	%>
	<%@ include file="includes/header.jsp"%>
	<div id="base">
		<div class="offcanvas"></div>

		
			<jsp:include page="${page}.jsp"></jsp:include>
	

			
		<%@ include file="includes/menu.jsp"%>

	</div>
	<%@ include file="includes/scripts.jsp"%>

</body>
</html>
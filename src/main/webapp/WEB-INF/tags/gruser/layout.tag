<%@ tag body-content="scriptless"  %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ attribute name="title" required="true"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>Gestion Ressources | <c:out value="${title}"></c:out></title>
	<%@ include file="../../views/includes/css.jsp"%>
</head>
<body class="menubar-hoverable header-fixed ">

	<%@ include file="../../views/includes/header.jsp"%>
	<div id="base">
		<div class="offcanvas"></div>
		
			<jsp:doBody/>

		<%@ include file="../../views/includes/menu_user.jsp"%>

	</div>
	
	<%@ include file="../../views/includes/scripts.jsp"%>

</body>
</html>
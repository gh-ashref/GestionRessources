<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<%@ include file="includes/css.jsp"%>
</head>
<body class="menubar-hoverable header-fixed ">
	
			<!-- BEGIN BASE-->
		<div id="base">

			<!-- BEGIN OFFCANVAS LEFT -->
			<div class="offcanvas">
			</div><!--end .offcanvas-->
			<!-- END OFFCANVAS LEFT -->

			<!-- BEGIN CONTENT-->
			<div id="content">

				<!-- BEGIN 500 MESSAGE -->
				<section>
					
					<div class="section-body contain-lg">
						<div class="row">
							<div class="col-lg-12 text-center">
								<h1><span class="text-xxxl text-light">403 <i class="fa fa-exclamation-circle text-danger"></i></span></h1>
								<h2 class="text-light">Vous n'avez pas droit d'aceder a cette page</h2>
							</div><!--end .col -->
						</div><!--end .row -->
					</div><!--end .section-body -->
					<div class="section-body contain-lg">
						<div class="row">
							<div class="col-lg-12 text-center">
								<a href="../spring_security_logout"><h2 class="text-light">Réessayer</h2></a>
							</div><!--end .col -->
						</div><!--end .row -->
					</div>
				</section>
				<!-- END 500 MESSAGE -->

			</div><!--end #content-->
			<!-- END CONTENT -->
</div>
		




	</div>
	<%@ include file="includes/scripts.jsp"%>

</body>
</html>
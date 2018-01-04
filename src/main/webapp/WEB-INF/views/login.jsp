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


	<!-- BEGIN LOCKED SECTION -->
	<section class="section-account">
	
	<div class="img-backdrop"
		style="background-image: url('../../assets/img/img16.jpg')"></div>
	<div class="spacer"> </div>
	
	<div class="card contain-xs style-transparent">
		<div class="card-body">
		
			<div class="row">
		
			
			
				<div class="col-sm-12">
					
						<br>
					<h1 style="margin-left: 80px">Gestion Ressources</h2>
					<form class="form floating-label" action="spring_security_check"
						method="post" accept-charset="utf-8">
						<div class="form-group">
							<input type="text" class="form-control dirty" id="username"
								name="username"> <label for="Pseudo">Username</label>
						</div>
						<div class="form-group">
							<input type="password" class="form-control dirty" id="password"
								name="password"> <label for="Mot de passe">Password</label>
							<p class="help-block">
								<a href="#">Forgotten?</a>
							</p>
						</div>
						<br />
						<div class="row">
							<div class="col-xs-6 text-left">
								<div class="checkbox checkbox-inline checkbox-styled">
									<label> <input type="checkbox"> <span>Remember
											me</span>
									</label>
								</div>
							</div>
							<!--end .col -->
							<div class="col-xs-6 text-right">
								<button class="btn btn-primary btn-raised" type="submit">Login</button>
							</div>
							<!--end .col -->
						</div>
						<!--end .row -->
					</form>


				</div>
				<!--end .col -->
			</div>
			<!--end .row -->
		</div>
		
		<!--end .card-body -->
	</div>
	<!--end .card --> </section>
	<!-- 	<form action="spring_security_check" method="post"> -->
	<!-- 		<input type="text" name="username"> <input type="password" -->
	<!-- 			name="password"> <input type="submit" value="envoie"> -->
	<!-- 	</form> -->
	<%-- 	<%@ include file="includes/scripts.jsp" %> --%>

</body>
</html>

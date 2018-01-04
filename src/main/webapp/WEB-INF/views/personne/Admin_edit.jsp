<%@ page contentType="text/html" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %> 
<%@ taglib prefix="gr" tagdir="/WEB-INF/tags/gr" %>
<gr:layout title="Edit des personnes">
<div id="content">

<script type="text/javascript">

    function PreviewImage() {
        var oFReader = new FileReader();
        oFReader.readAsDataURL(document.getElementById("uploadImage").files[0]);

        oFReader.onload = function (oFREvent) {
            document.getElementById("uploadPreview").src = oFREvent.target.result;
        };
    };

</script>

	<section>
		<div class="section-header">
			<ol class="breadcrumb">
				<li><a href="/ProjetSpring/admin/personne/list">Utilisateurs</a></li>
				<li class="active">Editer Utilisateur</li>
			</ol>
		</div>
		<div class="section-body contain-lg">
			<div class="row">

				<!-- BEGIN ADD CONTACTS FORM -->
				<div class="col-md-12">
					<div class="card">
						<div class="card-head style-primary">
							<header>Ajout d'un nouveau utilisateur</header>
						</div>
						<form class="form" role="form" action="editPersonne" method="post"
							modelAttribute="personne">

							<!-- BEGIN DEFAULT FORM ITEMS -->
							<div class="card-body style-primary form-inverse">
								<div class="row">
									<div class="col-xs-12">
										<div class="row">
											<div class="col-md-6">
												<div class="form-group floating-label">
													<input name="nom" type="text" class="form-control input-lg"
														id="firstname" value=<c:out value="${personne.nom}" /> > <label for="firstname">Nom</label>
												</div>
											</div>
											<!--end .col -->
											<div class="col-md-6">
												<div class="form-group floating-label">
													<input name="prenom" type="text"
														class="form-control input-lg" id="lastname" value=<c:out value="${personne.prenom}" />> <label
														for="lastname">Prenom</label>
												</div>
											</div>
											<!--end .col -->
										</div>
										<!--end .row -->

									</div>
									<!--end .col -->
								</div>
								<!--end .row -->
							</div>
							<!--end .card-body -->
							<!-- END DEFAULT FORM ITEMS -->

							<!-- BEGIN FORM TABS -->
							<div class="card-head style-primary">
								<ul class="nav nav-tabs tabs-text-contrast tabs-accent"
									data-toggle="tabs">
									<li class="active"><a href="#contact">Information
											Personnele</a></li>
									<li><a href="#experience">Information Compte</a></li>

								</ul>
							</div>
							<!--end .card-head -->
							<!-- END FORM TABS -->

							<!-- BEGIN FORM TAB PANES -->
							<div class="card-body tab-content">
								<div class="tab-pane active" id="contact">
									<div class="row">
										<div class="col-md-8">
											<div class="row">
												<div class="col-md-6">
													<div class="form-group">
														<input name="tel" type="text" class="form-control"
															id="mobile" value=<c:out value="${personne.tel}" />> <label for="mobile">N°Tel</label>
													</div>
												</div>
												<!--end .col -->

											</div>
											<!--end .row -->
											<div class="form-group">
												<input name="mail" type="email" class="form-control"
													id="email" value=<c:out value="${personne.mail}" /> > <label for="email">Email</label>
											</div>
											<!--end .form-group -->
											<div class="row">
												<div class="col-md-8">
													<div class="form-group">
														<input name="cin" type="text" class="form-control"
															id="street" value=<c:out value="${personne.cin}" /> > <label for="street" >CIN</label>
													</div>
												</div>
												<!--end .col -->

											</div>
											<!--end .row -->
										</div>
										<!--end .col -->
										<div class="col-md-4">
											<div class="form-group">
											
												<input src=<c:out value="${personne.nom}" /> name="photo" id="uploadImage" type="file" name="myPhoto" onchange="PreviewImage();" />
												
												<img  id="uploadPreview" style=" border:1px; width: 250px; height: 250px;" />
											</div>
										</div>
										<!--end .col -->
									</div>
									<!--end .row -->
								</div>
								<!--end .tab-pane -->
								<div class="tab-pane" id="experience">
									<div class="form-group">
										<input name="login" type="text" class="form-control" value=<c:out value="${personne.login}" />>
										<label for="email">Login</label>
									</div>
									<!--end .form-group -->

									<div class="row">
										<div class="col-md-6">
											<div class="form-group">
												<input name="password" type="password" class="form-control" value=<c:out value="${personne.password}" />>
												<label for="mobile">Mot de Passe</label>
											</div>
										</div>
										<!--end .col -->
										<div class="col-md-6">
											<div class="form-group">
												<input type="password" class="form-control" value=<c:out value="${personne.password}" />>
												<label for="phone">Mot de passe</label>
											</div>
										</div>
										<!--end .col -->
									</div>

								</div>
								<!--end .tab-pane -->
								<!--end .tab-pane -->
								<!--end .tab-pane -->
							</div>
							<!--end .card-body.tab-content -->
							<!-- END FORM TAB PANES -->

							<!-- BEGIN FORM FOOTER -->
							<div class="card-actionbar">
								<div class="card-actionbar-row">
									<button type="reset" class="btn btn-flat ink-reaction btn-danger">Vider</button>
									<button type="submit" class="btn btn-flat ink-reaction btn-success">Ajouter</button>
								</div>
								<!--end .card-actionbar-row -->
							</div>
							<!--end .card-actionbar -->
							<!-- END FORM FOOTER -->

						</form>
					</div>
					<!--end .card -->
				</div>
				<!--end .col -->
				<!-- END ADD CONTACTS FORM -->

			</div>
			<!--end .row -->
		</div>
		<!--end .section-body -->
	</section>
</div>
</gr:layout>


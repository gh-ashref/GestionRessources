<%@ page contentType="text/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@ taglib prefix="gr" tagdir="/WEB-INF/tags/gr"%>

<gr:layout title="Liste des reservations">
	<div id="content" class="section-body contain-lg">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="text-primary">Modifier ressource</h1>
			</div>
		</div>

		<div class="row">
			<div class="col-lg-12">
				<div class="card">
					<div class="card-body no-padding">
						<div class="">
							<c:out value="${erreur}" />
							<form action="addRessource" method="post"
								modelAttribute="ressource">
								<table class="table table-striped no-margin">
									<tr>
										<td>Libelle:</td>
										<td><input type="text" name="libelle" class="form-control" value=<c:out value="${ressource.libelle}" />></td>
									</tr>
									<tr>
										<td>Type:</td>
										<td><input type="text" name="type" class="form-control" value=<c:out value="${ressource.type}" />></td>
									</tr>
									<tr>
										<td>Etat:</td>
										<td><input type="text" name="etat" class="form-control" value=<c:out value="${ressource.etat}" />></td>
									</tr>
									<tr>
										<td>Description:</td>
										<td><input type="text" name="description" class="form-control" value=<c:out value="${ressource.description}" />></td>
									</tr>
									<tr>
										<td>Quantité:</td>
										<td><input type="number" name="qte" class="form-control" value=<c:out value="${ressource.qte}" />></td>
									</tr>
									<tr>
										<td>Max réservations:</td>
										<td><input type="number" name="maxReserv" class="form-control" value=<c:out value="${ressource.maxReserv}" />></td>
									</tr>

									<tr>
										<td></td>
										<td><input type="submit" value="Modifier"
											class="btn btn-primary btn-raised"> <a href="list"><input
												type="button" value="Annuler"
												class="btn btn-primary btn-raised"></a></td>
									</tr>
								</table>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</gr:layout>

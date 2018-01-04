
<%@ page contentType="text/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@ taglib prefix="gr" tagdir="/WEB-INF/tags/gr"%>


<gr:layout title="Ajouter réservation">
	<div id="content" class="section-body contain-lg">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="text-primary">Ajouter réservation</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-12">
				<div class="card">
					<div class="card-body">
						<div class="">
							<form action="/ProjetSpring/admin/reservation/add" method="post"
								modelAttribute="reservation">
								<table class="table no-margin">
									<tr>
										<td>Date de début:</td>
										<td><input type="date" name="dateDebutFreq"
											class="form-control"></td>

									</tr>
									<tr>
										<td>Date de fin fréquence:</td>
										<td><input type="date" name="dateFinFreq"
											class="form-control"></td>
									</tr>
									<tr>
										<td>Fréquence:</td>
										<td><select name="freq" class="form-control">
												<option value=0>Une Seule Fois</option>
												<option value=1>Chaque Jour</option>
												<option value=7>Chaque Semaine</option>
												<option value=15>Chaque 2 semaine</option>
										</select></td>
									</tr>

									<tr>
										<td>Personne:</td>
										<td><select name="personne_id" class="form-control">
												<c:forEach var="personne" items="${listPersonnes}">

													<option value=<c:out value="${personne.id}" />><c:out
															value="${personne.nom}" />
														<c:out value="${personne.prenom}" /></option>
												</c:forEach>
										</select></td>
									</tr>

									<tr>
										<td>Ressource:</td>
										<td><select name="ressource_id" class="form-control">
												<c:forEach var="ressource" items="${listRessources}">

													<option value=<c:out value="${ressource.id}" />><c:out
															value="${ressource.libelle}" />
													</option>
												</c:forEach>
										</select></td>
									</tr>
									<tr>
										<td>Quantité:</td>
										<td><input type="text" name="qte" class="form-control"></td>
									</tr>

									<tr>
										<td>Heure de début :</td>
										<td><input type="time" name="heured" class="form-control"></td>
									</tr>
									<tr>
										<td>Heure de fin :</td>
										<td><input type="time" name="heuref" class="form-control"></td>
									</tr>

									<tr>
										<center>
											<td><input type="submit" value="Save"
												class="btn btn-primary btn-raised"></td>
										</center>
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
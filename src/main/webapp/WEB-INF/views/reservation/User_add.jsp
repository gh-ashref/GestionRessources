
<%@ page contentType="text/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@ taglib prefix="gr" tagdir="/WEB-INF/tags/gruser"%>
<gr:layout title="Ajouter des Reservation">

	<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

	<script type="text/javascript">
		function check_date() {

			// start_date and End_date now point straight at the correct boxes.
			var dateDebut = document.getElementById("dateDebutFreq");
			var dateFin = document.getElementById("dateFinFreq");
			// convert both entries to a Date object from the string value
			var dateDebut2 = new Date(dateDebut.value);
			var dateFin2 = new Date(dateFin.value);
			var diffDays = (dateFin2 - dateDebut2) / (24 * 3600 * 1000);
			if (diffDays < 0) {
				document.getElementById("dateFinFreq").focus();
			}
		}
		function check_time() {

			// start_date and End_date now point straight at the correct boxes.
			var heureDebut = document.getElementById("heured");
			var heureFin = document.getElementById("heuref");
			// convert both entries to a Date object from the string value
			var heureDebut2 = new Date(heureDebut.value);
			var heureFin2 = new Date(heureFin.value);

			if (heureFin2 < heureDebut2) {
				alert("verif time");
				document.getElementById("qte").focus();
			}
		}
	</script>


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
							<form action="/ProjetSpring/user/reservation/add" method="post"
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
					<td><input type="submit" value="Save"></td>

				</tr>
			</table>
		</form>
	</div>


									<tr>
										<td></td>
										<td><input type="submit" value="Save"
											class="btn btn-primary btn-raised"></td>
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

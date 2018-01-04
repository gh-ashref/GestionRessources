
<%@ page contentType="text/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@ taglib prefix="gr" tagdir="/WEB-INF/tags/gr"%>

<gr:layout title="Liste des reservations">
	<div id="content" class="section-body contain-lg">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="text-primary">
					Liste des réservations <a href="form"><button
							class="btn btn-primary btn-raised" type="submit">+</button></a>
				</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-12">
				<div class="card">
					<div class="card-body no-padding">
						<div class="">
							<table class="table table-striped no-margin">
								<thead>
									<tr>
										<th>Nom Personne</th>
										<th>Ressource</th>
										<th>Quantité</th>
										<th>Date</th>
										<th>Heure D</th>
										<th>Heure F</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="creneau" items="${listCreneaux}">
										<tr>
											<td><c:out value="${creneau.reservation.personne.nom}" /></td>
											<td><c:out value="${creneau.ressource.description}" /></td>
											<td><c:out value="${creneau.qte}" /></td>
											<td><c:out value="${creneau.date}" /></td>
											<td><c:out value="${creneau.heureDebut}" /></td>
											<td><c:out value="${creneau.heureFin}" /></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-12">
				<h1 class="text-primary">Créneaux rejetés</h1>
			</div>
			<div class="col-lg-8">
				<article class="margin-bottom-xxl">
					<p class="lead"></p>
				</article>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-12">
				<div class="card">
					<div class="card-body no-padding">
						<div class="">
							<table class="table table-striped no-margin">
								<thead>
									<tr>
										<th>Nom Personne</th>
										<th>Ressource</th>
										<th>Quantité disponible</th>
										<th>Date</th>
										<th>Heure D</th>
										<th>Heure F</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="creneau" items="${creneauRejetes}">
										<tr>
											<td><c:out value="${creneau.reservation.personne.nom}" /></td>
											<td><c:out value="${creneau.ressource.description}" /></td>
											<td><c:out value="${creneau.qteDispo}" /></td>
											<td><c:out value="${creneau.dateNonDispo}" /></td>
											<td><c:out value="${creneau.heureDebut}" /></td>
											<td><c:out value="${creneau.heureFin}" /></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</gr:layout>
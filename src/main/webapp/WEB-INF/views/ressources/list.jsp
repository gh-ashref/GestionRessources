<%@ page contentType="text/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@ taglib prefix="gr" tagdir="/WEB-INF/tags/gr"%>

<gr:layout title="Liste des reservations">
	<div id="content" class="section-body contain-lg">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="text-primary">
					Liste des ressources <a href="form"><button
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
										<th>Libelle</th>
										<th>Type</th>
										<th>Quantité</th>
									</tr>
								</thead>


								<c:forEach var="ressource" items="${listRessource}">
									<tr>

										<td><c:out value="${ressource.libelle}" /></td>
										<td><c:out value="${ressource.type}" /></td>
										<td><c:out value="${ressource.qte}" /></td>

										<c:url value="deleteRessource" var="del">
											<c:param name="id" value="${ressource.id}" />
										</c:url>

										<c:url value="editRessourceView" var="edit">
											<c:param name="id" value="${ressource.id}" />
										</c:url>

										<c:url value="detailRessource" var="detail">
											<c:param name="id" value="${ressource.id}" />
										</c:url>

										<td><a href='<c:out value="${detail}"/>'>Details</a></td>
										<td><a href='<c:out value="${edit}"/>'>Modifier</a></td>
										<td><a href='<c:out value="${del}"/>'>Supprimer</a></td>
									</tr>
								</c:forEach>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</gr:layout>

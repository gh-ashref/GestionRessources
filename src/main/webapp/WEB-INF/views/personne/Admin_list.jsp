<%@ page contentType="text/html" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %> 
<%@ taglib prefix="gr" tagdir="/WEB-INF/tags/gr" %>

<gr:layout title="Liste des personnes">
	<div id="content">
		<section>
	
			<div class="section-body contain-lg">
	
				<!-- BEGIN INTRO -->
				<div class="row">
					<div class="col-lg-12">
						<h1 class="text-primary">Liste des Utilisateurs</h1>
					</div>
					<!--end .col -->
					<div class="col-lg-8">
						<article class="margin-bottom-xxl">
							<p class="lead"></p>
						</article>
					</div>
					<!--end .col -->
				</div>
				<!--end .row -->
				<!-- END INTRO -->
	
	
				<!-- BEGIN RESPONSIVE TABLE 2 -->
				<div class="row">
	
					<div class="col-lg-12">
						<div class="card">
							<div class="card-body no-padding">
								<div class="">
									<table class="table table-striped no-margin">
										<thead>
											<tr>
												<th>#</th>
												<th>Nom et Prenom</th>
												<th>Mail</th>
												<th>Numero Telephone</th>
												<th>CIN</th>
												<th>Rôle</th>
												<th>Editer/Supprimer</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="personne" items="${listPersonne}" varStatus="i">
												<tr>
													<td> <c:out value="${i.index+1}" /></td>
													<td><c:out value="${personne.nom} ${personne.prenom}" /></td>
													<td><c:out value="${personne.mail}" /></td>
													<td><c:out value="${personne.tel}" /></td>
													<td><c:out value="${personne.cin}" /></td>
													<td><c:out value="${personne.role}" /></td>
	
													<c:url value="deletePersonne" var="del">
														<c:param name="id" value="${personne.id}" />
													</c:url>
	
													<c:url value="editPersonne" var="edit">
														<c:param name="id" value="${personne.id}" />
													</c:url>
	
													<c:url value="detailPersonne" var="detail">
														<c:param name="id" value="${personne.id}" />
													</c:url>
	
													<td>
														<div class="btn-group">
														<button type="button" class="btn ink-reaction btn-floating-action btn-sm btn-primary" data-toggle="dropdown"><i class="fa fa-star"></i></button>
														<ul class="dropdown-menu dropdown-menu-right" role="menu">
															<li><a href='<c:out value="${detail}"/>'> <i class="fa fa-fw fa-eye text-primary"></i> Detail</a></li>
															<li><a href='<c:out value="${edit}"/>'><i class="fa fa-fw fa-pencil text-primary"></i> Editer</a></li>
															<li class="divider"></li>
															<li><a href='<c:out value="${del}"/>'><i class="fa fa-fw fa-times text-danger"></i> Supprimer </a></li>
														</ul>
													</div>
														</td>
												</tr>
											</c:forEach>
	
	
										</tbody>
									</table>
								</div>
								<!--end .table-responsive -->
							</div>
							<!--end .card-body -->
						</div>
						<!--end .card -->
					</div>
					<!--end .col -->
				</div>
				<!--end .row -->
				<!-- END RESPONSIVE TABLE 1 -->
	
			</div>
		</section>
	</div>
</gr:layout>

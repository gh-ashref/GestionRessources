
<%@ page contentType="text/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@ taglib prefix="gr" tagdir="/WEB-INF/tags/gr"%>

<gr:layout title="Calendrier des reservations">
	<div id="content" class="section-body contain-lg">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="text-primary">
					Liste des réservations <a href="form"><button
							class="btn btn-primary btn-raised" type="submit">+</button></a>
				</h1>
			</div>
		</div>
		
		
		<section>
					
					<div class="section-body">
						<div class="row">

							
							<!-- BEGIN CALENDAR -->
							<div class="col-sm-9">
								<div class="card">
									<div class="card-head style-primary">
										<header>
											<span class="selected-day">&nbsp;</span> &nbsp;<small class="selected-date">&nbsp;</small>
										</header>
										<div class="tools">
											<div class="btn-group">
												<a id="calender-prev" class="btn btn-icon-toggle ink-reaction"><i class="fa fa-angle-left"></i></a>
												<a id="calender-next" class="btn btn-icon-toggle ink-reaction"><i class="fa fa-angle-right"></i></a>
											</div>
											<div class="btn-group pull-right">
											</div>
										</div>
										<ul class="nav nav-tabs tabs-text-contrast tabs-accent" data-toggle="tabs">
											<li data-mode="month" ><a href="#">Month</a></li>
											<li data-mode="agendaWeek"><a href="#">Week</a></li>
											<li data-mode="agendaDay" class="active"><a href="#">Day</a></li>
										</ul>
									</div><!--end .card-head -->
									<div class="card-body no-padding">
										<div id="calendar"></div>
									</div><!--end .card-body -->
								</div><!--end .card -->
							</div><!--end .col -->
							<!-- END CALENDAR -->

						</div><!--end .row -->
					</div><!--end .section-body -->
				</section>
		
	</div>
</gr:layout>
<!-- BEGIN MENUBAR-->
			<div id="menubar" class="menubar-inverse ">
				<div class="menubar-fixed-panel">
					<div>
						<a class="btn btn-icon-toggle btn-default menubar-toggle" data-toggle="menubar" href="javascript:void(0);">
							<i class="fa fa-bars"></i>
						</a>
					</div>
					<div class="expanded">
						<a href="../../html/dashboards/dashboard.html">
							<span class="text-lg text-bold text-primary ">MATERIAL&nbsp;ADMIN</span>
						</a>
					</div>
				</div>
				<div class="menubar-scroll-panel">

					<!-- BEGIN MAIN MENU -->
					<ul id="main-menu" class="gui-controls">

						<!-- BEGIN DASHBOARD -->
						<li>
							<a href="/ProjetSpring/admin/personne/list" >
								<div class="gui-icon"><i class="md md-home"></i></div>
								<span class="title">Accueil</span>
							</a>
						</li><!--end /menu-li -->
						<!-- END DASHBOARD -->

						<!-- BEGIN EMAIL -->
						<li class="gui-folder">
							<a>
								<div class="gui-icon"><i class="glyphicon glyphicon-user"></i></div>
								<span class="title">Utilisateurs</span>
							</a>
							<!--start submenu -->
							<ul>
								<li><a href="/ProjetSpring/admin/personne/form" ><span class="title">Ajouter nouveau Utilisateur</span></a></li>
								<li><a href="/ProjetSpring/admin/personne/list" ><span class="title">Gestion d'Utilisateur</span></a></li>
								</ul><!--end /submenu -->
						</li><!--end /menu-li -->
						<!-- END EMAIL -->


						<!-- BEGIN RESSOURCES -->
						<li class="gui-folder">
							<a>
								<div class="gui-icon"><i class="fa fa-table"></i></div>
								<span class="title">Ressources</span>
							</a>
							<!--start submenu -->
							<ul>
								<li><a href="/ProjetSpring/admin/ressource/form" ><span class="title">Ajouter ressource</span></a></li>
								<li><a href="/ProjetSpring/admin/ressource/list" ><span class="title">Gestion de ressources</span></a></li>
								</ul><!--end /submenu -->
						</li><!--end /menu-li -->
						
						<li class="gui-folder">
							<a>
								<div class="gui-icon"><i class="fa fa-table"></i></div>
								<span class="title">Reservation</span>
							</a>
							<!--start submenu -->
							<ul>
								<li><a href="/ProjetSpring/admin/reservation/form" ><span class="title">Ajouter Reservation</span></a></li>
								<li><a href="/ProjetSpring/admin/reservation/list" ><span class="title">Gestion des Reservations</span></a></li>
								<li><a href="/ProjetSpring/admin/reservation/calender" ><span class="title">Calendrier des Reservations</span></a></li>
								
								</ul><!--end /submenu -->
						</li><!--end /menu-li -->
						
						<!-- END RESSOURCES -->

					</ul><!--end .main-menu -->
					<!-- END MAIN MENU -->

			<!-- END MENUBAR -->
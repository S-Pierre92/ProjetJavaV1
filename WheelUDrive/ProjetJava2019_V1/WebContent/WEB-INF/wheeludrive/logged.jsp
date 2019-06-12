<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>


<div class= "widgets-wrap float-right">
<!-- 	<a href= "#" class= "widget-header mr-3"> -->
<!-- 		<div class="icontext"> -->
<!-- 			<div class="icon-wrap"> -->
<!-- 				<i class= "icon-sm round border fa fa-heart"></i> -->
<!-- 			</div> -->
<!-- 			<div class="text-wrap"> -->
<!-- 				<span class= "small badge badge-danger">0</span><small style="color:#000;">Favoris</small> -->
<!-- 			</div> -->
<!-- 		</div> -->
<!-- 	</a> -->
	<div class= "widget-header dropdown">
		<a href= "#" data-toggle= "dropdown" data-offset="20,10"><div class="icontext">
			<div class="icontext">
				<div class="icon-wrap">
					<i class= "icon-sm round border fa fa-user"></i>
				</div>
				<div class="text-wrap">
					<div style="color:#000;">
						Mon compte <i class= "fa fa-caret-down"></i>
					</div>
				</div>
			</div>
		</a>
		<div class= "dropdown-menu dropdown-menu-right">
			<form class= "px-4 py-3">
				<a class= "dropdown-item" href="wheeludrive/compte" >Mes informations</a>
				<hr class="dropdown-divider">
				<a class= "dropdown-item" href= "?logout=1">Se déconnecter</a>
				<hr class="dropdown-divider">
				<a class= "dropdown-item btn btn-primary btn-block" href="#" data-toggle= "modal" data-target="#modal-annonce">Vendre</a>
			</form>
		</div>
	</div>
</div>


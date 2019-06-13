<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<div class="widgets-wrap float-right" id="connectForm">
	<div class="widget-header dropdown">
		<a href="#" data-toggle="dropdown" data-offset="20,10">
			<div class="icontext">
				<div class="icon-wrap">
					<i class="icon-sm round border fa fa-user"></i>
				</div>
				<div class="text-wrap">
					<small style="color: #000;">Mon compte <i class= "fa fa-caret-down"></i></small>
					<small style="color: #000;"><i>se connecter</i></small>
				</div>
			</div>
		</a>
		<div class="dropdown-menu dropdown-menu-right px-4 py-3">
			<form class=""
				action="${pageContext.request.contextPath}/wheeludrive" method="post">
				<div class="form-group">
					<label>Email</label> <input name="emailConnexion" type="email"
						class="form-control" placeholder="email@exemple.com" required>
				</div>
				<div class="form-group">
					<label>Mot de passe</label> <input type="password"
						name="pswdConnexion" class="form-control"
						placeholder="Mot de passe" required>
				</div>
				<input type="submit" class="btn btn-primary" value="Se connecter">
			</form>
			<hr class="dropdown-divider">
			<a href="#" class="dropdown-item" data-toggle="modal" data-target="#modal-sign">S'inscrire</a> 
			<a href="#" class="dropdown-item" data-toggle="modal" data-target="#modal-pswd-lost">Mot de passe
				oublié?</a>
		</div>
		<!--  dropdown-menu .// -->
	</div>
	<!-- widget-header .// -->
</div>
<!-- widgets-wrap.// -->
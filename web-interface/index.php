<!DOCTYPE html>
<html lang="en">
	<head>
		<!-- Bootstrap Meta for Mobile -->
		<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<title>Hello there!</title>
		<!-- Main CSS -->
		<link rel="stylesheet" type="text/css" href="css/main.css">
		<!-- Normalizer CSS -->
		<link rel="stylesheet" type="text/css" href="css/normalize.css">
		<!-- Bootstrap -->
		<!-- Bootstrap CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<!-- jQuery library -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
		<!-- Bootstrap JavaScript -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<!-- End Bootstrap -->
	</head>
	
	<body>
		<div class="container-fluid">
			
			<nav class="navbar navbar-inverse">
				<div class="container-fluid">
					<div class="navbar-header">
						<a class="navbar-brand" href="http://68.38.21.90/">VNConnect</a>
					</div>
					<ul class="nav navbar-nav">
						<li class="active"><a href="http://68.38.21.90/">Home</a></li>
						<li><a href="http://68.38.21.90/phpmyadmin/">phpMyAdmin</a></li>
						<li><a href="http://68.38.21.90/daemon-connect.php">Daemon Connect</a></li>
					</ul>
				</div>
			</nav>
			
			<div class="row">
				
				<div class="col-md-4">
					<div id="list">
						
						<h1>List</h1>
						<div id="outer-list">
						<?php
						for($i=0;$i<20;$i++) {
							?>
							<div class="list-item"></div>
							<?php
						}
						?>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-md-12">
						<form action="daemon-connect.php" method="POST">
							<input type="text" name="name">
							<input type="submit" text="submit">
						</form>
					</div>
				</div>

				<div class="col-md-8">
					<div id="info">
						
						<h1>Info</h1>
						<img src="http://cdn1-www.dogtime.com/assets/uploads/gallery/border-collie-dog-breed-pictures/1-facethreequarters.jpg" class="img-circle" id="user-profile">

					</div>

					<div >
						<div class="info-block">
						<div>
							<h3 class="info-head">Network Info</h3>
						</div>
							<br/>
							<br/>
						</div>
						<div class="info-block">

						<div>
							<h3 class="info-head">System Info</h3>
						</div>

							<br/>
							<br/>
						</div>

					</div>

				</div>

			</div>

			
		</div>
	</body>
</html>
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
					$a=array("https://pbs.twimg.com/profile_images/18920332/lil_peachieness_400x400.jpg",
						"http://animals.sandiegozoo.org/sites/default/files/styles/feeds_animal_thumbnail/public/lizard_thumb.jpg?itok=1l38sGyD",
						"http://petus.imageg.net/PETNA_36/pimg/pPETNA-4032756_main_r200.jpg",
						"https://d1wn0q81ehzw6k.cloudfront.net/additional/thul/media/4e34feee0acdc38a?w=400&h=400",
						"https://d1wn0q81ehzw6k.cloudfront.net/additional/thul/media/24912b4b43b6ae6d?w=400&h=400",
						"https://nationalzoo.si.edu/scbi/migratorybirds/featured_photo/images/bigpic/blbw2.jpg",
						"http://animals.sandiegozoo.org/sites/default/files/styles/feeds_animal_thumbnail/public/tiger_thumb.jpg?itok=AEODN3Ke",
						"https://upload.wikimedia.org/wikipedia/commons/6/66/Polar_Bear_-_Alaska_(cropped).jpg",
						"http://magazine.foxnews.com/sites/magazine.foxnews.com/files/styles/700_image/public/CowMoo.jpg?itok=aT-PEpl6",
						"http://static.boredpanda.com/blog/wp-content/uploads/2016/02/juniper-fox-happiest-instagram-9.jpg",
						"http://www.birdinginformation.com/wp-content/gallery/mandarin-duck/mandarin-duck-swimming-1.jpg",
						"http://purelyfacts.com/pics/items/animals/Giraffe.jpg");
					$b=array("Panda","Lizard","Fish","Cat","Dog","Bird","Tiger","Polar Bear","Cow","Fox","Duck","Giraffe");
					$c=array(25898554,35496879, 32198792, 32187491, 98762416, 58721841, 98763166, 68746128,65498745, 54891354, 98746169,34984631,65498746);

					for($i=0;$i < count($a);$i++){
						?>
						<div class="list-item"><table>
								<tr>
									<td rowspan="2"><img src=<?php echo $a[$i]; ?> class="img-circle" id="user-profile-list"></td>
									<td class="list-names">
										<b><?php ;
											echo $b[$i];
											?></b>
									</td>
									<td id="move">      ID: <?php echo ('    '.$c[$i]) ?></td>
								</tr>
								<tr>
									<td class="list-type"><?php $type = 'Laptop';
										echo $type;
										?></td>
								</tr>
							</table></div>
						<?php
					}
					?>
				</div>
			</div>
		</div>

		<div class="col-md-8">
			<div id="info">

				<h1>Info</h1>
				<img src="https://pbs.twimg.com/profile_images/18920332/lil_peachieness_400x400.jpg" class="img-circle" id="user-profile">

				<div id="checkOnline"><h3>Online</h3>
					<div id="OwnerInfo"><h3>Owner Information</h3> <h4 class="fake">ID: 2589854</h4></div></div>
				<?php
				if(true) {
					?>
					<div id="online-dot" class="img-circle"></div>
					<?php
				}else {
					?>
					<div id="offline-dot" class="img-circle"></div>
					<?php
				}
				?>

			</div>

			<div >
				<div class="info-block">
					<div>
						<h3 class="info-head">Network Info</h3>
					</div>
					<h4 class="fake">Hostname: pal-nat186-17-82.itap.purdue.edu <br> Internal IP: 10.186.17.82 <br> External IP: 128.210.106.52</h4>
				</div>
				<div class="info-block">

					<div>
						<h3 class="info-head">System Info</h3>
					</div>
					<h4 class="fake">OS: Mac OS X <br> Version: 10.11.4 <br> Ram Size: 8GB</h4>
				</div>

			</div>

		</div>

	</div>


</div>
</body>
</html>
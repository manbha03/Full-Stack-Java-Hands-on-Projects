<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

<title>Fly Away</title>

<!-- Google font -->
<link href="https://fonts.googleapis.com/css?family=PT+Sans:400"
	rel="stylesheet">

<!-- Bootstrap -->
<link type="text/css" rel="stylesheet" href="css/bootstrap.min.css" />

<!-- Custom stlylesheet -->
<link type="text/css" rel="stylesheet" href="css/style.css" />

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
		  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
		  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		<![endif]-->

</head>

<body>

	<div id="booking" class="section">
		<div class="section-center">
			<div class="container">
				<div class="row">
					<div class="booking-form">
						<form name="contact-form" action="SearchFlights">
							<div class="form-group">
								<div class="form-checkbox">

									<label for="one-way"> <input type="radio" id="one-way"
										name="flight-type" checked="checked"> <span></span>One
										way
									</label>
								</div>
							</div>
							<div class="row">

								<div class="col-md-6">
									<div class="form-group">
										<span class="form-label">Flying From</span> <select
											class="form-control" name="source"><option selected>Select
												Source</option>
											<option value="Kolkata">Kolkata(CCU)</option>
											<option value="Delhi">Delhi(DEL)</option>
											<option value="Mumbai">Mumbai(BOM)</option>
											<option value="Chennai">Chennai(MAA)</option>
											<option value="Shillong">Shillong(SHL))</option>

										</select> <span class="select-arrow"></span>
									</div>
								</div>

								<div class="col-md-6">

									<div class="form-group">
										<span class="form-label">Flying To</span> <select
											class="form-control" name="destination">
											<option selected>Select Destination</option>
											<option value="Kolkata">Kolkata(CCU)</option>
											<option value="Delhi">Delhi(DEL)</option>
											<option value="Mumbai">Mumbai(BOM)</option>
											<option value="Chennai">Chennai(MAA)</option>
											<option value="Shillong">Shillong(SHL)</option>
										</select> <span class="select-arrow"></span>
									</div>

								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<span class="form-label">Departing</span> <input
											class="form-control" type="date" name="departOn" required>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<span class="form-label">Adults (18+)</span> <input
											class="form-control" type="text" name="travellers"
											placeholder="enter number of traveller(s)" required>

									</div>
								</div>

							</div>
							<div class="row">

								<div class="col-md-3">
									<div class="form-btn">
										<button class="submit-btn">Show flights</button>
									</div>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<footer class="bg-light text-center text-lg-start">
		<!-- Copyright -->
		<div class="text-center p-3"
			style="background-color: rgba(0, 0, 0, 0.2);">
			© 2022 Copyright: <a class="text-dark"
				href="https://mdbootstrap.com/">Developed by Dakamanbha
				Ryngkhlem</a>
		</div>
		<!-- Copyright -->
	</footer>
</body>
</html>
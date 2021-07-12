<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="../WEB-INF/jsp/head.jsp"%>
</head>
<body>
	<div class="wrapper">
		<div class="main-header">
			<!-- Logo Header -->


			<%@include file="../WEB-INF/jsp/logoHeader.jsp"%>



			<!-- End Logo Header -->

			<!-- Navbar Header -->
			<%@include file="../WEB-INF/jsp/navbar.jsp"%>
			<!-- End Navbar -->
		</div>

		<!-- Sidebar -->
		<%@include file="../WEB-INF/jsp/slideBar.jsp"%>



		<!-- End Sidebar -->

		<div class="main-panel">
			<div class="content">
				<div class="panel-header bg-info-gradient">
					<div class="page-inner py-5">
						<div
							class="d-flex align-items-left align-items-md-center flex-column flex-md-row">
							<div>
								<h2 class="text-white pb-2 fw-bold">Maintenance Dashboard</h2>
								<h5 class="text-white op-7 mb-2"></h5>
							</div>
							<div class="ml-md-auto py-2 py-md-0">
								<!-- 									<a href="appointment" class="btn btn-white btn-border btn-round mr-2">Make Appointment</a> -->
								<!-- 									<a href="vehicleInformation" class="btn btn-white btn-border btn-round mr-2">Gate Entry</a> -->
								<!-- 								<a href="#" class="btn btn-white btn-border btn-round mr-2">Manage</a> -->
								<!-- 								<a href="#" class="btn btn-secondary btn-round">Add Customer</a> -->
							</div>
						</div>
					</div>
				</div>
				<div class="page-inner mt--5">
					<div class="row mt--3">
						<div class="col-md-3">
							<div class="card text-white bg-danger-gradient full-height">
								<div class="card-body">
									<div class="card-title font-weight-bold">CALIBRATION OVERDUE</div>
									<div class="card-category"></div>
									<div class="d-flex flex-wrap justify-content-around pb-2 pt-4">

										<div class="text-center"
											style="width: 110px; height: 100px;">

											<div class="rounded-circle circles-text" id="totcal"
												style="font-size: 40px;">0</div>
											<h6 class="fw-bold mt-3 mb-0">EQUIPMENT DUE</h6>
										</div>

										


									</div>
								</div>
							</div>
						</div>

						<div class="col-md-3">
							<div class="card text-white bg-warning-gradient full-height">
								<div class="card-body">



									<div class="card-title font-weight-bold">CALIBRATION DUE 30 DAYS</div>
									<div class="card-category"></div>

									<div class="d-flex flex-wrap justify-content-around pb-2 pt-4">

										<div class="text-center"
											style="width: 110px; height: 100px;">

											<div class="rounded-circle circles-text" id="cali30"
												style="font-size: 40px;">0</div>
											<h6 class="fw-bold mt-3 mb-0">EQUIPMENT DUE</h6>
										</div>

										


									</div>



								</div>
							</div>


						</div>

						<div class="col-md-3">
							<div class="card text-white bg-success-gradient full-height">
								<div class="card-body">



									<div class="card-title font-weight-bold">CALIBRATION DUE 60 DAYS</div>
									<div class="card-category"></div>

									<div class="d-flex flex-wrap justify-content-around pb-2 pt-4">

										<div class="text-center"
											style="width: 110px; height: 100px;">

											<div class="rounded-circle circles-text" id="cali60"
												style="font-size: 40px;">0</div>
											<h6 class="fw-bold mt-3 mb-0">EQUIPMENT DUE</h6>
										</div>

									



									</div>



								</div>
							</div>


						</div>

						<div class="col-md-3">
							

						</div>
						
						<div class="col-md-3">
							<div class="card text-white bg-danger-gradient full-height">
								<div class="card-body">



									<div class="card-title font-weight-bold">SERVICE OVERDUE</div>
									<div class="card-category"></div>

									<div class="d-flex flex-wrap justify-content-around pb-2 pt-4">

										<div class="text-center"
											style="width: 110px; height: 100px;">

											<div class="rounded-circle circles-text" id="serover"
												style="font-size: 40px;">0</div>
											<h6 class="fw-bold mt-3 mb-0">EQUIPMENT DUE</h6>
										</div>

									</div>

								</div>
							</div>


						</div>
						
						<div class="col-md-3">
							<div class="card text-white bg-warning-gradient full-height">
								<div class="card-body">



									<div class="card-title font-weight-bold">SERVICE DUE 30 DAYS</div>
									<div class="card-category"></div>

									<div class="d-flex flex-wrap justify-content-around pb-2 pt-4">

										<div class="text-center"
											style="width: 110px; height: 100px;">

											<div class="rounded-circle circles-text" id="ser30"
												style="font-size: 40px;">0</div>
											<h6 class="fw-bold mt-3 mb-0">EQUIPMENT DUE</h6>
										</div>

									</div>

								</div>
							</div>


						</div>
						
						<div class="col-md-3">
							<div class="card text-white bg-success-gradient card full-height">
								<div class="card-body">



									<div class="card-title font-weight-bold">SERVICE DUE 60 DAYS</div>
									<div class="card-category"></div>

									<div class="d-flex flex-wrap justify-content-around pb-2 pt-4">

										<div class="text-center"
											style="width: 110px; height: 100px;">

											<div class="rounded-circle circles-text" id="ser60"
												style="font-size: 40px;">0</div>
											<h6 class="fw-bold mt-3 mb-0">EQUIPMENT DUE</h6>
										</div>

									</div>

								</div>
							</div>


						</div>
						<div class="col-md-5">
							<div class="card full-height">
								<div class="card-body">



									<div class="card-title font-weight-bold">ISSUE TICKETS</div>
									<div class="card-category"></div>

									<div class="d-flex flex-wrap justify-content-around pb-2 pt-4">

										<div class="px-2 pb-2 pb-md-0 text-center">

											<div class="rounded-circle circles-text" id="totTicket"
												style="font-size: 40px;">0</div>
											<h6 class="fw-bold mt-3 mb-0">TICKETS</h6>
										</div>

										<div class="px-2 pb-2 pb-md-0 text-center">
										<div class="rounded-circle circles-text" id="openTicket"
												style="font-size: 40px;">0</div>										
											<h6 class="fw-bold mt-3 mb-0" style="color:#F25961">OPEN TICKETS</h6>
										</div>

										<div class="px-2 pb-2 pb-md-0 text-center">	
											<div class="rounded-circle circles-text" id="closeticket"
												style="font-size: 40px;">0</div>
											<h6 class="fw-bold mt-3 mb-0" style="color:#40daf5">CLOSE TICKETS</h6>
										</div>



									</div>


								</div>


							</div>


						</div>




					</div>



					<div class="row"></div>
					<!-- 					<div class="row"> -->
					<!-- 						<div class="col-md-8"> -->
					<!-- 							<div class="card"> -->
					<!-- 								<div class="card-header"> -->
					<!-- 									<div class="card-head-row"> -->
					<!-- 										<div class="card-title">User Statistics</div> -->
					<!-- 										<div class="card-tools"> -->
					<!-- 											<a href="#" class="btn btn-info btn-border btn-round btn-sm mr-2"> -->
					<!-- 												<span class="btn-label"> -->
					<!-- 													<i class="fa fa-pencil"></i> -->
					<!-- 												</span> -->
					<!-- 												Export -->
					<!-- 											</a> -->
					<!-- 											<a href="#" class="btn btn-info btn-border btn-round btn-sm"> -->
					<!-- 												<span class="btn-label"> -->
					<!-- 													<i class="fa fa-print"></i> -->
					<!-- 												</span> -->
					<!-- 												Print -->
					<!-- 											</a> -->
					<!-- 										</div> -->
					<!-- 									</div> -->
					<!-- 								</div> -->
					<!-- 								<div class="card-body"> -->
					<!-- 									<div class="chart-container" style="min-height: 375px"> -->
					<!-- 										<canvas id="statisticsChart"></canvas> -->
					<!-- 									</div> -->
					<!-- 									<div id="myChartLegend"></div> -->
					<!-- 								</div> -->
					<!-- 							</div> -->
					<!-- 						</div> -->

					<!-- 					</div> -->

					<!-- 												<div class="card"> -->
					<!-- 								<div class="card-body pb-0"> -->
					<!-- 									<div class="h1 fw-bold float-right text-warning">+7%</div> -->
					<!-- 									<h2 class="mb-2">213</h2> -->
					<!-- 									<p class="text-muted">Transactions</p> -->
					<!-- 									<div class="pull-in sparkline-fix"> -->
					<!-- 										<div id="lineChart"></div> -->
					<!-- 									</div> -->
					<!-- 								</div> -->
					<!-- 							</div> -->


					<!-- 					<div class="row"> -->

					<!-- 						<div class="col-md-6"> -->
					<!-- 							<div class="card full-height"> -->
					<!-- 								<div class="card-header"> -->
					<!-- 									<div class="card-head-row"> -->
					<!-- 										<div class="card-title">Support Tickets</div> -->
					<!-- 										<div class="card-tools"> -->
					<!-- 											<ul class="nav nav-pills nav-secondary nav-pills-no-bd nav-sm" id="pills-tab" role="tablist"> -->
					<!-- 												<li class="nav-item"> -->
					<!-- 													<a class="nav-link" id="pills-today" data-toggle="pill" href="#pills-today" role="tab" aria-selected="true">Today</a> -->
					<!-- 												</li> -->
					<!-- 												<li class="nav-item"> -->
					<!-- 													<a class="nav-link active" id="pills-week" data-toggle="pill" href="#pills-week" role="tab" aria-selected="false">Week</a> -->
					<!-- 												</li> -->
					<!-- 												<li class="nav-item"> -->
					<!-- 													<a class="nav-link" id="pills-month" data-toggle="pill" href="#pills-month" role="tab" aria-selected="false">Month</a> -->
					<!-- 												</li> -->
					<!-- 											</ul> -->
					<!-- 										</div> -->
					<!-- 									</div> -->
					<!-- 								</div> -->
					<!-- 								<div class="card-body"> -->
					<!-- 									<div class="d-flex"> -->
					<!-- 										<div class="avatar avatar-online"> -->
					<!-- 											<span class="avatar-title rounded-circle border border-white bg-info">J</span> -->
					<!-- 										</div> -->
					<!-- 										<div class="flex-1 ml-3 pt-1"> -->
					<!-- 											<h6 class="text-uppercase fw-bold mb-1">Joko Subianto <span class="text-warning pl-3">pending</span></h6> -->
					<!-- 											<span class="text-muted">I am facing some trouble with my viewport. When i start my</span> -->
					<!-- 										</div> -->
					<!-- 										<div class="float-right pt-1"> -->
					<!-- 											<small class="text-muted">8:40 PM</small> -->
					<!-- 										</div> -->
					<!-- 									</div> -->
					<!-- 									<div class="separator-dashed"></div> -->
					<!-- 									<div class="d-flex"> -->
					<!-- 										<div class="avatar avatar-offline"> -->
					<!-- 											<span class="avatar-title rounded-circle border border-white bg-secondary">P</span> -->
					<!-- 										</div> -->
					<!-- 										<div class="flex-1 ml-3 pt-1"> -->
					<!-- 											<h6 class="text-uppercase fw-bold mb-1">Prabowo Widodo <span class="text-success pl-3">open</span></h6> -->
					<!-- 											<span class="text-muted">I have some query regarding the license issue.</span> -->
					<!-- 										</div> -->
					<!-- 										<div class="float-right pt-1"> -->
					<!-- 											<small class="text-muted">1 Day Ago</small> -->
					<!-- 										</div> -->
					<!-- 									</div> -->
					<!-- 									<div class="separator-dashed"></div> -->
					<!-- 									<div class="d-flex"> -->
					<!-- 										<div class="avatar avatar-away"> -->
					<!-- 											<span class="avatar-title rounded-circle border border-white bg-danger">L</span> -->
					<!-- 										</div> -->
					<!-- 										<div class="flex-1 ml-3 pt-1"> -->
					<!-- 											<h6 class="text-uppercase fw-bold mb-1">Lee Chong Wei <span class="text-muted pl-3">closed</span></h6> -->
					<!-- 											<span class="text-muted">Is there any update plan for RTL version near future?</span> -->
					<!-- 										</div> -->
					<!-- 										<div class="float-right pt-1"> -->
					<!-- 											<small class="text-muted">2 Days Ago</small> -->
					<!-- 										</div> -->
					<!-- 									</div> -->
					<!-- 									<div class="separator-dashed"></div> -->
					<!-- 									<div class="d-flex"> -->
					<!-- 										<div class="avatar avatar-offline"> -->
					<!-- 											<span class="avatar-title rounded-circle border border-white bg-secondary">P</span> -->
					<!-- 										</div> -->
					<!-- 										<div class="flex-1 ml-3 pt-1"> -->
					<!-- 											<h6 class="text-uppercase fw-bold mb-1">Peter Parker <span class="text-success pl-3">open</span></h6> -->
					<!-- 											<span class="text-muted">I have some query regarding the license issue.</span> -->
					<!-- 										</div> -->
					<!-- 										<div class="float-right pt-1"> -->
					<!-- 											<small class="text-muted">2 Day Ago</small> -->
					<!-- 										</div> -->
					<!-- 									</div> -->
					<!-- 									<div class="separator-dashed"></div> -->
					<!-- 									<div class="d-flex"> -->
					<!-- 										<div class="avatar avatar-away"> -->
					<!-- 											<span class="avatar-title rounded-circle border border-white bg-danger">L</span> -->
					<!-- 										</div> -->
					<!-- 										<div class="flex-1 ml-3 pt-1"> -->
					<!-- 											<h6 class="text-uppercase fw-bold mb-1">Logan Paul <span class="text-muted pl-3">closed</span></h6> -->
					<!-- 											<span class="text-muted">Is there any update plan for RTL version near future?</span> -->
					<!-- 										</div> -->
					<!-- 										<div class="float-right pt-1"> -->
					<!-- 											<small class="text-muted">2 Days Ago</small> -->
					<!-- 										</div> -->
					<!-- 									</div> -->
					<!-- 								</div> -->
					<!-- 							</div> -->
					<!-- 						</div> -->
					<!-- 					</div> -->
				</div>
			</div>

			<%@include file="../WEB-INF/jsp/footer.jsp"%>

		</div>


	</div>
	<%@include file="../WEB-INF/jsp/commJs.jsp"%>



	<script>
		// 		var totalIncomeChart = document.getElementById('totalIncomeChart').getContext('2d');

		// 		var mytotalIncomeChart = new Chart(totalIncomeChart, {
		// 			type: 'bar',
		// 			data: {
		// 				labels: ["S", "M", "T", "W", "T", "F", "S", "S", "M", "T"],
		// 				datasets : [{
		// 					label: "Total Income",
		// 					backgroundColor: '#ff9e27',
		// 					borderColor: 'rgb(23, 125, 255)',
		// 					data: [6, 4, 9, 5, 4, 6, 4, 3, 8, 10],
		// 				}],
		// 			},
		// 			options: {
		// 				responsive: true,
		// 				maintainAspectRatio: false,
		// 				legend: {
		// 					display: false,
		// 				},
		// 				scales: {
		// 					yAxes: [{
		// 						ticks: {
		// 							display: false //this will remove only the label
		// 						},
		// 						gridLines : {
		// 							drawBorder: false,
		// 							display : false
		// 						}
		// 					}],
		// 					xAxes : [ {
		// 						gridLines : {
		// 							drawBorder: false,
		// 							display : false
		// 						}
		// 					}]
		// 				},
		// 			}
		// 		});

		// // 		$('#lineChart').sparkline([105,103,123,100,95,105,115], {
		// // 			type: 'line',
		// // 			height: '70',
		// // 			width: '100%',
		// // 			lineWidth: '2',
		// // 			lineColor: '#ffa534',
		// // 			fillColor: 'rgba(255, 165, 52, .14)'
		// // 		});

		getVehicleStatus();
		function getVehicleStatus() {
			var todayDate = new Date().toISOString().slice(0, 10);

			$
					.ajax({

						type : 'GET',
						url : "getMaintenanceDashboard",
						data : {
							"date" : todayDate
						},
						contentType : "application/json; charset=utf-8",
						success : function(data) {

							document.getElementById("serover").innerHTML = data.serover;
							Circles.create({
								id : 'serover',
								radius : 35,
								value : data.serover,
								width : 7,
								text : (data.serover),
								colors : [ '#f1f1f1', '#F25961' ],
								duration : 400,
								wrpClass : 'circles-wrp',
								textClass : 'circles-text',
								styleWrapper : true,
								styleText : true
							})

							document.getElementById("totcal").innerHTML = data.totcal;
							Circles.create({
								id : 'totcal',
								radius : 35,
								value : data.totcal,
								width : 7,
								text : (data.totcal),
								colors : [ '#f1f1f1', '#40daf5' ],
								duration : 400,
								wrpClass : 'circles-wrp',
								textClass : 'circles-text',
								styleWrapper : true,
								styleText : true
							})

							document.getElementById("totTicket").innerHTML = data.totTicket;

							Circles.create({
								id : 'totTicket',
								radius : 35,
								value : data.totTicket,
								maxValue : data.totTicket,
								width : 7,
								text : (data.totTicket),
								colors : [ '#f1f1f1', '#F25961' ],
								duration : 400,
								wrpClass : 'circles-wrp',
								textClass : 'circles-text',
								styleWrapper : true,
								styleText : true
							})

							
							
							document.getElementById("openTicket").innerHTML = data.openTicket;

							Circles.create({
								id : 'openTicket',
								radius : 35,
								value : data.openTicket,
								maxValue : data.openTicket,
								width : 7,
								text : (data.openTicket),
								colors : [ '#f1f1f1', '#F25961' ],
								duration : 400,
								wrpClass : 'circles-wrp',
								textClass : 'circles-text',
								styleWrapper : true,
								styleText : true
							})

							document.getElementById("closeticket").innerHTML = data.closeticket;
							Circles.create({
								id : 'closeticket',
								radius : 35,
								value : data.closeticket,
								maxValue : data.closeticket,
								value : 20,
								maxValue : 30,
								width : 7,
								text : (data.closeticket),
								text : (20),
								colors : [ '#f1f1f1', '#40daf5' ],
								duration : 400,
								wrpClass : 'circles-wrp',
								textClass : 'circles-text',
								styleWrapper : true,
								styleText : true
							})

							document.getElementById("ser30").innerHTML = data.ser30;
							Circles.create({
								id : 'ser30',
								radius : 35,
								value : data.ser30,
								width : 7,
								text : (data.ser30),
								colors : [ '#f1f1f1', '#FF9E27' ],
								duration : 400,
								wrpClass : 'circles-wrp',
								textClass : 'circles-text',
								styleWrapper : true,
								styleText : true
							})

							
							document.getElementById("ser60").innerHTML = data.ser60;
							Circles.create({
								id : 'ser60',
								radius : 35,
								value : data.ser60,
								width : 7,
								text : (data.ser60),
								colors : [ '#f1f1f1', '#FF9E27' ],
								duration : 400,
								wrpClass : 'circles-wrp',
								textClass : 'circles-text',
								styleWrapper : true,
								styleText : true
							})


							document.getElementById("cali60").innerHTML = data.cali60;
							Circles.create({
								id : 'cali60',
								radius : 35,
								value : data.cali60,
								width : 7,
								text : (data.cali60),
								colors : [ '#f1f1f1', '#FF9E27' ],
								duration : 400,
								wrpClass : 'circles-wrp',
								textClass : 'circles-text',
								styleWrapper : true,
								styleText : true
							})
							
							document.getElementById("cali30").innerHTML = data.cali30;
							Circles.create({
								id : 'cali30',
								radius : 35,
								value : data.cali30,
								width : 7,
								text : (data.cali30),
								colors : [ '#f1f1f1', '#FF9E27' ],
								duration : 400,
								wrpClass : 'circles-wrp',
								textClass : 'circles-text',
								styleWrapper : true,
								styleText : true
							})

							//	alert(data.pendinCheckDoc);
							// 		    		document.getElementById("totgate").innerHTML=data.totgate;

							// 		    		Circles.create({
							// 		    			id:'pendinCheckDoc',
							// 		    			radius:35,
							// 		    			value:data.pendinCheckDoc,
							// 		    			maxValue:data.totgate,
							// 		    			width:7,
							// 		    			text: data.pendinCheckDoc,
							// 		    			colors:['#f1f1f1', '#40daf5'],
							// 		    			duration:400,
							// 		    			wrpClass:'circles-wrp',
							// 		    			textClass:'circles-text',
							// 		    			styleWrapper:true,
							// 		    			styleText:true
							// 		    		})

							// 		    			Circles.create({
							// id:'pendingVehicleReg',
							// radius:35,
							// value:data.pendingVehicleReg,
							// maxValue:data.totgate,
							// width:7,
							// text: data.pendingVehicleReg,
							// colors:['#f1f1f1', '#FF9E27'],
							// duration:400,
							// wrpClass:'circles-wrp',
							// textClass:'circles-text',
							// styleWrapper:true,
							// styleText:true
							// })

							// Circles.create({
							// id:'pendingLaneEntry',
							// radius:35,
							// value:data.pendingLaneEntry,
							// maxValue:data.totgate,
							// width:7,
							// text: data.pendingLaneEntry,
							// colors:['#f1f1f1', '#2BB930'],
							// duration:400,
							// wrpClass:'circles-wrp',
							// textClass:'circles-text',
							// styleWrapper:true,
							// styleText:true
							// })	

							// document.getElementById("totinc").innerHTML="INR "+((data.dalyTotIncome/100).toFixed(2));		    		

						},
						error : function(data) {
							alert("Data Not Found");

						}
					});

			// 			var todayDate = new Date().toISOString().slice(0,10); 			

			// 				var date2 = new Date(todayDate);
			// 			//	alert(todayDate);
			// 				document.getElementById("today").innerHTML=todayDate;		  
			// 						$.ajax({

			// 						    type: 'GET',
			// 						    url: "getDashBordData", 
			// 						    data: {"date":todayDate},
			// 						    contentType: "application/json; charset=utf-8",
			// 					        success: function(data){

			// 					    		Circles.create({
			// 					    			id:'apoymentCircles',
			// 					    			radius:35,
			// 					    			value:data.pendingApoyment,
			// 					    			maxValue:data.nfApoyment,
			// 					    			width:7,
			// 					    			text: (data.pendingApoyment+"/"+data.nfApoyment),
			// 					    			colors:['#f1f1f1', '#F25961'],
			// 					    			duration:400,
			// 					    			wrpClass:'circles-wrp',
			// 					    			textClass:'circles-text',
			// 					    			styleWrapper:true,
			// 					    			styleText:true
			// 					    		})	
			// 					        //	alert(data.pendinCheckDoc);
			// 					    		document.getElementById("totgate").innerHTML=data.totgate;

			// 					    		Circles.create({
			// 					    			id:'pendinCheckDoc',
			// 					    			radius:35,
			// 					    			value:data.pendinCheckDoc,
			// 					    			maxValue:data.totgate,
			// 					    			width:7,
			// 					    			text: data.pendinCheckDoc,
			// 					    			colors:['#f1f1f1', '#40daf5'],
			// 					    			duration:400,
			// 					    			wrpClass:'circles-wrp',
			// 					    			textClass:'circles-text',
			// 					    			styleWrapper:true,
			// 					    			styleText:true
			// 					    		})

			// 					    			Circles.create({
			// 			id:'pendingVehicleReg',
			// 			radius:35,
			// 			value:data.pendingVehicleReg,
			// 			maxValue:data.totgate,
			// 			width:7,
			// 			text: data.pendingVehicleReg,
			// 			colors:['#f1f1f1', '#FF9E27'],
			// 			duration:400,
			// 			wrpClass:'circles-wrp',
			// 			textClass:'circles-text',
			// 			styleWrapper:true,
			// 			styleText:true
			// 		})

			// 		Circles.create({
			// 			id:'pendingLaneEntry',
			// 			radius:35,
			// 			value:data.pendingLaneEntry,
			// 			maxValue:data.totgate,
			// 			width:7,
			// 			text: data.pendingLaneEntry,
			// 			colors:['#f1f1f1', '#2BB930'],
			// 			duration:400,
			// 			wrpClass:'circles-wrp',
			// 			textClass:'circles-text',
			// 			styleWrapper:true,
			// 			styleText:true
			// 		})	

			// 			document.getElementById("totinc").innerHTML="INR "+((data.dalyTotIncome/100).toFixed(2));		    		

			// 					        },
			// 					        error:function(data){
			// 					        	alert("Data Not Found");

			// 					        }
			// 						 }); 

		}

		// 		var totalIncomeChart = document.getElementById('totalIncomeChart').getContext('2d');

		// 		var mytotalIncomeChart = new Chart(totalIncomeChart, {
		// 			type: 'bar',
		// 			data: {
		// 				labels: ["Car", "Truck", "Van", "Bus", "2/Wheeler ", "3/Wheeler","MPV","UTV"],
		// 				datasets : [{
		// 					label: "Total Income",
		// 					backgroundColor: '#ff9e27',
		// 					borderColor: 'rgb(23, 125, 255)',
		// 					data: [5, 4, 9, 5, 4, 6,8,2],
		// 				}],
		// 			},
		// 			options: {
		// 				responsive: true,
		// 				maintainAspectRatio: false,
		// 				legend: {
		// 					display: false,
		// 				},
		// 				scales: {
		// 					yAxes: [{
		// 						ticks: {
		// 							display: false //this will remove only the label
		// 						},
		// 						gridLines : {
		// 							drawBorder: false,
		// 							display : false
		// 						}
		// 					}],
		// 					xAxes : [ {
		// 						gridLines : {
		// 							drawBorder: false,
		// 							display : false
		// 						}
		// 					}]
		// 				},
		// 			}
		// 		});
	</script>
</body>
</html>
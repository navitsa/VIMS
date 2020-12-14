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
				<div class="panel-header bg-primary-gradient">
					<div class="page-inner py-5">
						<div class="d-flex align-items-left align-items-md-center flex-column flex-md-row">
							<div>
								<h2 class="text-white pb-2 fw-bold">Dashboard</h2>
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
						<div class="col-md-7">
							<div class="card full-height">
								<div class="card-body">
									<div class="card-title">Overall statistics</div>
									<div class="card-category"></div>
									<div class="d-flex flex-wrap justify-content-around pb-2 pt-4">
									
									     <div class="border border-success text-center" style="width:110px; height:100px;">

											<div class="rounded-circle circles-text" id="totgate" style="font-size: 40px;">0</div>
											<h6 class="fw-bold mt-3 mb-0">Total Gate Entry</h6>
										</div>
        	
										<div class="px-2 pb-2 pb-md-0 text-center">
											<div id="pendinCheckDoc"></div>
											<h6 class="fw-bold mt-3 mb-0">CHECK DOCUMENT</h6>
										</div>
										<div class="px-2 pb-2 pb-md-0 text-center">
											<div id="pendingVehicleReg"></div>
											<h6 class="fw-bold mt-3 mb-0">VEHICLE REGISTRATION</h6>
										</div>
										<div class="px-2 pb-2 pb-md-0 text-center">
											<div id="pendingLaneEntry"></div>
											<h6 class="fw-bold mt-3 mb-0">LANE ENTRY</h6>
										</div>
										<div class="px-2 pb-2 pb-md-0 text-center">
											<div id="apoymentCircles"></div>
											<h6 class="fw-bold mt-3 mb-0">APPOINTMENT</h6>
										</div>
									</div>
								</div>
							</div>
						</div>
						
						
						
						<div class="col-md-4">
						<div class="row mt-1">
							<div class="col-md-12">
							<div class="card card-primary">
								<div class="card-header">
									<div class="card-title">Today Total Income</div>
									<div class="card-category" id="today"></div>
								</div>
								<div class="card-body pb-0">
									<div class="mb-5 mt-5">
										<h1 id="totinc">0</h1>
									</div>
<!-- 									<div class="pull-in"> -->
<!-- 										<canvas id=""></canvas> -->
<!-- 									</div> -->
								</div>
							</div>
							</div>
					</div>
						</div>
					</div>
				<div class="row">
					<div class="col-md-4">
							
								<div class="card-body">
								<img src="resources/assets/img/adams-car.gif" alt="navbar brand" class="navbar-brand" style="width: 400px; height: 300px;">
<!-- 								<img src="resources/assets/img/dashimg.jpg" alt="navbar brand" class="navbar-brand" style="width: 400px; height: 300px;"> -->
								
								</div>
							
						</div>
					
			
						<div class="col-md-7">
							<div class="card full-height">
								<div class="card-body">
									<div class="card-title">Vehicle Status</div>
									<div class="row py-3">
										<div class="col-md-3 d-flex flex-column justify-content-around">
											<div>
												<h6 class="fw-bold text-uppercase text-success op-8"></h6>
												<h3 class="fw-bold"></h3>
											</div>
											<div>
												<h6 class="fw-bold text-uppercase text-danger op-8"></h6>
												<h3 class="fw-bold"></h3>
											</div>
										</div>
										<div class="col-md-9">
											<div id="chart-container">
												<canvas id="totalIncomeChart"></canvas>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
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

// 		$('#lineChart').sparkline([105,103,123,100,95,105,115], {
// 			type: 'line',
// 			height: '70',
// 			width: '100%',
// 			lineWidth: '2',
// 			lineColor: '#ffa534',
// 			fillColor: 'rgba(255, 165, 52, .14)'
// 		});


		 getVehicleStatus();
		function getVehicleStatus()
		{
		
			var todayDate = new Date().toISOString().slice(0,10); 			
						
				var date2 = new Date(todayDate);
			//	alert(todayDate);
				document.getElementById("today").innerHTML=todayDate;		  
						$.ajax({

						    type: 'GET',
						    url: "getDashBordData", 
						    data: {"date":todayDate},
						    contentType: "application/json; charset=utf-8",
					        success: function(data){
					

					    		Circles.create({
					    			id:'apoymentCircles',
					    			radius:35,
					    			value:data.pendingApoyment,
					    			maxValue:data.nfApoyment,
					    			width:7,
					    			text: (data.pendingApoyment+"/"+data.nfApoyment),
					    			colors:['#f1f1f1', '#F25961'],
					    			duration:400,
					    			wrpClass:'circles-wrp',
					    			textClass:'circles-text',
					    			styleWrapper:true,
					    			styleText:true
					    		})	
					        //	alert(data.pendinCheckDoc);
					    		document.getElementById("totgate").innerHTML=data.totgate;
					    		
					    		Circles.create({
					    			id:'pendinCheckDoc',
					    			radius:35,
					    			value:data.pendinCheckDoc,
					    			maxValue:data.totgate,
					    			width:7,
					    			text: data.pendinCheckDoc,
					    			colors:['#f1f1f1', '#40daf5'],
					    			duration:400,
					    			wrpClass:'circles-wrp',
					    			textClass:'circles-text',
					    			styleWrapper:true,
					    			styleText:true
					    		})
					    		
					    		
					    			Circles.create({
			id:'pendingVehicleReg',
			radius:35,
			value:data.pendingVehicleReg,
			maxValue:data.totgate,
			width:7,
			text: data.pendingVehicleReg,
			colors:['#f1f1f1', '#FF9E27'],
			duration:400,
			wrpClass:'circles-wrp',
			textClass:'circles-text',
			styleWrapper:true,
			styleText:true
		})

		Circles.create({
			id:'pendingLaneEntry',
			radius:35,
			value:data.pendingLaneEntry,
			maxValue:data.totgate,
			width:7,
			text: data.pendingLaneEntry,
			colors:['#f1f1f1', '#2BB930'],
			duration:400,
			wrpClass:'circles-wrp',
			textClass:'circles-text',
			styleWrapper:true,
			styleText:true
		})	
				    		
					    		
			document.getElementById("totinc").innerHTML="INR "+((data.dalyTotIncome/100).toFixed(2));		    		
			    		
					    		
					    		
					        },
					        error:function(data){
					        	alert("Data Not Found");
					           
					        }
						 }); 

		}
		
	
		
		var totalIncomeChart = document.getElementById('totalIncomeChart').getContext('2d');

		var mytotalIncomeChart = new Chart(totalIncomeChart, {
			type: 'bar',
			data: {
				labels: ["Car", "Truck", "Van", "Bus", "2/Wheeler ", "3/Wheeler","MPV","UTV"],
				datasets : [{
					label: "Total Income",
					backgroundColor: '#ff9e27',
					borderColor: 'rgb(23, 125, 255)',
					data: [5, 4, 9, 5, 4, 6,8,2],
				}],
			},
			options: {
				responsive: true,
				maintainAspectRatio: false,
				legend: {
					display: false,
				},
				scales: {
					yAxes: [{
						ticks: {
							display: false //this will remove only the label
						},
						gridLines : {
							drawBorder: false,
							display : false
						}
					}],
					xAxes : [ {
						gridLines : {
							drawBorder: false,
							display : false
						}
					}]
				},
			}
		});






	</script>
</body>
</html>
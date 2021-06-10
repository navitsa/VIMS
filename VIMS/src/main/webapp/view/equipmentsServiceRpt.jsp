<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ page isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>



<html lang="en">
<head>
<%@include file="../WEB-INF/jsp/head.jsp"%>

<style>
.vidSty {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 30px;
	font-weight: bold;
	color: #02d41b;
}

.textred {
	font-family: Arial, Helvetica, sans-serif;
	border: 0px solid #b30000;
	font-size: 14px;
	font-weight: bold;
	text-align: center;
	color: #2c03fc;
}

.fontst {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	height: 30px;
}

.l-fontst {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	height: 5px;
	margin-top: 0px;
}

.iconali {
	position: absolute;
	top: 6px;
	right: -7px;
}

.capCam {
	height: 100px;
	width: 210px;
}

.cursiz {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	width: 48px;
	color: #ff8000;
}

.amt {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	width: 60px;
	color: blue;
	text-align: right;
}

.iconstyle {
	width: 7%;
	color: blue';
}

.icon-pre-ve {
	width: 150%;
}
</style>

</head>
<body onload="checkStatusofDropdowns();">
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
					<div class="page-inner py-3">
						<div
							class="d-flex align-items-left align-items-md-center flex-column flex-md-row">
							<div class="col-xl-3 col-lg-2">
								<h2 class="text-white pb-2 fw-bold">Service Report</h2>
							</div>
							<div class="col-xl-2 col-lg-2"></div>
							<div class="ml-md-auto py-2 py-md-4"></div>

							<div class="ml-md-auto py-2 py-md-4"></div>
						</div>
					</div>
				</div>

				<div class="page-inner mt--5">
					<div class="container-fluid">
						<div class="row">
							<div class="col-xl-2 col-lg-2">
								<form:form action="privewEquipmentsServiceReport" method="POST">
									<div class="card shadow mb-4" style="height: 640px;">
										<div class="card border-left-primary shadow h-100 py-2">
											<div class="card-body">

												<div class="form-group row">
													<div class="col-sm-12">
														<label class="l-fontst">Service Date</label> </br> </br> <label
															class="l-fontst">From</label> <input
															class="form-control fontst" type="date" name="fromdate"
															required id="fromdate" /> <label class="l-fontst">To</label>
														<input class="form-control fontst" type="date"
															name="todate" required id="todate" />
													</div>
												</div>

												<div class="form-group row">

													<div class="col-sm-12">
														<button type="button"
															onclick="loadreport(); this.onclick=null; " id="view"
															class="btn  btn-block btn-success btn-rounded tabStyle">View</button>
													</div>

												</div>

												<div class="form-group row">

													<div class="col-sm-12">
														<button type="submit" onclick="getServiceDetails();" 
															class="btn  btn-block btn-danger btn-rounded tabStyle">Print</button>
														<!-- 											<a href="#" class="btn btn-primary" onclick="runCancelInvoice();">Invoice Cancel</a>																 -->
													</div>

												</div>
											</div>
										</div>
									</div>

								</form:form>


							</div>



							<div class="col-xl-10 col-lg-10">
								<div class="col-sm-12">




									<c:if test="${pdfViewEq != null }">
										<embed type="application/pdf"
											src="data:application/pdf;base64,${pdfViewEq}"
											style="height: 500px; width: 100%">
										</embed>
									</c:if>
									
									<table id="tableMoSaDetails" class="table table-hover"
										style="display: none;margin-top: 5%">
										<thead>
											<tr>
												<td><lable style='font-size:15px'
														class='l-fontst font-weight-bold'>
													Type/Model No/Serial No</lable></td>
												<td><lable style='font-size:15px'
														class='l-fontst font-weight-bold'>Service Date</lable></td>
												<td><lable style='font-size:15px'
														class='l-fontst font-weight-bold'>Next Service
													Date</lable></td>
													<td><lable style='font-size:15px'
														class='l-fontst font-weight-bold'>Service report
													</lable></td>
												<td><lable style='font-size:15px'
														class='l-fontst font-weight-bold'>User</lable></td>
												
											</tr>
										</thead>
										<tbody>

										</tbody>
									</table>



								</div>

							</div>










						</div>

					</div>
				</div>

			</div>
			<%@include file="../WEB-INF/jsp/footer.jsp"%>
		</div>
	</div>
	<%@include file="../WEB-INF/jsp/commJs.jsp"%>

	<script>
		/* 		/* function loadreport() {
		
		 var result = "<tr><td><lable style='font-size:15px' class='l-fontst font-weight-bold'> Type/ Make/ Model/Serial No</lable>"
		 + "<td><lable style='font-size:15px' class='l-fontst font-weight-bold'>Service Date</lable>"
		 + "<td><lable style='font-size:15px' class='l-fontst font-weight-bold'>Next Service Date</lable>"
		 + "<td><lable style='font-size:15px' class='l-fontst font-weight-bold'>Remarks</lable>"
		 + "<td><lable style='font-size:15px' class='l-fontst font-weight-bold'>Service User</lable>"
		 + "<td><tr>"
		 +"<tr><td><input style='font-size:15px; margin-bottom:1%' class='form-control fontst' name='' type'text' value= '350A''rrr' readonly='true'  />"
		 + "<td><input style='font-size:15px; margin-bottom:1%' class='form-control fontst' name='' type'text' value= '350A''rrr' readonly='true'  />"
		 + "<td><input style='font-size:15px; margin-bottom:1%' class='form-control fontst' name='' type'text' value= '350A''rrr' readonly='true'  />"
		 + "<td><input style='font-size:15px; margin-bottom:1%' class='form-control fontst' name='' type'text' value= '350A''rrr' readonly='true'  />"
		 + "<td><input style='font-size:15px; margin-bottom:1%' class='form-control fontst' name='' type'text' value= '350A''rrr' readonly='true'  />"
		 + "<td><tr>"
		 $("#tableMoSaDetails tbody").append(result); 

		 } */
		/* 
		function loadreport() {
				

				$
						.ajax({

							type : 'GET',
							url : "loadservicereport",
							data : {
								"date" : todate
							},
							success : function(data) {

								document.getElementById("").innerHTML = data.totcal;
								

								var result = "<tr><td><lable style='font-size:15px' class='l-fontst font-weight-bold'> Type/ Make/ Model/Serial No</lable>"
								+ "<td><lable style='font-size:15px' class='l-fontst font-weight-bold'>Service Date</lable>"
								+ "<td><lable style='font-size:15px' class='l-fontst font-weight-bold'>Next Service Date</lable>"
								+ "<td><lable style='font-size:15px' class='l-fontst font-weight-bold'>Remarks</lable>"
								+ "<td><lable style='font-size:15px' class='l-fontst font-weight-bold'>Service User</lable>"
								+ "<td><tr>"
								+"<tr><td><input style='font-size:15px; margin-bottom:1%' class='form-control fontst' name='' type'text' value= '350A' readonly='true'  />"
								+ "<td><input style='font-size:15px; margin-bottom:1%' class='form-control fontst' name='' type'text' value= '350A' readonly='true'  />"
								+ "<td><input style='font-size:15px; margin-bottom:1%' class='form-control fontst' name='' type'text' value= '350A' readonly='true'  />"
								+ "<td><input style='font-size:15px; margin-bottom:1%' class='form-control fontst' name='' type'text' value= '350A' readonly='true'  />"
								+ "<td><input style='font-size:15px; margin-bottom:1%' class='form-control fontst' name='' type'text' value= '350A' readonly='true'  />"
								+ "<td><tr>"
						$("#tableMoSaDetails tbody").append(result); 
								})
							},
							error : function(data) {
								alert("Data Not Found");

							}
						});
		 */
		 
			$(document).ready(function() {
				$("#view").click(function() {
					$("#tableMoSaDetails").toggle();
			
				});
			});

		function loadreport() {

			var mak = document.getElementById("fromdate").value;
			var cls = document.getElementById("todate").value;
		
			$("table tbody").empty();

			$
					.ajax({
						type : 'GET',
						url : "loadservicereport",
						data : {
							"date" : mak,

						},
						success : function(model) {

							$("table tbody").empty();
							for (var i = 0; i < model.length; i++) {

								var result = "<tr><td>"
										+ model[i].equipmentID.eqModelID.eqTypeID.eqType+"/"+model[i].equipmentID.eqModelID.eqModel+"/"+model[i].equipmentID.serialNo
										+ "</td><td>"
										+ model[i].servicesDate
										+ "</td><td>"
										+ model[i].nextServicesDate
										+ "</td><td><a href=equipmentsServiceRpt?servicesReport="
										+ model[i].servicesReport
										+"><i class='fas fa-file-pdf'></i></a>"
										+ "</td><td>"
										+ model[i].userId.userName
										+ "</td><td>"
										

								$("table tbody").append(result);
							}
						},
						error : function() {
							alert("Model information not found !");
						}

					});

		}
		
		
		function getServiceDetails() {
			
			var from = document.getElementById("fromdate").value;
			var to = document.getElementById("todate").value;
		
				$.ajax({
							type : 'GET',
							url : "getDetailsByDate",
							data : {"fromdate" : from,"todate":to  },
							success : function(data) {
							if(data==""){
								
								alert("No Service Selected Date");		
							}
							},
							error : function() {
								alert("Error in DB");
							}

						});
			}
		
	</script>

</body>
</html>
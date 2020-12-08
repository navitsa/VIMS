<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ page isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>



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
				<div class="page-inner">	
					<div class="page-header">
						<h4 class="page-title">Issue VI Report</h4>
						<ul class="breadcrumbs">
							<li class="nav-home">
								<a href="#">
									<i class="flaticon-home"></i>
								</a>
							</li>
							<li class="separator">
								<i class="flaticon-right-arrow"></i>
							</li>
							<li class="nav-item">
								<a href="#">Vehicle Inspection</a>
							</li>
							<li class="separator">
								<i class="flaticon-right-arrow"></i>
							</li>
							<li class="nav-item">
								<a href="#">Issue VI Report</a>
							</li>
						</ul>
					</div>

					  <input name="status" type="checkbox" value="true" checked> Only inspected parts
					  <br><br>
					
						<div class="table-responsive">
							<table id="viTable" class="display table table-bordered table-hover" cellspacing="0" width="100%">
								<thead>
									<tr>
										<th>Registration #</th>
										<th>License Plate #</th>
										<th>Date</th>
										<th>Start Time</th>
										<th>End Time</th>
										<th>Actions</th>
									</tr>
								</thead>
						
								<tbody>
									<c:forEach items="${checklistMaster}" var="chMaster">
										<tr>
											<td>${chMaster.vr.vregID}</td>
											<td>${chMaster.vehicleID}</td>
											<td>${chMaster.date}</td>
											<td>${chMaster.time}</td>
											<td>${chMaster.endtime}</td>
											<td><a href="printVisualInspectReport?chMasterID=${chMaster.cheklistID}&status=true" class="btn btn-success" role="button"><i class="fas fa-print"></i> Print</a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						

				</div>
			</div>	
			<%@include file="../WEB-INF/jsp/footer.jsp"%>			
		</div>
	</div>
<%@include file="../WEB-INF/jsp/commJs.jsp"%>

<script>
	function setStatus(){
		if ($('#switch1').is(":checked")) {
		      //alert($('#switch1').val());
		      //document.getElementById("status").innerHTML=$('#switch1').val(); 
		}
	} 
</script>
<script>
	$(window).on("load",function(){
	    $(".loader-wrapper").fadeOut("slow");
	});
</script>

	<script>
		$(document).ready(function() {
		    $('#viTable').DataTable( {
		    	//"scrollY": "400px",
		    	"processing": true,
		    	"order": [[ 0, "desc" ]],
		        "columnDefs": [{ "orderable": false, "targets": 1 },
		        				{ "orderable": false, "targets": 3 },
		        				{ "orderable": false, "targets": 4 },
		        				{ "orderable": false, "targets": 5 }]
		    } );
		} );
	</script>

</body>
</html>
<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ page isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>



<html lang="en">
<head>
	<%@include file="../WEB-INF/jsp/head.jsp"%>
	
	<style>
.error1{color:red;font-size: 12px }
         
.fontcolor{color: blue;}
</style>
	
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
							<h4 class="page-title">Completed Visual Inspections</h4>
							<ul class="breadcrumbs">
								<li class="nav-home">
									<a href="#">
										<i class="flaticon-home"></i>
									</a>
								</li>
								<li class="separator">
									<i class="flaticon-right-arrow"></i>
								</li>
								
								
							</ul>
						</div>
				
		               <div class="card-body">
<!-- 					<h4>Completed Visual Inspections</h4> -->
					
					  <div class="custom-control custom-switch">
					    <input type="checkbox" class="custom-control-input" id="switch1" value="true" name="status">
					    <label class="custom-control-label" for="switch1">only the checked parts</label>
					  </div>
					  
					  <br>
					  <div class="table-responsive-lg">
						<table class="table table-sm table-striped">
						  <thead>
						    <tr>
						      <th scope="col">Registration #</th>
						      <th scope="col">License Plate #</th>
						      <th scope="col">Date</th>
						      <th scope="col">Start Time</th>
						      <th scope="col">End Time</th>
						      <th scope="col">Actions<th>
						    </tr>
						  </thead>
						  <tbody>
						  	<c:forEach items="${checklistMaster}" var="chMaster">
							    <tr>
							      <th scope="row">${chMaster.vr.vregID}</th>
							      <td>${chMaster.vehicleID}</td>
							      <td>${chMaster.date}</td>
							      <td>${chMaster.time}</td>
							      <td>${chMaster.endtime}</td>
							      <td>
							      	<a href="printVisualInspectReport?chMasterID=${chMaster.cheklistID}&status=true" class="btn btn-success" role="button"><i class="fas fa-print"></i> Print</a>
							      </td>
							    </tr>
							</c:forEach>
						  </tbody>
					</table>
				</div>
								
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

</body>
</html>
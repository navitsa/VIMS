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
							<h4 class="page-title">Previous Reports</h4>
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
                	
							<table class="display" id="example" style="width:100%">
								<thead>
								   <tr>
								      <th>#</th>
								      <th>Registration No</th>
								      <th>Vehicle No</th>
								      <th>Date & Time</th>
								      <th>Action</th>							      
								   </tr>
								</thead>
								<tbody>
								                
								  <c:forEach items="${previousReports}" var="result">
								      <tr>
								        <th>${result.test_value_file_id}</th>
								        <td>${result.vreg.vregID}</td>
								        <td>${result.vehicle_id}</td>
								        <td>${result.date}</td>
								        <td>
											<a href="getTestReport?register_id=${result.vreg.vregID}&test_value_file_id=${result.test_value_file_id}" class="btn btn-success" role="button">
											<i class="fas fa-print"></i> Print</a>
										</td>
								      </tr>
								  </c:forEach>
								                       
								</tbody>
							</table>

	            </div> <!-- End of card body -->

							
	
				
				
				
				
				
					</div>
				
			</div>	
			<%@include file="../WEB-INF/jsp/footer.jsp"%>			
		</div>
	</div>
<%@include file="../WEB-INF/jsp/commJs.jsp"%>

		<script>
	$(document).ready(function() {
	    $('#example').DataTable( {
	    	"scrollY": "400px",
	    	"processing": true,
	        "order": [[ 0, "desc" ]],
	        "columnDefs": [{ "orderable": false, "targets": 4 }]
	    } );
	} );
	</script>

</body>
</html>
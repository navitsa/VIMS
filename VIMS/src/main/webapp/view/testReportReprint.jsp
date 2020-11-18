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
						<h4 class="page-title">Previous Reports</h4>
						<ul class="breadcrumbs">
							<li class="nav-home"><a href="#"> <i
									class="flaticon-home"></i>
							</a></li>
							<li class="separator"><i class="flaticon-right-arrow"></i></li>


						</ul>
					</div>
	              <!-- Card -->
	              <div class="card shadow mb-4">
<!-- 	            <div class="card-header py-3">
						<h6 class="m-0 font-weight-bold text-primary">Previous Reports</h6>
	                </div> -->
	                <div class="card-body">
	                	
								<table class="display" id="example" style="width:100%">
									<thead>
									   <tr>
									      <th>#</th>
									      <th>Registration No</th>
									      <th>Vehicle No</th>
									      <th>Date & Time</th>
									      <th>Color</th>
									      <th>B / W</th>							      
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
												<a href="getTestReport?register_id=${result.vreg.vregID}&test_value_file_id=${result.test_value_file_id}&color=1" class="btn btn-primary" onclick="checkAvailableResults()">
												<i class="fas fa-print"></i> Color</a>
											</td>
									        <td>
												<a href="getTestReport?register_id=${result.vreg.vregID}&test_value_file_id=${result.test_value_file_id}&color=0" class="btn btn-primary" onclick="checkAvailableResults()">
												<i class="fas fa-print"></i> B/W</a>
											</td>
									      </tr>
									  </c:forEach>
									                       
									</tbody>
								</table>
	
		            </div> <!-- End of card body -->
	              </div>


				</div>
			</div>	
			<%@include file="../WEB-INF/jsp/footer.jsp"%>			
		</div>
	</div>
<%@include file="../WEB-INF/jsp/commJs.jsp"%>

<!--    <script src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script> -->
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

<script>
function checkAvailableResults()
{
	//alert("hello...");
	
	$.ajax({
	    type: 'GET',
	    url: "checkAvailableTestResults",
	    data: {"regID" : "0009"},
	    success: function(data){
	    	
	    },
	    error:function(){
	        //alert("error");
	    }
	
	});
	
}
</script>


</body>
</html>
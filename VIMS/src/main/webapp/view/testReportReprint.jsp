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
								<a href="#">Reprint Test Report</a>
							</li>
						</ul>
					</div>
					
	              <!-- Card -->
	              <div class="card shadow mb-4">
<!-- 	            <div class="card-header py-3">
						<h6 class="m-0 font-weight-bold text-primary">Previous Reports</h6>
	                </div> -->
	                <div class="card-body">
	                
<div class="input-group mb-3">
  <input type="text" id="vehicleNo" class="form-control" placeholder="Vehicle No" aria-label="Vehicle No" aria-describedby="basic-addon2">
  <div class="input-group-append">
    <button class="btn btn-outline-primary" type="button" onclick="findReport()">Search</button>
  </div>
</div>
<table class="table table-sm table-hover">
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
	                       
	</tbody>
</table>	                
	                
<%-- 	                	<div class="table-responsive">               	
								<table class="display table table-bordered table-hover" id="example" cellspacing="0" style="width:100%">
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
												<a href="getTestReport?register_id=${result.vreg.vregID}&test_value_file_id=${result.test_value_file_id}&color=1"  class="btn btn-success btn-sm">
													<i class="fas fa-print"></i>
												</a>
											</td>
									        <td>
												<a href="getTestReport?register_id=${result.vreg.vregID}&test_value_file_id=${result.test_value_file_id}&color=0" class="btn btn-default btn-sm">
													<i class="fas fa-print"></i>
												</a>
											</td>
									      </tr>
									  </c:forEach>
									                       
									</tbody>
								</table>
						</div> --%>

		            </div> <!-- End of card body -->
	              </div>


				</div>
			</div>	
			<%@include file="../WEB-INF/jsp/footer.jsp"%>			
		</div>
	</div>
<%@include file="../WEB-INF/jsp/commJs.jsp"%>

<script>
function findReport()
{
	var vehicleNo = document.getElementById("vehicleNo").value;
	
	if (vehicleNo=="") {
		$("table tbody").empty();
		return;		
	}else{
		$.ajax({
	        type: 'GET',
	        url: "findTestReportByVehicleNo",
	        data: {"vehicleNo" : vehicleNo},
	        success: function(data){

	        	$("table tbody").empty();
				for(var i=0; i<data.length; i++){
					var markup = "<tr><th scope='row'>"+data[i].test_value_file_id+"</th><td>"+data[i].vreg.vregID+"</td><td>"+data[i].vehicle_id+"</td><td>"+data[i].date+"</td><td><a href='getTestReport?register_id="+data[i].vreg.vregID+"&test_value_file_id="+data[i].test_value_file_id+"&color=1' class='btn btn-success btn-sm'><i class='fas fa-print'></i></a></td><td><a href='getTestReport?register_id="+data[i].vreg.vregID+"&test_value_file_id="+data[i].test_value_file_id+"&color=0' class='btn btn-default btn-sm'><i class='fas fa-print'></i></a></td> </tr>";
	           		 $("table tbody").append(markup);
	           	 }
	        	
	        },
	        error:function(){
	            alert("No Data...!");
	        }
        
		});
	}
}


</script>
	
	<script>
	$(document).ready(function() {
	    $('#example').DataTable( {
	    	//"scrollY": "400px",
	    	"processing": true,
	        "order": [[ 0, "desc" ]],
	        "columnDefs": [{ "orderable": false, "targets": 2 },
	        				{ "orderable": false, "targets": 4 },
	        				{ "orderable": false, "targets": 5 }]
	    } );
	} );
	</script>

<!-- <script>
function checkAvailableResults(regID,test_value_file_id,color)
{
	//alert(regID+" "+test_value_file_id+" "+color);
	
	$.ajax({
	    type: 'GET',
	    url: "checkAvailableTestResults",
	    data: {"regID" : regID},
	    success: function(map){
	    	confirmMsg(regID,test_value_file_id,color,map);
	    },
	    error:function(){
	        //alert("error");
	    }
	
	});
	
}
</script>

<script>
function confirmMsg(regID,test_value_file_id,color,map) {
	
	swal({
		title: 'Are you sure?',
		text: "Available Results :\n1. Visual Inspection : "+map[1]+"\n2. Emission Petrol : "+map[3]+"\n3. Emission Diesel : "+map[2],
		type: 'warning',
		buttons:{
			confirm: {
				text : 'Yes, print it!',
				className : 'btn btn-success'
			},
			cancel: {
				visible: true,
				className: 'btn btn-danger'
			}
		}
	}).then((value) => {
		if (value) {
			//return fetch("http://localhost:8080/VIMS/getTestReport?register_id=0002&test_value_file_id=1&color=0");
			window.location.href = "getTestReport?register_id="+regID+"&test_value_file_id="+test_value_file_id+"&color="+color;
		} else {
			swal.close();
		}
	});
	
}
</script> -->


</body>
</html>
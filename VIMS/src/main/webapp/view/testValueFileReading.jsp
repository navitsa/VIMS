<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ page isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>



<html lang="en">
<head>
	<%@include file="../WEB-INF/jsp/head.jsp"%>
	
<style>
#loading-effect{
  position: absolute;
  top: 15%;
  left: 80%;
  transform: translate(-50%,-50%);
  -ms-transform: translate(-50%,-50%);
}
#text{
  position: absolute;
  top: 15%;
  left: 88%;
  font-size: 15px;
  color: green;
  transform: translate(-50%,-50%);
  -ms-transform: translate(-50%,-50%);
}

</style>
	
</head>
<body onload="Reading()">
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
						<h4 class="page-title">Test Results</h4>
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
								<a href="#">Issue Test Report</a>
							</li>
						</ul>
					</div>


	              <!-- Card -->
	              <div class="card shadow mb-4">
	                <div class="card-body">
						<!-- <input type="button" class="btn btn-primary btn-sm" value="Read Test Results" onclick="Reading()"> -->
	                	<!-- <input type="button" class="btn btn-primary btn-sm" value="Read Emission Results (AVL DB)" onclick="ReadingEmissionResults()"> -->
	                	<!-- <input type="button" class="btn btn-primary btn-sm" value="Download file from FTP" onclick="download()"> -->
	                	
							<div class="table-responsive-lg">
								<table class="table table-sm" id="pendingResultsTable">
									<thead>
									   <tr>
									      <th style="width:50px" scope="col">#</th>
									      <th scope="col">Registration No</th>
									      <th scope="col">Vehicle No</th>
									      <th scope="col">Date & Time</th>
									      <th scope="col">Color</th>
									      <th scope="col">B / W</th>
									      <th scope="col"></th>
									   </tr>
									</thead>
									<tbody>
									  <c:forEach items="${testValueFileHeader}" var="result">
									      <tr>
									        <th scope="row">${result.test_value_file_id}</th>
									        <td>${result.vreg.vregID}</td>
									        <td>${result.vehicle_id}</td>
									        <td>${result.date}</td>
									        <td>
												<a href="#" class="btn btn-success btn-sm" role="button" onclick="checkAvailableResults('${result.vreg.vregID}','${result.test_value_file_id}',1)">
													<i class="fas fa-print"></i>
												</a>
											</td>
											<td>
												<a href="#" class="btn btn-default btn-sm" role="button" onclick="checkAvailableResults('${result.vreg.vregID}','${result.test_value_file_id}',0)">
													<i class="fas fa-print"></i>
												</a>
											</td>
									      </tr>
									  </c:forEach>							                
	                       
									</tbody>
								</table>
							</div>
	
		            </div> <!-- End of card body -->
	              </div>	
				
							
				</div>
			</div>	
			<%@include file="../WEB-INF/jsp/footer.jsp"%>			
		</div>
	</div>
<%@include file="../WEB-INF/jsp/commJs.jsp"%>

<script>
	function Reading()
	{
		//window.location.href = "readingTestValues";
		//document.getElementById("overlay").style.display = "block";
		
		$.ajax({
		    type: 'GET',
		    url: "readingTestValues",
		    success: function(data){
		    	document.getElementById("overlay").style.display = "none";
	        	$("#pendingResultsTable tbody").empty();
				for(var i=0; i<data.length; i++){
					var markup = "<tr><th scope='row'>"+data[i].test_value_file_id+"</th><td>"+data[i].vreg.vregID+"</td><td>"+data[i].vehicle_id+"</td><td>"+data[i].date+"</td><td><a href='#' class='btn btn-success btn-sm' onclick='checkAvailableResults(`"+data[i].vreg.vregID+"`,`"+data[i].test_value_file_id+"`,1)'><i class='fas fa-print'></i></a></td><td><a href='#' class='btn btn-default btn-sm' onclick='checkAvailableResults(`"+data[i].vreg.vregID+"`,`"+data[i].test_value_file_id+"`,0)'><i class='fas fa-print'></i></a></td> <td></td></tr>";
	           		 $("#pendingResultsTable tbody").append(markup);
	           	 }
		    },
		    error:function(){
		        //alert("error");
		    }
		
		});
		
	}
	function ReadingEmissionResults(){
		
		window.location.href = "readingEmissionResults";
	}
	function download(){
		
		window.location.href = "downloadFromFTP";
	}
</script>
	
<c:if test = "${result ==0}">
	<script>
    	Swal.fire(
        	'No Pending Test Results !',
        	'',
        	'info'
      	)
	</script>
</c:if>

<div id="overlay">
<!--   <div id="loading-effect"><img alt="" src="resources/img/96x96.gif"></div> -->
  <div id="text">Reading Test Results ...</div>
</div>

<script>
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

function confirmMsg(regID,test_value_file_id,color,map) {
	
	swal({
		title: 'Are you sure?',
		text: "Available Results :\n1. Visual Inspection : "+map[1]+"\n2. Emission : "+map[2],
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
</script>

	<!-- Modal -->
	<div class="modal fade" id="printingOrderModal" tabindex="-1"
		role="dialog" aria-labelledby="printingOrderModalTitle"
		aria-hidden="true">
		
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLongTitle">Results for Printing</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<form name="" id="" action="" method="GET">
					<div class="modal-body">

						<div style="height: 300px; overflow: auto;">
							<table class="table table-sm" id="">
								<thead>
									<tr>
										<th>Test Type</th>
										<th>Status</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>Side Slip Test</td>
										<td><input type="checkbox" checked></td>
									</tr>
									<tr>
										<td>Shock Absorber Test</td>
										<td><input type="checkbox" checked></td>
									</tr>
									<tr>
										<td>Headlight Test</td>
										<td><input type="checkbox" checked></td>
									</tr>
									<tr>
										<td>Noise Level Test</td>
										<td><input type="checkbox" checked></td>
									</tr>
									<tr>
										<td>Speedometer Test</td>
										<td><input type="checkbox" checked></td>
									</tr>
									<tr>
										<td>Speed Governor / Limit Test</td>
										<td><input type="checkbox" checked></td>
									</tr>
									<tr>
										<td>Brake Test (CAR)</td>
										<td><input type="checkbox" checked></td>
									</tr>
									<tr>
										<td>Brake Test (TRUCK)</td>
										<td><input type="checkbox" checked></td>
									</tr>
									<tr>
										<td>Emission ( Diesel )</td>
										<td><input type="checkbox" checked></td>
									</tr>
									<tr>
										<td>Emission ( Petrol/LPG/CNG)</td>
										<td><input type="checkbox" checked></td>
									</tr>
								</tbody>
							</table>
						</div>

					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-success"
							data-dismiss="modal">Save Changes</button>
<!-- 						<button type="submit" class="btn btn-success">Save
							Changes</button> -->
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
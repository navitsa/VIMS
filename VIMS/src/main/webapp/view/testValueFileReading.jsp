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
  top: 50%;
  left: 50%;
  transform: translate(-50%,-50%);
  -ms-transform: translate(-50%,-50%);
}
#text{
  position: absolute;
  top: 60%;
  left: 50%;
  font-size: 15px;
  color: black;
  transform: translate(-50%,-50%);
  -ms-transform: translate(-50%,-50%);
}

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
								
								
							</ul>
						</div>

	              <!-- Card -->
	              <div class="card shadow mb-4">
	                <div class="card-header py-3">
		                <div class="row">
		                	<div class="col-sm-8">
							 <h6 class="m-0 font-weight-bold text-primary">Test Results</h6>
							 </div>
							 <div class="col-sm-4">
								 <div class="dropdown float-right">
	<!-- 							  <button type="button" class="btn btn-primary btn-sm dropdown-toggle" data-toggle="dropdown">
								   More
								  </button> -->
									  <button type="button" class="btn btn-sm" data-toggle="dropdown">
									   <i class="fa fa-ellipsis-v" style="font-size:22px;color:blue"></i>
									  </button>
								  <div class="dropdown-menu">
								    <a class="dropdown-item" href="previousResults">Previous Reports</a>
								  </div>
								</div>
							</div>
						</div>	
	                </div>
	                <div class="card-body">
						<!-- <input type="button" class="btn btn-primary btn-sm" value="Read Test Results" onclick="Reading()"> -->
	                	<!-- <input type="button" class="btn btn-primary btn-sm" value="Read Emission Results (AVL DB)" onclick="ReadingEmissionResults()"> -->
	                	<!-- <input type="button" class="btn btn-primary btn-sm" value="Download file from FTP" onclick="download()"> -->
	                	<br>
	                	
							<div class="table-responsive-lg">
								<table class="table table-sm">
									<thead>
									   <tr>
									      <th style="width:50px" scope="col">#</th>
									      <th scope="col">Registration No</th>
									      <th scope="col">Vehicle No</th>
									      <th scope="col">Date & Time</th>
									      <th scope="col">Color</th>
									      <th scope="col">B / W</th>
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
												<a href="getTestReport?register_id=${result.vreg.vregID}&test_value_file_id=${result.test_value_file_id}&color=1" class="btn btn-primary" role="button">
												<i class="fas fa-print"></i> Color</a>
											</td>
											<td>
												<a href="getTestReport?register_id=${result.vreg.vregID}&test_value_file_id=${result.test_value_file_id}&color=0" class="btn btn-secondary" role="button">
												<i class="fas fa-print"></i> B/W</a>
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
		document.getElementById("overlay").style.display = "block";
		
		$.ajax({
		    type: 'GET',
		    url: "readingTestValues",
		    success: function(data){
		    	document.getElementById("overlay").style.display = "none";
	        	$("table tbody").empty();
				for(var i=0; i<data.length; i++){
					var markup = "<tr><th scope='row'>"+data[i].test_value_file_id+"</th><td>"+data[i].vreg.vregID+"</td><td>"+data[i].vehicle_id+"</td><td>"+data[i].date+"</td><td><a href='getTestReport?register_id="+data[i].vreg.vregID+"&test_value_file_id="+data[i].test_value_file_id+"&color=1' class='btn btn-primary'><i class='fas fa-print'></i> Color</a></td><td><a href='getTestReport?register_id="+data[i].vreg.vregID+"&test_value_file_id="+data[i].test_value_file_id+"&color=0' class='btn btn-secondary'><i class='fas fa-print'></i> B/W</a></td></tr>";
	           		 $("table tbody").append(markup);
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
  <div id="loading-effect"><img alt="" src="resources/img/96x96.gif"></div>
  <div id="text">Reading Test Results ...</div>
</div>

</body>
</html>
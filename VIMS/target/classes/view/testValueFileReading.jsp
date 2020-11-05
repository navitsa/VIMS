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
                	<input type="button" class="btn btn-primary btn-sm" value="Read Test Results" onclick="Reading()">
                	<!-- <input type="button" class="btn btn-primary btn-sm" value="Read Emission Results (AVL DB)" onclick="ReadingEmissionResults()"> -->
                	<!-- <input type="button" class="btn btn-primary btn-sm" value="Download file from FTP" onclick="download()"> -->
                	<br><br>
                	
						<div class="table-responsive-lg">
							<table class="table table-sm table-striped">
								<thead>
								   <tr>
								      <th style="width:50px" scope="col">#</th>
								      <th scope="col">Registration No</th>
								      <th scope="col">Vehicle No</th>
								      <th scope="col">Date & Time</th>
								      <th scope="col">Action</th>
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
											<a href="getTestReport?register_id=${result.vreg.vregID}&test_value_file_id=${result.test_value_file_id}" class="btn btn-success" role="button">
											<i class="fas fa-print"></i> Print</a>
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
			window.location.href = "readingTestValues";
			
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

</body>
</html>
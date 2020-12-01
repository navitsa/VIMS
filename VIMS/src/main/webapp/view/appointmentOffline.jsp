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
	<div class="wrapper sidebar_minimize">
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


					<div class="row">
						<div class="col-md-12">
							<div class="card">
								<form:form  action="saveAppointment" method="POST" 
									modelAttribute="appointmentForm" onsubmit="return validateForm()">
									<div class="card-header">
										<div class="card-title">Appointments ( OFFLINE )</div>
									</div>
									<div class="card-body">
										<div class="row">
											<div class="col-md-6 col-lg-4">
											
<div class="form-group">
	<label for="vClass">Vehicle Class</label>	
	<select class="form-control" id="vClass" onchange="findBestLane()" required>
		<option value="">--SELECT--</option>									
		<c:forEach items="${vClass}" var="vClass">
			<option value="${vClass.vehicleClassID}">${vClass.vehicleClass}</option>
		</c:forEach>																																		
	</select>
</div>
<div class="form-group">
	<label for="testCat">Test Category</label>
	<select class="form-control" id="testCat" onchange="findBestLane()" required>									
		<option value="">--SELECT--</option>
		<c:forEach items="${testCategory}" var="cat">
			<option value="${cat.categoryId}">${cat.categoryType}</option>
		</c:forEach>																																		
	</select>
</div>
	
											</div>
											<div class="col-md-6 col-lg-4">				
	
											</div>
											<div class="col-md-6 col-lg-4">
	
											</div>
										</div>
									</div>
									<div class="card-action">
										<button class="btn btn-success">Submit</button>
										<button class="btn btn-danger">Cancel</button>
									</div>
								</form:form>
							</div>
						</div>
					</div>


				</div> <!-- End of page-inner -->
			</div>	
			<%@include file="../WEB-INF/jsp/footer.jsp"%>			
		</div>
	</div>
	
	<%@include file="../WEB-INF/jsp/commJs.jsp"%>

</body>
</html>
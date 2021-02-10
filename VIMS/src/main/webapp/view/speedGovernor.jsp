<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<%@include file="../WEB-INF/jsp/head.jsp"%>
	<meta charset="ISO-8859-1">
	<title>Speed Governor</title>
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
							<h4 class="page-title">Speed Governor Limits</h4>
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
									<a href="#">Test Profiles</a>
								</li>
								<li class="separator">
									<i class="flaticon-right-arrow"></i>
								</li>
								<li class="nav-item">
									<a href="#">Speed Governor Limits</a>
								</li>
							</ul>
						</div>
				
													
					<div class="row">
						<div class="col-xl-8 col-md-6 mb-4">
			              <div class="card shadow mb-4 border-left-primary">
			                <div class="card-body">
			                
			                	<c:if test = "${success ==1}">
									<div class="alert alert-success alert-dismissible">
									  <button type="button" class="close" data-dismiss="alert">&times;</button>
									  <strong>Success!</strong> Data Successfully Saved.
									</div>
								</c:if>
								<c:if test = "${success ==0}">
								  <div class="alert alert-danger alert-dismissible">
								    <button type="button" class="close" data-dismiss="alert">&times;</button>
								    <strong>Warning!</strong>Something went wrong ! Please try again!
								  </div>
								</c:if>
			                
								<form:form action="saveSpeedGovernorLimits" method="POST" modelAttribute="veSubCatForm" id="form1">

									<div class="form-group row">
										<div class="col-lg-6">
											<div class="form-group form-floating-label">
												<form:select id="testProfile" class="form-control input-border-bottom" 
													required="required" path="testProfileHeaderID.testProfileID">
													<option></option>
													<c:forEach items="${testProfile}" var="testProfile">
														<form:option value="${testProfile.testProfileID}">${testProfile.testProfileName}</form:option>
													</c:forEach>
												</form:select>
												<label for="testProfile" class="placeholder">Select test profile</label>
											</div>
										</div>
									</div>
			                		<div class="form-group row">
										<div class="col-lg-8">
											<label for="description">Speed Governor Type <span class="required text-danger">*</span></label>
											<form:input class="form-control form-control-sm" path="description" placeholder="Ex: Transport Vehicles/School Buses"/>
											<form:errors path="description" class="bg-danger text-white" />
										</div>
									</div>

									<div class="form-group row">
										<div class="col-lg-3">
										<label for="maxSpeed">Max Speed Limit</label>
											<div class="input-group">												
												<form:input path="maxSpeed" id="maxSpeed" type="text" class="form-control input-border-bottom"/>
												<div class="input-group-append">
													<span class="input-group-text">Km</span>
												</div>							
											</div>
										</div>
									</div>
										
									<div class="form-group row">
										<div class="col-lg-3">
										<label for="plusTol">Tolerance</label>
											<div class="input-group">												
												<form:input path="tolerance" id="plusTol" type="text" class="form-control input-border-bottom"/>
												<div class="input-group-append">
													<span class="input-group-text">%</span>
												</div>							
											</div>
										</div>
									</div>
											
									<input type="submit" class="btn btn-success" value="Save Limits">
									<input type="reset" class="btn btn-warning mr-sm-2" value="Clear">
								</form:form>

								
			                </div>
			               </div>
						</div>

						<div class="col-xl-4 col-md-6 mb-4"></div>
					</div>	

	
				</div>				
			</div>	
			<%@include file="../WEB-INF/jsp/footer.jsp"%>			
		</div>
	</div>
<%@include file="../WEB-INF/jsp/commJs.jsp"%>

	<script>
		$(document).ready(function() {
		    $('#example').DataTable( {
		    	//"scrollY": "400px",
		    	"processing": true,
		        "columnDefs": [{ "orderable": false, "targets": 4 },{ "orderable": false, "targets": 5 }]
		    } );
		} );
	</script>
</body>
</html>
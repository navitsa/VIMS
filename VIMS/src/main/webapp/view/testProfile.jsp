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
							<h4 class="page-title">Test Profiles</h4>
							<ul class="breadcrumbs">
								<li class="nav-home">
									<a href="#">
										<i class="flaticon-home"></i>
									</a>
								</li>
								<li class="separator">
									<i class="flaticon-right-arrow"></i>
								</li>
									<a href="#">Test Profiles</a>
								<li class="nav-item">
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
			                
								<form:form action="saveTestProfile" method="POST" modelAttribute="testProfileForm" id="form1">
								
									<form:input class="form-control form-control-sm" path="testProfileID" type="hidden"/>
									
			                		<div class="form-group row">
										<div class="col-lg-8">
											<label for="testProfileName">Profile Name <span class="required text-danger">*</span></label>
											<form:input class="form-control form-control-sm" path="testProfileName"/>
											<form:errors path="testProfileName" class="bg-danger text-white" />
										</div>
									</div>
			                		<div class="form-group row">
										<div class="col-lg-8">
											<form:textarea path="description" class="form-control form-control-sm" placeholder="Remark"/>
											<form:errors path="description" class="bg-danger text-white" />
										</div>
									</div>
									<div class="form-group row">
										<div class="col-lg">

											<div class="custom-control custom-radio custom-control-inline">
												<form:radiobutton path="status" class="custom-control-input" value="Active" 
													id="active" checked="checked" /> 
												<label class="custom-control-label" for="active">Active</label>
											</div>
											<div class="custom-control custom-radio custom-control-inline">
												<form:radiobutton path="status" class="custom-control-input" value="Inactive" 
													id="inactive"/> 
												<label class="custom-control-label" for="inactive">Inactive</label>
											</div>

										</div>
									</div>
			                		<div class="form-group row">
										<div class="col-lg">
											<input type="submit" class="btn btn-success" value="Add Profile">
											<input type="reset" class="btn btn-warning mr-sm-2" value="Clear">
										</div>
									</div>

								</form:form>
								<br><br>
								<table id="example" class="display table table-bordered table-hover" cellspacing="0" width="100%">
									<thead>
										<tr>
											<th>#</th>
											<th>Profile</th>
											<th>Remarks</th>
											<th>Status</th>
											<th></th>
											<th></th>
										</tr>
									</thead>

									<tbody>
										<c:forEach items="${testProfile}" var="tp">
											<tr>
												<td>${tp.testProfileID}</td>
												<td>${tp.testProfileName}</td>
												<td>${tp.description}</td>
												<td>${tp.status}</td>
												<td><a href="limitValues">Set Codes & Limit Values</a></td>
												<td><a href="updateTestProfile?proId=${tp.testProfileID}"><i
														class="fas fa-pen"></i></a>
												</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
								
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
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
							<h4 class="page-title">Test Limit Rules</h4>
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
									<a href="#">Test Limit Rules</a>
								</li>
							</ul>
						</div>
				
													
					<div class="row">
						<div class="col-xl col-md-6 mb-4">
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
			                
								<form:form action="saveTestLimitRule" method="POST" modelAttribute="testLimitRuleForm" id="form1">
								
								<form:input class="form-control form-control-sm" path="ruleCode" type="hidden"/>
								
									<div class="form-group row">
										<div class="col-lg-4">
											<div class="form-group form-floating-label">
												<form:select id="fuelType" class="form-control input-border-bottom" 
													required="required" path="fuelType.fuelTypeID">
													<option></option>
													<c:forEach items="${fuelTypes}" var="fuelType">
														<form:option value="${fuelType.fuelTypeID}">${fuelType.fuel}</form:option>
													</c:forEach>
												</form:select>
												<label for="fuelType" class="placeholder">Select fuel type</label>
											</div>
										</div>
									</div>
									
			                		<div class="form-group row">
										<div class="col-lg-4">
											<label for="ruleName">Rule Name <span class="required text-danger">*</span></label>
											<form:input class="form-control form-control-sm" path="ruleName"/>
											<form:errors path="ruleName" class="bg-danger text-white" />
										</div>
									</div>
									<div class="form-group row">
										<div class="col-lg-4">
											<label for="effectiveFrom">Effective From <span class="required text-danger">*</span></label>
											<form:input class="form-control form-control-sm" path="effectiveFrom" type="date"/>
										</div>
										<div class="col-lg-4">
											<label for="effectiveTo">Effective To <span class="required text-danger">*</span></label>
											<form:input class="form-control form-control-sm" path="effectiveTo" type="date"/>
										</div>
									</div>
			                		<div class="form-group row">
										<div class="col-lg-8">
											<form:textarea path="ruleDesc" class="form-control form-control-sm" placeholder="Description"/>
											<form:errors path="ruleDesc" class="bg-danger text-white" />
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
											<input type="submit" class="btn btn-success" value="Save Limit Rule">
											<input type="reset" class="btn btn-warning mr-sm-2" value="Clear">
										</div>
									</div>

								</form:form>
								<br><br>
								<div class="table-responsive">
								<table id="example" class="display table table-bordered table-hover" cellspacing="0" width="100%">
									<thead>
										<tr>
											<th>#</th>
											<th>fuel Type</th>
											<th>Rule Name</th>
											<th>Effective From</th>
											<th>Effective To</th>
											<th>Description</th>
											<th>Status</th>
											<th></th>
										</tr>
									</thead>

									<tbody>
										<c:forEach items="${rules}" var="rule">
											<c:if test = "${rule.ruleCode !=0}">
												<tr>
													<td>${rule.ruleCode}</td>
													<td>${rule.fuelType.fuel}</td>
													<td>${rule.ruleName}</td>
													<td>${rule.effectiveFrom}</td>
													<td>${rule.effectiveTo}</td>
													<td>${rule.ruleDesc}</td>
													<td>${rule.status}</td>
													<td><a href="updateTestLimitRule?ruleCode=${rule.ruleCode}"><i
															class="fas fa-pen"></i></a>
													</td>
												</tr>
											</c:if>
										</c:forEach>
									</tbody>
								</table>
								</div>
								
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
		        "columnDefs": [
		        	{ "orderable": false, "targets": 1 },
		        	{ "orderable": false, "targets": 2 },
		        	{ "orderable": false, "targets": 5 },
		        	{ "orderable": false, "targets": 6 },
		        	{ "orderable": false, "targets": 7 }]
		    } );
		} );
	</script>
</body>
</html>
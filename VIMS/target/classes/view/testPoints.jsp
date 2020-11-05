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
							<h4 class="page-title">Test Configurations</h4>
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
									<a href="#">Points</a>
								</li>
								
							</ul>
						</div>
				
						<div
								class="card-header py-3 d-flex flex-row align-items-center justify-content-between">								
						<div class="col-xl-8 col-md-6 mb-4">
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
							
							<div class="card shadow mb-4 border-left-primary">
			                	<div class="card-body">

									 <div id="accordion">				
										  <div class="card">
											<a href="#collapseOne" class="d-block card-header bg-primary" 
												data-toggle="collapse" role="button" aria-expanded="true" aria-controls="collapseOne">
												<h6 class="m-0 font-weight-bold text-white">Test Points</h6>
											</a>
										    <div id="collapseOne" class="collapse show" data-parent="#accordion">
										      <div class="card-body">

												<form:form action="saveTestPoints" method="GET" modelAttribute="testPointForm" id="form1">
													<%-- <form:input type="hidden" path="testPointID" /> --%>
													<div class="form-group row">
														<div class="col-lg-6">
															<form:select id="testType" class="custom-select custom-select-sm" path="testType.typeId" 
																required="required">
																<form:option value="">Select test type...</form:option>
																<c:forEach items="${testTypes}" var="testTypes">
																	<form:option value="${testTypes.typeId}">${testTypes.type}</form:option>
																</c:forEach>
															</form:select>
														</div>
													</div>
													<div class="form-group row" id="rowpoint">
														<div class="col-lg" id="colpoint">
															<div class="form-inline">
															  <label for="testpoint"  class="mr-sm-2 text-gray-900 text-sm">Test Point :</label>
															  <form:input class="form-control form-control-sm  mb-2 mr-sm-2" placeholder="Ex: front axle" id="testpoint" path="testPointName"/>
															  <a href="#" id="removePointF"><i class="fa fa-minus-circle" style="font-size:15px;color:red" aria-hidden="true"></i></a>	  
															</div>
														</div>
													</div>
													
													 <a href="#" id="addPointF"><i class="fa fa-plus-circle" style="font-size:20px;color:green" aria-hidden="true"></i> Add new point</a>
													 <br><br>
													  <input type="submit" value="Save" class="btn btn-success" id="submitButton" form="form1"/>
												  </form:form>	
										      </div>
										    </div>
										  </div>
										
										  <div class="card">
											<a href="#collapseTwo" class="d-block card-header bg-warning" 
												data-toggle="collapse" role="button" aria-expanded="true" aria-controls="collapseTwo">
												<h6 class="m-0 font-weight-bold text-white">Parameters</h6>
											</a>
	
										    <div id="collapseTwo" class="collapse" data-parent="#accordion">
										      <div class="card-body">
										      	<form:form action="saveTestParameter" method="GET" modelAttribute="testParameterForm" id="form2">
													<div class="form-group row">
														<div class="col-lg-6">
															<form:select id="testType" class="custom-select custom-select-sm" path="testType.typeId" 
																required="required">
																<form:option value="">Select test type...</form:option>
																<c:forEach items="${testTypes}" var="testTypes">
																	<form:option value="${testTypes.typeId}">${testTypes.type}</form:option>
																</c:forEach>
															</form:select>
														</div>
													</div>
													<div class="form-inline">
													  <label for="para"  class="mr-sm-2 text-gray-900 text-sm">Parameter 1 :</label>
													  <form:input class="form-control form-control-sm  mb-2 mr-sm-2" placeholder="" id="para" path="paraName"/>
													  <a href="#"><i class="fa fa-minus-circle" style="font-size:15px;color:red" aria-hidden="true"></i></a>	  
													</div>
													<div class="form-inline">
													  <label for="para2"  class="mr-sm-2 text-gray-900 text-sm">Parameter 2 :</label>
													  <form:input class="form-control form-control-sm  mb-2 mr-sm-2" placeholder="" id="para2" path="paraName"/>
													  <a href="#"><i class="fa fa-minus-circle" style="font-size:15px;color:red" aria-hidden="true"></i></a>	  
													</div>
													 
													 <a href="#"><i class="fa fa-plus-circle" style="font-size:20px;color:green" aria-hidden="true"></i> Add new Parameter</a>
													 <br><br>
													 
													  <input type="submit" value="Save" class="btn btn-success" id="paraSubmit" form="form2"/>
													  
												  </form:form>
										      </div>
										    </div>
										  </div>

										  <div class="card">
											<a href="#collapseThree" class="d-block card-header bg-success" 
												data-toggle="collapse" role="button" aria-expanded="true" aria-controls="collapseThree">
												<h6 class="m-0 font-weight-bold text-white">Directions</h6>
											</a>
	
										    <div id="collapseThree" class="collapse" data-parent="#accordion">
										      <div class="card-body">
										      	<form:form action="saveTestAngles" method="GET" modelAttribute="testAngleForm" id="form3">
													<div class="form-group row">
														<div class="col-lg-6">
															<form:select id="testPara" class="custom-select custom-select-sm" path="testParameter.testParameterId" 
																required="required">
																<form:option value="">Select test parameter...</form:option>
																	<c:forEach items="${testParameters}" var="testParameters">
																		<option value="${testParameters.testParameterId}">${testParameters.paraName}</option>
																	</c:forEach>
															</form:select>
														</div>
													</div>
													<div class="form-inline">
													  <label for="angle"  class="mr-sm-2 text-gray-900 text-sm">Direction 1 :</label>
													  <form:input class="form-control form-control-sm  mb-2 mr-sm-2" placeholder="" id="angle" path="angleName"/>
													  <a href="#"><i class="fa fa-minus-circle" style="font-size:15px;color:red" aria-hidden="true"></i></a>	  
													</div>
													<div class="form-inline">
													  <label for="angle2"  class="mr-sm-2 text-gray-900 text-sm">Direction 2 :</label>
													  <form:input class="form-control form-control-sm  mb-2 mr-sm-2" placeholder="" id="angle2" path="angleName"/>
													  <a href="#"><i class="fa fa-minus-circle" style="font-size:15px;color:red" aria-hidden="true"></i></a>	  
													</div>
													 
													 <a href="#"><i class="fa fa-plus-circle" style="font-size:20px;color:green" aria-hidden="true"></i> Add new Direction</a>
													 <br><br>
													 
													  <input type="submit" value="Save" class="btn btn-success" form="form3"/>
													  
												  </form:form>
										      </div>
										    </div>
										  </div>
										  
									</div> 
									<!-- End of accordion -->

			                	</div>
			                </div>
						</div>						

	</div>
				
				
				
				
				
					</div>
				
			</div>	
			<%@include file="../WEB-INF/jsp/footer.jsp"%>			
		</div>
	</div>
<%@include file="../WEB-INF/jsp/commJs.jsp"%>

	<script>  
	$(document).ready(function(){  
	    $("#addPointF").click(function(){  
	        $("#colpoint").clone().appendTo("#rowpoint");
	    });

	    $("#removePointF").click(function(){  
	    	 $("#colpoint").remove();
	    });
	    
	});  
	</script>

</body>
</html>
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
							<h4 class="page-title">ES_OUT Codes Mapping</h4>
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
									<a href="#">Test Configurations</a>
								</li>
								<li class="separator">
									<i class="flaticon-right-arrow"></i>
								</li>
								<li class="nav-item">
									<a href="#">ES_OUT Codes Mapping</a>
								</li>
							</ul>
					</div>

					<!-- Card -->
					<div class="card shadow mb-4">

						<div class="card-body">
							<c:if test="${success ==1}">
								<div class="alert alert-success alert-dismissible">
									<button type="button" class="close" data-dismiss="alert">&times;</button>
									<strong>Success!</strong> Data Successfully Saved.
								</div>
							</c:if>
							<c:if test="${success ==0}">
								<div class="alert alert-danger alert-dismissible">
									<button type="button" class="close" data-dismiss="alert">&times;</button>
									<strong>Warning!</strong>Something went wrong ! Please try
									again!
								</div>
							</c:if>

							<form:form action="saveParaCodes" method="POST" modelAttribute="testCodesM">

							<div class="form-group row">
								<div class="col-lg-3">
									<form:input path="ck_paraCodeId.code" id="paraCode" class="form-control" placeholder="Code"/>
								</div>
								<div class="col-lg-6">
									<form:textarea path="description" class="form-control" placeholder="Description"/>
								</div>
							</div>

							<div class="form-group row">
								<div class="col-lg-3">
									<form:select id="testType" class="form-control"
										onchange="getTestPoints(this.value)" required="required" path="ck_paraCodeId.testType.typeId">
										<form:option value="">Select test type...</form:option>
										<c:forEach items="${testTypes}" var="testTypes">
											<form:option value="${testTypes.typeId}">${testTypes.type}</form:option>
										</c:forEach>
									</form:select>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-lg-3">
									<form:select id="testPointCombo" class="form-control"
										onchange="getTestCodes3(this.value)" required="required" path="testPoint.testPointID">
										<form:option value="">Select test point...</form:option>
										<c:forEach items="${testPoints}" var="testPoints">
											<form:option value="${testPoints.testPointID}">${testPoints.testPointName}</form:option>
										</c:forEach>
									</form:select>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-lg-3">
									<form:select id="testPara" class="form-control"
										onchange="getTestAngles(this.value)" path="testParameter.testParameterId">
										<form:option value="">Select test parameter...</form:option>
										<c:forEach items="${testParameters}" var="testParameters">
											<form:option value="${testParameters.testParameterId}">${testParameters.paraName}</form:option>
										</c:forEach>
									</form:select>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-lg-3">
									<form:select id="testAngle" class="form-control"
										onchange="getTestCodes2(this.value)" path="testParameterAngle.paraAngleID">
										<form:option value="">Select parameter direction...</form:option>
										<c:forEach items="${parameterAngles}" var="paraAngles">
											<form:option value="${paraAngles.paraAngleID}">${paraAngles.angleName}</form:option>
										</c:forEach>
									</form:select>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-lg">
									<button type="submit" class="btn btn-success" onclick="return Validate()">Save</button>
									<button type="reset" class="btn btn-warning">Clear</button>
								</div>
							</div>
								
							</form:form>
						</div>
						<!-- End of card body -->
					</div>
					<!-- End of card-->
				
				
				</div>	
			</div>	
			<%@include file="../WEB-INF/jsp/footer.jsp"%>			
		</div>
	</div>
<%@include file="../WEB-INF/jsp/commJs.jsp"%>

<!-- Page level custom scripts -->
	<script src="resources/ajax/limit-values.js" type="text/javascript"></script>

</body>
</html>
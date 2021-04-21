<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ page isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>



<html lang="en">
<head>
<%@include file="../WEB-INF/jsp/head.jsp"%>

<style>
.vidSty {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 30px;
	font-weight: bold;
	color: #02d41b;
}

.textred {
	font-family: Arial, Helvetica, sans-serif;
	border: 0px solid #b30000;
	font-size: 14px;
	font-weight: bold;
	text-align: center;
	color: #2c03fc;
}

.fontst {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	height: 30px;
}

.l-fontst {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	height: 5px;
	margin-top: 0px;
}

.iconali {
	position: absolute;
	top: 6px;
	right: -7px;
}

.capCam {
	height: 100px;
	width: 210px;
}

.cursiz {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	width: 48px;
	color: #ff8000;
}

.amt {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	width: 60px;
	color: blue;
	text-align: right;
}

.iconstyle {
	width: 7%;
	color: blue';
}

.icon-pre-ve {
	width: 150%;
}
</style>

</head>
<body onload="checkStatusofDropdowns();">
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
				<div class="panel-header bg-primary-gradient">
					<div class="page-inner py-3">
						<div
							class="d-flex align-items-left align-items-md-center flex-column flex-md-row">
							<div class="col-xl-2 col-lg-2">
								<h2 class="text-white pb-2 fw-bold">Parameter Code</h2>
							</div>
							<div class="col-xl-2 col-lg-2"></div>
							<div class="ml-md-auto py-2 py-md-4"></div>

							<div class="ml-md-auto py-2 py-md-4"></div>
						</div>
					</div>
				</div>

				<div class="page-inner mt--5">
					<div class="container-fluid">

						<div class="row">
							<div class="col-xl-5 col-lg-5">
								<!-- Card -->
								<form:form action="saveParameterCodes" method="post"
									modelAttribute="parameterCodesForm"
									enctype="multipart/form-data" id="formMake">
									<div class="card shadow mb-4" style="height: 640px;">
										<div class="card border-left-primary shadow h-100 py-2">
											<div class="card-body">
												<div class="form-group row">
													<div class="col-sm-4">
														<label class="l-fontst">Code</label>
													</div>
													<div class="col-sm-6">
														<form:input class="form-control fontst" type="text"
															path="ck_paraCodeId.code" onchange="" id="code" />
													</div>
													<!-- <div class="col-sm-4">
														<label class="l-fontst">S ID</label>
													</div> -->
													<div class="col-sm-2">
														<form:input class="form-control fontst" type="hidden"
															path="s_id" onchange="" id="s_id" readonly="true" />
													</div>
												</div>
												<!-- <div class="form-group row">
													
												</div> -->
												<div class="form-group row">
													<div class="col-sm-4">
														<label class="l-fontst">Description</label>
													</div>
													<div class="col-sm-6">
														<form:input class="form-control fontst" type="text"
															path="description" onchange="" id="description" />

													</div>
												</div>
												<div class="form-group row">
													<div class="col-sm-4">
														<label class="l-fontst">Type</label>
													</div>
													<div class="col-sm-6">
														<form:select class="form-control fontst" type="text"
															path="ck_paraCodeId.testType.typeId" onchange=""
															id="type_id">
															<form:option value="">--SELECT--</form:option>
															<c:forEach items="${testTypeList}" var="tt">
																<form:option value="${tt.typeId}">${tt.type}</form:option>
															</c:forEach>
														</form:select>
													</div>
												</div>
												<div class="form-group row">
													<div class="col-sm-4">
														<label class="l-fontst">Test Point</label>
													</div>
													<div class="col-sm-6">
														<form:select class="form-control fontst" type="text"
															path="testPoint.testPointID" onchange="" id="testPoint">
															<form:option value="">--SELECT--</form:option>
															<c:forEach items="${testPointList}" var="tp">
																<form:option value="${tp.testPointID}">${tp.testPointName}</form:option>
															</c:forEach>
														</form:select>
													</div>
												</div>
												<div class="form-group row">
													<div class="col-sm-4">
														<label class="l-fontst">Test Parameter</label>
													</div>
													<div class="col-sm-6">
														<form:select class="form-control fontst" type="text"
															path="testParameter.testParameterId" onchange=""
															id="testParameter">
															<form:option value="">--SELECT--</form:option>
															<c:forEach items="${testParameterList}" var="tp">
																<form:option value="${tp.testParameterId}">${tp.paraName}</form:option>
															</c:forEach>
														</form:select>
													</div>
												</div>
												<div class="form-group row">
													<div class="col-sm-4">
														<label class="l-fontst">Test Parameter Angle</label>
													</div>
													<div class="col-sm-6">
														<form:select class="form-control fontst" type="text"
															path="testParameterAngle.paraAngleID" onchange=""
															id="testParameterAngle">
															<form:option value="">--SELECT--</form:option>
															<c:forEach items="${testParameterAngleList}" var="tpa">
																<form:option value="${tpa.paraAngleID}">${tpa.angleName}</form:option>
															</c:forEach>
														</form:select>
													</div>
												</div>

												<hr>
												<div class="form-group row">

													<div class="col-sm-5">
														<button type="submit"
															class="btn  btn-block btn-success btn-rounded tabStyle">Add
															Parameters</button>
													</div>
													<div class="col-sm-3">
														<button type="reset"
															class="btn  btn-block btn-danger btn-rounded tabStyle">Reset</button>
													</div>

												</div>
												<hr>

											</div>
											<!-- End of card body -->
										</div>
									</div>
								</form:form>
							</div>

							<div class="col-xl-7 col-lg-5">
								<div class="card shadow mb-4" style="height: 640px;">
									<div class="card border-left-primary shadow h-100 py-2">
										<div class="card-body">

											<div class="col-sm-12">

												<table id="tblParameterCodes"
													class="table table-bordered table-sm table-wrapper-scroll-y my-custom-scrollbar"
													cellspacing="0" style="height: 50vh">

													<thead>
														<tr>
															<th style="width: 10%">Code</th>
															<th style="width: 30%">Type</th>
															<th style="width: 40%">Description</th>
															<th style="width: 20%">Test Point</th>
															<th style="width: 20%">Test Parameter</th>
															<th style="width: 20%">Test Parameter Angle</th>
															<th style="width: 10%"></th>
														</tr>
													</thead>
													<tbody id="myTable">
														<c:forEach items="${parameterCodeList}" var="pc">
															<tr>
																<td><div>${pc.ck_paraCodeId.code}</div></td>
																<td><div>${pc.ck_paraCodeId.testType.type}</div></td>
																<td><div>${pc.description}</div></td>
																<td><div>${pc.testPoint.testPointName}</div></td>
																<td><div>${pc.testParameter.paraName}</div></td>
																<td><div>${pc.testParameterAngle.angleName}</div></td>
																<td><a href="editParameterCodes?id=${pc.s_id}"><i
																		class="material-icons">&#xE254;</i></a></td>
															</tr>

														</c:forEach>
													</tbody>
												</table>

											</div>

										</div>
										<!-- End of card body -->
									</div>
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
		
	</script>
</body>
</html>
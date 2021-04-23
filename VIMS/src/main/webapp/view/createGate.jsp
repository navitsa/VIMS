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
								<h2 class="text-white pb-2 fw-bold">Create Gate</h2>
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
								<form:form action="saveCreatedGate" method="post"
									modelAttribute="createGateForm" enctype="multipart/form-data"
									id="formMake">
									<div class="card shadow mb-4" style="height: 640px;">
										<div class="card-body">
											<div class="form-group row">
												<div class="col-sm-4">
													<label class="l-fontst">Gate ID</label>
												</div>
												<div class="col-sm-6">
													<form:input class="form-control fontst" type="text"
														path="gateID" onchange="" id="gateID" readonly="true" />
												</div>
											</div>
											<div class="form-group row">
												<div class="col-sm-4">
													<label class="l-fontst">Gate Name</label>
												</div>
												<div class="col-sm-6">
													<form:input class="form-control fontst" type="text"
														path="gateName" onchange="" id="gateName" />
												</div>
											</div>
											<div class="form-group row">
												<div class="col-sm-4">
													<label class="l-fontst">Gate Path</label>
												</div>
												<div class="col-sm-6">
													<form:input class="form-control fontst" type="text"
														path="gatePath" onchange="" id="gatePath" />

												</div>
											</div>
											<div class="form-group row">
												<div class="col-sm-4">
													<label class="l-fontst">Gate IP</label>
												</div>
												<div class="col-sm-6">
													<form:input class="form-control fontst" type="text"
														path="gateIP" onchange="" id="gateIP" />
												</div>
											</div>
											<div class="form-group row">
												<div class="col-sm-4">
													<label class="l-fontst">Camera IP</label>
												</div>
												<div class="col-sm-6">
													<form:input class="form-control fontst" type="text"
														path="cameraIP" onchange="" id="cameraIP" />
												</div>
											</div>

											<hr>
											<div class="form-group row">

												<div class="col-sm-5">
													<button type="submit"
														class="btn  btn-block btn-success btn-rounded tabStyle">Add
														Gate</button>
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
								</form:form>
							</div>

							<div class="col-xl-7 col-lg-5">
								<div class="card shadow mb-4" style="height: 640px;">
									<div class="card-body">

										<div class="col-sm-12">

											<table id="tblCreatedGates"
												class="table table-bordered table-sm table-wrapper-scroll-y my-custom-scrollbar"
												cellspacing="0" style="height: 50vh">

												<thead>
													<tr>
														<th style="width: 10%">ID</th>
														<th style="width: 30%">Gate Name</th>
														<th style="width: 40%">Gate Path</th>
														<th style="width: 20%">Gate IP</th>
														<th style="width: 20%">Camera IP</th>
														<th style="width: 10%"></th>
													</tr>
												</thead>
												<tbody id="myTable">
													<c:forEach items="${gateList}" var="g">
														<tr>
															<td><div>${g.gateID}</div></td>
															<td><div>${g.gateName}</div></td>
															<td><div>${g.gatePath}</div></td>
															<td><div>${g.gateIP}</div></td>
															<td><div>${g.cameraIP}</div></td>
															<td><a href="editGate?id=${g.gateID}"><i
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
			<%@include file="../WEB-INF/jsp/footer.jsp"%>
		</div>
	</div>
	<%@include file="../WEB-INF/jsp/commJs.jsp"%>
	<script>
		
	</script>
</body>
</html>
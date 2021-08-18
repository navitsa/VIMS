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
								<h2 class="text-white pb-2 fw-bold">Vehicle Category</h2>
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
								<form:form action="saveVehicleCategory" method="post"
									modelAttribute="vehicleCategoryForm"
									enctype="multipart/form-data" id="formMake">
									<div class="card shadow mb-4" style="height: 640px;">

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

											<div class="form-group row">
												<div class="col-sm-4">
													<label class="l-fontst">Category Type</label>
												</div>
												<div class="col-sm-6">
													<form:select class="form-control form-control-user fontst"
														path="typeId.typeId" required="true">
														<form:option value="">- Select Type -</form:option>
														<c:forEach items="${alltypes}" var="types">
															<form:option value="${types.typeId}">${types.type}</form:option>
														</c:forEach>
													</form:select>

												</div>
											</div>

											<div class="form-group row">
												<div class="col-sm-4">
													<label class="l-fontst">Category ID</label>
												</div>
												<div class="col-sm-6">
													<form:input class="form-control fontst" type="text"
														path="categoryID" onchange="" id="categoryID" required="true" />
												</div>
											</div>
											<div class="form-group row">
												<div class="col-sm-4">
													<label class="l-fontst">Category</label>
												</div>
												<div class="col-sm-6">
													<form:input class="form-control fontst" type="text"
														path="vehicleCategory" onchange="" id="vehicleCategory" required="true" />
												</div>
											</div>
											<div class="form-group row">
												<div class="col-sm-4">
													<label class="l-fontst">Remark</label>
												</div>
												<div class="col-sm-6">
													<form:textarea class="form-control fontst" type="text"
														path="remarks" onchange="" id="remarks" />
												</div>
											</div>

											<div class="form-group row">
												<div class="col-sm-4">
													<label class="form-label">Status</label>
												</div>
												<div class="col-sm-6">
													<div class="selectgroup w-75">
														<label class="selectgroup-item"> <form:radiobutton
																path="status" value="ACTIVE" class="selectgroup-input"
																checked="" /> <span class="selectgroup-button"><b>ACTIVE</b></span>
														</label> <label class="selectgroup-item"> <form:radiobutton
																path="status" value="INACTIVE" class="selectgroup-input" />
															<span class="selectgroup-button"><b>INACTIVE</b></span>
														</label>
													</div>
												</div>
											</div>

											<hr>
											<div class="form-group row">

												<div class="col-sm-5">
													<button type="submit"
														class="btn  btn-block btn-success btn-rounded tabStyle">Add
														Vehicle Category</button>
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

											<table id="tblIncomingPayment"
												class="table table-bordered table-sm table-wrapper-scroll-y my-custom-scrollbar"
												cellspacing="0" style="height: 50vh">

												<thead>
													<tr>
														<th style="width: 10%">ID</th>
														<th style="width: 10%">Category Type</th>
														<th style="width: 30%">Category</th>
														<th style="width: 40%">Remark</th>
														<th style="width: 20%">Status</th>
														<th style="width: 10%"></th>
													</tr>
												</thead>
												<tbody id="myTable">
													<c:forEach items="${categoryList}" var="cl">
														<tr>
															<td><div>${cl.categoryID}</div></td>
															<td><div>${cl.typeId.type}</div></td>
															<td><div>${cl.vehicleCategory}</div></td>
															<td><div>${cl.remarks}</div></td>
															<td><div>${cl.status}</div></td>
															<td><a href="editCategory?id=${cl.categoryID}"><i
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

</body>
</html>
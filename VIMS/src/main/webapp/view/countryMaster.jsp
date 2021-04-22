<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ page isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>



<html lang="en">
<head>
<style type="text/css">
.imagePreview {
	width: 60%;
	height: 60%;
	background-position: center center;
	background:
		url(http://cliquecities.com/assets/no-image-e3699ae23f866f6cbdf8ba2443ee5c4e.jpg);
	background-color: #fff;
	background-size: cover;
	background-repeat: no-repeat;
	display: inline-block;
	box-shadow: 0px -3px 6px 2px rgba(0, 0, 0, 0.2);
}

.btn-primary {
	display: block;
	font-color: #FFFFFF;
	box-shadow: 0px 4px 6px 2px rgba(0, 0, 0, 0.2);
	margin-top: 1px;
}

.imgUp {
	margin-bottom: 15px;
}

.del {
	position: absolute;
	top: 0px;
	right: 15px;
	width: 30px;
	height: 30px;
	text-align: center;
	line-height: 30px;
	background-color: rgba(255, 255, 255, 0.6);
	cursor: pointer;
}

.imgAdd {
	width: 30px;
	height: 30px;
	border-radius: 50%;
	background-color: #4bd7ef;
	color: #fff;
	box-shadow: 0px 0px 2px 1px rgba(0, 0, 0, 0.2);
	text-align: center;
	line-height: 30px;
	margin-top: 0px;
	cursor: pointer;
	font-size: 15px;
}
</style>

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

				<div class="panel-header bg-primary-gradient">
					<div class="page-inner py-3">
						<div
							class="d-flex align-items-left align-items-md-center flex-column flex-md-row">
							<div class="col-xl-3 col-lg-2">
								<h2 class="text-white pb-2 fw-bold">Country Information</h2>

							</div>
							<div class="col-xl-2 col-lg-2"></div>
							<div class="ml-md-auto py-2 py-md-4">
								<li class="separator"><i class="flaticon-right-arrow"></i>
								</li>
							</div>

							<div class="ml-md-auto py-2 py-md-4">
								<a class="btn btn-white btn-border btn-round mr-2"
									href="taxConfiguration">Tax Configuration</a>
							</div>
						</div>
					</div>
				</div>

				<div class="page-inner mt--5">
					<div class="container-fluid">

						<div
							class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
							<div class="col-xl-9 col-md-6mb-4 ">
								<div class="card border-left-primary shadow h-100 py-2">
									<div class="card-body">
										<div class="row no-gutters align-items-center">
											<div class="col mr-2">

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

												<form:form action="saveCountry" method="post" name="cForm"
													modelAttribute="cMaster" enctype="multipart/form-data"
													id="formCountry" onsubmit="return checkDefault()">


													<div class="form-group row">
														<div class="col-sm-5">
															<div class="col-sm-60 mb-1 mb-sm-3">
																<label for="country">Country <span
																	class="required text-danger">*</span></label>
																<form:input class="form-control form-control-sm"
																	id="country" name="country" path="country"
																	placeholder="Enter Country Name" />
																<form:errors path="country" class="bg-danger text-white" />
															</div>


														</div>
														<div class="col-sm-2"></div>
														<div class="col-sm-4">
															<div class="col-sm-30 mb-1 mb-sm-3">
																<label for="countryCode">Country Code <span
																	class="required text-danger">*</span></label>
																<form:input class="form-control form-control-sm"
																	path="countryCode" placeholder="Country Code"
																	id="countryCode" name="countryCode" />
																<form:errors path="countryCode"
																	class="bg-danger text-white" />
															</div>
														</div>
													</div>

													<div class="form-group row">
														<div class="col-sm-5">
															<div class="col-sm-60 mb-1 mb-sm-3">
																<label for="currency">Default Currency <span
																	class="required text-danger">*</span></label>
																<form:input class="form-control form-control-sm"
																	path="currency" placeholder="Enter Currency"
																	id="currency" />
																<form:errors path="currency"
																	class="bg-danger text-white" />
															</div>
														</div>
														<div class="col-sm-2"></div>
														<div class="col-sm-4">
															<div class="col-sm-30 mb-1 mb-sm-3">
																<label for="countryCode">Currency Description <span
																	class="required text-danger">*</span></label>
																<form:input class="form-control form-control-sm"
																	path="currencyDescription"
																	placeholder="Currency Description"
																	id="currencyDescription" name="currencyDescription" />
																<form:errors path="currencyDescription"
																	class="bg-danger text-white" />
															</div>
														</div>

													</div>
													<div class="form-group row">

														<div class="col-sm-5">
															<div class="col-sm-30 mb-1 mb-sm-3">
																<label for="countryCode">Date Format<span
																	class="required text-danger">*</span></label>
																<form:input class="form-control form-control-sm"
																	path="dateFormat" placeholder="DD/MM/YYYY"
																	id="dateFormat" name="dateFormat" />
																<form:errors path="dateFormat"
																	class="bg-danger text-white" />
															</div>
														</div>
													</div>

													<div class="col-6">
														<div class="form-group">
															<div class="row">
																<div class="col-7">
																	<c:if test="${cMaster.flagImg != null}">
																		<img src="data:image/jpg;base64,${flagimg}"
																			id="preview" class="img-thumbnail" width="120" height="120">
																		<label class="btn btn-primary">Upload Photo<form:input
																				type="file" class="uploadFile img"
																				value="Upload Photo"
																				style="width: 0px; height: 0px; overflow: hidden;"
																				accept="image/*" id="flagImg" path="flagImg" /></label>	
																	</c:if>
																	<c:if test="${cMaster.flagImg == null}">
																		<img class="img-thumbnail"
																			src="<c:url value='/resources/img/empty-placeholder-image-icon.jpg'/>"
																			id="preview" class="img-thumbnail" width="120" height="120">
																		<label class="btn btn-primary">Upload Photo<form:input
																				type="file" class="uploadFile img"
																				value="Upload Photo"
																				style="width: 0px; height: 0px; overflow: hidden;"
																				accept="image/*" id="flagImg" path="flagImg" /></label>
																	</c:if>
																</div>
															</div>
														</div>

													</div>

													<div class="custom-control custom-checkbox">


														<div class="col-sm-60 mb-1 mb-sm-3">
															<label>Status</label> <br>
															<form:radiobutton path="status" value="Active"
																checked="checked" />
															ACTIVE
															<form:radiobutton path="status" value="Inactive" />
															INACTIVE

														</div>


													</div>

													<br>
													<br>


													<input type="submit" class="btn btn-success"
														value="Add Country">

													<input type="reset" class="btn btn-warning" value="Clear">


												</form:form>


												<div id="tableCountry" class="scrollable mt-5">
													<table class=" table table-bordered table-hover"
														width="100%" cellspacing="0">
														<thead>
															<tr>
																<th>Country Code</th>
																<th>Country</th>
																<th>Currency</th>
																<th>Currency Description</th>

																<th>Status</th>
																<th>Flag</th>
															</tr>
														</thead>
														<tbody>
															<c:forEach var="country" items="${listCountryMaster}">
																<tr>
																	<td>${country.countryCode}</td>
																	<td>${country.country }</td>
																	<td>${country.currency }</td>
																	<td>${country.currencyDescription }</td>
																	<td>${country.status}</td>
																	<td><c:if test="${country.flagImg != null}">
																			<img
																				src="data:image/jpg;base64,${country.flagImgView}"
																				width="90" height="80" alt="No image" />
																		</c:if></td>
																	<td><a
																		href="editCountry?id=${country.countryCode}"><i
																			class="material-icons">&#xE254;</i></a></td>
																</tr>
															</c:forEach>
														</tbody>
													</table>
												</div>
											</div>
										</div>
									</div>
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



</body>
</html>
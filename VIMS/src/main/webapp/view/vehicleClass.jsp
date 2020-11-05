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
							<h4 class="page-title">Vehicle Information</h4>
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
									<a href="#">Class</a>
								</li>
							
							</ul>
						</div>
				
						
					
							<div
								class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
								<div class="col-xl-9 col-md-12 mb-4 ">
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
															<strong>Warning!</strong>Something went wrong ! Please
															try again!
														</div>
													</c:if>

													<form:form action="saveVClass" method="post"
														modelAttribute="saveVClass" id="classForm"
														enctype="multipart/form-data">

														<div class="form-group row">

															<div class="col-sm-5">
																<div class="col-sm-60 mb-1 mb-sm-3">
																	<label for="vehicleClass">Vehicle Class</label>
																	<form:input class="form-control form-control-user" 
																		id="vehicleClass" path="vehicleClass" value="${saveVClass.vehicleClass}"/>
																	<form:errors path="vehicleClass" class="bg-danger text-white"/>

																</div>
															</div>

															<div class="col-sm-2"></div>
															<div class="col-sm-3">
																<div class="col-sm-30 mb-1 mb-sm-3">
																	<label for="vehicleClassID">Vehicle Class ID</label>
																	<form:input class="form-control form-control-user"
																		path="vehicleClassID"
																		value="${saveVClass.vehicleClassID}" readOnly="true" />


																</div>
															</div>

														</div>

														<div class="form-group row">
															<div class="col-sm-5">
																<div class="col-sm-60 mb-1 mb-sm-3">
																	<label>Vehicle Class Image</label> <input type="file"
																		class="file" accept="image/*" name="vehicleclassLogo">
																	<div class="input-group">
																		<input type="text" class="form-control"
																			placeholder="Choose Image..." id="file" disabled>
																		<div class="input-group-append">
																			<button type="button" class="browse btn btn-primary">Browse</button>
																		</div>
																	</div>

																</div>
															</div>
															<div class="col-sm-5">
																<div class="ml-2 col-sm-6">
																	<c:if test="${saveVClass.vehicleclassLogo != null}">
																		<img
																			src="data:image/jpg;base64,${saveVClass.vehicleclassLogoView}"
																			id="preview" class="img-thumbnail">
																	</c:if>
																	<c:if test="${saveVClass.vehicleclassLogo == null}">
																		<img src="" id="preview" class="img-thumbnail">
																	</c:if>

																</div>
															</div>

															<div class="col-sm-5">
																<div class="col-sm-60 mb-1 mb-sm-3">
																	<label for="categoryID">Vehicle Category</label>
																	<form:select class="custom-select"
																		path="categoryID.categoryID" required="true" id="categoryID" >
																		<form:option value="">Select Vehicle Category</form:option>
																		<c:forEach items="${vehicleCategoryCombo}" var="cat">
																			<form:option value="${cat.categoryID}">${cat.vehicleCategory}</form:option>
																		</c:forEach>
																	</form:select>
																</div>
															</div>


															<div class="col-sm-5">
																<div class="col-sm-60 mb-1 mb-sm-3">
																	<label for="remark">Remark</label>
																	<form:textarea path="remark" class="form-control" value="${saveVClass.remark}"/>
																</div>
															</div>
														</div>

														<div class="col-sm-5">
															<div class="col-sm-60 mb-1 mb-sm-3">
																<label>Status</label> <br>
																<form:radiobutton path="status" value="Active"
																	checked="checked" />
																ACTIVE
																<form:radiobutton path="status" value="Inactive" />
																INACTIVE
															</div>
														</div>





														<table>
															<tr>
																<td>
																	<div class="col-sm-7 mb-1 mb-sm-3">
																		<input type="submit" class="btn btn-success"
																			value="Add Vehicle Class">
																	</div>
																</td>


																<td>
																	<div class="col-sm-7 mb-1 mb-sm-3">
																		<input type="button" class="btn btn-warning"
																			onclick="clear1()" value="CLEAR">
																	</div>

																</td>


															</tr>
														</table>

													</form:form>
													<div id="tableClass" class="scrollable  table-wrapper-scroll-y my-custom-scrollbar">
														<table class="table table-bordered table-hover"
															width="100%" cellspacing="0">
															<thead>
																<tr>
																	<th>Vehicle Class ID</th>
																	<th>Vehicle Class</th>
																	<th>Image</th>
																	<th>Vehicle Category</th>
																	<th>Remark</th>
																	<th>Status</th>
																	<th></th>
																</tr>
															</thead>
															<tbody id="myTable">
																<c:forEach items="${listVehicleClass}" var="vc">
																	<tr>
																		<td><div>${vc.vehicleClassID}</div></td>
																		<td><div>${vc.vehicleClass}</div></td>
																		<td><div>
																				<c:if test="${vc.vehicleclassLogo != null}">
																					<img
																						src="data:image/jpg;base64,${vc.vehicleclassLogoView}"
																						width="90" height="80"/>
																				</c:if>
																			</div></td>
																			<td><div>${vc.categoryID.vehicleCategory}</div></td>
																			
																		<td><div>${vc.remark}</div></td>
																		<td><div>${vc.status}</div></td>
																		<td><a href="editClass?id=${vc.vehicleClassID}"><i
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
			<%@include file="../WEB-INF/jsp/footer.jsp"%>			
		</div>
	</div>
<%@include file="../WEB-INF/jsp/commJs.jsp"%>

</body>
</html>
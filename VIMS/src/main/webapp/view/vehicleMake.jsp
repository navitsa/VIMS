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
									<a href="#">Make</a>
								</li>
							
							</ul>
						</div>
				
						
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
															<strong>Warning!</strong>Something went wrong ! Please
															try again!
														</div>
													</c:if>


													<form:form action="saveVMake" method="post"
														modelAttribute="VMakeForm" enctype="multipart/form-data"
														id="formMake">

														<div class="form-group row">
															<div class="col-sm-5">
																<div class="col-sm-60 mb-1 mb-sm-3">
																	<label for="vm">Vehicle Make</label>
																	<form:input class="form-control" path="vehicleMake"
																		id="vm" />
																	<form:errors path="vehicleMake" class="bg-danger text-white"/>
																</div>
															</div>
															<div class="col-sm-2"></div>
															<div class="col-sm-3">
																<div class="col-sm-30 mb-1 mb-sm-3">
																	<label for="vehicleMakeID">Make ID</label>
																	<form:input class="form-control" path="vehicleMakeID"
																		value="${nextVMID.vehicleMakeID}" readonly="true" />
																</div>
															</div>

														</div>
														<div class="form-group row">
															<div class="col-sm-5">
																<div class="col-sm-60 mb-1 mb-sm-3">
																	<label>Make Logo</label> <form:input type="file"
																		class="file" accept="image/*" path="makeLogo"/>
																	<div class="input-group">
																		<input type="text" class="form-control"
																			placeholder="Choose Logo..." id="file" disabled>
																		<div class="input-group-append">
																			<button type="button" class="browse btn btn-primary">Browse</button>
																		</div>
																	</div>

																</div>
															</div>
															<div class="col-sm-5">
																<div class="ml-2 col-sm-6">
																	<c:if test="${VMakeForm.makeLogo != null}">
																		<img src="data:image/jpg;base64,${makeImg}"
																			id="preview" class="img-thumbnail">
																	</c:if>
																	<c:if test="${VMakeForm.makeLogo == null}">
																		<img src="" id="preview" class="img-thumbnail">
																	</c:if>

																</div>
															</div>



															<div class="col-sm-5">
																<div class="col-sm-60 mb-1 mb-sm-3">
																	<label for="remark">Remarks</label>
																	<form:textarea path="remark" class="form-control" />
																	<form:errors path="remark" class="bg-danger text-white"/>
																</div>
															</div>
														</div>
														<div class="form-group row">
															<div class="col-sm-7">
																<div class="col-sm-60 mb-1 mb-sm-3">
																	<label>Status</label> <br>
																	<form:radiobutton path="status" value="Active"
																		checked="checked" />
																	ACTIVE
																	<form:radiobutton path="status" value="Inactive" />
																	INACTIVE

																</div>
															</div>
															<div class="col-sm-2"></div>
															<div class="col-sm-3"></div>

														</div>

														<table>
															<tr>
																<td>
																	<div class="col-sm-7 mb-1 mb-sm-3">
																		<input type="submit" class="btn btn-success"
																			value="Add Vehicle Make">
																	</div>
																</td>


																<td>
																	<div class="col-sm-7 mb-1 mb-sm-3">
																		<input type="reset" class="btn btn-warning"
																			value=" Clear ">
																	</div>

																</td>


															</tr>
														</table>

													</form:form>


											
									<div id="tableClass" class="scrollable  table-wrapper-scroll-y my-custom-scrollbar">
											<table id="eqvechiTable" class="table table-bordered table-hover"
															width="100%" cellspacing="0">

														<tr>
															<th style="width: 10%">ID</th>
															<th style="width: 30%">Make</th>
															<th style="width: 20%">Logo</th>
															<th style="width: 20%">Remark</th>
															<th style="width: 30%">Status</th>
															<th style="width: 10%"></th>
														</tr>
														<c:forEach items="${makeList}" var="mk">
															<tr>
																<td><div>${mk.vehicleMakeID}</div></td>
																<td><div>${mk.vehicleMake}</div></td>
																<td><div>
																		<c:if test="${mk.makeLogo != null}">
																			<img src="data:image/jpg;base64,${mk.makeLogoView}"
																				width="90" height="80"/>
																		</c:if>
																	</div></td>
																<td><div>${mk.remark}</div></td>
																<td><div>${mk.status}</div></td>

																<td><a href="editMake?id=${mk.vehicleMakeID}"><i
																		class="material-icons">&#xE254;</i></a></td>
															</tr>

														</c:forEach>

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
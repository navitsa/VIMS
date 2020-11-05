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
							<h4 class="page-title">Country Information</h4>
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
									<a href="#">Country Setting</a>
								</li>
								<a class="btn btn-primary btn-sm" href="taxConfiguration">Tax Configuration</a>
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

													<form:form action="saveCountry" method="post" name="cForm"
														modelAttribute="cMaster" enctype="multipart/form-data"
														id="formCountry" onsubmit="return checkDefault()">


														<div class="form-group row">
															<div class="col-sm-5">
																<div class="col-sm-60 mb-1 mb-sm-3">
																	<label for="country">Country <span class="required text-danger">*</span></label>
																	<form:input class="form-control form-control-sm"
																		id="country" name="country" path="country"
																		placeholder="Enter Country Name" />
																	<form:errors path="country" class="bg-danger text-white"/>
																</div>

														
															</div>
															<div class="col-sm-2"></div>
															<div class="col-sm-4">
																<div class="col-sm-30 mb-1 mb-sm-3">
																	<label for="countryCode">Country Code <span class="required text-danger">*</span></label>
																	<form:input class="form-control form-control-sm"
																		path="countryCode" placeholder="Country Code"
																		id="countryCode" name="countryCode" />
																	<form:errors path="countryCode" class="bg-danger text-white"/>
																</div>
															</div>
														</div>
														
														<div class="form-group row">
															<div class="col-sm-5">
																<div class="col-sm-60 mb-1 mb-sm-3">
																	<label for="currency">Default Currency <span class="required text-danger">*</span></label>
																	<form:input class="form-control form-control-sm"
																		path="currency" placeholder="Enter Currency" id="currency" />
																	<form:errors path="currency" class="bg-danger text-white"/>
																</div>
															</div>
															<div class="col-sm-2"></div>
															<div class="col-sm-4">
																<div class="col-sm-30 mb-1 mb-sm-3">
																	<label for="countryCode">Currency Description <span class="required text-danger">*</span></label>
																	<form:input class="form-control form-control-sm"
																		path="currencyDescription" placeholder="Currency Description"
																		id="currencyDescription" name="currencyDescription" />
																	<form:errors path="currencyDescription" class="bg-danger text-white"/>
																</div>
															</div>
														</div>			
														
														
														
														

														<div class="form-group row">
															<div class="col-lg-5">
																<form:input type="file" class="file" id="flagImg" path="flagImg" ></form:input>
																	<div class="input-group">
																		 <input type="text" class="form-control form-control-sm" placeholder="Choose Country Flag..." id="file"  disabled >
																		 <div class="input-group-append">
																		 	<button type="button" class="browse btn btn-primary btn-sm">Browse</button>
																		 </div>
																	</div>
															</div>
												            <div class="col-lg-4">
												                <div class="ml-2 col-sm-6">
												                	<c:if test = "${cMaster.flagImg == null}">
												                 		<img src="<c:url value='/resources/img/empty-placeholder-image-icon.jpg'/>" id="preview" class="img-thumbnail"/>
												                 	</c:if>
												                 	<c:if test = "${cMaster.flagImg != null}">
																		 <img src="data:image/jpg;base64,${flagimg}" id="preview" width="80" height="80" alt=""/>
																	</c:if>
												                 </div>
												            </div>
														</div>
														
														<div class="custom-control custom-checkbox">


																<div class="col-sm-60 mb-1 mb-sm-3">
																	<label>Status</label> <br>
																	<form:radiobutton path="status" value="Active" checked="checked" />ACTIVE
																	<form:radiobutton path="status" value="Inactive" />INACTIVE
																	
																</div>


														</div>
														
														<br><br>
														

														<input type="submit" class="btn btn-success" value="Add Country">

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
																			</c:if>
																		</td>
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
			<%@include file="../WEB-INF/jsp/footer.jsp"%>			
		</div>
	</div>
<%@include file="../WEB-INF/jsp/commJs.jsp"%>



</body>
</html>
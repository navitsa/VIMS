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
							<h4 class="page-title">Centers Organization</h4>
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
									<a href="#">Inspection Centers</a>
								</li>
							<li class="separator">
									<i class="flaticon-right-arrow"></i>
								</li>
								<li class="nav-item">
									<a href="#">Organization</a>
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

													<form:form action="saveCenterType" method="POST"
														modelAttribute="ct">

														<div class="form-group row">
															<div class="col-sm-5">
																<div class="col-sm-60 mb-1 mb-sm-3">
																	<label for="ctype">Center Type <span class="required text-danger">*</span></label>
																	<form:input class="form-control form-control-sm"
																		path="centerType" id="ctype" value="${ct.centerType}" />
																	<form:errors path="centerType" class="bg-danger text-white"/>
																</div>
															</div>
															<div class="col-sm-2"></div>
															<div class="col-sm-3">
																<div class="col-sm-30 mb-1 mb-sm-3">
																	<!-- <label>Center Type ID</label> -->
																	<form:input path="centerTypeID" value="${ct.centerTypeID}" type="hidden"/>
																</div>
															</div>
														</div>


														<div class="form-group row">
															<div class="col-sm-5">
																<div class="col-sm-60 mb-1 mb-sm-3">
																	<form:textarea class="form-control" placeholder="Remark" 
																		path="remarks" value="${ct.remarks}" />
																	<form:errors path="remarks" class="bg-danger text-white" />
																</div>
															</div>
															<div class="col-sm-2"></div>
															<div class="col-sm-3"></div>
														</div>

														<div class="form-group row">
															<div class="col-sm-5">
																<div class="col-sm-60 mb-1 mb-sm-3">
																	<label>Status</label> <br> 
																	<input type="radio" name="status" value="Active" checked="checked">
																	Active 
																	<input type="radio" name="status" value="Inactive"> 
																	Inactive
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
																			value="Save">
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

													<div id="tableTypes" class="scrollable mt-5">
														<table class=" table table-bordered table-hover"
															width="100%" cellspacing="0">
															<thead>
																<tr>
																	<th>Center Type ID</th>
																	<th>Center Type</th>
																	<th>Remark</th>
																	<th>Status</th>
																	<th></th>

																</tr>
															</thead>
															<tbody>

																<c:forEach items="${types}" var="countm">
																	<tr>
																		<td><div>${countm.centerTypeID}</div></td>
																		<td><div>${countm.centerType}</div></td>
																		<td><div>${countm.remarks}</div></td>
																		<td><div>${countm.status}</div></td>
																		<td><a
																			href="updateCenterType?centerTypeID=${countm.centerTypeID}"><i
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
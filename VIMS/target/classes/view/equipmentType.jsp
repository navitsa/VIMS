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
							<h4 class="page-title">Testing Equipment</h4>
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
									<a href="#">Type</a>
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
													<form:form action="saveequipmenttype" method="post"
														modelAttribute="equipmentType">


														<div class="form-group row">
															<div class="col-sm-7">
																<div class="col-sm-60 mb-1 mb-sm-3">
																	<label for="eqType">Equipment Type</label>
																	<form:input class="form-control form-control-sm"
																		path="eqType" />
																	<form:errors path="eqType" class="bg-danger text-white"/>
																</div>
															</div>
															<div class="col-sm-2"></div>
															<div class="col-sm-3">
																<div class="col-sm-30 mb-1 mb-sm-3">
																	<label for="eqTypeID">Equipment Type ID</label>
																	<form:input class="form-control form-control-sm"
																		path="eqTypeID" readonly="true" />

																</div>
															</div>
														</div>
														<div class="form-group row">
															<div class="col-sm-7">
																<div class="col-sm-60 mb-1 mb-sm-3">
																	<label for="remark">Remarks</label>
																	<form:textarea path="remark" class="form-control"/>

																</div>
															</div>
															<div class="col-sm-2"></div>
															<div class="col-sm-3"></div>

														</div>

														<div class="form-group row">
															<div class="col-sm-7">
																<div class="col-sm-60 mb-1 mb-sm-3">
																	<label>Status</label> <br>
																	<form:radiobutton path="status" value="ACTIVE"
																		checked="checked" />
																	ACTIVE
																	<form:radiobutton path="status" value="INACTIVE" />
																	INACTIVE
																	<form:errors path="status" class="errortext" />
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
																			value="Add Equipment Type">
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

													<table id="eqTypeTable"
														class="table table-striped table-bordered table-sm table-wrapper-scroll-y my-custom-scrollbar"
														cellspacing="0">
														<!--  <col width="150"> 
		<col width="200"> 
		<col width="0"> 
		<col width="0">
		<col width="0">-->
														<thead>
															<tr>
																<th>Equipment Type ID</th>
																<th>Equipment Type</th>
																<th>Status</th>
																<th>Remarks</th>
																<th></th>
															</tr>
														</thead>
														<tbody id="myTable">
															<c:forEach items="${allequipmenttype}"
																var="equipmenttype">
																<tr>
																	<td><div>${equipmenttype.eqTypeID}</div></td>
																	<td><div>${equipmenttype.eqType}</div></td>
																	<td><div>${equipmenttype.status}</div></td>
																	<td><div>${equipmenttype.remark}</div></td>
																	<td><a
																		href="editEqType?id=${equipmenttype.eqTypeID}"><i
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
			<%@include file="../WEB-INF/jsp/footer.jsp"%>			
		</div>
	</div>
<%@include file="../WEB-INF/jsp/commJs.jsp"%>

</body>
</html>
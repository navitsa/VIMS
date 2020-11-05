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
							<h4 class="page-title">Test Configurations</h4>
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
								<li class="separator">
									<i class="flaticon-right-arrow"></i>
								</li>
								<li class="nav-item">
									<a href="#">Add Equipment Type</a>
								</li>
							</ul>
						</div>
				
								<div
								class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
								<div class="col-xl-11 col-md-6mb-4">
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
												
													<form:form action="saveTesttypeEqumenttype"
														modelAttribute="testtypeEqumenttype" method="POST">
													

														<div class="row">
															<div class="col-sm-5  border border-top-0">
																<div class="col-sm-60 mb-1 mb-sm-3">
																	<label>Test Type</label>
																	<form:select class="form-control form-control-user"
																		path="typeId.typeId" readonly="true">
																		<form:option value="">- Select Test Type -</form:option>
																		<c:forEach items="${testtypeListTy}" var="lane1">
																			<form:option value="${lane1.typeId}">${lane1.type}</form:option>
																		</c:forEach>
																	</form:select>

																</div>
															</div>
															<div class="col-sm-4">
															

															</div>
															
															<div class="col-sm-3">
				
															</div>
														</div>
													

														<div class="row">
															<div class="col-sm-5  border border-top-0">
																<div class="col-sm-60 mb-1 mb-sm-3">
											<label>Equipment Type</label>
											<form:select class="form-control"
												path="eqTypeID.eqTypeID" required="Required">
												<form:option value="">--SELECT--</form:option>
												<c:forEach items="${eqTypeCmbfortesttyp}" var="eq1">
													<form:option value="${eq1.eqTypeID}">${eq1.eqType}</form:option>
												</c:forEach>
											</form:select>

																</div>
															</div>
															<div class="col-sm-4">
															

															</div>
															
															<div class="col-sm-3">
				
															</div>
														</div>













														<button type="submit" class="btn btn-primary mt-2">
															Save<i class=""></i>
														</button>

													</form:form>
													<br/>
												<div id="tableLane" class="scrollable">
												<table
													class=" table table-bordered table-hover"
													cellspacing="0">
													<thead>
														<tr>
															<th>ID</th>
															<th>Test Type</th>
															<th>Equipment Type</th>
<!-- 															<th></th> -->


														</tr>
													</thead>
													<tbody id="myTable">
														<c:forEach items="${testtypeequmenttypeList}" var="testtypeq">
															<tr>
																<td><div>${testtypeq.id}</div></td>
																<td><div>${testtypeq.typeId.type}</div></td> 
																<td><div>${testtypeq.eqTypeID.eqType}</div></td>
															
																
																
<%-- 																 <td><a href="editTestlanes?laneId=${lane.laneId}"><i class="material-icons">&#xE254;</i></a></td>  --%>
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
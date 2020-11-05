<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ page isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>



<html>
<head>
	<title>Add Vehicle Class To Lane</title>
	<!-- head -->
	<%@include file="../WEB-INF/jspf/head.jsp"%>
</head>
<body id="page-top">


	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- Sidebar -->
		<%@include file="../WEB-INF/jspf/slideBar.jsp"%>

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">

				<!-- Top Bar -->
				<%@include file="../WEB-INF/jspf/header.jsp"%>


				<!-- Begin Page Content -->
				<div class="container-fluid">

					<h1 class="h3 mb-4 text-gray-800">Add Vehicle Class To Lane</h1>
					<div class="row">
						<div class="container">
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
												
													<form:form action="savelaneTypeVehicleClass"
														modelAttribute="laneTypeVehicleClass" method="POST">
													

														<div class="row">
															<div class="col-sm-5  border border-top-0">
																<div class="col-sm-60 mb-1 mb-sm-3">
																	<label>Lane Type</label>
																	<form:select class="form-control form-control-user"
																		path="laneId.laneId">
																		<form:option value="">- Select Test Type -</form:option>
																		<c:forEach items="${alllanes}" var="lane1">
																			<form:option value="${lane1.laneId}">${lane1.lane}</form:option>
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
																	<label>Vehicle Class</label>

																	<form:select class="form-control form-control-user"
																		id="vehicleClassID" path="vehicleClassID.vehicleClassID"
																		required="Required">
																		<form:option value="">Select Vehicle Class
															</form:option>
																		<c:forEach items="${vclassLane}" var="vcl">
																			<form:option value="${vcl.vehicleClassID}">${vcl.vehicleClass}</form:option>
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
															<th>Lane Type</th>
															<th>Vehicle Class</th>
<!-- 															<th></th> -->


														</tr>
													</thead>
													
													<tbody id="myTable">
														<c:forEach items="${laneTypeVehicleClasslist}" var="lane">
															<tr>
																<td><div>${lane.id}</div></td>
																<td><div>${lane.laneId.lane}</div></td> 
																<td><div>${lane.vehicleClassID.vehicleClass}</div></td>
															
																
																
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












				</div>

				<!-- End of Page Content -->


			</div>
			<!-- End of Main Content -->

			<!-- Footer -->
			<%@include file="../WEB-INF/jspf/footer.jsp"%>

		</div>
		<!-- End of Content Wrapper -->

	</div>
	<!-- End of Page Wrapper -->

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>

	<!-- Logout Modal-->
	<%@include file="logoutModel.jsp"%>



	<!-- Bootstrap core JavaScript-->
	<script src="<c:url value='/resources/vendor/jquery/jquery.min.js'/>"></script>
	<script
		src="<c:url value='/resources/vendor/bootstrap/js/bootstrap.bundle.min.js'/>"></script>

	<!-- Core plugin JavaScript-->
	<script
		src="<c:url value='/resources/vendor/jquery-easing/jquery.easing.min.js'/>"></script>

	<!-- Custom scripts for all pages-->
	<script src="<c:url value='/resources/js/sb-admin-2.min.js'/>"></script>

	<!-- Page level plugins -->
	<script src="<c:url value='/resources/vendor/chart.js/Chart.min.js'/>"></script>

	<!-- Page level custom scripts -->
	<script src="<c:url value='/resources/js/demo/chart-area-demo.js'/>"></script>
	<script src="<c:url value='/resources/js/demo/chart-pie-demo.js'/>"></script>
	
	
	
	
		<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
	
	<script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
	
	<script src="https://cdn.datatables.net/rowgroup/1.1.1/js/dataTables.rowGroup.min.js"></script>




</body>
</html>
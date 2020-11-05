<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ page isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
	<title>Inspection Center</title>
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

					<h1 class="h3 mb-4 text-gray-800">Inspection Center</h1>
					<div class="row">
						<div class="container">
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
																	<label>Equipment Type</label>
																	<form:input class="form-control form-control-user"
																		path="eqType" />
																	<form:errors path="eqType"
																		cssClass="error1 text-danger" />
																</div>
															</div>
															<div class="col-sm-2"></div>
															<div class="col-sm-3">
																<div class="col-sm-30 mb-1 mb-sm-3">
																	<label>Equipment Type ID</label>
																	<form:input class="form-control form-control-user"
																		path="eqTypeID" readonly="true" />

																</div>
															</div>
														</div>
														<div class="form-group row">
															<div class="col-sm-7">
																<div class="col-sm-60 mb-1 mb-sm-3">
																	<label>Remarks</label>
																	<form:input class="form-control form-control-user"
																		path="remark" />

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
																		<input type="submit" class="btn btn-primary"
																			value="Save">
																	</div>
																</td>


																<td>
																	<div class="col-sm-7 mb-1 mb-sm-3">
																		<input type="reset" class="btn btn-primary"
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




</body>
</html>
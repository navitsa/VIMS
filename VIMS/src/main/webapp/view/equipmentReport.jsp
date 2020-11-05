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
									<a href="#">Equipments List</a>
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






													<table id="example" class="display" style="width: 100%">
														<thead>
															<tr>


																<th>Type</th>
																<th>Make</th>
																<th>Model</th>
																<th style="padding-left: 20em;">ID</th>
																<th style="padding-left: 0em;">Serial NO</th>


															</tr>
														</thead>
														<tbody>

															<c:forEach items="${listalleqdetails}"
																var="listalleqdetails">
																<tr>
																	<td><div>${listalleqdetails.eqModelID.eqTypeID.eqType}</div></td>
																	<td><div style="padding-left: 5em;">${listalleqdetails.eqModelID.eqMakeID.eqMake}
																			<c:if
																				test="${listalleqdetails.eqModelID.eqMakeID.eqMakeLogo != null}">
																				<img
																					src="data:image/jpg;base64,${listalleqdetails.eqModelID.eqMakeID.eqMakeLogoView}"
																					width="90" height="80" alt="" />
																			</c:if>
																		</div></td>
																	<td><div style="padding-left: 10em;">${listalleqdetails.eqModelID.eqModel}
																			<c:if
																				test="${listalleqdetails.eqModelID.eqModelLogo != null}">
																				<img
																					src="data:image/jpg;base64,${listalleqdetails.eqModelID.eqModelLogoView}"
																					width="90" height="80" alt="" />
																			</c:if>

																		</div></td>
																	<td><div style="padding-left: 20em;">${listalleqdetails.equipmentID}</div></td>
																	<td><div style="padding-left: 0em;">${listalleqdetails.serialNo}</div></td>

																</tr>

															</c:forEach>


														</tbody>
														<tfoot>

														</tfoot>
													</table>

													<form:form action="saveequipmenttype" method="post"
														modelAttribute="equipmentType">



														<a href="equipmentSummaryReport"
															class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
															class="fas fa-download fa-sm text-white-50"></i> Generate
															Report</a>



														<!-- 										<a href="exchangeRates">Equipment Summary Report</a> -->
													</form:form>


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


	<script type="text/javascript">
		$(document).ready(function() {
			$('#example').DataTable({
				order : [ [ 0, 'asc' ], [ 1, 'asc' ], [ 2, 'asc' ] ],
				rowGroup : {
					dataSrc : [ 0, 1, 2 ]
				},
				columnDefs : [ {
					targets : [ 0, 1, 2 ],
					visible : false
				} ]
			});
		});
	</script>

</body>
</html>
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
							<h4 class="page-title">Lane Types</h4>
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
									<a href="#"></a>
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




													<form:form action="savetestLanes" method="post"
														modelAttribute="saveTestLane" id="formTestLane">

													<form:input class="form-control form-control-user"
																		path="laneId" value="${netmaxid.laneId}" type="hidden" readonly="true" />

														<div class="form-group row">
															<div class="col-sm-5">
																<div class="col-sm-60 mb-1 mb-sm-3">

																	<label>Lane Type</label>
																	<form:input class="form-control form-control-user"
																		path="lane" placeholder="Enter Lane Type"/>
																		<form:errors path="lane" cssClass="error1 text-danger"/>

																</div>
															</div>
															<div class="col-sm-1"></div>
															<div class="col-sm-4">
															<br>
															
															
															</div>
														</div>



														<div class="form-group row">
															<div class="col-sm-5">
																<div class="col-sm-60 mb-1 mb-sm-3">
																	<label>Remark</label>
																	<form:input class="form-control form-control-user"
																		path="remark" placeholder="enter remark"/>
<%-- 																		<form:errors path="remark" cssClass="error1 text-danger"/> --%>
																</div>
															</div>
															<div class="col-sm-1"></div>
															<div class="col-sm-5">
															<br>
															
															</div>
														</div>

														<div class="form-group row">
															<div class="col-sm-5">
																<label for="name">Status</label> <br>

																<form:radiobutton path="status" value="Active"
																	checked="checked" />
																Active
																<form:radiobutton path="status" value="Inactive" />
																Inactive

															</div>
															<div class="col-sm-2"></div>
															<div class="col-sm-3"></div>

														</div>

														<table>
															<tr>
																<td>
																	<div class="col-sm-7 mb-1 mb-sm-3">
																		<input type="submit" class="btn btn-primary btn-sm"
																			value="Save">
																	</div>
																</td>


																<td>
																	<div class="col-sm-7 mb-1 mb-sm-3">
																		<input type="reset" class="btn btn-primary btn-sm"
																			value=" Clear ">
																	</div>

																</td>


															</tr>
														</table>
													</form:form>
										
												
												<div id="tableLane" class="scrollable">
												<table
													class=" table table-bordered table-hover"
													cellspacing="0">
													<thead>
														<tr>				
															<th>Lane Type</th>
															<th>Status</th>
															<th>Remark</th>									
															<th></th>


														</tr>
													</thead>
													<tbody id="myTable">
														<c:forEach items="${AlltestLane}" var="lane">
															<tr>
																
																<td><div>${lane.lane}</div></td>
																<td><div>${lane.status}</div></td>		
																<td><div>${lane.remark}</div></td>	
																<td><a href="editTestlanes?laneId=${lane.laneId}"><i class="material-icons">&#xE254;</i></a></td> 
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

		
		<script>
			$(document).on("click", ".open-VehicleClass", function() {
				var laneID = $(this).data('id');
				var name = $(this).data('name');
				var vclass = $(this).data('clss');
				
				$(".modal-body #vclass").val(vclass);
				$(".modal-body #laneID").val(laneID);
				$(".modal-body #name").val(name);
				
				
				
		
				
				
				
				
				
				// As pointed out in comments, 
				// it is unnecessary to have to manually call the modal.
				// $('#addBookDialog').modal('show');
			});
		</script>

</body>
</html>
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
													<form:form action="saveequipmentMake" method="post"
														modelAttribute="equipmentMake" id="eqMakeForm"
														enctype="multipart/form-data"
														onsubmit="return Filevalidation()">

														<div class="form-group row">
															<div class="col-sm-5">
																<div class="col-sm-60 mb-1 mb-sm-3">
																	<label for="eqMake">Equipment Make</label>
																	<form:input class="form-control form-control-sm"
																		id="eqMake" path="eqMake"/>
																	<form:errors path="eqMake" class="bg-danger text-white"/>
																</div>
															</div>
															<div class="col-sm-2"></div>
															<div class="col-sm-3">
																<div class="col-sm-30 mb-1 mb-sm-3">
																	<label for="eqMakeID">Equipment Make ID</label>
																	<form:input class="form-control form-control-sm"
																		id="eqMakeID" path="eqMakeID" readonly="true" />

																</div>
															</div>
														</div>



														<div class="form-group row">
															<div class="col-sm-5">
																<div class="col-sm-60 mb-1 mb-sm-3">
																	<label for="">Equipment Make Logo</label> <input type="file"
																		class="file" accept="image/*" id="eqMakeLogo"
																		name="eqMakeLogo">
																	<!-- <form:errors path="eqMakeLogo" class="errortext"/>-->
																	<div class="input-group my-3">
																		<input type="text"
																			class="form-control form-control-sm"
																			disabled placeholder="Choose make logo" id="file">
																		<div class="input-group-append">
																			<button type="button" class="browse btn btn-primary btn-sm">Browse...</button>
																		</div>
																	</div>

																</div>
															</div>
															<div class="col-sm-5">
																<div class="ml-2 col-sm-6">

																	<c:if test="${equipmentMake.eqMakeLogo != null }">
																		<img src="data:image/jpg;base64,${vmLogo}"
																			id="preview" class="img-thumbnail">
																	</c:if>
																	<c:if test="${equipmentMake.eqMakeLogo == null }">
																		<img src="" id="preview" class="img-thumbnail">
																	</c:if>
																	
																</div>
															</div>


														</div>

														<div class="form-group row">
															<div class="col-sm-5">
																<div class="col-sm-60 mb-1 mb-sm-3">
																	<label for="remarks">Remarks</label>
																	<form:textarea path="remarks" id="remarks" class="form-control"/>
																</div>
															</div>
															<div class="col-sm-2"></div>
															<div class="col-sm-3"></div>

														</div>


														<div class="form-group row">
															<div class="col-sm-5">
																<div class="col-sm-60 mb-1 mb-sm-3">
																	<label>Status</label> <br>
																	<form:radiobutton path="status" value="Active"
																		checked="checked" />
																	ACTIVE
																	<form:radiobutton path="status" value="Inactive" />
																	INACTIVE
																	<form:errors path="status" class="bg-danger text-white" />
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
																			value="Add Equipment Make">
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

													<table id="eqMakeTable"
														class="table table-striped table-bordered table-sm table-wrapper-scroll-y my-custom-scrollbar"
														cellspacing="0" width="50%">
														<tr>
															<th>Equipment Make ID</th>
															<th>Equipment Make</th>
															<th>Equipment Make Logo</th>
															<th>Status</th>
															<th>Remarks</th>
														</tr>
														<c:forEach items="${allequipmentMake}"
															var="allequipmentMake">
															<tr>
																<td><div>${allequipmentMake.eqMakeID}</div></td>
																<td><div>${allequipmentMake.eqMake}</div></td>
																<td>
																	<div>
																		<c:if test="${allequipmentMake.eqMakeLogo != null}">
																			<img
																				src="data:image/jpg;base64,${allequipmentMake.eqMakeLogoView}"
																				width="90" height="80" alt="No image" />
																		</c:if>
																	</div>

																</td>
																<td><div>${allequipmentMake.status}</div></td>
																<td><div>${allequipmentMake.remarks}</div></td>
																<td><a
																	href="editEqMake?eqMakeID=${allequipmentMake.eqMakeID}"><i
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
			<%@include file="../WEB-INF/jsp/footer.jsp"%>			
		</div>
	</div>
<%@include file="../WEB-INF/jsp/commJs.jsp"%>

<script type="text/javascript">

		function Filevalidation() {
			const fi = document.getElementById('eqMakeLogo');
			const pro = document.getElementById('eqMake').value;
			const st = document.getElementById('eqMakeID').value;
			const iname = document.getElementById('remarks').value;

			// Check if any file is selected. 
			if (fi.files.length > 0) {
				for (const i = 0; i <= fi.files.length - 1; i++) {

					const fsize = fi.files.item(i).size;
					const file = Math.round((fsize / 1024));
					// The size of the file. 
					if (file >= 4096) {
						alert("File too Big, please select a file less than 4mb");
						return false;
					}
				}
			}
			if (iname == "" || pro == "" || st == "") {
			} else {
				if (fi.files.length == 0) {

					if (confirm("You not choose an Equipment Make Logo...!\n Are you sure to continue ? ")) {
					} else {
						return false;
					}

				}
			}
		}
	</script>



</body>
</html>
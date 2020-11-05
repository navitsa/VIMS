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
									<a href="#">Model</a>
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
													<form:form action="saveEquipmentmodel" method="post"
														modelAttribute="equipmentModel" name="equipmentModelform"
														id="equipmentModelform" enctype="multipart/form-data">



														<div class="form-group row">
															<div class="col-sm-5">
																<div class="col-sm-60 mb-1 mb-sm-3">
																	<label for="eqMakeID">Equipment Make <span class="required text-danger">*</span></label>
																	<form:select class="custom-select custom-select-mb"
																		id="eqMakeID" path="eqMakeID.eqMakeID"
																		required="true">
																		<form:option value=""> --SELECT--</form:option>
																		<c:forEach items="${eqMakeDetailsCmb}" var="profile">
																			<form:option value="${profile.eqMakeID}">${profile.eqMake}</form:option>
																		</c:forEach>

																	</form:select>
																</div>
															</div>
															<div class="col-sm-4"></div>
															<div class="col-sm">
																<div class="col-sm-30 mb-1 mb-sm-3">
																	<label>Model ID</label>

																	<form:input class="form-control form-control-sm"
																		path="eqModelID" readonly="true" />

																</div>
															</div>
														</div>

														<div class="form-group row">
															<div class="col-sm-5">
																<div class="col-sm-60 mb-1 mb-sm-3">
																	<label for="eqTypeID">Equipment Class <span class="required text-danger">*</span></label>
																	<form:select class="custom-select custom-select-mb"
																		id="eqTypeID" path="eqTypeID.eqTypeID"
																		required="true">
																		<form:option value=""> --SELECT--</form:option>
																		<c:forEach items="${types}" var="t">
																			<form:option value="${t.eqTypeID}">${t.eqType}</form:option>
																		</c:forEach>
																	</form:select>
																</div>
															</div>
														</div>
														
														<div class="form-group row">
															<div class="col-sm-5">
																<div class="col-sm-60 mb-1 mb-sm-3">
																	<label for="eqModel">Equipment Model <span class="required text-danger">*</span></label>
																	<form:input class="form-control form-control-mb" path="eqModel" id="eqModel" />
																	<form:errors path="eqModel" class="bg-danger text-white"/>
																</div>
															</div>
															<div class="col-sm-2"></div>
															<div class="col-sm-3"></div>

														</div>
														<div class="form-group row">
															<div class="col-sm-5">
																<div class="col-sm-60 mb-1 mb-sm-3">
																	<label for="calibrationInt">Calibration Interval</label><br>
																	<span class="badge badge-info">months</span>
																	<form:input type="number" min="0" class="form-control form-control-sm"
																		path="calibrationInt" id="calibrationInt" style="width:80px"/>
																	<form:errors path="calibrationInt" class="bg-danger text-white"/>
																</div>
															</div>
															<div class="col-sm-2"></div>
															<div class="col-sm-3"></div>

														</div>
														<div class="form-group row">
															<div class="col-sm-5">
																<div class="col-sm-60 mb-1 mb-sm-3">
																	<label for="serviceInt">Service Interval</label><br>
																	<span class="badge badge-info">months</span>
																	<form:input type="number" min="0" class="form-control form-control-sm" path="serviceInt"
																		id="serviceInt" style="width:80px"/>
																	<form:errors path="serviceInt" class="bg-danger text-white"/>
																</div>
															</div>
															<div class="col-sm-2"></div>
															<div class="col-sm-3"></div>

														</div>


														<div class="form-group row">
															<div class="col-sm-5">
																<div class="col-sm-60 mb-1 mb-sm-3">
																	<label>Equipment Model Logo</label> <input type="file"
																		class="file" accept="image/*" id="eqModelLogo"
																		name="eqModelLogo">
																	<div class="input-group my-3">
																		<input type="text"
																			class="form-control form-control-sm"
																			disabled placeholder="choose model logo" id="file">
																		<div class="input-group-append">
																			<button type="button" class="browse btn btn-primary btn-sm">Browse...</button>
																		</div>
																	</div>

																</div>
															</div>
															<div class="col-sm-5">
																<div class="ml-2 col-sm-6">

																	<c:if test="${equipmentModel.eqModelLogo != null}">
																		<img src="data:image/jpg;base64,${img}" id="preview"
																			class="img-thumbnail">
																	</c:if>
																	<c:if test="${equipmentModel.eqModelLogo == null}">
																		<img src="" id="preview" class="img-thumbnail">
																	</c:if>
																</div>
															</div>
														</div>
														<div class="form-group row">
															<div class="col-sm-5">
																<div class="col-sm-60 mb-1 mb-sm-3">
																	<label>Equipment Model Manual</label>
																	<span class="badge badge-info">maximum file size 2mb</span>
																	<input type="file" class="file2" accept="application/pdf" id="eqModelMa"
																		name="eqModelMa">
																	<div class="input-group">
																		<input type="text"
																			class="form-control form-control-sm"
																			disabled placeholder="choose pdf file" id="file2">
																		<div class="input-group-append">
																			<button type="button" class="browse2 btn btn-primary btn-sm">Browse...</button>
																		</div>
																	</div>
																	
																</div>
															</div>
															<div class="col-sm-5">
																<div class="ml-2 col-sm-6">

																	<%-- <c:if test="${equipmentModel.eqModelMa != null}">
																		<img src="data:image/jpg;base64,${img}" id="preview2"
																			class="img-thumbnail">
																	</c:if> --%>
																	
																	<!-- <img src="" id="preview2" class="img-thumbnail"
																		width="200" height="300"> -->
																</div>
															</div>

														</div>
														<div class="form-group row">
															<div class="col-sm-5">
																<div class="col-sm-60 mb-1 mb-sm-3">
																	<label for="remarks">Remarks</label>
																	<form:textarea path="remarks" id="remarks" class="form-control" value="${equipmentMake.remarks}"/>

																</div>
															</div>
															<div class="col-sm-2"></div>
															<div class="col-sm-3"></div>

														</div>

														<div class="form-group row">
															<div class="col-sm-5">
																<div class="col-sm-60 mb-1 mb-sm-3">
																	<label>Status</label> <br>
																	<form:radiobutton path="status" value="ACTIVE"
																		checked="checked" />
																	ACTIVE
																	<form:radiobutton path="status" value="INACTIVE" />
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
																			value="Add Model">
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



													<!-- 	<div class="table-wrapper-scroll-y my-custom-scrollbar">-->


													<table id="eqModelTable"
														class="table table-striped table-bordered table-sm table-wrapper-scroll-y my-custom-scrollbar"
														cellspacing="0" width="50%">

														<thead>
															<tr>
																<th class="th-sm">Model ID</th>
																<th class="th-sm">Make</th>
																<th class="th-sm">Type</th>
																<th class="th-sm">Model</th>
																<th class="th-sm">Calibration Interval</th>
																<th class="th-sm">Service Interval</th>
																<th class="th-sm">Logo</th>
																<th class="th-sm">Status</th>
																<th class="th-sm">Remarks</th>
															</tr>
														</thead>
														<tbody>
															<c:forEach items="${listEquipmentModel}"
																var="allequipmentModel">
																<tr>
																	<td><div>${allequipmentModel.eqModelID}</div></td>

																	<td><c:if
																			test="${allequipmentModel.eqMakeID.eqMake != null}">
																			<div>${allequipmentModel.eqMakeID.eqMake}</div>
																		</c:if></td>
																	<td><c:if test="${allequipmentModel.eqTypeID.eqType != null}">
																		<div>${allequipmentModel.eqTypeID.eqType}</div>
																	</c:if></td>
																	<td><div>${allequipmentModel.eqModel}</div></td>
																	<td><div>${allequipmentModel.calibrationInt}</div></td>
																	<td><div>${allequipmentModel.serviceInt}</div></td>
																	<td><div>
																			<c:if test="${allequipmentModel.eqModelLogo != null}">
																				<img
																					src="data:image/jpg;base64,${allequipmentModel.eqModelLogoView}"
																					width="90" height="80" alt="No image" />
																			</c:if>
																		</div></td>
																	<td><div>${allequipmentModel.status}</div></td>
																	<td><div>${allequipmentModel.remarks}</div></td>
																	<td><a
																		href="editEqModel?id=${allequipmentModel.eqModelID}"><i
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

	<script type="text/javascript">
		//eq model manual
		$(document).on("click", ".browse2", function() {
			var file2 = $(this).parents().find(".file2");
			file2.trigger("click");
		});
		$('#eqModelMa').change(function(e) {
			var fileName2 = e.target.files[0].name;
			$("#file2").val(fileName2);

			var reader2 = new FileReader();
			reader2.onload = function(e) {
				// get loaded data and render thumbnail.
				document.getElementById("preview2").src = e.target.result;
			};
			// read the image file as a data URL.
			reader2.readAsDataURL(this.files[0]);
		})
		</script>

	<script type="text/javascript">
		//eq model logo
		$(document).on("click", ".browse", function() {
			var file = $(this).parents().find(".file");
			file.trigger("click");
		});
		$('#eqModelLogo').change(function(e) {
			var fileName = e.target.files[0].name;
			$("#file").val(fileName);

			var reader = new FileReader();
			reader.onload = function(e) {
				// get loaded data and render thumbnail.
				document.getElementById("preview").src = e.target.result;
			};
			// read the image file as a data URL.
			reader.readAsDataURL(this.files[0]);
		})

/* 		function Filevalidation() {
			const fi = document.getElementById('eqModelLogo');
			const pro = document.getElementById('eqModel').value;
			const st = document.getElementById('remarks').value;

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
			if (pro == "" || st == "") {
			} else {
				if (fi.files.length == 0) {

					if (confirm("You not choose an Equipment Model Logo...!\n Are you sure to continue ? ")) {
					} else {
						return false;
					}

				}
			}
		} */
	</script>

</body>
</html>
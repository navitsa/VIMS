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
									<a href="#">Equipment Allocation</a>
								</li>
							</ul>
						</div>
				
						<div
								class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
								<div class="col-xl-12 col-md-12 mb-12 ">
									<div class="card border-left-primary shadow h-100 py-2">
										<div class="card-body">		
					
											<div class="row">
						<div class="col-xl-6 col-md-6 mb-4">
			              <div class="card shadow mb-4 border-left-primary">
			                <div class="card-body">
			                
								<c:if test="${success ==1}">
									<div class="alert alert-success alert-dismissible">
										<button type="button" class="close" data-dismiss="alert">&times;</button>
										<strong>Success!</strong> Data Successfully Saved.
									</div>
								</c:if>
								<c:if test="${success ==0}">
									<div class="alert alert-danger alert-dismissible">
										<button type="button" class="close" data-dismiss="alert">&times;</button>
										<strong>Warning!</strong>Something went wrong ! Please try again!
									</div>
								</c:if>	

								<form:form action="saveEquipmentMaster" method="post"
									modelAttribute="equipmentMaster" enctype="multipart/form-data" id="formEquipmentMaster">
									
									<form:input path="equipmentID" type="hidden"/>
			                		<div class="form-group row">
										<div class="col-lg-6">
												<label for="center">Center <span class="required text-danger">*</span></label>
												<form:select class="custom-select custom-select-sm"
													path="invLoID.invLoID" id="center" required="true">
													<form:option value="0"> --SELECT--</form:option>
													<c:forEach items="${allInventoryLocation}" var="invlo">
														<form:option value="${invlo.invLoID}">${invlo.invLocationcol}</form:option>
													</c:forEach>
												</form:select>
										</div>
									</div>
			                		<div class="form-group row">
										<div class="col-lg-6">
												<label for="eqMakeID">Equipment Make <span class="required text-danger">*</span></label>
												<form:select class="custom-select custom-select-sm"
													id="eqMakeID" path="eqModelID.eqMakeID.eqMakeID"
													required="true"
													onchange="getModel(this.value); getMakeLogo(this.value)">
													<form:option value=""> --SELECT--</form:option>
													<c:forEach items="${eqMakeDetailsCmb}" var="eqmake">
														<form:option value="${eqmake.eqMakeID}">${eqmake.eqMake}</form:option>
													</c:forEach>
												</form:select>
										</div>
										<div class="col-lg">
												<c:if test="${equipmentMaster.eqModelID.eqMakeID.eqMakeLogo != null}">
													<img src="data:image/jpg;base64,${makeLogo}" id="makeImg"
														class="img-thumbnail" width="80" height="80">
												</c:if>
												<c:if test="${equipmentMaster.eqModelID.eqMakeID.eqMakeLogo == null}">
													<img src="" id="makeImg" class="img-thumbnail" width="80" height="90">
												</c:if>

										</div>
									</div>
			                		<div class="form-group row">
										<div class="col-lg-6">
												<label for="eqTypeID">Equipment Class <span class="required text-danger">*</span></label>
												<form:select class="custom-select custom-select-sm"
													id="eqTypeID" path="eqModelID.eqTypeID.eqTypeID"
													onchange="getClass();" required="true">
													<form:option value=""> --SELECT--</form:option>
													<c:forEach items="${eqTypeDetailsCmb}" var="t">
														<form:option value="${t.eqTypeID}">${t.eqType}</form:option>
													</c:forEach>
												</form:select>
										</div>
									</div>
									<div class="form-group row">
										<div class="col-lg-6">
												<label for="eqModelID">Equipment Model <span class="required text-danger">*</span></label>
												<form:select class="custom-select custom-select-sm"
													id="eqModelID" path="eqModelID.eqModelID"
													onchange="getEqModelLogo(this.value);" required="true">
													<form:option value=""> --SELECT--</form:option>
													<c:forEach items="${eqModleDetailsCmb}" var="eqmake">
														<form:option value="${eqmake.eqModelID}">${eqmake.eqModel}</form:option>
													</c:forEach>
												</form:select>
										</div>
										<div class="col-lg">
												<c:if test="${equipmentMaster.eqModelID.eqModelLogo!=null}">
													<img src="data:image/jpg;base64,${eqmodelLogo}" id="mydemo"
														class="img-thumbnail" width="80" height="80">
												</c:if>
												<c:if test="${equipmentMaster.eqModelID.eqModelLogo==null}">
													<img src="" id="mydemo" class="img-thumbnail" width="80" height="80">
												</c:if>
										</div>
									</div>
									<div class="form-group row">
										<div class="col-lg-6">
												<label for="serialNo">Serial Number <span class="required text-danger">*</span></label>
												<form:input class="form-control form-control-sm"
													path="serialNo" id="serialNo" />
												<form:errors path="serialNo" class="bg-danger text-white" />
										</div>
									</div>
									<div class="form-group row">
										<div class="col-lg-6">
												<label for="installDate">Installation Date <span class="required text-danger">*</span></label>
												<form:input type="date" class="form-control form-control-sm" path="installDate"/>
												<form:errors path="installDate" class="bg-danger text-white" />
										</div>
										<div class="col-lg-6">
												<label for="commDate">Commissioning Date <span class="required text-danger">*</span></label>
												<form:input type="date" class="form-control form-control-sm" path="commDate" />
												<form:errors path="commDate" class="bg-danger text-white" />
										</div>
									</div>
									<div class="form-group row">
										<div class="col-lg-6">
												<label for="trainDate">Training Date <span class="required text-danger">*</span></label>
												<form:input type="date" class="form-control form-control-sm" path="trainDate" />
												<form:errors path="trainDate" class="bg-danger text-white" />
											</div>
									</div>
									<div class="form-group row">
										<div class="col-lg">
												<label for="lastCalDate" class="form-control-sm">Last Calibration Date <span class="required text-danger">*</span></label>
												<form:input type="date" class="form-control form-control-sm" 
													path="lastCalibrationDate" id="lastCalDate" onchange="setDate()"/>
												<form:errors path="lastCalibrationDate" class="bg-danger text-white" />
												<br>
												<label class="form-control-sm text-primary">Next Calibration Date</label>
												<form:input class="form-control form-control-sm text-primary"  path="nextCalibrationDate" id="nextCalDate"/>
										</div>
										<div class="col-lg">

												<label class="form-control-sm">Last Calibration Report</label> 
												<input type="file" class="file4" accept="application/pdf"
													id="lastCalibrationReport" name="lastCalibrationReport">
												<div class="input-group">
													<input type="text" class="form-control form-control-sm"
														disabled placeholder="choose.." id="file4">
													<div class="input-group-append">
														<button type="button" id="calBtn"
															class="browse4 btn btn-primary btn-sm">Browse...</button>
													</div>
												</div>

										</div>
										<div class="col-lg">

												<label class="form-control-sm">Last Calibration Certificate</label>
												<input type="file" class="file2" accept="application/pdf"
													id="lastCalibrationCer" name="lastCalibrationCer">
												<div class="input-group">
													<input type="text" class="form-control form-control-sm"
														disabled placeholder="choose.." id="file2">
													<div class="input-group-append">
														<button type="button"
															class="browse2 btn btn-primary btn-sm">Browse...</button>
													</div>
												</div>

										</div>
									</div>
									<div class="form-group row">
										<div class="col-lg">

												<label for="lastServiceDate" class="form-control-sm">Last Service Date <span class="required text-danger">*</span></label>
												<form:input type="date" class="form-control form-control-sm"
													onchange="setSerDate()" path="lastServiceDate"
													id="lastServiceDate" />
												<form:errors path="lastServiceDate" class="bg-danger text-white" />
												<br>
												<label class="form-control-sm text-primary">Next Service Date</label>
												<form:input class="form-control form-control-sm text-primary" path="nextServiceDate" id="nextServiceDate"/>

										</div>
										<div class="col-lg">
												<label class="form-control-sm">Last Service Report</label>
												<input type="file" class="file5" accept="application/pdf"
													id="lastServiceReport" name="lastServiceReport">
												<div class="input-group">
													<input type="text" class="form-control form-control-sm"
														disabled placeholder="choose.." id="file5">
													<div class="input-group-append">
														<button type="button" id="eqSerBtn"
															class="browse5 btn btn-primary btn-sm">Browse...</button>
													</div>
												</div>
										</div>
										<div class="col-lg">
												<label class="form-control-sm">Last Service Certificate</label>
												<input type="file" class="file3" accept="application/pdf"
													id="lastServiceCer" name="lastServiceCer">
												<div class="input-group">
													<input type="text" class="form-control form-control-sm"
														disabled placeholder="choose.." id="file3">
													<div class="input-group-append">
														<button type="button"
															class="browse3 btn btn-primary btn-sm">Browse...</button>
													</div>
												</div>
										</div>
									</div>
									<div class="form-group row">
										<div class="col-lg-6">
												<label class="form-control-sm">Equipment Image</label> 
												<input type="file" class="file" accept="image/*" id="equipmentImage"
													name="equipmentImage">
												<div class="input-group">
													<input type="text" class="form-control form-control-sm"
														disabled placeholder="choose image file" id="file">
													<div class="input-group-append">
														<button type="button"
															class="browse btn btn-primary btn-sm">Browse...</button>
													</div>
												</div>
										</div>
										<div class="col-lg">
												<c:if test="${equipmentMaster.equipmentImage != null }">
													<img src="data:image/jpg;base64,${eqLogo}" id="preview"
														class="img-thumbnail">
												</c:if>
												<img src="" id="preview" class="img-thumbnail">

										</div>
									</div>
									<div class="form-group row">
										<div class="col-lg">
											<form:textarea path="remarks" id="remarks" class="form-control" placeholder="Remarks"/>
										</div>
									</div>
									<div class="form-group row">
										<div class="col-lg">
												<label>Status</label> <br>
												<form:radiobutton path="status" value="ACTIVE"
													checked="checked" />
												Active
												<form:radiobutton path="status" value="INACTIVE" />
												Inactive
										</div>
									</div>
									<input type="submit" class="btn btn-success" value="Add Equipment">
									<input type="button" class="btn btn-warning" onclick="clear1()" value="Clear">

								</form:form>
							</div>
			              </div>
						</div>

						<div class="col-xl-6 col-md-6 mb-4">
			              <div class="card shadow mb-4 border-left-primary">
			                <div class="card-body">

										<table class="display" id="example" style="width:100%">
											<thead>
												<tr>
													<th>Equipment Model</th>
													<th>Serial No</th>
													<th>Calibration Report</th>
													<th>Service Report</th>
													<th>Calibration Certificate</th>
													<th>Service Certificate</th>
													<th>Equipment Image</th>
													<th>Status</th>
													<th>Remarks</th>
													<th></th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${listEquipmentMaster}" var="listEquipmentMaster">
													<tr>
														<td>${listEquipmentMaster.eqModelID.eqModel}</td>
														<td>${listEquipmentMaster.serialNo}</td>
														<td><div>
																<c:if
																	test="${listEquipmentMaster.lastCalibrationReport !=null}">
																	<a
																		href="eqCReport?equipmentID=${listEquipmentMaster.equipmentID}"><i
																		class="fa fa-file-pdf"
																		style="font-size: 48px; color: red" aria-hidden="true"></i></a>
																</c:if>
															</div>
														</td>
														<td><div>
																<c:if
																	test="${listEquipmentMaster.lastServiceReport !=null}">
																	<a
																		href="eqSReport?equipmentID=${listEquipmentMaster.equipmentID}"><i
																		class="fa fa-file-pdf"
																		style="font-size: 48px; color: red" aria-hidden="true"></i></a>
																</c:if>
															</div>
														</td>
														<td><div>
																<c:if
																	test="${listEquipmentMaster.lastCalibrationCer !=null}">
																	<a
																		href="eqCalibrationCertificateView?equipmentID=${listEquipmentMaster.equipmentID}"><i
																		class="fa fa-file-pdf"
																		style="font-size: 48px; color: red" aria-hidden="true"></i></a>
																</c:if>
															</div>
														</td>
														<td><div>
																<c:if test="${listEquipmentMaster.lastServiceCer !=null}">
																	<a
																		href="eqServiceCertificateView?equipmentID=${listEquipmentMaster.equipmentID}"><i
																		class="fa fa-file-pdf"
																		style="font-size: 48px; color: red" aria-hidden="true"></i></a>
																</c:if>
															</div>
														</td>
														<td><div>
																<c:if test="${listEquipmentMaster.equipmentImage !=null}">
																	<img
																		src="data:image/jpg;base64,${listEquipmentMaster.equipmentImageView}"
																		width="90" height="80" alt="No image" />
																</c:if>
															</div>
														</td>
														<td>${listEquipmentMaster.status}</td>
														<td>${listEquipmentMaster.remarks}</td>
														<td><a
															href="editEqMaster?equipmentID=${listEquipmentMaster.equipmentID}"><i
																class="material-icons">&#xE254;</i></a>
														</td>
													</tr>
												</c:forEach>
											</tbody>

										</table>

								</div>
			               </div>
						</div>
					</div>	
	
				</div></div></div></div>
				
				
				
				
					</div>
				
			</div>	
			<%@include file="../WEB-INF/jsp/footer.jsp"%>			
		</div>
	</div>
<%@include file="../WEB-INF/jsp/commJs.jsp"%>


<script src="resources/ajax/equipment-master.js"></script>



	<script>
	$(document).ready(function() {
	    $('#example').DataTable( {
	    	"scrollY": "400px",
	    	"processing": true,
	        "columnDefs": [{ "orderable": false, "targets": 4 }]
	    } );
	} );
	</script>
	
	<script type="text/javascript">
		//last calibration certificate
		$(document).on("click", ".browse2", function() {
			var file2 = $(this).parents().find(".file2");
			file2.trigger("click");
		});
		$('#lastCalibrationCer').change(function(e) {
			var fileName2 = e.target.files[0].name;
			$("#file2").val(fileName2);

			// 			 var reader2 = new FileReader();
			// 			reader2.onload = function(e) {
			// 				// get loaded data and render thumbnail.
			// 				document.getElementById("preview2").src = e.target.result;
			// 			}; 
			// 			// read the image file as a data URL.
			// 			reader2.readAsDataURL(this.files[0]); 
		})
	</script>

	<script type="text/javascript">
		//last service certificate
		$(document).on("click", ".browse3", function() {
			var file3 = $(this).parents().find(".file3");
			file3.trigger("click");
		});
		$('#lastServiceCer').change(function(e) {
			var fileName3 = e.target.files[0].name;
			$("#file3").val(fileName3);

			// 			 var reader3 = new FileReader();
			// 			reader3.onload = function(e) {
			// 				// get loaded data and render thumbnail.
			// 				document.getElementById("preview3").src = e.target.result;
			// 			}; 
			// 			// read the image file as a data URL.
			// 			reader3.readAsDataURL(this.files[0]); 
		})
	</script>
	
	<script type="text/javascript">
		//last calibration report
		$(document).on("click", ".browse4", function() {
			var file4 = $(this).parents().find(".file4");
			file4.trigger("click");
		});
		$('#lastCalibrationReport').change(function(e) {
			var fileName4 = e.target.files[0].name;
			$("#file4").val(fileName4);

			/*  var reader4 = new FileReader();
			reader4.onload = function(e) {
				// get loaded data and render thumbnail.
				document.getElementById("preview4").src = e.target.result;
			}; 
			// read the image file as a data URL.
			reader4.readAsDataURL(this.files[0]);  */
		})
	</script>

	<script type="text/javascript">
		//last service report
		$(document).on("click", ".browse5", function() {
			var file5 = $(this).parents().find(".file5");
			file5.trigger("click");
		});
		$('#lastServiceReport').change(function(e) {
			var fileName5 = e.target.files[0].name;
			$("#file5").val(fileName5);

			/*  var reader5 = new FileReader();
			reader5.onload = function(e) {
				// get loaded data and render thumbnail.
				document.getElementById("preview5").src = e.target.result;
			}; 
			// read the image file as a data URL.
			reader5.readAsDataURL(this.files[0]);  */
		})
	</script>

	<script type="text/javascript">
		//equipment Img
		$(document).on("click", ".browse", function() {
			var file = $(this).parents().find(".file");
			file.trigger("click");
		});
		$('#equipmentImage').change(function(e) {
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
	</script>

</body>
</html>
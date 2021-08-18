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
						<h4 class="page-title">Vehicle Information</h4>
						<ul class="breadcrumbs">
							<li class="nav-home"><a href="#"> <i
									class="flaticon-home"></i>
							</a></li>
							<li class="separator"><i class="flaticon-right-arrow"></i></li>
							<li class="nav-item"><a href="#">Model</a></li>

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
													<strong>Warning!</strong>Something went wrong ! Please try
													again!
												</div>
											</c:if>
											<form:form action="savevmodel" method="post"
												modelAttribute="vehicleModelForm"
												enctype="multipart/form-data" id="modelForm">

												<div class="form-group row">
													<div class="col-lg-4">
														<label for="vehicleMakeID">Vehicle Make</label>

														<form:select class="custom-select" id="vehicleMakeID"
															path="vehicleMakeID.vehicleMakeID"
															onchange="getMakeLogo(this.value)" required="true">
															<form:option value="">Select Vehicle Make</form:option>
															<c:forEach items="${vmake}" var="vmak">
																<form:option value="${vmak.vehicleMakeID}">${vmak.vehicleMake}</form:option>
															</c:forEach>
														</form:select>
													</div>
													<div class="col-lg-4">
														<div id="demo"></div>
														<c:if
															test="${vehicleModelForm.vehicleMakeID.makeLogo != null}">
															<img src="data:image/jpg;base64,${vMakeLogo}"
																class="img-thumbnail" width="80" height="80">
														</c:if>
														<img src="" id="mydemo" class="img-thumbnail">
													</div>
													<div class="col-lg-4">
														<label for="vehicleModelID">Vehicle Model ID</label>
														<form:input class="form-control form-control-sm"
															path="vehicleModelID" readonly="true" style="width:80px" />
													</div>
												</div>
												<div class="form-group row">
													<div class="col-lg-4">

														<label for="vehicleClassID">Vehicle Class</label>

														<form:select class="custom-select" id="vehicleClassID"
															path="vehicleClass.vehicleClassID" required="true"
															onchange="getModelData();">
															<form:option value="">Select Vehicle Class</form:option>
															<c:forEach items="${vclass}" var="cl">
																<c:if test="${cl.status=='Active'}">
																	<form:option value="${cl.vehicleClassID}">${cl.vehicleClass}</form:option>
																</c:if>
															</c:forEach>
														</form:select>
													</div>
												</div>

												<div class="form-group row">
													<div class="col-lg-6">
														<label for="vehicleModel">Vehicle Model </label>
														<form:input class="form-control form-control-user"
															id="vehicleModel" path="vehicleModel"
															onkeyup="checkModel(this.value);" />
													</div>
												</div>

												<div class="row">

													<div class="col-sm-5">
														<div class="col-sm-60 mb-1 mb-sm-3">
															<label>Model Image</label>
															<form:input type="file" class="file" id="modelLogo"
																path="modelLogo" />
															<div class="input-group">
																<input type="text" class="form-control" disabled
																	placeholder="choose image..." id="file">
																<div class="input-group-append">
																	<button type="button" class="browse btn btn-primary">Browse</button>
																</div>
															</div>

														</div>
													</div>
`														
													<%-- <div class="col-sm-5">
														<div class="ml-2 col-sm-6">

															<c:if test="${vehicleModelForm.modelLogo != null}">
																<img src="data:image/jpg;base64,${vMLogo}" id="preview"
																	class="img-thumbnail">
															</c:if>
															<c:if test="${vehicleModelForm.modelLogo == null}">
																<img src="" id="preview" class="img-thumbnail">
															</c:if>
														</div>
													</div> --%>

												</div>

												<div class="col-sm-6 mb-1 mb-sm-3">
													<label>Status</label> <br>
													<form:radiobutton path="status" value="ACTIVE"
														checked="checked" />
													ACTIVE
													<form:radiobutton path="status" value="INACTIVE" />
													INACTIVE
												</div>

												<div class="row">
													<div class="col-sm-2 mb-1 mb-sm-3">
														<input type="submit" id="sub" class="btn btn-success"
															value="Add Model" />
													</div>
													<div class="col-sm-6 mb-1 mb-sm-3">
														<input type="button" class="btn btn-warning"
															onclick="clear1()" value="Clear">
													</div>
												</div>
												<br>
												<br>

											</form:form>
										</div>

										<div class="col-12 scrollable">
											<table id="basic-datatables"
												class="display table table-striped table-hover table-bordered"
												width="100%">
												<thead>
													<tr>
														<th>Model ID</th>
														<th>Vehicle Make</th>
														<th>Vehicle Class</th>
														<th>Vehicle Model</th>
														<th>Model Logo</th>
														<th>Status</th>
														<th></th>
													</tr>
												</thead>
												<tbody>
													<c:forEach var="vm" items="${vModelList}">
														<tr>
															<td>${vm.vehicleModelID}</td>
															<td>${vm.vehicleMakeID.vehicleMake}</td>
															<td>${vm.vehicleClass.vehicleClass}</td>
															<td>${vm.vehicleModel}</td>
															<td><c:if test="${vm.modelLogo != null}">
																	<img src="data:image/jpg;base64,${vm.modelLogoView}"
																		width="90" height="80" alt="No image" />
																</c:if></td>
															<td>${vm.status}</td>
															<td><a
																href="updateVehicleModel?id=${vm.vehicleModelID}"><i
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

	<!-- Datatable -->
	<script src="<c:url value='/resources/ajax/datatable.js'/>"></script>

	<script type="text/javascript">
		//document.getElementById("sub").style.display = "none";

		//clear form after/before submiting 
		function clear1() {
			/*Put all the data posting code here*/
			document.getElementById("vehicleMakeID").value = "";
			document.getElementById("vehicleModel").value = "";
			//document.getElementById("vModelLogo").value = "";
			document.getElementById("vehicleClassID").value = "";
		}

		function getMakeLogo(str) {
			if (str == "") {
				return;
			} else {
				$.ajax({

					type : 'GET',
					url : "getImageForCombo",
					data : {
						"vmake" : str
					},
					success : function(data) {

						//delete previous selected value
						var img = $('#mydemo'), value = "";
						img.empty();

						//var x = document.createElement("IMG");
						var x = document.getElementById("mydemo");
						x.setAttribute("src", "data:image/jpg;base64," + data
								+ "");
						x.setAttribute("width", "80");
						x.setAttribute("height", "80");
						x.setAttribute("alt", "Make Image");
						// document.body.appendChild(x);
						document.getElementById("mydemo").appendChild(x);

					},
					error : function() {
						//alert("Error");
					}

				});
			}
		}
		function checkModel(sta) {
			//document.getElementById("sub").style.display = "none";
			var mak = document.getElementById("vehicleMakeID").value;
			var cls = document.getElementById("vehicleClassID").value;
			if (sta != "") {
				$.ajax({
					type : 'GET',
					url : "getCheckModelValue",
					data : {
						"make" : mak,
						"clas" : cls,
						"modelname" : sta
					},
					success : function(model) {

						if (model == "0") {

							document.getElementById("vehicleModel").value = "";
							//	document.getElementById("sub").style.display = "none";
							//alert("Model is found");	

							Swal.fire({
								icon : 'error',
								title : 'Oops...',
								text : 'Model is already found'
							//,footer: '<a href>Why do I have this issue?</a>'
							});

						} else {
							// document.getElementById("sub").style.display = "block";
						}

					}

				});
			} else {
				//document.getElementById("sub").style.display = "none";
			}
		}

		function arrayBufferToBase64(buffer) {
			var binary = '';
			var bytes = new Uint8Array(buffer);
			var len = bytes.byteLength;
			for (var i = 0; i < len; i++) {
				binary += String.fromCharCode(bytes[i]);
			}
			return window.btoa(binary);
		}

		function getModelData() {

			var mak = document.getElementById("vehicleMakeID").value;
			var cls = document.getElementById("vehicleClassID").value;

			$("table tbody").empty();

			$
					.ajax({
						type : 'GET',
						url : "getvehicleModelSelect",
						data : {
							"make" : mak,
							"clas" : cls
						},
						success : function(model) {

							$("table tbody").empty();
							for (var i = 0; i < model.length; i++) {

								var result = "<tr><td>"
										+ model[i].vehicleModelID
										+ "</td><td>"
										+ model[i].vehicleModel
										+ "</td><td>"
										+ "<img src='data:image/jpg;base64,"
										+ arrayBufferToBase64(model[i].modelLogo)
										+ "' width='90' height='80'/>"
										// 									+"</td><td>"
										// 									+model[i].vehicleMakeID.vehicleMake
										// 									+"</td><td>"
										// 									+"<img src='data:image/jpg;base64,"+model[i].vehicleMakeID.vMakeLogoView+"' width='90' height='80' alt='No image' />"	

										// 									+"</td><td>"
										// 									+model[i].vehicleClass.vehicleClass
										+ "</td><td>"
										+ model[i].status
										+ "</td><td><a href=updateVinfo?vehicleModelID="
										+ model[i].vehicleModelID
										+ "><i class='fas fa-pen'></i></a>"
										+ "</td></tr>";

								$("table tbody").append(result);
							}
						},
						error : function() {
							alert("Model information not found !");
						}

					});

		}
	</script>



</body>
</html>
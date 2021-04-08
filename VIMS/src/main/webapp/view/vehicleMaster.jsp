<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ page isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>



<html lang="en">
<head>
<%@include file="../WEB-INF/jsp/head.jsp"%>

<style>
.vidSty {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 30px;
	font-weight: bold;
	color: #02d41b;
}

.error1 {
	color: red;
	font-size: 12px
}

form input[type="file"] {
	display: none;
}

.numberfield {
	width: 80px;
}

.labelcol {
	color: black;
}

.capCam {
	height: 110px;
	width: 200px;
}

.textred {
	font-family: Arial, Helvetica, sans-serif;
	/*         border: 1px solid #b30000; */
	font-size: 20px;
	text-align: center;
	color: #b30000;
	pointer-events: none;
}

.iconstyle {
	width: 7%;
	color: blue';
}

.videnty {
	width: 8%;
}

.fontst {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 13px;
	height: 30px;
	color: #031f3f;
}

.l-fontst {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 13px;
	height: 10px;
	margin-top: 5px;
	color: #040100;
}

pos {
	position: absolute;
	align-content: center;
}

.bt-sty {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
}

.fontst {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
}

.fontcol-peo {
	color: #ff8000;
}

.imgalign {
	position: absolute;
	bottom: 1px;
	left: 0px;
	/*   			height: 130px; */
	/*   			width: 220px; */
}

.lacol {
	color: #000099;
}

.datesty {
	width: 60px;
}

.stytex {
	width: 100px;
}

.engSty {
	width: 100%;
}

.iconali {
	position: absolute;
	top: 6px;
	right: -7px;
}

.manuSty {
	width: 120px;
}

.l-chno {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 15px;
	color: black;
}

.v-chno {
	border: 1px solid #1000c4;
	font-family: "Lucida Console", Monaco, monospace;
	font-size: 15px;
	color: black;
	padding-left: 6.5px;
	letter-spacing: 13px;
	/* 	        background-image: url("http://3.bp.blogspot.com/-4oAWWCcNNz4/Tjr3nKNyVUI/AAAAAAAAPLU/Pouua-pNsEY/s1600/sq.gif");     */
	background-size: 28px;
	padding-left: 6.5px;
	letter-spacing: 18px;
	width: 500px;
	height: 30px;
}
</style>


<link href="resources/assets/css/scrollbar.css" rel="stylesheet">
</head>
<body onload="getClassImage();getMakeLogo();getModelImage();">

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
				<div class="panel-header bg-primary-gradient">
					<div class="page-inner py-3">
						<div
							class="d-flex align-items-left align-items-md-center flex-column flex-md-row">
							<div class="col-xl-2 col-lg-2">
								<img src="data:image/jpg;base64,${imgVe}" class="capCam"
									id="results"
									onerror="this.onerror=null; this.src='resources/img/car-placeholder.jpg'"
									style="border-radius: 8px; border: 1px solid #ddd;" /> <br>
								<br>
							</div>
							<div class="col-xl-2 col-lg-2">
								<p class="vidSty">${vidn}</p>
							</div>
							<div class="ml-md-auto py-2 py-md-4">


								<h2 class="text-white pb-2 fw-bold">Vehicle Details</h2>

							</div>


							<div class="ml-md-auto py-2 py-md-4">
								<a href="vehicleInformation"
									class="btn btn-white btn-border btn-round mr-2">Gate Entry</a>
								<!-- 								<a href="vehicleInformation" class="btn btn-white btn-border btn-round mr-2">Vehicle Details</a> -->
								<button class="btn btn-white btn-border btn-round mr-2"
									data-toggle="modal" data-target="#checkDocumentModal"
									onclick="getDocumentCheck()">Document Check</button>

								<!-- <a  class="btn btn-secondary btn-round" data-toggle="modal" data-target="#checkDocumentModal">Document Check</a> -->
							</div>
						</div>
					</div>
				</div>


				<div class="page-inner mt--5">
					<!-- 					<div class="page-header"> -->
					<!-- 							<h4 class="page-title">Vehicle Details</h4> -->
					<!-- 							<ul class="breadcrumbs"> -->
					<!-- 								<li class="nav-home"> -->
					<!-- 									<a href="#"> -->
					<!-- 										<i class="flaticon-home"></i> -->
					<!-- 									</a> -->
					<!-- 								</li> -->
					<!-- 								<li class="separator"> -->
					<!-- 									<i class="flaticon-right-arrow"></i> -->
					<!-- 								</li> -->
					<!-- 								<li class="nav-item"> -->
					<!-- 									<a href="vehicleInformation">Gate Entry</a> -->
					<!-- 								</li> -->

					<!-- 							</ul> -->
					<!-- 						</div> -->




					<!-- Content Row -->
					<form:form action="saveVMasterk" method="post"
						modelAttribute="saveVMaster" enctype="multipart/form-data"
						id="form1">
						<div class="row">

							<!-- Area Chart -->
							<div class="col-xl-8 col-lg-6">
								<div class="card shadow mb-4">
									<!-- Card Header - Dropdown -->
									<div
										class="card-header py-1 d-flex flex-row align-items-center">
										<div class="col-sm-1">
											<i class="fa fa-car" style='font-size: 28px; color: blue'></i>
										</div>
										<div class="col-sm-4">
											<h6 class="m-0 font-weight-bold text-primary">. Vehicle
												Details</h6>
										</div>
										<div class="col-sm-7">
											<form:input class="form-control textred" path="vehicleID"
												id="vehicleID" placeholder="Licence Plate NO..."
												onkeyup="this.value = this.value.toUpperCase();"
												readonly="true" type="hidden" />
										</div>
									</div>


									<!-- Card Body -->
									<div class="card-body">
										<input type="hidden"
											value='<%=session.getAttribute("vehicleAutoConfig")%>'
											id="autoValue">
										<div class="row">
											<div class="col-sm-9">


												<input class="form-control textred" id="ocid" name="ocid"
													value="${ocid}" type="hidden" /> <label for="chassisNo"
													class="l-chno">VIN(Chassis Number)</label>
												<form:input class="form-control v-chno" path="chassisNo"
													onkeyup="this.value = this.value.toUpperCase();getChassisNumberDetails();checkVinNo();"
													onchange="getChassisNumberDetails();checkVinNo();"
													id="chassisNoid3" maxlength="17" required="true" />
												<form:errors path="chassisNo" cssClass="error1" />




											</div>
											<div class="col-sm-3">

												<label class="l-fontst">Mileage</label> <input
													class="form-control fontst" name="currentMilage"
													required="Required" value="${milage}" id="currentMilage"
													required="true" />
												<!-- 										<i class='fas fa-tachometer-alt iconali'></i>	 -->




											</div>

										</div>
										<hr>
										<!-- 		 </div> -->


										<!-- 	<div class="card-header py-1 d-flex flex-row align-items-center"> -->
										<!-- 		<img src="resources/img/icon/vehicleidentification.png" class="videnty"/><h6 class="m-0 font-weight-bold text-primary">.  Vehicle Identification</h6> -->

										<!-- 	</div> -->
										<!-- 		<div class="card-body"> -->




										<div class="row">
											<div class="col-sm-4">
												<div class="row">
													<div class="col-sm-8">
														<label for="manufactureYear" class="l-fontst manuSty">Manufactured
															Year</label>
													</div>
													<div class="col-sm-5">
														<form:input class="form-control fontst"
															path="manufactureYear" id="manufactureYear"
															pattern="{12}" title="Please Enter valid YEAR !"
															required="true" onchange="getNorms" />														
														<form:errors path="manufactureYear" cssClass="error1" />
														<i class="fa fa-calendar iconali"></i>
													</div>


												</div>

											</div>
											<div class="col-sm-5">
												<div class="row">

													<div class="col-sm-6">
														<label for="registeredYear" class="l-fontst">Registered
															Year</label>
													</div>
													<div class="col-sm-6">
														<form:input type="date" class="form-control fontst"
															path="registeredYear" id="registeredYear" pattern="{12}"
															title="Please Enter valid YEAR !"
															onchange="getChassisNumberDetails()" required="true" />
														<form:errors path="registeredYear" cssClass="error1" />
														<i class="fa fa-calendar iconali" for="registeredYear"></i>
													</div>

												</div>

											</div>
											<div class="col-sm-3">
												<label class="l-fontst" id="manufaCur1">Manufactured
													in</label><br> <label class="l-fontst" id="manufaCur"></label>
											</div>
										</div>
										<br>
										<hr />




										<div class="row">
											<div class="col-sm-4">
												<div class="row">
													<div class="col-sm-3">
														<label class="l-fontst">Class</label>
													</div>
													<div class="col-sm-7">
														<form:select path="vmodel.vehicleClass.vehicleClassID"
															class="custom-select fontst" id="vClass"
															onchange="getClass();getClassImage();getCategory();"
															required="true">
															<form:option value="NONE">Select..</form:option>
															<c:forEach items="${veclass}" var="VClass">
																<form:option value="${VClass.vehicleClassID}">${VClass.vehicleClass}</form:option>
															</c:forEach>
														</form:select>
													</div>
													<div class="col-sm-2">
														<img src="" id="classImg" class="img-responsive imgalign">
													</div>
												</div>

											</div>
											<div class="col-sm-8">
												<div class="row">

													<div class="col-sm-1">
														<label for="manu1" class="l-fontst">Make</label>
													</div>
													<div class="col-sm-5">
														<form:select path="vmodel.vehicleMakeID.vehicleMakeID"
															id="vMake" class="custom-select fontst"
															onchange="getModel(); getMakeLogo()" required="true">
															<form:option value="NONE">Select...</form:option>
															<c:forEach items="${veMake}" var="vMake">
																<form:option value="${vMake.vehicleMakeID}">${vMake.vehicleMake}</form:option>
															</c:forEach>
														</form:select>
													</div>
													<div class="col-sm-3">
														<img src="" id="makeImg" class="img-responsive imgalign">
													</div>
													<div class="col-sm-3">
														<a type="button"
															class="bt-sty btn btn-outline-primary waves-effect"
															data-toggle="modal" data-target="#myModal">New Make</a>
													</div>
												</div>

											</div>
											<!-- 							<div class="col-sm-3">											 -->
											<!-- 										<label  class="l-fontst" id="manufaCur">Manufactured in</label>									 -->
											<!-- 							</div>										 -->
										</div>
										<br />
										<div class="row">
											<div class="col-sm-4">
												<div class="row">
													<div class="col-sm-3">
														<label for="ii" class="l-fontst">Category</label>
													</div>
													<div class="col-sm-7">
														<label id="cate" class="lacol"></label>
													</div>

												</div>




											</div>
											<div class="col-sm-8">
												<div class="row">
													<div class="col-sm-1">
														<label for="t6" class="l-fontst">Model</label>
													</div>
													<div class="col-sm-5">
														<form:select path="vmodel.vehicleModelID"
															id="vehicleModelID" class="custom-select fontst"
															onchange="getModelImage()" required="true">
															<form:option value="NONE">Select Model...</form:option>
															<c:forEach items="${vemodel}" var="model">
																<form:option value="${model.vehicleModelID}">${model.vehicleModel}</form:option>
															</c:forEach>
														</form:select>
													</div>
													<div class="col-sm-3">
														<img src="" id="modelImg" class="img-responsive imgalign">
													</div>
													<div class="col-sm-3">
														<a type="button"
															class="bt-sty btn btn-outline-success waves-effect"
															data-toggle="modal" data-target="#VecModal">New Model</a>
													</div>
												</div>




											</div>
										</div>
										<hr>
										<!-- 					======================  -->
										<div class="row">
											<div class="col-sm-1">
												<img src="resources/img/icon/engine.png" class="engSty" />
											</div>
											<div class="col-sm-3">
												<label class="l-fontst">Engine</label>
											</div>

											<div class="col-sm-5">
												<!-- 								<div class="row"> -->
												<!-- 									<div class="col-sm-3"> -->
												<!-- 										<label  class="l-fontst">Class</label> -->
												<!-- 									</div>	 -->
												<!-- 									<div class="col-sm-7">						             			             		 -->
												<%-- 					             		<form:select path="vmodel.vehicleClass.vehicleClassID" class="custom-select fontst" id="vClass" onchange="getClass();getClassImage();getCategory();" required="true"> --%>
												<%-- 											<form:option value="NONE">Select..</form:option> --%>
												<%-- 											<c:forEach items="${veclass}" var="VClass"> --%>
												<%-- 												<form:option value="${VClass.vehicleClassID}">${VClass.vehicleClass}</form:option> --%>
												<%-- 											</c:forEach> --%>
												<%-- 										</form:select>		             		 --%>
												<!-- 									</div> -->
												<!-- 									<div class="col-sm-2">											 -->
												<!-- 										<img src="" id="classImg" class="img-responsive imgalign">									 -->
												<!-- 									</div> -->
												<!-- 								</div> -->

											</div>


										</div>
										<div class="form-group row">
											<div class="col-sm-5">
												<div class="row">
													<div class="col-sm-4">
														<label for="u7" class="l-fontst">No</label>
													</div>
													<div class="col-sm-8">
														<form:input class="form-control fontst" path="engineNo"
															id="engno"
															onkeyup="this.value = this.value.toUpperCase();checkEngNo();"
															required="true" />
														<form:errors path="engineNo" cssClass="error1" />
													</div>
												</div>

											</div>
											<div class="col-sm-6">
												<div class="row">
													<div class="col-sm-5">
														<label class="l-fontst">Capacity</label>
													</div>
													<div class="col-sm-5">
														<form:input class="form-control fontst"
															path="engineCapacity" id="engineCapacity" required="true" />
														<form:errors path="engineCapacity" cssClass="error1" />
													</div>
													<div class="col-sm-2">
														<label class="l-fontst">CC</label>
													</div>
												</div>

											</div>

										</div>

										<div class="form-group row">
											<div class="col-sm-5">
												<div class="row">
													<div class="col-sm-4">
														<label for="chassisNo" class="l-fontst">Fuel Type</label>
													</div>
													<div class="col-sm-6">
														<form:select path="ftype.fuelTypeID"
															class="custom-select fontst" id="fuel" required="true"
															onchange="getNorms()">
															<form:option value="NONE">Select...</form:option>
															<c:forEach items="${fuelType}" var="fuel">
																<form:option value="${fuel.fuelTypeID}">${fuel.fuel}</form:option>
															</c:forEach>
														</form:select>
														<i class='fas fa-gas-pump iconali'></i>
													</div>

												</div>

											</div>
											<div class="col-sm-6">
												<div class="row">
													<div class="col-sm-5">
														<label for="chassisNo" class="l-fontst">Emission
															Norms</label>
													</div>
													<div class="col-sm-5">
														<form:select path="emissionNorms"
															class="custom-select fontst" id="emission"
															required="true">
															<form:option value="NONE">Select...</form:option>
															<c:forEach items="${emissionNorms}" var="name">
																<form:option value="${name.ruleName}">${name.ruleName}</form:option>
															</c:forEach>
														</form:select>
													</div>
												</div>
											</div>

										</div>

									</div>


									<div class="form-group row">
										<div class="col-sm-5">

											<div class="row">
												<div class="col-sm-4">
													<label for="t4" class="l-fontst">Axles</label>
												</div>
												<div class="col-sm-3">
													<form:select path="noWheel"
														class="custom-select numberfield fontst" required="true">
														<form:option value="9">9</form:option>
														<form:option value="8">8</form:option>
														<form:option value="7">7</form:option>
														<form:option value="6">6</form:option>
														<form:option value="5">5</form:option>
														<form:option value="4">4</form:option>
														<form:option value="3">3</form:option>
														<form:option value="2" selected="true">2</form:option>
														<form:option value="1">1</form:option>
														<form:option value="0">0</form:option>
													</form:select>
												</div>
												<!-- 									<div class="col-sm-2"> -->

												<!-- 									</div> -->
											</div>

										</div>
										<div class="col-sm-5">
											<div class="row">
												<div class="col-sm-6">
													<label for="chassisNo" class="l-fontst">Speed
														Governor</label>
												</div>
												<div class="col-sm-6">
													<form:select path="subCategoryID.subCategoryID"
														class="custom-select fontst" required="true">
														<form:option value="NONE">Select...</form:option>
														<c:forEach items="${vehiclesSubCategorylist}" var="vscat">
															<form:option value="${vscat.subCategoryID}">${vscat.description}</form:option>
														</c:forEach>
													</form:select>
												</div>


											</div>

										</div>

									</div>
									<br>
									<br> <br>
									<br> <br>
									<br>

								</div>



							</div>
						</div>
						<form:form method="post" modelAttribute="veOwner">
							<!-- Pie Chart -->
							<div class="col-xl-4 col-lg-5">
								<div class="card shadow mb-4">
									<!-- Card Header - Dropdown -->
									<div
										class="card-header py-2 d-flex flex-row align-items-center">
										<img src="resources/img/icon/vowner.png" class="iconstyle" />
										<h6 class="m-0 font-weight-bold text-primary">. Owner
											Details</h6>

										<div class="col-sm-7 text-right">
											<a href="#" class="w3-button w3-tiny fontst fontcol-peo"
												onClick="goNewOwner()"><i class="fa fa-plus-circle"
												aria-hidden="true" style="color: #4dc3ff;"></i> New Owner</a>

										</div>
									</div>
									<!-- Card Body -->
									<div class="card-body">

										<div class="row">

											<div class="col-sm-5">
												<form:input class="form-control" path="ownerID" id="ownerId"
													hidden="true" value="${veOwner.ownerID}" />
												<label class="l-fontst">Name</label>
											</div>
											<div class="col-sm-7"></div>
										</div>
										<div class="row">

											<div class="col-lg-4">
												<form:select path="title" id="title"
													class="custom-select custom-select-sm" required="true">
													<form:option selected="true" value="Mr">Mr</form:option>
													<form:option value="Mrs">Mrs</form:option>
													<form:option value="Miss">Miss</form:option>
												</form:select>
											</div>
											<div class="col-sm-8">
												<form:input class="form-control fontst" path="ownerName"
													value="${veOwner.ownerName}" required="true" />
											</div>
										</div>
										<div class="row">
											<div class="col-sm-2">
												<label class="l-fontst">P.O.Box</label>
											</div>
											<div class="col-sm-2"></div>
										</div>
										<div class=" row">
											<div class="col-sm-12">
												<form:input class="form-control fontst" path="postalBox"
													value="${veOwner.postalBox}" required="true" />
											</div>
										</div>
										<div class="row">
											<div class="col-sm-2">
												<label class="l-fontst">Address</label>
											</div>
											<div class="col-sm-2"></div>
										</div>
										<div class=" row">
											<div class="col-sm-12">
												<form:input class="form-control fontst" path="add01"
													value="${veOwner.add01}" required="true" />
											</div>
										</div>



										<div class="row">
											<div class="col-sm-2">
												<label class="l-fontst">City</label>
											</div>
											<div class="col-sm-2"></div>
										</div>
										<div class=" row">
											<div class="col-sm-12">
												<form:input class="form-control fontst" path="city"
													value="${veOwner.city}" required="true" />
											</div>
										</div>

										<div class="row">
											<div class="col-sm-2">
												<label class="l-fontst">State</label>
											</div>
											<div class="col-sm-2"></div>
										</div>
										<div class=" row">
											<div class="col-sm-12">
												<form:select path="stateid.stateid"
													value="${veOwner.stateid.stateid}"
													class="custom-select fontst" required="true">
													<form:option value="">Select State...</form:option>
													<c:forEach items="${counState}" var="sta">
														<form:option value="${sta.stateid}">${sta.state}</form:option>
													</c:forEach>
												</form:select>


											</div>
										</div>

										<div class="row">
											<div class="col-sm-1"></div>
											<div class="col-sm-11">
												<label class="l-fontst">Contact Info</label>
											</div>
										</div>
										<div class=" row">
											<div class="col-sm-1">
												<i class="fa fa-phone" aria-hidden="true"></i>
											</div>
											<div class="col-sm-3">
												<form:input class="form-control fontst" path=""
													value='<%=session.getAttribute("countryCode")%>'
													required="true" readonly="true" />
											</div>
											<div class="col-sm-8">
												<form:input class="form-control fontst" path="contactNo"
													value="${veOwner.contactNo}" required="true" />
											</div>
										</div>


										<div class="row">
											<div class="col-sm-1"></div>
											<div class="col-sm-11">
												<label class="l-fontst">Email</label>
											</div>
										</div>
										<div class="row">
											<div class="col-sm-1">
												<i class="fa fa-envelope" aria-hidden="true"></i>
											</div>
											<div class="col-sm-11">
												<form:input class="form-control fontst" path="email"
													value="${veOwner.email}" />
											</div>
										</div>




										<div class="form-group row"></div>
										<div class="row">
											<br>
											<div class="col-sm-11">
												<label class="l-fontst fontcol-peo">Previous
													Owners</label>

											</div>
										</div>
										<hr>
										<div class=" row">
											<div class="col-sm-12">
												<table id="eqTypeTable"
													class="table-sm table-wrapper-scroll-y my-custom-scrollbar"
													style="height: 70px;">
													<thead>
														<tr>
															<th width="420px"></th>
														</tr>
													</thead>
													<tbody id="myTable">

														<c:forEach items="${pre_owners}" var="preOwners">
															<c:if test="${preOwners.status=='previousOwner'}">
																<tr>
																	<td><div
																			style="color: #000099; font-family: Arial, Helvetica, sans-serif; font-size: 12px">${preOwners.ownerName}</div></td>
																</tr>
															</c:if>
														</c:forEach>
													</tbody>
												</table>

											</div>
										</div>
										<div class="row">
											<div class="col-sm-12 justify-content-end">
												<button type="submit" class="btn btn-success btn-block">Proceed
													to Lane Entry</button>
											</div>


										</div>

									</div>
								</div>
							</div>
						</form:form>
				</div>

				</form:form>

				<%@include file="checkDocument.jsp"%>





			</div>

		</div>
		<%@include file="../WEB-INF/jsp/footer.jsp"%>
	</div>
	</div>
	<%@include file="../WEB-INF/jsp/commJs.jsp"%>

	<%@include file="VehicleMakeModel.jsp"%>

	<%@include file="VehicleModelFormModel.jsp"%>



	<script src='resources/assets/js/select2/select2.min.js'
		type='text/javascript'></script>




	<script>
		function getDocumentCheck(){
		//	alert("ddddddddddd");
		
		var ocid = document.getElementById("ocid").value;
		 
		 	$.ajax({

		 	    type: 'GET',
		 	    url: "checkDocTable",
		 	    data: {"ocrid" : ocid},
		         success: function(data){
		        
		         	//$("table tbody").empty();
		        	if(data!=""){
		        		var dohid="";
		         	 var slctSubcat1=$('#docTable1'), option="";
		 	            slctSubcat1.empty();
		 			for(var i=0; i<data.length; i++){
					
		 				selected_option =  "<tr>"+
		 				"<td><div><input class='form-control form-control-sm' name='doc' id='doc' value="+data[i].documentcheckDetailsid+"  readonly/></div></td>"+
		 				"<td><div>"+data[i].documentid.description+"</div></td>"+
		 				"<td><div><input class='form-control form-control-sm' name='rem' id='rem' value="+data[i].remarks+"  /></div></td>"+
		 				"<td><div><select class='custom-select' name='docStatus' value="+data[i].checkStatus+" >"+
		 								"<option value='N/A'>N/A</option>"+
		 								"<option value='OK'>OK</option>"+
		 								"<option value='Not OK'>Not OK</option>"+
		 							"</select>"+		
		 				"</div></td>"+
		 			"</tr>"
							
							
							dohid=data[i].documentCheckHeadID.documentcheckheadid;
		 				 slctSubcat1.append(selected_option);	
							
		 			}
							
		 			
		 			document.getElementById("docheadid").value=	dohid;
		            	 }

		         },
		         error:function(){
		        	alert("Error");
		         }
		 	 });
			
			
		}
		
		$(document).ready(function(){
			
		    // Initialize select2
		    $("#vehicleModelID").select2();
		   
		});
		
		$(document).ready(function(){
			
		    // Initialize select2
		    $("#vMake").select2();
		   
		});
		
		
	$(document).ready(function(){
		  $("#manufactureYear").keypress(function(e){
		    var keyCode = e.which;
		    /*
		    8 - (backspace)
		    32 - (space)
		    48-57 - (0-9)Numbers
		    */
		    if ( (keyCode != 8 || keyCode ==32 ) && (keyCode < 48 || keyCode > 57)) { 
		      return false;
		    }
		  });
		  $("#registeredYear").keypress(function(e){
			    var keyCode = e.which;
			    /*
			    8 - (backspace)
			    32 - (space)
			    48-57 - (0-9)Numbers
			    */
		    if ( (keyCode != 8 || keyCode ==32 ) && (keyCode < 48 || keyCode > 57)) { 
			      return false;
			    }
			  });
		  $("#engineCapacity").keypress(function(e){
			    var keyCode = e.which;
			    /*
			    8 - (backspace)
			    32 - (space)
			    48-57 - (0-9)Numbers
			    */
			    if ( (keyCode != 8 || keyCode ==32 ) && (keyCode < 48 || keyCode > 57)) { 
			      return false;
			    }
			  });
		  $("#currentMilage").keypress(function(e){
			    var keyCode = e.which;
			    /*
			    8 - (backspace)
			    32 - (space)
			    48-57 - (0-9)Numbers
			    */
			    if ( (keyCode != 8 || keyCode ==32 ) && (keyCode < 48 || keyCode > 57)) { 
			      return false;
			    }
			  });
		  
		  
		  
		  
		  
		  
	});
	

	
	</script>


	<script type="text/javascript">
	
	
	
	
	function getClass()
	{
		var str = document.getElementById("vClass").value;
		var makeID = document.getElementById("vMake").value;
		//alert(str);
		if (str=="") {
			var slctSubcat=$('#vehicleModelID'), option="";
	        slctSubcat.empty();
	   
		return;
		}
		else{			
			$.ajax({
	        type: 'GET',
	        url: "getModelForCombo",
	        data: {"makeID" : makeID , "classID" : str},
	        success: function(data){
	        
	            var slctSubcat=$('#vehicleModelID'), option="";
	            slctSubcat.empty();
	            selected_option = "<option value='' selected>Select Model...</option>"
	            slctSubcat.append(selected_option);

	            for(var i=0; i<data.length; i++){
	                option = option + "<option value='"+data[i].vehicleModelID + "'>"+data[i].vehicleModel + "</option>";
	            }
	            slctSubcat.append(option);
	        },
	        error:function(){
	          //  alert("No return Model data for this Class ID");
	        }

	    });			
	}	
		getCategory();
	}
	
	
	function getModel()
	{
		//document.getElementById("VecModal").style.display="block";
		//alert("ddd");
		var str= document.getElementById("vMake").value;
	var vClass = document.getElementById("vClass").value;
		if (str=="") {
    		var slctSubcat=$('#vehicleModelID'), option="";
            slctSubcat.empty();
            
    	return;
		}else{
  			
			$.ajax({
	        type: 'GET',
	        url: " getModelForCombo",
	        data: {"classID" : vClass, "makeID" : str},
	        success: function(data){
	        
	            var slctSubcat=$('#vehicleModelID'), option="";
	            slctSubcat.empty();
	            selected_option = "<option value='' selected>Select Model...</option>"
	            slctSubcat.append(selected_option);
	
	            for(var i=0; i<data.length; i++){
	                option = option + "<option value='"+data[i].vehicleModelID + "'>"+data[i].vehicleModel + "</option>";
	            }
	            slctSubcat.append(option);
	        },
	        error:function(){
	           // alert("No return Model data for this Make ID");
	        }
	
	    });
			
    }
}


function getCategory()
{ 
	var str = document.getElementById("vClass").value;
	
	//alert(str);
	if (str=="") {
    	var slctSubcat=$('#cate'), option="";
        slctSubcat.empty();
   
	return;
	}
	else{			
		$.ajax({
        type: 'GET',
        url: "getVClassByIdData",
        data: {"classid" : str},
        success: function(data){
        
        	var slctSubcat=$('#cate'), option="";
        	 slctSubcat.empty();
        	option="<label class='fontst lacol'>"+data.categoryID.vehicleCategory+"</label>";
        	slctSubcat.append(option);
     	
        	
       	
      	
        },
        error:function(){
        	var slctSubcat=$('#cate'), option="";
       	 	slctSubcat.empty();
        }

    });
		
}
}

function checkVinNo(){
	
	var str = document.getElementById("chassisNoid3").value;
	var veNo = document.getElementById("vehicleID").value;
	
	$.ajax({
        type: 'GET',
        url: "checkVinNo",
        data: {"vinno" : str,"veNo" : veNo},
        success: function(data){
        	if(data!=""){
        	alert("VIN(Chassis Number) is already used");
        	document.getElementById("chassisNoid3").value="";
        	}else{
        	
        			
        	}
      	
        }

    });
	
	
	
}

function checkEngNo(){
	
	var str = document.getElementById("engno").value;
	var veNo = document.getElementById("vehicleID").value;
	
	$.ajax({
        type: 'GET',
        url: "checkEngNo",
        data: {"engno" : str,"veNo" : veNo},
        success: function(data){
        	if(data!=""){
        	alert("Engine is already used");
        	document.getElementById("engno").value="";
        	}else{
        	
        			
        	}
      	
        }

    });
	
}

	
//=================================================================================
	
	function getClassImage(){ 
		var str = document.getElementById("vClass").value;
		//alert(str);
		if (str=="") {
	    	var slctSubcat=$('#classImg'), option="";
	        slctSubcat.empty();
	   
		return;
		}
		else{			
			$.ajax({
	        type: 'GET',
	        url: "getVClassImage",
	        data: {"classid" : str},
	        success: function(data){
				 var x = document.getElementById("classImg");
				 
				 x.setAttribute("src", "data:image/jpg;base64,"+data+"");
 				 x.setAttribute("width", "50");
 				 x.setAttribute("height", "30");
	       	
	      	
	        },
	        error:function(){
	      
	        }

	    });
			

			
			
			
	}
	}
	

	function getMakeLogo()
	{
		var str = document.getElementById("vMake").value;
		
		
		if (str=="")
		{   
			return;
		}
		
		else
		{
				$.ajax({
			    type: 'GET',
			    url: "getImageForCombo",
			    data: {"vmake" : str},
			    success: function(data){
			        	
					 var x = document.getElementById("makeImg");
					 
					 x.setAttribute("src", "data:image/jpg;base64,"+data+"");
					 x.setAttribute("width", "60");
					 x.setAttribute("height", "30");
					 
					 //document.getElementById("makeImg").appendChild(x);
			    },
			    error:function(){
			        //alert("No Return Make Logo");
			    }
			
			});
		}
	}
	
	
	function getModelImage()
	{
		
		var str = document.getElementById("vehicleModelID").value;
		
		if (str=="")
		{   
			return;
		}
		
		else
		{
				$.ajax({
			    type: 'GET',
			    url: "getModelImage",
			    data: {"vehicleModelID" : str},
			    success: function(data){
			        	
					 var x = document.getElementById("modelImg");
					 
					 x.setAttribute("src", "data:image/jpg;base64,"+data+"");
					 x.setAttribute("width", "60");
					 x.setAttribute("height", "30");
					 
					 //document.getElementById("makeImg").appendChild(x);
			    },
			    error:function(){
			       // alert("No Return Model Image");
			    }
			
			});
		}
	}
	
	function goNewOwner(){
		
    	document.getElementById("ownerId").value = "";
    	document.getElementById("ownerName").value = "";
    	document.getElementById("contactNo").value = "";
    	document.getElementById("email").value = "";
    	document.getElementById("add01").value = "";
    	document.getElementById("postalBox").value = "";
    	document.getElementById("city").value = "";
    	document.getElementById("stateid.stateid").value = "";
    //	document.getElementById("vehicleID").value = "";
		
	}

	</script>


	<script type="text/javascript">
	

            // When the document is ready

          
            $(document).ready(function () {
             $('#manufactureYear').datepicker({
                    minViewMode: 1,
                    autoclose: true,
                    format:'<%=session.getAttribute("dateFormat")%>' 
//                 	moment(manufactureYear).format(dateFormat);
                	
             });  
                     
          }); 

            
//             $(document).ready(function () {
                
//                 $('#manufactureYear').datepicker({
//                     minViewMode: 'years',
//                     autoclose: true,
//                      format: 'yyyy'
//                 });  
            
//             });       
            
            //registeredYear
            
            
//             $(document).ready(function () {
//                 $('#manufactureYear').datepicker({
//                        minViewMode: 1,
//                        autoclose: true,
//                        format: 'yyyy-mm'
//                 });  
                        
//             });
//             $(document).ready(function () {
//                 $('#registeredYear').datepicker({
//                        minViewMode: 1,
//                        autoclose: true,
//                        format: 'yyyy-mm-dd'
//                 });  
                        
//             }); 
            
        	function getChassisNumberDetails()
        	{
        		if(${check}=="1"){
        		var str = document.getElementById("chassisNoid3").value;
        		if(str.length==17){
        		var regyea = document.getElementById("registeredYear").value;
        		
        		  var d = new Date();
        		  var n = d.getFullYear();
             		if (regyea=="")
            		{   
             		regyea =n;
            		}
        		
        		if (str=="")
        		{   
        			return;
        		}
        		
        		else
        		{
        				$.ajax({
        			    type: 'GET',
        			    url: "getChassisNumberDetails",
        			    data: {"vinid" : str,"regyea" : regyea},
        			    success: function(data){
		 
        			    	if(data[0][1]!=null){
        					 document.getElementById("vMake").value=data[0][1];
        					 
        			    	}
        			    	if(data[0][0]!=null){
        					 document.getElementById("manufactureYear").value=data[0][0];
        			    	}
        					 if(data[0][2]!=null){
        					 document.getElementById("manufaCur").innerHTML=""+data[0][2];
        			    	}
        			    },
        			    error:function(){
        			       // alert("No Return Model Image");
        			    }
        			
        			});
        		}
        		}
        	}
        	}   
            
        	
        	
        	
//         	function getModelImage(str)
//         	{
//         		if (str=="")
//         		{   
//         			return;
//         		}
        		
//         		else
//         		{
//         				$.ajax({
//         			    type: 'GET',
//         			    url: "getModelImage",
//         			    data: {"vehicleModelID" : str},
//         			    success: function(data){
        			        	
//         					 var x = document.getElementById("modelImg");
        					 
//         					 x.setAttribute("src", "data:image/jpg;base64,"+data+"");
//         					 x.setAttribute("width", "60");
//         					 x.setAttribute("height", "30");
        					 
//         					 //document.getElementById("makeImg").appendChild(x);
//         			    },
//         			    error:function(){
//         			       // alert("No Return Model Image");
//         			    }
        			
//         			});
//         		}
//         	}
        	
        	
        	
// function cide() {
	
// 	//$('#myModal').modal('toggle');
       
// 	 alert("error");
//     }

        	
function getMake()
{   
	
			
		$.ajax({
        type: 'GET',
        url: "getComboVmak",
        success: function(data){
        
            var slctSubcat=$('#vMake'), option="";
            slctSubcat.empty();
            selected_option = "<option value='' selected>Select vMake...</option>"
            slctSubcat.append(selected_option);
            
            var slctSubcat1=$('#mvehicleMakeID');
            slctSubcat1.empty(); 
            slctSubcat1.append(selected_option);     
            
            
            
            
            

            for(var i=0; i<data.length; i++){
                option = option + "<option value='"+data[i].vehicleMakeID + "'>"+data[i].vehicleMake + "</option>";
               
            }
            slctSubcat.append(option);
            slctSubcat1.append(option);
        },
        error:function(){
            alert("No return vMake data");
        }

    });
		
	
}    	
function saveModelV(){
	var request_method = $("#modelForm2").attr("method"); //get form GET/POST method

	// Get form
	var form = $('#modelForm2')[0];

	// Create an FormData object
	var data = new FormData(form);

	//alert("Error "+form_data);
	$.ajax({

		url : "savevmodelFormModel",
		type : request_method,
		enctype : 'multipart/form-data',
		data : data,
		processData : false,
		contentType : false,
		cache : false,
		success : function(data) {
			
			swal("Good job!", "Successfully saved!", {
				icon : "success",
				buttons: {        			
					confirm: {
						className : 'btn btn-success'
					}
				},
			});
	      		getModelV();


		}

	});	


}   	
   	
   	
function getModelV(){
	
	//document.getElementById("VecModal").style.display="block";
	//alert("ddd");
var str= document.getElementById("vMake").value;
var vClass = document.getElementById("vClass").value;

// alert(str+"  "+vClass);
	if (str=="") {
		var slctSubcat=$('#vehicleModelID'), option="";
        slctSubcat.empty();
        
	return;
	}
		else{
			
		$.ajax({
        type: 'GET',
        url: " getModelForCombo",
        data: {"classID" : vClass, "makeID" : str},
        success: function(data){
        
            var slctSubcat=$('#vehicleModelID'), option="";
            slctSubcat.empty();
            selected_option = "<option value='"+data[data.length-1].vehicleModelID + "'>"+data[data.length-1].vehicleModel + "</option>";
            slctSubcat.append(selected_option);

            for(var i=0; i<data.length-1; i++){
                option = option + "<option value='"+data[i].vehicleModelID + "'>"+data[i].vehicleModel + "</option>";
            }
            slctSubcat.append(option);
        },
        error:function(){
        	
           // alert("No return Model data for this Make ID");
        }

    });
		
}
	

	
} 	
function saveMakeV() {
	var request_method = $("#formMake").attr("method"); //get form GET/POST method

	// Get form
	var form = $('#formMake')[0];

	// Create an FormData object
	var data = new FormData(form);

	//alert("Error "+form_data);
	$.ajax({

		url : "saveVMakeModelForm",
		type : request_method,
		enctype : 'multipart/form-data',
		data : data,
		processData : false,
		contentType : false,
		cache : false,
		success : function(data) {
			
//       		Swal.fire({
// 	      		  position: 'top-end',
// 	      		  icon: 'success',
// 	      		  title: 'Successfully saved!',
// 	      		  showConfirmButton: false,
// 	      		  timer: 1500
// 	      		});
			swal("Good job!", "Successfully saved!", {
				icon : "success",
				buttons: {        			
					confirm: {
						className : 'btn btn-success'
					}
				},
			});

	      		getMakeV();
		}

	});	
	 
}

function saveCheckDocment() {

	var request_method = $("#savaCheckdocid").attr("method"); //get form GET/POST method
	
	// Get form
	var form = $('#savaCheckdocid')[0];

	// Create an FormData object
	var data = new FormData(form);
	
	//alert("Error "+form_data);
	$.ajax({

		url : "savaCheckDocument",
		type : request_method,
		enctype : 'multipart/form-data',
		data : data,
		processData : false,
		contentType : false,
		cache : false,
		success : function(data) {
			
 			if (data == "1") {
	    
		      		
					swal("Good job!", "Document Check is Successfully Completed!", {
						icon : "success",
						buttons: {        			
							confirm: {
								className : 'btn btn-success'
							}
						},
					});
		      		
		      		
 			}else{
 				
	        		swal("Oops...", "Document Check is not Save ", {
							icon : "error",
							buttons: {        			
								confirm: {
									className : 'btn btn-danger'
								}
							},
						});
 				
 			
 			}
 			


		}

	});
	


}

   	
function getMakeV()
{   
	
			
		$.ajax({
        type: 'GET',
        url: "getComboVmakV",
        success: function(data){
        
            var slctSubcat=$('#vMake'), option="";
            slctSubcat.empty();
            selected_option = "<option value='"+data[data.length-1].vehicleMakeID + "'>"+data[data.length-1].vehicleMake + "</option>"
            slctSubcat.append(selected_option);
            
            var slctSubcat1=$('#mvehicleMakeID');
            slctSubcat1.empty(); 
            slctSubcat1.append(selected_option);     
            
            
            
            
            

            for(var i=0; i<data.length-1; i++){
                option = option + "<option value='"+data[i].vehicleMakeID + "'>"+data[i].vehicleMake + "</option>";
               
            }
            slctSubcat.append(option);
            slctSubcat1.append(option);
        },
        error:function(){
           // alert("No return vMake data");
        }

    });
		
	
}     	
   	
	 	
var table = document.getElementsByTagName("table")[0];
var tbody = table.getElementsByTagName("tbody")[0];
tbody.onclick = function (e) {
    e = e || window.event;
    var data = [];
    var target = e.srcElement || e.target;
    while (target && target.nodeName !== "TR") {
        target = target.parentNode;
    }
    if (target) {
        var cells = target.getElementsByTagName("td");
        for (var i = 0; i < cells.length; i++) {
            data.push(cells[i].innerHTML);
        }
    }
  //  alert(data[0]);
    var vid = document.getElementById("vehicleID").value;
    
    if(data[3]=="New"){
    	window.location.href = "newVehicleMaster?vehicleID="+data[0]+"&id="+data[2]+"&appNo=0";
    }else{
    	window.location.href = "vehicleMasterAuto?vehicleID="+data[0]+"&id="+data[2]+"&appNo=0";
    }
    
			
		
		//document.getElementById('vehicleID').value = data[0];
		//document.getElementById('ocid').value = data[2];
	//	getVMasterData(data[0]);
	//	document.getElementById('results').src = "data:image/jpg;base64,"+data[1];

};
   	
   






        </script>
	<script type="text/javascript">

function getNorms() {

	 
 	var year = document.getElementById("manufactureYear").value;
	var fuel = document.getElementById("fuel").value;
		
	 			
	$.ajax({
		type : "GET",
		url : "emissionNorms",
		 data: {"year" : year, "fuel" : fuel},
		success : function(data) {
			
           document.getElementById("emission").value = data.ruleName;             
  
// 	$.ajax({
// 	        type: 'GET',
//  	        url: "emissionNorms",
// 	        data: {"year" : year, "fuel" : fuel},
// 	        success: function(data){
	        
 	   				
	        	
	        	
	        	
//  	        },
//  	        error:function(){
	        	
//  	            alert("No return Model data for this Make ID");
  	        }

 	    });
}

</script>

</body>
</html>
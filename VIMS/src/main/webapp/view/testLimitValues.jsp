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
							<h4 class="page-title">Set Codes & Limit Values</h4>
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
									<a href="#">Test Profiles</a>
								</li>
								<li class="separator">
									<i class="flaticon-right-arrow"></i>
								</li>
								<li class="nav-item">
									<a href="#">Set Codes & Limit Values</a>
								</li>
							</ul>
					</div>

					<!-- Card -->
					<div class="card shadow mb-4">
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
									<strong>Warning!</strong>Something went wrong ! Please try
									again!
								</div>
							</c:if>

							<div class="row">
								<div class="col-lg-6">
								
									<form:form action="saveLimitValues" method="POST" modelAttribute="limitValues">
		
										<div class="form-group row">
											<div class="col-lg-6">
												<div class="form-group form-floating-label">
													<form:select id="testProfile" class="form-control input-border-bottom" 
														required="required" path="ck_testProfileDetailId.testProfileHeaderID.testProfileID">
														<option></option>
														<c:forEach items="${testProfile}" var="testProfile">
															<form:option value="${testProfile.testProfileID}">${testProfile.testProfileName}</form:option>
														</c:forEach>
													</form:select>
													<label for="testProfile" class="placeholder">Select test profile</label>
												</div>
											</div>
										</div>
										<div class="form-group row">
											<div class="col-lg-6">
												<div class="form-group form-floating-label">
													<form:select id="testType" class="form-control input-border-bottom"
														onchange="getTestCodes4(this.value)" required="required" path="ck_testProfileDetailId.parameterCode.ck_paraCodeId.testType.typeId">
														<option></option>
														<c:forEach items="${testTypes}" var="testType">
															<c:if test = "${testType.typeId != '0'}">
																<form:option value="${testType.typeId}">${testType.type}</form:option>
															</c:if>
														</c:forEach>
													</form:select>
													<label for="testType" class="placeholder">Select test type</label>
												</div>
											</div>
										</div>
										<div class="form-group row">
											<div class="col-lg-6">
												<div class="form-group form-floating-label">
													<form:select id="paraCode" class="form-control input-border-bottom" 
														required="required" path="ck_testProfileDetailId.parameterCode.ck_paraCodeId.code">
														<option></option>
														<c:forEach items="${paraCodes}" var="c">
															<form:option value="${c.ck_paraCodeId.code}">${c.ck_paraCodeId.code} - ${c.testPoint.testPointName} ${c.testParameter.paraName} ${c.testParameterAngle.angleName}</form:option>
														</c:forEach>
													</form:select>
													<label for="paraCode" class="placeholder">Select code</label>
												</div>
											</div>
										</div>
			
										<div class="form-group row">
											<div class="col-lg-6">
												<div class="form-group form-floating-label">
													<form:select id="vehicleCateory" class="form-control input-border-bottom" 
														required="required" path="ck_testProfileDetailId.vehicleCat.categoryID">
														<option></option>
														<c:forEach items="${vehicleCat}" var="vCat">
															<form:option value="${vCat.categoryID}">${vCat.vehicleCategory}</form:option>
														</c:forEach>
														<form:option value="all">Apply to all categories</form:option>
													</form:select>
													<label for="vehicleCateory" class="placeholder">Select vehicle category</label>
												</div>
											</div>
										</div>
										
									
									<br>
										<div class="row">
											<div class="col-lg">
		
												<h5>Single Limit Value <a href="#" data-toggle="tooltip" title="If you want to get pass fail status depending on your preference, you can set limit values, 
													otherwise please skip it and save.">
													<i class="fa fa-question-circle" style="font-size:14px"></i>
													</a></h5>
												<table class="table table-borderless table-sm">
													<thead class="thead-light">
														<tr>
															<th></th>
															<th>.</th>
															<th>.</th>
														</tr>
													</thead>
													<tbody>
														<tr>
															<td>
																<div
																	class="custom-control custom-radio  custom-control-inline">
																	<input type="radio" class="custom-control-input"
																		id="customRadio" name="example1" checked="checked"
																		value="pass"> 
																		<label class="custom-control-label" for="customRadio">PASS</label>
																</div>
															</td>
															<td>
																<form:select path="operator" id="select1"
																	class="form-control">
																	<form:option value="">Select operator</form:option>
																	<form:option value="=>"> equal or grater than </form:option>
																	<form:option value="<="> less than or equal </form:option>
																	<form:option value=">"> grater than </form:option>
																	<form:option value="<"> less than </form:option>
																</form:select>
															</td>
															<td>
																<form:input path="limitValue" id="input1"
																	placeholder="00.00" class="form-control"
																	maxlength="5" size="4" onkeypress="return onlyNumber(event)"/>
															</td>
														</tr>
														<tr>
															<td>
																<div
																	class="custom-control custom-radio  custom-control-inline">
																	<input type="radio" class="custom-control-input"
																		id="customRadio2" name="example1" value="fail">
																	<label class="custom-control-label" for="customRadio2">FAIL</label>
																</div>
															</td>
															<td><form:select path="operator" id="select2"
																	class="form-control" disabled="true">
																	<form:option value="">Select operator</form:option>
																	<form:option value="=>"> equal or grater than </form:option>
																	<form:option value="<="> less than or equal </form:option>
																	<form:option value=">"> grater than </form:option>
																	<form:option value="<"> less than </form:option>
																</form:select></td>
															<td><form:input path="limitValue" id="input2"
																	placeholder="00.00" class="form-control"
																	maxlength="5" size="4" disabled="true" onkeypress="return onlyNumber(event)"/></td>
														</tr>
													</tbody>
												</table>
											</div>
										</div>
										<div class="row">
											<div class="col-lg">
												<h5>Limit Value in Range</h5>
		
												<table class="table table-borderless table-sm">
													<thead class="thead-light">
														<tr>
															<th></th>
															<th>Min<=</th>
															<th>Max=></th>
														</tr>
													</thead>
													<tbody>
														<tr>
															<td>
																<div
																	class="custom-control custom-radio  custom-control-inline">
																	<input type="radio" class="custom-control-input"
																		id="customRadio3" name="example2" checked="checked"
																		value="pass"> <label
																		class="custom-control-label" for="customRadio3">PASS</label>
																</div>
															</td>
															<td><form:input path="minValue" id="minValue1"
																	class="form-control" placeholder="00.00"
																	maxlength="5" size="4" onkeypress="return onlyNumber(event)"/></td>
															<td><form:input path="maxValue" id="maxValue1"
																	class="form-control" placeholder="00.00"
																	maxlength="5" size="4" onkeypress="return onlyNumber(event)"/></td>
														</tr>
														<tr>
															<td>
																<div
																	class="custom-control custom-radio  custom-control-inline">
																	<input type="radio" class="custom-control-input"
																		id="customRadio4" name="example2" value="fail">
																	<label class="custom-control-label" for="customRadio4">FAIL</label>
																</div>
															</td>
															<td><form:input path="minValue" id="minValue2"
																	class="form-control" placeholder="00.00"
																	maxlength="5" size="4" disabled="true" onkeypress="return onlyNumber(event)"/></td>
															<td><form:input path="maxValue" id="maxValue2"
																	class="form-control" placeholder="00.00"
																	maxlength="5" size="4" disabled="true" onkeypress="return onlyNumber(event)" /></td>
														</tr>
													</tbody>
												</table>
		
											</div>
										</div>
										
										<label for="plusTol">Tolerance</label>
										<div class="row">
											<div class="col-lg-3">
												<div class="input-group">												
													<form:input path="tolerance" id="plusTol" type="text" class="form-control input-border-bottom"/>
													<div class="input-group-append">
														<span class="input-group-text">%</span>
													</div>							
												</div>
											</div>
										</div>
										
										<br>
										<button type="submit" class="btn btn-success"
											onclick="return Validate()">Save</button>
										<button type="reset" class="btn btn-warning">Clear</button>
									</form:form>
									
								</div>
								<!-- End of card column 1 -->
								
								<div class="col-lg-6">
									<div class="table-responsive">
									<table id="proDetailsTable" class="display table table-bordered table-hover" cellspacing="0" width="100%">
										<thead>
											<tr>
												<th>Profile</th>
												<th>Test Type</th>
												<th>Code</th>
												<th>Category</th>
												<th>Limit</th>
												<th>Min</th>
												<th>Max</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${testProfileDetails}" var="tpd">
												<tr>
													<td>${tpd.ck_testProfileDetailId.testProfileHeaderID.testProfileName}</td>
													<td>${tpd.ck_testProfileDetailId.parameterCode.ck_paraCodeId.testType.type}</td>
													<td>${tpd.ck_testProfileDetailId.parameterCode.ck_paraCodeId.code}</td>
													<td>${tpd.ck_testProfileDetailId.vehicleCat.vehicleCategory}</td>
													<td>${tpd.limitValue}</td>
													<td>${tpd.minValue}</td>
													<td>${tpd.maxValue}</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
									</div>

								</div>
								<!-- End of card column 2 -->
								
							</div>
							<!-- End of card row -->
							
							
						</div>
						<!-- End of card body -->
					</div>
					<!-- End of card-->
				
				
				</div>	
			</div>	
			<%@include file="../WEB-INF/jsp/footer.jsp"%>			
		</div>
	</div>
<%@include file="../WEB-INF/jsp/commJs.jsp"%>

<!-- Page level custom scripts -->
	<script src="resources/ajax/limit-values.js" type="text/javascript"></script>
	
	<script>
		$(document).ready(function(){
		  $('[data-toggle="tooltip"]').tooltip();
		  
		    $('#proDetailsTable').DataTable( {
		    	//"scrollY": "400px",
		    	"processing": true,
		    	"order": [[ 0, "desc" ]],
		        "columnDefs": [{ "orderable": false, "targets": 4 },
		        				{ "orderable": false, "targets": 5 },
		        				{ "orderable": false, "targets": 6 }]
		    } );
		});

	</script>

	
	<script type="text/javascript">
		$(document).ready(function() {
			$('input[type=radio][name="example1"]').change(function() {
				//alert($(this).val()); // or this.value

				var rs = this.value;
				if (rs == "pass") {
					document.getElementById("select2").disabled = true;
					document.getElementById("input2").disabled = true;
					document.getElementById("select2").value = "";
					document.getElementById("input2").value = "";
					document.getElementById("select1").disabled = false;
					document.getElementById("input1").disabled = false;
				} else {
					document.getElementById("select1").disabled = true;
					document.getElementById("input1").disabled = true;
					document.getElementById("select1").value = "";
					document.getElementById("input1").value = "";
					document.getElementById("select2").disabled = false;
					document.getElementById("input2").disabled = false;
				}

			});

		});
	</script>

	<script type="text/javascript">
		$(document).ready(function() {
			$('input[type=radio][name="example2"]').change(function() {
				//alert($(this).val()); // or this.value

				var rs = this.value;
				if (rs == "pass") {
					document.getElementById("minValue2").disabled = true;
					document.getElementById("maxValue2").disabled = true;
					document.getElementById("minValue2").value = "";
					document.getElementById("maxValue2").value = "";
					document.getElementById("minValue1").disabled = false;
					document.getElementById("maxValue1").disabled = false;
				} else {
					document.getElementById("minValue1").disabled = true;
					document.getElementById("maxValue1").disabled = true;
					document.getElementById("minValue1").value = "";
					document.getElementById("maxValue1").value = "";
					document.getElementById("minValue2").disabled = false;
					document.getElementById("maxValue2").disabled = false;
				}

			});
		});
	</script>

	<script type="text/javascript">
		function Validate() {
			var profile = document.getElementById("testProfile").value;
			var type = document.getElementById("testType").value;
			var catID = document.getElementById("vehicleCateory").value;
			var paraCode = document.getElementById("paraCode").value;

			if (profile == "0") {
				//Swal.fire('Please select a test profile!', '', 'info')
				alert("Please select a test profile !");
				return false;
			} else if (type == "") {
				//Swal.fire('Please select a test type!', '', 'info')
				alert("Please select a test type !");
				return false;
			} else if (paraCode == "") {
				//Swal.fire('Please select a test point!', '', 'info')
				alert("Please select a code !");
				return false;
			} else if (catID == "") {
				//Swal.fire('No defined Paramneters!', '', 'warning')
				alert("Please select a vehicle cateory !");
				return false;
			}

			return true;
		}

		function onlyNumber(evt) {
			var keyCode = (evt.which) ? evt.which : evt.keyCode
			
			if ( (keyCode != 8 || keyCode ==32 ) && (keyCode < 48 || keyCode > 57))
				return false;
		}

	</script>
	
</body>
</html>
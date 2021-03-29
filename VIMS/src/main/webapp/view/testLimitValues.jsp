<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ page isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html lang="en">
<head>
	<%@include file="../WEB-INF/jsp/head.jsp"%>
<style>
	#hidden-panel {
		display: none;
	}	
</style>
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
				
<!-- 				<a href="#" class="btn btn-sm btn-success pull-right" data-toggle="modal" 
						data-target="#exampleModalCenter">Mandatory Test Types</a>
					<a href='' data-toggle='modal' data-target='#printingOrderModal'>
						<i class='fas fa-cog'></i>
					</a> -->
					
					<div class="dropdown pull-right">
					  <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					    More
					  </button>
					  <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
					    <a class="dropdown-item" href="#" data-toggle="modal" data-target="#exampleModalCenter">Mandatory Test Types</a>
					    <a class="dropdown-item" href="#" data-toggle='modal' data-target='#printingOrderModal'>Test Wise Print Order</a>
					  </div>
					</div>
									
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
									<strong>Success!</strong> Test Profile Successfully Updated.
								</div>
							</c:if>
							<c:if test="${success ==0}">
								<div class="alert alert-danger alert-dismissible">
									<button type="button" class="close" data-dismiss="alert">&times;</button>
									<strong>Warning!</strong>Something went wrong ! Please try
									again!
								</div>
							</c:if>
							
							<form:form action="saveLimitValues" method="POST" modelAttribute="limitValues">
							<div class="row">
								<div class="col-lg">
		
										<div class="form-group row">
											<div class="col-lg">
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
											<div class="col-lg">
												<div class="form-group form-floating-label">
													<form:select id="testType" class="form-control input-border-bottom"
														onchange="getTestCodes4(this.value);showHide();" required="required" path="ck_testProfileDetailId.parameterCode.ck_paraCodeId.testType.typeId">
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
											<div class="col-lg">
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
											<div class="col-lg">
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
										<div class="form-group-row">
											<div class="col-lg">
												<div id="hidden-panel">
													<div class="form-group form-floating-label">
														<form:select id="vSubCat" class="form-control input-border-bottom" 
															required="required" path="ck_testProfileDetailId.subCategoryID.subCategoryID">
															<option value="0">N/A</option>
															<c:forEach items="${vehicleSubCat}" var="vSubCat">
																<c:if test = "${vSubCat.subCategoryID != '0'}">
																	<form:option value="${vSubCat.subCategoryID}">${vSubCat.description}</form:option>
																</c:if>
															</c:forEach>
														</form:select>
														<label for="vSubCat" class="placeholder">Select speed category</label>
													</div>
												</div>
											</div>
										</div>
										<div class="form-group row">
											<div class="col-lg">
												<div class="form-group form-floating-label">
													<form:select id="rule" class="form-control input-border-bottom" 
														required="required" path="ck_testProfileDetailId.testLimitRule.ruleCode">
														<option></option>
														<c:forEach items="${rules}" var="rule">
															<form:option value="${rule.ruleCode}">${rule.ruleName}</form:option>
														</c:forEach>
													</form:select>
													<label for="rule" class="placeholder">Select limit rule</label>
												</div>
											</div>
										</div>
									
								</div>
								<!-- End of row 1 column 1 -->
								
								<div class="col-lg">
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
																	placeholder="0" class="form-control"
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
																	placeholder="0" class="form-control"
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
																	class="form-control" placeholder="0"
																	maxlength="5" size="4" onkeypress="return onlyNumber(event)"/></td>
															<td><form:input path="maxValue" id="maxValue1"
																	class="form-control" placeholder="0"
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
																	class="form-control" placeholder="0"
																	maxlength="5" size="4" disabled="true" onkeypress="return onlyNumber(event)"/></td>
															<td><form:input path="maxValue" id="maxValue2"
																	class="form-control" placeholder="0"
																	maxlength="5" size="4" disabled="true" onkeypress="return onlyNumber(event)" /></td>
														</tr>
													</tbody>
												</table>
		
											</div>
										</div>
										
										<label for="plusTol">Tolerance (%)</label>
										<div class="row">
											<div class="col-lg-3">
												<div class="input-group">												
													<form:input path="tolerance_plus" id="plusTol" type="text" class="form-control input-border-bottom"/>
													<div class="input-group-append">
														<span class="input-group-text">+</span>
													</div>							
												</div>
											</div>										
											<div class="col-lg-3">
												<div class="input-group">												
													<form:input path="tolerance_minus" id="minusTol" type="text" class="form-control input-border-bottom"/>
													<div class="input-group-append">
														<span class="input-group-text">-</span>
													</div>							
												</div>
											</div>
										</div>										
										<br>
										<button type="submit" class="btn btn-success"
											onclick="return Validate()">Save</button>
										<button type="reset" class="btn btn-warning">Clear</button>
										<br>
								</div>
								<!-- End of row 1 column 2 -->
								
							</div>
							<!-- End of card row 1 -->
							
							</form:form>
							
							<div class="row">
								<div class="col-lg">
									<div class="table-responsive">
									<table id="proDetailsTable" class="display table table-bordered table-hover" cellspacing="0" width="100%">
										<thead>
											<tr>
												<th>Profile</th>
												<th>Test Type</th>
												<th>Code</th>
												<th>Category</th>
												<th>Speed Category</th>
												<th>Limit Rule</th>
												<th>Operator</th>
												<th>Limit</th>
												<th>Min</th>
												<th>Max</th>
												<th>Tolerance (+)</th>
												<th>Tolerance (-)</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${testProfileDetails}" var="tpd">
												<tr>
													<td>${tpd.ck_testProfileDetailId.testProfileHeaderID.testProfileName}</td>
													<td>${tpd.ck_testProfileDetailId.parameterCode.ck_paraCodeId.testType.type}</td>
													<td>${tpd.ck_testProfileDetailId.parameterCode.ck_paraCodeId.code}</td>
													<td>${tpd.ck_testProfileDetailId.vehicleCat.vehicleCategory}</td>
													<td>${tpd.ck_testProfileDetailId.subCategoryID.description}</td>
													<td>${tpd.ck_testProfileDetailId.testLimitRule.ruleName}</td>
													<td>${tpd.operator}</td>
													<td>${tpd.limitValue}</td>
													<td>${tpd.minValue}</td>
													<td>${tpd.maxValue}</td>
													<td>${tpd.tolerance_plus}</td>
													<td>${tpd.tolerance_minus}</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
									</div>

								</div>
								<!-- End of row 2 column 1 -->
							</div>
							<!-- End of card row 2 -->
							
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
		    	//"order": [[ 0, "desc" ]],
		        "columnDefs": [{ "orderable": false, "targets": 4 },
		        				{ "orderable": false, "targets": 5 },
		        				{ "orderable": false, "targets": 6 },
		        				{ "orderable": false, "targets": 7 },
		        				{ "orderable": false, "targets": 8 },
		        				{ "orderable": false, "targets": 9 },
		        				{ "orderable": false, "targets": 10 },
		        				{ "orderable": false, "targets": 11 }]
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

		/*function onlyNumber(evt) {
			var keyCode = (evt.which) ? evt.which : evt.keyCode
			
			if ( (keyCode != 8 || keyCode ==32 ) && (keyCode < 48 || keyCode > 57))
				return false;
		}*/

	</script>

	<!-- Modal -->
	<div class="modal fade" id="exampleModalCenter" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalCenterTitle"
		aria-hidden="true">
		
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLongTitle">Mandatory
						Test Types</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<form name="ProfileStatusForm" id="ProfileStatusForm" action="saveProfileStatus"
					method="GET">
					<div class="modal-body">

						<div class="alert alert-success alert-dismissible" style="display: none;" id="saveMessage">
							<button type="button" class="close" data-dismiss="alert">&times;</button>
							<strong>Success!</strong> Data Successfully Saved.
						</div>
						<div class="alert alert-success alert-dismissible" style="display: none;" id="updateMessage">
							<button type="button" class="close" data-dismiss="alert">&times;</button>
							<strong>Success!</strong> Data Successfully Updated.
						</div>
						<div class="alert alert-danger alert-dismissible" style="display: none;" id="errorMessage">
							<button type="button" class="close" data-dismiss="alert">&times;</button>
							<strong>Warning!</strong>Something went wrong ! Please try
							again!
						</div>

						<div class="form-group row">
							<div class="col-lg-6">
								<select id="testProfile" class="form-control"
									required name="profile_id">
									<option value="0">Select test profile...</option>
									<c:forEach items="${testProfile}" var="testProfile">
										<option value="${testProfile.testProfileID}">${testProfile.testProfileName}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="form-group row">
							<div class="col-lg-6">
								<select class="form-control"
									required name="type_id">
									<option value="">Select test type...</option>
									<c:forEach items="${testTypes}" var="testTypes">
										<option value="${testTypes.typeId}">${testTypes.type}</option>
									</c:forEach>
								</select>
							</div>
<!-- 							<div class="col-lg">
								<div class="form-inline">
									<label for="ordering_no" class="mr-sm-2">Serial No</label>
									<select class="custom-select custom-select-sm" name="serial_no" required>
										<option value=1 selected>1</option>
										<option value=2 >2</option>
										<option value=3 >3</option>
										<option value=4 >4</option>
										<option value=5 >5</option>
										<option value=6 >6</option>
									</select>
									<a href="#" data-toggle="tooltip" 
										title="The test result report is printed in the order of serial number of the test type">
									<i class="fa fa-question-circle" style="font-size:14px"></i>
									</a>
								</div>
							</div> -->
						</div>
						
						<br>
						<div class="custom-control custom-radio custom-control-inline">
							<input type="radio" class="custom-control-input" id="mandatory"
								name="status" value=0 checked="checked"> <label
								class="custom-control-label" for="mandatory">Mandatory</label>
						</div>
						<div class="custom-control custom-radio custom-control-inline">
							<input type="radio" class="custom-control-input"
								id="nonmandatory" name="status" value=1> <label
								class="custom-control-label" for="nonmandatory">Non-Mandatory</label>
						</div>
						<br>
						<br>
						<div style="height: 300px; overflow: auto;">
							<table class="table table-sm" id="profileStatus">
								<thead>
									<tr>
										<th>Profile</th>
										<th>Test Type</th>
										<th>Mandatory</th>
<!-- 										<th>Serial No</th> -->
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${testProfileStatus}" var="status">
										<tr>
											<td>${status.profile_id.testProfileName}</td>
											<td>${status.type_id.type}</td>
											<td><c:if test="${status.status==0}">
													<i class="fa fa-check-circle"
														style="font-size: 24px; color: green"></i>
												</c:if> <c:if test="${status.status==1}">
													<i class="fa fa-times-circle"
														style="font-size: 24px; color: red"></i>
												</c:if>
											</td>
<%-- 											<td>${status.serial_no}</td> --%>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>

					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-warning"
							data-dismiss="modal">Close</button>
						<button type="submit" class="btn btn-success">Save
							Changes</button>
					</div>
				</form>
			</div>
		</div>
	</div>

<script>
function showHide() {
    let testType = document.getElementById('testType')

    if (testType.value == "37000-37999-1") {
        document.getElementById('hidden-panel').style.display = 'block'
    } else {
        document.getElementById('hidden-panel').style.display = 'none'
    }
}
</script>

	<!-- Modal -->
	<div class="modal fade" id="printingOrderModal" tabindex="-1"
		role="dialog" aria-labelledby="printingOrderModalTitle"
		aria-hidden="true">
		
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="printingOrderModalLongTitle">Test Wise Printing Order</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<form name="testWisePrintOrderForm" id="testWisePrintOrderForm" method="POST">
					<div class="modal-body">

						<div style="height: 300px; overflow: auto;">
							<table class="table table-sm" id="">
								<thead>
									<tr>
										<th>Profile</th>
										<th>Test Type</th>
										<th>Printing Order</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${testWisePrintOrder}" var="order">
										<tr>
											<td>
												${order.ck_testWisePrintOrderId.testProfile.testProfileName}
												<input type="hidden" name="profile_id" value="${order.ck_testWisePrintOrderId.testProfile.testProfileID}"> 
											</td>
											<td>
												${order.ck_testWisePrintOrderId.testType.type}
												<input type="hidden" name="type_id" value="${order.ck_testWisePrintOrderId.testType.typeId}">
											</td>
											<td>
												<select class="form-control" name="print_order">
												
													<c:forEach var="j" begin="1" end="6">
														<c:if test="${order.printingOrder == j}">
															<option value="${j}" selected>${j}</option>

														</c:if>
														<c:if test="${order.printingOrder != j}">
															<option value="${j}">${j}</option>

														</c:if>
													</c:forEach>
													
												</select>
											</td>
										</tr>
										<input type="hidden" name="reportPath" value="${order.reportPath}">
									</c:forEach>
								</tbody>
							</table>
						</div>

					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-warning"
							data-dismiss="modal">Close</button>
						<button type="button" class="btn btn-success" onclick="saveTestWisePrintOrder()">Save
							Changes</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	
<script type="text/javascript">

function saveTestWisePrintOrder() {
	var request_method = $("#testWisePrintOrderForm").attr("method"); //get form GET/POST method
	
	// Get form
	var form = $('#testWisePrintOrderForm')[0];

	// Create an FormData object
	var data = new FormData(form);
	
	$.ajax({
		url : "saveTestWisePrintOrder",
		type : request_method,
		data : data,
		processData : false,
		contentType : false,
		cache : false,
		success : function(data) {
 			if (data == "1") {
 				alert("Print Order is changed successfully !");
				
 			}else{
 				alert("Please try again !");
 			}
 			
		}

	});
	
}
</script>
</body>
</html>
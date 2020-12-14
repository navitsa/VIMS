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
						<div class="card-header py-3">
			                <div class="row">
			                	<div class="col-sm-8">
			                		<h6 class="m-0 font-weight-bold text-primary">Set Codes & Limit Values</h6>
			                	</div>
			                
				                <div class="col-sm-4">
									 <div class="dropdown float-right">
									  <button type="button" class="btn btn-sm" data-toggle="dropdown">
									   <i class="fa fa-ellipsis-v" style="font-size:22px;color:blue"></i>
									  </button>
									  <div class="dropdown-menu">
									    <a href="#" class="dropdown-item" data-toggle="modal" data-target="#exampleModalCenter">Mandatory Test Types</a>
									  </div>
									</div>
				                </div>
			                </div>					
						</div>
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

								<div class="form-group row">
									<div class="col-lg-3">
										<select id="testProfile" class="custom-select custom-select-sm" 
											required="required">
											<option value="0">Select test profile...</option>
											<c:forEach items="${testProfile}" var="testProfile">
												<option value="${testProfile.testProfileID}">${testProfile.testProfileName}</option>
											</c:forEach>
										</select>
									</div>
								</div>
							<form:form action="setLimitValues" method="POST" modelAttribute="limitValues">
								
							<div class="form-group row">
								<div class="col-lg-3">
									<form:select id="testType" class="custom-select custom-select-sm"
										onchange="getTestPoints(this.value)" required="required" path="testType.typeId">
										<form:option value="">Select test type...</form:option>
										<c:forEach items="${testTypes}" var="testTypes">
											<form:option value="${testTypes.typeId}">${testTypes.type}</form:option>
										</c:forEach>
									</form:select>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-lg-3">
									<form:select id="testPoint" class="custom-select custom-select-sm"
										onchange="getTestCodes3(this.value)" required="required" path="testPoint.testPointID">
										<form:option value="">Select test point...</form:option>
										<c:forEach items="${testPoints}" var="testPoints">
											<form:option value="${testPoints.testPointID}">${testPoints.testPointName}</form:option>
										</c:forEach>
									</form:select>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-lg-3">
									<form:select id="testPara" class="custom-select custom-select-sm"
										onchange="getTestAngles(this.value)" path="testParameter.testParameterId">
										<form:option value="">Select test parameter...</form:option>
										<c:forEach items="${testParameters}" var="testParameters">
											<form:option value="${testParameters.testParameterId}">${testParameters.paraName}</form:option>
										</c:forEach>
									</form:select>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-lg-3">
									<form:select id="testAngle" class="custom-select custom-select-sm"
										onchange="getTestCodes2(this.value)" path="testParameterAngle.paraAngleID">
										<form:option value="">Select parameter direction...</form:option>
										<c:forEach items="${parameterAngles}" var="paraAngles">
											<form:option value="${paraAngles.paraAngleID}">${paraAngles.angleName}</form:option>
										</c:forEach>
									</form:select>
								</div>
							</div>
	
							<div class="form-group row">
								<div class="col-lg-3">
									<form:input path="code" id="paraCode" class="form-control form-control-sm" placeholder="Code"/>
								</div>
								<div class="col-lg-6">
									<%-- <form:textarea path="description" class="form-control form-control-sm" placeholder="Description"/> --%>
								</div>
							</div>

								<div class="row">
									<div class="col-lg-6">

										<h5>Single Limit Value <a href="#" data-toggle="tooltip" title="If you want to get pass fail status depending on your preference, you can set limit values, 
											otherwise please skip it and save the code.">
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
															class="custom-select custom-select-sm">
															<form:option value="">Select operator</form:option>
															<form:option value="=>"> equal or grater than </form:option>
															<form:option value="<="> less than or equal </form:option>
															<form:option value=">"> grater than </form:option>
															<form:option value="<"> less than </form:option>
														</form:select>
													</td>
													<td>
														<form:input path="limitValue" id="input1"
															placeholder="00.00" class="form-control form-control-sm"
															maxlength="5" size="4"/>
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
															class="custom-select custom-select-sm" disabled="true">
															<form:option value="">Select operator</form:option>
															<form:option value="=>"> equal or grater than </form:option>
															<form:option value="<="> less than or equal </form:option>
															<form:option value=">"> grater than </form:option>
															<form:option value="<"> less than </form:option>
														</form:select></td>
													<td><form:input path="limitValue" id="input2"
															placeholder="00.00" class="form-control form-control-sm"
															maxlength="5" size="4" disabled="true"/></td>
												</tr>
											</tbody>
										</table>
									</div>

									<div class="col-lg-6">
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
															class="form-control form-control-sm" placeholder="00.00"
															maxlength="5" size="4"/></td>
													<td><form:input path="maxValue" id="maxValue1"
															class="form-control form-control-sm" placeholder="00.00"
															maxlength="5" size="4"/></td>
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
															class="form-control form-control-sm" placeholder="00.00"
															maxlength="5" size="4" disabled="true"/></td>
													<td><form:input path="maxValue" id="maxValue2"
															class="form-control form-control-sm" placeholder="00.00"
															maxlength="5" size="4" disabled="true"/></td>
												</tr>
											</tbody>
										</table>

									</div>
								</div>
								<button type="submit" class="btn btn-success"
									onclick="return Validate()">Save</button>
								<button type="reset" class="btn btn-warning">Clear</button>
								<br>
								<br>
							</form:form>

								<table class="display" id="example" style="width:100%">
									<thead>
										<tr>
											<th>Code</th>
											<th>Test Type</th>
											<th>Test Point</th>
											<th>Test Parameter</th>
											<th>Direction</th>
											<th>Limit</th>
											<th>Min</th>
											<th>Max</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${paraCodes}" var="paraCodes">
											<tr>
												<td>${paraCodes.code}</td>
												<td>${paraCodes.testType.type}</td>
												<td>${paraCodes.testPoint.testPointName}</td>
												<td>${paraCodes.testParameter.paraName}</td>
												<td>${paraCodes.testParameterAngle.angleName}</td>
												<td>${paraCodes.limitValue}</td>
												<td>${paraCodes.minValue}</td>
												<td>${paraCodes.maxValue}</td>
												<%-- <td><a href="editLimits?code=${paraCodes.code}"><i
														class="material-icons">&#xE254;</i></a></td> --%>
											</tr>
										</c:forEach>
									</tbody>
								</table>

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
		});
	</script>
	
   <script src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
	<script>
	$(document).ready(function() {
	    $('#example').DataTable( {
	    	"scrollY": "400px",
	    	"processing": true
	    } );
	} );
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
			var point = document.getElementById("testPoint").value;
			var paraCode = document.getElementById("paraCode").value;

			if (profile == "0") {
				//Swal.fire('Please select a test profile!', '', 'info')
				alert("Please select a test profile !");
				return false;
			} else if (type == "") {
				//Swal.fire('Please select a test type!', '', 'info')
				alert("Please select a test type !");
				return false;
			} else if (point == "") {
				//Swal.fire('Please select a test point!', '', 'info')
				alert("Please select a test point !");
				return false;
			} else if (paraCode == "") {
				//Swal.fire('No defined Paramneters!', '', 'warning')
				alert("No defined Paramneters !");
				return false;
			}

			return true;
		}
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
								<select id="testProfile" class="custom-select custom-select-sm"
									required="required" name="profile_id">
									<option value="0">Select test profile...</option>
									<c:forEach items="${testProfile}" var="testProfile">
										<option value="${testProfile.testProfileID}">${testProfile.testProfileName}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="form-group row">
							<div class="col-lg-6">
								<select class="custom-select custom-select-sm"
									required="required" name="type_id">
									<option value="">Select test type...</option>
									<c:forEach items="${testTypes}" var="testTypes">
										<option value="${testTypes.typeId}">${testTypes.type}</option>
									</c:forEach>
								</select>
							</div>
							<div class="col-lg">
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
							</div>
						</div>

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
										<th>Serial No</th>
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
											<td>${status.serial_no}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>

					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Close</button>
						<button type="submit" class="btn btn-success">Save
							changes</button>
					</div>
				</form>
			</div>
		</div>
	</div>

<script type="text/javascript">

$("#ProfileStatusForm").submit(function(event) {
    event.preventDefault(); //prevent default action 
    let post_url = $(this).attr("action"); //get form action url
    let request_method = $(this).attr("method"); //get form GET/POST method
    let form_data = $(this).serialize(); //Encode form elements for submission	
    $.ajax({
        url: post_url,
        type: request_method,
        data: form_data
      }).done(function(data) { //
        //$("#server-results").html(response);
      	//alert(data.success);
      	$("#profileStatus tbody").empty();
		for(var i=0; i<data.profile_status_list.length; i++){
			if(data.profile_status_list[i].status==0){
				var markup = "<tr><td>"+data.profile_status_list[i].profile_id.testProfileName+"</td><td>"+data.profile_status_list[i].type_id.type+"</td><td><i class='fa fa-check-circle' style='font-size: 24px; color: green'></i></td><td>"+data.profile_status_list[i].serial_no+"</td></tr>";
			}else{
				var markup = "<tr><td>"+data.profile_status_list[i].profile_id.testProfileName+"</td><td>"+data.profile_status_list[i].type_id.type+"</td><td><i class='fa fa-times-circle' style='font-size: 24px; color: red'></i></td><td>"+data.profile_status_list[i].serial_no+"</td></tr>";
			}
			
       		 $("#profileStatus tbody").append(markup);
       	 }
		if(data.success==0){
			 $('#saveMessage').show();
			 $('#updateMessage').hide();
			 $('#errorMesssage').hide();
		}else if(data.success==1){
			$('#updateMessage').show();
			$('#saveMessage').hide();
			$('#errorMesssage').hide();
		}else{
			$('#errorMesssage').show();
			$('#saveMessage').hide();
			$('#updateMessage').hide();
		}
      });
  });

</script>
</body>
</html>
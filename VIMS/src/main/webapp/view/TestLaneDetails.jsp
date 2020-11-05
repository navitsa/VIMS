<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ page isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>



<html lang="en">
<head>
	<%@include file="../WEB-INF/jsp/head.jsp"%>
	
	
	<style type="text/css">
 .tabfont{
          font-family: Arial, Helvetica, sans-serif;
          font-size: 8px;
 }

		      .fontst{
         font-family: Arial, Helvetica, sans-serif;
          font-size: 12px;
           height: 30px;
         }
	         .l-fontst{
         font-family: Arial, Helvetica, sans-serif;
          font-size: 12px;
          height: 5px;
          margin-top: 0px;
         }
		.tabStyle{
         font-family: Arial, Helvetica, sans-serif;
          font-size: 12px;
          height: 280px;
		}
		.tabStyle2{
         font-family: Arial, Helvetica, sans-serif;
          font-size: 12px;
         height: 130px;
		}
		
		
		.tabcontent {
  display: none;
  padding: 6px 12px;
  border: 1px solid #ccc;
  border-top: none;
 
}
		
	/* Style the tab */
.tab {
  overflow: hidden;
  border: 1px solid #ccc;
  background-color: #f1f1f1;
}

/* Style the buttons inside the tab */
.tab button {
  background-color: inherit;
  float: left;
  border: none;
  outline: none;
  cursor: pointer;
  padding: 9px 9px;
  transition: 0.3s;
  font-size: 12px;
}

/* Change background color of buttons on hover */
.tab button:hover {
  background-color: #ddd;
}

/* Create an active/current tablink class */
.tab button.active {
  background-color: #ccc;
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
					
						<h1 class="h3 mb-4 text-gray-800">Configure Test Lane for ${testLaneDetails.testLaneHeadId.laneName}</h1>
			
							<div  class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
							
								<div class="col-xl-6 col-md-6mb-4" style="height: 500px">
									<div class="card border-left-primary shadow h-100 py-2">
										<div class="card-body">
									
									<div class="tab">
										 
										  <button class="tablinks tabfont" onclick="openCity(event, 'Category')">Test Category</button>
										  <button class="tablinks tabfont" onclick="openCity(event, 'VehicleClass')">Vehicle Class</button>
										   <button class="tablinks tabfont" onclick="openCity(event, 'Equipment')">Equipment</button>
									</div>	
										
										
										
										
										
				<div class="row no-gutters align-items-center tabcontent" id="Equipment" >
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
												
					<form:form action="testDetailsAction" modelAttribute="testLaneDetails" method="POST">
						
						<form:input class="form-control form-control-user" path="centerID.center_ID" hidden="true" id="cenid"/>
													
						<form:input class="form-control form-control-user" path="testLaneHeadId.testLaneHeadId" hidden="true" />							
													
						<form:input class="form-control form-control-user" path="testLaneDetailsid" readonly="true" hidden="true" />

						<br>


						<div class="form-group row">
							<div class="col-sm-4">
								<label class="l-fontst">Test Type</label>
							</div>
							<div class="col-sm-6">
								<form:select class="form-control form-control-user fontst"
									path="testType" required="sd" id="testType" onchange="getEqupmentType()">
									<form:option value="">- Select Test Lane -</form:option>
									<c:forEach items="${testtypeList}" var="lane1">
										<form:option value="${lane1.typeId}">${lane1.type}</form:option>
									</c:forEach>
								</form:select>
							</div>	
						</div>						
						
						<div class="form-group row">
							<div class="col-sm-4">
								<label class="card-title text-primary l-fontst">Equipment Selection</label>
							</div>
							<div class="col-sm-6">
	
							</div>	
						</div>

						<div class="form-group row">
							<div class="col-sm-4">
								<label class="l-fontst">Equipment Class</label>
							</div>
							<div class="col-sm-6">
								<form:select class="form-control form-control-user fontst"
									path="eqTypeid" id="eqTypeid" onchange="getModel()" required="sd">
								</form:select>
							</div>	
						</div>	

						<div class="form-group row">
							<div class="col-sm-4">
								<label class="l-fontst">Equipment Make</label>
							</div>
							<div class="col-sm-6">
								<form:select class="form-control form-control-user fontst" id="eqMakeID"
																		path="eqMakeID" onchange="getModel()"
																		required="sd">
																		<form:option value="">- Select Equipment Make -</form:option>
																		<c:forEach items="${eqMakeCmbforLane}" var="tp">
																			<form:option value="${tp.eqMakeID}">${tp.eqMake}</form:option>
																		</c:forEach>
																	</form:select>
							</div>	
						</div>

						<div class="form-group row">
							<div class="col-sm-4">
								<label class="l-fontst">Equipment Model</label>
							</div>
							<div class="col-sm-6">
								<form:select class="form-control form-control-user fontst"
																		id="eqModelID" path="eqModelID"
																		onchange="getEqupmentMa()" required="sd">
																		<form:option value="">- Select Equipment Model -</form:option>

																	</form:select>
							</div>	
						</div>

						<div class="form-group row">
							<div class="col-sm-4">
								<label class="l-fontst">Equipment</label>
							</div>
							<div class="col-sm-6">
								<form:select class="form-control form-control-user fontst"
										id="equipmentID" path="equipmentID"
										onchange="getSerialNo(this.value)" required="sd">
									<form:option value="">- Select Equipment -</form:option>
								</form:select>
							</div>	
						</div>													
												



										<div class="row">	
									<div class="col-sm-2 ">	
										<input type="submit" class="btn btn-primary btn-sm"
														value="Save">
									</div>		
									<div class="col-sm-5 ">	
										<a class="btn btn-primary btn-sm" href="createNewTestLanes">Back</a>
									</div>
						</div>
																			
												
												
												
												
												
												
												
													</form:form>












												</div>

											</div>
											
<!-- 		***********************************************************************************************									 -->
											
											
											
							<div class="row no-gutters align-items-center tabcontent" id="Category" >
												<div class="col mr-2">
												<c:if test="${success1 ==1}">
														<div class="alert alert-success alert-dismissible">
															<button type="button" class="close" data-dismiss="alert">&times;</button>
															<strong>Success!</strong> Data Successfully Saved.
														</div>
													</c:if>
													<c:if test="${success1 ==0}">
														<div class="alert alert-danger alert-dismissible">
															<button type="button" class="close" data-dismiss="alert">&times;</button>
															<strong>Warning!</strong>Something went wrong ! Please
															try again!
														</div>
													</c:if>
												
											<form:form action="saveLaneHeadCategory" modelAttribute="addLaneHeadCategory" method="POST">
												
																			
												<form:input class="form-control form-control-user" path="testLaneHeadId.testLaneHeadId"  hidden="true" />							
					
												<br>
						
						
												<div class="form-group row">
													<div class="col-sm-4">
														<label class="l-fontst">Test Category</label>
													</div>
													<div class="col-sm-6">
														<form:select class="form-control form-control-user fontst"
															path="categoryId.categoryId" required="sd" id="testcat" >
															<form:option value="">- Select Test Category -</form:option>
															<c:forEach items="${regCatTypeList}" var="cat">
																<form:option value="${cat.categoryId}">${cat.categoryType}</form:option>
															</c:forEach>
														</form:select>
													</div>	
												</div>						
												
											<div class="row">	
															<div class="col-sm-2 ">	
																<input type="submit" class="btn btn-primary btn-sm"
																				value="Save">
															</div>		
															<div class="col-sm-5 ">	
																<a class="btn btn-primary btn-sm" href="createNewTestLanes">Back</a>
															</div>
												</div>
																			
							
												
													</form:form>

												</div>

											</div>								
											
<!-- 			***************************************************************************************************************								 -->
											

									<div class="row no-gutters align-items-center tabcontent" id="VehicleClass" >
												<div class="col mr-2">
												<c:if test="${success3 ==2}">
														<div class="alert alert-success alert-dismissible">
															<button type="button" class="close" data-dismiss="alert">&times;</button>
															<strong>Success!</strong> Data Successfully Saved.
														</div>
													</c:if>
													<c:if test="${success2 ==0}">
														<div class="alert alert-danger alert-dismissible">
															<button type="button" class="close" data-dismiss="alert">&times;</button>
															<strong>Warning!</strong>Something went wrong ! Please
															try again!
														</div>
													</c:if>
												
											<form:form action="saveLaneHeadVehicleClass" modelAttribute="addLaneHeadVehicleClass" method="POST">
												
																			
												<form:input class="form-control form-control-user" path="testLaneHeadId.testLaneHeadId" hidden="true"  />							
					
												<br>
						
						
												<div class="form-group row">
													<div class="col-sm-4">
														<label class="l-fontst">Vehicle Class</label>
													</div>
													<div class="col-sm-6">
														<form:select class="form-control form-control-user fontst"
															path="vehicleClassID.vehicleClassID" required="sd" id="testcat" >
															<form:option value="">- Select Vehicle Class -</form:option>
															<c:forEach items="${vclassLane}" var="vcla">
																<form:option value="${vcla.vehicleClassID}">${vcla.vehicleClass}</form:option>
															</c:forEach>
														</form:select>
													</div>	
												</div>						
												
											<div class="row">	
															<div class="col-sm-2 ">	
																<input type="submit" class="btn btn-primary btn-sm"
																				value="Save">
															</div>		
															<div class="col-sm-5 ">	
																<a class="btn btn-primary btn-sm" href="createNewTestLanes">Back</a>
															</div>
												</div>
																			
							
												
													</form:form>

												</div>

											</div>
											
											
											
											
											
<!-- 		*************************************************************************************************************									 -->
											
											
										</div>
									</div>
								</div>



<div class="col-xl-6 col-md-6mb-4" style="height: 500px">
									<div class="card border-left-primary shadow h-100 py-2">
										<div class="card-body">
											<div class="row no-gutters align-items-center">
												<div class="col mr-2">
	


<!-- id="example" class="display" -->
<table id="eqTypeTable" class="table table-striped table-bordered table-sm table-wrapper-scroll-y my-custom-scrollbar tabStyle"
														cellspacing="0">
	
		<thead>
		<tr>
		
		<th style="text-align: center; width: 200px"">Test Type</th>  	   		
   		<th style="text-align: center; width: 300px">Equipment</th>
   		<th>Serial No</th>
  		
		</tr>
		</thead>
		<tbody id="myTable">							                
		<c:forEach items="${testlanedetaisList}" var="testlanedetais">
		<tr>
   		<td>
   			<div style="float:left;">${testlanedetais.testType.type}</div>
   			<div style="float:right;">
   				<c:if test="${testlanedetais.testType.image != null}">
					<img src="data:image/jpg;base64,${testlanedetais.testType.imageView}" width="90" height="80" alt="No image" />
				</c:if>
			</div>  	
   		</td>  		   		
   		<td>
   			<div style="float:left;">${testlanedetais.equipmentID.eqModelID.eqMakeID.eqMake}-<br/>
   				${testlanedetais.equipmentID.eqModelID.eqModel}
   			</div>  		
   			<div style="float:right;"> 
   			 	<c:if test="${testlanedetais.equipmentID.equipmentImage != null}">	
					<img src="data:image/jpg;base64,${testlanedetais.equipmentID.equipmentImageView}" width="90" height="80" alt="No image" />   		      		
   				</c:if>
   			</div>  		
   		</td>
   		<td>
   			<div>${testlanedetais.equipmentID.serialNo}</div>
   		</td>

		</tr>
		</c:forEach>
		</tbody>
		</table>


												</div>
												
				

											</div>
											
			<div class="row no-gutters align-items-center">								
			<div class="col-sm-5">								
									
				<table class=" table table-bordered table-hover tabStyle2 table-wrapper-scroll-y my-custom-scrollbar" cellspacing="0">
										<thead>
											<tr>
												<th>Category</th>													
											</tr>
										</thead>
										<tbody id="myTable">
											<c:forEach items="${laneCategoryList}" var="cat">
												<tr>
													<td><div>${cat.categoryId.categoryType}</div></td>
												
												</tr>
											</c:forEach>
										</tbody>
					</table>
				
											
			</div>			
			<div class="col-sm-2">	
			</div>					
			<div class="col-sm-5">								
											
				<table class=" table table-bordered table-hover tabStyle2 table-wrapper-scroll-y my-custom-scrollbar" cellspacing="0">
										<thead>
											<tr>
												<th>Vehicle Class</th>
											</tr>
										</thead>
										<tbody id="myTable">
											<c:forEach items="${laneVehicleClassList}" var="vcla">
												<tr>
													<td><div>${vcla.vehicleClassID.vehicleClass}</div></td>
												
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

	<script>
//============================================================	
	
	function getEqupmentType() {
		var str = document.getElementById("testType").value;
		if (str == "") {
			//document.getElementById("txtHint").innerHTML="";
			var slctSubcat = $('#eqTypeid'), option = "";
			slctSubcat.empty();
			return;
			} else {
			$.ajax({
						type : 'GET',
						url : "geteqTypeidByTesTtyp",
						data : {"testType": str},
						success : function(data) {

							if(data!=""){
							
							var slctSubcat = $('#eqTypeid'), option = "";
							slctSubcat.empty();
							selected_option = ""
							slctSubcat.append(selected_option);

							for (var i = 0; i < data.length; i++) {
								option = option
										+ "<option value='"+data[i].eqTypeID + "'>"
										+ data[i].eqType + "</option>";
							}
							slctSubcat.append(option);
							}else{
								alert("Not assign Equipment Class");	
								
							}
							
							
							
						},
						error : function() {
							alert("error");
						}
						
					});
		}
	}	
	
	
	
	
	
	
//================================================================	
	function getModel() {
		var str = document.getElementById("eqMakeID").value;
		var eqTypeID = document.getElementById("eqTypeid").value;
		
		//document.getElementById("equipmentID").value = "";
		
		
			if (str == "") {
				document.getElementById("serialNo").value = "";

				//document.getElementById("txtHint").innerHTML="";
				var slctSubcat = $('#eqModelID'), option = "";
				slctSubcat.empty();
				return;
			} else {
				$.ajax({
							type : 'GET',
							url : "eqModleCmbforLane",
							data : {"eqTypeID" : eqTypeID, "eqMakeid" : str},
							success : function(data) {

								var slctSubcat = $('#eqModelID'), option = "";
								slctSubcat.empty();
								selected_option = "<option value='' selected>- Select Equipment Model -</option>"
								slctSubcat.append(selected_option);

								for (var i = 0; i < data.length; i++) {
									option = option
											+ "<option value='"+data[i].eqModelID + "'>"
											+ data[i].eqModel + "</option>";
								}
								slctSubcat.append(option);
							},
							error : function() {
								alert("error");
							}

						});
			}
		}
	
	function getEqupmentMa() {
		var str = document.getElementById("eqModelID").value;
		var center = document.getElementById("cenid").value;
		if (str == "") {
			//document.getElementById("txtHint").innerHTML="";
			var slctSubcat = $('#equipmentID'), option = "";
			slctSubcat.empty();
			return;
			} else {
			$.ajax({
						type : 'GET',
						url : "getEquipmentMa",
						data : {"eqModelID": str,"center":center},
						success : function(data) {

							
							var slctSubcat = $('#equipmentID'), option = "";
							slctSubcat.empty();
							selected_option = "<option value='' selected>- Select Equipment-</option>"
							slctSubcat.append(selected_option);

							for (var i = 0; i < data.length; i++) {
								option = option
										+ "<option value='"+data[i].equipmentID + "'>"
										+ data[i].serialNo + "</option>";
							}
							slctSubcat.append(option);
							
							
						},
						error : function() {
							alert("error");
						}

					});
		}
	}


	
	
	
	</script>
	<script>
	var i = 0;
	function move() {
	  if (i == 0) {
	    i = 1;
	    var elem = document.getElementById("myBar");
	    var width = 10;
	    var id = setInterval(frame, 10);
	    function frame() {
	      if (width >= 100) {
	        clearInterval(id);
	        i = 0;
	      } else {
	        width++;
	        elem.style.width = width + "%";
	        elem.innerHTML = width  + "%";
	      }
	    }
	  }
	}
	</script>
<script>
function openCity(evt, cityName) {
  var i, tabcontent, tablinks;
  tabcontent = document.getElementsByClassName("tabcontent");
  for (i = 0; i < tabcontent.length; i++) {
    tabcontent[i].style.display = "none";
  }
  tablinks = document.getElementsByClassName("tablinks");
  for (i = 0; i < tablinks.length; i++) {
    tablinks[i].className = tablinks[i].className.replace(" active", "");
  }
  document.getElementById(cityName).style.display = "block";
  evt.currentTarget.className += " active";
}
</script>	

</body>
</html>
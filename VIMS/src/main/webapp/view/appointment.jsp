<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ page isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>



<html lang="en">
<head>
	<%@include file="../WEB-INF/jsp/head.jsp"%>
	<link href="resources/css/appointmentForm.css" rel="stylesheet">
	
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/tempusdominus-bootstrap-4/5.1.2/css/tempusdominus-bootstrap-4.min.css"/>
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>

<style>

#overlay {
  position: fixed;
  display: none;
  width: 100%;
  height: 100%;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background-color: rgba(0,0,0,0.5);
  z-index: 2;
  cursor: pointer;
}

#text{
  position: absolute;
  top: 50%;
  left: 50%;
  font-size: 50px;
  color: white;
  transform: translate(-50%,-50%);
  -ms-transform: translate(-50%,-50%);
}

#text2{
  position: absolute;
  top: 55%;
  left: 50%;
  font-size: 25px;
  color: white;
  transform: translate(-50%,-50%);
  -ms-transform: translate(-50%,-50%);
}
#text3{
  position: absolute;
  top: 60%;
  left: 50%;
  transform: translate(-50%,-50%);
  -ms-transform: translate(-50%,-50%);
}
</style>

</head>
<body onload="checkCloseTime()"  data-background-color="bg3">
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
					
					<form:form id="msform" action="saveAppointment" method="POST" modelAttribute="appointmentForm" onsubmit="return validateForm()">
					
					  <!-- progressbar -->
					  <ul id="progressbar">
					    <li class="active">Date & Time</li>
					    <li>Vehicle Details</li>
					    <li>Customer Details</li>
					  </ul>
					  
					  <!-- fieldsets -->
					  <fieldset>
					    <h2 class="fs-title">Appointment ( offline )</h2>
					    <!-- <h3 class="fs-subtitle">Choose a Date & Time</h3> -->

							<div class="form-group row">
							   <div class="col-lg">
									<form:select path="vclassId.vehicleClassID" class="form-control mb-4" id="vClass" onchange="getFreeTimes()" required="true">									
										<option value="">Select vehicle type...</option>
										<c:forEach items="${vClass}" var="vClass">
											<form:option value="${vClass.vehicleClassID}">${vClass.vehicleClass}</form:option>
										</c:forEach>																																		
									</form:select>

									<form:select path="categoryId.categoryId" class="form-control mb-4" id="testCat" onchange="getFreeTimes()" required="true">									
										<form:option value="">Select test type...</form:option>
										<c:forEach items="${testCategory}" var="cat">
											<form:option value="${cat.categoryId}">${cat.categoryType}</form:option>
										</c:forEach>																																		
									</form:select>
									
<%-- 									<form:select path="lane.testLaneHeadId" class="form-control" 
										onchange="getFreeTimes();deleteLanemsg();" required="true" id="laneID">									
										<form:option value=""> Select lane...</form:option>
										<c:forEach items="${lanes}" var="lane">
											<form:option value="${lane.testLaneHeadId}">${lane.laneName}</form:option>
										</c:forEach>																																	
									</form:select>
									<div id="lanemsg"><span></span></div> --%>
							   </div>
							   <div class="col-lg">
							   
									<div style="overflow:hidden;">        
						            	<div class="form-group">
							                <div class="input-group date" id="datetimepicker1" data-target-input="nearest">
												<%-- <form:input path="appointmentTime" type="hidden" class="datetimepicker-input"
													data-target="#datetimepicker1"/> --%>
												<form:input path="appointmentDate" type="hidden" class="datetimepicker-input" 
													data-target="#datetimepicker1" id="appointmentDate"/>
							                </div>
							            </div>
									</div>
									
							   </div>
							</div>
<!-- 							<label class="bg-info text-white note" id="instruction">
								Please select a lane and date to show free time for appointments
							</label> -->
			            	<div class="btn-group-toggle" data-toggle="buttons" id="timeSlots">
							</div>

					    <input type="button" name="next" class="next action-button" value="Next" />
					  </fieldset>
					  
					  <fieldset>
					    <h2 class="fs-title">Vehicle Details</h2>
					    <h3 class="fs-subtitle"></h3>
					    
							<div class="form-group row">
								<div class="col-lg">
									<form:input class="form-control form-control-sm"
										placeholder="Enter License Plate No." path="vehicleID" id="vehicleID"  required="true" onfocusout="getCurrentOwner(this.value)"
										onkeyup="this.value = this.value.toUpperCase()"/>
								</div>
								OR
								<div class="col-lg">
									<select class="form-control form-control-sm" onchange="getCurrentOwner(this.value)">
										<option value="">Select License Plate No.</option>
										<c:forEach items="${ocr_vehicles}" var="ocr">
											<option value="${ocr.ocrVid}">${ocr.ocrVid}</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-lg">
									<select id="vMake" class="form-control form-control-sm"
										onchange="getModel(this.value);getMakeLogo()" required>
										<option value="">Select Make...</option>
											<c:forEach items="${vMake}" var="vMake">
												<option value="${vMake.vehicleMakeID}">${vMake.vehicleMake}</option>
											</c:forEach>
									</select>
									<img src="" id="makeImg" class="img-responsive">
								</div>
								<div class="col-lg">
									<form:select path="vmodel.vehicleModelID" id="vehicleModelID"
										class="form-control form-control-sm" onchange="getModelImage()"
										required="true">
										<form:option value="">Select Model...</form:option>
											<c:forEach items="${vmodel}" var="model">
												<form:option value="${model.vehicleModelID}">${model.vehicleModel}</form:option>
											</c:forEach>
									</form:select>
									<img src="" id="modelImg" class="img-responsive">
								</div>
							</div>
							<div class="form-group row">
								<div class="col-lg">
									<div class="form-inline">
										<form:select class="form-control form-control-sm mb-2 mr-sm-2" 
											id="fuelType" path="ftype.fuelTypeID" required="true" onchange="getEmissionNorm()">
											<option value="">Fuel Type...</option>
											<c:forEach items="${fuelType}" var="fuel">
												<form:option value="${fuel.fuelTypeID}">${fuel.fuel}</form:option>
											</c:forEach>
										</form:select>
										<i class='fas fa-gas-pump' style="color:black;"></i>
									</div>
								</div>
							</div>

<!-- 							<label class="bg-info text-white note">
								Note : If you can fill in the vehicle details below, You can save more time at the gate entrance !
							</label> -->
							
							<div class="accordion accordion-secondary">
							<div class="card">
								<div class="card-header collapsed" id="headingThree" data-toggle="collapse" data-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">

									<div class="span-title">
										If you can fill in the vehicle details below, You can save more time at the gate entrance !
									</div>
									<div class="span-mode"></div>
								</div>
								<div id="collapseThree" class="collapse" aria-labelledby="headingThree" data-parent="#accordion">
									<div class="card-body">
										<div class="form-group row">
										
											<div class="form-inline">

												<label for="registeredYear" class="mr-sm-2">Registered Year</label>
												<form:input type="text" class="form-control form-control-sm mb-2 mr-sm-2 datetimepicker-input" 
													id="registeredYear" data-toggle="datetimepicker" 
													data-target="#registeredYear" style="width: 110px" path="registeredYear"/>

<%-- 													<form:input type="text" class="form-control form-control-sm mb-2 mr-sm-2" 
													style="width: 80px" path="registeredYear" id="registeredYear"/> --%>
												
												<i class="fa fa-calendar mb-2" style="color:black;"></i>

											</div>

										</div>
										<div class="form-group row">
											<label for="chassisNo">VIN (Chassis Number)</label>
											<form:input class="form-control form-control-sm v-chno" id="chassisNo" maxlength="17"
												onkeyup="this.value = this.value.toUpperCase();" path="chassisNo"/>
										</div>
										<div class="form-group row">
											<div class="form-inline">
												<label for="manufactureYear" class="mr-sm-2">Manufactured Year</label>
												<form:input type="text" class="form-control form-control-sm mb-2 mr-sm-2 datetimepicker-input" 
													id="manufactureYear" data-toggle="datetimepicker" 
													data-target="#manufactureYear" style="width: 110px" path="manufactureYear" onchange="getEmissionNorm()"/>
													
<%-- 													<form:input class="form-control form-control-sm mb-2 mr-sm-2" 
													style="width: 110px" path="manufactureYear" id="manufactureYear"/> --%>
												<i class="fa fa-calendar mb-2 mr-sm-4" style="color:black;"></i>
											</div>
										</div>
										<div class="form-group row">
											<div class="form-inline">
												<label for="engno" class="mr-sm-4">Engine No.</label>
												<form:input class="form-control form-control-sm" id="engno"
													onkeyup="this.value = this.value.toUpperCase();" path="engineNo"/>
											</div>
										</div>
										<div class="form-group row">
											<div class="form-inline">
												<label for="engineCapacity" class="mr-sm-2">Capacity</label>
												<form:input class="form-control form-control-sm mb-2 mr-sm-2" 
													id="engineCapacity" style="width: 80px" path="engineCapacity"/>
												<label class="mb-2 mr-sm-4 fontst">CC</label>
												

											</div>
										</div>
										<div class="form-group row">
											<div class="form-inline">
												<label for="axles" class="mr-sm-2">No of Axles</label>
												<form:select class="form-control form-control-sm mb-2 mr-sm-4" 
													id="axles" path="noWheel">
													<form:option value="1">1</form:option>
													<form:option selected="true" value="2">2</form:option>
													<form:option value="3">3</form:option>
													<form:option value="4">4</form:option>
													<form:option value="5">5</form:option>
													<form:option value="6">6</form:option>
													<form:option value="7">7</form:option>
													<form:option value="8">8</form:option>
													<form:option value="9">9</form:option>
												</form:select>
												
												<label class="mr-sm-2">Emission Norms</label>
													<form:select path="emissionNorms" id="emissionNorms"  class="form-control form-control-sm">
														<c:forEach items="${emissionNorms}" var="rule">
															<form:option value="${rule.ruleName}">${rule.ruleName}</form:option>
														</c:forEach>
													</form:select>

											</div>
										</div>			
									</div>
								</div>
							</div>
							</div>				

							
						<input type="button" name="previous" class="previous action-button" value="Previous" />
					    <input type="button" name="next" class="next action-button" value="Next" />
					  </fieldset>
					  
					  <fieldset>
					    <h2 class="fs-title">Customer Details</h2>
					    <h3 class="fs-subtitle"></h3>
								<form:input class="form-control form-control-sm" type="hidden" 
									path="customerID" id="customerID" />

							<div class="form-group row">
								<div class="col-lg-6">
									<form:select path="customer_owner_status" class="form-control form-control-sm" 
									required="true" onchange="goAsNewOne()">										
										<form:option selected="true" value="owner">Owner</form:option>
										<form:option value="customer">Customer</form:option>																																		
									</form:select>
								</div>
								<div class="col-lg text-right">
									<a href="#" class="fontst fontcol-peo" onClick="goAsNewOne()" >
									<i class="fa fa-plus-circle"></i>
									New Owner</a>
								</div>
							</div>	
							<div class="form-group row">
								<div class="col-lg-6">
									<form:input class="form-control form-control-sm" id="tele" placeholder="Mobile No" 
										path="mobileNo" onfocusout="getCustomerDetails(this.value)" required="true"/>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-lg-3">
									<form:select path="cusTitle" id="cusTitle" class="form-control form-control-sm" 
									required="true">										
										<form:option selected="true" value="Mr">Mr</form:option>
										<form:option value="Mrs">Mrs</form:option>
										<form:option value="Miss">Miss</form:option>																																
									</form:select>							
								</div>
							  <div class="col-lg">
							    <form:input class="form-control form-control-sm" placeholder="Name" 
							    	path="firstName" id="firstName" required="true"/>
							  </div>
<%-- 							  <div class="col-lg">
							    <form:input class="form-control form-control-sm" placeholder="Last Name" 
							    	path="lastName" id="lastName"/>
							  </div> --%>
							</div>
							<div class="form-group row">
								<div class="col-lg-3">
									<form:input class="form-control form-control-sm" path="postalCode" placeholder="P O Box"/>
								</div>
								<div class="col-lg">
									<form:textarea path="address" id="address" class="form-control" placeholder="Address"/>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-lg-6">
									<form:input class="form-control form-control-sm" path="city" placeholder="City"/>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-lg-6">						
									<%-- <form:textarea class="form-control" path="address" placeholder="Address" id="address"/> --%>
						             <form:select  path="stateid.stateid" class="form-control form-control-sm" id="stateid">
										<form:option value="">Select State...</form:option>
										<c:forEach items="${countryStates}" var="state">
											<form:option value="${state.stateid}">${state.state}</form:option>
										</c:forEach>
									</form:select>
								</div>
							</div>	
							<div class="form-group row">
								<div class="col-lg-8">
								<form:input class="form-control form-control-sm" type="email" 
									path="email" id="email" placeholder="example@gmail.com"  />
								</div>
							</div>
							
							<div class="alert alert-warning alert-dismissible" id="timeSlotValidateMsgBox" style="display:none">
							  <!-- <button type="button" class="close" data-dismiss="alert">&times;</button> -->
							  <strong>Info!</strong> <div id="timeSlotValidateMsg"><span></span></div>
							</div>
							
					    <input type="button" name="previous" class="previous action-button" value="Previous" />
					    <input type="submit" name="submit" class="submit action-button" value="Submit"/>
					    <!-- <button type="submit" class="btn btn-success action-button">Submit</button> -->
					   
					  </fieldset>
					</form:form>

					<div id="overlay" onclick="off()">
					  <div id="text">Center is closed now !</div>
					  <!-- <div id="text2">Opens 8 AM to 5 PM</div> -->
					  <div id="text3"><a href="Dashboard" class="btn btn-success"> Back to Home</a></div>
					</div>


				</div>		
			</div>	
			<%@include file="../WEB-INF/jsp/footer.jsp"%>	
		</div>
	</div>
	
	<%@include file="../WEB-INF/jsp/commJs.jsp"%>

	<!-- Page level custom scripts -->
	<script src="resources/jQuery/appointmentForm.js"></script>
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.js"></script>
	<script
		src="<c:url value='resources/vendor/jquery-easing/jquery.easing.min.js'/>"
		type="text/javascript"></script>

	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.22.2/moment.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/tempusdominus-bootstrap-4/5.1.2/js/tempusdominus-bootstrap-4.min.js"></script>

    <script type="text/javascript">
        $(function () {
            $('#datetimepicker1').datetimepicker({
                inline: true,
                sideBySide: true,
                format: 'L',
                minDate: moment(1, 'h')
            });
        	
             $('#registeredYear').datetimepicker({
                 viewMode: 'years',
                 format: '<%=session.getAttribute("dateFormat")%>'.toUpperCase()
            });
            
            $('#manufactureYear').datetimepicker({
                 viewMode: 'years',
                 format: '<%=session.getAttribute("dateFormat")%>'.toUpperCase()

             });
             

             $('#datetimepicker1').on("change.datetimepicker", function (e) {
             	getFreeTimes();
              });
            
        }); 
    </script>
    
<script>
function getFreeTimes()
{
	var catID = document.getElementById("testCat").value;
	var date = $('#datetimepicker1').datetimepicker('viewDate').format('DD-MM-YYYY');

	if (catID == "" || date == "" ) {
        return;
	}
	else{
		$.ajax({
	    	type: 'GET',
	    	url: "getFreeTimeSlots",
	    	data: {"catID" :catID,"selectedDate":date},
		    success: function(data){
		    	 $('#timeSlots').empty();
	            for(var i=0; i<data.length; i++){
	            	if(data[i] != null){
        				option ="<label class='btn btn-success btn-sm mr-1 mb-1'><input type='radio' name='appointmentTime' autocomplete='off' value='"+data[i]+"'>"+data[i]+"</label>";
        				$('#timeSlots').append(option);
	            	}
	            	  	
	            }

	            //document.getElementById("instruction").style.visibility = "hidden";
	            var x = document.getElementById("instruction");
	            x.style.display = "none";
		    },
		    error:function(){
		        //alert("error");
		    }
	
		});
	}
}

</script>
<script>
function getCustomerDetails(str)
{
	if (str=="") {
        return;
	}
	else{
		$.ajax({
	    	type: 'GET',
	    	url: "getCustomerDetails",
	    	data: {"mobileNo" : str},
		    success: function(data){
		    	if(data.name !=null){
		    		document.getElementById("customerID").value = data.id;			    	
		    		document.getElementById("cusTitle").value = data.title;
			    	document.getElementById("firstName").value = data.name;
			    	document.getElementById("email").value = data.email;
			    	document.getElementById("postalCode").value = data.address;
			    	document.getElementById("city").value = data.city;
			    	document.getElementById("stateid").value = data.stateid.stateid;
		    	}else{
		    		document.getElementById("customerID").value = "";
		    		document.getElementById("cusTitle").value = "Mr";
		    		document.getElementById("firstName").value = "";
		    		document.getElementById("lastName").value = "";
		    		document.getElementById("postalCode").value = "";
		    		document.getElementById("city").value = "";
		    		document.getElementById("stateid").value = "";
		    		document.getElementById("email").value = "";
		    	}	
		    },
		    error:function(){
		        //alert("error");
		    }
	
		});
	}
}
</script>
<script>
function getMakeLogo()
{
	var str = document.getElementById("vMake").value;
	if (str=="")
	{ return;}
	else
	{
			$.ajax({
		    type: 'GET',
		    url: "getMakeImage",
		    data: {"vmake" : str},
		    success: function(data){
		        	
				 var x = document.getElementById("makeImg");
				 x.setAttribute("src", "data:image/jpg;base64,"+data+"");
				 x.setAttribute("width", "60");
				 x.setAttribute("height", "30");
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
	{return;}
	else
	{
		$.ajax({
		    type: 'GET',
		    url: "getModelImg",
		    data: {"vehicleModelID" : str},
		    success: function(data){
		        	
				 var x = document.getElementById("modelImg");
				 
				 x.setAttribute("src", "data:image/jpg;base64,"+data+"");
				 x.setAttribute("width", "60");
				 x.setAttribute("height", "30");
		    },
		    error:function(){
		       // alert("No Return Model Image");
		    }
		
		});
	}
}


function getModel(str) {
	var vClass = document.getElementById("vClass").value;
	if (str == "") {
		var slctSubcat = $('#vehicleModelID'), option = "";
		slctSubcat.empty();
        selected_option = "<option value='' selected>Select Model...</option>"
        slctSubcat.append(selected_option);
		return;
	} else {

		$.ajax({
			type	: 'GET',
			url		: "getModels",
			data	: {"makeID" : str,"classID" : vClass},
			success : function(data) {

				var slctSubcat = $('#vehicleModelID'), option = "";
				slctSubcat.empty();
				selected_option = "<option value='' selected>Select Model...</option>"
				slctSubcat.append(selected_option);

				for (var i = 0; i < data.length; i++) {
					option = option + "<option value='"+data[i].vehicleModelID + "'>"+ data[i].vehicleModel + "</option>";
				}
				slctSubcat.append(option);
			},
			error : function() {
				//alert("No return Model data for this Make ID");
			}

		});

	}
}
</script>

<c:if test = "${success ==1}">    
	<script type="text/javascript">
		Swal.fire(
			'Good job!',
			'Appointment Request Successfully Saved !',
			'success'
		)
	</script>
</c:if>
<c:if test = "${success ==0}">
	<script type="text/javascript">
		Swal.fire({
		  icon: 'error',
		  title: 'Oops...',
		  text: 'Something went wrong!'
		})
	</script>
</c:if>

<script>
function getCurrentOwner(vehicleNo){
	if(vehicleNo==""){
		return;
	}else{

		$.ajax({
	    	type: 'GET',
	    	url: "getCurrentOwner",
	    	data: {"vehicelNo":vehicleNo},
		    success: function(data){

		    	if(data.ownerName !=null){
		    		document.getElementById("customerID").value = data.ownerID;
		    		document.getElementById("tele").value = data.contactNo;
		    		document.getElementById("cusTitle").value = data.title;
			    	document.getElementById("firstName").value = data.ownerName;
			    	document.getElementById("email").value = data.email;
			    	document.getElementById("address").value = data.add01;
			    	document.getElementById("postalCode").value = data.postalBox;
			    	document.getElementById("city").value = data.city;
			    	document.getElementById("stateid").value = data.stateid.stateid;
			    	
			    	document.getElementById("vMake").value = data.vehicleID.vmodel.vehicleMakeID.vehicleMakeID;
			    	document.getElementById("vehicleModelID").value = data.vehicleID.vmodel.vehicleModelID;
			    	document.getElementById("fuelType").value = data.vehicleID.ftype.fuelTypeID;
			    	
			    	document.getElementById("registeredYear").value = data.vehicleID.registeredYear;
			    	document.getElementById("chassisNo").value = data.vehicleID.chassisNo;
			    	document.getElementById("manufactureYear").value = data.vehicleID.manufactureYear;
			    	document.getElementById("engno").value = data.vehicleID.engineNo;
			    	document.getElementById("engineCapacity").value = data.vehicleID.engineCapacity;
			    	document.getElementById("axles").value = data.vehicleID.noWheel;
			    	document.getElementById("emissionNorms").value = data.vehicleID.emissionNorms;
			    	document.getElementById("vehicleID").value = data.vehicleID.vehicleID;
		    	}else{
		    		goAsNewOne();
		    	}
	    		//document.getElementById("customerID").value = data.id;

		    },
		    error:function(){
		        //alert("error");
		    }
	
		});
		
	}
}

</script>

<!-- <script>
function findBestLane(){

	var vClass = document.getElementById("vClass").value;
	var vCat = document.getElementById("testCat").value;
	
	if(vClass == "" || vCat == ""){
		//document.getElementById("laneID").value="";
		return;
	}
	else{
		$.ajax({
			type : 'GET',
			url : "findBestLane",
			data : {"vCatID" : vCat,"vClassID" : vClass},
			success : function(data) {
				document.getElementById("laneID").value = data[0][0];
				document.getElementById("laneID").style.border="1px solid #50990c";
				$('#lanemsg span').text("The best lane is automatically selected !");
				document.getElementById("lanemsg").style.fontSize = "x-small";
				getFreeTimes();
			},
			error : function() {}

		});	
	}

}
function deleteLanemsg(){
	$('#lanemsg span').text("");
}
</script> -->

<script>
function goAsNewOne() {
	document.getElementById("customerID").value = "";
	document.getElementById("tele").value = "";
	document.getElementById("cusTitle").value = "Mr";
	document.getElementById("firstName").value = "";
	document.getElementById("lastName").value = "";
	document.getElementById("postalCode").value = "";
	document.getElementById("address").value = "";
	document.getElementById("city").value = "";
	document.getElementById("stateid").value = "";
	document.getElementById("email").value = "";
}
</script>

<script>
	function validateForm() {
		var a = document.getElementsByName("appointmentTime");
		var formValid = false;

		var i = 0;
		while (!formValid && i < a.length) {
			if (a[i].checked)
				formValid = true;
			i++;
		}

		if (!formValid){
			//alert("Must check some option!");
			$('#timeSlotValidateMsg span').text("Please Select an Appointment Time !");
			document.getElementById("timeSlotValidateMsg").style.fontSize = "small";
			document.getElementById("timeSlotValidateMsgBox").style.display = "block";

		}
			
		
		return formValid;
	}
</script>

<script>
	function checkCloseTime() {
		$.ajax({
		    type: 'GET',
		    url: "checkCloseTime",
		    success: function(data){

		    	if (data == true) {
		    		document.getElementById("overlay").style.display = "block";
				}else{
					document.getElementById("overlay").style.display = "none";
				}
		    },
		    error:function(){
		        //alert("error");
		    }
		
		});
	}
</script>

<script>
function getEmissionNorm()
{
 	var year = document.getElementById("manufactureYear").value;
	var fuel = document.getElementById("fuelType").value;
	
	if (year=="" || fuel=="")
	{ return;}
	else
	{
			$.ajax({
		    type: 'GET',
		    url : "emissionNorms",
		    data: {"year" : year, "fuel" : fuel},
		    success: function(data){
		        	
		    	document.getElementById("emissionNorms").value = data.ruleName;
		    },
		    error:function(){
		        alert("There was an error selecting Emission Norms ! Please select manually and proceed !");
		    }
		
		});
	}
}
</script>

</body>
</html>
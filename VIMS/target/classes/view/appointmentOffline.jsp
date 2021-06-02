<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ page isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>



<html lang="en">
<head>
	<%@include file="../WEB-INF/jsp/head.jsp"%>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/tempusdominus-bootstrap-4/5.1.2/css/tempusdominus-bootstrap-4.min.css"/>
	
<link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
<style>
* {
  box-sizing: border-box;
}

body {
  background-color: #f1f1f1;
}

#regForm {
  background-color: #ffffff;
  margin: 50px auto;
/*   font-family: Raleway; */
  padding: 40px;
  width: 70%;
  min-width: 300px;
}

h1 {
  text-align: center;  
}

input {
  padding: 10px;
  width: 100%;
  font-size: 17px;
/*   font-family: Raleway; */
  border: 1px solid #aaaaaa;
}

/* Mark input boxes that gets an error on validation: */
input.invalid {
  background-color: #ffdddd;
}

/* Hide all steps by default: */
.tab {
text-align: center;
  display: none;
}

button {
  background-color: #4CAF50;
  color: #ffffff;
  border: none;
  padding: 10px 20px;
  font-size: 17px;
  font-family: Raleway;
  cursor: pointer;
}

button:hover {
  opacity: 0.8;
}

#prevBtn {
  background-color: #bbbbbb;
}

/* Make circles that indicate the steps of the form: */
.step {
  height: 15px;
  width: 15px;
  margin: 0 2px;
  background-color: #bbbbbb;
  border: none;  
  border-radius: 50%;
  display: inline-block;
  opacity: 0.5;
}

.step.active {
  opacity: 1;
}

/* Mark the steps that are finished and valid: */
.step.finish {
  background-color: #4CAF50;
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


<form:form id="regForm" action="saveAppointment" method="POST" modelAttribute="appointmentForm">
  
  <!-- One "tab" for each step in the form: -->
  <div class="tab">
  	<h1>Appointment ( offline )</h1>
	<div class="form-group row">
	   <div class="col-lg-8">
			<select class="form-control mb-4" id="vClass" onchange="findBestLane()" required>									
				<option value="">Select vehicle class...</option>
				<c:forEach items="${vClass}" var="vClass">
					<option value="${vClass.vehicleClassID}">${vClass.vehicleClass}</option>
				</c:forEach>																																		
			</select>
	
	
			<form:select path="categoryId.categoryId" class="form-control mb-4" id="testCat" onchange="findBestLane()" required="true">									
				<form:option value="">Select testing category...</form:option>
				<c:forEach items="${testCategory}" var="cat">
					<form:option value="${cat.categoryId}">${cat.categoryType}</form:option>
				</c:forEach>																																		
			</form:select>
			
			<form:select path="lane.testLaneHeadId" class="form-control" 
				onchange="getFreeTimes();deleteLanemsg();" required="true" id="laneID">									
				<form:option value=""> Select lane...</form:option>
				<c:forEach items="${lanes}" var="lane">
					<form:option value="${lane.testLaneHeadId}">${lane.laneName}</form:option>
				</c:forEach>																																	
			</form:select>
			<div id="lanemsg"><span></span></div>
	   </div>
	</div>
	<div class="form-group row">
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
	
  </div>
  <div class="tab">
 	<h1>Vehicle Details</h1>
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
		<div class="col-lg">
			<div class="form-inline">
				<form:select class="form-control form-control-sm mr-sm-2" 
					id="fuelType" path="ftype.fuelTypeID" required="true">
					<option value="">Fuel Type...</option>
					<c:forEach items="${fuelType}" var="fuel">
						<form:option value="${fuel.fuelTypeID}">${fuel.fuel}</form:option>
					</c:forEach>
				</form:select>
				<i class='fas fa-gas-pump' style="color:black;"></i>
			</div>
		</div>
	</div>
 
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
								data-target="#registeredYear" style="width: 80px" path="registeredYear"/>

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
								data-target="#manufactureYear" style="width: 80px" path="manufactureYear"/>
								
<%-- 													<form:input type="text" class="form-control form-control-sm mb-2 mr-sm-2" 
													style="width: 80px" path="manufactureYear" id="manufactureYear"/> --%>
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
									<form:option value="">--SELECT--</form:option>
									<form:option value="2/3 WHEELER">2/3 WHEELER</form:option>
									<form:option value="4W Pre Bh.II">4W Pre Bh.II</form:option>
									<form:option value="4W Bh.II or III">4W Bh.II or III</form:option>
									<form:option value="4W Bh.IV">4W Bh.IV</form:option>
									<form:option value="Pre Bh. Stage IV">Pre Bh. Stage IV</form:option>
									<form:option value="BH. Stage IV">4W Bh.IV</form:option>
								</form:select>

						</div>
					</div>			
				</div>
			</div>
		</div>
	</div>	
 
  </div>



  <div style="overflow:auto;">
    <div style="float:right;">
      <button type="button" id="prevBtn" onclick="nextPrev(-1)">Previous</button>
      <button type="button" id="nextBtn" onclick="nextPrev(1)">Next</button>
    </div>
  </div>
  <!-- Circles which indicates the steps of the form: -->
  <div style="text-align:center;margin-top:40px;">
    <span class="step"></span>
    <span class="step"></span>
    <span class="step"></span>
    <span class="step"></span>
  </div>
</form:form>


				</div> <!-- End of page-inner -->
			</div>	
			<%@include file="../WEB-INF/jsp/footer.jsp"%>			
		</div>
	</div>
	
	<%@include file="../WEB-INF/jsp/commJs.jsp"%>
	
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
                 format: 'MM/YYYY'
            });
            
             $('#manufactureYear').datetimepicker({
                 viewMode: 'years',
                 format: 'YYYY'
             });

             $('#datetimepicker1').on("change.datetimepicker", function (e) {
             	getFreeTimes();
              });
            
        });
        
    </script>

<script>
var currentTab = 0; // Current tab is set to be the first tab (0)
showTab(currentTab); // Display the current tab

function showTab(n) {
  // This function will display the specified tab of the form...
  var x = document.getElementsByClassName("tab");
  x[n].style.display = "block";
  //... and fix the Previous/Next buttons:
  if (n == 0) {
    document.getElementById("prevBtn").style.display = "none";
  } else {
    document.getElementById("prevBtn").style.display = "inline";
  }
  if (n == (x.length - 1)) {
    document.getElementById("nextBtn").innerHTML = "Submit";
  } else {
    document.getElementById("nextBtn").innerHTML = "Next";
  }
  //... and run a function that will display the correct step indicator:
  fixStepIndicator(n)
}

function nextPrev(n) {
  // This function will figure out which tab to display
  var x = document.getElementsByClassName("tab");
  // Exit the function if any field in the current tab is invalid:
  if (n == 1 && !validateForm()) return false;
  // Hide the current tab:
  x[currentTab].style.display = "none";
  // Increase or decrease the current tab by 1:
  currentTab = currentTab + n;
  // if you have reached the end of the form...
  if (currentTab >= x.length) {
    // ... the form gets submitted:
    document.getElementById("regForm").submit();
    return false;
  }
  // Otherwise, display the correct tab:
  showTab(currentTab);
}

function validateForm() {
  // This function deals with validation of the form fields
  var x, y, i, valid = true;
  x = document.getElementsByClassName("tab");
  y = x[currentTab].getElementsByTagName("input");
  // A loop that checks every input field in the current tab:
  for (i = 0; i < y.length; i++) {
    // If a field is empty...
    if (y[i].value == "") {
      // add an "invalid" class to the field:
      y[i].className += " invalid";
      // and set the current valid status to false
      valid = false;
    }
  }
  // If the valid status is true, mark the step as finished and valid:
  if (valid) {
    document.getElementsByClassName("step")[currentTab].className += " finish";
  }
  return valid; // return the valid status
}

function fixStepIndicator(n) {
  // This function removes the "active" class of all steps...
  var i, x = document.getElementsByClassName("step");
  for (i = 0; i < x.length; i++) {
    x[i].className = x[i].className.replace(" active", "");
  }
  //... and adds the "active" class on the current step:
  x[n].className += " active";
}
</script>


</body>
</html>
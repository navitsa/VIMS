<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ page isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<title>Appointments</title>
<!-- head -->
<%@include file="../WEB-INF/jspf/head.jsp"%>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.14.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/tempusdominus-bootstrap-4/5.0.1/css/tempusdominus-bootstrap-4.min.css" />

</head>

<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- Sidebar -->
		<%@include file="../WEB-INF/jspf/slideBar.jsp"%>

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">

				<!-- Top Bar -->
				<%@include file="../WEB-INF/jspf/header.jsp"%>


				<!-- Begin Page Content -->
				<div class="container-fluid">

					<!-- Page Heading -->
					<div
						class="d-sm-flex align-items-center justify-content-between mb-4">
						<h1 class="h3 mb-0 text-gray-800">Appointment Request</h1>
					</div>
						
					<form:form action="saveAppointment" method="POST" modelAttribute="appointmentForm">

					<div class="row">
						<div class="col-xl-6 col-md-6 mb-4">
						
			              <div class="card shadow mb-4 border-left-primary">
			                <div class="card-body">
			                
			                	<c:if test = "${success ==1}">
									<div class="alert alert-success alert-dismissible">
									  <button type="button" class="close" data-dismiss="alert">&times;</button>
									  <strong>Success!</strong> Appointment Request Successfully Saved.
									</div>
								</c:if>
								<c:if test = "${success ==0}">
								  <div class="alert alert-danger alert-dismissible">
								    <button type="button" class="close" data-dismiss="alert">&times;</button>
								    <strong>Warning!</strong>Something went wrong ! Please try again!
								  </div>
								</c:if>
								
			                	<form:input type="hidden" path="appointmentID"/>
			                
							  <div class="form-group row">
							    <div class="col-lg">
							      <form:input class="form-control form-control-sm" placeholder="First Name" path="firstName"/>
							    </div>
							    <div class="col-lg">
							      <form:input class="form-control form-control-sm" placeholder="Last Name" path="lastName"/>
							    </div>
							  </div>
							  <div class="form-group row">
								<div class="col-lg-6">
<!-- 									<label for="tele">
									<i class="fa fa-phone-square" style="font-size:24px;color:blue" aria-hidden="true"></i>
									   Mobile No</label> -->
									<form:input class="form-control form-control-sm" id="tele" placeholder="Mobile No" path="mobileNo"/>
								</div>
							  </div>
							  <div class="form-group row">
							    <div class="col-lg-6">
							      <form:input class="form-control form-control-sm" placeholder="License Plate No." path="licensePlateNo"/>
							    </div>
							  </div>
								<div class="form-group row">
								   <div class="col-lg">
									<select class="custom-select custom-select-sm" onchange="">									
										<option value="">Select vehicle class...</option>
										<c:forEach items="${vClass}" var="vClass">
											<option value="${vClass.vehicleClassID}">${vClass.vehicleClass}</option>
										</c:forEach>																																		
									</select>
								   </div>
								   <div class="col-lg">
									<select class="custom-select custom-select-sm" id="testCat" onchange="">									
										<option value="">Select testing category...</option>
										<c:forEach items="${testCategory}" var="cat">
											<option value="${cat.categoryId}">${cat.categoryType}</option>
										</c:forEach>																																		
									</select>
								   </div>
								</div>
							  <div class="form-group row">
							    <div class="col-lg-6">
									<form:select path="lane.testLaneHeadId" class="custom-select custom-select-sm" onchange="getFreeTimes(this.value)">									
										<form:option value=""> Select lane...</form:option>
										<c:forEach items="${lanes}" var="lane">
											<form:option value="${lane.testLaneHeadId}">${lane.laneName}</form:option>
										</c:forEach>																																	
									</form:select>
							    </div>
							  </div>
							  
								<div style="overflow:hidden;">
								    <div class="form-group">
								        <div class="row">
								            <div class="col-lg">
								            
								            	<div class="form-group">
									                <div class="input-group date" id="datetimepicker1" data-target-input="nearest">
														<%-- <form:input path="appointmentTime" type="hidden" class="datetimepicker-input"
															data-target="#datetimepicker1"/> --%>
														<form:input path="appointmentDate" type="hidden" class="datetimepicker-input" 
															data-target="#datetimepicker1"/>
									                </div>
									            </div>
									            
								            </div>
								        </div>
								    </div>
								</div>

							  <div class="form-group row">
							    <div class="col-lg">
									<div class="btn-group-toggle" data-toggle="buttons" id="timeSlots">
									</div>
							    </div>
							  </div>

							  	<br>
								<button type="submit" class="btn btn-success">Request</button>
								<button type="reset" class="btn btn-warning">Clear</button>
							  
			                </div>
			              </div>
			              
						</div>
						
						<div class="col-xl-4 col-md-6 mb-4"> 
						</div>						
					</div>
					<!-- 1 row end -->

					</form:form>
					
				</div>
				<!-- End of Page Content -->


			</div>
			<!-- End of Main Content -->

			<!-- Footer -->
			<%@include file="../WEB-INF/jspf/footer.jsp"%>

		</div>
		<!-- End of Content Wrapper -->

	</div>
	<!-- End of Page Wrapper -->

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>

	<!-- Logout Modal-->
	<%@include file="logoutModel.jsp"%>



	<!-- Bootstrap core JavaScript-->
	<script src="<c:url value='/resources/vendor/jquery/jquery.min.js'/>"
		type="text/javascript"></script>
	<script
		src="<c:url value='/resources/vendor/bootstrap/js/bootstrap.bundle.min.js'/>"
		type="text/javascript"></script>

	<!-- Core plugin JavaScript-->
	<script
		src="<c:url value='/resources/vendor/jquery-easing/jquery.easing.min.js'/>"
		type="text/javascript"></script>

	<!-- Custom scripts for all pages-->
	<script src="<c:url value='/resources/js/sb-admin-2.min.js'/>"
		type="text/javascript"></script>

	<!-- Page level plugins -->

	<!-- Page level custom scripts -->

	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.22.2/moment.min.js"></script>
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/tempusdominus-bootstrap-4/5.0.1/js/tempusdominus-bootstrap-4.min.js"></script>

	<script type="text/javascript">
        $(function () {
            $('#datetimepicker1').datetimepicker({
                inline: true,
                sideBySide: true,
                format: 'L'
            });    
        });
    </script>
    
<script>
function getFreeTimes(str)
{
	var catID = document.getElementById("testCat").value;
	//alert("Lane ID & Cat IDs are "+str+" "+catID);	
	if (str=="") {
        return;
	}
	else{
		$.ajax({
	    	type: 'GET',
	    	url: "getFreeTimeSlots",
	    	data: {"catID" : catID, "laneID": str},
		    success: function(data){
	            for(var i=0; i<data.length; i++){
	            	//alert("success "+data[i]);
	                option ="<label class='btn btn-success mr-lg-1 mb-lg-1'><input type='radio' name='appointmentTime' autocomplete='off' value='"+data[i]+"'>"+data[i]+"</label>";
	                $('#timeSlots').append(option);
	            }
		    },
		    error:function(){
		        alert("error");
		    }
	
		});
	}
}
</script>


</body>
</html>
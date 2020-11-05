<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<title>vehicle Owner</title>
	<!-- head -->
	<%@include file="../WEB-INF/jspf/head.jsp"%>


	<style>
	.error1{color:red;font-size: 12px }
		
		.header-right {
		  float: right;
		}
		
	html {
	  scroll-behavior: smooth;
	}
	</style>

</head>

<body id="page-top" onload=" updateOwnerInfo()">

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

              <!-- Card -->
              <div class="card shadow mb-4 border-left-primary">
                <div class="card-header py-3">
                	<h6 class="m-0 font-weight-bold text-primary">Vehicle Owner</h6>
                </div>
                <div class="card-body">
					<c:if test = "${success ==true}">
						<div class="alert alert-success alert-dismissible">
						  <button type="button" class="close" data-dismiss="alert">&times;</button>
						  <strong>Success! </strong>Data Successfully Saved (Vehicle No - ${veOwner.vehicleID.vehicleID}).
						</div>
					</c:if>
					<c:if test = "${updated ==true}">
						<div class="alert alert-success alert-dismissible">
						  <button type="button" class="close" data-dismiss="alert">&times;</button>
						  <strong>Updated! </strong>Data Successfully Saved.
						</div>
					</c:if>

		                <div class="row">
<!-- 								<div class="col-sm-4"> -->
<!-- 									<div class="card" style="width: 18rem;"> -->
<!-- 									  <div class="card-body"> -->
<!-- 									    <h5 class="card-title">Current Owner Info:</h5> -->
<%-- 									    <input type="hidden" id="ownerID" value="${current_owner.ownerID}"> --%>
<%-- 									    <label>Name : </label>${current_owner.ownerName} --%>
<!-- 									    <br> -->
<%-- 									    <label>Contact Info : </label>${current_owner.contactNo} --%>
<!-- 									    <br> -->
<%-- 									    <label>Address Line 1 : </label> ${current_owner.add01} --%>
<!-- 									    <br> -->
<%-- 									    <label>Address Line 2 : </label>${current_owner.add02} --%>
<!-- 									    <br> -->
<%-- 									    <label>Address Line 3 : </label>${current_owner.city} --%>
<!-- 									    <br> -->
<%-- 									    <label>Email : </label>${current_owner.email} --%>
<!-- 									    <br> -->
<!-- 									    <a href="#section2" class="btn btn-primary btn-sm" onClick="updateOwnerInfo()">Edit Info</a> -->
<%-- 									    <a href="skipowner?vehicleID=${current_owner.vehicleID.vehicleID}" class="btn btn-primary btn-sm">Continue</a> --%>
<!-- 									  </div> -->
<!-- 									</div> -->
<!-- 								</div> -->
<!-- 								<div class="col-sm-4"> -->
							
<!-- 									<div class="card" style="width: 18rem;"> -->
<!-- 									  <div class="card-body"> -->
<!-- 									    <h5 class="card-title">Previous Owners Info :</h5> -->
<%-- 									    <c:forEach items="${pre_owners}" var="preOwners"> --%>
<%-- 									    	<c:if test = "${preOwners.status=='previousOwner'}"> --%>
<%-- 									    		${preOwners.ownerName} --%>
<!-- 									    		<br> -->
<%-- 									    	</c:if> --%>
<%-- 									    </c:forEach> --%>
<!-- 									  </div> -->
<!-- 									</div> -->
									
<!-- 								</div> -->
<!-- 								<div class="col-sm-4"> -->
<!-- 									<div class="card" style="width: 18rem;"> -->
<!-- 									  <div class="card-body"> -->
<!-- 									    <h5 class="card-title">Vehicle Info :</h5> -->
<%-- 									    <label>Licence Plate No :</label>${current_owner.vehicleID.vehicleID}<br> --%>
<%-- 									    <label>Make : </label>${current_owner.vehicleID.vmodel.vehicleMakeID.vehicleMake}<br> --%>
<%-- 									    <label>Class : </label>${current_owner.vehicleID.vmodel.vehicleClass.vehicleClass}<br> --%>
<%-- 									    <label>Model : </label>${current_owner.vehicleID.vmodel.vehicleModel} --%>
<!-- 									  </div> -->
<!-- 									</div> -->
<!-- 								</div> -->
								
						</div>
						<br>

					  
					  <div class="card-body" id="section2">
					  	<form:form action="saveVOwner" method="post" modelAttribute="veOwner">
					  	
					  		<form:input class="form-control"  path="ownerID" id="ownerId" value="${current_owner.ownerID}"/>
					  		<form:input class="form-control" type="hidden" path="vehicleID.vehicleID" id="vehicleID" value="${current_owner.vehicleID.vehicleID}"/>
					  		
						  	<div class="form-group row">
								<div class="col-sm-4">
									<label>Name :</label>
									<form:input class="form-control" path="ownerName" placeholder="Enter Owner Name" id="ownerName" />
									<form:errors path="ownerName" cssClass="error1"/>
								</div>
								<div class="col-sm-4">
									<label>Contact No :</label> 
									<form:input class="form-control" path="contactNo" placeholder="Enter Contact Number" id="contactNo" />
									<form:errors path="contactNo" cssClass="error1"/>
								</div>
								<div class="col-sm-4">
									<label>Email :</label> 
									<form:input class="form-control" type="email" path="email" placeholder="Enter Email" id="email" />
									<form:errors path="email" cssClass="error1"/>
								</div>
							</div>
						  	<div class="form-group row">
								<div class="col-sm-4">
									<label>Address Line 01</label>
									<form:textarea path="add01"  id="add01" class="form-control" placeholder="Enter Addres Line 01"/>
									<form:errors path="add01" cssClass="error1"/>
								</div>
								<div class="col-sm-4">
									<label>Address Line 02</label>
									<form:textarea path="add02"  id="add02" class="form-control" placeholder="Enter Addres Line 02"/>
									<form:errors path="add02" cssClass="error1"/>
								</div>
								<div class="col-sm-4">
									<label>Address Line 03</label>
									<form:textarea path="city"  id="city" class="form-control" placeholder="Enter Addres Line 03"/>
									<form:errors path="city" cssClass="error1"/>
								</div>
							</div>
						  	<div class="form-group row">
								<div class="col-sm-4">
									<label>Country :</label><br> 
										<form:select  class="custom-select"  id="countryCode" path="countryCode.countryCode" required="true"  readonly="true">
											<option value="">Select Country</option>
									
											<c:forEach items="${couCode}" var="c">
												<c:if test="${c.status == 'Active'}">
													<form:option selected="true"
														value="${c.countryCode}">${c.country}</form:option>
												</c:if>
												<c:if test="${c.status != 'Active'}">
													<form:option value="${c.countryCode}">${c.country}</form:option>
												</c:if>
											</c:forEach>		
										
										</form:select>
								</div>
								<div class="col-sm-4">
									<label>Status :</label><br> 
										<form:select class="custom-select"  id="cDrop" path="status" required="true" >
											<option value="">Select Status</option>
											<option value="currentOwner" selected>Current Owner</option>
											<option value="previousOwner">Previous Owner</option>
										</form:select>
								</div>
							</div>
							
							<input type="submit" class="btn btn-primary" value="SAVE"/>
							<input type="reset" class="btn btn-primary" value="CLEAR"/>
<!-- 							<input type="submit" class="btn btn-primary" value="CONTINUE" formaction="skipowner"/> -->
						
					  	</form:form>

					  </div>
				
	            </div> <!-- End of card body -->
              </div>

        </div>
        <!-- /.container-fluid -->
      </div>
      <!-- End of Main Content -->

			<!-- Footer -->
			<%@include file="../WEB-INF/jspf/footer.jsp"%>
    </div>
    <!-- End of Content Wrapper -->

  </div>
  <!-- End of Page Wrapper -->

  <!-- Scroll to Top Button-->
  <a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
  </a>

  <!-- Bootstrap core JavaScript-->
  <script src="resources/vendor/jquery/jquery.min.js"></script>
  <script src="resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="resources/vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="resources/js/sb-admin-2.min.js"></script>
  
    <!-- Page level plugins -->


  <!-- Page level custom scripts -->
  <script>
 
  	function updateOwnerInfo() {
  	  
  		var x = document.getElementById("ownerId");
		$.ajax({
	        type: 'GET',
	        url: "updateVOwner",
	        data: {"id" : x.value},
	        success: function(data){
	        	
	        	document.getElementById("ownerId").value = data.ownerID;
	        	document.getElementById("ownerName").value = data.ownerName;
	        	document.getElementById("contactNo").value = data.contactNo;
	        	document.getElementById("email").value = data.email;
	        	document.getElementById("add01").value = data.add01;
	        	document.getElementById("add02").value = data.add02;
	        	document.getElementById("city").value = data.city;
	        	document.getElementById("countryCode").value = data.countryCode.countryCode;
	        	document.getElementById("vehicleID").value = data.vehicleID.vehicleID;

	        },
	        error:function(){
	            alert("error");
	        }

	    });
		
	}
  </script>



</body>

</html>
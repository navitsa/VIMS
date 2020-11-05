<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<title>Visual Profile Item</title>
	<!-- head -->
	<%@include file="../WEB-INF/jspf/head.jsp"%>
	<link href="<c:url value='/resources/css/table.css'/>" rel="stylesheet">

<style>
.scrollable {
	height: 600px;
	overflow: scroll;
}
</style>

</head>

<body id="page-top" onload="checkStatusofDropdowns()">

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
              <div class="card shadow mb-4">
                <div class="card-header">
                 Visual Inspection > <a href="profileMaster">Profile</a> > 
                 	<a href="ProfileStages">Stages</a> > 
                 	<label class="text-primary font-weight-bold">Items</label>
                </div>
                <div class="card-body">

                	<c:if test = "${success ==1}">
						<div class="alert alert-success alert-dismissible">
						  <button type="button" class="close" data-dismiss="alert">&times;</button>
						  <strong>Success!</strong> Data Successfully Saved.
						</div>
					</c:if>
					<c:if test = "${success ==0}">
					  <div class="alert alert-danger alert-dismissible">
					    <button type="button" class="close" data-dismiss="alert">&times;</button>
					    <strong>Warning!</strong>Something went wrong ! Please try again!
					  </div>
					</c:if>
					
                	<form:form action="addStageItem" method="post" modelAttribute="profileItem" enctype="multipart/form-data" onsubmit="">
                		<div class="form-group row">
							<div class="col-sm-3">
								 <label for="profile" class="text-gray-900">Profile <span class="required text-danger">*</span></label>
								<form:select path="profile" class="custom-select" 
									id="profile" onchange="getStages(this.value)" required="true">
									<form:option value="">Select profile...</form:option>
									<c:forEach items="${profileNames}" var="profiles">
										<form:option value="${profiles.visualProfileID}">${profiles.profileName}</form:option>
									</c:forEach>
								</form:select>
								<form:errors path="profile" class="bg-danger text-white"/>
							</div>
							<div class="col-sm-7">
								<!--blank column -->
							</div>
							<div class="col-sm-2">
								<label for="itemId">Item ID:</label>
								<form:input path="itemId" class="form-control" readonly="true"/> 
			                </div>
						</div>
						<div class="form-group row">
							<div class="col-sm-3">
								<label for="visualProfileStageID" class="text-gray-900">Stage <span class="required text-danger">*</span></label>
								<form:select path="stage.stageID" id="visualProfileStageID" 
									class="custom-select" onchange="getItemForTable(this.value)" required="true">
									<form:option value="">Select Stage...</form:option>
									<c:forEach items="${listStages}" var="stage">
										<form:option value="${stage.stageID}">${stage.stage}</form:option>
									</c:forEach>
									
								</form:select>
								<form:errors path="stage" class="bg-danger text-white"/>
							</div>
						</div>
						<div class="form-group row">
							<div class="col-sm-3">
								<label for="serialNo" class="text-gray-900">Item Serial No <span class="required text-danger">*</span></label>
								<form:input path="serialNo"  class="form-control" id="serialNo"/>
								<form:errors path="serialNo" class="bg-danger text-white"/>
							</div>
						</div>
						<div class="form-group row">
							<div class="col-sm-3">
								<label for="itemName" class="text-gray-900">Item Name <span class="required text-danger">*</span></label>
								<form:input path="itemName" class="form-control" id="itemName"/>
								<form:errors path="itemName" class="bg-danger text-white"/>
							</div>
						</div>
						<div class="form-group row">
							<div class="col-sm-3">
								<form:input type="file" class="file" id="itemImage" path="itemImage" ></form:input>
									<div class="input-group">
										 <input type="text" class="form-control" placeholder="Choose Image..." id="file"  disabled >
										 <div class="input-group-append">
										 	<button type="button" class="browse btn btn-primary">Browse</button>
										 </div>
									</div>
							</div>
				            <div class="col-sm-3">
				                <div class="ml-2 col-sm-6">
				                	<c:if test = "${profileItem.itemImage == null}">
				                 		<img src="<c:url value='/resources/img/empty-placeholder-image-icon.jpg'/>" id="preview" class="img-thumbnail"/>
				                 	</c:if>
				                 	<c:if test = "${profileItem.itemImage != null}">
										 <img src="data:image/jpg;base64,${profileItem.itemImageView}" id="preview" width="80" height="80" alt=""/>
									</c:if>
				                 </div>
				            </div>
						</div>
						<button type="submit" class="btn btn-success">Add Item</button>
						<button type="reset" class="btn btn-warning">Clear</button>
                	</form:form>
                	<hr>
					<!-- table -->
						<div class="table-responsive">
							<div class="table-wrapper">
								<div class="table-title">
									<div class="row">
										<div class="col-sm-8"><h3>Item <b>Details</b></h3></div>
									</div>
								</div>
									<div class="scrollable">
									<table class="table table-bordered">
										<thead>
										   <tr>
										      <th>Profile</th>
										      <th>Stage</th>
										      <th>Item Serial</th>
										      <th>Item</th>
										      <th>Image</th>
										   </tr>
										</thead>
										<tbody id="myTable">
										                
										  <c:forEach items="${listItems}" var="item">
										      <tr>
										        <td>${item.stage.vp.profileName}</td>
										        <td>${item.stage.stage}</td>
										        <td>${item.serialNo}</td>
										        <td>${item.itemName}</td>
										        <td>
										        	<div>
										        		<c:if test = "${item.itemImage != null}">
										        			<img src="data:image/jpg;base64,${item.itemImageView}" width="80" height="80" alt=""/>
										        		</c:if>
										        	</div>
										        </td>
										        <td>
													<a href="editProfileItem?id=${item.itemId}"><i class="material-icons">&#xE254;</i></a>
										        </td>
										      </tr>
										  </c:forEach>
										                       
										</tbody>
									</table>
									</div>
							</div>
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
    <script src="resources/js/file-input.js"></script>
  	<script src="resources/ajax/item-status.js"></script>
  	<script src="resources/js/file-input-validation.js"></script>
  	
  	<script>
  		function checkStatusofDropdowns()
  		{
  			//document.getElementById('visualProfileStageID').disabled = true;
  		}
  	</script>
 
</body>

</html>
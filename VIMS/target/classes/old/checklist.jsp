<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<title>Checklist</title>
	<!-- head -->
	<%@include file="../WEB-INF/jspf/head.jsp"%>

    <!-- Custom styles for this page -->
  <link href="resources/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
  
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

              <!-- Card -->
              <div class="card shadow mb-4">
                <div class="card-header py-3">
                  <h6 class="m-0 font-weight-bold text-primary">Visual Inspection Checklist</h6>
                </div>
                <div class="card-body">
                	
					<div class="row">
						 <div class="col-sm-3">
						 	<form action="getPendingVehiclesForInspection">
						    	<label for="vehicle_no" class="mb-2 mr-sm-2">Vehicle No:</label>
						    		<input type="text" class="form-control mb-2 mr-sm-2" id="vehicle_no" placeholder="Vehicle No..." name="vehicle_no" value='${pending.vid.vehicleID}'>
						    </form>
						 </div>
					</div>
					<form action="chMasterDataB" method="GET">
						<div class="row">
								 <div class="col-sm-3">
								    <label for="preparedBy" class="mb-2 mr-sm-2">Prepared By:</label>
								    <input type="text" class="form-control mb-2 mr-sm-2" id="preparedBy" placeholder="Prepared By..." name="">
								 </div>
								 <div class="col-sm-3">
								    <label for="conductedOn" class="mb-2 mr-sm-2">Conducted On:</label>
								    <input type="date" name="date" class="form-control mb-2 mr-sm-2">
								    <input type="hidden" name="time" value="2pm">
								 </div>
								 <div class="col-sm-3">
								</div>
						</div>

						<div class="row">
							 <div class="col-sm-3">
						   		<label for="reg_no" class="mb-2 mr-sm-2">Registration No:</label>
						   		<input type="text" class="form-control mb-2 mr-sm-2" id="reg_no" placeholder="Registration No..." name="vRegID" value='${pending.vregID}'>
						   	</div>
						   	 <div class="col-sm-3">
						   		<label for="fuel_type" class="mb-2 mr-sm-2">Fuel Type:</label>
						   		<input type="text" class="form-control mb-2 mr-sm-2" id="fuel_type" placeholder="Fuel Type..." name="" value='${pending.vid.fuelTypeID.fuel}'>
<%-- 						   		<input type="hidden" name="fuelTypeID" value="${pending.vid.fuelTypeID.fuelTypeID}"> --%>
						   	</div>
						</div>

						<div class="table-responsive">
				        <table class="gridtable table table-bordered" id="tableMain">
				            <thead class="thead-light">
				                <tr class="tableheader">
				                	<th>Stage ID</th>
									<th>Stage</th>
									<th>Item ID</th>
				                  <th>Item</th>
				                  <th>Status</th>
				                  <th>Remark</th>
				                  <th>Input</th>
				                </tr>
				            </thead>
				            <tbody>
								<c:forEach items="${remark}" var="remark">
<%-- 									<c:if test = "${remark.is.item.stage.stage != stage}"> --%>
<%-- 				                		<tr class="breakrow"><td>${remark.is.item.stage.stage}</td><td></td><td></td><td></td></tr> --%>
<%-- 				                	</c:if> --%>
				                	<c:if test = "${remark.is.item.itemName != item}">
				                		<c:set var = "test"  value = "${remark.is.item.itemName}"/>
					                		<tr class="datarow">
					                				<td>${remark.is.item.stage.stageID}</td>
					                				<td>${remark.is.item.stage.stage}</td>
					                				<td><input name="itemID" value="${remark.is.item.itemId}"/></td>
					                				<td>${remark.is.item.itemName}</td>
					                				
					                				<td>
					                					<select  class="custom-select" id="mySelect" onchange="getRemarks(this.value)">
					                						<option value="">--Select--</option>
					                						<c:forEach items="${rm}" var="abc">
					                							<c:if test = "${abc.is.item.itemName ==test }">
					                								<option value="${abc.is.profileItemStatusID}">${abc.is.vprofileItemStatus}</option>
					                							</c:if>
					                						</c:forEach>
					                					</select>
					                				</td>
					                				
					                				<td>
					                					<select id="cmbRemark" class="cmbRemark custom-select">
					                						<option value="">--Select--</option>
					                						<c:forEach items="${rem}" var="abcd">
					                							<c:if test = "${abcd.is.item.itemName ==test }">
					                								<option>${abcd.remarks}</option>
					                							</c:if>
					                						</c:forEach>
					                					</select>
					                				</td>
					                				<td></td>
					                		</tr>
				                	</c:if>
				                			
				                		<c:set var = "stage"  value = "${remark.is.item.stage.stage}"/>
				                		<c:set var = "item"  value = "${remark.is.item.itemName}"/>
				             	</c:forEach>
				            </tbody>
				        </table>
				        </div>

					        <div class="row">
					        		<div class="col-sm-4">
					        			  <label for="status" class="mt-4">Status:</label>
					        			  <textarea class="form-control" rows="3" id="status" name="status"></textarea>
					        		</div>
					        		<div class="col-sm-4">
					        			  <label for="remark" class="mt-4">Remark:</label>
					        			  <textarea class="form-control" rows="3" id="remark" name="remark"></textarea>
					        		</div>
					        </div>
					         <input type="hidden" name="cheklistID" value="001">
					        <input type="hidden" name="partnerID" value="001">
					        <input type="hidden" name="vehicleID" value='${pending.vid.vehicleID}'>
					        <input type="hidden" name="centerID" value='${pending.centermaster.center_ID}'>
					        <input type="hidden" name="laneID" value="001">
					        <input type="hidden" name="profileID" value="001">
					        <input type="hidden" name="userID" value="1">

					        <input type="hidden" name="fuelTypeID" value="${pending.vid.fuelTypeID.fuelTypeID}">
					        
					        <input type="hidden" name="stageID" value="">

					        
					        <button type="submit" value="" class="btn btn-primary mt-4">Save</button>
							<button type="button" id="bt" class="btn btn-primary mt-4" onclick="showTableData()">Test </button>
					        
				        </form>
				        
				            <p id="info"></p>
				      
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
  <script src="resources/vendor/datatables/jquery.dataTables.min.js"></script>
  <script src="resources/vendor/datatables/dataTables.bootstrap4.min.js"></script>

  <!-- Page level custom scripts -->
  <script src="resources/js/demo/datatables-demo.js"></script>
   <script src="resources/js/checklist_table.js"></script>

</body>

</html>
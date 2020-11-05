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
							<h4 class="page-title">Test Profiles</h4>
							<ul class="breadcrumbs">
								<li class="nav-home">
									<a href="#">
										<i class="flaticon-home"></i>
									</a>
								</li>
								<li class="separator">
									<i class="flaticon-right-arrow"></i>
								</li>
									<a href="#">Visual Profile</a>
								<li class="nav-item">
								</li>
								<li class="separator">
									<i class="flaticon-right-arrow"></i>
								</li>
									<a href="#">Remarks</a>
								<li class="nav-item">
								</li>
							</ul>
						</div>
				
									<div
								class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
								<div class="col-xl-9 col-md-12 mb-4 ">
									<div class="card border-left-primary shadow h-100 py-2">			
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
					
			        <form:form action="addStatusRemarks" method="POST" modelAttribute="itemRemarks">
				    	<div class="form-group row">
							<div class="col-sm-3">
								<label for="visualprofileID" class="text-gray-900">Profile <span class="required text-danger">*</span></label>
								<form:select path="profileID" id="visualprofileID" class="custom-select"  onchange="getStages(this.value)" required="true">
									<form:option value="">Select profile...</form:option>
										<c:forEach items="${profileNames}" var="profile">
											<form:option value = "${profile.visualProfileID}">${profile.profileName}</form:option>
										</c:forEach>
								</form:select>
								<form:errors path="profileID" class="bg-danger text-white"/>
							</div>
							<div class="col-sm-7">
							</div>
							<div class="col-sm-2">
								<label for="" class="text-gray-900">Remark ID:</label>
								<form:input path="remarksID" class="form-control" readonly="true"/>
							</div>
						</div>
				    	<div class="form-group row">
							<div class="col-sm-3">
								<label for="visualProfileStageID" class="text-gray-900">Stage <span class="required text-danger">*</span></label>
								<form:select path="stage" id="visualProfileStageID" class="custom-select"  onchange="getItem(this.value)" required="true">
									<form:option value="">Select stage...</form:option>
									<c:forEach items="${listStages}" var="stage">
										<form:option value="${stage.stageID}">${stage.stage}</form:option>
									</c:forEach>
								</form:select>
								<form:errors path="stage" class="bg-danger text-white"/>
							</div>	
						</div>
				    	<div class="form-group row">
							<div class="col-sm-3">
								<label for="visualProfileItemID" class="text-gray-900">Item <span class="required text-danger">*</span></label>
								<form:select path="itemID" id="visualProfileItemID" class="custom-select" onchange="getStatusForDropDown(this.value)" required="true">
									<form:option value="">Select item...</form:option>
									<c:forEach items="${listItems}" var="item">
										<form:option value="${item.itemId}">${item.itemName}</form:option>
									</c:forEach>
								</form:select>
								<form:errors path="itemID" class="bg-danger text-white"/>
							</div>
						</div>
				    	<div class="form-group row">
							<div class="col-sm-3">
								<label for="itemStatus" class="text-gray-900">Status <span class="required text-danger">*</span></label>
								<form:select path="is.profileItemStatusID" id="itemStatus" class="custom-select" onchange="getRemarks(this.value)" required="true">
									<form:option value="">Select status...</form:option>
									<c:forEach items="${listItemsStatus}" var="status">
										<form:option value="${status.profileItemStatusID}">${status.vprofileItemStatus}</form:option>
									</c:forEach>
								</form:select>
								<form:errors path="is" class="bg-danger text-white"/>
							</div>
						</div>
						<div class="form-group row">
							<div class="col-sm-3">
							
								<label for="serialNo" class="text-gray-900">Remark Serial No <span class="required text-danger">*</span></label>
								<form:input path="serialNo"  class="form-control"/>
								<form:errors path="serialNo" class="bg-danger text-white"/>
								
							</div>
							<div class="col-sm-6">
								<label for="remarks" class="text-gray-900">Remark <span class="required text-danger">*</span></label>
								<form:textarea path="remarks" class="form-control"/>
								<form:errors path="remarks" class="bg-danger text-white"/>
							</div> 
						</div>
						
							<button type="submit" class="btn btn-success">Add Remark</button>
							<button type="reset" class="btn btn-warning">Clear</button>
						<hr>
						<!-- table -->
						<div class="table-responsive">
							<div class="table-wrapper">
								<div class="table-title">
									<div class="row">
										<div class="col-sm-8"><h2>Item Status Remark &nbsp;<b>Details</b></h2></div>
									</div>
								</div>
									<table class="table table-bordered">
										<thead>
										   <tr>
										      <th>Item</th>
										      <th>Status</th>
										      <th>Remark Serial</th>
										      <th>Remark</th>
										      <th></th>
										   </tr>
										</thead>
										<tbody id="myTable">
										                
										  <c:forEach items="${remark}" var="remark">
										      <tr>
										        <td>${remark.is.item.itemName}</td>
										        <td>${remark.is.vprofileItemStatus}</td>
										        <td>${remark.serialNo}</td>
										        <td>${remark.remarks}</td>
										        <td>
													<a href="editRemark?id=${remark.remarksID}"><i class="material-icons">&#xE254;</i></a>
										        </td>
										      </tr>
										  </c:forEach>
										                       
										</tbody>
									</table>
							</div>
						</div>
			        </form:form>

	            </div> 	
				</div> </div> </div> 
				
				
					</div>
				
			</div>	
			<%@include file="../WEB-INF/jsp/footer.jsp"%>			
		</div>
	</div>
<%@include file="../WEB-INF/jsp/commJs.jsp"%>

	
</body>
</html>
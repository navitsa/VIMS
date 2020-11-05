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
									<a href="#">Status</a>
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
                
                	<form:form action="saveStatus_act" method="POST" modelAttribute="saveStatus" enctype="multipart/form-data" onsubmit="">
                	
				    	<div class="form-group row">
							<div class="col-sm-3">
								<label for="visualprofileID" class="text-gray-900">Profile <span class="required text-danger">*</span></label>
								<form:select path="visualprofileID" id="visualprofileID" class="custom-select"  onchange="getStages(this.value)" required="true">
									<form:option value="">Select profile...</form:option>
										<c:forEach items="${profileNames}" var="profile">
											<form:option value = "${profile.visualProfileID}">${profile.profileName}</form:option>
										</c:forEach>
								</form:select>
								<form:errors path="visualprofileID" class="bg-danger text-white"/>
							</div>
							<div class="col-sm-7">
							</div>
							<div class="col-sm-2">
								<label for="profileItemStatusID" class="text-gray-900">Item Status ID:</label>
								<form:input path="profileItemStatusID" class="form-control" readonly="true"/>
							</div>
						</div>
				    	<div class="form-group row">
							<div class="col-sm-3">
								<label for="visualProfileStageID" class="text-gray-900">Stage <span class="required text-danger">*</span></label>
								<form:select path="visualProfileStageID" id="visualProfileStageID" class="custom-select"  onchange="getItem(this.value)" required="true">
									<form:option value="">Select stage...</form:option>
									<c:forEach items="${listStages}" var="stage">
										<form:option value="${stage.stageID}">${stage.stage}</form:option>
									</c:forEach>
								</form:select>
								<form:errors path="visualProfileStageID" class="bg-danger text-white"/>
							</div>	
						</div>
				    	<div class="form-group row">
							<div class="col-sm-3">
								<label for="visualProfileItemID" class="text-gray-900">Item <span class="required text-danger">*</span></label>
								<form:select path="item.itemId" id="visualProfileItemID" class="custom-select" onchange="getStatus(this.value)" required="true">
									<form:option value="">Select item...</form:option>
									<c:forEach items="${listItems}" var="item">
										<form:option value="${item.itemId}">${item.itemName}</form:option>
									</c:forEach>
								</form:select>
								<form:errors path="item" class="bg-danger text-white"/>
							</div>
						</div>

						<div class="border mt-2 mb-2">
							<div class="row mt-2 mb-2 ml-2">
							
								<div class="col-sm-3">
									<label for="statusSerialNo" class="text-gray-900">Serial No <span class="required text-danger">*</span></label>
									<form:input path="statusSerialNo" class="form-control"/>
									<form:errors path="statusSerialNo" class="bg-danger text-white"/>
								</div>
								
								<div class="col-sm-3">
									<label for="vprofileItemStatus" class="text-gray-900">Status <span class="required text-danger">*</span></label>
									<form:input path="vprofileItemStatus" class="form-control"/>
									<form:errors path="vprofileItemStatus" class="bg-danger text-white"/>
								</div>
								
								<div class="col-sm-3">
									<label for="statusMark" class="text-gray-900">Status Mark :</label>
									 <form:input type="file" class="file" accept="image/*" path="statusMark"/>
										<div class="input-group">
										 	<input type="text" class="form-control" placeholder="Choose Image..." id="file"  disabled>
										 		<div class="input-group-append">
										 		  	<button type="button" class="browse btn btn-primary">Browse</button>
										 		</div>
										 </div>
								</div>
								
				                <div class="col-sm-3">
				                 	<div class="ml-2 col-sm-6">
				                	<c:if test = "${saveStatus.statusMark == null}">
				                		<img src="<c:url value='/resources/img/empty-placeholder-image-icon.jpg'/>" id="preview" class="img-thumbnail"/>
				                 	</c:if>
				                 	<c:if test = "${saveStatus.statusMark != null}">
										 <img src="data:image/jpg;base64,${saveStatus.statusMarkView}"  width="80" height="80" alt=""/>
									</c:if>
				                 	</div>
				                </div>
				                
							</div>
						</div>
						
						<button type="submit" class="btn btn-success">Add Status</button>
						<button type="reset" class="btn btn-warning">Clear</button>
                	</form:form>
                	<hr>
                	
                	<div class="table-responsive">
                	<div class="table-wrapper">
						<div class="table-title">
							<div class="row">
								<div class="col-sm-8"><h2>Item Status <b>Details</b></h2></div>
							</div>
						</div>
						<div class="scrollable   table-wrapper-scroll-y my-custom-scrollbar">
							<table class="table table-bordered" >
								<thead>
									<tr>
										<th>Item</th>
										<th>Serial No</th>
										<th>Status</th>
										<th>Status Mark</th>
										<th>Actions</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${listItemsStatus}" var="status">
										<tr>
											<td>${status.item.itemName}</td>
											<td>${status.statusSerialNo}</td>
											<td>${status.vprofileItemStatus}</td>
											<td>
												<div>
											        <c:if test = "${status.statusMark != null}">
											        	<img src="data:image/jpg;base64,${status.statusMarkView}" width="80" height="80" alt="No Image"/>
											        </c:if>
										       </div>
											</td>
											<td>
												<a href="editStatus?id=${status.profileItemStatusID}"><i class="material-icons">&#xE254;</i></a>
											</td>
										</tr>
									</c:forEach>
											                       
								</tbody>
							</table>
						</div>
					</div>
                	</div>
	            </div> 				
				
				</div></div></div>
				
					</div>
				
			</div>	
			<%@include file="../WEB-INF/jsp/footer.jsp"%>			
		</div>
	</div>
<%@include file="../WEB-INF/jsp/commJs.jsp"%>

	
</body>
</html>
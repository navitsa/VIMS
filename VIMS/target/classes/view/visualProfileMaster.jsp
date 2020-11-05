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
									<a href="#">Profile</a>
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

			        <form:form action="visualProfile_act" method="POST" modelAttribute="visualProfile">
			            <div class="form-group row">
							<div class="col-sm-3">
								 <label for="profileName" class="text-gray-900">Profile Name <span class="required text-danger">*</span></label>
							       <form:input path="profileName"  class="form-control"/>
							       <form:errors path="profileName" class="bg-danger text-white"/>
							 </div>
							<div class="col-sm-7">
							 </div>
							<div class="col-sm-2">
								<label for="name" class="text-gray-900">Profile id:</label> 
								<form:input path="visualProfileID" class="form-control" readonly="true"/>
							</div>
						</div>
						<div class="form-group row">
							<div class="col-sm-3">
								<label for="profileHeader" class="text-gray-900">Header</label>
								<form:input path="profileHeader"  class="form-control"/>
								<form:errors path="profileHeader" class="bg-danger text-white"/>
							</div> 
						</div>
						<div class="form-group row">
							<div class="col-sm-3">
								<label for="profileSubHeader" class="text-gray-900">Sub Header</label>
							    	<form:input path="profileSubHeader" id="profileSubHeader" class="form-control"/>
							    	<form:errors path="profileSubHeader" class="bg-danger text-white"/>
							 </div>
						</div>
						<div class="form-group row">
							<div class="col-sm-3">
							    <label for="profileFooter" class="text-gray-900">Footer</label>
							       <form:input path="profileFooter"  class="form-control" id="profileFooter"/>
							       <form:errors path="profileFooter" class="bg-danger text-white"/>
							</div>
						</div>
						<div class="form-group row">
							<div class="col-sm-3">
							    <label for="profileRemark" class="text-gray-900">Remark</label>
							       <form:textarea path="remark" class="form-control" id="profileRemark"/>
							       <form:errors path="remark" cssClass="bg-danger text-white"/>
							</div>
						</div>
						
							<button type="submit" class="btn btn-success" onclick="clickCounter()">Add Profile</button>
							<button type="reset" class="btn btn-warning">Clear</button>
						</form:form>
						<hr>
									<!-- table -->
									<div class="table-responsive">
										<div class="table-wrapper">
												<table class="table table-bordered">
													<thead>
													   <tr>
													      <th>Profile ID</th>
													      <th>Profile</th>
													      <th>Header</th>
													      <th>Sub Header</th>
													      <th>Footer</th>
													      <th>Remark</th>
													      <th></th>
													   </tr>
													</thead>
													<tbody id="myTable">
													                
													  <c:forEach items="${profileNames}" var="profile">
													      <tr>
													        <td>${profile.visualProfileID}</td>
													        <td>${profile.profileName}</td>
													        <td>${profile.profileHeader}</td>
													        <td>${profile.profileSubHeader}</td>
													        <td>${profile.profileFooter}</td>
													        <td>${profile.remark}</td>
													        <td>
																<a href="getProfileInfo?id=${profile.visualProfileID}"><i class="material-icons">&#xE254;</i></a>
													        </td>
													      </tr>
													  </c:forEach>
													                       
													</tbody>
												</table>
										</div>
									</div>
								
	            </div> 	

	 </div>  </div>  </div> 
				
				
				
				
				
					</div>
				
			</div>	
			<%@include file="../WEB-INF/jsp/footer.jsp"%>			
		</div>
	</div>
<%@include file="../WEB-INF/jsp/commJs.jsp"%>

	
</body>
</html>
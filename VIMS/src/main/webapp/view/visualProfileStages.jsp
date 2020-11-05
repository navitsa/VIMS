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
									<a href="#">Stages</a>
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
					    <strong>Warning! </strong>Something went wrong ! Please try again!
					  </div>
					</c:if>
					
                	<form:form action="profileStage_act" method="POST" modelAttribute="visualStage">
                	
						<div class="form-group row">
							<div class="col-sm-3">
								<label for="profile" class="text-gray-900">Profile <span class="required text-danger">*</span></label>
								<form:select path="vp.visualProfileID" id="profile" class="custom-select" required="true" onchange="getStagesForTable(this.value)">										
									<form:option value=""> --SELECT--</form:option>																																			
										<c:forEach items="${profileNames}" var="pro">
											<form:option value="${pro.visualProfileID}">${pro.profileName}</form:option>
										</c:forEach>
								</form:select>	
								<form:errors path="vp" class="bg-danger text-white"/>
							</div>
							<div class="col-sm-7">
								<!--blank column -->
							</div>
							<div class="col-sm-2">
								<label for="stageID" class="text-gray-900">Stage ID:</label>
								<form:input path="stageID" class="form-control" readonly="true"/> 
			                </div>
						</div>
						<div class="form-group row">
							<div class="col-sm-3">
								<label for="stageNo" class="text-gray-900">Stage Serial No <span class="required text-danger">*</span></label>
								<form:input path="stageNo"  class="form-control"/> 
								<form:errors path="stageNo" class="bg-danger text-white"/>
							</div>
						</div>
						<div class="form-group row">
							<div class="col-sm-3">
								<label for="stage" class="text-gray-900">Stage Name <span class="required text-danger">*</span></label>
								<form:input path="stage"  class="form-control"/>
								<form:errors path="stage" class="bg-danger text-white"/> 
							</div>
						</div>
						
						<button type="submit" class="btn btn-success">Add Stage</button>
						<button type="reset" class="btn btn-warning">Clear</button>
						<hr>
						<!-- table -->
						<div class="table-responsive">
							<div class="table-wrapper">
								<div class="table-title">
									<div class="row">
										<div class="col-sm-8"><h2>Stage <b>Details</b></h2></div>
									</div>
								</div>
									<table class="table table-bordered">
										<thead>
										   <tr>
										      <th>Profile</th>
										      <th>Stage Serial</th>
										      <th>Stage</th>
										      <th></th>
										   </tr>
										</thead>
										<tbody id="myTable">
										                
										  <c:forEach items="${listStages}" var="ProfileStages">
										      <tr>
										        <td>${ProfileStages.vp.profileName}</td>
										        <td>${ProfileStages.stageNo}</td>
										        <td>${ProfileStages.stage}</td>
										        <td>
													<a href="editStage?id=${ProfileStages.stageID}"><i class="material-icons">&#xE254;</i></a>
										        </td>
										      </tr>
										  </c:forEach>
										                       
										</tbody>
									</table>
							</div>
						</div>
                	</form:form>
	            </div> <!-- End of card body -->
				
				
				</div></div></div>
				
				
					</div>
				
			</div>	
			<%@include file="../WEB-INF/jsp/footer.jsp"%>			
		</div>
	</div>
<%@include file="../WEB-INF/jsp/commJs.jsp"%>

	
</body>
</html>
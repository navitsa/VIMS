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
						<h4 class="page-title">Create Test Category</h4>
						<ul class="breadcrumbs">
							<li class="nav-home">
								<a href="#">
									<i class="flaticon-home"></i>
								</a>
							</li>
							<li class="separator">
								<i class="flaticon-right-arrow"></i>
							</li>
							<li class="nav-item">
								<a href="#">Test Profiles</a>
							</li>
							<li class="separator">
								<i class="flaticon-right-arrow"></i>
							</li>
							<li class="nav-item">
								<a href="#">Test Categories</a>
							</li>
						</ul>
					</div>
				
					
								<div class="row">
						<div class="col-xl-6 col-md-6 mb-4">
							<!-- Success msg and Warning msg -->
							<c:if test="${success ==1}">
								<div class="alert alert-success alert-dismissible">
									<button type="button" class="close" data-dismiss="alert">&times;</button>
									<strong>Success!</strong> Data Successfully Saved.
								</div>
							</c:if>
							<c:if test="${success ==0}">
								<div class="alert alert-danger alert-dismissible">
									<button type="button" class="close" data-dismiss="alert">&times;</button>
									<strong>Warning!</strong>Something went wrong ! Please try again!
								</div>
							</c:if>
							
			              <div class="card shadow mb-4 border-left-primary">
			                <div class="card-body">

									<form:form action="saveTestCategory" method="POST"
										modelAttribute="testCategory" id="formCategory">

										<div class="form-group row">
											<div class="col-lg-8">
												<label for="categoryType">Test Category <span
													class="required text-danger">*</span></label>
												<form:input class="form-control" path="categoryType" 
													id="categoryType" />
												<form:errors path="categoryType" class="bg-danger text-white"/>
											</div>
											<div class="col-lg">
												<form:input type="hidden" path="categoryId" id="categoryId" />
											</div>
										</div>
										<div class="form-group row">
											<div class="col-lg-4">

												<label for="categoryFee">Test Fee <span
													class="required text-danger">*</span></label>
												<div class="input-group">
													<div class="input-group-prepend">
														<c:forEach items="${countryM}" var="c">
															<c:if test="${c.status == 'Active'}">
																<span class="input-group-text" id="basic-addon1">${c.currency}</span>
															</c:if>
														</c:forEach>
													</div>
													<form:input type="text" class="form-control"
														path="categoryFee" id="categoryFee"
														value="${testfee}" />
												</div>
												<form:errors path="categoryFee" class="bg-danger text-white"/>

											</div>
											<div class="col-lg">
												<label for="aptime">Approximate Inspection Duration 
													<span class="badge badge-info">minutes</span></label>
												<form:input class="form-control" path="testAproTime" id="aptime" style="width:80px;"/>
												<form:errors path="testAproTime" class="bg-danger text-white"/>
											</div>

										</div>
										<div class="form-group row">

											<div class="col-lg-6">

												<label for="testProfile">Test Profile <span class="required text-danger">*</span></label>
												<form:select path="testProfileId.testProfileID" class="custom-select" id="testProfile" required="true">
													<form:option value="0">--SELECT--</form:option>
													<c:forEach items="${testProfiles}" var="tpro">
														<form:option value="${tpro.testProfileID}">${tpro.testProfileName}</form:option>
													</c:forEach>
												</form:select>

											</div>
	
											<div class="col-lg-6">
												<label for="viProfile">Visual Profile <span class="required text-danger">*</span></label>
												<form:select path="viProfileId.visualProfileID" class="custom-select" id="viProfile" required="true">
													<form:option value="">--SELECT--</form:option>
													<c:forEach items="${profileNames}" var="vipro">
														<form:option value="${vipro.visualProfileID}">${vipro.profileName}</form:option>
													</c:forEach>
												</form:select>
											</div>

										</div>
										<div class="form-group row">
											<div class="col-lg">
												<label for="remarks">Remarks</label>
												<form:textarea path="remarks" class="form-control"/>
											</div>
										</div>

										<button type="submit" class="btn btn-success">Add Category</button>
										<button type="reset" class="btn btn-warning">Clear</button>

									</form:form>

								</div>
			              </div>
						
						</div>
						<div class="col-xl-6 col-md-6 mb-4">

							<div class="card shadow mb-4">
								<div class="card-body">
								
									<div id="tableCategory" class="scrollable  table-wrapper-scroll-y my-custom-scrollbar">
										<table class="table table-bordered">
											<thead>
												<tr>
													<th>Category</th>
													<th>Fee</th>
													<th>Duration (minutes)</th>
													<th>Test Profile</th>
													<th>Visual Profile</th>
													<th>Remark</th>
													<th></th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${cCategory}" var="cat">
													<tr>
														<td>${cat.categoryType}</td>
														<td align="right">${cat.categoryFee/100}</td>
														<td>${cat.testAproTime}</td>
														<td>${cat.testProfileId.testProfileName}</td>
														<td>${cat.viProfileId.profileName}</td>
														<td>${cat.remarks}</td>
														<td><a href="editDetails?id=${cat.categoryId}"><i
																class="fas fa-pen"></i></a></td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>

								</div>
							</div>

						</div>
					</div>	
				
				
				
					</div>
				
			</div>	
			<%@include file="../WEB-INF/jsp/footer.jsp"%>			
		</div>
	</div>
<%@include file="../WEB-INF/jsp/commJs.jsp"%>
	<script type="text/javascript">
	$(document).ready(function(){
		  $("#categoryFee").keypress(function(e){
		    var keyCode = e.which;
		    /*
		    8 - (backspace)
		    32 - (space)
		    48-57 - (0-9)Numbers
		    */
		    if ( (keyCode != 8 || keyCode ==32 ) && (keyCode < 48 || keyCode > 57)) { 
		      return false;
		    }
		  });
		  $("#aptime").keypress(function(e){
			    var keyCode = e.which;
			    /*
			    8 - (backspace)
			    32 - (space)
			    48-57 - (0-9)Numbers
			    */
			    if ( (keyCode != 8 || keyCode ==32 ) && (keyCode < 48 || keyCode > 57)) { 
			      return false;
			    }
			});
	});
	</script>
	
</body>
</html>
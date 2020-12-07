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
						<h4 class="page-title">Test Types</h4>
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
								<a href="#">Test Types</a>
							</li>
						
						</ul>
					</div>
				
						<div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
							<div class="col-xl-9 col-md-6 mb-4">
								<div class="card border-left-primary shadow h-100 py-2">
									<div class="card-body">
										<div class="row no-gutters align-items-center">
											<div class="col mr-2">
												<form:form action="testTypeAction" method="post" modelAttribute="test_type" enctype="multipart/form-data">
												
													<div class="form-group row">
														<div class="col-sm-4">
															<label>Test Type <span class="required text-danger ">*</span></label>
																<form:input class="form-control" path="type" />
																<form:errors path="type" cssClass="error1 text-danger" />
														</div>
														<div class="col-sm-5">
														</div>
														<div class="col-sm-3">
															<label>Test Type ID <span class="required text-danger ">*</span></label>
															<form:input class="form-control" path="typeId"/>
																	
														</div>
													</div>
													<div class="form-group row">
														<div class="col-sm-4">
															<label>Remarks </label>
																<form:input class="form-control form-control-user"
																	path="remarks" />
														</div>
													</div>
													<div class="form-group row">
														<div class="col-sm-4">
															<form:input type="file" class="file fontst" id="itemImage" path="image" ></form:input>
																<div class="input-group">
																	 <input type="text" class="form-control fontst" placeholder="Choose Image..." id="file"  disabled >
																	 <div class="input-group-append">
																	 	<button type="button" class="browse btn-sm btn-primary">Browse</button>
																	 </div>
																</div>
														</div>
											            <div class="col-sm-3">
											                <div class="ml-2 col-sm-6">
											                	<c:if test = "${test_type.image == null}">
											                 		<img src="<c:url value='/resources/img/empty-placeholder-image-icon.jpg'/>" id="preview" class="img-thumbnail"/>
											                 	</c:if>
											                 	<c:if test = "${test_type.image != null}">
																	 <img src="data:image/jpg;base64,${test_type.imageView}" id="preview" width="80" height="80" alt=""/>
																</c:if>
											                 </div>
											            </div>
													</div>
													<input type="submit" class="btn btn-primary" value="Add" />
													<input type="reset" class="btn btn-primary" value="Clear" />


												</form:form>
												<hr>
													<table class="table table-bordered tabStyle">
														<thead>
															<tr>
																<th>Test Type ID</th>
																<th>Test Type</th>
																<th>Image</th>
																<th>Remarks</th>
																<th></th>
																<th></th>
															</tr>
														</thead>
														<tbody>
															<c:forEach items="${testTypeList}" var="testType">
																<tr>
																	<td>${testType.typeId}</td>
																	<td>${testType.type}</td>
															        <td>
															        	<div>
															        		<c:if test = "${testType.image != null}">
															        			<img src="data:image/jpg;base64,${testType.imageView}" width="80" height="80" alt=""/>
															        		</c:if>
															        	</div>
															        </td>
															        <td>${testType.remarks}</td>
															        <td><div><a class="btn-sm btn-primary mt-2 btfont" href="callTestTypeEqumentType?typeid=${testType.typeId}">Add Equipment Type</a></div></td>
																	<td><a href="updatetestTypeInfo?typeId=${testType.typeId}"><i class="fas fa-pen"></i></a></td>
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
				
			</div>	
			<%@include file="../WEB-INF/jsp/footer.jsp"%>			
		</div>
	</div>
<%@include file="../WEB-INF/jsp/commJs.jsp"%>



</body>
</html>
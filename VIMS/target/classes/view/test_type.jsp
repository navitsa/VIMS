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
						<h4 class="page-title">Create Test Type</h4>
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
								<a href="#">Test Configurations</a>
							</li>
							<li class="separator">
								<i class="flaticon-right-arrow"></i>
							</li>
							<li class="nav-item">
								<a href="#">Test Types</a>
							</li>
						</ul>
					</div>

					<div class="row">
						<div class="col-xl-8 col-md-6 mb-4">
			              <div class="card shadow mb-4 border-left-primary">
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

								<form:form action="testTypeAction" method="post" modelAttribute="test_type" enctype="multipart/form-data">
								
									<div class="form-group row">
										<div class="col-sm-6">
											<label>Test Type ID <span class="required text-danger ">*</span></label>
											<form:input class="form-control" path="typeId"/>
											<form:errors path="typeId" class="bg-danger text-white" />
										</div>
									</div>
									<div class="form-group row">
										<div class="col-sm-6">
											<label>Test Type <span class="required text-danger ">*</span></label>
												<form:input class="form-control" path="type" />
												<form:errors path="type" class="bg-danger text-white" />
										</div>
									</div>
									<div class="form-group row">
										<div class="col-sm-6">
											<form:textarea path="remarks" class="form-control" placeholder="Remark"/>
										</div>
									</div>

									<div class="form-group row">
										<div class="col-lg-6">
											<form:input type="file" class="file" id="typeImage" path="image" ></form:input>
												<div class="input-group">
													 <input type="text" class="form-control" placeholder="Choose Image" id="file"  disabled >
													 <div class="input-group-append">
													 	<button type="button" class="browse btn btn-primary">Browse</button>
													 </div>
												</div>
										</div>
							            <div class="col-lg-3">
							            	<img src="" id="preview" class="img-thumbnail"/>
						                 	<c:if test = "${test_type.image != null}">
												 <img src="data:image/jpg;base64,${test_type.imageView}" id="preview" width="80" height="80" alt=""/>
											</c:if>

							            </div>
									</div>
									<div class="form-group row">
										<div class="col-lg">

											<div class="custom-control custom-radio custom-control-inline">
												<form:radiobutton path="status" class="custom-control-input" value="Active" 
													id="active" checked="checked" /> 
												<label class="custom-control-label" for="active">Active</label>
											</div>
											<div class="custom-control custom-radio custom-control-inline">
												<form:radiobutton path="status" class="custom-control-input" value="Inactive" 
													id="inactive"/> 
												<label class="custom-control-label" for="inactive">Inactive</label>
											</div>

										</div>
									</div>
									<div class="form-group row">
										<div class="col-lg">
											<input type="submit" class="btn btn-success" value="Add Type">
											<input type="reset" class="btn btn-warning mr-sm-2" value="Clear">
										</div>
									</div>
								</form:form>
								<br><br>
								<div class="table-responsive">
								<table id="example" class="display table table-bordered table-hover" cellspacing="0" width="100%">
									<thead>
										<tr>
											<th>Test Type ID</th>
											<th>Test Type</th>
											<th>Status</th>
											<th>Image</th>
											<th>Remarks</th>
											<th></th>
											<th></th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${testTypeList}" var="testType">
											<c:if test = "${testType.typeId != '0'}">
												<tr>
													<td>${testType.typeId}</td>
													<td>${testType.type}</td>
													<td>${testType.status}</td>
											        <td>
											        	<div>
											        		<c:if test = "${testType.image != null}">
											        			<img src="data:image/jpg;base64,${testType.imageView}" width="80" height="80" alt=""/>
											        		</c:if>
											        	</div>
											        </td>
											        <td>${testType.remarks}</td>
											        <td><a href="callTestTypeEqumentType?typeid=${testType.typeId}"><i class="fas fa-plus"></i> Equipment</a></td>
													<td><a href="updatetestTypeInfo?typeId=${testType.typeId}"><i class="fas fa-pen"></i></a></td>
												</tr>
											</c:if>
										</c:forEach>
									</tbody>
								</table>
								</div>

								
			                </div>
			               </div>
						</div>

						<div class="col-xl-4 col-md-6 mb-4"></div>
					</div>				
								

				</div>
			</div>	
			<%@include file="../WEB-INF/jsp/footer.jsp"%>			
		</div>
	</div>
<%@include file="../WEB-INF/jsp/commJs.jsp"%>

	<script>
		$(document).ready(function() {
		    $('#example').DataTable( {
		    	//"scrollY": "400px",
		    	"processing": true,
		        "columnDefs": [{ "orderable": false, "targets": 3 },
		        				{ "orderable": false, "targets": 4 },
		        				{ "orderable": false, "targets": 5 },
		        				{ "orderable": false, "targets": 6 }]
		    } );
		} );
	</script>
	
</body>
</html>
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
							<h4 class="page-title">Corporate information</h4>
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
									<a href="#">Lane Registration Types</a>
								</li>
								
							</ul>
						</div>
				
													
												<div
								class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
								<div class="col-xl-9">
									<div class="card border-left-primary shadow h-100 py-2">
										<div class="card-body">
											<div class="row no-gutters align-items-center">

												<div class="col mr-2">
												
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

													<form:form id="typesForm" action="saveVRegTypes"
														method="POST" modelAttribute="vehicleRegisterType">


														<form:input type="text" class="form-control"
															path="vRegTypeID" hidden="true" />
														<div class="form-group row">
															<div class="col-lg-3">
																<label for="vRegType">Entry Type <span class="required text-danger">*</span></label>
															</div>
															<div class="col-lg-6">
																<form:input type="text" class="form-control form-control-sm" id="vRegType" path="vRegType" />
																<form:errors path="vRegType" class="bg-danger text-white"/>
															</div>
														</div>
														<div class="form-group row">
															<div class="col-lg-3">
																<label for="remark">Remarks</label>
															</div>
															<div class="col-lg-6">
																<form:textarea path="remark" id="remark" class="form-control"/>
																<form:errors path="remark" class="bg-danger text-white"/>
															</div>
														</div>

														<div class="form-group row">
															<div class="col-lg-3">
																<label for="vTestFeePre">Test Fee % <span class="required text-danger">*</span></label>
															</div>
															<div class="col-lg-3">
																<form:input type="number" class="form-control form-control-sm" id="vTestFeePre" path="vTestFeePre" required="true" />
																<form:errors path="vTestFeePre" class="bg-danger text-white"/>
															</div>
															<div class="col-sm-3">
																<label for="sequenceId">Sequence <span class="required text-danger">*</span></label>
															</div>
															<div class="col-sm-3">
																<form:select class="custom-select custom-select-sm"
																	path="sequence" id="sequenceId" required="true">


																	<form:option value="1">1</form:option>
																	<form:option value="2">2</form:option>
																	<form:option value="3">3</form:option>
																	<form:option value="4">4</form:option>
																	<form:option value="5">5</form:option>
																	<form:option value="6">6</form:option>
																	<form:option value="7">7</form:option>
																	<form:option value="8">8</form:option>
																	<form:option value="9">9</form:option>
																</form:select>
															</div>
														</div>

														<div class="form-group row">
															<div class="col-sm-3">
																<label>Status</label>
															</div>
															<div class="col-sm-3">
																<input type="radio" name="status" value="Active"
																	checked="checked"> <label>Active</label>
																<input type="radio" name="status" value="Inactive">
																<label>Inactive</label>
															</div>
														</div>

														<table>
															<tr>
																<td>
																	<div class="col-sm-7 mb-1 mb-sm-3">
																		<input type="submit" class="btn btn-success"
																			value="Add Entry Type">
																	</div>
																</td>


																<td>
																	<div class="col-sm-7 mb-1 mb-sm-3">
																		<input type="button" class="btn btn-warning" onclick="clear1()" value="Clear">
																	</div>

																</td>
															</tr>
														</table>

													</form:form>


													<div id="tablelan" class="scrollable  table-wrapper-scroll-y my-custom-scrollbar">
														
														<table class="table table-bordered table-hover"
															width="100%" cellspacing="0">
															<thead>
																<tr>
																	<th>Sequence</th>
																	<th>Entry Type</th>
																	<th>Test Fee %</th>
																	<th>Remark</th>
																	<th>Status</th>
																	<th></th>
																</tr>
															</thead>
															<tbody id="myTable">
																<c:forEach items="${vehicleRegisterTypelist}"
																	var="vtypes">
																	<tr>
																		<td><div>${vtypes.sequence}</div></td>
																		<td><div>${vtypes.vRegType}</div></td>
																		<td><div>${vtypes.vTestFeePre}</div></td>
																		<td><div>${vtypes.remark}</div></td>
																		<td><div>${vtypes.status}</div></td>
																		<td><a
																			href="editVRegType?id=${vtypes.vRegTypeID}"><i
																				class="material-icons">&#xE254;</i></a></td>
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
				
			</div>	
			<%@include file="../WEB-INF/jsp/footer.jsp"%>			
		</div>
	</div>
<%@include file="../WEB-INF/jsp/commJs.jsp"%>

<script type="text/javascript">
		//clear form after/before submiting 

		function clear1() {
			/*Put all the data posting code here*/
			document.getElementById("vRegType").value = "";
			document.getElementById("remark").value = "";

		}
	</script>
	<script>
		$(document).ready(function(){
			  $("#vTestFeePre").keypress(function(e){
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
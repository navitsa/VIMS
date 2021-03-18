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
							<h4 class="page-title">Country Information</h4>
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
									<a href="#">Country Setting</a>
								</li>
								<li class="separator">
									<i class="flaticon-right-arrow"></i>
								</li>
								<li class="nav-item">
									<a href="taxConfiguration">Tax Configuration</a>
								</li>
								
								
							</ul>
						</div>
				
							<div
								class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
								<div class="col-xl-9 col-md-6mb-4 ">
									<div class="card border-left-primary shadow h-100 py-2">
										<div class="card-body">
											<div class="row no-gutters align-items-center">
												<div class="col mr-2">

													<form:form action="taxConfigurationSave" method="POST"
														modelAttribute="taxC">

														<form:input path="taxCode" type="hidden" id="taxCode" />

														<div class="form-group row">
															<div class="col-lg-4">

																<label for="tax">Tax <span class="required text-danger">*</span></label>
																<form:input class="form-control form-control-sm" path="tax" id="tax" />
																<form:errors path="tax" class="bg-danger text-white"/>

															</div>
															<div class="col-lg-4">

																<label for="cCode">Country <span class="required text-danger">*</span></label>
																<form:select path="countryCode" class="custom-select custom-select-sm"
																	id="cCode" required="true">
																	<form:option value="">Select Country</form:option>
																	<c:forEach items="${countrydeta}" var="c">
																		<c:if test="${c.status == 'Active'}">
																			<form:option selected="true" value="${c.countryCode}">${c.country}</form:option>
																		</c:if>
																		<c:if test="${c.status != 'Active'}">
																			<form:option value="${c.countryCode}">${c.country}</form:option>
																		</c:if>
																	</c:forEach>
																</form:select>
																<form:errors path="countryCode" class="bg-danger text-white"/>
															</div>
														</div>

														<div class="form-group row">
															<div class="col-lg-2">

																<label for="taxValue">Tax Value <span class="required text-danger">*</span></label>
																<input class="form-control" name="taxRaten"
																	id="taxValue" value="${etaxRate}" />
																<form:input class="form-control" path="taxRate"
																	id="taxValue" value="0" type="hidden" />

															</div>
															<div class="col-lg-3">
																<br>

																<div class="custom-control custom-radio">
																	<input type="radio" class="custom-control-input"
																		id="rate" name="type" value="Rate" checked> <label
																		class="custom-control-label" for="rate">Rate
																		(%)</label>
																</div>
																<div class="custom-control custom-radio">
																	<input type="radio" class="custom-control-input"
																		id="value" name="type" value="Value"> <label
																		class="custom-control-label" for="value">Value</label>
																</div>

															</div>

														</div>

														<div class="form-group row">
															<div class="col-lg-4">

																<label>GL Account</label>
																	<form:select path="glAccNo.glAccNo" class="custom-select custom-select-sm"
																	id="glAccNo1" required="true">
																	<form:option value="">Select GL Account</form:option>
																		<c:forEach items="${listTaxGLAccounts}" var="gl"> 
																			<form:option value="${gl.glAccNo}">${gl.glAccNo}-${gl.glAccountName}</form:option>
																	</c:forEach> 
																</form:select>
																

																	
																	
																	
																

															</div>
															<div class="col-lg-3">

																<label for="sequenceId">Sequence ID <span class="required text-danger">*</span></label>
																<form:select class="custom-select custom-select-sm" path="sequenceId"
																	id="sequenceId" required="Required">

																	<form:option value="0">0</form:option>
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

																<form:errors path="sequenceId" class="bg-danger text-white"/>

															</div>
														</div>

														<div class="form-group row">
															<div class="col-lg-4">
																<form:textarea class="form-control" placeholder="Remark" path="remarks" 
																	id="remarks"/>
																<form:errors path="remarks" class="bg-danger text-white"/>

															</div>
														</div>

														<div
															class="custom-control custom-radio  custom-control-inline">
															<input type="radio" class="custom-control-input"
																id="active" name="status" value="ACTIVE" checked>
															<label class="custom-control-label" for="active">Active</label>
														</div>
														<div
															class="custom-control custom-radio  custom-control-inline">
															<input type="radio" class="custom-control-input"
																id="inactive" name="status" value="INACTIVE"> <label
																class="custom-control-label" for="inactive">Inactive</label>
														</div>
														<br>
														<br>

														<input type="submit" class="btn btn-success" value="Add Tax">
														<input type="reset" class="btn btn-warning" value="Clear">


													</form:form>
													<br> <br>


													<table id="eqTypeTable"
														class="table table-bordered table-sm table-wrapper-scroll-y my-custom-scrollbar"
														cellspacing="0">


														<!-- <COLGROUP align="left"> -->
														<!-- <COLGROUP align="left"> -->
														<!-- <COLGROUP align="right" span="2"> -->
														<!-- <COLGROUP align="center"> -->
														<!-- <COLGROUP align="left"> -->
														<!-- <COLGROUP align="center"> -->
														<!-- <COLGROUP align="left"> -->
														<!-- <COLGROUP align="left"> -->

														<col width="85">
														<col width="200">
														<col width="85">
														<col width="0">
														<col width="0">
														<col width="120">
														<col width="75">
														<col width="0">
														<thead>
															<tr>
																<th>Tax id</th>
																<th>Tax</th>
																<th>Tax Value</th>
																<th>Type</th>
																<th>Remark</th>
																<th>Status</th>
																<th>GL Account</th>
																<th>Seq ID</th>
																<th></th>

															</tr>
														</thead>
														<tbody>
															<c:forEach items="${taxesList}" var="tax">
																<tr>
																	<td><div>${tax.taxCode}</div></td>
																	<td><div>${tax.tax}</div></td>
																	<td><div align="right" span="2">${(tax.taxRate)/100}</div></td>
																	<td><div>${tax.type}</div></td>
																	<td><div>${tax.remarks}</div></td>
																	<td><div>${tax.status}</div></td>
																	<td><div>${tax.glAccNo.glAccNo} ${tax.glAccNo.glAccountName}</div></td>
																	<td><div>${tax.sequenceId}</div></td>
																	<td><a href="updatetaxConf?taxCode=${tax.taxCode}"><i
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
				
			</div>	
			<%@include file="../WEB-INF/jsp/footer.jsp"%>			
		</div>
	</div>
<%@include file="../WEB-INF/jsp/commJs.jsp"%>



</body>
</html>
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
							<h4 class="page-title">Centers Organization</h4>
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
									<a href="#">Inspection Centers</a>
								</li>
						
							</ul>
						</div>
				
						
										<form:form action="saveCMaster" method="POST" modelAttribute="saveCMaster" id="form1"
							enctype="multipart/form-data">
							
							<form:input type="hidden" path="center_ID" value="${saveCMaster.center_ID}"/>

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

				              <div class="card shadow mb-4">
				                <div class="card-body">
				                
									<div class="form-group row">
										<div class="col-lg-6">
												<label for="cType">Center Type <span class="required text-danger">*</span></label><br>
												<form:select path="centerTypeID.centerTypeID"
													class="custom-select custom-select-sm" id="cType" name="cType"
													required="true">
													<form:option value="">Select Center Type</form:option>
													<c:forEach items="${cType}" var="CenterT">
														<form:option value="${CenterT.centerTypeID}">${CenterT.centerType}</form:option>
													</c:forEach>
												</form:select>
										</div>
									</div>
									<div class="form-group row">
										<div class="col-lg">
												<label for="cname">Center Name <span class="required text-danger">*</span></label>
												<form:input class="form-control form-control-sm"
													path="center" id="cname" value="${saveCMaster.center}" />
												<form:errors path="center" class="bg-danger text-white"/>
										</div>
									</div>
									<div class="form-group row">
										<div class="col-lg">
											<form:textarea class="form-control" placeholder="Address" path="add03" 
												id="add03" value="${saveCMaster.add03}" />
											<form:errors path="add03" class="bg-danger text-white"/>
										</div>
									</div>
									<div class="form-group row">
										<div class="col-lg-6">

												<label for="email">
												<i class="fa fa-envelope" style="font-size:24px;color:blue" aria-hidden="true"></i>
												  Email</label>
												<form:input type="email" class="form-control form-control-sm" 
													placeholder="example@gmail.com" path="email" id="email" 
													value="${saveCMaster.email}"/>
												<form:errors path="email" class="bg-danger text-white"/>

										</div>
									</div>
									<div class="form-group row">
										<div class="col-lg">
												<label for="contactPerson"><i class="fa fa-id-badge" style="font-size:24px;color:blue" aria-hidden="true"></i>
												  Contact Person
												</label>
												<form:input class="form-control form-control-sm"
													path="contactPersonID" id="contactPerson"
													value="${saveCMaster.contactPersonID}" />
												<form:errors path="contactPersonID" class="bg-danger text-white"/>

										</div>
										<div class="col-lg">
												<label for="tele">
												<i class="fa fa-phone-square text-primary" style="font-size:24px" aria-hidden="true"></i>
												  Mobile Number
												</label>
												<form:input class="form-control form-control-sm" path="tele"
													id="tele" value="${saveCMaster.tele}" />
												<form:errors path="tele" class="bg-danger text-white"/>
										</div>
									</div>
									<div class="form-group row">
										<div class="col-lg">
												<label for="openTime">
												<i class="fa fa-clock-o text-primary" style="font-size:24px" aria-hidden="true"></i>
												  Open Time :
												</label>
												<div class="input-group ">
													<input type="hidden" id="d1"/>
													<form:input type="time" path="openTime" name="openTime"
														id="openTime" class="form-control form-control-sm" 
														value="${saveCMaster.openTime}" />
												</div>
												<form:errors path="openTime" class="bg-danger text-white"/>

										</div>
										<div class="col-lg">

												<label for="closeTime">
												<i class="fa fa-clock-o text-primary" style="font-size:24px" aria-hidden="true"></i>
												  Close Time :</label>
												<div class="input-group">
													<input type="hidden" id="d2"/>
													<form:input type="time" path="closeTime" name="closeTime"
														id="closeTime" class="form-control form-control-sm"
														value="${saveCMaster.closeTime}" />
												</div>
												<form:errors path="closeTime" class="bg-danger text-white"/>
										</div>
										<div class="col-lg">
											<label>Total Hours :</label>
											<dl id="diff"></dl>
										</div>
									</div>
									
									<div class="form-group row">
										<label for="lanes" class="ml-3 text-gray-900">Number of Test Lanes
										 <span class="required text-danger">*</span></label>
										<div class="col-lg-3">
												<form:input type="number" class="form-control form-control-sm"
													placeholder="0" path="lanes" id="lanes" min="1" max="99" 
													value="${saveCMaster.lanes}" />
										</div>
										<form:errors path="lanes" class="bg-danger text-white"/>
									</div>
									<div class="form-group row">
										<div class="col-lg">
											<label for="esInPath" class="text-gray-900">
											<i class="fa fa-sign-in" style="font-size:24px;color:blue" aria-hidden="true"></i>
											   ES in Path <span class="required text-danger">*</span></label>
											<form:input class="form-control form-control-sm" path="esInPath" id="esInPath"/>
											<form:errors path="esInPath" class="bg-danger text-white"/>
										</div>
									</div>
									<div class="form-group row">
										<div class="col-lg">
											<label for="esOutPath" class="text-gray-900">
											<i class="fa fa-sign-out" style="font-size:24px;color:blue" aria-hidden="true"></i>
											   ES out Path <span class="required text-danger">*</span></label>
											<form:input class="form-control form-control-sm" path="esOutPath" id="esOutPath"/>
											<form:errors path="esOutPath" class="bg-danger text-white"/>
										</div>
									</div>
									
									
									<div class="form-group row">
										<div class="col-lg">
											<label for="esInPath" class="text-gray-900">
											<i class="fa fa-sign-in" style="font-size:24px;color:blue" aria-hidden="true"></i>
											   ES in XML Path <span class="required text-danger">*</span></label>
											<form:input class="form-control form-control-sm" path="esInXmlPath" id="esInXmlPath"/>
											<form:errors path="esInXmlPath" class="bg-danger text-white"/>
										</div>
									</div>
									
									

									<input type="submit" class="btn btn-primary" value="Save">
									<input type="reset" class="btn btn-warning" value="Clear">	

				                </div>
				              </div>
				              
							</div><!-- 1 column end -->
							
							<div class="col-xl-4 col-md-6 mb-4">

								<div class="card shadow mb-4 ">
								   
								<a href="#collapseCardExample" class="d-block card-header bg-primary" 
									data-toggle="collapse" role="button" aria-expanded="true" aria-controls="collapseCardExample">
									<h6 class="m-0 font-weight-bold text-white">Country & Partner</h6>
								</a>
									<div class="collapse hide" id="collapseCardExample">
								    <div class="card-body">
<!-- 			                			<div class="form-group row"> -->
<!-- 											<div class="col-lg"> -->

<!-- 												<label for="cCode">Country</label><br> -->
<%-- 												<form:select path="countrycode.countryCode" --%>
<%-- 													class="custom-select custom-select-sm" id="cCode" --%>
<%-- 													onchange="getCountryDetails()" required="true"> --%>
<%-- 													<form:option value="">Select Country</form:option> --%>
<%-- 													<c:forEach items="${country}" var="c"> --%>
<%-- 														<c:if test="${c.status == 'Active'}"> --%>
<%-- 															<form:option selected="true" value="${c.countryCode}">${c.country}</form:option> --%>
<%-- 														</c:if> --%>
<%-- 														<c:if test="${c.status != 'Active'}"> --%>
<%-- 															<form:option value="${c.countryCode}">${c.country}</form:option> --%>
<%-- 														</c:if> --%>
<%-- 													</c:forEach> --%>
<%-- 												</form:select> --%>

<!-- 											</div> -->
<!-- 										</div> -->
			                			<div class="form-group row">
											<div class="col-lg">

												<label for="bPartner">Business Partner</label><br>
												<form:select path="partner_ID.partner_ID"
													class="custom-select custom-select-sm" id="bPartner"
													required="true">
													<form:option value="">Select Business Partner</form:option>
													<c:forEach items="${business}" var="bs">
														<c:if test="${bs.defaultPartner == 'Active'}">
															<form:option selected="true" value="${bs.partner_ID}">${bs.partner_Name}</form:option>
														</c:if>
														<c:if test="${bs.defaultPartner != 'Active'}">
															<form:option value="${bs.partner_ID}">${bs.partner_Name}</form:option>
														</c:if>
													</c:forEach>
												</form:select>

											</div>
										</div>
								    </div>
								    </div>
								</div>
								
								<div class="card shadow mb-4 ">
								    <div class="card-header bg-primary">
								      <h6 class="m-0 font-weight-bold text-white">Google Map</h6>
								    </div>
								    <div class="card-body">
								    	<div id="map"></div>
								    </div>
								</div>
								<div class="card shadow mb-4 ">
									<a href="#collapseCardExample" class="d-block card-header bg-primary" 
										data-toggle="collapse" role="button" aria-expanded="true" aria-controls="collapseCardExample">
										<h6 class="m-0 font-weight-bold text-white">Center View</h6>
									</a>
									<div class="collapse show" id="collapseCardExample">
									    <div class="card-body">
											<div class="form-group row">
												<form:input type="file" class="file" id="center_image" path="center_image" ></form:input>
													<div class="input-group">
														 <input type="text" class="form-control" placeholder="Choose Image..." id="file"  disabled >
														 <div class="input-group-append">
														 	<button type="button" class="browse btn btn-primary">Browse</button>
														 </div>
													</div> 
											</div>
											<div class="form-group row">
							                	<c:if test = "${saveCMaster.center_image == null}">
							                 		<img src="<c:url value='/resources/img/empty-placeholder-image-icon.jpg'/>" id="preview" 
							                 			class="img-thumbnail" width="90" height="90"/>
							                 	</c:if>
							                 	<c:if test = "${saveCMaster.center_image != null}">
													 <img src="data:image/jpg;base64,${img}" id="preview" width="90" height="90" alt=""/>
												</c:if>
											</div>
									    </div>
									</div>
								</div>
								
				              
							</div><!-- 2 column end -->				
						</div>
						<!-- 1 row end -->
					</form:form>
					
					<div class="row">
						<div class="col-xl col-md-6 mb-4">
							<div class="card shadow mb-4 ">
								<a href="#collapseCardExample3" class="d-block card-header bg-primary" 
									data-toggle="collapse" role="button" aria-expanded="true" aria-controls="collapseCardExample3">
									<h6 class="m-0 font-weight-bold text-white">Inspection Centers</h6>
								</a>
							    	<div class="collapse hide" id="collapseCardExample3">
									    <div class="card-body">
		
												<table class="display" id="example" style="width:100%">
													<thead>
														<tr>
															<th>Country</th>
															<th>Partner</th>
															<th>Type</th>
															<th>Center</th>
															<th>Address</th>
															<th>Email</th>
															<th>Contact Person</th>
															<th>Mobile No</th>
															<th>Number Of Lanes</th>
															<th>Open Time</th>
															<th>Close Time</th>
															<th>ES in Path</th>
															<th>ES out Path</th>
															<th>ES in XML Path</th>
															<th>Center Image</th>
															<th></th>
														</tr>
													</thead>
		
													<tbody>
														<c:forEach items="${centerMasterlist}" var="cem">
															<tr>
																<td>${cem.countrycode.country}</td>
																<td>${cem.partner_ID.partner_Name}</td>
																<td>${cem.centerTypeID.centerType}</td>
																<td>${cem.center}</td>
																<td>${cem.add03}</td>
																<td>${cem.email}</td>
																<td>${cem.contactPersonID}</td>
																<td>${cem.tele}</td>
																<td>${cem.lanes}</td>
																<td>${cem.openTime}</td>
																<td>${cem.closeTime}</td>
																<td>${cem.esInPath}</td>
																<td>${cem.esOutPath}</td>
																<td>${cem.esInXmlPath}</td>
																
																<td>
																	<c:if test="${cem.center_image != null}">
																		<img src="data:image/jpg;base64,${cem.center_imageView}"
																			width="80" height="80"/>
																	</c:if>
																</td>
																<td>
																	<a href="updateInfo?center_ID=${cem.center_ID}"><i class="material-icons">&#xE254;</i></a>
																</td>
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

	<script>
	$(document).ready(function() {
	    $('#example').DataTable( {
	    	"scrollY": "400px",
	    	"processing": true
	    } );
	} );
	</script>

</body>
</html>
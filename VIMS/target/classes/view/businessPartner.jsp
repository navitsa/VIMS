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
									<a href="#">Business Partner</a>
								</li>
								
							</ul>
						</div>
				
													
										<form:form action="saveBPartner" method="POST" modelAttribute="bisPartner" id="form1"
							enctype="multipart/form-data">

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
			                		
			                		<form:input path="partner_ID" type="hidden"/>
			                		
			                		<div class="form-group row">
										<div class="col-lg">
											<label for="pname">Partner Name <span class="required text-danger">*</span></label>
											<form:input class="form-control form-control-sm"
												path="partner_Name" id="pname" />
											<form:errors path="partner_Name" class="bg-danger text-white" />
										</div>

									</div>
									<div class="form-group row">
										<div class="col-lg">
											<label for="web">
											<i class="fa fa-globe" style="font-size:24px;color:blue" aria-hidden="true"></i>
											   Web Site</label>
											<form:input class="form-control form-control-sm" path="web"
											placeholder="www.example.com" id="web"/>
											<form:errors path="web" class="bg-danger text-white"/>
										</div>
										<div class="col-lg">
											<label for="email">
											<i class="fa fa-envelope" style="font-size:24px;color:blue" aria-hidden="true"></i>
											   Email</label>
											<form:input type="email" class="form-control form-control-sm" 
												path="email" placeholder="example@gmail.com" id="email"/>
											<form:errors path="email" class="bg-danger text-white"/>
										</div>
									</div>
									
									<div class="form-group row">
										<div class="col-lg">
											<label for="contact_Per">
											<i class="fa fa-id-badge" style="font-size:24px;color:blue" aria-hidden="true"></i>
											   Contact Person</label>
											<form:input class="form-control form-control-sm" 
												path="contact_Per" id="contact_Per"/>
											<form:errors path="contact_Per" class="bg-danger text-white"/>
										</div>
										<div class="col-lg">
											<label for="tele">
											<i class="fa fa-phone-square" style="font-size:24px;color:blue" aria-hidden="true"></i>
											   Mobile No</label>
											<form:input class="form-control form-control-sm" 
												path="tele" id="tele"/>
											<form:errors path="tele" class="bg-danger text-white"/>
										</div>
									</div>
									
									<div class="form-group row">
										<div class="col-lg-4">
											<label for="country">Country</label><br>
											<form:select path="country_Code.countryCode"
												class="custom-select" id="country" required="true">
												
												<form:option value="">Select Country</form:option>
												<c:forEach items="${country}" var="c">
													<c:if test="${c.status == 'Active'}">
														<form:option selected="true" value="${c.countryCode}">${c.country}</form:option>
													</c:if>
<%-- 													<c:if test="${c.status == 'Active'}"> --%>
														<form:option value="${c.countryCode}">${c.country}</form:option>
<%-- 													</c:if> --%>
												</c:forEach>
												
											</form:select>
										</div>
									</div>
									<div class="form-group row">
										<div class="col-lg">
											<form:textarea class="form-control" placeholder="Address" path="address" />
										</div>
									</div>
									
									<div class="form-group row">
										<div class="col-lg">
											<form:input type="file" class="file" id="partner_Logo" path="partner_Logo" 
												accept="image/*" ></form:input>
												<div class="input-group">
													 <input type="text" class="form-control" placeholder="Partner Logo..." id="file"  disabled >
													 <div class="input-group-append">
													 	<button type="button" class="browse btn btn-primary">Browse</button>
													 </div>
												</div>
										</div>
							            <div class="col-lg">
							                <div class="ml-2 col-sm-6">
							                	<c:if test = "${bisPartner.partner_Logo == null}">
							                 		<img src="<c:url value='/resources/img/empty-placeholder-image-icon.jpg'/>" id="preview" class="img-thumbnail"/>
							                 	</c:if>
							                 	<c:if test = "${bisPartner.partner_Logo != null}">
													 <img src="data:image/jpg;base64,${img}" id="preview" width="80" height="80" alt=""/>
												</c:if>
							                 </div>
							            </div>
									</div>

								  <div class="custom-control custom-checkbox">
								    <input type="checkbox" class="custom-control-input" id="customCheck" name="defaultPartner" value="Active">
								    <label class="custom-control-label" for="customCheck">Set as Default Partner</label>
								  </div>
								  <br>
								  
									<button type="submit" class="btn btn-success">Add Partner</button>
									<button type="reset" class="btn btn-warning">Clear</button>
									
									<br><br>

			                </div>
			              </div>
			              
						</div>
						
						<div class="col-xl-4 col-md-6 mb-4">
						
			              <div class="card shadow mb-4">
							<a href="#collapseReceipt" class="d-block card-header bg-primary" 
								data-toggle="collapse" role="button" aria-expanded="true" aria-controls="collapseReceipt">
								<h6 class="m-0 font-weight-bold text-white">Receipt Layout</h6>
							</a>
							<div class="collapse hide" id="collapseReceipt">
				                <div class="card-body">
			                		<div class="form-group row">
										<div class="col-lg">
											<label for="receiptHeader">Receipt Header</label>
											<form:textarea class="form-control" path="receiptHeader" id="receiptHeader"/>
											<form:errors path="receiptHeader" class="bg-danger text-white"/>
										</div>
									</div>
			                		<div class="form-group row">
										<div class="col-lg">
											<label for="receiptFooter">Receipt Footer</label>
											<form:textarea class="form-control" path="receiptFooter" id="receiptFooter"/>
											<form:errors path="receiptFooter" class="bg-danger text-white"/>
										</div>
									</div>
			                		<div class="form-group row">
										<div class="col-lg">
											<label for=maxRecNo>Last Receipt Sequence No</label>
											<form:input class="form-control form-control-sm" 
												path="maxRecNo" id="maxRecNo"/>
											<form:errors path="maxRecNo" class="bg-danger text-white"/>
										</div>
									</div>
			                		<div class="form-group row">
										<div class="col-lg">
											<label for="recformate">Receipt No. Format</label>
											<form:input class="form-control form-control-sm" 
												path="recformate" id="recformate" placeholder="Example: REC/"/>
											<form:errors path="recformate" class="bg-danger text-white"/>
										</div>
									</div>
									
				                </div>
				             </div>
			              </div>
			              
							<div class="card shadow mb-4 ">
								<a href="#collapseTestReport" class="d-block card-header bg-primary" 
									data-toggle="collapse" role="button" aria-expanded="true" aria-controls="collapseTestReport">
									<h6 class="m-0 font-weight-bold text-white">Test Report Layout</h6>
								</a>
								<div class="collapse hide" id="collapseTestReport">
								    <div class="card-body">
			                			<div class="form-group row">
											<div class="col-lg">
												<label for="reportHeader">Report Header</label>
												<form:textarea class="form-control" path="reportHeader" id="reportHeader"/>
												<form:errors path="reportHeader" class="bg-danger text-white"/>
											</div>
										</div>
			                			<div class="form-group row">
											<div class="col-lg">
												<label for="reportFooter">Report Footer</label>
												<form:textarea class="form-control" path="reportFooter" id="reportFooter"/>
												<form:errors path="reportFooter" class="bg-danger text-white"/>
											</div>
										</div>
								    </div>
								</div>
							</div>
			              
						</div>						
					</div>
					<!-- 1 row end -->
					
					<div class="row">
						<div class="col-xl col-md-6 mb-4">
							<div class="card shadow mb-4 ">
								<a href="#collapseCardExample" class="d-block card-header bg-primary" 
									data-toggle="collapse" role="button" aria-expanded="true" aria-controls="collapseCardExample">
									<h6 class="m-0 font-weight-bold text-white">Business Partners</h6>
								</a>
							    	<div class="collapse hide" id="collapseCardExample">
									    <div class="card-body">
		
												<table class="display" id="example" style="width:100%">
													<thead>
														<tr>
															<th>Partner</th>
															<th>Web Site</th>
															<th>Email</th>
															<th>Contact Person</th>
															<th>Mobile No</th>
															<th>Country</th>
															<th>Address</th>
															<th>Logo</th>
															<th>Status</th>
															<th>Receipt Header</th>
															<th>Receipt Footer</th>
															<th>Receipt No</th>
															<th>Receipt No Format</th>
															<th>Report Header</th>
															<th>Report Footer</th>
															<th></th>
														</tr>
													</thead>
		
													<tbody>
														<c:forEach items="${listPartner}" var="p">
															<tr>
																<td>${p.partner_Name}</td>
																<td>${p.web}</td>
																<td>${p.email}</td>
																<td>${p.contact_Per}</td>
																<td>${p.tele}</td>
																<td>${p.country_Code.country}</td>
																<td>${p.address}</td>
																<td>
																	<c:if test="${p.partner_Logo != null}">
																		<img src="data:image/jpg;base64,${p.partnerImgView}"
																			width="80" height="80"/>
																	</c:if>
																</td>
																<td>${p.defaultPartner}</td>
																<td>${p.receiptHeader}</td>
																<td>${p.receiptFooter}</td>
																<td>${p.maxRecNo}</td>
																<td>${p.recformate}</td>
																<td>${p.reportHeader}</td>
																<td>${p.reportFooter}</td>
																<td><a href="editPartner?partner_ID=${p.partner_ID}"><i
																		class="fas fa-pen"></i></a>
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
					<!-- 2 row end -->
					</form:form>	

	
				
				
				
				
				
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
	    	"processing": true,
	        "columnDefs": [{ "orderable": false, "targets": 4 }]
	    } );
	} );
	</script>

</body>
</html>
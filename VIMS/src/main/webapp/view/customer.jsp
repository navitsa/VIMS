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
							<h4 class="page-title">Customer</h4>
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
									<a href="#"></a>
								</li>
							
							</ul>
						</div>
				
						<div
								class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
							
						<div class="col-xl-6 col-md-6 mb-4">

			              <div class="card shadow mb-4 border-left-primary">
			                <div class="card-body">

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

				                <form:form action="saveCustomer" method="post" modelAttribute="newcustomer">
			                		<div class="form-group row">
										<div class="col-lg">
											<label class="l-fontst">Customer Name</label>
											<form:input class="form-control form-control-sm fontst" path="name" required="true"/>
										</div>
									</div>
			                		<div class="form-group row">
										<div class="col-lg">
											<form:textarea class="form-control fontst"  path="address" placeholder="Addres" required="true"/>
										</div>
									</div>									
									
									
									
									
			                		<div class="form-group row">
										<div class="col-lg-6">
											<label class="l-fontst">Mobile No</label>
											<form:input class="form-control form-control-sm fontst" path="tpno" required="true"/>
										</div>
										<div class="col-lg-6">
										<label class="l-fontst">Email</label> 
										<form:input class="form-control form-control-sm fontst" type="email" path="email" placeholder="example@gmail.com"  />
										</div>
									</div>

			                		<div class="form-group row">
										<div class="col-lg-6">
										<label class="l-fontst">Tax Code</label> 
										<form:input class="form-control form-control-sm fontst" path="taxcode"/>
										</div>
										<div class="col-lg-6">
											<div class="form-group row">
												<div class="col-lg-12">
													<input type="checkbox" class="custom-control-input fontst fontstc" id="customCheck" name="isCredeit" value="Credit" onclick="customerCredit()">
								    				<label class="custom-control-label l-fontst fontstc" for="customCheck">is Credit</label>
								    				<label class="l1-fontst crmr" style="display:none" id="crLimitidL">Credit Limit</label> 
								    				<form:input class="form-control form-control-sm fonts" style="display:none" id="crLimitid" path="crLimit" value="0"/>
								    				<label class="l1-fontst" style="display:none" id="crBalanceidL">Credit Balance</label> 
								    				<form:input class="form-control form-control-sm fonts" style="display:none" id="crBalanceid" path="crBalance" value="0"/>
								    				
												</div>
											</div>
												
										</div>
										
										
										
									
									</div>
									<div class="form-group row">
										<div class="col-lg-1"></div>

									</div>
									
									
									
									<input type="submit" class="btn btn-success" value="Add Customer"/>
									<input type="reset" class="btn btn-warning" value="Clear"/>
								
								</form:form>
			                </div>
			              </div>
						
						</div>

						<div class="col-xl-6 col-md-6 mb-4">
				              <div class="card shadow mb-4">
				                <div class="card-body tabStyle">

									<table class="display tabStyle table-striped table-bordered table-sm table-wrapper-scroll-y my-custom-scrollbar" id="example" style="width:100%">
										<thead>
											<tr>
												
												<th>Name</th>
												<th>Mobile No</th>
												<th>Address</th>
												<th>Email</th>
												<th>Tax Code</th>
												<th>Payment Type</th>
												<th>Credit Limit</th>
												<th>Credit Balance</th>
																			
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${allcus}" var="customer">
												<c:if test="${customer.id !='0000'}">	
													<tr>												
														<td>${customer.name}</td>
														<td>${customer.tpno}</td>
														<td>${customer.address}</td>
														<td>${customer.email}</td>
														<td>${customer.taxcode}</td>
														
															<td>
																<c:if test="${customer.isCredeit !=null}">
																${customer.isCredeit}
																</c:if>
																<c:if test="${customer.isCredeit ==null}">
																Cash
																</c:if>	
															</td>
															<td>
															${customer.crLimit}
															</td>
															<td>
															${customer.crBalance}
															</td>
															
														<td><a
															href="editCustomer?id=${customer.id}"><i
																class="material-icons">&#xE254;</i></a>
														</td>
														
													</tr>
												</c:if>
											</c:forEach>
										</tbody>
									</table>

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
// 	$(document).ready(function() {
// 	    $('#example').DataTable( {
// 	    	"scrollY": "400px",
// 	    	"processing": true,
// 	        "columnDefs": [{ "orderable": false, "targets": 4 }]
// 	    } );
// 	} );
	
	
	function customerCredit() {
		  var checkBox = document.getElementById("customCheck");
		  var crLimitid = document.getElementById("crLimitid");
		  var crBalanceid = document.getElementById("crBalanceid");
		  var crLimitidL = document.getElementById("crLimitidL");
		  var crBalanceidL = document.getElementById("crBalanceidL");
		  
		  if (checkBox.checked == true){
			  crLimitid.style.display = "block";
			  crBalanceid.style.display = "block";
			  crLimitidL.style.display = "block";
			  crBalanceidL.style.display = "block";
		  } else {
			  crLimitid.style.display = "none";
			  crBalanceid.style.display = "none";
			  crLimitidL.style.display = "none";
			  crBalanceidL.style.display = "none";
		  }
		}
	
	

	
	
	</script>

</body>
</html>
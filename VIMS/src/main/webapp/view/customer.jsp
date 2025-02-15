<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ page isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>



<html lang="en">
<head>
<%@include file="../WEB-INF/jsp/head.jsp"%>
</head>
<body onload="crBalanceAdd()">
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
							<li class="nav-home"><a href="#"> <i
									class="flaticon-home"></i>
							</a></li>
							<li class="separator"><i class="flaticon-right-arrow"></i></li>
							<li class="nav-item"><a href="#"></a></li>

						</ul>
					</div>

					<div
						class="card-header py-3 d-flex flex-row align-items-center justify-content-between">

						<div class="col-xl-6 col-md-6 mb-4">

							<div class="card shadow mb-4 border-left-primary"
								style="height: 70vh;">
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
											<strong>Warning!</strong>Something went wrong ! Please try
											again!
										</div>
									</c:if>

									<form:form action="saveCustomer" method="post"
										modelAttribute="newcustomer" onsubmit="return validateForm()">
										<form:input class="form-control form-control-sm fontst"
											path="id" hidden="true" />

										<div class="form-group row">
											<div class="col-lg">
												<label class="l-fontst">Customer Name</label>
												<form:input class="form-control form-control-sm fontst"
													path="name" required="true" />
											</div>
										</div>
										<div class="form-group row">
											<div class="col-lg">
												<form:textarea class="form-control fontst" path="address"
													placeholder="Addres" required="true" />
											</div>
										</div>

										<div class="form-group row">
											<div class="col-lg-6">
												<label class="l-fontst">Mobile No</label>
												<form:input class="form-control form-control-sm fontst"
													path="tpno" required="true" />
											</div>
											<div class="col-lg-6">
												<label class="l-fontst">Email</label>
												<form:input class="form-control form-control-sm fontst"
													type="email" path="email" placeholder="example@gmail.com" />
											</div>
										</div>

										<div class="form-group row">
											<div class="col-lg-6">
												<label class="l-fontst">Tax Code</label>
												<form:input class="form-control form-control-sm fontst"
													path="taxcode" />
											</div>
											<div class="col-lg-6">
												<div class="form-group row">
													<div class="col-lg-12">
														<form:checkbox class="custom-control-input fontst fontstc"
															id="customCheck" path="isCredeit" value="Credit"
															onclick="" />
														<label class="custom-control-label l-fontst fontstc"
															for="customCheck">is Credit</label> <br> <label
															class="l1-fontst crmr" style="" id="crLimitidL">Credit
															Limit</label>
														<form:input class="form-control form-control-sm fonts"
															style="" id="crLimitid" path="crLimit" value="" onchange="myction()"
															/>
														<label class="l1-fontst" style="" id="crBalanceidL">Credit
															Balance</label>
														<form:input class="form-control form-control-sm fonts"
															style="" id="crBalanceid" path="crBalance" value="" />

														<input class="form-control form-control-sm fonts" style=""
															id="oldcrLimits" name="oldcrLimitid" value="0" hidden="true" />

														<input class="form-control form-control-sm fonts" style=""
															id="oldcrBalance" name="oldcrBalance" value="0" hidden="true"
															 />


													</div>
												</div>

											</div>

										</div>
										<div class="form-group row">
											<div class="col-lg-1"></div>

										</div>

										<input type="submit" class="btn btn-success"
											value="Add Customer" />
										<input type="reset" class="btn btn-warning" value="Clear" />

									</form:form>
								</div>
							</div>

						</div>

						<div class="col-xl-6 col-md-6 mb-4">
							<div class="card shadow mb-4" style="height: 70vh;">
								<div class="card-body tabStyle">

									<table
										class="display tabStyle table-striped table-bordered table-sm table-wrapper-scroll-y my-custom-scrollbar"
										id="example" style="width: 100%; height: 60vh;">
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

														<td><c:if test="${customer.isCredeit !=null}">
																${customer.isCredeit}
																</c:if> <c:if test="${customer.isCredeit ==null}">
																Cash
																</c:if></td>
														<td>${customer.crLimit/100}</td>
														<td>${customer.crBalance/100}</td>

														<td><a href="editCustomer?id=${customer.id}"><i
																class="material-icons" onclick="readOnly()">&#xE254;</i></a></td>

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
			
function myction() {
	var x = document.getElementById("oldcrLimits").value;
	var y = document.getElementById("oldcrBalance").value;
	var a = document.getElementById("crLimitid").value;
	
	if(x<a){

document.getElementById("crBalanceid").value =(parseFloat(y)+parseFloat(a)-parseFloat(x))

	}else{
		
		alert("Credite limit less than old limit");
		
	}
}
		
		
	 readOnly();
			function readOnly() {
		var a = document.getElementById("crBalanceid").value;
		if(${edit}=="1"){
			
			var crLimitid = document.getElementById("crLimitid").value;
			var crBalanceid =  document.getElementById("crBalanceid").value;
			document.getElementById("oldcrLimits").value = crLimitid;
			document.getElementById("oldcrBalance").value = crBalanceid;
			
			document.getElementById("crBalanceid").readOnly = true;
			
		}
			
		}
		

		function customerCredit() {
			var checkBox = document.getElementById("customCheck");
			var crLimitid = document.getElementById("crLimitid");
			var crBalanceid = document.getElementById("crBalanceid");
			var crLimitidL = document.getElementById("crLimitidL");
			var crBalanceidL = document.getElementById("crBalanceidL");

			if (checkBox.checked == true) {
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

		function validateForm() {
			var checkBox = document.getElementById("customCheck");
			var crLimitid = document.getElementById("crLimitid").value;
			var crBalanceid = document.getElementById("crBalanceid").value;
			var crLimitidL = document.getElementById("crLimitidL");
			var crBalanceidL = document.getElementById("crBalanceidL");

			console.log(crLimitid);
			console.log(crBalanceid);
			if (checkBox.checked == true) {
				if (crLimitid == "" || isNaN(crLimitid)) {
					swal("Credit limit value is empty or not a number!", "", {
						icon : "error",
						buttons : {
							confirm : {
								className : 'btn btn-danger'
							}
						},
					});
					return false;
				} else if (crBalanceid == "" || isNaN(crBalanceid)) {
					swal("Credit balance value is empty or not a number!", "",
							{
								icon : "error",
								buttons : {
									confirm : {
										className : 'btn btn-danger'
									}
								},
							});
					return false;
				}
			}

		}
	</script>

</body>
</html>

<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ page isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>



<html lang="en">
<head>
<%@include file="../WEB-INF/jsp/head.jsp"%>

<style>
.vidSty {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 30px;
	font-weight: bold;
	color: #02d41b;
}

.textred {
	font-family: Arial, Helvetica, sans-serif;
	border: 0px solid #b30000;
	font-size: 14px;
	font-weight: bold;
	text-align: center;
	color: #2c03fc;
}

.fontst {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	height: 30px;
}

.l-fontst {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	height: 5px;
	margin-top: 0px;
}

.iconali {
	position: absolute;
	top: 6px;
	right: -7px;
}

.capCam {
	height: 100px;
	width: 210px;
}

.cursiz {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	width: 48px;
	color: #ff8000;
}

.amt {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	width: 60px;
	color: blue;
	text-align: right;
}

.iconstyle {
	width: 7%;
	color: blue';
}

.icon-pre-ve {
	width: 150%;
}
</style>

</head>
<body onload="checkStatusofDropdowns();">
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
				<div class="panel-header bg-primary-gradient">
					<div class="page-inner py-3">
						<div
							class="d-flex align-items-left align-items-md-center flex-column flex-md-row">
							<div class="col-xl-2 col-lg-2">
								<h2 class="text-white pb-2 fw-bold">AP Invoice</h2>
							</div>
							<div class="col-xl-2 col-lg-2"></div>
							<div class="ml-md-auto py-2 py-md-4"></div>

							<div class="ml-md-auto py-2 py-md-4"></div>
						</div>
					</div>
				</div>

				<div class="page-inner mt--5">
					<div class="container-fluid">

						<form:form action="saveAPInvoice" method="post"
							modelAttribute="apInvoiceForm" enctype="multipart/form-data"
							id="formMake">

							<div class="row">

								<div class="col-xl-5 col-lg-5">
									<!-- Card -->

									<div class="card shadow mb-4" style="height: 640px;">
										<div class="card-body">
											<!-- <div class="form-group row">
												<div class="col-sm-4">
													<label class="l-fontst">AP Invoice Head ID</label>
												</div>
												<div class="col-sm-6">
													<input class="form-control fontst" type="text"
														name="apInvoiceHeadId" onchange="" id="apInvoiceHeadId"
														readonly="true" />
												</div>
											</div> -->
											<div class="form-group row">
												<div class="col-sm-4">
													<label class="l-fontst">Supplier</label>
												</div>
												<div class="col-sm-6">
													<input class="form-control fontst" type="text"
														name="supplierId" onchange="" id="supplierId" />
												</div>
											</div>
											<div class="form-group row">
												<div class="col-sm-4">
													<label class="l-fontst">Supplier GL Account No</label>
												</div>
												<div class="col-sm-6">
													<input class="form-control fontst" type="text"
														name="supplierGlCode" onchange="" id="supplierGlCode" />

												</div>
											</div>
											<div class="form-group row">
												<div class="col-sm-4">
													<label class="l-fontst">Date</label>
												</div>
												<div class="col-sm-6">
													<input class="form-control fontst" type="date" name="date"
														onchange="" id="apInvoiceDate" />
												</div>
											</div>
											<hr>
											<div class="form-group row">
												<div class="col-sm-4">
													<label class="l-fontst">Net Total</label>
												</div>
												<div class="col-sm-6">
													<input class="form-control fontst" type="text"
														name="netTotal" onchange="" id="netTotal" readonly />
												</div>
											</div>
											<hr>

											<div class="form-group row">
												<div class="col-sm-5">
													<button type="submit"
														class="btn  btn-block btn-success btn-rounded tabStyle">Add
														AP Invoice</button>
												</div>
												<div class="col-sm-3">
													<button type="reset"
														class="btn  btn-block btn-danger btn-rounded tabStyle">Reset</button>
												</div>
											</div>

										</div>
										<!-- End of card body -->
									</div>
								</div>

								<div class="col-xl-7 col-lg-5">
									<div class="card shadow mb-4" style="height: 640px;">
										<div class="card-body">

											<div class="col-sm-12">
												<div class="row">
													<span><b> AP Invoice Details</b></span>
												</div>
												<br>
												<div class="row">
													<table id="apInvoiceDetailsTable"
														class="table table-bordered table-sm table-wrapper-scroll-y my-custom-scrollbar"
														style="height: 30vh">

														<thead>
															<tr>
																<th style="width: 40%">GL Account No</th>
																<th style="width: 40%">Description</th>
																<th style="width: 20%">Amount</th>
																<th style="width: 10%"></th>
															</tr>
														</thead>
														<tbody id="apInvoiceDetailsTableBody">

														</tbody>
													</table>
												</div>
											</div>

											<div class="col-sm-12">
												<div class="row">
													<span><b> AP Invoice Tax</b></span>
												</div>
												<br>
												<div class="row">
													<table id="apInvoiceTaxTable"
														class="table table-bordered table-sm table-wrapper-scroll-y my-custom-scrollbar"
														style="height: 30vh">

														<thead>
															<tr>
																<th style="width: 40%">GL Account No</th>
																<th style="width: 40%">Description</th>
																<th style="width: 20%">Amount</th>
																<th style="width: 10%"></th>
															</tr>
														</thead>
														<tbody id="apInvoiceTaxTableBody">

														</tbody>
													</table>
												</div>
											</div>

										</div>
										<!-- End of card body -->
									</div>

								</div>

							</div>

						</form:form>

					</div>

				</div>
				l
			</div>

		</div>
		<%@include file="../WEB-INF/jsp/footer.jsp"%>
	</div>

	<%@include file="../WEB-INF/jsp/commJs.jsp"%>
	<script>
		
	</script>
</body>
</html>
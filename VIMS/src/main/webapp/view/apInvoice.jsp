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
							id="formMake" onsubmit="return validateForm()">

							<div class="row">

								<div class="col-xl-5 col-lg-5">
									<!-- Card -->

									<div class="card shadow mb-4" style="height: 80vh;">
										<div class="card-body">
											<c:if test="${success ==1}">
												<div class="alert alert-success alert-dismissible">
													<button type="button" class="close" data-dismiss="alert">&times;</button>
													<strong>Success!</strong> AP Invoice Successfully Added.
												</div>
											</c:if>
											<c:if test="${success ==0}">
												<div class="alert alert-danger alert-dismissible">
													<button type="button" class="close" data-dismiss="alert">&times;</button>
													<strong>Warning!</strong>Something went wrong ! Please try
													again!
												</div>
											</c:if>
											<div class="form-group row">
												<div class="col-sm-4">
													<label class="l-fontst">Supplier</label>
												</div>
												<div class="col-sm-6">
													<%-- <form:input class="form-control fontst" type="text"
														path="supplierId" onchange="" id="supplierId" required="true"/> --%>
													<form:select id="supplierId"
														path="supplierMaster.supplierId" onchange=""
														class="form-control" required="true">
														<option value="">--SELECT--</option>
														<c:forEach items="${supplierList}" var="sl">
															<option value="${sl.supplierId}">
																${sl.supplierName}</option>
														</c:forEach>
													</form:select>
												</div>
											</div>
											<div class="form-group row">
												<div class="col-sm-4">
													<label class="l-fontst">Reference No</label>
												</div>
												<div class="col-sm-6">
													<form:input class="form-control fontst" type="text"
														path="referenceNo" onchange="" id="referenceNo"
														required="true" />

												</div>
											</div>
											<div class="form-group row">
												<div class="col-sm-4">
													<label class="l-fontst">Invoice Date</label>
												</div>
												<div class="col-sm-6">
													<form:input class="form-control fontst" type="date"
														path="date" onchange="" id="apInvoiceDate" required="true" />
												</div>
											</div>
											<div class="form-group row"></div>
											<div class="form-group row"></div>
											<div class="form-group row"></div>
											<hr>
											<div class="form-group row">
												<div class="col-sm-4">
													<label class="l-fontst">Gross Total</label>
												</div>
												<div class="col-sm-6">
													<form:input class="form-control fontst" type="text"
														path="grossTotal" onchange="" id="grossTotal"
														readonly="true" required="true" />
												</div>
											</div>
											<div class="form-group row">
												<div class="col-sm-4">
													<label class="l-fontst">Discount</label>
												</div>
												<div class="col-sm-6">
													<form:input class="form-control fontst" type="text"
														path="discountTotal" onchange="" id="discount"
														readonly="true" required="true" />
												</div>
											</div>
											<div class="form-group row">
												<div class="col-sm-4">
													<label class="l-fontst">Taxes</label>
												</div>
												<div class="col-sm-6">
													<form:input class="form-control fontst" type="text"
														path="taxTotal" onchange="" id="taxTotal" readonly="true"
														required="true" />
												</div>
											</div>
											<div class="form-group row">
												<div class="col-sm-4">
													<label class="l-fontst">Net Total</label>
												</div>
												<div class="col-sm-6">
													<form:input class="form-control fontst" type="text"
														path="netTotal" onchange="" id="netTotal" readonly="true"
														required="true" />
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
									<div class="card shadow mb-4" style="height: 80vh;">
										<div class="card-body">

											<div class="col-sm-12">
												<div class="row">
													<div class="col-sm-4">
														<span><label class="l-fontst">Item</label></span><select
															id="inputDetailsItemCode" class="form-control"><option
																value="">--SELECT--</option>
															<c:forEach items="${itemList}" var="il">
																<option value="${il.itemCode}">${il.itemCode}-
																	${il.itemDescription}</option>
															</c:forEach></select>
													</div>
													<div class="col-sm-2">
														<span><label class="l-fontst">Unit Price</label></span><input
															id="inputDetailsUnitPrice" type="text" placeholder="0.00"
															class="form-control" />
													</div>
													<div class="col-sm-2">
														<span><label class="l-fontst">Quantity</label></span><input
															id="inputDetailsQuantity" type="number" placeholder=""
															class="form-control" />
													</div>
													<div class="col-sm-2">
														<span><label class="l-fontst">Discount</label></span><input
															id="inputDetailsDiscount" type="text" placeholder="0.00"
															class="form-control" />
													</div>
													<div class="col-sm-2">
														<br>
														<button id="btnAddDetails" type="button"
															onclick="addDetailsRow()"
															class="btn btn-primary btn-rounded tabStyle" value="">
															<i class="fa fa-plus-circle"></i>
														</button>
													</div>
												</div>
												<br>
												<div class="row">
													<table id="apInvoiceDetailsTable"
														class="table table-bordered table-sm table-wrapper-scroll-y my-custom-scrollbar"
														style="height: 25vh">

														<thead>
															<tr>
																<th style="width: 40%">Item</th>
																<th style="width: 40%">Unit Price</th>
																<th style="width: 20%">Quantity</th>
																<th style="width: 20%">Discount</th>
																<th style="width: 20%">Total</th>
																<th style="width: 10%"></th>
															</tr>
														</thead>
														<tbody id="apInvoiceDetailsTableBody">

														</tbody>
													</table>
												</div>
											</div>

											<div class="col-sm-12">
												<div class="row" id="inputTaxes">
													<div class="col-sm-4">
														<span><label class="l-fontst">Tax</label></span><select
															id="inputTaxCode" class="form-control"><option
																value="">--SELECT--</option>
															<c:forEach items="${taxList}" var="tl">
																<option value="${tl.taxCode}">${tl.taxCode}-
																	${tl.tax}</option>
															</c:forEach></select>
													</div>
													<div class="col-sm-2">
														<span><label class="l-fontst">Amount</label></span><input
															id="inputTaxAmount" type="text" placeholder="0.00"
															class="form-control" />
													</div>
													<!-- <div class="col-sm-4"><input id="inputTaxesAmount" type="text" placeholder="0.00" class="form-control" /> </div> -->
													<div class="col-sm-2">
														<br>
														<button id="btnAddTaxes" type="button"
															onclick="addTaxesRow()"
															class="btn btn-primary btn-rounded tabStyle" value="">
															<i class="fa fa-plus-circle"></i>
														</button>
													</div>
												</div>
												<br>
												<div class="row">
													<table id="apInvoiceTaxTable"
														class="table table-bordered table-sm table-wrapper-scroll-y my-custom-scrollbar"
														style="height: 25vh; width: 100%">

														<thead>
															<tr>
																<th style="width: 40%">Tax</th>
																<!-- <th style="width: 40%">Description</th> -->
																<th style="width: 20%">Amount</th>
																<th style="width: 20%"></th>
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

			</div>

		</div>
		<%@include file="../WEB-INF/jsp/footer.jsp"%>
	</div>

	<%@include file="../WEB-INF/jsp/commJs.jsp"%>
	<script src='resources/assets/js/select2/select2.min.js'
		type='text/javascript'></script>
	<script>
		$(document).ready(function() {
			// Initialize select2
			$("#supplierId").select2();
		});
		$(document).ready(function() {
			// Initialize select2
			$("#inputDetailsItemCode").select2();
		});
		$(document).ready(function() {
			// Initialize select2
			$("#inputTaxCode").select2();
		});

		var arrHead = new Array(); // array for header.
		arrHead = [ '', '', '', '' ];
		var detTableCells = document.getElementById('apInvoiceDetailsTable').rows[0].cells.length;
		var taxTableCells = document.getElementById('apInvoiceTaxTable').rows[0].cells.length;
		var grossTotal = 0;
		var discountTotal = 0;
		var taxTotal = 0;
		var netTotal = 0;
		function addDetailsRow() {
			var detailsItemCodeValue = document
					.getElementById("inputDetailsItemCode").value;
			var detailsUnitPriceValue = document
					.getElementById("inputDetailsUnitPrice").value;
			var detailsQuantityValue = document
					.getElementById("inputDetailsQuantity").value;
			var detailsDiscountValue = document
					.getElementById("inputDetailsDiscount").value;
			if (detailsItemCodeValue == '') {
				swal("Item is empty!", "", {
					icon : "error",
					buttons : {
						confirm : {
							className : 'btn btn-danger'
						}
					},
				});
				return false;
			} else if (detailsUnitPriceValue == ''
					|| isNaN(detailsUnitPriceValue)) {
				swal("Unit Price is empty or not a number!", "", {
					icon : "error",
					buttons : {
						confirm : {
							className : 'btn btn-danger'
						}
					},
				});
				return false;
			} else if (detailsQuantityValue == ''
					|| isNaN(detailsQuantityValue)) {
				swal("Quantity is empty or not a number!", "", {
					icon : "error",
					buttons : {
						confirm : {
							className : 'btn btn-danger'
						}
					},
				});
				return false;
			} else if (detailsDiscountValue !== ''
					&& isNaN(detailsDiscountValue)) {
				swal("Discount should be a number!", "", {
					icon : "error",
					buttons : {
						confirm : {
							className : 'btn btn-danger'
						}
					},
				});
				return false;
			} else {
				if (detailsDiscountValue == '') {
					detailsDiscountValue = 0;
				}
				var detailsTotalValue = (parseInt(detailsUnitPriceValue) * parseInt(detailsQuantityValue))
						- parseInt(detailsDiscountValue);
				var empTab = document.getElementById('apInvoiceDetailsTable');
				var rowCnt = empTab.rows.length; // table row count.
				var tr = empTab.insertRow(rowCnt); // the table row.
				for (var c = 0; c < detTableCells; c++) {
					var td = document.createElement('td'); // table definition.
					td = tr.insertCell(c);
					var ele;
					var button;

					if (c == 0) {
						ele = document.createElement('input');
						ele.setAttribute('type', 'text');
						ele.setAttribute('value', detailsItemCodeValue);
						ele.setAttribute('name', 'detailsItemCode');
						ele.setAttribute('readonly', true);
						td.appendChild(ele);
					} else if (c == 1) {
						ele = document.createElement('input');
						ele.setAttribute('type', 'text');
						ele.setAttribute('value',
								parseInt(detailsUnitPriceValue));
						ele.setAttribute('name', 'detailsUnitPrice');
						ele.setAttribute('readonly', true);
						td.appendChild(ele);
					} else if (c == 2) {
						ele = document.createElement('input');
						ele.setAttribute('type', 'text');
						ele.setAttribute('value',
								parseInt(detailsQuantityValue));
						ele.setAttribute('name', 'detailsQuantity');
						ele.setAttribute('readonly', true);
						td.appendChild(ele);
					} else if (c == 3) {
						ele = document.createElement('input');
						ele.setAttribute('type', 'text');
						ele.setAttribute('value',
								parseInt(detailsDiscountValue));
						ele.setAttribute('name', 'detailsDiscount');
						ele.setAttribute('readonly', true);
						td.appendChild(ele);
					} else if (c == 4) {
						ele = document.createElement('input');
						ele.setAttribute('type', 'text');
						ele.setAttribute('value', parseInt(detailsTotalValue));
						ele.setAttribute('name', 'detailsTotal');
						ele.setAttribute('readonly', true);
						td.appendChild(ele);
					} else if (c == 5) {
						button = document.createElement('input');
						button.setAttribute('type', 'button');
						button.setAttribute('value', 'Remove');
						button
								.setAttribute('onclick',
										'removeDetailsRow(this)');
						td.appendChild(button);
					}
				}
				document.getElementById("inputDetailsItemCode").value = '';
				document.getElementById("inputDetailsUnitPrice").value = '';
				document.getElementById("inputDetailsQuantity").value = '';
				document.getElementById("inputDetailsDiscount").value = '';

				grossTotal = grossTotal
						+ (parseInt(detailsUnitPriceValue) * parseInt(detailsQuantityValue));
				discountTotal = discountTotal + parseInt(detailsDiscountValue);
				netTotal = netTotal + parseInt(detailsTotalValue);
				document.getElementById("grossTotal").value = grossTotal;
				document.getElementById("discount").value = discountTotal;
				document.getElementById("netTotal").value = netTotal;
			}
		}

		function removeDetailsRow(oButton) {
			var empTab = document.getElementById('apInvoiceDetailsTable');
			var row = oButton.parentNode.parentNode;
			empTab.deleteRow(row.rowIndex); // button -> td -> tr.
			var unitPrice = row.cells[1];
			var quantity = row.cells[2];
			var discount = row.cells[3];
			var total = row.cells[4];
			grossTotal = grossTotal
					- (unitPrice.childNodes[0].value * quantity.childNodes[0].value);
			discountTotal = discountTotal - (discount.childNodes[0].value);
			netTotal = netTotal - parseInt(total.childNodes[0].value);
			document.getElementById("grossTotal").value = grossTotal;
			document.getElementById("discount").value = discountTotal;
			document.getElementById("netTotal").value = netTotal;
		}

		function addTaxesRow() {
			var taxesCodeValue = document.getElementById("inputTaxCode").value;
			var taxesAmountValue = document.getElementById("inputTaxAmount").value;
			//var taxesAmountValue = document.getElementById ("inputTaxesAmount").value;
			if (taxesCodeValue == '') {
				swal("Tax Code is empty!", "", {
					icon : "error",
					buttons : {
						confirm : {
							className : 'btn btn-danger'
						}
					},
				});
				return false;
			} else if (taxesAmountValue == '' || isNaN(taxesAmountValue)) {
				swal("Tax amount is empty or not a number!", "", {
					icon : "error",
					buttons : {
						confirm : {
							className : 'btn btn-danger'
						}
					},
				});
				return false;
			} else {
				var empTab = document.getElementById('apInvoiceTaxTable');
				var rowCnt = empTab.rows.length; // table row count.
				var tr = empTab.insertRow(rowCnt); // the table row.
				for (var c = 0; c < taxTableCells; c++) {
					var td = document.createElement('td'); // table definition.
					td = tr.insertCell(c);
					var ele;
					var button;

					if (c == 0) {
						ele = document.createElement('input');
						ele.setAttribute('type', 'text');
						ele.setAttribute('value', taxesCodeValue);
						ele.setAttribute('name', 'taxesCode');
						ele.setAttribute('readonly', true);
						td.appendChild(ele);

					} else if (c == 1) {
						ele = document.createElement('input');
						ele.setAttribute('type', 'text');
						ele.setAttribute('value', parseInt(taxesAmountValue));
						ele.setAttribute('name', 'taxesTotal');
						ele.setAttribute('readonly', true);
						td.appendChild(ele);
					}
					/*else if (c == 2) {
					    // 3rd column, will have textbox.
					    ele = document.createElement('input');
					    ele.setAttribute('type', 'text');
					    ele.setAttribute('value', taxesAmountValue);
					    ele.setAttribute('id', 'taxesAmount');
					    ele.setAttribute('name', 'taxesAmount');
					    ele.setAttribute('readonly', true);
					    td.appendChild(ele);
					}*/
					else if (c == 2) {
						button = document.createElement('input');
						button.setAttribute('type', 'button');
						button.setAttribute('value', 'Remove');
						button.setAttribute('onclick', 'removeTaxesRow(this)');
						td.appendChild(button);
					}
				}
				document.getElementById("inputTaxCode").value = '';
				document.getElementById("inputTaxAmount").value = '';
				//netTotal = netTotal + parseInt(taxesAmountValue);
				//document.getElementById("netTotal").value = netTotal;

				taxTotal = taxTotal + parseInt(taxesAmountValue);
				netTotal = netTotal + parseInt(taxesAmountValue);
				document.getElementById("taxTotal").value = taxTotal;
				document.getElementById("netTotal").value = netTotal;
			}
		}

		// delete TABLE row function.
		function removeTaxesRow(oButton) {
			var empTab = document.getElementById('apInvoiceTaxTable');
			var row = oButton.parentNode.parentNode;
			empTab.deleteRow(row.rowIndex); // button -> td -> tr.
			var tax = row.cells[1];
			taxTotal = taxTotal - parseInt(tax.childNodes[0].value);
			netTotal = netTotal - parseInt(tax.childNodes[0].value);
			document.getElementById("taxTotal").value = taxTotal;
			document.getElementById("netTotal").value = netTotal;
		}

		function validateForm() {
			var detTab = document.getElementById('apInvoiceDetailsTable');
			var detRowCnt = detTab.rows.length; // table row count.
			var taxTab = document.getElementById('apInvoiceTaxTable');
			var taxRowCnt = taxTab.rows.length; // table row count.
			if (detRowCnt == 1) {
				swal("Details are empty!", "", {
					icon : "error",
					buttons : {
						confirm : {
							className : 'btn btn-danger'
						}
					},
				});
				return false;
			} else if (taxRowCnt == 1) {
				swal("Tax Details are empty!", "", {
					icon : "error",
					buttons : {
						confirm : {
							className : 'btn btn-danger'
						}
					},
				});
				return false;
			} else {
				return true;
			}
		}
	</script>
</body>
</html>
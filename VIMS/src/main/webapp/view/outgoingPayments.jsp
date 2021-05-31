<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ page isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>



<html lang="en">
<head>
<%@include file="../WEB-INF/jsp/head.jsp"%>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

<style>
.topcorner {
	position: absolute;
	top: 0;
	right: 0;
}

.table-wrapper {
	width: 900px;
	margin: 30px auto;
	background: #fff;
	padding: 20px;
	box-shadow: 0 1px 1px rgba(0, 0, 0, .05);
}

table.table {
	table-layout: fixed;
}

table.table tr th, table.table tr td {
	border-color: #e9e9e9;
}

table.table th i {
	font-size: 13px;
	margin: 0 5px;
	cursor: pointer;
}

table.table th:last-child {
	width: 100px;
}

table.table td a {
	cursor: pointer;
	display: inline-block;
	margin: 0 5px;
	min-width: 24px;
}

table.table td a.add {
	color: #27C46B;
}

table.table td a.edit {
	color: #FFC107;
}

table.table td a.delete {
	color: #E34724;
}

table.table td i {
	font-size: 19px;
}

table.table td a.add i {
	font-size: 24px;
	margin-right: -1px;
	position: relative;
	top: 3px;
}

table.table .form-control {
	height: 32px;
	line-height: 32px;
	box-shadow: none;
	border-radius: 2px;
}

table.table .form-control.error {
	border-color: #f50000;
}

table.table td .add {
	display: none;
}
</style>
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
				<div class="panel-header bg-primary-gradient">
					<div class="page-inner py-3">
						<div
							class="d-flex align-items-left align-items-md-center flex-column flex-md-row">
							<div class="col-xl col-lg">
								<h2 class="text-white pb-2 fw-bold">Outgoing Payment</h2>
							</div>
						</div>
					</div>
				</div>
				<div class="page-inner mt--5">

					<div class="row">
						<div class="col-xl mb-4">
							<div class="card shadow mb-4 border-left-primary" id="">
								<div class="card-header">
									<ul class="nav nav-pills nav-primary" id="pills-tab"
										role="tablist">
										<li class="nav-item"><a class="nav-link active"
											id="pills-account-tab" data-toggle="pill" href="" role="tab"
											aria-controls="pills-account" aria-selected="true"
											onclick="accountTab()">Account</a></li>
										<li class="nav-item"><a class="nav-link"
											id="pills-vendor-tab" data-toggle="pill" href="" role="tab"
											aria-controls="pills-vendor" aria-selected="false"
											onclick="vendorTab();">Vendor</a></li>
									</ul>
								</div>
								<div class="card-body">
									<form:form action="saveOutgoingPayment" method="POST"
										modelAttribute="outgoingPaymentForm" id="accountForm">

										<div class="topcorner bg-success">
											<%-- <form:input type="hidden" path="paymentVoucherNo"></form:input> --%>
										</div>

										<div class="form-group row">
											<div class="col-lg">

												<fieldset>
													<legend> Payment Type </legend>
													<label> <%-- <form:radiobutton path="paymentType"
															value="Vendor" disabled="true" /> Vendor </label> --%> <label><form:radiobutton
																path="paymentType" value="Account" checked="checked" />
															Account </label>
												</fieldset>

												<div class="row">
													<div class="col-sm-3">
														<label>Payment Due Date</label>
													</div>
													<div class="col-sm-6">
														<form:input class="form-control" type="date"
															path="dueDate" onchange="" id="payDueDate"
															required="required" />
													</div>
												</div>
												<br>
												<div class="row">
													<div class="col-sm-3">
														<label>To Order of</label>
													</div>
													<div class="col-sm">
														<form:input class="form-control" path="toOrderOf"
															onchange="" id="toOrderOf" />
													</div>
												</div>
												<br>
												<div class="row">
													<div class="col-sm-3">
														<label>Pay To</label>
													</div>
													<div class="col-sm">
														<form:input class="form-control" path="payTo" onchange=""
															id="payTo" />
													</div>
												</div>
												<br>
												<div class="row">
													<div class="col-sm-3">
														<label>Ref. No</label>
													</div>
													<div class="col-sm-6">
														<form:input class="form-control" path="refNo" onchange=""
															id="refNo" />
													</div>
												</div>

											</div>
											<div class="col-lg">

												<fieldset>
													<legend> Payment Mean</legend>
													<label><form:radiobutton path="paymentMean"
															value="Cash" /> Cash</label> <label><form:radiobutton
															path="paymentMean" value="Cheque" /> Cheque</label> <label><form:radiobutton
															path="paymentMean" value="BankTransfer" disabled="true" />
														Bank Transfer</label>
												</fieldset>

											</div>
										</div>

										<hr>

										<div class="form-group row">
											<div class="col-lg-4">
												<label>GL Account</label> <select id="glAccNo"
													class="form-control" required>
													<option value="">--SELECT--</option>
													<c:forEach items="${listGLAccounts}" var="gl">
														<option value="${gl.glAccNo}">${gl.glAccNo}
															${gl.glAccountName}</option>
													</c:forEach>
												</select>

											</div>
											<div class="col-lg-3">
												<label>Amount</label> <input class="form-control"
													type="text" id="amount" />
											</div>
											<div class="col-lg">
												<button type="button" class="btn btn-info mt-4 add-new"
													onclick="addGLDetailsRow();">
													<i class="fa fa-plus"></i> Add
												</button>
											</div>
										</div>
										<div class="form-group row">
											<div class="col-lg-4">
												<label>Remarks</label>
												<textarea class="form-control" id="remarks"></textarea>
											</div>
										</div>

										<div class="table-responsive">
											<div class="table-wrapper">
												<table class="table table-bordered" id="table1">
													<thead>
														<tr>
															<th>GL Ac No</th>
															<th>GL Ac Name</th>
															<th>Remark</th>
															<th>Amount</th>
															<th></th>
														</tr>
													</thead>
													<tbody>

													</tbody>
												</table>
											</div>
										</div>

										<button type="submit" class="btn btn-success" id="btnSubmit">Process
											Payment</button>
										<button type="reset" class="btn btn-warning" id="btnClear">Clear</button>

									</form:form>

									<form id="vendorForm" action="saveAPInvoicePayment"
										method="POST" enctype="multipart/form-data"
										style="display: none;">

										<div class="row">
											<div class="col-xl-4 col-lg-5">
												<!-- Card -->

												<div class="card shadow mb-4" style="height: 640px;">

													<div class="card-body">

														<div class="form-group row">
															<div class="col-sm-12">
																<label class="l-fontst">Supplier</label> <select
																	class="custom-select custom-select-mb" id="supplierId"
																	name="supplierId" onchange="getAPInvoicesBySupplier();">
																	<option value="">--SELECT--</option>
																	<c:forEach items="${supplierList}" var="sl">
																		<option value="${sl.supplierId}">${sl.supplierName}</option>
																	</c:forEach>
																</select>
															</div>
														</div>
														<div class="form-group row">
															<div class="col-sm-6">
																<label class="l-fontst">Total Due Amount</label> <input
																	class="form-control fontst" type="text" name="totalDue"
																	onchange="" id="totalDueAmount" readonly="readonly" />
															</div>
															<div class="col-sm-6">
																<label class="l-fontst">Payment</label> <input
																	class="form-control fontst" type="number"
																	name="totalPayment"
																	onchange="getAPInvoicesBySupplier();" id="payment" />
															</div>
														</div>
														<div class="form-group row">
															<div class="col-sm-10">

																<label class="l-fontst">Payment Type</label>

																<div class="btn-group btn-group-toggle"
																	data-toggle="buttons">
																	<label class="btn btn-outline-success btn-sm">
																		<input type="radio" name="paymentType" value="Cash"
																		onclick="cashPayment();" />Cash
																	</label> <label class="btn btn-outline-primary btn-sm">
																		<input type="radio" name="paymentType"
																		value="CreditCard" onclick="cardPayment();" />Credit
																		Card
																	</label> <label class="btn btn-outline-info btn-sm"> <input
																		type="radio" name="paymentType" value="Cheque"
																		onclick="chequePayment();" /> Cheque
																	</label> <label class="btn btn-outline-warning btn-sm">
																		<input type="radio" name="paymentType"
																		value="BankTransfer" onclick="bankPayment();" />Bank
																		Transfer
																	</label>

																</div>

															</div>

														</div>

														<div class="form-group row" id="divName">
															<div class="col-sm-4">
																<label class="l-fontst" id="lname">Name</label>
															</div>
															<div class="col-sm-6">

																<select class="form-control fontst" name="name"
																	id="idname" onchange="getBankDetails()">

																	<option value="N/A">--SELECT--</option>

																	<c:forEach items="${bankNameList}" var="cus">
																		<option value="${cus.bankid}">${cus.bankName}</option>
																	</c:forEach>
																</select>

															</div>
														</div>


														<div class="form-group row" id="divNumber">
															<div class="col-sm-4">
																<label class="l-fontst" id="lnumber">Number</label>
															</div>
															<div class="col-sm-6">
																<input class="form-control fontst" type="text"
																	name="number" onchange="" id="inumber"
																	required="required" />

															</div>
														</div>


														<div class="form-group row" id="divAccount">
															<div class="col-sm-4">
																<label class="l-fontst" id="lglacc">G/L Account</label>
															</div>
															<div class="col-sm-6">
																<select class="form-control fontst" name="glAccno"
																	id="glAccno"">
																	<option value="--">--SELECT--</option>
																</select>
															</div>
														</div>
														<div class="form-group row" id="divDate">
															<div class="col-sm-4">
																<label class="l-fontst" id="lexpData">Exp.Date</label>
															</div>
															<div class="col-sm-6">
																<input class="form-control fontst" type="date"
																	name="expDate" onchange="" id="expDate"
																	required="required" />
															</div>
														</div>
														<div class="form-group row" id="divCharges">
															<div class="col-sm-4">
																<label class="l-fontst" id="lbankchg">Bank
																	Charges</label>
															</div>
															<div class="col-sm-6">
																<input class="form-control fontst" type="text"
																	name="bankCharges" onchange="" id="bankCharges"
																	required="required" />
															</div>
														</div>
														<div class="form-group row">
															<br>
															<div class="col-sm-12">
																<button type="submit"
																	class="btn  btn-block btn-danger btn-rounded tabStyle">Process
																	Payment</button>
																<!-- 											<a href="#" class="btn btn-primary" onclick="runCancelInvoice();">Invoice Cancel</a>																 -->
															</div>
														</div>
													</div>
													<!-- End of card body -->
												</div>
											</div>
											<div class="col-xl-8 col-lg-5">
												<div class="card shadow mb-4" style="height: 640px;">
													<div class="card-body">
														<div class="col-sm-12">
															<div id="paymentTable">
																<table id="tblAPInvoicePayment"
																	class="table table-bordered table-sm table-wrapper-scroll-y my-custom-scrollbar"
																	style="height: 50vh">
																	<thead>
																		<tr>
																			<th style="width: 10%">Invoice ID</th>
																			<th style="width: 20%">Reference No</th>
																			<th style="width: 10%">Date</th>
																			<th style="width: 10%">Net Total</th>
																			<th style="width: 10%">Balance</th>
																			<th style="width: 10%">Payment</th>
																			<th style="width: 10%">New Balance</th>
																			<th style="width: 10%"></th>
																		</tr>
																	</thead>
																	<tbody id="">
																	</tbody>
																</table>
															</div>
														</div>
													</div>
													<!-- End of card body -->
												</div>
											</div>
										</div>
									</form>
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
	<!-- <script>
		$(document)
				.ready(
						function() {
							$('[data-toggle="tooltip"]').tooltip();
							//var actions = $("table td:last-child").html();
							var actions = "<a class='add' title='Add' data-toggle='tooltip'><i class='material-icons'>&#xE03B;</i></a>"
									+ "<a class='edit' title='Edit' data-toggle='tooltip'><i class='material-icons'>&#xE254;</i></a>"
									+ "<a class='delete' title='Delete' data-toggle='tooltip'><i class='material-icons'>&#xE872;</i></a>";

							// Append table with add row form on add new button click
							$(".add-new")
									.click(
											function() {
												//$(this).attr("disabled", "disabled");
												var index = $(
														"table tbody tr:last-child")
														.index();

												var glAccNo = $("#glAccNo")
														.val();
												var amount = $("#amount").val();
												var remarks = $("#remarks")
														.val();

												var row = '<tr>'
														+ '<td><input type="text" class="form-control" name="glAccNo" value="'+glAccNo+'"></td>'
														+ '<td><input type="text" class="form-control" name="glAccName" value="'+glAccNo+'"></td>'
														+ '<td><input type="text" class="form-control" name="remarks" value="'+remarks+'"></td>'
														+ '<td><input type="text" class="form-control" name="amount" value="'+amount+'"></td>'
														+ '<td>' + actions
														+ '</td>' + '</tr>';
												$("table tbody").append(row);
												//caltotalAmount();
												$("table tbody tr").eq(
														index + 1).find(
														".add, .edit").toggle();
												$('[data-toggle="tooltip"]')
														.tooltip();
											});
							// Add row on add button click
							$(document).on(
									"click",
									".add",
									function() {
										var empty = false;
										var input = $(this).parents("tr").find(
												'input[type="text"]');
										/*         input.each(function(){
										 if(!$(this).val()){
										 $(this).addClass("error");
										 empty = true;
										 } else{
										 $(this).removeClass("error");
										 }
										 }); */
										//$(this).parents("tr").find(".error").first().focus();
										if (!empty) {
											input.each(function() {
												$(this).parent("td").html(
														$(this).val());
											});
											$(this).parents("tr").find(
													".add, .edit").toggle();
											$(".add-new")
													.removeAttr("disabled");
										}
									});
							// Edit row on edit button click
							$(document)
									.on(
											"click",
											".edit",
											function() {
												$(this)
														.parents("tr")
														.find(
																"td:not(:last-child)")
														.each(
																function() {
																	$(this)
																			.html(
																					'<input type="text" class="form-control" value="'
																							+ $(
																									this)
																									.text()
																							+ '">');
																});
												$(this).parents("tr").find(
														".add, .edit").toggle();
												$(".add-new").attr("disabled",
														"disabled");
											});
							// Delete row on delete button click
							$(document).on("click", ".delete", function() {
								$(this).parents("tr").remove();
								$(".add-new").removeAttr("disabled");
							});
						});
	</script> -->
	<script>
		function caltotalAmount() {
			var table = document.getElementById("table1"), sumVal = 0;
			for (var i = 1; i < table.rows.length; i++) {
				sumVal = sumVal + parseInt(table.rows[i].cells[3].innerHTML);
			}
			document.getElementById("sumval").innerHTML = "Sum Value = "
					+ sumVal;
			console.log(sumVal)
		}
		function vendorTab() {
			document.getElementById("accountForm").style.display = 'none';
			document.getElementById("vendorForm").style.display = 'block';
		}
		function accountTab() {
			document.getElementById("vendorForm").style.display = 'none';
			document.getElementById("accountForm").style.display = 'block'
		}
	</script>
	<script type="text/javascript">
		var bankCharges = document.getElementById("bankCharges");
		var expDate = document.getElementById("expDate");
		var glAccno = document.getElementById("glAccno");
		var number = document.getElementById("inumber");
		var idname = document.getElementById("idname");
		var nameDiv = document.getElementById("divName");
		var numberDiv = document.getElementById("divNumber");
		var accountDiv = document.getElementById("divAccount");
		var dateDiv = document.getElementById("divDate");
		var chargesDiv = document.getElementById("divCharges");
		$('#lname').text("");
		$('#lexpData').text("");
		$('#lglacc').text("");
		$('#lbankchg').text("");
		$('#lnumber').text("");
		bankCharges.style.display = "none";
		expDate.style.display = "none";
		glAccno.style.display = "none";
		number.style.display = "none";
		idname.style.display = "none";
		nameDiv.style.display = "none";
		numberDiv.style.display = "none";
		dateDiv.style.display = "none";
		accountDiv.style.display = "none";
		chargesDiv.style.display = "none";
		//	  bankName.style.display = "none";
		jQuery(document).ready(function() {
			$('input:radio[name="paymentType"]').change(function() {
				//Cash 	Credit Card	  Cheque  Bank Transfer
				//lbankchg expData lglacc lnumber lname  glAccno lexpData bankCharges
				if ($(this).val() == 'Cash') {
					$('#lname').text("");
					$('#lexpData').text("");
					$('#lglacc').text("");
					$('#lbankchg').text("");
					$('#lnumber').text("");
					bankCharges.value = "0";
					expDate.value = "1990-01-01";
					glAccno.value = "--";
					number.value = "--";
					idname.value = "N/A"
					bankCharges.style.display = "none";
					expDate.style.display = "none";
					glAccno.style.display = "none";
					number.style.display = "none";
					idname.style.display = "none";
					nameDiv.style.display = "none";
					numberDiv.style.display = "none";
					dateDiv.style.display = "none";
					accountDiv.style.display = "none";
					chargesDiv.style.display = "none";
					//  bankName.style.display = "none";
				} else if ($(this).val() == 'CreditCard') {
					$('#lname').text("");
					$('#lexpData').text("Exp.Date");
					$('#lglacc').text("");
					$('#lbankchg').text("");
					$('#lnumber').text("Credit Card Number");
					bankCharges.value = "0";
					expDate.value = "";
					glAccno.value = "--";
					number.value = "";
					idname.value = "N/A";
					bankCharges.style.display = "none";
					expDate.style.display = "block";
					glAccno.style.display = "none";
					number.style.display = "block";
					idname.style.display = "none";
					nameDiv.style.display = "none";
					numberDiv.style.display = "block";
					dateDiv.style.display = "block";
					accountDiv.style.display = "none";
					chargesDiv.style.display = "none";
					//  bankName.style.display = "none";
				} else if ($(this).val() == 'Cheque') {
					$('#lname').text("Name");
					$('#lexpData').text("Due Date");
					$('#lglacc').text("");
					$('#lbankchg').text("");
					$('#lnumber').text("Cheque Number");
					bankCharges.value = "0";
					expDate.value = "";
					glAccno.value = "--";
					number.value = "";
					idname.value = "N/A"
					bankCharges.style.display = "none";
					expDate.style.display = "block";
					glAccno.style.display = "none";
					number.style.display = "block";
					idname.style.display = "block";
					nameDiv.style.display = "block";
					numberDiv.style.display = "block";
					dateDiv.style.display = "block";
					accountDiv.style.display = "none";
					chargesDiv.style.display = "none";
					// bankName.style.display = "none";
				} else if ($(this).val() == 'BankTransfer') {
					$('#lname').text("Bank Name");
					$('#lexpData').text("");
					$('#lglacc').text("Bank Account");
					$('#lbankchg').text("Bank Charges");
					$('#lnumber').text("");
					bankCharges.value = "";
					expDate.value = "1990-01-01";
					glAccno.value = "";
					number.value = "--";
					idname.value = "N/A"
					bankCharges.style.display = "block";
					expDate.style.display = "none";
					glAccno.style.display = "block";
					number.style.display = "none";
					idname.style.display = "block";
					nameDiv.style.display = "block";
					numberDiv.style.display = "none";
					dateDiv.style.display = "none";
					accountDiv.style.display = "block";
					chargesDiv.style.display = "block";
					//  bankName.style.display = "block";
				}
			});
		});
		function getBankDetails() {
			var bankid = document.getElementById("idname").value;
			var slctSubcat = $('#glAccno'), option = "";
			slctSubcat.empty();
			option = "<option value='--'>--SELECT--</option>"
			$
					.ajax({
						type : 'GET',
						url : "getBankAccountByBank",
						data : {
							"bankid" : bankid
						},
						success : function(data) {
							;
							for (var i = 0; i < data.length; i++) {
								option = option
										+ "<option value='"+data[i].glAccNo.glAccNo + "'>"
										+ data[i].bankAccountNo + "</option>";
							}
							slctSubcat.append(option);
						},
						error : function() {
							alert("No return vMake data");
						}
					});
		}
	</script>
	<script>
		function addGLDetailsRow() {
			var glCodeValue = document.getElementById("glAccNo").value;
			var glAmountValue = document.getElementById("amount").value;
			var glRemarksValue = document.getElementById("remarks").value;
			//var glAmountValue = document.getElementById ("inputTaxesAmount").value;
			if (glCodeValue == '') {
				swal("GL Code is empty!", "", {
					icon : "error",
					buttons : {
						confirm : {
							className : 'btn btn-danger'
						}
					},
				});
				return false;
			} else if (glAmountValue == '' || isNaN(glAmountValue)) {
				swal("GL amount is empty or not a number!", "", {
					icon : "error",
					buttons : {
						confirm : {
							className : 'btn btn-danger'
						}
					},
				});
				return false;
			} else if (glRemarksValue == '') {
				swal("GL Remarks empty!", "", {
					icon : "error",
					buttons : {
						confirm : {
							className : 'btn btn-danger'
						}
					},
				});
				return false;
			} else {
				var empTab = document.getElementById('table1');
				var rowCnt = empTab.rows.length; // table row count.
				var tr = empTab.insertRow(rowCnt); // the table row.
				//tr = empTab.insertRow(rowCnt);
				for (var c = 0; c < 5; c++) {
					var td = document.createElement('td'); // table definition.
					td = tr.insertCell(c);
					var ele;
					var button;
					if (c == 0) {
						ele = document.createElement('input');
						ele.setAttribute('type', 'text');
						ele.setAttribute('value', glCodeValue);
						ele.setAttribute('name', 'glAccNo');
						ele.setAttribute('readonly', true);
						td.appendChild(ele);
					} else if (c == 1) {
						ele = document.createElement('input');
						ele.setAttribute('type', 'text');
						ele.setAttribute('value', glCodeValue);
						ele.setAttribute('name', 'glAccName');
						ele.setAttribute('readonly', true);
						td.appendChild(ele);
					} else if (c == 2) {
						// 3rd column, will have textbox.
						ele = document.createElement('input');
						ele.setAttribute('type', 'text');
						ele.setAttribute('value', glRemarksValue);
						ele.setAttribute('name', 'remarks');
						ele.setAttribute('readonly', true);
						td.appendChild(ele);
					} else if (c == 3) {
						// 3rd column, will have textbox.
						ele = document.createElement('input');
						ele.setAttribute('type', 'text');
						ele.setAttribute('value', glAmountValue);
						ele.setAttribute('name', 'amount');
						ele.setAttribute('readonly', true);
						td.appendChild(ele);
					} else if (c == 4) {
						button = document.createElement('input');
						button.setAttribute('type', 'button');
						button.setAttribute('value', 'Remove');
						button.setAttribute('onclick',
								'removeGLDetailsRow(this)');
						td.appendChild(button);
					}
				}
				$('#glAccNo').get(0).selectedIndex = 0;
				document.getElementById("amount").value = '';
				document.getElementById("remarks").value = '';
			}
		}
		// delete TABLE row function.
		function removeGLDetailsRow(oButton) {
			var empTab = document.getElementById('table1');
			var row = oButton.parentNode.parentNode;
			empTab.deleteRow(row.rowIndex); // button -> td -> tr.
		}
		function getAPInvoicesBySupplier() {
			var supplierId = document.getElementById("supplierId").value;
			var payment = document.getElementById("payment").value;
			var paidAmount = 0;
			if (payment != "") {
				paidAmount = payment;
			}
			$("#tblAPInvoicePayment tbody").empty();
			$
					.ajax({
						type : 'GET',
						url : "getAPInvoicesBySupplier",
						data : {
							"supplierId" : supplierId
						},
						success : function(data) {
							var totalBalance = 0;
							$("#tblAPInvoicePayment tbody").empty();
							for (var i = 0; i < data.length; i++) {
								var payamount = 0;
								var newBalance = 0;
								if (paidAmount <= 0) {
									payamount = 0;
									newBalance = data[i].balance/100;
								} else {
									paidAmount = paidAmount - data[i].balance
											/ 100;
									if (paidAmount > 0) {
										payamount = data[i].balance / 100;
									} else {
										payamount = paidAmount + data[i].balance
												/ 100;
										newBalance = data[i].balance / 100
												- payamount;
									}
								}
								
								var result = '<tr>'
									+ '<td><input readonly type="text" name="apInvoiceHeadId" value="'+data[i].apInvoiceHeadId +'"></td>'
									+ '<td><input readonly type="text" name="referenceNo" value="'+ data[i].referenceNo +'"></td>'
									+ '<td><input readonly type="text" name="date" value="'+ data[i].date +'"></td>'
									+ '<td><input readonly type="text" name="netTotal" value="'+ parseInt(data[i].netTotal) / 100 +'"></td>'
									+ '<td><input readonly type="text" name="balance" value="'+ parseInt(data[i].balance) / 100 +'"></td>'
									+ '<td><input readonly type="text" name="payamount" value="'+ parseInt(payamount) +'"></td>'
									+ '<td><input readonly type="text" name="newBalance" value="'+ parseInt(newBalance) +'"></td>'
									+ '<td>' 
									+ '</tr>';
									
								$("#tblAPInvoicePayment tbody").append(result);
								totalBalance = totalBalance + data[i].balance;
							}
							document.getElementById("totalDueAmount").value = (parseInt(totalBalance) / 100);
						},
						error : function() {
							swal(
									"No payable invoices for the selected supplier",
									"", {
										icon : "info",
										buttons : {
											confirm : {
												className : 'btn btn-danger'
											}
										},
									});
						}
					});
		}
	</script>

</body>
</html>
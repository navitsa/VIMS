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
							<div class="col-xl-4 col-lg-4">
								<h2 class="text-white pb-2 fw-bold">Journal Voucher</h2>
							</div>
							<div class="col-xl-2 col-lg-2"></div>
							<div class="ml-md-auto py-2 py-md-4"></div>

							<div class="ml-md-auto py-2 py-md-4"></div>
						</div>
					</div>
				</div>

				<div class="page-inner mt--5">
					<div class="container-fluid">
						<form:form action="saveJournalVoucher" method="POST"
							id="journalVoucher">
							<div class="row">
								<div class="col-xl-3 col-lg-5">
									<!-- Card -->

									<div class="card shadow mb-4" style="height: 600px;">
										<div class="card border-left-primary shadow h-100 py-2">

											<div class="card-body">

												<div class="form-group row">
													<div class="col-sm-12">
														<label class="l-fontst">GL Account</label> <select
															class="custom-select custom-select-mb" id="glaccount"
															name="glaccount">
															<option value="">--SELECT--</option>
															<c:forEach items="${glaccountList}" var="t">
																<option value="${t.glAccNo}">${t.glAccountName}</option>
															</c:forEach>
														</select>

													</div>


												</div>
												<div class="form-group row">
													<div class="col-sm-10">

														<div class="col-sm-2"></div>

														<div class="btn-group btn-group-toggle"
															data-toggle="buttons">
															<label class="btn btn-outline-success btn-sm"> <input
																type="radio" name="crdr" value="Credit" />Credit
															</label> <label class="btn btn-outline-primary btn-sm"> <input
																type="radio" name="crdr" value="Debit" />Debit
															</label>

														</div>

													</div>
													<div class="col-sm-2"></div>
													<div class="col-sm-3"></div>

												</div>




												<div class="form-group row">
													<div class="col-sm-12">
														<label class="l-fontst">Amount</label> <input
															class="form-control fontst" type="number" name="amount"
															onchange="" id="amount" />
													</div>


												</div>

												<!-- 							<div class="form-group row"> -->
												<!-- 										<div class="col-sm-12"> -->
												<!-- 													<input type="checkbox" class="form-control custom-control-input fontst fontstc" id="withCheck" name="repStatu" value="INACTIVE" onclick="customerCredit()"> -->
												<!-- 								    				<label class="custom-control-label l-fontst fontstc" for="withCheck">With Cancel</label> -->
												<!-- 										</div> -->


												<!-- 							</div> -->

												<br>
												<hr>
												<div class="form-group row">

													<div class="col-sm-12">
														<input type="button" class="add-row btn btn-info"
															value="Add Entery >>" onclick="addEqumentToTable();">
														<!-- 											<a href="#" class="btn btn-primary" onclick="runCancelInvoice();">Invoice Cancel</a>																 -->
													</div>

												</div>


											</div>
											<!-- End of card body -->
										</div>
									</div>

								</div>

								<div class="col-xl-9 col-lg-5">
									<div class="card shadow mb-4" style="height: 600px;">
										<div class="card border-left-primary shadow h-100 py-2">
											<div class="card-body">

												<div class="col-sm-12">
													<div id="paymentTable">
														<table id="tblIncomingPayment"
															class="table table-bordered table-sm table-wrapper-scroll-y my-custom-scrollbar"
															cellspacing="0" style="height: 50vh">

															<thead>
																<tr>
																	<th style="width: 10%">GL Account No</th>
																	<th style="width: 40%">Account</th>
																	<th style="width: 10%">Debit</th>
																	<th style="width: 10%">Credit</th>
																	<th style="width: 10%"></th>
																</tr>
															</thead>
															<tbody id="myTable">

															</tbody>
														</table>
													</div>
												</div>
												<div class="form-group row">
													<div class="col-sm-3">
														<label class="l-fontst">Debit Total</label>
													</div>
													<div class="col-sm-8">
														<p class="l-fontst" id="drTot"></p>
													</div>
												</div>
												<div class="form-group row">
													<div class="col-sm-3">
														<label class="l-fontst">Credit Total</label>
													</div>
													<div class="col-sm-8">
														<p class="l-fontst" id="crTot"></p>
													</div>
												</div>
												<div class="row">
													<div class="col-sm-4 mb-4 mb-sm-4"></div>
													<div class="col-sm-6 mb-6 mb-sm-6">
														<input id="createVoucher" type="button"
															class="btn btn-success" value="Create Voucher">
													</div>
												</div>

											</div>

										</div>
										<!-- End of card body -->
									</div>
								</div>


							</div>

							<!-- <div class="col-xl-9 col-lg-5">
									<div class="col-sm-12">
										<div class="col-md-12 col-lg-12">

											<table id="tblIncomingPayment"
												class="table table-striped table-bordered table-sm table-wrapper-scroll-y my-custom-scrollbar"
												style="height: 450px" required>

												<thead>
													<tr>
														<th>GL Account No</th>
														<th>Account</th>
														<th>Debit</th>
														<th>Credit</th>


													</tr>
												</thead>
												<tbody id="myTable">

												</tbody>
											</table>



										</div>

										<div class="form-group row">
											<div class="col-sm-3">
												<label class="l-fontst">Debit Total</label>
											</div>
											<div class="col-sm-8">
												<p class="l-fontst" id="drTot"></p>
											</div>
										</div>
										<div class="form-group row">
											<div class="col-sm-3">
												<label class="l-fontst">Credit Total</label>
											</div>
											<div class="col-sm-8">
												<p class="l-fontst" id="crTot"></p>
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-sm-4 mb-4 mb-sm-4"></div>
										<div class="col-sm-6 mb-6 mb-sm-6">
											<input type="submit" class="btn btn-success"
												value="Create Voucher">
										</div>
									</div>
									
									
									
									
								</div> -->
					</div>
					</form:form>


				</div>
			</div>

		</div>
		<%@include file="../WEB-INF/jsp/footer.jsp"%>
	</div>
	</div>
	<%@include file="../WEB-INF/jsp/commJs.jsp"%>

	<script type="text/javascript">
		var crtot = 0;
		var drtot = 0;
		function addEqumentToTable() {

			var crdr = $("input[type='radio'][name='crdr']:checked").val();
			// alert(crdr);
			if (crdr == "Debit") {
				var dramt = parseFloat($("#amount").val());
				var cramt = parseFloat("0")
				drtot = drtot + dramt;
				//drtot = drtot.toFixed(2);
			} else {
				var dramt = parseFloat("0")
				var cramt = parseFloat($("#amount").val());
				crtot = crtot + cramt;
				//crtot = crtot.toFixed(2);
			}
			var glaccount = $("#glaccount").val();

			var select = document.getElementById("glaccount");
			var option = select.options[select.selectedIndex];

			//     if(equmentTable!=""& epriceTable!=""){

			// 	$.ajax({
			// 	       type: 'GET',
			// 	       url: "rentEquipmentMaster",
			// 	       data: {"eqId" : equmentTable},
			// 	       success: function(data){
			var contact = "<tr><td>"
					+ "<input name='glaccno' readonly value='"+glaccount+"'/>" +

					"</td><td>" + option.text + "</td><td>"
					+ "<input name='dramt' readonly value='"+dramt+"'/>"
					+ "</td><td>"
					+ "<input name='cramt' readonly value='"+cramt+"'/>"
					+ "</td><td>" +
					// <i class="fas fa-trash"></i> "<button type='button' onclick='productDelete(this);' class='btn'>Remove</button>"+
					"<button type='button' onclick='deleteRow(this)' class='btn'>Remove</button>"
					+ "</td></tr>";

			$("table tbody").append(contact);
			//  getEqument(); 
			//   document.getElementById("crTot").value=crtot;
			//	  document.getElementById("drTot").value=drtot;

			document.getElementById('crTot').innerHTML = crtot;
			document.getElementById('drTot').innerHTML = drtot;

			// 	       },
			// 	       error:function(){
			// 	           alert("error");

			// 	       }

			// 	   });   

			//     }

		}

		function deleteRow(btn) {
			var row = btn.parentNode.parentNode;
			var debit = row.cells[2].children[0].value;
			var credit = row.cells[3].children[0].value;
			var debitTotal = document.getElementById("drTot").innerHTML;
			var creditTotal = document.getElementById("crTot").innerHTML;
			if (credit == 0) {
				debitTotal = parseFloat(debitTotal);
				var debitBalance = debitTotal - debit;
				document.getElementById('drTot').innerHTML = debitBalance;
			} else if (debit == 0) {
				creditTotal = parseFloat(creditTotal);
				var creditBalance = creditTotal - credit;
				document.getElementById('crTot').innerHTML = creditBalance;
			}
			row.parentNode.removeChild(row);
		}

		document.getElementById("createVoucher").addEventListener("click",
				saveJournalVoucher);

		function saveJournalVoucher() {

			var debitTotal = document.getElementById("drTot").innerHTML;
			var creditTotal = document.getElementById("crTot").innerHTML;
			debitTotal = parseInt(debitTotal);
			creditTotal = parseInt(creditTotal);

			if (!(creditTotal == debitTotal)) {

				swal("Credit & Debit Values must be equal!", {
					icon : "error",
					buttons : {
						confirm : {
							className : 'btn btn-danger'
						}
					},
				});
				return;
			} else {

				var request_method = $("#journalVoucher").attr("method"); //get form GET/POST method

				// Get form
				var form = $('#journalVoucher')[0];

				// Create an FormData object
				var data = new FormData(form);

				//alert("Error "+form_data);
				$
						.ajax({

							url : "saveJournalVoucher",
							type : request_method,
							enctype : 'multipart/form-data',
							data : data,
							processData : false,
							contentType : false,
							cache : false,

							success : function(data) {

								if (data == "1") {
									swal(
											"Good job!",
											"You clicked the button!",
											{
												icon : "success",
												buttons : {
													confirm : {
														className : 'btn btn-success'
													}
												},
											});
									window.location.href = "redirect:/journalVoucher.do";
								} else {
									swal(
											"Good job!",
											"You clicked the button!",
											{
												icon : "error",
												buttons : {
													confirm : {
														className : 'btn btn-danger'
													}
												},
											});
								}

							},
							error : function(e) {
								swal(
										"Good job!",
										"You clicked the button! err",
										{
											icon : "error",
											buttons : {
												confirm : {
													className : 'btn btn-danger'
												}
											},
										});
							}
						});

			}
		}
	</script>

</body>
</html>
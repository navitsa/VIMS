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
													<form:input class="form-control fontst" type="text"
														path="supplierId" onchange="" id="supplierId" required="true"/>
												</div>
											</div>
											<div class="form-group row">
												<div class="col-sm-4">
													<label class="l-fontst">Supplier GL Account No</label>
												</div>
												<div class="col-sm-6">
													<form:input class="form-control fontst" type="text"
														path="supplierGlCode" onchange="" id="supplierGlCode" required="true"/>

												</div>
											</div>
											<div class="form-group row">
												<div class="col-sm-4">
													<label class="l-fontst">Date</label>
												</div>
												<div class="col-sm-6">
													<form:input class="form-control fontst" type="date" path="date"
														onchange="" id="apInvoiceDate" required="true"/>
												</div>
											</div>
											<hr>
											<div class="form-group row">
												<div class="col-sm-4">
													<label class="l-fontst">Net Total</label>
												</div>
												<div class="col-sm-6">
													<form:input class="form-control fontst" type="text"
														path="netTotal" onchange="" id="netTotal" readonly="true" required="true"/>
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
													<div class="col-sm-12"><span><b>Details</b></span></div>
												</div>
												<br>
												<div class="row">
													<div class="col-sm-3"><select id="inputDetailsGLAccount" class="form-control"><option value="">--SELECT--</option>
													<c:forEach items="${listGLAccounts}" var="gl">
														<option value="${gl.glAccNo}">${gl.glAccNo}
															${gl.glAccountName}</option>
													</c:forEach></select></div>
													<div class="col-sm-5"><input id="inputDetailsDescription" type="text" placeholder="Description" class="form-control" /></div>
													<div class="col-sm-2"><input id="inputDetailsAmount" type="text" placeholder="0.00" class="form-control" /></div>
													<div class="col-sm-2" style="display: flex; justify-content: flex-end"><input id="btnAddDetails" type="button" onclick="addDetailsRow()" class="btn btn-primary btn-rounded tabStyle" value="Add"/></div>
												</div>
												<br>
												<div class="row">
													<table id="apInvoiceDetailsTable"
														class="table table-bordered table-sm table-wrapper-scroll-y my-custom-scrollbar"
														style="height: 24vh">

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
													<div class="col-sm-12"><span><b>Taxes</b></span></div>
												</div>
												<br>
												<div class="row" id="inputTaxes">
													<div class="col-sm-3"><select id="inputTaxesGLAccount" class="form-control"><option value="">--SELECT--</option>
													<c:forEach items="${listGLAccounts}" var="gl">
														<option value="${gl.glAccNo}">${gl.glAccNo}
															${gl.glAccountName}</option>
													</c:forEach></select></div>
													<div class="col-sm-5"><input id="inputTaxesDescription" type="text" placeholder="Description" class="form-control" /></div>
													<div class="col-sm-2"><input id="inputTaxesAmount" type="text" placeholder="0.00" class="form-control" /></div>
													<div class="col-sm-2" style="display: flex; justify-content: flex-end"><input id="btnAddTaxes" type="button" onclick="addTaxesRow()" class="btn btn-primary btn-rounded tabStyle" value="Add"/></div>
												</div>
												<br>
												<div class="row">
													<table id="apInvoiceTaxTable"
														class="table table-bordered table-sm table-wrapper-scroll-y my-custom-scrollbar"
														style="height: 24vh">

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
	var arrHead = new Array();	// array for header.
    arrHead = ['', '', '', ''];
	var netTotal = 0;
	function addDetailsRow() {
		var detailsGlAccountValue = document.getElementById ("inputDetailsGLAccount").value;
        var detailsDescriptionValue = document.getElementById ("inputDetailsDescription").value;
        var detailsAmountValue = document.getElementById ("inputDetailsAmount").value;
        if (detailsGlAccountValue == ''){
        	swal(
					"Details Gl Account  is empty!",
					"",
					{
						icon : "error",
						buttons : {
							confirm : {
								className : 'btn btn-danger'
							}
						},
					});
        	return false;
        } else if (detailsDescriptionValue == '') {
        	swal(
					"Details description  is empty!",
					"",
					{
						icon : "error",
						buttons : {
							confirm : {
								className : 'btn btn-danger'
							}
						},
					});
        	return false;
        } else if (detailsAmountValue == '' || isNaN(detailsAmountValue)) {
        	swal(
					"Details amount is empty or not a number!",
					"",
					{
						icon : "error",
						buttons : {
							confirm : {
								className : 'btn btn-danger'
							}
						},
					});
        	return false;
        } else {
        var empTab = document.getElementById('apInvoiceDetailsTable');
        var rowCnt = empTab.rows.length;   // table row count.
        var tr = empTab.insertRow(rowCnt); // the table row.
        //tr = empTab.insertRow(rowCnt);
        for (var c = 0; c < arrHead.length; c++) {
            var td = document.createElement('td'); // table definition.
            td = tr.insertCell(c);
            var ele;
            var button;
           
            if (c == 0) {      
            	// 1st column, will have select.
                ele = document.createElement('input');
                ele.setAttribute('type', 'text');
                ele.setAttribute('value', detailsGlAccountValue);
                ele.setAttribute('id', 'detailsGlAccount');
                ele.setAttribute('name', 'detailsGlAccount');
                ele.setAttribute('readonly', true);
                td.appendChild(ele);
            }
            else if (c == 1) {
                // 2nd, 3rd and 4th column, will have textbox.
                ele = document.createElement('input');
                ele.setAttribute('type', 'text');
                ele.setAttribute('value', detailsDescriptionValue);
                ele.setAttribute('id', 'detailsDescription');
                ele.setAttribute('name', 'detailsDescription');
                ele.setAttribute('readonly', true);
                td.appendChild(ele);
            }
            else if (c == 2) {
                // 2nd, 3rd and 4th column, will have textbox.
                ele = document.createElement('input');
                ele.setAttribute('type', 'text');
                ele.setAttribute('value', detailsAmountValue);
                ele.setAttribute('id', 'detailsAmount');
                ele.setAttribute('name', 'detailsAmount');
                ele.setAttribute('readonly', true);
                td.appendChild(ele);
            }
            else if (c == 3) { // the last column.
                // add a button in every new row in the last column.
                button = document.createElement('input');
                // set input attributes.
                button.setAttribute('type', 'button');
                button.setAttribute('value', 'Remove');
                // add button's 'onclick' event.
                button.setAttribute('onclick', 'removeDetailsRow(this)');
                td.appendChild(button);
            }
        }
        netTotal = netTotal + parseInt(detailsAmountValue);
        document.getElementById("netTotal").value = netTotal;
	} 
    }
	
    // delete TABLE row function.
    function removeDetailsRow(oButton) {
        var empTab = document.getElementById('apInvoiceDetailsTable');
        var row = oButton.parentNode.parentNode;
        empTab.deleteRow(row.rowIndex); // button -> td -> tr.
        var element = row.cells[2];
        netTotal = netTotal - parseInt(element.childNodes[0].value);
        document.getElementById("netTotal").value = netTotal;
    }
    
    function addTaxesRow() {
    	var taxesGlAccountValue = document.getElementById ("inputTaxesGLAccount").value;
        var taxesDescriptionValue = document.getElementById ("inputTaxesDescription").value;
        var taxesAmountValue = document.getElementById ("inputTaxesAmount").value;
        if (taxesGlAccountValue == ''){
        	swal(
					"Tax Gl Account  is empty!",
					"",
					{
						icon : "error",
						buttons : {
							confirm : {
								className : 'btn btn-danger'
							}
						},
					});
        	return false;
        } else if (taxesDescriptionValue == '') {
        	swal(
					"Tax description  is empty!",
					"",
					{
						icon : "error",
						buttons : {
							confirm : {
								className : 'btn btn-danger'
							}
						},
					});
        	return false;
        } else if (taxesAmountValue == '' || isNaN(taxesAmountValue)) {
        	swal(
					"Tax amount is empty or not a number!",
					"",
					{
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
        var rowCnt = empTab.rows.length;   // table row count.
        var tr = empTab.insertRow(rowCnt); // the table row.
        //tr = empTab.insertRow(rowCnt);
        for (var c = 0; c < arrHead.length; c++) {
            var td = document.createElement('td'); // table definition.
            td = tr.insertCell(c);
            var ele;
            var button; 
            
            if (c == 0) {      
            	// 1st column, will have text.
                ele = document.createElement('input');
                ele.setAttribute('type', 'text');
                ele.setAttribute('value', taxesGlAccountValue);
                ele.setAttribute('id', 'taxesGlAccount');
                ele.setAttribute('name', 'taxesGlAccount');
                ele.setAttribute('readonly', true);
                td.appendChild(ele);
                
            }
            else if (c == 1) {
                // 2nd will have textbox.
                ele = document.createElement('input');
                ele.setAttribute('type', 'text');
                ele.setAttribute('value', taxesDescriptionValue);
                ele.setAttribute('id', 'taxesDescription');
                ele.setAttribute('name', 'taxesDescription');
                ele.setAttribute('readonly', true);
                td.appendChild(ele);
            }
            else if (c == 2) {
                // 3rd column, will have textbox.
                ele = document.createElement('input');
                ele.setAttribute('type', 'text');
                ele.setAttribute('value', taxesAmountValue);
                ele.setAttribute('id', 'taxesAmount');
                ele.setAttribute('name', 'taxesAmount');
                ele.setAttribute('readonly', true);
                td.appendChild(ele);
            }
            else if (c == 3) { // the last column.
                // add a button in every new row in the last column.
                button = document.createElement('input');
                // set input attributes.
                button.setAttribute('type', 'button');
                button.setAttribute('value', 'Remove');
                // add button's 'onclick' event.
                button.setAttribute('onclick', 'removeTaxesRow(this)');
                td.appendChild(button);
            }
        }
        netTotal = netTotal + parseInt(taxesAmountValue);
        document.getElementById("netTotal").value = netTotal;
    } 
    }
    
    // delete TABLE row function.
    function removeTaxesRow(oButton) {
        var empTab = document.getElementById('apInvoiceTaxTable');
        var row = oButton.parentNode.parentNode;
        empTab.deleteRow(row.rowIndex); // button -> td -> tr.
        var element = row.cells[2];
        netTotal = netTotal - parseInt(element.childNodes[0].value);
        document.getElementById("netTotal").value = netTotal;
    }
    
	function validateForm() {
		var detTab = document.getElementById('apInvoiceDetailsTable');
        var detRowCnt = detTab.rows.length;   // table row count.
		var taxTab = document.getElementById('apInvoiceTaxTable');
		var taxRowCnt = taxTab.rows.length;   // table row count.
		if (detRowCnt == 1) {
			swal(
					"Details are empty!",
					"",
					{
						icon : "error",
						buttons : {
							confirm : {
								className : 'btn btn-danger'
							}
						},
					});
        	return false;
		} else if (taxRowCnt == 1) {
			swal(
					"Tax Details are empty!",
					"",
					{
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
<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ page isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>



<html lang="en">
<head>
	<%@include file="../WEB-INF/jsp/head.jsp"%>
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	
<style>

.topcorner{
  position:absolute;
  top:0;
  right:0;
 }
.table-wrapper {
    width: 900px;
    margin: 30px auto;
    background: #fff;
    padding: 20px;	
    box-shadow: 0 1px 1px rgba(0,0,0,.05);
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
			              <div class="card shadow mb-4 border-left-primary">
			                <div class="card-body">
									<form:form action="saveOutgoingPayment" method="POST"
										modelAttribute="outgoingPaymentForm" id="form1">

										<div class="topcorner bg-success">
											<%-- <form:input type="hidden" path="paymentVoucherNo"></form:input> --%>
										</div>

										<div class="form-group row">
											<div class="col-lg">

												<fieldset>
													<legend> Payment Type </legend>
													<label><form:radiobutton path="paymentType"
															value="Vendor" disabled="true" /> Vendor </label> <label><form:radiobutton
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


												<%-- 												<div class="row">
													<div class="col-sm-3">
														<label class="l-fontst">Cheque No</label>
													</div>
													<div class="col-sm-6">
														<form:input class="form-control fontst"
															path="chequeNo" onchange="" id="chequeNo"
															required="required" />
													</div>
												</div> --%>


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
												<button type="button" class="btn btn-info mt-4 add-new">
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


										<%-- 										<div class="row">
											<div class="col-lg-4">
											</div>
											<div class="col-lg-4">
												<label>Total Amount</label>
											</div>
											<div class="col-lg">
												<form:input class="form-control" path="totalPayment" placeholder="0.00"/>
												<span id="sumval"></span>
											</div>
											<div class="col-lg">
											</div>
										</div> --%>

										<button type="submit" class="btn btn-success" id="btnSubmit">Process
											Payment</button>
										<button type="reset" class="btn btn-warning" id="btnClear">Clear</button>

									</form:form>

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
$(document).ready(function(){
	$('[data-toggle="tooltip"]').tooltip();
	//var actions = $("table td:last-child").html();

    var actions ="<a class='add' title='Add' data-toggle='tooltip'><i class='material-icons'>&#xE03B;</i></a>" +
                "<a class='edit' title='Edit' data-toggle='tooltip'><i class='material-icons'>&#xE254;</i></a>" +
                "<a class='delete' title='Delete' data-toggle='tooltip'><i class='material-icons'>&#xE872;</i></a>";

	// Append table with add row form on add new button click
    $(".add-new").click(function(){
		//$(this).attr("disabled", "disabled");
		var index = $("table tbody tr:last-child").index();
		
        var glAccNo = $("#glAccNo").val();
        var amount = $("#amount").val();
        var remarks = $("#remarks").val();
		
        var row = '<tr>' +
            '<td><input type="text" class="form-control" name="glAccNo" value="'+glAccNo+'"></td>' +
            '<td><input type="text" class="form-control" name="glAccName" value="'+glAccNo+'"></td>' +
            '<td><input type="text" class="form-control" name="remarks" value="'+remarks+'"></td>' +
            '<td><input type="text" class="form-control" name="amount" value="'+amount+'"></td>' +
			'<td>' + actions + '</td>' +
        '</tr>';
    	$("table tbody").append(row);
    	//caltotalAmount();
		$("table tbody tr").eq(index + 1).find(".add, .edit").toggle();
        $('[data-toggle="tooltip"]').tooltip();
    });
	// Add row on add button click
	$(document).on("click", ".add", function(){
		var empty = false;
		var input = $(this).parents("tr").find('input[type="text"]');
/*         input.each(function(){
			if(!$(this).val()){
				$(this).addClass("error");
				empty = true;
			} else{
                $(this).removeClass("error");
            }
		}); */
		//$(this).parents("tr").find(".error").first().focus();
		if(!empty){
			input.each(function(){
				$(this).parent("td").html($(this).val());
			});			
			$(this).parents("tr").find(".add, .edit").toggle();
			$(".add-new").removeAttr("disabled");
		}		
    });
	// Edit row on edit button click
	$(document).on("click", ".edit", function(){		
        $(this).parents("tr").find("td:not(:last-child)").each(function(){
			$(this).html('<input type="text" class="form-control" value="' + $(this).text() + '">');
		});		
		$(this).parents("tr").find(".add, .edit").toggle();
		$(".add-new").attr("disabled", "disabled");
    });
	// Delete row on delete button click
	$(document).on("click", ".delete", function(){
        $(this).parents("tr").remove();
		$(".add-new").removeAttr("disabled");
    });
});

</script>
<script>
function caltotalAmount(){
	var table = document.getElementById("table1"), sumVal = 0;

	for(var i = 1; i < table.rows.length; i++)
	{
	    sumVal = sumVal + parseInt(table.rows[i].cells[3].innerHTML);
	}

	document.getElementById("sumval").innerHTML = "Sum Value = " + sumVal;
	console.log(sumVal)	
}
</script>

</body>
</html>
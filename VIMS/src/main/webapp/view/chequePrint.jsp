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
								<h2 class="text-white pb-2 fw-bold">Cheque Print</h2>
							</div>
						</div>
					</div>
				</div>
				<div class="page-inner mt--5">					
													
					<div class="row">
						<div class="col-xl-4 mb-4">
			              <div class="card shadow mb-4 border-left-primary">
			                <div class="card-body">
			                	<form:form action="chequePreview"  method="POST">
			                		
			                		<div class="form-group row">
			                			<div class="col-lg">
											<select id="pendingPayment" class="form-control" required="true" onchange="getPaymentDetails(this.value)">									
												<option value="">Select Pending Payment</option>
												<option value="ORE1">ORE1</option>																																			
											</select>
			                			</div>
			                		</div>
			                		<div class="form-group row">
			                			<div class="col-lg">
											<label for="chequeNo" class="text-gray-900">Cheque No.</label>
											<input class="form-control"/>
										</div>
									</div>
			                		<div class="form-group row">
			                			<div class="col-lg">
											<select id="bank" class="form-control" required="true">									
												<option value="">Select Bank</option>																																			
											</select>
			                			</div>
			                		</div>
			                		<div class="form-group row">
			                			<div class="col-lg">
											<select id="bankAccount" class="form-control" required="true">									
												<option value="">Select Bank Account</option>																																			
											</select>
			                			</div>
			                		</div>
			                		<div class="form-group row">
			                			<div class="col-lg">
											<button type="submit" class="btn  btn-block btn-success btn-rounded" >Print Preview</button>
			                			</div>
			                		</div>
			                	</form:form>
							</div>
			              </div>
						</div>
						<div class="col-xl-6 mb-4">
			              <div class="card shadow mb-4 border-left-primary">
			                <div class="card-body">
		                		<div class="form-group row">
		                			<div class="col-lg">
		                				<label>Voucher No. :</label>
		                				<label id="voucherNo"></label>
		                			</div>
		                			<div class="col-lg">
		                				<label>Ref No. :</label>
		                				<label id="refNo"></label>
		                			</div>
		                		</div>
		                		<div class="form-group row">
		                			<div class="col-lg">
		                				<label>Payment Type :</label>
		                				<label id="paymentType"></label>
		                			</div>
		                			<div class="col-lg">
		                				<label>Due Date :</label>
		                				<label id="dueDate"></label>
		                			</div>
		                		</div>
		                		<div class="form-group row">
		                			<div class="col-lg">
		                				<label>To Order of :</label>
		                				<label id="toOrderof"></label>
		                			</div>
		                		</div>
		                		<div class="form-group row">
		                			<div class="col-lg">
		                				<label>Pay to :</label>
		                				<label id="payTo"></label>
		                			</div>
		                		</div>
		                		<div class="form-group row">
		                			<div class="col-lg">
		                				<label>Payment Mean :</label>
		                				<label id="paymentMean"></label>
		                			</div>
		                		</div>
		                		<div class="form-group row">
		                			<div class="col-lg">
										<table class="table table-bordered table-sm">
										  <thead>
										    <tr>
										      <th scope="col">#</th>
										      <th scope="col">GL Account</th>
										      <th scope="col">Remark</th>
										      <th scope="col">Amount</th>
										    </tr>
										  </thead>
										  <tbody>
										  </tbody>
										</table>
		                			</div>
		                		</div>	                		

			                </div>
			              </div>
						</div>
					</div>	

					<c:if test="${pdfViewEq != null }">
						<embed type="application/pdf" src="data:application/pdf;base64,${pdfViewEq}" 
						style="height:600px; width:100%">
						</embed>
					</c:if>
	
				</div>			
			</div>	
			<%@include file="../WEB-INF/jsp/footer.jsp"%>			
		</div>
	</div>
<%@include file="../WEB-INF/jsp/commJs.jsp"%>
<script>
function getPaymentDetails(val){
	if (val=="") {
		return;
	}
	else{
			$.ajax({
		    type: 'GET',
		    url: " getOutgoingPaymentDetails",
		    data: {"voucherNo" : val},
		    success: function(data){
		    	
		    	$("table tbody").empty();
		        for(var i=0; i<data.length; i++){
					var markup = "<tr><td>"+data[i].outgoingPaymentDetailId+"</td><td>"+data[i].glAccNo+"</td><td>" + data[i].remarks + "</td><td>"+data[i].amount+"</td></tr>";
	           		 $("table tbody").append(markup);
		        }
		        
		        $('#voucherNo').text(data[0].paymentVoucherNo.paymentVoucherNo);
		        $('#refNo').text(data[0].paymentVoucherNo.refNo);
		        $('#paymentType').text(data[0].paymentVoucherNo.paymentType);
		        $('#dueDate').text(data[0].paymentVoucherNo.dueDate);
		        $('#toOrderof').text(data[0].paymentVoucherNo.toOrderOf);
		        $('#payTo').text(data[0].paymentVoucherNo.payTo);
		        $('#paymentMean').text(data[0].paymentVoucherNo.paymentMean);

		        
		        
		    },
		    error:function(){
		        alert("Error When Loading Payment Voucher Details !")
		    }
		
		});
	}
}
</script>

</body>
</html>
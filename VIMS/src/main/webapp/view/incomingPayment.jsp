<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ page isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>



<html lang="en">
<head>
	<%@include file="../WEB-INF/jsp/head.jsp"%>
	
	<style>
	.vidSty{
	font-family: Arial, Helvetica, sans-serif;	
	font-size:30px;
	font-weight: bold;
	color: #02d41b;	
	}
	
	
	    .textred{
       font-family: Arial, Helvetica, sans-serif;
        border: 0px solid #b30000;
		font-size:14px;
		font-weight:bold;
       	text-align:center;
       	color: #2c03fc;	
     
       }  
	      .fontst{
         font-family: Arial, Helvetica, sans-serif;
          font-size: 12px;
           height: 30px;
         }
         .l-fontst{
         font-family: Arial, Helvetica, sans-serif;
          font-size: 12px;
          height: 5px;
          margin-top: 0px;
         }
        .iconali{
        	position: absolute; 
  			top: 6px;
			right:-7px;
        
        }
        .capCam{

  			height: 100px;
  			width: 210px;	
		}
		.cursiz{
		font-family: Arial, Helvetica, sans-serif;
        font-size: 12px;
		width: 48px;	
		color: #ff8000;
		
		}
		.amt{
		font-family: Arial, Helvetica, sans-serif;
       font-size: 12px;
       width:60px;
		color: blue;
		text-align: right;
		}

	   .iconstyle{		
  			width: 7%;
  			color:blue';
       }
       .icon-pre-ve{
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
						<div class="d-flex align-items-left align-items-md-center flex-column flex-md-row">
							<div class="col-xl-2 col-lg-2">
								 <h2 class="text-white pb-2 fw-bold">Incoming Payment</h2>
							</div>
							<div class="col-xl-2 col-lg-2">
								
							</div>
							<div class="ml-md-auto py-2 py-md-4">
							  
							
							</div>
						
							<div class="ml-md-auto py-2 py-md-4">
							</div>
						</div>
					</div>
				</div>
				
				<div class="page-inner mt--5">	
								<div class="container-fluid">

<div class="row">				
	<div class="col-xl-4 col-lg-5" >			
					<!-- Card -->
			<form:form action="payIncomingPayment" modelAttribute="incomingPayment" method="POST">		
					<div class="card shadow mb-4" style="height:640px;">
						<div class="card border-left-primary shadow h-100 py-2" >
							<div class="card-header py-2">
								<h6 class="m-0 font-weight-bold text-primary">Incoming Payment</h6>
							</div>
							<div class="card-body">
								

							<div class="form-group row">
									<div class="col-sm-4">
										<label class="l-fontst">Customer</label>
									</div>
										<div class="col-sm-8">
										
										 <div class="form-inline active-cyan-4">
											<input class="form-control form-control-sm mr-3 w-75 fontst"
														name="customer" id="customer" type="text" placeholder="Search"
														aria-label="Search" onchange="getIncomingPaymentDetail();"  required="required">
													<i class="fas fa-search" aria-hidden="true"
														onclick="getIncomingPaymentDetail();"></i>
												</div>
										
										
											
										</div>
									
										
							</div>
							<div class="form-group row">
									<div class="col-sm-4">
										<label class="l-fontst">Total Due Amount</label>
									</div>
										<div class="col-sm-6">
											<input class="form-control fontst" type="text" name="totDueAmt" 
											onchange="" readonly="readonly"
											id="totDueAmt"
											/>	
										</div>
									
										
							</div>
							<div class="form-group row">
									<div class="col-sm-4">
										<label class="l-fontst">Pay Amount</label>
									</div>
										<div class="col-sm-6">
											<input class="form-control fontst" type="number" name="payAmt" 
											onchange="getIncomingPaymentDetail();" required="required"
											id="payAmt"
											/>	
										</div>
									
										
							</div>
		<hr>							
							<div class="form-group row">
								<div class="col-sm-6">
									<label><input type="radio" name="paytype" value="Cash" />Cash</label>
								</div>	
								<div class="col-sm-6">	
									<label><input type="radio" name="paytype" value="CreditCard" />Credit Card</label>

								</div>				
							</div>
							<div class="form-group row">
								<div class="col-sm-6">

									<label><input type="radio" name="paytype" value="Cheque" />Cheque</label>
								</div>	
								<div class="col-sm-6">									
									<label><input type="radio" name="paytype" value="BankTransfer" />Bank Transfer</label>
								</div>		
							</div>
							<div class="form-group row">
								<div class="col-sm-4">
									<label class="l-fontst" id="lname">Name</label>
								</div>
								<div class="col-sm-6">
									<input class="form-control fontst" type="text" name="name"
										onchange="" id="idname" required="required" />
								</div>
							</div>


							<div class="form-group row">
								<div class="col-sm-4">
									<label class="l-fontst" id="lnumber">Number</label>
								</div>
								<div class="col-sm-6">
									<input class="form-control fontst" type="text"
										name="number" onchange="" id="inumber" required="required" />

								</div>
							</div>



							<div class="form-group row">
								<div class="col-sm-4">
									<label class="l-fontst" id="lglacc">G/L Account</label>
								</div>
								<div class="col-sm-6">
									<input class="form-control fontst" type="text"
										name="glAccno" onchange="" id="glAccno"
										required="required" />

								</div>
							</div>

							<div class="form-group row">
								<div class="col-sm-4">
									<label class="l-fontst"  id="lexpData">Exp.Date</label>
								</div>
								<div class="col-sm-6">
									<input class="form-control fontst" type="date"
										name="expDate" onchange="" id="expDate"
										required="required" />

								</div>
							</div>


							<div class="form-group row">
								<div class="col-sm-4">
									<label class="l-fontst" id="lbankchg">Bank Charges</label>
								</div>
								<div class="col-sm-6">
									<input class="form-control fontst" type="text"
										name="bankCharges" onchange="" id="bankCharges"
										required="required" />

								</div>
							</div>






											<!-- 							<div class="form-group row"> -->
<!-- 								<div class="col-sm-12">	 -->
<!-- 									<label class="l-fontst">Name</label> -->
<!-- 									<input class="form-control fontst" type="text" name="name" onchange="" id="totDueAmt" /> -->
									
<!-- 									<label class="l-fontst">Account No</label> -->
<!-- 									<input class="form-control fontst" type="text" name="number" onchange="" id="totDueAmt" /> -->
									
<!-- 									<label class="l-fontst">G/L Account</label> -->
<!-- 									<input class="form-control fontst" type="text" name="glAccno" onchange="" id="totDueAmt" /> -->
							
<!-- 									<label class="l-fontst">DueDate</label> -->
<!-- 									<input class="form-control fontst" type="text" name="expDate" onchange="" id="totDueAmt" /> -->
<!-- 								</div>				 -->
<!-- 							</div>	 -->
			
					
								
	
							<hr>								
							<div class="form-group row">
								
									<div class="col-sm-12">
									<button type="submit" class="btn  btn-block btn-danger btn-rounded tabStyle" >Payment</button>
<!-- 											<a href="#" class="btn btn-primary" onclick="runCancelInvoice();">Invoice Cancel</a>																 -->
									</div>		
							
								</div>
	<hr>				

							</div>
							<!-- End of card body -->
						</div>
					</div>
		</form:form>
		</div>

		<div class="col-xl-8 col-lg-5">			
			<div class="col-sm-12">
			<c:if test="${pdfViewEq == null }">
				<table id="tblIncomingPayment" class="table table-striped table-bordered table-sm table-wrapper-scroll-y my-custom-scrollbar"
						cellspacing="0">

						<thead>
							<tr>
								<th>Vehicle No</th>
								<th>Invoice No</th>
								<th>Date</th>
								<th>Invoice Total</th>
								<th>Balance</th>
								<th>Payment</th>
								<th>Balance</th>
							</tr>
						</thead>
						<tbody id="myTable">
					
						</tbody>
					</table>	

				</c:if>
					<c:if test="${pdfViewEq != null }">
									<embed type="application/pdf" src="data:application/pdf;base64,${pdfViewEq}"
										style="height:600px; width:100%">
										</embed>
										</c:if>
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

	  var bankCharges = document.getElementById("bankCharges");
	  var expDate = document.getElementById("expDate");
	  var glAccno = document.getElementById("glAccno");
	  var number = document.getElementById("inumber");
	  var idname = document.getElementById("idname");
	  
// 	  if (checkBox.checked == true){
// 		  crLimitid.style.display = "block";
// 		  crBalanceid.style.display = "block";
// 		  crLimitidL.style.display = "block";
// 		  crBalanceidL.style.display = "block";
// 	  } else {
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
	
	
	jQuery(document).ready(function(){

		$('input:radio[name="paytype"]').change(function(){
			//Cash 	Credit Card	  Cheque  Bank Transfer
			//lbankchg expData lglacc lnumber lname  glAccno lexpData bankCharges
		    if($(this).val() == 'Cash'){

		    	$('#lname').text("");
		    	$('#lexpData').text("");
		    	$('#lglacc').text("");
		    	$('#lbankchg').text("");
		    	$('#lnumber').text("");
    	

				  bankCharges.value = "0";
				  expDate.value = "1990-01-01";
				  glAccno.value = "--";
				  number.value = "--";
				  idname.value = "--";

				  bankCharges.style.display = "none";
				  expDate.style.display = "none";
				  glAccno.style.display = "none";
				  number.style.display = "none";
				  idname.style.display = "none";
		    	

		    	
		    }else if($(this).val() == 'CreditCard'){
		    	
		    	$('#lname').text("");
		    	$('#lexpData').text("Exp.Date");
		    	$('#lglacc').text("");
		    	$('#lbankchg').text("");
		    	$('#lnumber').text("Credit Card Number");
    	

				  bankCharges.value = "0";
				 expDate.value = "";
				  glAccno.value = "--";
				  number.value = "";
				  idname.value = "--";
		   
				  bankCharges.style.display = "none";
				  expDate.style.display = "block";
				  glAccno.style.display = "none";
				  number.style.display = "block";
				  idname.style.display = "none";		  
				  
		    	
		    }else if($(this).val() == 'Cheque'){
		    	
		    	$('#lname').text("Name");
		    	$('#lexpData').text("Due Date");
		    	$('#lglacc').text("");
		    	$('#lbankchg').text("");
		    	$('#lnumber').text("Cheque Number");
    	

				  bankCharges.value = "0";
				  expDate.value = "";
				  glAccno.value = "--";
				  number.value = "";
				  idname.value = "";
				  
				  bankCharges.style.display = "none";
				  expDate.style.display = "block";
				glAccno.style.display = "none";
				number.style.display = "block";
					idname.style.display = "block";
		    }else if($(this).val() == 'BankTransfer'){
		    	
		    	$('#lname').text("Bank Name");
		    	$('#lexpData').text("");
		    	$('#lglacc').text("Gl Account");
		    	$('#lbankchg').text("Bank Charges");
		    	$('#lnumber').text("");
    	

				  bankCharges.value = "";
				  expDate.value = "1990-01-01";
				  glAccno.value = "";
				  number.value = "--";
				  idname.value = "";	
		    	
				  bankCharges.style.display = "block";
				  expDate.style.display = "none";
				  glAccno.style.display = "block";
				  number.style.display = "none";
				  idname.style.display = "block";
				  
		    }
		});

		});
	
	
	
	
	
	
	
	
	
	
	function getIncomingPaymentDetail() {
	
		var str = document.getElementById("customer").value;
		var payAmt=0;
		var x=document.getElementById("payAmt").value;	
		if(x != "") {
			payAmt=x;
		}

		
		$("table tbody").empty();
		
			$.ajax({
						type : 'GET',
						url : "getIncomingPaymentDetails",
						data : {"cusid" : str},
						success : function(data) {
							var totbal=0;
					
							$("table tbody").empty();
							for (var i = 0; i < data.length; i++) {
								var cpayAmt=0;
								var calBal=0;
								
								if(payAmt<=0){
									cpayAmt=0;
									calBal=0;
								}else{
									payAmt=payAmt-data[i].balance/100;
									if(payAmt>0){
										cpayAmt=data[i].balance/100;
										
									}else{
										cpayAmt=payAmt+data[i].balance/100;
										calBal=data[i].balance/100-cpayAmt;
									}
								}
								var result ="<tr><td>"
									+data[i].vRegisterID.vid.vehicleID
									+"</td><td>"
									+data[i].invoiceNo
									+"</td><td>"	
									+data[i].invoiceDate					
									+"</td><td>"
									+data[i].netTotal/100
									+"</td><td>"
									+data[i].balance/100
									+"</td><td>"
									+cpayAmt
									+"</td><td>"
									+calBal
									+"</td></tr>";					
									$("table tbody").append(result);
									totbal=totbal+data[i].balance;
							}
							document.getElementById("totDueAmt").value=(totbal/100);
						},
						error : function() {
							alert("Model information not found !");
						}

					});
		
		
		
		
		
		
		
		
		
	}
	
	
	
	</script>
	
	

</body>
</html>
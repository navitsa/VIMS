<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<title>Incoming Payment</title>
	<!-- head -->
	<%@include file="../WEB-INF/jspf/head.jsp"%>

	<style>
	.error1 {
		color: red;
		font-size: 12px
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
         .tabStyle{
         font-family: Arial, Helvetica, sans-serif;
          font-size: 12px;
		}
		 .fontstc{
     
           margin-top: 10px;
           margin-left: 25px;
           
         }
	</style>

</head>

<body id="page-top" onload="checkStatusofDropdowns()">

	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- Sidebar -->
		<%@include file="../WEB-INF/jspf/slideBar.jsp"%>

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">

				<!-- Top Bar -->
				<%@include file="../WEB-INF/jspf/header.jsp"%>

				<!-- Begin Page Content -->
				<div class="container-fluid">

<div class="row">				
	<div class="col-xl-12 col-lg-5" >			
					<!-- Card -->
			<form:form action="saveoutgoingPayments"  method="POST" modelAttribute="contactForm">		
					<div class="card shadow mb-4" style="height:640px;">
						<div class="card border-left-primary shadow h-100 py-2" >
							<div class="card-header py-2">
								<h6 class="m-0 font-weight-bold text-primary">Outgoing Payment</h6>
							</div>
							<div class="card-body">
					<div class="form-group row">	
						<div class="col-sm-6">
						
								
							<div class="form-group row">
								<div class="col-sm-3">
									<label><input type="radio" name="actype" value="Vendor" /> Vendor</label>
								</div>	
								<div class="col-sm-4">	
									<label><input type="radio" name="actype" value="Account" /> Account</label>

								</div>				
							</div>		
								
							<div class="form-group row">
								<div class="col-sm-3">
									<label class="l-fontst"  >Payment Due Date</label>
								</div>
								<div class="col-sm-4">
									<input class="form-control fontst" type="date"
										name="payDueDate" onchange="" id="payDueDate"
										required="required" />

								</div>
							</div>	

							<div class="form-group row">
									<div class="col-sm-3">
										<label class="l-fontst">To Order of</label>
									</div>
										<div class="col-sm-6">
										
										
												<input class="form-control fontst" type="text" name="toOrderOf" 
											onchange="" 
											id="toOrderOf"
											/>
												
										
										
											
										</div>
									
										
							</div>
							
							
										<div class="form-group row">
									<div class="col-sm-3">
										<label class="l-fontst">Pay To</label>
									</div>
										<div class="col-sm-6">
										
												<input class="form-control fontst" type="text" name="payTo" 
											onchange="" 
											id="payTo"
											/>
												
										
										
											
										</div>
									
										
							</div>			
					</div>
					<div class="col-sm-6">
					
					
												<div class="form-group row">
								<div class="col-sm-2">
									<label><input type="radio" name="paytype" value="Cash" /> Cash</label>
								</div>	
								<div class="col-sm-2">	
									
								<label><input type="radio" name="paytype" value="Cheque" /> Cheque</label>
								</div>	
								<div class="col-sm-4">									
									<label><input type="radio" name="paytype" value="BankTransfer" /> Bank Transfer</label>
								</div>
								
											
							</div>
						
							<div class="form-group row">
								<div class="col-sm-2">
									<label class="l-fontst" >Cheque No</label>
								</div>
								<div class="col-sm-5">
									<input class="form-control fontst" type="text" name="chequeNo"
										onchange="" id="chequeNo" required="required" />
								</div>
							</div>
					
					
					
					
					</div>
				</div>	
					
							
			<hr>					
						
<!-- 		<div class="col-sm-6">					 -->
					<div class="form-group row">
					
							<div class="col-sm-2">
								<label class="l-fontst">GL Account No</label>
							</div>
							<div class="col-sm-2">
								<input class="form-control fontst" type="text" name="glAccNo" onchange="" id="glAccNo"/>
								
							</div>
							<div class="col-sm-1">
								<label class="l-fontst">Amount</label>
							</div>
							<div class="col-sm-2">
									<input class="form-control fontst" type="number" name="amount" onchange="" id="amount"/>	
							</div>
							<div class="col-sm-1">
								<label class="l-fontst">Remarks</label>
							</div>
							<div class="col-sm-2">
								<input class="form-control fontst" type="text" name="remarks" onchange="" id="remarks"/>
							</div>	
								
											
							</div>				
					<div class="form-group row">
						<div class="col-sm-1">
							<input type="button" class="add-row btn btn-info" value="Add Entery">		
						</div>
					</div>
			<div class="form-group row">
				<div class="col-sm-6">
					<table id="tblIncomingPayment" class="table table-striped table-bordered table-sm table-wrapper-scroll-y my-custom-scrollbar"
							 style="height: 130px">
	
							<thead>
								<tr>
									<th>GL Account No</th>
									<th>GL Account Name</th>
									<th>Amount</th>
									<th>Remarks</th>
									
								</tr>
							</thead>
							<tbody id="myTable">
						
							</tbody>
						</table>	
				</div>
			</div>
			

						
										
							<div class="form-group row">
								
									<div class="col-sm-3">
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

<!-- 		<div class="col-xl-8 col-lg-5">			 -->
<!-- 			<div class="col-sm-12"> -->
<%-- 			<c:if test="${pdfViewEq == null }"> --%>
<!-- 				<table id="tblIncomingPayment" class="table table-striped table-bordered table-sm table-wrapper-scroll-y my-custom-scrollbar" -->
<!-- 						cellspacing="0"> -->

<!-- 						<thead> -->
<!-- 							<tr> -->
<!-- 								<th>Vehicle No</th> -->
<!-- 								<th>Invoice No</th> -->
<!-- 								<th>Date</th> -->
<!-- 								<th>Invoice Total</th> -->
<!-- 								<th>Balance</th> -->
<!-- 								<th>Payment</th> -->
<!-- 								<th>Balance</th> -->
<!-- 							</tr> -->
<!-- 						</thead> -->
<!-- 						<tbody id="myTable"> -->
					
<!-- 						</tbody> -->
<!-- 					</table>	 -->

<%-- 				</c:if> --%>
<%-- 					<c:if test="${pdfViewEq != null }"> --%>
<%-- 									<embed type="application/pdf" src="data:application/pdf;base64,${pdfViewEq}" --%>
<!-- 										style="height:600px; width:100%"> -->
<!-- 										</embed> -->
<%-- 										</c:if> --%>
<!-- 			</div> -->
								
<!-- 		</div> -->
</div>



				</div>
				<!-- /.container-fluid -->
			</div>
			<!-- End of Main Content -->

			<!-- Footer -->
			<%@include file="../WEB-INF/jspf/footer.jsp"%>
		</div>
		<!-- End of Content Wrapper -->

	</div>
	<!-- End of Page Wrapper -->

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>
<%@include file="logoutModel.jsp"%>
	<!-- Bootstrap core JavaScript-->
	<script src="resources/vendor/jquery/jquery.min.js"></script>
	<script src="resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="resources/vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="resources/js/sb-admin-2.min.js"></script>

	<!-- Page level plugins -->


	<!-- Page level custom scripts -->
	<script src="resources/js/file-input.js"></script>
	<script src="resources/js/file-input-validation.js"></script>


	<script>

    $(document).ready(function(){
        
    	$(".add-row").click(function(){
            var glAccNo = $("#glAccNo").val();
            var amount = $("#amount").val();
            var remarks = $("#remarks").val();
            if(glAccNo!=""& amount!=""){
            var contact = "<tr><td>" 
            +"<input name='glAccNo' value='"+glAccNo+"'/>"  + 
            "</td><td></td><td>"
             +"<input name='amount' value='"+amount+"'/>"  + 
            "</td><td>" 
           +"<input name='remarks' value='"+remarks+"'/>"  +
            "</td></tr>";
            }else{
            	
            }
            
            $("table tbody").append(contact);
        });
//     	<button type="button" class="delete-row">Delete Row</button>
        
//         // Find and remove selected table rows
//         $(".delete-row").click(function(){
//             $("table tbody").find('input[name="record"]').each(function(){
//             	if($(this).is(":checked")){
//                     $(this).parents("tr").remove();
//                 }
//             });

    	
    	
    });  
	
// 	jQuery(document).ready(function(){

// 		$('input:radio[name="paytype"]').change(function(){
// 			//Cash 	Credit Card	  Cheque  Bank Transfer
// 			//lbankchg expData lglacc lnumber lname  glAccno lexpData bankCharges
// 		    if($(this).val() == 'Cash'){
		    	
// // 		    	document.getElementById("lbankchg").value="";
// // 		    	document.getElementById("lexpData").value="";
// // 		    	document.getElementById("lglacc").value="";
// // 		    	document.getElementById("lnumber")="ddd";
// 		    	$('#lname').text("");
// 		    	$('#lexpData').text("");
// 		    	$('#lglacc').text("");
// 		    	$('#lbankchg').text("");
// 		    	$('#lnumber').text("");
// 		    	document.getElementById("name").value="--";
// 		    //	document.getElementById("expData").value="";
// 		    	document.getElementById("glAccno").value="--";
// 		    	document.getElementById("bankCharges")="0";	    	
// 		    	document.getElementById("number")="--";		    	
		    	
// 		    }else if($(this).val() == 'Credit Card'){
		    	
		    	
// 		    }else if($(this).val() == 'Cheque'){
		    	
		    	
// 		    }else if($(this).val() == 'Bank Transfer'){
		    	
		    	
		    	
// 		    }
// 		});

// 		});
	
	
	
	
	
	
	
	
	
	
// 	function getIncomingPaymentDetail() {
	
// 		var str = document.getElementById("customer").value;
// 		var payAmt=0;
// 		var x=document.getElementById("payAmt").value;	
// 		if(x != "") {
// 			payAmt=x;
// 		}

		
// 		$("table tbody").empty();
		
// 			$.ajax({
// 						type : 'GET',
// 						url : "getIncomingPaymentDetails",
// 						data : {"cusid" : str},
// 						success : function(data) {
// 							var totbal=0;
					
// 							$("table tbody").empty();
// 							for (var i = 0; i < data.length; i++) {
// 								var cpayAmt=0;
// 								var calBal=0;
								
// 								if(payAmt<=0){
// 									cpayAmt=0;
// 									calBal=0;
// 								}else{
// 									payAmt=payAmt-data[i].balance/100;
// 									if(payAmt>0){
// 										cpayAmt=data[i].balance/100;
										
// 									}else{
// 										cpayAmt=payAmt+data[i].balance/100;
// 										calBal=data[i].balance/100-cpayAmt;
// 									}
// 								}
// 								var result ="<tr><td>"
// 									+data[i].vRegisterID.vid.vehicleID
// 									+"</td><td>"
// 									+data[i].invoiceNo
// 									+"</td><td>"	
// 									+data[i].invoiceDate					
// 									+"</td><td>"
// 									+data[i].netTotal/100
// 									+"</td><td>"
// 									+data[i].balance/100
// 									+"</td><td>"
// 									+cpayAmt
// 									+"</td><td>"
// 									+calBal
// 									+"</td></tr>";					
// 									$("table tbody").append(result);
// 									totbal=totbal+data[i].balance;
// 							}
// 							document.getElementById("totDueAmt").value=(totbal/100);
// 						},
// 						error : function() {
// 							alert("Model information not found !");
// 						}

// 					});
		
		
		
		
		
		
		
		
		
// 	}
	
	
	
	</script>

</body>



</html>
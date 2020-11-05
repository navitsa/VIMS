<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<title>Incoming Receipt Reprint</title>

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

					<!-- Card -->
					<div class="card shadow mb-4">
						<div class="card border-left-primary shadow h-100 py-2">
							<div class="card-header py-3">
								<h6 class="m-0 font-weight-bold text-primary">Incoming Receipt Reprint</h6>
							</div>
							<div class="card-body">
								<form:form action="PrivewReprintIncomingReceipt"  method="POST">

									<div class="form-group row">
										<div class="col-sm-3">
											<label class="l-fontst">Receipt Date</label>
											<input class="form-control fontst" type="date" name="inrecDate" 
											 required
											id="inrecDate" onchange="getIncReceiptNo(this.value);"
											/>
										</div>
										<div class="col-sm-3">
											<label class="l-fontst">Incoming Receipt No</label>
	
												<select class="form-control form-control-user fontst"
												id="inreccno" name="inreccno"  required onchange="getIncReceiptDetail(this.value);">
												<option value=""> --SELECT--</option>
														
											</select>
	
	

	
	
																			
									</div>
							</div>									
										
								<div class="form-group row">
<!-- 									<div class="col-sm-7"> -->
<!-- 											<label> </label> -->
											<button type="submit" class="btn btn-primary tabStyle">
											<i class="fas fa-download fa-sm text-white-50"></i> Print Receipt</button>																
<!-- 									</div> -->
<!-- 									<div class="col-sm-5"> -->
<!-- 										<button type="button" onclick="getVechicalNo();" class="btn btn-primary"><i class="fas fa-download fa-sm text-white-50"></i> Print Token</button> -->
<!-- 									</div> -->
								</div>	
								
								
								</form:form>
								
								<div class="form-group row">
								<div class="col-sm-7">
								
							
								
								<br>
								<c:if test="${pdfViewEq != null }">
									<embed type="application/pdf" src="data:application/pdf;base64,${pdfViewEq}"
										style="height:500px; width:100%">
										</embed>
										</c:if>
										
							
							
								
								</div>
								<div class="col-sm-5">
									
								<br>
								<c:if test="${pdftokValue != null }">
									<embed type="application/pdf" src="data:application/pdf;base64,${pdftokValue}"
										style="height:500px; width:100%">
										</embed>
										</c:if>
									
								
								</div>
								</div>
								

					
	
								<hr>
								
				
								
								

							</div>
							<!-- End of card body -->
						</div>
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
		//onchange="getIncReceiptNo(this.value);"onchange="getIncReceiptDetail(this.value);"
		
			 
			
			function getIncReceiptNo(str) {
				alert(str);
			if (str == "") {

				var slctSubcat = $('#inrecDate'), option = "";
				slctSubcat.empty();
				return;
			} else {
				$.ajax({
							type : 'GET',
							url : "getIncomingReceiptNoByDate",
							data : {"vRdate" : str},
							success : function(data) {
							if(data!=""){
								var slctSubcat = $('#inreccno'), option = "";
								slctSubcat.empty();
								selected_option = "<option value='' selected>--SELECT--</option>"
								slctSubcat.append(selected_option);

								for (var i = 0; i < data.length; i++) {
									option = option
											+ "<option value='"+data[i].inRecNo + "'>"
											+ data[i].inRecNo + "</option>";
								}
								slctSubcat.append(option);
							}else{
								alert("No Incoming Receipt Selected Date");		
							}
							},
							error : function() {
								alert("Error in DB");
							}

						});
			}
		}


	function getReceiptDetail(vecid) {
	
		var vRdate = document.getElementById("recDate").value;

			if (vecid == "") {
				
				//document.getElementById("txtHint").innerHTML="";
				var slctSubcat = $('#recno'), option = "";
				slctSubcat.empty();
				return;
			} else {
				$.ajax({
							type : 'GET',
							url : "getReceiptHeadByVehicalRegID",
							data : {"vRdate" : vRdate, "vecid" : vecid,"payTyp" : "Cash"},
							success : function(data) {

								if(data!=""){
								
								var slctSubcat = $('#recno'), option = "";
								slctSubcat.empty();
								selected_option = "<option value='' selected>--SELECT--</option>"
								slctSubcat.append(selected_option);
								for (var i = 0; i < data.length; i++) {
									option = option
											+ "<option value='"+data[i].recNo + "'>"
											+ data[i].recNo + "</option>";
								}
								slctSubcat.append(option);
								}else{
									alert("No Receip");		
								}
								
								
							},
							error : function() {
								alert("Error in DB");
							}

						});
			}
		}
		

// 	function getVechicalNo() {
		
// 		//@RequestParam String vecno,@RequestParam String reccno,@RequestParam String recDate	
		
// 		var invRdate = document.getElementById("inrecDate").value;
// 		var inreccno = document.getElementById("inreccno").value;
		
// 		$.ajax({
// 							type : 'GET',
// 							url : "vehiclTokenPrint",
// 							data : {"inreccno" : inreccno,"inrecDate" : invRdate},
// 							success : function(data) {
						
// 							}

// 						});
			
// 		}

	
	
	</script>

</body>



</html>
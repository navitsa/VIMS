<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<title>Outgoing Payments</title>
	<!-- head -->
	<%@include file="../WEB-INF/jspf/head.jsp"%>

	<style>
	.error1 {
		color: red;
		font-size: 12px
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
					<div class="shadow mb-4">
						<div class="h-100 py-2">
<!-- 							<div class="card-header py-3"> -->
<!-- 								<h6 class="m-0 font-weight-bold text-primary">Outgoing Payments</h6> -->
<!-- 							</div> -->
							<div class="">
						
								
								<div class="form-group row">
								<div class="col-sm-12">
								
							
								
								<br>
								<c:if test="${pdfViewEq != null }">
									<embed type="application/pdf" src="data:application/pdf;base64,${pdfViewEq}"
										style="height:650px; width:100%">
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

	function getVechicalNo(str) {
			if (str == "") {

				var slctSubcat = $('#vehiNo'), option = "";
				slctSubcat.empty();
				return;
			} else {
				$.ajax({
							type : 'GET',
							url : "getVehicalDetailsByDate",
							data : {"vRdate" : str,"payTyp" : "Credit"},
							success : function(data) {
							if(data!=""){
								var slctSubcat = $('#vehiNo'), option = "";
								slctSubcat.empty();
								selected_option = "<option value='' selected>--SELECT--</option>"
								slctSubcat.append(selected_option);

								for (var i = 0; i < data.length; i++) {
									option = option
											+ "<option value='"+data[i].vid.vehicleID + "'>"
											+ data[i].vid.vehicleID + "</option>";
								}
								slctSubcat.append(option);
							}else{
								alert("No Vehicle Selected Date");		
							}
							},
							error : function() {
								alert("Error in DB");
							}

						});
			}
		}
	
	//get Model related make and class
	function getInvoiceDetail(vecid) {
	
		var vRdate = document.getElementById("recDate").value;

			if (vecid == "") {
				
				//document.getElementById("txtHint").innerHTML="";
				var slctSubcat = $('#recno'), option = "";
				slctSubcat.empty();
				return;
			} else {
				$.ajax({
							type : 'GET',
							url : "getInvoiceHeadByVehicalRegID",
							data : {"vRdate" : vRdate, "vecid" : vecid,"payTyp" : "Credit"},
							success : function(data) {

								var slctSubcat = $('#recno'), option = "";
								slctSubcat.empty();
								selected_option = "<option value='' selected>--SELECT--</option>"
								slctSubcat.append(selected_option);
								for (var i = 0; i < data.length; i++) {
									option = option
											+ "<option value='"+data[i].invoiceNo + "'>"
											+ data[i].invoiceNo + "</option>";
								}
								slctSubcat.append(option);

							},
							error : function() {
								alert("Error in DB");
							}

						});
			}
		}
	

	
	</script>

</body>



</html>
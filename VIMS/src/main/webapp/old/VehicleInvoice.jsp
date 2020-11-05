<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<title>Visual Profile Item</title>
<meta charset="ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<!-- Custom fonts for this template-->
<link href="resources/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="resources/css/sb-admin-2.min.css" rel="stylesheet">

<!-- Custom styles for this page -->
<link href="<c:url value='/resources/css/buttion.css'/>"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link href="<c:url value='/resources/css/scrollbar.css'/>"
	rel="stylesheet">
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
						<div class="card border-left-primary shadow h-100 py-2">
							
							<div class="card-body">
							
								
								<div class="form-group row">
								<div class="col-sm-7">
							
								<c:if test="${pdfViewEq != null }">
									<embed type="application/pdf" src="data:application/pdf;base64,${pdfViewEq}"
										style="height:650px; width:100%">
										</embed>
										</c:if>
										
							
							
								
								</div>
								<div class="col-sm-5">
								
								<c:if test="${pdftokValue != null }">
									<embed type="application/pdf" src="data:application/pdf;base64,${pdftokValue}"
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

	function getVechicalNo() {
		
		//@RequestParam String vecno,@RequestParam String reccno,@RequestParam String recDate	
		
		var vRdate = document.getElementById("recDate").value;
		var reccno = document.getElementById("reccno").value;
		var vecno = document.getElementById("vecno").value;
		$.ajax({
							type : 'GET',
							url : "vehiclTokenPrint",
							data : {"vecno" : vecno,"reccno" : reccno,"recDate" : vRdate},
							success : function(data) {
						
							}

						});
			
		}

	
	
	</script>

</body>



</html>
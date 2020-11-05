<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<title>Incoming Receipt Summary</title>
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
	<div class="col-xl-3 col-lg-5" >			
					<!-- Card -->
			<form:form action="PreviewIncomingReceiptSummary"  method="POST">		
					<div class="card shadow mb-4" style="height:600px;">
						<div class="card border-left-primary shadow h-100 py-2" >
							<div class="card-header py-2">
								<h6 class="m-0 font-weight-bold text-primary">Incoming Receipt Summary</h6>
							</div>
							<div class="card-body">
								

							<div class="form-group row">
										<div class="col-sm-12">
										<label class="l-fontst">From Date</label>
											<input class="form-control fontst" type="date" name="fromdate" 
											onchange=""
											id="recDate"
											/>	
										</div>
									
										
							</div>
							<div class="form-group row">
										<div class="col-sm-12">
										<label class="l-fontst">To Date</label>
											<input class="form-control fontst" type="date" name="todate" 
											onchange=""
											id="recDate"
											/>	
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
									<button type="submit" class="btn  btn-block btn-danger btn-rounded tabStyle" >Print Preview</button>
<!-- 											<a href="#" class="btn btn-primary" onclick="runCancelInvoice();">Invoice Cancel</a>																 -->
									</div>		
							
								</div>
					

							</div>
							<!-- End of card body -->
						</div>
					</div>
		</form:form>
		</div>

		<div class="col-xl-9 col-lg-5">			
			<div class="col-sm-12">
					<c:if test="${pdfViewEq != null }">
									<embed type="application/pdf" src="data:application/pdf;base64,${pdfViewEq}"
										style="height:600px; width:100%">
										</embed>
										</c:if>
			</div>
								
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


	
	
	
	</script>

</body>



</html>
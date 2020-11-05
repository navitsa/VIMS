<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<title>Vehicle Invoice Cancel</title>
	<!-- head -->
	<%@include file="../WEB-INF/jspf/head.jsp"%>

	<style>
		.error1 {
			color: red;
			font-size: 12px
		}
		
		
		.searchCol {
		  color: #4dd0e1;
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
	<div class="col-xl-4 col-lg-5" >			
					<!-- Card -->
					<div class="card shadow mb-4" style="height:600px;">
						<div class="card border-left-primary shadow h-100 py-2" >
							<div class="card-header py-2">
								<h6 class="m-0 font-weight-bold text-primary">Receipt Cancel</h6>
							</div>
							<div class="card-body">
								

							<div class="form-group row">
										<div class="col-sm-12">
											<label class="l-fontst">Receipt No</label>
												<div class="form-inline active-cyan-4">
													<input class="form-control form-control-sm mr-3 w-75 fontst"
														name="reccno" id="reccno" type="text" placeholder="Search"
														aria-label="Search" onchange="getvehiclReceipt();">
													<i class="fas fa-search searchCol" aria-hidden="true"
														onclick="getvehiclReceipt();"></i>
												</div>	
										</div>
									
										
							</div>
							<br>	
							<hr>								
							<div class="form-group row">
								
									<div class="col-sm-12">
									<button type="button" class="btn  btn-block btn-danger btn-rounded" onclick="runCancelReceipt();">Receipt Cancel</button>
<!-- 											<a href="#" class="btn btn-primary" onclick="runCancelInvoice();">Invoice Cancel</a>																 -->
									</div>		
							
								</div>
					

							</div>
							<!-- End of card body -->
						</div>
					</div>

		</div>

		<div class="col-xl-8 col-lg-5">			
			<div class="col-sm-12">
					<embed id="recView"  src="" ></embed>
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
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

		<script>

	function getvehiclReceipt() {
		var reccno=document.getElementById('reccno').value;
			if (reccno == "") {

				var slctSubcat = $('#recView'), option = "";
				slctSubcat.empty();
				return;
			} else {
				$.ajax({
							type : 'GET',
							url : "getRecdetailsPrivew",
							data : {"reccno" : reccno},
							success : function(data) {
								var slctSubcat = $('#recView'), option = "";
								slctSubcat.empty();
								
								if(data!="INACTIVE"){

								selected_option = "<embed  type='application/pdf' src='data:application/pdf;base64,"+data+"' style='height:600px; width:100%'> </embed>"
								slctSubcat.append(selected_option);
								}else{
								
									swal({
										  //title: "Are you sure?",
										  text: "This Receipt has been Canceled!",
										  icon: "warning",
										//  buttons: true,
										//  dangerMode: true,
										});
											
									
									
								}

							},
							error : function() {
								swal({
									  title: "",
									  text: "Receipt is not found!",
									  timer: 2000,
									  showConfirmButton: false
									});
							}

						});
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
			}
		}
	
		function runCancelReceipt(){
			
			var reccno=document.getElementById('reccno').value;
			
			swal({
				  title: "Are you sure?",
				  text: "Once Cancel, you will not be able to recover this Receipt!",
				  icon: "warning",
				  buttons: true,
				  dangerMode: true,
				})
				.then((willDelete) => {
				  if (willDelete) {
					  
					  
					  
					  $.ajax({
							type : 'GET',
							url : "runCancelReceipt",
							data : {"reccno" : reccno},
							success : function(data) {
								
							    swal("Poof! Your Receipt  has been Canceled!", {
								      icon: "success",
								    });
								var slctSubcat = $('#recView'), option = "";
								slctSubcat.empty();
								
							},
							error : function() {
								swal({
									  title: "Error",
									  text: "",
									  timer: 2000,
									  showConfirmButton: false
									});
							}

						});  
				  

				  } else {
				    swal("Your Receipt is safe!");
				  }
				});
			
		
			
		}

	
	</script>

</body>



</html>
<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ page isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>



<html lang="en">
<head>
	<%@include file="../WEB-INF/jsp/head.jsp"%>
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
				<div class="page-inner">	
					<div class="page-header">
							<h4 class="page-title">Invoice Cancel</h4>
							<ul class="breadcrumbs">
								<li class="nav-home">
									<a href="#">
										<i class="flaticon-home"></i>
									</a>
								</li>
							
							
							</ul>
						</div>
				
							<div
								class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
								<div class="col-xl-3 col-md-6 mb-4 ">
									<div class="card border-left-primary shadow h-100 py-2">
										<div class="card-body">
											<div class="row no-gutters align-items-center">
												<div class="col mr-2">
												
												
												

													<div class="form-group row">
										<div class="col-sm-12">
											<label class="l-fontst">Invoice No</label>
												<div class="form-inline active-cyan-4">
													<input class="form-control form-control-sm mr-3 w-75 fontst"
														name="invno" id="invNo" type="text" placeholder="Search"
														aria-label="Search" onchange="getvehiclInvoic();">
													<i class="fas fa-search" aria-hidden="true"
														onclick="getvehiclInvoic();"></i>
												</div>	
										</div>
									
										
							</div>
									<br>	
							<hr>								
										<div class="form-group row">
								
									<div class="col-sm-12">
									<button type="button" class="btn  btn-block btn-danger btn-rounded" onclick="runCancelInvoice();">Invoice Cancel</button>
<!-- 											<a href="#" class="btn btn-primary" onclick="runCancelInvoice();">Invoice Cancel</a>																 -->
									</div>		
							
								</div>
							

									<br>
									<br>
									<br>
									<br>
									<br>
									<br>
									<br>
									<br>
									<br>
									<br>
									<br>
									<br>
									<br>
									<br>
									<br>
									<br>			

													

												</div>
											</div>



										</div>

									</div>
								</div>
		<div class="col-xl-8 col-lg-5">			
			<div class="col-sm-12">
					<embed id="invView"  src="" ></embed>
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

	function getvehiclInvoic() {
		
		var invNo=document.getElementById('invNo').value;
		
			if (invNo == "") {

				var slctSubcat = $('#invView'), option = "";
				slctSubcat.empty();
				return;
			} else {
				$.ajax({
							type : 'GET',
							url : "getInvoicePrivew",
							data : {"invNo" : invNo},
							success : function(data) {
								var slctSubcat = $('#invView'), option = "";
								slctSubcat.empty();
								
								if(data!="INACTIVE"){
								selected_option = "<embed  type='application/pdf' src='data:application/pdf;base64,"+data+"#toolbar=0&navpanes=0&scrollbar=0' style='border: none; height:600px; width:100% '> </embed>"
								slctSubcat.append(selected_option);
								}else{
									
									swal({
										  //title: "Are you sure?",
										  text: "This Invoice has been Canceled!",
										  icon: "warning",
										//  buttons: true,
										//  dangerMode: true,
										});
											
									
									
								}

							},
							error : function() {
								swal({
									  title: "",
									  text: "Invoice is not found!",
									  timer: 2000,
									  showConfirmButton: false
									});
							}

						});
			}
		}
	
		function runCancelInvoice(){
			
			var invNo=document.getElementById('invNo').value;
			
			swal({
				  title: "Are you sure?",
				  text: "Once Cancel, you will not be able to recover this Invoice!",
				  icon: "warning",
				  buttons: true,
				  dangerMode: true,
				})
				.then((willDelete) => {
				  if (willDelete) {
					  
					  
					  
					  $.ajax({
							type : 'GET',
							url : "runCancelInvoice",
							data : {"invNo" : invNo},
							success : function(data) {
								
							    swal("Poof! Your Invoice  has been Canceled!", {
								      icon: "success",
								    });
								var slctSubcat = $('#invView'), option = "";
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
				    swal("Your Invoice is safe!");
				  }
				});
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		}

	
	</script>
</body>
</html>
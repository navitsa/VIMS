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
							<h4 class="page-title">Receipt Cancel</h4>
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
					<embed id="recView"  src="" ></embed>
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
								
								if(data=="BACKDATE"){

									swal({
										  //title: "Are you sure?",
										  text: "You can't Cancel this receipt.",
										  icon: "warning",
										//  buttons: true,
										//  dangerMode: true,
										});
								}else if(data=="INACTIVE"){
									swal({
										  //title: "Are you sure?",
										  text: "This Receipt has been Canceled!",
										  icon: "warning",
										//  buttons: true,
										//  dangerMode: true,
										});
								
								}else{
								
									selected_option = "<embed  type='application/pdf' src='data:application/pdf;base64,"+data+"' style='height:600px; width:100%'> </embed>"
									slctSubcat.append(selected_option);
											
									
									
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
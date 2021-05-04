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
								 <h2 class="text-white pb-2 fw-bold">ES_IN Create</h2>
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
							<div class="col-xl-8">
							
							
							<div class="card shadow mb-4">
								<!-- Card Header - Dropdown -->
								<div class="card-header py-1 d-flex flex-row align-items-center justify-content-between">
									<i class="fa fa-camera" style='font-size:28px;color:#3245f0'></i><h6 class="m-0 font-weight-bold text-primary">.</h6>
								</div>
								
								<form:form  modelAttribute="creaateEsin" method="POST" enctype="multipart/form-data" id="eqissue"> 
								<!-- Card Body -->
								<div class="card-body">
								<div class="row">
									<div class="col-sm-4">
										<div class="row">											
												<div class="col-sm-12">
															<label>Vehicle No</label>
															<select class="form-control" name="ocrid" required="Required" size="25" id="vecno" onchange="getEsINData(this.value);">
																
																<c:forEach items="${completedVehiclesPayment}" var="lan">
																	<option value="${lan.ocrid}">${lan.ocrVid} </option>
																</c:forEach>
															</select>																	
												</div>
											</div>
											<div class="form-group row">
											<input type="button" class="btn btn-success" value="Create Es_IN" onclick="createEsinfile()">
											
											</div>	
											
										
										

																	
									</div>
									<div class="col-sm-3">
										<div class="form-group row">
												<div class="col-sm-12">
													<img src="data:image/jpg;base64,${imgVimg}" class="capCam"  id="results" onerror="this.onerror=null; this.src='resources/img/car-placeholder.jpg'" style="border-radius: 8px; border: 1px solid #ddd;"/>																		
												</div>
										</div>
										<div class="form-group row">
											<div class="col-sm-12">
												<div style="color: #0014ed;  font-size: 16px;" id="vecClass"></div>
											</div>
										</div>
										<div class="form-group row">
											<div class="col-sm-12">
												<div style="color: #0014ed;  font-size: 16px;" id="vecmake"></div>
											</div>
										</div>
										<div class="form-group row">
											<div class="col-sm-12">
												<div style="color: #0014ed;  font-size: 16px;" id="vecModel"></div>
											</div>
										</div>
										
										
									</div>
									<div class="col-sm-5">
										<div class="row">
											<div class="col-sm-12">
												<div style="color: #ff1e00; font-size: 27px;" id="vecNo"></div>
											</div>
										</div>
										<div class="row">
											<div class="col-sm-12">
												<div style="color: #0014ed; font-size: 18px;" id="gateid"></div>
											</div>
										</div>

										
										
										
										
									</div>
								</div>
								
								</div>	
								
											</form:form>							
							
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



	<script type="text/javascript">
	
// 	$(document).ready(function(){
		
// 	    // Initialize select2
// 	    $("#vecno").select2();
	   
// 	});
		function getEsINData(str){
			$.ajax({
				type : 'GET',
				url : "getCreateEsinVehicle",
				data : {"ocrid" : str},
				success : function(data) {
					document.getElementById('results').src = "data:image/jpg;base64,"+arrayBufferToBase64(data.ocrid.noimage);
					document.getElementById('gateid').innerHTML="Gate Entry ID : "+data.ocrid.ocrid;
					document.getElementById('vecNo').innerHTML ="Vehicle No    : "+data.vid.vehicleID;
					
					
					document.getElementById('vecClass').innerHTML="Class : "+data.vid.vmodel.vehicleModel;
					document.getElementById('vecmake').innerHTML ="Make    : "+data.vid.vmodel.vehicleMakeID.vehicleMake;
					document.getElementById('vecModel').innerHTML ="Model    : "+data.vid.vmodel.vehicleClass.vehicleClass;
					
				},
				error : function() {
					alert("error");
				}

			});	
	
		}
	
		function arrayBufferToBase64( buffer ) {
			var binary = '';
			var bytes = new Uint8Array( buffer );
			var len = bytes.byteLength;
			for (var i = 0; i < len; i++) {
				binary += String.fromCharCode( bytes[ i ] );
			}
			return window.btoa( binary );
		}
		
		function createEsinfile() {

			var request_method = $("#eqissue").attr("method"); //get form GET/POST method

			// Get form
			var form = $('#eqissue')[0];

			// Create an FormData object
			var data = new FormData(form);

			//alert("Error "+form_data);
			$.ajax({

				url : "creaateEsin",
				type : request_method,
				enctype : 'multipart/form-data',
				data : data,
				processData : false,
				contentType : false,
				cache : false,

				success : function(data) {
				
					if (data == "0") {
				
						swal("Successfully Create Es_IN File!", "", {
							icon : "success",
							buttons : {
								confirm : {
									className : 'btn btn-success'
								}
							},
						});

					} else if(data=="1"){
 			        		swal("Oops...", "Session Expired", {
 								icon : "error",
 								buttons: {        			
 									confirm: {
 										className : 'btn btn-danger'
 									}
 								},
 							});

 	 						//document.getElementById("proceedLanBtn").style.display = "block";
 	 						//document.getElementById("moreLoder").style.display = "none";
 			        	}else if(data=="2"){
 			        		swal("Oops...", "License Plate is not captured ! Please go to Lane Entry ", {
 								icon : "error",
 								buttons: {        			
 									confirm: {
 										className : 'btn btn-danger'
 									}
 								},
 							});
 			        					        		
// 	 						document.getElementById("proceedLanBtn").style.display = "block";
// 	 						document.getElementById("moreLoder").style.display = "none";
			        	}else if(data=="3"){
 			        		swal("Oops...", "ES_IN Path not Found !", {
 								icon : "error",
 								buttons: {        			
 									confirm: {
 										className : 'btn btn-danger'
 									}
 								},
 							});
			     
// 	 						document.getElementById("proceedLanBtn").style.display = "block";
// 	 						document.getElementById("moreLoder").style.display = "none";
			        	}else if(data=="4"){
 			        		swal("Oops...", "XML_IN Path not Found !", {
 								icon : "error",
 								buttons: {        			
 									confirm: {
 										className : 'btn btn-danger'
 									}
 								},
 							});
			        	}else if(data=="5"){
 			        		swal("Oops...", "This vehicle already assigned to a lane !", {
 								icon : "error",
 								buttons: {        			
 									confirm: {
 										className : 'btn btn-danger'
 									}
 								},
 							});

// 	 						document.getElementById("proceedLanBtn").style.display = "block";
// 	 						document.getElementById("moreLoder").style.display = "none";
			        	}else if(data=="6"){
 			        		swal("Oops...", "Data Transfer Server not Found !", {
 								icon : "error",
 								buttons: {        			
 									confirm: {
 										className : 'btn btn-danger'
 									}
 								},
 							});

// 	 						document.getElementById("proceedLanBtn").style.display = "block";
// 	 						document.getElementById("moreLoder").style.display = "none";
			        	}else if(data=="7"){
 			        		swal("Oops...", "Data not Found !", {
 								icon : "error",
 								buttons: {        			
 									confirm: {
 										className : 'btn btn-danger'
 									}
 								},
 							});

// 	 						document.getElementById("proceedLanBtn").style.display = "block";
// 	 						document.getElementById("moreLoder").style.display = "none";
			        	}else{
						swal("Not Create Ticket", "You clicked the button!", {
							icon : "error",
							buttons : {
								confirm : {
									className : 'btn btn-danger'
								}
							},
						});
						
						
						
						
				
					}
					document.getElementById("eqissue").reset();
				},
				error : function(e) {
					swal("Not Create ES_IN File", "You clicked the button! err", {
						icon : "error",
						buttons : {
							confirm : {
								className : 'btn btn-danger'
							}
						},
					});
					
				}
			});

		}
		</script>
</body>
</html>
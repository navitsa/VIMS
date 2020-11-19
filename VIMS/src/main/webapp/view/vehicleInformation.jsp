<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ page isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>



<html lang="en">
<head>
	<%@include file="../WEB-INF/jsp/head.jsp"%>
		<style>
		.error1{color:red;font-size: 12px } 
		
 		form input[type="file"] { 
          display: none; 
         }
         .numberfield{width:70px;}
         .labelcol{color:black;}
         .imgalign{
           display: block;
  			margin-top: -20px;
 			 margin-right: auto;
 			 width: 80%;
         
         }
         .fontst{
         font-family: Arial, Helvetica, sans-serif;
          font-size: 14px;
          
         }
         .fontcol{
         color: blue;
         }
         .fontcol-peo{
         color: #ff8000;
         }
         .bgred{
         color: #b30000;
         }
         
         .capCam{
/*   			position: absolute; */
/*   			top: 10px; */
/*   			right: 12px; */
  			height: 120px;
  			width: 160px;	
		}
       .iconstyle{		
  			width: 10%;
  			color:blue';
       }
       .camara{
       		width: 190px;
			height: 160px;
       }       
         
         
         
         .spinner {
  margin: 100px auto 0;
  width: 70px;
  text-align: center;
}

.spinner > div {
  width: 18px;
  height: 18px;
  background-color: #333;

  border-radius: 100%;
  display: inline-block;
  -webkit-animation: sk-bouncedelay 1.4s infinite ease-in-out both;
  animation: sk-bouncedelay 1.4s infinite ease-in-out both;
}

.spinner .bounce1 {
  -webkit-animation-delay: -0.32s;
  animation-delay: -0.32s;
}

.spinner .bounce2 {
  -webkit-animation-delay: -0.16s;
  animation-delay: -0.16s;
}

@-webkit-keyframes sk-bouncedelay {
  0%, 80%, 100% { -webkit-transform: scale(0) }
  40% { -webkit-transform: scale(1.0) }
}

@keyframes sk-bouncedelay {
  0%, 80%, 100% { 
    -webkit-transform: scale(0);
    transform: scale(0);
  } 40% { 
    -webkit-transform: scale(1.0);
    transform: scale(1.0);
  }
}
         
         
         
         
         
         
         
         
	</style>
		
		
		
		<style>
	.lds-roller {
	  display: none;
	  position: relative;
	  width: 80px;
	  height: 80px;
	  top: 37px;
	  left: 20px
	  
	  
	}
	.lds-roller div {
	  animation: lds-roller 1.2s cubic-bezier(0.5, 0, 0.5, 1) infinite;
	  transform-origin: 40px 40px;
	}
	.lds-roller div:after {
	  content: " ";
	  display: block;
	  position: absolute;
	  width: 7px;
	  height: 7px;
	  border-radius: 50%;
	  background: #fff;
	  margin: -4px 0 0 -4px;
	}
	.lds-roller div:nth-child(1) {
	  animation-delay: -0.036s;
	}
	.lds-roller div:nth-child(1):after {
	  top: 63px;
	  left: 63px;
	}
	.lds-roller div:nth-child(2) {
	  animation-delay: -0.072s;
	}
	.lds-roller div:nth-child(2):after {
	  top: 68px;
	  left: 56px;
	}
	.lds-roller div:nth-child(3) {
	  animation-delay: -0.108s;
	}
	.lds-roller div:nth-child(3):after {
	  top: 71px;
	  left: 48px;
	}
	.lds-roller div:nth-child(4) {
	  animation-delay: -0.144s;
	}
	.lds-roller div:nth-child(4):after {
	  top: 72px;
	  left: 40px;
	}
	.lds-roller div:nth-child(5) {
	  animation-delay: -0.18s;
	}
	.lds-roller div:nth-child(5):after {
	  top: 71px;
	  left: 32px;
	}
	.lds-roller div:nth-child(6) {
	  animation-delay: -0.216s;
	}
	.lds-roller div:nth-child(6):after {
	  top: 68px;
	  left: 24px;
	}
	.lds-roller div:nth-child(7) {
	  animation-delay: -0.252s;
	}
	.lds-roller div:nth-child(7):after {
	  top: 63px;
	  left: 17px;
	}
	.lds-roller div:nth-child(8) {
	  animation-delay: -0.288s;
	}
	.lds-roller div:nth-child(8):after {
	  top: 56px;
	  left: 12px;
	}
	@keyframes lds-roller {
	  0% {
	    transform: rotate(0deg);
	  }
	  100% {
	    transform: rotate(360deg);
	  }
	}
	
	
	.button4 {background-color: #e7e7e7; color: black;
	 border: none;
	
	} /* Gray */
	</style>
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
			
				<div class="panel-header bg-primary-gradient">
					<div class="page-inner py-4">
						<div class="d-flex align-items-left align-items-md-center flex-column flex-md-row">
							<div>
								<h2 class="text-white pb-2 fw-bold">Gate Entry</h2>
								<h5 class="text-white op-7 mb-2"></h5>
							</div>
							<div class="ml-md-auto py-2 py-md-4">
<!-- 								<a href="vehicleInformation" class="btn btn-white btn-border btn-round mr-2">Gate Entry</a> -->
<!-- 								<a href="vehicleInformation" class="btn btn-white btn-border btn-round mr-2">Vehicle Details</a> -->
<!-- 								<a href="#" class="btn btn-white btn-border btn-round mr-2" data-toggle="modal" data-target="#checkDocumentModal">Document Check</a> -->
<!-- <a  class="btn btn-secondary btn-round" data-toggle="modal" data-target="#checkDocumentModal">Document Check</a> -->
							</div>
						</div>
					</div>
				</div>
	
				<div class="page-inner mt--5">	
<!-- 					<div class="page-header"> -->
<!-- 					<i class="fa fa-camera" style='font-size:36px;color:#3245f0'></i> -->
<!-- 							<h4 class="page-title">Gate Entry</h4> -->
<!-- 							<ul class="breadcrumbs"> -->
<!-- 								<li class="nav-home"> -->
<!-- 									<a href="#"> -->
<!-- 										<i class="flaticon-home"></i> -->
<!-- 									</a> -->
<!-- 								</li> -->
<!-- 								<li class="separator"> -->
<!-- 									<i class="flaticon-right-arrow"></i> -->
<!-- 								</li> -->
<!-- 								<li class="nav-item"> -->
<!-- 									<a href="#"></a> -->
<!-- 								</li> -->
							
<!-- 							</ul> -->
<!-- 						</div> -->
					<div class="row">	
					<div class="col-xl-4">					
					<div class="row">

						<div class="col-xl-12">
							<div class="card shadow mb-4">
								<!-- Card Header - Dropdown -->
								<div class="card-header py-1 d-flex flex-row align-items-center justify-content-between">
									<i class="fa fa-camera" style='font-size:28px;color:#3245f0'></i><h6 class="m-0 font-weight-bold text-primary">.</h6>
								</div>
								<!-- Card Body -->
								<div class="card-body">
									
				
									 <div class="row">
											<div class="col-sm-6">
<!-- 												<div class="row"> -->
												
<!-- 							         			<a href="#" class="" onClick="takeAutoNo()" id="cam-click"> -->
<!-- 							             		<i class="fa fa-refresh  fa-spin" style="font-size:24px"></i>  -->
<!-- 							             		</a>														 -->
<!-- 												</div> -->
												<br>
												<div class="row">
													<div class="col-sm-12">
														<input type="hidden" value='<%=session.getAttribute("vehicleAutoConfig")%>' id="autoValue" >
														<table id="ocrdetails" class="table-wrapper-scroll-y my-custom-scrollbar" style="height: 112px;">                	
					
															<tbody>
															
															
															</tbody>
					
														</table>	
													</div>	
												</div>
												<br>
												
												<div class="row">
													<div class="col-sm-12">
														<a href="#" class="" onClick="takeSnapshot();" id="more">More..</a>	
													
														<div class="spinner-grow" role="status" id="moreLoder" style="display: none;">
													  	<span class="sr-only" >Loading...</span>
													 </div>
												</div>
																								
												
												
												
												
												
												
												</div>
												<div class="row">
													<input type="file" class="" id="num_img"  accept="image/*" capture="user"  style="display: none;" />	
												</div>
												
												
											</div>
											<div class="col-sm-6">
											
												<div class="row">
													<div class="col-mb-12 col-sm-12">
														<img src="resources/img/car-placeholder.jpg" class="capCam"  id="results"/>
								             			<input type="hidden" name="ImageData" id="ImageData"  />
								             			<input type="hidden" class="form-control fontst" id="ocrid"/>	
													</div>
												</div>
												<br>
												<div class="row">
													<div class="col-mb-12 col-sm-12">
														<input class="form-control fontst bgred" id="vehicleID" placeholder="Licence Plate NO..." oninput="getVMasterData(this.value)" onkeyup="this.value = this.value.toUpperCase();" />
													</div>
												</div>
												<br>
												<div class="row">
													<div class="col-mb-12 col-sm-12">
														<a href="#" class="btn btn-success btn-block" onClick="ocrImageNumberSava('1')" style="display: none;" id="capButtion">Continue</a>
<!-- 														<a href="#" class="btn btn-success btn-block" onClick="goToVehicleRegFrmOrNew()">Continue</a> -->
													
											<div class="spinner" style="display: none;" id="lod1">
												  <div class="bounce1"></div>
												  <div class="bounce2"></div>
												  <div class="bounce3"></div>
											</div>	
														

													</div>
													

												</div>	
											</div>
									</div>
									
									
									
				<!-- 						<div class="row"> -->
				<!-- 			             	<div class="col-sm-5"> -->
							   
							             	
							             	
				
							             		
				<!-- 			             	</div> -->
				<!-- 			             	<div class="col-sm-2"> -->
				<!-- 			             	</div> -->
				<!-- 			             	<div class="col-sm-5 justify-content-end"> -->
							             	
							             		
				
				<!-- 			            	</div> -->
				<!-- 			             </div> -->
									
					


								</div>
							</div>
						</div>
					</div>				
					<div class="row">
						<div class="col-xl-12" hidden="true" id="vdetails">
							<div class="card shadow mb-4">
								<!-- Card Header - Dropdown -->
<!-- 								<div class="card-header py-1 d-flex flex-row align-items-center justify-content-between"> -->
<!-- <!-- 									<i class="fa fa-car" style='font-size:36px;color:#3245f0'></i> --> 
<!-- 									<h6 class="m-0 font-weight-bold text-primary">.</h6> -->
<!-- 								</div> -->
									<div class="card-header py-0 d-flex justify-content-between">
<!-- 									<img src="resources/img/icon/vowner.png" class="iconstyle"/> -->
									<h6 class="font-weight-bold text-primary">Vehicle</h6>
									</div>
								<!-- Card Body -->
								<div class="card-body">

								
									 <div class="row">
										<div class="col-sm-4">
											<label class="fontst">Class</label>
										</div>
										<div class="col-sm-6">	
										<label class="fontst fontcol" id="veclass"></label>	             	
				<!-- 							<input class="fontst "  value="" readonly="true" id="veclass"/>			             											             		 -->
										</div>						
										<div class="col-sm-2"><br>
											<img src="" id="classImg" class="img-responsive imgalign">
										</div>
									</div>
									<div class="row">
										<div class="col-sm-4">
											<label class="fontst">Make/Model</label>
										</div>
										<div class="col-sm-8">	
											<label class="fontst fontcol" id="vMnM"></label>	   	             	
														             											             		
										</div>						
									</div>
								
									<div class="row">
										<div class="col-sm-4">
						            	<label for="engineNo" class="fontst">Engine No</label>
										</div>
										<div class="col-sm-6">
								            	<label class="fontst fontcol-peo" id="engNo"></label>  	             	
														             											             		
										</div>						
										<div class="col-sm-2"><br>
											
										</div>
									</div>
									<div class="row">
										<div class="col-sm-4">
						            	<label for="engineNo" class="fontst">Chassis No</label>
										</div>
										<div class="col-sm-6">
								            	<label class="fontst fontcol-peo" id="chaNor"></label>  	             	
														             											             		
										</div>						
										<div class="col-sm-2"><br>
											
										</div>
									</div>			
								
									<div class="row">
										<div class="col-sm-4">
						            	<i class='fas fa-gas-pump'></i>
										</div>
										<div class="col-sm-6">
								            	<label class="fontst fontcol" id="fuelTyp"></label>  	             	
														             											             		
										</div>						
										<div class="col-sm-2"><br>
											
										</div>
									</div>	
													
							</div>
								<div class="card-header py-0 d-flex justify-content-between">
<!-- 									<img src="resources/img/icon/vowner.png" class="iconstyle"/> -->
									<h6 class="font-weight-bold text-primary">Current Owner</h6>
								</div>
							<div class="card-body">	
									<div class="row">
										<div class="col-sm-1">
										<i class="fas fa-user"></i>
				 						</div>
				 						<div class="col-sm-10">
						            	<label class="fontst fontcol" id="ownerName"></label>
										</div>
									</div>		
									<div class="row">
										<div class="col-sm-1"><i class="fa fa-phone" aria-hidden="true"></i> </div>
										<div class="col-sm-6">
						            	
						            	<label class="fontst fontcol" id="contactNo"></label>
										</div>
										
										<div class="col-sm-5">
										<a href="#" class="btn btn-info btn-sm" onClick="ocrImageNumberSava('2')">Edit Vehicle</a>
										</div>
										
									</div>		
				
									
								</div>
							</div>
						</div>
	
						
					</div>
					 </div>
				<!-- 		===========================================================		  --> 
				 <div class="col-xl-4">
				 
				 			<div class="card shadow mb-4">
				<!-- Card Header - Dropdown -->
				<div class="card-header py-2 d-flex flex-row align-items-center">
<!-- 					<img src="resources/img/icon/perviousVehicleicon.png" class="iconstyle"/> -->
					<h6 class="m-0 font-weight-bold text-primary">Pending Lane Registrations</h6><span class="badge badge-pill badge-warning" id="pendingVehic" style="font-size:15px; font-weight: 900; color:black; border-radius: 50%;"></span>
				</div>
				<!-- Card Body -->
				<div class="card-body  table-wrapper-scroll-y my-custom-scrollbar" style="height: 630px;">	
					<div class="row" >
								<div class="col-mb-12" id="ocrVehicle">
	
																	
								</div>
					</div>	
					
	
				</div>
			</div>
				 
				 </div>
				<!-- 		===========================================================		  --> 
				 <div class="col-xl-3">
				 
				 <div class="card shadow mb-4">
				<!-- Card Header - Dropdown -->
				<div class="card-header py-2 d-flex flex-row align-items-center">
<!-- 					<img src="resources/img/icon/perviousVehicleicon.png" class="iconstyle"/> -->
					<h6 class="m-0 font-weight-bold text-primary">Pending Appointment</h6><span class="badge badge-pill badge-warning" id="pendingAppoi" style="font-size:15px; font-weight: 900; color:black; border-radius: 50%;"></span> 
				</div>
				<!-- Card Body -->
				<div class="card-body  table-wrapper-scroll-y my-custom-scrollbar" style="height: 630px">	
					<div class="row" >
								<div class="col-sm-12" id="asss">
																
								</div>
					</div>	
					
	
				</div>
			</div>
				 
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

	<script language="JavaScript">
// 	var id;
	
	
// 		Webcam.set({
// 			width: 190,
// 			height: 160,
// 			image_format: 'jpeg',
// 			jpeg_quality: 100
// 		});
// 		//Webcam.attach( '#my_camera' );
// 		 Webcam.attach( document.querySelector('#my_camera') );
		
		
	</script>
	
	<!-- Code to handle taking the snapshot and displaying it locally -->
	<script language="JavaScript">
	
	var status="0";	
	var appointmrntNo="0";	
	
	
	//
	
		function takeSnapshot() {
			document.getElementById("moreLoder").style.display = "block";
			document.getElementById("more").style.display = "none";
				// var str = document.getElementById("ocrid").value;
				// var y=0;
 				// if(str!=""){
 				//	 y=str;					 
 				// }
 				//document.getElementById("lice-msg").style.display = "none";
				//document.getElementById("loader").style.display = "block";
				//document.getElementById("cam-click").style.display = "none";
					
				
			//	var jsonfile={id:y,mthod:meth};
				$.ajax({

				    type: 'POST',
				    url: "getLicensePlateip",
			        success: function(data){
			        	
			        	//document.getElementById('ocrid').value=data[0].id;
			        	
// 			            var slctSubcat=$('#ocrdetails'), option="";
// 			            slctSubcat.empty();
// 			            selected_option = "  <tr><td></td></tr>"
			            
			           
			            	
// 			            slctSubcat.append(selected_option);

			        //  if(data[0].number==""){
			        	  
			       // 	  document.getElementById("lice-msg").style.display = "block";
			        	  
			        //  }
			              
			        	document.getElementById('vehicleID').value = data[0].number;
      					getVMasterData(data[0].number);
			            document.getElementById('results').src = "data:image/jpg;base64,"+data[0].noimage;			    		
			            document.getElementById("ImageData").value="data:image/jpg;base64,"+data[0].noimage;

					//	document.getElementById("loader").style.display = "none";
					//	document.getElementById("cam-click").style.display = "block";
						
  						document.getElementById("moreLoder").style.display = "none";
  						document.getElementById("more").style.display = "block";
			            slctSubcat.append(option);	 
			           
			           
			        },
			        error:function(){
			        	//alert("Error");
			        	document.getElementById("moreLoder").style.display = "none";
			        	document.getElementById("more").style.display = "block";
			        }
				 });
				
				
	
		}
		takeAutoNo();
		
		function takeAutoNo() {
			
			if(<%=session.getAttribute("userId")%>==null){
        		Swal.fire({
        			  icon: 'error',
        			  title: 'Oops...',
        			  text: 'Session Expired'
        			  //,footer: '<a href>Why do I have this issue?</a>'
        			});
			window.location.href = "logout";
			}	
			
			
			
		setTimeout(takeAutoNo, 3000); 

			$.ajax({

			    type: 'POST',
			    url: "takeAutoNo",
		        success: function(data){

		        	$("table tbody").empty();
					for(var i=0; i<data.length; i++){
					
						var markup =  "<tr data-folder='ghjgh'><td>"+ data[i].number+ "</td>"
				            +"<td style='display:none;'>"+ data[i].noimage+"</td>"
				            +"</tr>";
							
							$("table tbody").append(markup);
		           	 }
   	
		        },
		        error:function(){
		        //	alert("Error");
		        }
			 });
		var g=0;
			//pending Registation
			$.ajax({

			    type: 'POST',
			    url: "getOcrVehicle",
		        success: function(data){
		            var slctSubcat=$('#ocrVehicle'), option="";
		            slctSubcat.empty();
		        	for(var i=0; i<data.length; i++){
		        		
		        		
		        		var link="";
	        			var statu="";
		        		g=g+1;
// 		        		if(data[i].vmStatus=="pending"){
// 		        			statu="<div class='row'>"+
// 						"<div class='col-sm-12'>"+
// 							"<div style='color: #000000; font-family: Arial, Helvetica, sans-serif; font-size: 13px; color:#cf6e06'>Vehicle Details    -    <i class='fas fa-exclamation' style='font-size:12px;color:#faa005'></i></div>"+
// 					"</div></div>";
// 			        		if(data[i].vehicletype=="New"){
// 			        			link="newVehicleMaster?vehicleID="+data[i].ocrVid+"&id="+data[i].ocrid;
// 			        		}else if(data[i].vehicletype=="Old"){
// 			        			link="vehicleMasterAuto?vehicleID="+data[i].ocrVid+"&id="+data[i].ocrid+"&appNo=0";
// 			        		}
					
					
// 								}else if(data[i].docStatus=="pending"){
// 									statu="<div class='row'>"+
// 									"<div class='col-sm-12'>"+
// 										"<div style='color: #000000; font-family: Arial, Helvetica, sans-serif; font-size: 13px; color:#066301'>Vehicle Details    -    <i class='fa fa-check' style='font-size:12px;color:#0fad07'></i></div>"+
// 									"</div></div>"+
// 									"<div class='row'>"+
// 										"<div class='col-sm-12'>"+
// 											"<div style='color: #000000; font-family: Arial, Helvetica, sans-serif; font-size: 13px; color:#cf6e06'>Document Verification    -    <i class='fas fa-exclamation' style='font-size:12px;color:#faa005'></i></div>"+
// 										"</div>"+
// 									"</div>";	
// 								}else if(data[i].vrStatus=="pending"){
									
	
									
// 									link="vehicleRegistrationAuto?vid="+data[i].ocrVid+"&curMi=0"+"&id="+data[i].ocrid;
									
									
// 								}
		        		
		        		if(data[i].vmStatus=="pending"){
						statu=statu+"<div class='row'>"+
						"<div class='col-sm-12'>"+
						"<div style='color: #000000; font-family: Arial, Helvetica, sans-serif; font-size: 13px; color:#cf6e06'>Vehicle Details    -    <i class='fas fa-exclamation' style='font-size:12px;color:#faa005'></i></div>"+
						"</div></div>";
			        		if(data[i].vehicletype=="New"){
		        				link="newVehicleMaster?vehicleID="+data[i].ocrVid+"&id="+data[i].ocrid;
			        		}else if(data[i].vehicletype=="Old"){
			        			link="vehicleMasterAuto?vehicleID="+data[i].ocrVid+"&id="+data[i].ocrid+"&appNo=0";
			        		}
						
		        		}else{
		        			statu=statu+"<div class='row'>"+
							"<div class='col-sm-12'>"+
								"<div style='color: #000000; font-family: Arial, Helvetica, sans-serif; font-size: 13px; color:#066301'>Vehicle Details    -    <i class='fa fa-check' style='font-size:12px;color:#0fad07'></i></div>"+
							"</div></div>";
		        			link="vehicleRegistrationAuto?vid="+data[i].ocrVid+"&curMi=0"+"&id="+data[i].ocrid;
		        		}
		        		
		        		if(data[i].docStatus=="pending"){
							statu=statu+"<div class='row'>"+
							"<div class='col-sm-12'>"+
							"<div style='color: #000000; font-family: Arial, Helvetica, sans-serif; font-size: 13px; color:#cf6e06'>Document Verification    -    <i class='fas fa-exclamation' style='font-size:12px;color:#faa005'></i></div>"+
							"</div></div>";
			        		}else{
			        			statu=statu+"<div class='row'>"+
								"<div class='col-sm-12'>"+
									"<div style='color: #000000; font-family: Arial, Helvetica, sans-serif; font-size: 13px; color:#066301'>Document Verification    -    <i class='fa fa-check' style='font-size:12px;color:#0fad07'></i></div>"+
								"</div></div>";
			        			
			        		}
		        		
		        		if(data[i].vrStatus=="pending"){
							statu=statu+"<div class='row'>"+
							"<div class='col-sm-12'>"+
							"<div style='color: #000000; font-family: Arial, Helvetica, sans-serif; font-size: 13px; color:#cf6e06'>Vehicle Regostration    -    <i class='fas fa-exclamation' style='font-size:12px;color:#faa005'></i></div>"+
							"</div></div>";
			        		}else{
			        			statu=statu+"<div class='row'>"+
								"<div class='col-sm-12'>"+
									"<div style='color: #000000; font-family: Arial, Helvetica, sans-serif; font-size: 13px; color:#066301'>Vehicle Regostration    -    <i class='fa fa-check' style='font-size:12px;color:#0fad07'></i></div>"+
								"</div></div>";
			        			
			        		}
		        		
						
		        	//	var encodedString = btoa(data[i].noimage);

		        	//	alert(data[i].noimage);
		        		
		        	//alert("dd");
		        	
		 
	//  var enc =arrayBufferToBase64(data[i].noimage );// window.btoa(data[i].noimage);
    
// 	  alert(enc);
		        	
		        	var  img="";
// 		        	if(data[i].noimage!=null){
		        	//	onerror="this.src='resources/img/car-placeholder.jpg'"
		       
		        		img="<img src='data:image/jpg;base64,"+arrayBufferToBase64(data[i].noimage )+"' width='90' height='80' onerror='this.src='resources/img/car-placeholder.jpg';' alt='No Image'/>";	
// 		        	}else{
// 		        		img="<img src='resources/img/car-placeholder.jpg' width='90' height='80' alt='No image' />";	
// 		        	}
// 		   	<img src="resources/img/car-placeholder.jpg" class="capCam"  id="results"/>
		        	
		        		
	        			 selected_option = 
	        	"<div class='row'    style='padding-left:40px;'> "+	        			
	 					"<div class='col-mb-2'></div><div class='col-mb-1'>"+
	 					"<a href='"+link+"'>"+
	 						"<div class='row'>"+
	 							"<div class='col-sm-12'>"+
	 								"<div style='color: #ff0516; font-family: Arial, Helvetica, sans-serif; font-size: 14px'>"+data[i].ocrVid+"</div>"+
	 							"</div>"+
	 						"</div>"+

 							"<div class='row'>"+
								"<div class='col-sm-12'>"+
									"<div style='color: #000000; font-family: Arial, Helvetica, sans-serif; font-size: 13px'>Gate Entry ID - "+data[i].ocrid+"</div>"+
								"</div>"+
							"</div>"+
							
							statu+"<hr/>"+
							"</a>"+
						"</div>"+
					
					"<div class='col-mb-4'  style='padding-left:40px;'>"+
					"<div class='row'>"+
						"<div class='col-sm-12'>"+
					
					img+
						"</div>"+
					"</div>"+
					
				
					"</div></div>";
	            	 slctSubcat.append(selected_option);	
	        	}

		        	document.getElementById('pendingVehic').innerHTML = g;
		        },
		        error:function(){
		        //	alert("Error");
		        }
			 });
			
			
			
			
			
			
			function clickNext(){
				alert("");
				
			}
			
	//	});

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
	</script>
	
	
	
	<script type="text/javascript">



	var table = document.getElementsByTagName("table")[0];
	var tbody = table.getElementsByTagName("tbody")[0];
	tbody.onclick = function (e) {
	    e = e || window.event;
	    var data = [];
	    var target = e.srcElement || e.target;
	    while (target && target.nodeName !== "TR") {
	        target = target.parentNode;
	    }
	    if (target) {
	        var cells = target.getElementsByTagName("td");
	        for (var i = 0; i < cells.length; i++) {
	            data.push(cells[i].innerHTML);
	        }
	    }
	  //  alert(data[0]);
	    
			document.getElementById('vehicleID').value = data[0];
			getVMasterData(data[0]);
			document.getElementById('results').src = "data:image/jpg;base64,"+data[1];
			 document.getElementById("ImageData").value="data:image/jpg;base64,"+data[1];
	};


	

	

	function getClassImage(str)
	{ 
		//var str = document.getElementById("vClass").value;
		
		//alert(str);
		if (str=="") {
	    	var slctSubcat=$('#cate'), option="";
	        slctSubcat.empty();
	   
		return;
		}
		else{			
			$.ajax({
		        type: 'GET',
		        url: "getVClassImage",
		        data: {"classid" : str},
		        success: function(data){
					 var x = document.getElementById("classImg");
					 
					 x.setAttribute("src", "data:image/jpg;base64,"+data+"");
					 x.setAttribute("width", "150");
					 x.setAttribute("height", "40");	       	
		      	
		        },
		        error:function(){
	
		        }
	    	});		
			
			}
		}
	

		function getVMasterData(x) {
			 document.getElementById("capButtion").style.display = "none";
			 document.getElementById("lod1").style.display = "block";
		//   var x = document.getElementById("vehicleID");
		 //  document.getElementById("skipbtn").style.visibility = "hidden";
		   
			if (x=="") {
				 document.getElementById('vdetails').hidden = true;
				 document.getElementById("capButtion").style.display = "none";
				 document.getElementById("lod1").style.display = "none";
	    		var slctSubcat=$('#vehicleID'), option="";
	            slctSubcat.empty();
	           
	    	return;
			}else{
				
		   $.ajax({
		        type: 'GET',
		        url: "getFindVmaster",
		        data: {"vehicleID" :x},
		        success: function(data){
		        
		        if(data!=null&&data!=""){
		       
		        	$('#veclass').text(data.vmodel.vehicleClass.vehicleClass);
		        	$('#vMnM').text( data.vmodel.vehicleMakeID.vehicleMake+' / '+data.vmodel.vehicleModel);
		        	//$('#vModel').text(data.vmodel.vehicleModel);

		        	
		        	$('#engNo').text(data.engineNo);
		        	$('#chaNor').text( data.chassisNo);
		        	$('#fuelTyp').text(data.ftype.fuel);
    	
					 getClassImage(data.vmodel.vehicleClass.vehicleClassID);
					 document.getElementById('vdetails').hidden = false;
					if(status!="3"){
					 status="1";
		        		}
					 document.getElementById("capButtion").style.display = "block";
					 document.getElementById("lod1").style.display = "none";

		        }else{
		        	
		        	 document.getElementById('vdetails').hidden = true;
		        	
		        	
		        	 status="0";
		        	 document.getElementById("capButtion").style.display = "block";
		        	 document.getElementById("lod1").style.display = "none";
		        }
		       	 
		        },
		        error:function(){
		        	 document.getElementById('vdetails').hidden = true;
		        	 document.getElementById("capButtion").style.display = "block";
		        	 document.getElementById("lod1").style.display = "none";
		        	 status="0";
		        	//alert("error");
		        }
		
		    });
		   
		   
			$.ajax({
		        type: 'GET',
		        url: "getVehicleOwnerIDByVehicleID",
		        data: {"vehicleID" : x},
		        success: function(data){
		        	$('#ownerName').text(data.ownerName);
		        	$('#contactNo').text(data.contactNo);

		        },
		        error:function(){
		          //  alert("error");
		        }

		    });
   
			}	
			getAllPendingAppointment(x);
		}
	
		function takeAutoCapMore(){
		
			
			var imagebase64=document.getElementById("ImageData").value;
			var vecn=document.getElementById('vehicleID').value;
			
			if(vecn!=""){
			var jsonfile={json:JSON.stringify(imagebase64),vecno:vecn};
			$.ajax({

			    type: 'POST',
			    url: "takeAutoCapMore", 
			    data: jsonfile,
		        success: function(data){
		        	
		        		document.getElementById('vehicleID').value=data;
		        		  getVMasterData(data);
		        },
		        error:function(data){
		        	alert(data.responseText);
		           
		        }
			 });
			
			}else{
				alert("Capture License Plate");
				
			}
			
		}
		
		
		function ocrImageNumberSava(meth){
			
			
			
			var imagebase64=document.getElementById("ImageData").value;
			var vecn=document.getElementById('vehicleID').value;
			
			var autoValue=document.getElementById('autoValue').value;
			var apoid=appointmrntNo;
			
			if(vecn!=""){
			var jsonfile={json:JSON.stringify(imagebase64),vecno:vecn,vtype:status,apoid:apoid};
			$.ajax({

			    type: 'POST',
			    url: "createOcrId", 
			    data: jsonfile,
		        success: function(data){
		        	if(data!="0"){
		        	document.getElementById("ocrid").value=data;
		        		if(meth==1){
		        		
		        			
		        			if(autoValue.split("-")[0].substring(0,1)=="1"){
		        				
		        				goToVehicleRegFrmOrNew();
		        			
		        			}else{
		        				
		        				 swal("Good job!", "You clicked the button!", "success")
	
		        				//swal("Good job!", "You clicked the button!", "success")
		        				window.location.href ="vehicleInformation";
		        				
		        			}
		        			
		        		}else if(meth==2){
		        			
		        			vehicleMaster();
		        		}
		        	
		        	}else{
		        		alert("Data Not Save");
		        	}
		        },
		        error:function(data){
		        	alert(data.responseText);
		           
		        }
			 });
			
			}else{
				alert("Capture License Plate");
				
			}
			
		}
		
		
		
		function vehicleMaster() {
			
			 var str = document.getElementById("ocrid").value;
			 var y=0;
				 if(str!=""){
					 y=str;					 
				 }
			
			 var vid = document.getElementById("vehicleID").value;
			window.location.href = "vehicleMasterAuto?vehicleID="+vid+"&id="+y+"&appNo="+appointmrntNo;
		
		
		}
		
		function goToVehicleRegFrmOrNew(){	
			
			var vid = document.getElementById("vehicleID").value;
		 	var str = document.getElementById("ocrid").value;
			 var y=0;
			 
			 if(str!=""){
				 y=str;					 
			 }
	
			if(status=="1"){	
				//window.location.href = "checkDocumentAuto?vid="+vid+"&id="+y+"&curMi=0";
				
				//window.location.href = "checkDocumentAuto?vecNo="+vid+"&id="+y+"&curMi=0";
				vehicleMaster();
				
				
			}else if(status=="3"){
				vehicleMaster();
			}else{				
				window.location.href ="newVehicleMaster?vehicleID="+vid+"&id="+y;	
				
			}
		}
		
	
		
	</script>
	
	<script>
		function hideContinue() {
			 id="0";
		}
	</script>
	
	
		<script type="text/javascript">
		pageLoadRun();
		function pageLoadRun() {
			if(/Android|webOS|iPhone|iPad|iPod|BlackBerry|IEMobile|Opera Mini/i.test(navigator.userAgent)){
				  // true for mobile device
				 // document.write("mobile device");
				  document.getElementById("num_img").style.display = "block";
				 // document.getElementById("num_img_g").style.display = "block";
			//	  document.getElementById("cam-click").style.display = "none";
				  document.getElementById("more").style.display = "none";
				  
				  
				//  alert("error");
				}else{
				  // false for not mobile device
				//    alert("error");
				//  document.write("not mobile device");
				
				 // document.getElementById("num_img_g").style.display = "none";
				//  document.getElementById("cam-click").style.display = "block";
				  document.getElementById("more").style.display = "block";
				}
			
		}
		
		var base64;
		//equipment Img
		$(document).on("click", ".browse", function() {
			var file = $(this).parents().find(".file");
			file.trigger("click");
		});
		$('#num_img').change(function(e) {
			var fileName = e.target.files[0].name;
			$("#file").val(fileName);

			var reader = new FileReader();
			reader.onload = function(e) {
				// get loaded data and render thumbnail.
			//	document.getElementById("results").src = e.target.result;
			
				base64=e.target.result.replace(/^data:image\/(png|jpg);base64,/, "");

				document.getElementById("results").src =base64;
				//	alert(base64);
				
				
				//	document.getElementById('results').src = data_uri;	
				document.getElementById('ImageData').value = base64;
				
				 
				 
				 var str = document.getElementById("ocrid").value;
				 var y=0;
					 if(str!=""){
						 y=str;					 
					 }
					document.getElementById("lice-msg").style.display = "none";
					//	document.getElementById("my_camera").style.display = "none";
					document.getElementById("loader").style.display = "block";
					//document.getElementById("cam-click").style.display = "none";

				
				var jsonfile={json:JSON.stringify(base64),id:y};
				$.ajax({

				    type: 'POST',
				    url: "saveLicensePlate", 
				    data: jsonfile,
			        success: function(data){
			        	
			        	document.getElementById('ocrid').value=data[0].id;
			        	
			            var slctSubcat=$('#ocrdetails'), option="";
			            slctSubcat.empty();
			            selected_option = "  <tr><td></td></tr>"
			            slctSubcat.append(selected_option);

			          if(data[0].number==""){
			        	  
			        	  document.getElementById("lice-msg").style.display = "block";
			        	  
			          }
			              
			               document.getElementById('vehicleID').value = data[0].number;
	  					   getVMasterData(data[0].number)
			            
	 				//	document.getElementById("my_camera").style.display = "block";
						document.getElementById("loader").style.display = "none";
						
			            slctSubcat.append(option);	  	
			      	
			        },
			        error:function(data){
			        	alert(data.responseText);
			           
			        }
				 });
				
		
				
			};
			// read the image file as a data URL.
			reader.readAsDataURL(this.files[0]);
		
			//  document.querySelector('results').src = URL.createObjectURL(file)

	
			
			
		});
		
		
		getAllPendingAppointment("");
		
		function getAllPendingAppointment(vno){
			
			appointmrntNo="0";
			var hj=0;
		//	alert(vno)
			$.ajax({
		        type: 'GET',
		        url: "getAllPendingAppointment", 
		        success: function(data){
		        	
		            var slctSubcat=$('#asss'), option="";
		            slctSubcat.empty();
		        	for(var i=0; i<data.length; i++){
		        		hj=hj+1;
		        		if(vno==data[i].vehicle_id.vehicleID){
		        			 status="3";
		        			 appointmrntNo=data[i].appointmentID;
		        			 //alert(data[i].vehicle_id.vehicleID);
		        			 
		        			 selected_option = "<div class='row'style='background-color: green; background: rgba(0, 128, 0, 0.3)'>"+
		 					
		 					"<div class='col-sm-12'>"+
		 						"<div class='row'>"+
		 							"<div class='col-sm-12'>"+
		 								"<div style='color: #ff0516; font-family: Arial, Helvetica, sans-serif; font-size: 14px'>"+data[i].vehicle_id.vehicleID+"</div>"+
		 							"</div>"+
		 						"</div>"+
		 						"<div class='row'>"+
		 							"<div class='col-sm-12'>"+
		 								"<div style='color: #000000; font-family: Arial, Helvetica, sans-serif; font-size: 13px'>"+data[i].appointmentDate+" "+data[i].appointmentTime+"</div>"+
		 							"</div>"+
		 						"</div>"+
//		  						"<div class='row'>"+
//		  							"<div class='col-sm-12'>"+
//		  								"<div style='color: #000099; font-family: Arial, Helvetica, sans-serif; font-size: 13px'>"+data[i].appointmentTime+"</div>"+
//		  							"</div>"+
//		  						"</div>"+
		 					"</div>"+
		 					
		 					
		 					"<hr/></div>";
		        			 
		        		}else{
		        			
		        			selected_option = "<div class='row'>"+
							
							"<div class='col-sm-12'>"+
								"<div class='row'>"+
									"<div class='col-sm-12'>"+
										"<div style='color: #ff0516; font-family: Arial, Helvetica, sans-serif; font-size: 14px'>"+data[i].vehicle_id.vehicleID+"</div>"+
									"</div>"+
								"</div>"+
								"<div class='row'>"+
									"<div class='col-sm-12'>"+
										"<div style='color: #3e34fa; font-family: Arial, Helvetica, sans-serif; font-size: 13px'>"+data[i].appointmentDate+" "+data[i].appointmentTime+"</div>"+
									"</div>"+
								"</div>"+
//		 						"<div class='row'>"+
//		 							"<div class='col-sm-12'>"+
//		 								"<div style='color: #000099; font-family: Arial, Helvetica, sans-serif; font-size: 13px'>"+data[i].appointmentTime+"</div>"+
//		 							"</div>"+
//		 						"</div>"+
							"</div>"+
							
							
							"</div><hr/>";
		        			
		        		}  
		            
		            	 slctSubcat.append(selected_option);	
		        	}
	             document.getElementById('pendingAppoi').innerHTML = hj;

		        },
		        error:function(){
		         //   alert("error");
		        }

		    });
			//setTimeout(hideContinue,30);
		}
		
		
		
		
		
		
	
	</script>

</body>
</html>
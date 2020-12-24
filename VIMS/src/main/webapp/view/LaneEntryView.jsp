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
								<img src="data:image/jpg;base64,${imgVimg}" class="capCam"  id="results" onerror="this.onerror=null; this.src='resources/img/car-placeholder.jpg'" style="border-radius: 8px; border: 1px solid #ddd;"/>
				
								<br><br>
							</div>
							<div class="col-xl-2 col-lg-2">
								<p class="vidSty" id="vvno" >${vehNo}</p>
							</div>
							<div class="col-xl-2 col-lg-2">	
							</div>
							<div class="col-xl-2 col-lg-2">							
							
							<h2 class="text-white pb-2 fw-bold">Lane Entry</h2>
							
							</div>	
							<div class="ml-md-auto py-2 py-md-4">
<!-- 								<a href="vehicleInformation" class="btn btn-white btn-border btn-round mr-2">Gate Entry</a> -->
<%-- 								<a href="vehicleMasterAuto?vehicleID=<%=session.getAttribute("vRvid")%>&id=<%=session.getAttribute("vRocr")%>&appNo=0" class="btn btn-white btn-border btn-round mr-2">Vehicle Details</a> --%>
<!-- 								<a href="#" class="btn btn-white btn-border btn-round mr-2" data-toggle="modal" data-target="#checkDocumentModal">Document Check</a> -->
<!-- 								<a href="#" class="btn btn-white btn-border btn-round mr-2" data-toggle="modal" data-target="#capturePlateModal">Capture</a> -->
<!-- <a  class="btn btn-secondary btn-round" data-toggle="modal" data-target="#checkDocumentModal">Document Check</a> -->
							</div>
						</div>
					</div>
				</div>
				
				<div class="page-inner mt--5">	
				
		
				
				
<!-- 					<div class="page-header"> -->
<!-- 						<div class="col-xl-8 col-lg-6"> -->
					
<!-- 							<h4 class="page-title"> Vehicle Registrations</h4> -->
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
<!-- 									<a href="vehicleInformation">Gate Entry</a> -->
<!-- 								</li> -->
							
<!-- 								<li class="separator"> -->
<!-- 									<i class="flaticon-right-arrow"></i> -->
<!-- 								</li> -->
<!-- 								<li class="nav-item"> -->
<!-- 									<a href="vehicleInformation">Vehicle Details</a> -->
<!-- 								</li> -->
<!-- 							</ul> -->
<!-- 						</div>	 -->
<!-- 						<div class="col-xl-4 col-lg-6">	 -->
<!-- 							 <a type="button" class="bt-sty btn btn-outline-primary waves-effect" data-toggle="modal" data-target="#checkDocumentModal">Document Check</a> -->
									
							
<!-- 						</div>	 -->
<!-- 						</div> -->
				
						
				<form:form  modelAttribute="VehicleRegistration" method="POST" id="formVehicleRegistration">
					<!-- Card -->
		<!-- Area Chart -->
		
	 <div class="row">	
		<div class="col-xl-8 col-lg-6">
			<div class="card shadow mb-4">
				<!-- Card Header - Dropdown -->
				<div class="card-header py-1 d-flex flex-row align-items-center">
					<i class="fa fa-car" style='font-size:28px;color:blue'></i> <h6 class="m-0 font-weight-bold text-primary">.  Vehicle Details</h6>
					
				</div>

					
				<!-- Card Body -->
				<div class="card-body">		
						<div class="row">
							<div class="col-sm-2">
									<label for="manu1" class="l-fontst">Vehicle</label>
								</div>	
								<div class="col-sm-4">						             			             		
									<select  id="payVehicleNo" class="custom-select fontst" onchange="setPayVehicleNo(this.value);" >
										<option value="NONE">Select...</option>
										
									</select>		             		
								</div>
								<div class="col-sm-1">
									
								</div>		
								<div class="col-sm-5">
									<button type="button"  class="btn btn-primary btn-block" data-toggle="modal" data-target="#capturePlateModal">Capture License Plate</button>
								</div>
								
								
								
									
								
						
						</div>
							<br>			
					<hr>			
						<div class="form-group row">						
							<div class="col-sm-6">
								<div class="row">
									<div class="col-sm-4">
										<label for="manufactureYear" class="l-fontst">Customer</label>	
									</div>	
									<div class="col-sm-8">
									<label for="manufactureYear" class="2-fontst">${custom }</label>							             			             		
											<input class="form-control fontst" id="vregID" type="hidden" value="${VehicleRegistration.vregID}"  onchange="customerDate();" required="Required" />
												
<%-- 												<c:forEach items="${cusallCombo}" var="cus"> --%>
<%-- 													<form:option value="${cus.id}">${cus.name}</form:option>													 --%>
<%-- 												</c:forEach> --%>
<%-- 											</form:select>			             		 --%>
									</div>			
								</div>

							</div>		
						
										
						 </div>			

						<hr>

					<div class="form-group row">						
							<div class="col-sm-6">
								<div class="row">
									<div class="col-sm-4">
										<label for="manufactureYear" class="l-fontst">Test Category</label>	
									</div>	
									<div class="col-sm-8">						             			             		
										<label for="manufactureYear" class="2-fontst" id="tesCat">${VehicleRegistration.testCategory.categoryType }</label>
									</div>			
								</div>

							</div>		
							<div class="col-sm-6">	
								<div class="row">
									<div class="col-sm-6">
										<label  class="l-fontst">Lane Registration Type</label>
									</div>	
									<div class="col-sm-6">						             			             		
										<label for="manufactureYear" class="2-fontst"  id="verg">${VehicleRegistration.vtype.vRegType }</label>
									</div>
									
								</div>
							
							</div>
										
						 </div>	


					<div class="form-group row">						
							<div class="col-sm-6">
								<div class="row">
									<div class="col-sm-4">
										<label for="manufactureYear" class="l-fontst"  >Test Lane</label>	
									</div>	
									<div class="col-sm-8">						             			             													
										<label for="manufactureYear" class="2-fontst" id="lane">${VehicleRegistration.testLaneHeadId.laneName }</label>										             		
									</div>			
								</div>

							</div>		
							<div class="col-sm-6">	
								<div class="row">
									<div class="col-sm-6">
										<label  class="l-fontst">Lane Inspector</label>
									</div>	
									<div class="col-sm-6">						             			             		
                                        <label for="manufactureYear" class="2-fontst" id="insp">${VehicleRegistration.user.userName }</label>
									</div>
									
								</div>
							
							</div>
										
						 </div>	
<br>
<hr>

	<br><br><br><br><br><br><br>

					<div class="row">

			            <div class="col-sm-7">
			            </div>
						<div class="col-sm-5 justify-content-end">
			             	<button type="button"  class="btn btn-success btn-block" onclick="checkCondition();" id="proceedLanBtn">Proceed to Lane Entry in Lane</button>
						
								<div class="spinner-grow" role="status" id="moreLoder" style="display: none;">
												  <span class="sr-only" >Loading...</span>
												</div>
						
						
						</div>


					</div>

		


<!-- 									<button type="submit" class="btn btn-primary">Register</button> -->

								
					
							<!-- End of card body -->
						</div>
					</div>

				</div>
				
				
				
				
				
				
		<!-- Pie Chart -->
		<div class="col-xl-4 col-lg-5">
			<div class="card shadow mb-4">
				<!-- Card Header - Dropdown -->
				<div class="card-header py-2 d-flex flex-row align-items-center">
					<img src="resources/img/icon/perviousVehicleicon.png" class="iconstyle"/><h6 class="m-0 font-weight-bold text-primary">.  Previous Lane Entry </h6>
				</div>
				<!-- Card Body -->
				<div class="card-body  table-wrapper-scroll-y my-custom-scrollbar" style="height: 540px;">	
					<div class="row" >
								<div class="col-sm-12">
									<div class="row" id="preReg">
									</div>
<!-- 									<table id="eqTypeTable" -->
<!-- 									class="table-sm table-wrapper-scroll-y my-custom-scrollbar" -->
<!-- 									 style="height: 112px;"> -->

								

									
									
																	
								</div>
					</div>	
					
	
				</div>
			</div>
		</div>
				
				
	</div>			
				
				
				
				
				
				
				
				
				</form:form>
					
					
					
					
					
					
					
					
					
					
					
					<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="capturePlateModal" class="modal fade bd-example-modal"  role="dialog" aria-labelledby="myExtraLargeModalLabel" aria-hidden="true">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
<!--         <button type="button" class="close" data-dismiss="modal">&times;</button> -->
		<div class="col-sm-5">
			<h4 class="modal-title">Capture License Plate</h4>
		</div>
		<div class="col-sm-5">
        	<input class="form-control textred" name="vehNO" value="${vehNo}" id="vehNO" placeholder="Licence Plate NO..." readonly="true" />		
		</div>

      </div>
      <div class="modal-body">
       
   								

														<div class="form-group row">
			
															<div class="col-sm-12">
															<div class="row">
																	<div class="col-sm-5">
																		<div class="form-group row">
																			<div class="col-sm-12">
																				
																					<input class="form-control form-control-sm"
																			name="ocrrid" id="ocrrid" value="${ocid}"  type="hidden"/>
																			</div>
																		</div>																	
																		<div class="row">
																			<div class="col-sm-6">
																				
																			</div>
																			<div class="col-sm-5">
																																	
																			</div>

																		</div>
																	</div>
																	<div class="col-sm-3">
														

																	</div>																	
																</div>
																
																
																
																
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
														
														<table id="ocrdetails" class="table-wrapper-scroll-y my-custom-scrollbar" style="height: 112px;">                	
					
															<tbody id="ocrdetails4" >
															
															
															</tbody>
					
														</table>	
													</div>	
												</div>
												<br>
												
												<div class="row">
													<div class="col-sm-12">
														<a href="#" class="" onClick="takeSnapshot();" id="more">More..</a>	
													
														<div class="loader" id="moreLoder" style="display: none;"></div>
												</div>
																								
												
												
												
												
												
												
												</div>
												<div class="row">
<!-- 													<input type="file" class="" id="num_img"  accept="image/*" capture="user"  style="display: none;" />	 -->
												</div>
												
												
											</div>
											<div class="col-sm-6">
											
												<div class="row">
													<div class="col-mb-12 col-sm-12">
														<img src="resources/img/car-placeholder.jpg" class="capCam"  id="results1"/>
								             			<input type="hidden" name="ImageData" id="ImageData"  />
								             				
													</div>
												</div>
												<br>
												<div class="row">
													<div class="col-mb-12 col-sm-12">
														<input class="form-control fontst bgred" id="vehicleID" placeholder="Licence Plate NO..." oninput="checkVehicleNo(this.value)" onkeyup="this.value = this.value.toUpperCase();" />
													</div>
												</div>
												<br>
										
											</div>
									</div>															
													
															</div>
															
															
															
														</div>
										
<!--        style="display: none;" -->
								      </div>
								      <div class="modal-footer">
								      <div class="col-sm-6 mb-sm-6">
								      
								      </div>
								      <div class="col-sm-2 mb-sm-2">
											<button type="button" class="btn btn-success" data-dismiss="modal" onclick="saveOcrImage()" style="display: none;" id="veButt">Save</button>
									</div>
								      <div class="col-sm-3 mb-sm-3">
											<button type="button" class="btn btn-info" data-dismiss="modal" >Close</button>
										</div>																
								      </div>
								    </div>
								
								  </div>
								</div>

	











									
				<%@include file="checkDocument.jsp"%>	
					<%@include file="capturePlateModal.jsp"%>	
					</div>
				
			</div>	
			<%@include file="../WEB-INF/jsp/footer.jsp"%>			
		</div>
	</div>
<%@include file="../WEB-INF/jsp/commJs.jsp"%>

			<script>
	
	
	function checkCondition(){
				var mak=document.getElementById("ocrrid").value;
				
 				$.ajax({

 		 		    type: 'POST',
		 		    url: "saveLaneEntry", 
		 		    data: {"ocrid" : mak},
 			        success: function(data){
 			        	if(data=="1"){
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
 			        		swal("Oops...", "License Plate is not captured ! Please capture and continue", {
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
			        	}else{ 	
			        		clearAll();
			        		getPayVehicleNo();
							swal("Good job!", "This vehicle successfully assigned to the lane!", {
								icon : "success",
								buttons: {        			
									confirm: {
										className : 'btn btn-success'
									}
								},
							});
 			        	}

		 	
 			        },
 			        error:function(){
 			        	alert("Error");
 			        }
 				 });
			
			
		}
		
		
	
	
	</script>

	

<script type="text/javascript">


takeAutoNo();

function takeAutoNo() {

setTimeout(takeAutoNo, 3000); 

	$.ajax({

	    type: 'POST',
	    url: "takeAutoNo",
	    data: {"method":"2"},
        success: function(data){

        	//$("table tbody").empty();
        	
        	 var slctSubcat1=$('#ocrdetails4'), option="";
	            slctSubcat1.empty();
			for(var i=0; i<data.length; i++){
			
				selected_option =  "<tr data-folder='ghjgh'><td>"+ data[i].number+ "</td>"
		            +"<td style='display:none;'>"+ data[i].noimage+"</td>"
		            +"</tr>";
		            slctSubcat1.append(selected_option);
					//$("table tbody").append(markup);
           	 }

        },
        error:function(){
       //	alert("Error");
        }
	 });

}





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
			
	
					document.getElementById('vehicleID').value = data[0];
					checkVehicleNo(data[0]);
					document.getElementById('results1').src = "data:image/jpg;base64,"+data[1];
					document.getElementById("ImageData").value="data:image/jpg;base64,"+data[1];
			};
	 
			function saveOcrImage(){
				
				
				
				var imagebase64=document.getElementById("ImageData").value;
				if(imagebase64!=""){
		 		var y=document.getElementById("ocrrid").value;		 
		 		var jsonfile={json:JSON.stringify(imagebase64),id:y};
		 		$.ajax({

		 		    type: 'POST',
		 		    url: "saveNewOcrPlate", 
		 		    data: jsonfile,
		 	        success: function(data){
		 	        
			      	if(data=="1"){
			      		
			      		document.getElementById("results").src=imagebase64;
			      		
						swal("Good job!", "License Plate Capturing is successfully !", {
							icon : "success",
							buttons: {        			
								confirm: {
									className : 'btn btn-success'
								}
							},
						});
			      
			      	}else{
			      		
		        		swal("Oops...", "License Plate is not captured ! Please capture and continue ..", {
							icon : "error",
							buttons: {        			
								confirm: {
									className : 'btn btn-danger'
								}
							},
						});
			      		

			      		
			      	}
		 	        	
		 	        	
		 	        },
		 	        error:function(data){
		 	        	alert(data.responseText);
			           
		 	        }
		 		 });
				}else{
					
		        		swal("Oops...", "License Plate is not captured ! Please capture and continue ..", {
								icon : "error",
								buttons: {        			
									confirm: {
										className : 'btn btn-danger'
									}
								},
							});

				}

			}
				
		
			function checkVehicleNo(str){
// 					document.getElementById("veButt").style.display = "none";
					var oldVno=document.getElementById("vehNO").value;
					
					if(oldVno==str){
						document.getElementById("veButt").style.display = "block";
					}else{
						
						document.getElementById("veButt").style.display = "none";	
					}
				
			}
			function setPayVehicleNo(st){
				clearAll();
				document.getElementById("ocrrid").value=st;
				$.ajax({
			        type: 'POST',
			        url: "getVehicleRegistation",
			        data: {"ocrid":st},
			        success: function(data){
						document.getElementById("vvno").innerHTML=data.vid.vehicleID;
						document.getElementById("vehNO").value=data.vid.vehicleID;
						document.getElementById("vregID").value=data.vregID;
						
						
						document.getElementById("tesCat").innerHTML=data.testCategory.categoryType;
						document.getElementById("verg").innerHTML=data.vtype.vRegType;
						document.getElementById("lane").innerHTML=data.testLaneHeadId.laneName;
						document.getElementById("insp").innerHTML=data.user.userName;
						
						document.getElementById("results").src="data:image/jpg;base64,"+arrayBufferToBase64(data.ocrid.noimage );
						getPerviousVehicleRegistation(data.vid.vehicleID);
					
			        },
			        error:function(){
			          //  alert("No return Model data for this Class ID");
			        }
	
			    });	
				
				
				
				
				
				
				
				
				
				

				
				
			}
			function clearAll(){
			    var slctSubcat1=$('#preReg');
	            slctSubcat1.empty();
				document.getElementById("vvno").innerHTML="";
				document.getElementById("vehNO").value="";
				document.getElementById("vregID").value="";
				
				
				document.getElementById("tesCat").innerHTML="";
				document.getElementById("verg").innerHTML="";
				document.getElementById("lane").innerHTML="";
				document.getElementById("insp").innerHTML="";
				
				document.getElementById("results").src=null;
				
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
			
			
			
			
			
			function getPerviousVehicleRegistation(vno){
				$.ajax({
			        type: 'POST',
			        url: "getPerviousVehicleRegistation",
			        data: {"veno":vno},
			        success: function(data){
			        	
			            var slctSubcat1=$('#preReg'), option="";
			            slctSubcat1.empty();
			         
			            for(var i=0; i<data.length; i++){
			            	selected_option="<div class='row'>"+
							"<div class='col-sm-2'>"+
								"<img src='resources/img/icon/perviousVehicleicon.png' class='icon-pre-ve'/>"+
							"</div><div class='col-sm-10'><div class='row'><div class='col-sm-12'>"+
							"<div style='color: #000099; font-family: Arial, Helvetica, sans-serif; font-size: 12px'>"+
							data[i].vtype.vRegType+
							"</div>"+
									"</div></div><div class='row'><div class='col-sm-12'>"+
							"<div style='color: #000099; font-family: Arial, Helvetica, sans-serif; font-size: 12px'>"+
							data[i].date+" : "+data[i].time+
							"</div>"+
									"</div></div><div class='row'><div class='col-sm-12'>"+
							"<div style='color: #000099; font-family: Arial, Helvetica, sans-serif; font-size: 12px'>Mileage :"+
							data[i].currentMilage+
							"</div>"+
									"</div></div></div></div><hr/>";
			            
			            
			            slctSubcat1.append(selected_option);
							}
			        	
			        },error:function(){
			          //  alert("No return Model data for this Class ID");
			        }
	
			    });	
				
				
				
			}
			
			
			
			
			
			
			getPayVehicleNo();
			function getPayVehicleNo(){
					$.ajax({
				        type: 'POST',
				        url: "pendingLaneEntryData",				      
				        success: function(data){
				       
				            var slctSubcat=$('#payVehicleNo'), option="";
				            slctSubcat.empty();
				            selected_option = "<option value='' selected>Select Vehicle...</option>"
				            slctSubcat.append(selected_option);
		
				            for(var i=0; i<data.length; i++){
				             	if(data[i].noimage==""){
				                option = option + "<option value='"+data[i].ocrid + "'>"+data[i].ocrVid + "</option>";
				            }
				            }
				            slctSubcat.append(option);
				        },
				        error:function(){
				          //  alert("No return Model data for this Class ID");
				        }
		
				    });	
			}
			
			function takeSnapshot() {
				document.getElementById("moreLoder").style.display = "block";
				document.getElementById("more").style.display = "none";
			
					$.ajax({

					    type: 'POST',
					    url: "getLicensePlateip",
					    data: {"type":"0"},
				        success: function(data){
				        	
				        
				              
				        	document.getElementById('vehicleID').value = data[0].number;
	      					getVMasterData(data[0].number);
				            document.getElementById('results1').src = "data:image/jpg;base64,"+data[0].noimage;			    		
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
			
			</script>
</body>
</html>
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
								<p class="vidSty" >${vid}</p>
							</div>
							<div class="ml-md-auto py-2 py-md-4">
							   <h2 class="text-white pb-2 fw-bold">Payment</h2>
							
							</div>
						
							<div class="ml-md-auto py-2 py-md-4">
								<a href="vehicleInformation" class="btn btn-white btn-border btn-round mr-2">Gate Entry</a>
								<a href="vehicleMasterAuto?vehicleID=${vid}&id=${ocid}" class="btn btn-white btn-border btn-round mr-2">Vehicle Details</a>
								<button class="btn btn-white btn-border btn-round mr-2" data-toggle="modal" data-target="#checkDocumentModal" onclick="getDocumentCheck()">Document Check</button>

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
		<form:input class="form-control" path="centermaster.center_ID" id="icenterId" value='<%=session.getAttribute("centerid")%>'  readonly="true" type="hidden"  />
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

			         
			             	<div class="col-sm-4">
										             		<div class="row">
									<div class="col-sm-6">
										<label for="manufactureYear" class="l-fontst">Appointment ID</label>
										 	
									</div>	
									<div class="col-sm-5">	
										<c:if test = "${apono!='0'}">
											<input class="form-control fontst" name="apono" value='${apono}' readonly/>
										</c:if>	
										<c:if test = "${apono=='0'}">
											<input class="form-control fontst" name="apono" value="N/A" readonly/>
										</c:if>	
			             		
									</div>

												             		
									</div>
			             
			             	</div>
			             	<div class="col-sm-4">
	
			             			<div class="row">
									<div class="col-sm-6">
										<label  class="l-fontst">Appointment Time</label>
									</div>	
									<div class="col-sm-5">	
									
										<c:if test = "${apono!='0'}">
											<input class="form-control fontst" name="apoTime" value='${apoTime}' readonly/>
										</c:if>	
										<c:if test = "${apono=='0'}">
											<input class="form-control fontst" name="apoTime" value="N/A" readonly/>
										</c:if>
									
										             		
									</div>
									
								</div>
								
								
			             								<div class="col-sm-6">	

							
							</div>
			             	
			             	
			             	
			             	
			             	
			             	
			             	
			             	
			             	
			             	
			             	
			             	
			             		<div class="form-group row">
			             			<div class="col-sm-12">
				                		<form:input class="form-control textred" path="vid.vehicleID" id="vid" placeholder="Licence Plate NO..." readonly="true" type="hidden" />
<%-- 				                		<form:errors path="vehicleID" cssClass="error1"/> --%>
				                	</div>		
				               </div>
				           
		
			             	</div>
			             	<div class="col-sm-4">
			             		<div class="row">
			             			<div class="col-sm-6">
										<label  class="l-fontst">Mileage</label>
									</div>	
									<div class="col-sm-5">	
									
										<form:input class="form-control fontst" path="currentMilage" id="currentMilage" required="Required" />
									<input class="form-control fontst " value='${vclassid}' type="hidden" id="vclassids"/>
						             	
										             		
									</div>
			             		</div>
			             	</div>
			             </div>
<hr>
						<div class="form-group row">						
							<div class="col-sm-6">
								<div class="row">
									<div class="col-sm-4">
										<label for="manufactureYear" class="l-fontst">Customer</label>	
									</div>	
									<div class="col-sm-8">						             			             		
											<form:select class="form-control fontst" id="customer" path="cusid.id"  onchange="customerDate();" required="Required" >
												
												<c:forEach items="${cusallCombo}" var="cus">
													<form:option value="${cus.id}">${cus.name}</form:option>													
												</c:forEach>
											</form:select>			             		
									</div>			
								</div>

							</div>		
							<div class="col-sm-6">	
								<div class="row">
									<div class="col-sm-6">
										<label  class="l-fontst">Payment Type</label>
									</div>	
									<div class="col-sm-6">	
								<label  class="l-fontst" id="payType">Cash</label>
									<label  class="l-fontst" id="credbal"></label>	
									<input class="form-control fontst " value='0' type="hidden" id="credbalhid"/>
						             
													             			             		
<%-- 					             		<form:select path="payType" class="custom-select fontst" id="payType" onchange="" required="Required" readonly="true"> --%>
											
<%-- 											<c:forEach items="${veclass}" var="VClass"> --%>
<%-- 												<form:option value="Cash">Cash</form:option> --%>
<%-- 												<form:option value="Credit">Credit</form:option> --%>
<%-- 											</c:forEach> --%>
<%-- 										</form:select>			             		 --%>
									</div>
									
								</div>
							
							</div>
										
						 </div>	


					<div class="form-group row">						
							<div class="col-sm-6">
								<div class="row">
									<div class="col-sm-4">
										<label for="manufactureYear" class="l-fontst">Test Category</label>	
									</div>	
									<div class="col-sm-8">						             			             		
											<form:select class="form-control fontst" onchange="getLanes();tesTimeDetails();tesFeeDetails();"
												path="testCategory.categoryId" required="Required" id="testCat">
												<form:option value="">--SELECT--</form:option>
												<c:forEach items="${regCatTypeList}" var="testCat">
													<form:option value="${testCat.categoryId}">${testCat.categoryType}</form:option>
												</c:forEach>
											</form:select>			             		
									</div>			
								</div>

							</div>		
							<div class="col-sm-6">	
								<div class="row">
									<div class="col-sm-6">
										<label  class="l-fontst">Lane Registration Type</label>
									</div>	
									<div class="col-sm-6">						             			             		
											<form:select class="form-control fontst" path="vtype.vRegTypeID" onchange="tesFeeDetails();"     
												required="Required" id="vrtyp">
<%-- 												<form:option value="">--SELECT--</form:option> --%>
												<c:forEach items="${regTypeList}" var="rtp">
													<form:option value="${rtp.vRegTypeID}">${rtp.vRegType}</form:option>
												</c:forEach>
											</form:select>			             		
									</div>
									
								</div>
							
							</div>
										
						 </div>	


					<div class="form-group row">						
							<div class="col-sm-6">
								<div class="row">
									<div class="col-sm-4">
										<label for="manufactureYear" class="l-fontst">Test Lane</label>	
									</div>	
									<div class="col-sm-8">						             			             		
										
											
											<form:select class="form-control fontst" path="testLaneHeadId.testLaneHeadId" onchange="getLaneInspector();"     
												required="Required" id="tldid">
									
												<c:forEach items="${allLane}" var="lan">
													<form:option value="${lan.testLaneHeadId}">${lan.laneName} </form:option>
												</c:forEach>
											</form:select>	
													             		
									</div>			
								</div>

							</div>		
							<div class="col-sm-6">	
								<div class="row">
									<div class="col-sm-6">
										<label  class="l-fontst">Lane Inspector</label>
									</div>	
									<div class="col-sm-6">						             			             		
											<form:select class="form-control fontst" path="user"
												required="Required" id="users" >
												<form:option value="">--SELECT--</form:option>
<%-- 												<c:forEach items="${usercombo}" var="use"> --%>
<%-- 													<form:option value="${use.userId}">${use.userName}</form:option> --%>
<%-- 												</c:forEach> --%>
											</form:select>			             		
									</div>
									
								</div>
							
							</div>
										
						 </div>	

<hr>

						<div class="row">						
							<div class="col-sm-6">
								<div class="row">
									<div class="col-sm-5">
										<label  class="l-fontst">Inspection Fee</label>	
									</div>	
									<div class="col-sm-1">	
											<label  class="cursiz"  id="cur1"></label>			             			             		
<%-- 					             		<form:input class="fontst cursiz" path="" id="cur1" disabled="true"/> --%>
									     	             		
									</div>
									<div class="col-sm-5">	
										<label  class="amt"  id="inpFee"></label>										
<%-- 										<form:input class="form-control fontst" path="" id="inpFee" disabled="true"/>									 --%>
									</div>			
								</div>

							</div>		
							<div class="col-sm-6">	
								<div class="row">
									<div class="col-sm-8">
										<label  class="l-fontst">Approximate Inspection Duration</label>
									</div>	
									<div class="col-sm-4">
										<label  class="amt"  id="aiDu"></label>						             			             		
<%-- 					             		<form:input class="form-control fontst" path="" id="aiDu" disabled="true"/>		             		 --%>
									</div>
									
								</div>
							
							</div>
										
						 </div>	



						<div class="row">						
							<div class="col-sm-6">
								<div class="row">
									<div class="col-sm-5">
										<label  class="l-fontst">Tax</label>	
									</div>	
									<div class="col-sm-1">	
									<label  class="cursiz"  id="cur2"></label>					             			             		
<%-- 					             		<form:input class="form-control fontst cursiz" path="" id="cur2" disabled="true"/> --%>
									     	             		
									</div>
									<div class="col-sm-5">
									<label  class="amt"  id="tax"></label>												
<%-- 										<form:input class="form-control fontst" path="" id="tax" disabled="true"/>								 --%>
									</div>			
								</div>

							</div>		
							<div class="col-sm-6">	
								<div class="row">
									<div class="col-sm-8">
										<label  class="l-fontst">Current Lane Waiting Time</label>
									</div>	
									<div class="col-sm-4">	
										<label  class="amt"  id="curWtime"></label>						             			             		
<%-- 					             		<form:input class="form-control fontst" path="" id="curWtime" disabled="true"/>		             		 --%>
									</div>
									
								</div>
							
							</div>
										
						 </div>	

						<div class="row">						
							<div class="col-sm-6">
								<div class="row">
									<div class="col-sm-5">
									
										<label  class="l-fontst">Net Inspection Fee</label>	
									</div>	
									<div class="col-sm-1">	
									<label  class="cursiz"  id="cur3"></label>					             			             		
<%-- 					             		<form:input class="form-control fontst cursiz" path="" id="cur3" disabled="true"/> --%>
									     	             		
									</div>
									<div class="col-sm-5">	
									<label  class="amt"  id="netInsFree"></label>										
<%-- 										<form:input class="form-control fontst" path="" id="netInsFree" disabled="true"/>									 --%>
									</div>			
								</div>

							</div>		
							<div class="col-sm-6">	
								<div class="row">
									<div class="col-sm-8">
										<label  class="l-fontst">Expected Start Time</label>
									</div>	
									<div class="col-sm-4">
										<label  class="amt"  id="expStTime"></label>							             			             		
<%-- 					             		<form:input class="form-control fontst" path="" id="expStTime" disabled="true"/>		             		 --%>
									</div>
									
								</div>
							
							</div>
										
						 </div>	



						<div class="form-group  row">						
							<div class="col-sm-6">
								<div class="row">
									<div class="col-sm-5">
										
									</div>	
									<div class="col-sm-2">						             			             		
					             		
									     	             		
									</div>
									<div class="col-sm-4">											
																	
									</div>			
								</div>

							</div>		
							<div class="col-sm-6">	
								<div class="row">
									<div class="col-sm-8">
										<label  class="l-fontst">Expected End Time</label>
									</div>	
									<div class="col-sm-4">
										<label  class="amt"  id="expEndTime"></label>						             			             		
<%-- 					             		<form:input class="form-control fontst" path="" id="expEndTime" disabled="true"/>		             		 --%>
									</div>
									
								</div>
							
							</div>
										
						 </div>	

					<div class="row">

			            <div class="col-sm-6">
			            </div>
						<div class="col-sm-6 justify-content-end">
			             	<button type="button"  class="btn btn-success btn-block" onclick="checkCondition();" id="proceedLanBtn">Payment</button>
						
								<div class="spinner-grow" role="status" id="moreLoder" style="display: none;">
												  <span class="sr-only" >Loading...</span>
												</div>
						
						
						</div>


					</div>

					<form:input type="hidden" path="ocrid.ocrid" id="ocidd"  />


<!-- 									<button type="submit" class="btn btn-primary">Register</button> -->

								
					
							<!-- End of card body -->
						</div>
					</div>

				</div>
				<div class="col-xl-1 col-lg-1">
				
				</div>
				<div class="col-xl-2 col-lg-2">
				<br/><br/><br/><br/><br/><br/><br/>
					<div id="overlay" style="display: none;" >
					  <div id="loading-effect"><img alt="" src="resources/img/96x96.gif"></div>
					  <div id="text">Payment in Progress ....</div>
					</div>
				
				</div>
				
	</div>			
				
	
				
				
				
				
				
				
				</form:form>
					
					
			

									
				<%@include file="checkDocument.jsp"%>	
				
					</div>
				
			</div>	
			<%@include file="../WEB-INF/jsp/footer.jsp"%>			
		</div>
	</div>
<%@include file="../WEB-INF/jsp/commJs.jsp"%>

			<script>
		
			
			
			
			
			
			
			
			
			
			
			
			takeAutoNo();
			
			function takeAutoNo() {
	
			setTimeout(takeAutoNo, 3000); 

				$.ajax({

				    type: 'POST',
				    url: "takeAutoNo",
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
			

			
			
			
			
			
	function customerDate(){
		
		var cusid=document.getElementById("customer").value;
		var crba=0;
		$.ajax({
		    type: 'GET',
		    url: "getCustomerbyvehical",
		    data: {"cusid" : cusid},
		    success: function(data){
		    	crba=data.crBalance;
		    	var pty=data.isCredeit;
		    	  document.getElementById("payType").innerHTML=pty ;
		    	if(pty=="Cash"){
		    		  document.getElementById("credbal").innerHTML="" ;
		    		  document.getElementById("credbalhid").value="0.00";
		    	}else{
		    		 document.getElementById("credbal").innerHTML="  Balance is "+(parseFloat(crba)/100).toFixed(2) ;
		    		 document.getElementById("credbalhid").value=(parseFloat(crba)/100).toFixed(2)
		    		 
		    		 
		    	}
		     
		    },
		    error:function(){
		       
		  
		    	alert("Error");
	    	 
//		    	inpFee
		    }
		
		});
		
	}
	
	
	
	
	function checkCondition(){
		
		document.getElementById("overlay").style.display = "block";
		//
	if(document.getElementById("currentMilage").value!="0"&&document.getElementById("currentMilage").value!=""){
		
		
		if(document.getElementById("payType").innerHTML=="Credit"){
			document.getElementById("proceedLanBtn").style.display = "none";
			document.getElementById("moreLoder").style.display = "block";
			
		swal("Do you won't to generate Receipt or Invoice?", {
			  buttons: {
			    
			    catch: {
			      text: "Receipt",
			      value: "receipt",
			    },
			    defeat:  {
				      text: "Invoice",
				      value: "invoice",
				    },
				    cancel: "Close",
			  },
			})
			.then((value) => {
			  switch (value) {
			 
			    case "invoice":
			    	//netInsFree
			    	//document.getElementById("credbalhid").value
				var crbah=document.getElementById("credbalhid").value;
				var netinf=document.getElementById("netInsFree").innerHTML;	
				//alert("Error"+parseFloat(netinf)+"-"+parseFloat(crbah));
				
				if( parseFloat(netinf)<=parseFloat(crbah)){
					
				    var request_method = $("#formVehicleRegistration").attr("method"); //get form GET/POST method
					var form_data = $("#formVehicleRegistration").serialize();
					$.ajax({

				        url : "vehicleInvoiceRegAction",
				        type: request_method,
				        data : form_data,
				        success: function(data){
				        	
	 			        	if(data=="0"){
// 	 			        		Swal.close();
	 			        	document.getElementById("overlay").style.display = "none";
	 			        		swal("Oops...", "System Error", {
									icon : "error",
									buttons: {        			
										confirm: {
											className : 'btn btn-danger'
										}
									},
								});
	 	 						document.getElementById("proceedLanBtn").style.display = "block";
	 	 						document.getElementById("moreLoder").style.display = "none";
	 			        	}else if(data=="1"){
// 	 			        		Swal.close();
 				        	document.getElementById("overlay").style.display = "none";
				        		swal("Oops...", "Session Expired", {
									icon : "error",
									buttons: {        			
										confirm: {
											className : 'btn btn-danger'
										}
									},
								});
		        			window.location.href = "logout";
				        	}else if(data=="2"){
// 				        		Swal.close();
									document.getElementById("overlay").style.display = "none";
				        		swal("Oops...", "Documents are not verified ! Please confirm document verification and continue", {
									icon : "error",
									buttons: {        			
										confirm: {
											className : 'btn btn-danger'
										}
									},
								});
				        		
		 						document.getElementById("proceedLanBtn").style.display = "block";
		 						document.getElementById("moreLoder").style.display = "none";
				        	}else if(data=="3"){
// 				        		Swal.close();
				        	document.getElementById("overlay").style.display = "none";
				        		swal("Oops...", "Payment Receipt Already Issued for this Vehicle!", {
									icon : "error",
									buttons: {        			
										confirm: {
											className : 'btn btn-danger'
										}
									},
								});
				        		
		 						document.getElementById("proceedLanBtn").style.display = "block";
		 						document.getElementById("moreLoder").style.display = "none";
	 			        	}else if(data=="4"){
// 	 			        		Swal.close();
				        		document.getElementById("overlay").style.display = "none";
				        		swal("Oops...", "License Plate is not captured ! Please capture and continue", {
									icon : "error",
									buttons: {        			
										confirm: {
											className : 'btn btn-danger'
										}
									},
								});
		 						document.getElementById("proceedLanBtn").style.display = "block";
		 						document.getElementById("moreLoder").style.display = "none";
				        	}else{ 	
				        		
	 			       		window.location.href = data;
	 			       	document.getElementById("overlay").style.display = "none";
// 	 			       	Swal.close();
	 			        	}
	 			        	
				        },
				        error:function(){
				        	alert("Error");
				        	document.getElementById("overlay").style.display = "none";
				        }
					 }); 
			    
			      
			  }else{
				  
					swal("Oops...", "Credit Balance must be Greater Than  or equal Net Inspection Fee", {
						icon : "error",
						buttons: {        			
							confirm: {
								className : 'btn btn-danger'
							}
						},
					});
					
					document.getElementById("proceedLanBtn").style.display = "block";
					document.getElementById("moreLoder").style.display = "none";
					document.getElementById("overlay").style.display = "none";
			  }
				  break;
			    case "receipt":
			    	
			

			    	
	 			    var request_method = $("#formVehicleRegistration").attr("method"); //get form GET/POST method
	 				var form_data = $("#formVehicleRegistration").serialize();
	 				$.ajax({

	 			        url : "vehicleRegAction",
	 			        type: request_method,
	 			        data : form_data,
	 			        success: function(data){
	 			        	
	 			        	if(data=="0"){
// 	 			        		Swal.close();
	 			     document.getElementById("overlay").style.display = "none";
	 	 			       		swal("Oops...", "System Error", {
	 								icon : "error",
	 								buttons: {        			
	 									confirm: {
	 										className : 'btn btn-danger'
	 									}
	 								},
	 							});
	 	 						document.getElementById("proceedLanBtn").style.display = "block";
	 	 						document.getElementById("moreLoder").style.display = "none";
	 			        	}else if(data=="1"){
// 	 			        		Swal.close();
document.getElementById("overlay").style.display = "none";
				        		swal("Oops...", "Session Expired", {
									icon : "error",
									buttons: {        			
										confirm: {
											className : 'btn btn-danger'
										}
									},
								});
		        			window.location.href = "logout";
				        	}else if(data=="2"){
// 				        		Swal.close();
				        		document.getElementById("overlay").style.display = "none";
				        		swal("Oops...", "Documents are not verified ! Please confirm document verification and continue", {
									icon : "error",
									buttons: {        			
										confirm: {
											className : 'btn btn-danger'
										}
									},
								});
		 						document.getElementById("proceedLanBtn").style.display = "block";
		 						document.getElementById("moreLoder").style.display = "none";
				        	}else if(data=="3"){
// 				        		Swal.close();
				        		document.getElementById("overlay").style.display = "none";
				        		swal("Oops...", "This vehicle already Payment !", {
									icon : "error",
									buttons: {        			
										confirm: {
											className : 'btn btn-danger'
										}
									},
								});
		 						document.getElementById("proceedLanBtn").style.display = "block";
		 						document.getElementById("moreLoder").style.display = "none";
	 			        	}else if(data=="4"){
// 	 			        		Swal.close();
	 			        		document.getElementById("overlay").style.display = "none";
	 			        		swal("Oops...", "License Plate is not captured ! Please capture and continue", {
									icon : "error",
									buttons: {        			
										confirm: {
											className : 'btn btn-danger'
										}
									},
								});
		 						document.getElementById("proceedLanBtn").style.display = "block";
		 						document.getElementById("moreLoder").style.display = "none";
				        	}else{ 	
	 			        	
	 			       		window.location.href = data;
	 			       	document.getElementById("overlay").style.display = "none";
// 	 			       	Swal.close();
	 			        	}
	 			        	
	 			        },
	 			        error:function(){
	 			        	alert("Error");
	 			        	document.getElementById("overlay").style.display = "none";
	 			        }
	 				 });
			      break;
			 
// 			    default:
// 			      swal("Got away safely!");
			  }
			});
		}else{
// 			Swal.fire ({
// 				   title: 'Wait ...',
// 				   onBeforeOpen: () => {
// 				     Swal.showLoading ()
// 				   }
// 				})
			
			document.getElementById("proceedLanBtn").style.display = "none";
			document.getElementById("moreLoder").style.display = "block";
			    var request_method = $("#formVehicleRegistration").attr("method"); //get form GET/POST method
 				var form_data = $("#formVehicleRegistration").serialize();
 				$.ajax({

 			        url : "vehicleRegAction",
 			        type: request_method,
 			        data : form_data,
 			        success: function(data){
 			        	
 			        	if(data=="0"){
//  			        		Swal.close();
 			        	document.getElementById("overlay").style.display = "none";
 			       		swal("Oops...", "System Error", {
							icon : "error",
							buttons: {        			
								confirm: {
									className : 'btn btn-danger'
								}
							},
						});
 			        		
 	 						document.getElementById("proceedLanBtn").style.display = "block";
 	 						document.getElementById("moreLoder").style.display = "none";
 			        	}else if(data=="1"){
//  			        		Swal.close();
			        	
			        		document.getElementById("overlay").style.display = "none";
			        		swal("Oops...", "Session Expired", {
								icon : "error",
								buttons: {        			
									confirm: {
										className : 'btn btn-danger'
									}
								},
							});
			        		
			        		
	        			window.location.href = "logout";
			        	}else if(data=="2"){
// 			        		Swal.close();
			        document.getElementById("overlay").style.display = "none";
			        		
			        		swal("Oops...", "Documents are not verified ! Please confirm document verification and continue", {
								icon : "error",
								buttons: {        			
									confirm: {
										className : 'btn btn-danger'
									}
								},
							});
			        		
	 						document.getElementById("proceedLanBtn").style.display = "block";
	 						document.getElementById("moreLoder").style.display = "none";
			        	}else if(data=="3"){
// 			        		Swal.close();
			        		document.getElementById("overlay").style.display = "none";
			        		
			        		swal("Oops...", "This vehicle already Payment !", {
								icon : "error",
								buttons: {        			
									confirm: {
										className : 'btn btn-danger'
									}
								},
							});
			        		
			        		
			        		
			        		
	 						document.getElementById("proceedLanBtn").style.display = "block";
	 						document.getElementById("moreLoder").style.display = "none";
 			        	}else if(data=="4"){
//  			        		Swal.close();
		
			        		document.getElementById("overlay").style.display = "none";
			        		swal("Oops...", "License Plate is not captured ! Please capture and continue", {
								icon : "error",
								buttons: {        			
									confirm: {
										className : 'btn btn-danger'
									}
								},
							});
			        		
	 						document.getElementById("proceedLanBtn").style.display = "block";
	 						document.getElementById("moreLoder").style.display = "none";
			        	}else{ 	
 			        	
 			       		window.location.href = data;
//  			       	Swal.close();
 			       	document.getElementById("overlay").style.display = "none";
 			        	}
 			        	
		 	
 			        },
 			        error:function(){
 			        	alert("Error");
//  			        	Swal.close();
 			        	document.getElementById("overlay").style.display = "none";
 			        }
 				 });
			
			
		}
		
		
		//document.getElementById("proceedLanBtn").style.display = "block";
		
	}else{
		

		swal("Oops...", "Please Enter Current Mileage !", {
			icon : "error",
			buttons: {        			
				confirm: {
					className : 'btn btn-danger'
				}
			},
		});
		
	}
		
		
	
	}

	//load current date and time to jsp
		var date = new Date();

		document.getElementById("date").value = date.getFullYear() + "-"
				+ (date.getMonth() < 10 ? '0' : '') + (date.getMonth() + 1)
				+ "-" + (date.getDate() < 10 ? '0' : '') + date.getDate();
		document.getElementById("time").value = (date.getHours() < 10 ? '0'
				: '')
				+ date.getHours()
				+ ":"
				+ (date.getMinutes() < 10 ? '0' : '')
				+ date.getMinutes();
	</script>

	<script>
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//getLanes();
	
		function getLanes() {
			
			var icenterId=document.getElementById("icenterId").value;
			var vci=document.getElementById("vclassids").value;
			var catid=document.getElementById("testCat").value;
		

			//	alert("ffaaaaaaff="+icenterId+"-"+vci+"-"+catid);
				$.ajax({
    			    type: 'GET',
    			    url: "getTestLaneHeadvc",
    			    data: {"catid" : catid,"vclassid" : vci,"cenid" : icenterId},
    			    success: function(data){
    			    	
    			    	 document.getElementById("tldid").value= data[0][0];
    			    	 getLaneInspector();
    			    },
    			    error:function(){
    			       
   			  
			    	 
			    	 
// 			    	inpFee
    			    }
    			
    			});
				
				
		
			
		}


    	function tesFeeDetails()
    	{
	
			var vecCatID=document.getElementById("testCat").value;
			var vrTypId=document.getElementById("vrtyp").value;
			var centerId=document.getElementById("icenterId").value;
			
			var vehNo=document.getElementById("vid").value;
			
			var noofrepdate;
			//alert("vrTypId="+vrTypId);
			$.ajax({
			    type: 'GET',
			    url: "getVehicleRegisterType",
			    data: {"id" : vrTypId,"vNo" :vehNo },
			    success: function(data){
			    	
			    	noofrepdate=data[1];
			    	//alert("fff="+noofrepdate);
 			    	if(data[0]<=data[1]){
 			     		swal("Oops...", "Repeat Test Validity Period is Expired ", {
							icon : "error",
							buttons: {        			
								confirm: {
									className : 'btn btn-danger'
								}
							},
						});
 					}
					
			    	
			    },
			    error:function(){
			       
			  
		    	 
		    	 
//			    	inpFee
			    }
			
			});
			
			
			
			
			
			
			
			
		
			
			
		//	alert("call ="+vecCatID);
    		if (vecCatID=="")
    		{   
    			return;
    		}
    		if (vrTypId=="")
    		{   
    			return;
    		}
    		if (centerId=="")
    		{   
    			return;
    		}
    		
    		
    		else
    		{
    				$.ajax({
    			    type: 'GET',
    			    url: "tesFeeDetails",
    			    data: {"vecCatID" : vecCatID,"vrTypId" : vrTypId,"centerId" : centerId},
    			    success: function(data){
	 
    			    	 $('#inpFee').text(data[0]);
    			    	 $('#tax').text(data[1]);
    			    	 $('#netInsFree').text(data[2]);
    			    	 $('#cur1').text(data[3]);
    			    	 $('#cur2').text(data[3]);
    			    	 $('#cur3').text(data[3]);
			 
    			    },
    			    error:function(){
    			       
   			    	 $('#inpFee').text("");
			    	 $('#tax').text("");
			    	 $('#netInsFree').text("");
			    	 $('#cur1').text("");
			    	 $('#cur2').text("");
			    	 $('#cur3').text("");
			    	 alert("Not Correct");
			    	 
// 			    	inpFee
    			    }
    			
    			});
    		}
    	}
		
     	function tesTimeDetails()
    	{
     		
			var vecCatID=document.getElementById("testCat").value;

    		if (vecCatID=="")
    		{   
    			return;
    		}
	
    		else
    		{
    				$.ajax({
    			    type: 'GET',
    			    url: "tesTime",
    			    data: {"vecCatID" : vecCatID},
    			    success: function(data){
  	 
    			    	 $('#aiDu').text(data[0]);
    			    	 $('#curWtime').text(data[1]);
    			    	 $('#expStTime').text(data[2]);
    			    	 $('#expEndTime').text(data[3]);
  
    			    },
    			    error:function(){
    			       
   			    	 $('#curWtime').text("");
			    	 $('#aiDu').text("");
			    	 $('#expStTime').text("");
			    	 $('#expEndTime').text("");
	
			    	 alert("Not Correct");
			    	 
// 			    	inpFee
    			    }
    			
    			});
    				
    		}
    		
    		
    		 
    	}
//      	setvechileDateNo();
//      	function setvechileDateNo() {
//      		var str = document.getElementById("viewVid").innerHTML=document.getElementById("vid").value;

//      		link="vehicleMasterAuto?vehicleID="+data[i].ocrVid+"&id="+data[i].ocrid+"&appNo=0";
//      	}
     	
//      	var table = document.getElementsByTagName("table")[0];
//      	var tbody = table.getElementsByTagName("tbody")[0];
//      	tbody.onclick = function (e) {
//      	    e = e || window.event;
//      	    var data = [];
//      	    var target = e.srcElement || e.target;
//      	    while (target && target.nodeName !== "TR") {
//      	        target = target.parentNode;
//      	    }
//      	    if (target) {
//      	        var cells = target.getElementsByTagName("td");
//      	        for (var i = 0; i < cells.length; i++) {
//      	            data.push(cells[i].innerHTML);
//      	        }
//      	    }
//      			document.getElementById('vid').value = data[0];
//      			//document.getElementById('ocid').value = data[2];
//      		//	getVMasterData(data[0]);
//      		document.getElementById('currentMilage').value = data[4];
//      			document.getElementById('results').src = "data:image/jpg;base64,"+data[1];

//      	};
     	
     	
	</script>
	<script>
	$(document).ready(function(){
		  $("#currentMilage").keypress(function(e){
		    var keyCode = e.which;
		    /*
		    8 - (backspace)
		    32 - (space)
		    48-57 - (0-9)Numbers
		    */
		    if ( (keyCode != 8 || keyCode ==32 ) && (keyCode < 48 || keyCode > 57)) { 
		      return false;
		    }
		  });
	});
	
	function saveCheckDocment() {

		var request_method = $("#savaCheckdocid").attr("method"); //get form GET/POST method
		
		// Get form
		var form = $('#savaCheckdocid')[0];

		// Create an FormData object
		var data = new FormData(form);
		
		//alert("Error "+form_data);
		$.ajax({

			url : "savaCheckDocument",
			type : request_method,
			enctype : 'multipart/form-data',
			data : data,
			processData : false,
			contentType : false,
			cache : false,
			success : function(data) {
				
	 			if (data == "1") {
					swal("Good job!", "Document Check is Successfully Completed!", {
						icon : "success",
						buttons: {        			
							confirm: {
								className : 'btn btn-success'
							}
						},
					});
					
	 			}else{
	        		swal("Oops...", "Document Check is not Save ", {
						icon : "error",
						buttons: {        			
							confirm: {
								className : 'btn btn-danger'
							}
						},
					});
	 			}
	 			


			}

		});
		


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
			
			function getDocumentCheck(){
				//	alert("ddddddddddd");
				
				var ocid = document.getElementById("ocidd").value;
				 
				 	$.ajax({

				 	    type: 'GET',
				 	    url: "checkDocTable",
				 	    data: {"ocrid" : ocid},
				         success: function(data){
				        
				         	//$("table tbody").empty();
				        	if(data!=""){
				        		var dohid="";
				         	 var slctSubcat1=$('#checkDocTable'), option="";
				 	            slctSubcat1.empty();
				 			for(var i=0; i<data.length; i++){
							
				 				selected_option =  "<tr>"+
				 				"<td><div><input class='form-control form-control-sm' name='doc' id='doc' value="+data[i].documentcheckDetailsid+"  readonly/></div></td>"+
				 				"<td><div>"+data[i].documentid.description+"</div></td>"+
				 				"<td><div><input class='form-control form-control-sm' name='rem' id='rem' value="+data[i].remarks+"  /></div></td>"+
				 				"<td><div><select class='custom-select' name='docStatus' value="+data[i].checkStatus+" >"+
				 								"<option value='N/A'>N/A</option>"+
				 								"<option value='OK'>OK</option>"+
				 								"<option value='Not OK'>Not OK</option>"+
				 							"</select>"+		
				 				"</div></td>"+
				 			"</tr>"
									
									
									dohid=data[i].documentCheckHeadID.documentcheckheadid;
				 				 slctSubcat1.append(selected_option);	
									
				 			}
									
				 			
				 			document.getElementById("docheadid").value=	dohid;
				            	 }

				         },
				         error:function(){
				        	alert("Error");
				         }
				 	 });
					
					
				}
			getLaneInspector();
			function getLaneInspector(){
				
				var tldid=document.getElementById("tldid").value;
	            var slctSubcat=$('#users'), option="";
	            slctSubcat.empty();
	            option="<option value=''>--SELECT--</option>"
				$.ajax({
			        type: 'GET',
			        url: "getLaneInspector",
			        data: {"laneid" : tldid},
			        success: function(data){
			        	
;
			            for(var i=0; i<data.length; i++){
			                option = option + "<option value='"+data[i].userId.userId + "'>"+data[i].userId.userName + "</option>";
			               
			            }
			            slctSubcat.append(option);
			           
			        },
			        error:function(){
			            alert("No return vMake data");
			        }

			    });
				
			}
			
			</script>
</body>
</html>
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
								 <h2 class="text-white pb-2 fw-bold">Issue Ticket</h2>
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

							<div class="col-xl-12 col-md-6mb-4">
									<div class="card border-left-primary shadow h-100 py-2">
										<div class="card-body">

<form:form  modelAttribute="equipmentsIssue" method="POST" enctype="multipart/form-data" id="eqissue"> 
		<div class=" row">
			<div class="col-sm-7">

				<div class="form-group row">
					<div class="col-sm-3">	
						<label >Issue Type</label>
						<form:select class="form-control fontst" path="issueType"
												required="Required" id="issueType" onchange="">
						<form:option value="">--SELECT--</form:option>
						<form:option value="Equipment Failure">Equipment Failure</form:option>
						<form:option value="Lane Breakdown">Lane Breakdown</form:option>
<%-- 						<form:option value="Lane & Equipment Breakdown">Lane & Equipment Breakdown</form:option> --%>
						<form:option value="Other">Other</form:option>
						</form:select>
						
					</div>	
			
					<div class="col-sm-6">
						<label >Issue</label>
						<form:textarea path="issue" class="form-control"/>
					</div>
				</div>
				<div class="form-group row">
					<div class="col-sm-3">	
						<label>Lane</label>
							<form:select class="form-control fontst" path="testLaneHeadId.testLaneHeadId" onchange="getapoiment(this.value);getLaneStatus();"     
								 id="tldid">
								<form:option value="000">--SELECT--</form:option>
								<c:forEach items="${lanesissue}" var="lan">
									<form:option value="${lan.testLaneHeadId}">${lan.laneName} </form:option>
								</c:forEach>
							</form:select>	
					
					</div>
					<div class="col-sm-3">	
						<label >Lane Status</label>
						<form:select class="form-control fontst" path="laneStatus"
												 id="laneStatus" onchange="getLaneStatus();">
						<form:option value="">--SELECT--</form:option>
						<form:option value="Working">Lane is Active</form:option>
						<form:option value="Temporarily close">Temporarily close the lane</form:option>
						</form:select>
						
					</div>
				
				<div class="col-sm-3">
				
				<label >Lane Issue Time</label>
						<form:input type="time" path="laneIssueTime" class="form-control"/>
				
				</div>
				
				
				
				
				</div>
				
				<div class="form-group row">

					<div class="col-sm-3">
						<label>Equipment Type</label>
						<select class="form-control"   onchange="getAllEquipmenteByEquipmenteType();" id="eqtype">
							<option value="">--SELECT--</option>
							<c:forEach items="${eqTypeCmbfor}" var="eq1">
								<option value="${eq1.eqTypeID}">${eq1.eqType}</option>
							</c:forEach>
						</select>
					</div>
					<div class="col-sm-6">
						<label>Equipment</label>
						<form:select class="form-control" path="equipmentID.equipmentID"  id="eqid" onchange="setDate();">
							<form:option value="000">--SELECT--</form:option>
						</form:select>
					</div>
				</div>
				<div class="form-group row">	
					<div class="col-sm-3">	
						<label >Equipment is Working</label>
						<form:select class="form-control fontst" path="eqIsWorking"
												 id="eqIsWorking" onchange="">
						<form:option value="">--SELECT--</form:option>
						<form:option value="Working">Working</form:option>
						<form:option value="Not Working">Not Working</form:option>
						</form:select>
						
					</div>	
					<div class="col-sm-3">
				
						<label >Equipment Issue Time</label>
						<form:input type="time" path="equipmentIssueTime" class="form-control"/>
				
					</div>
					<div class="col-sm-3">
						<label >Issue Level</label>
						<form:select class="form-control fontst" path="issueLevel"
												required="Required" id="issueLevel" onchange="">
						<form:option value="">--SELECT--</form:option>
						<form:option value="Low">Low</form:option>
						<form:option value="Medium">Medium</form:option>high
						<form:option value="High">High</form:option>

						</form:select>
					</div>
				</div>
				<div class="form-group row">
				<h1 style="color: #ff0516; font-family: Arial, Helvetica, sans-serif;" id="laneSta"></h1>
				
				</div>
				<div class="form-group row">
									<div class="col-sm-6">
										<input type="button" class="btn btn-success"
																			value="Save" onclick="saveEquimentIssue()">
									
									</div>
									<div class="col-sm-6">
<!-- 										<input type="button" class="btn btn-warning" -->
<!-- 																			onclick="clear1()" value="CLEAR"> -->
									
									</div>
						</div>		
				
				
				
				
			</div>
			<div class="col-sm-5">
				<h2 style="color: #ff0516; font-family: Arial, Helvetica, sans-serif;" >Management Appointment</h2>	
			<div class="row table-striped table-bordered table-sm table-wrapper-scroll-y my-custom-scrollbar">
								<div class="col-lg" id="apoimentData"></div>
							</div>

			
			</div>
		</div>	
</form:form>										</div>
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

		function getLaneStatus(){
		//	var tldid=document.getElementById("tldid").value;
			var laneStatus=document.getElementById("laneStatus").value;
			
			var e = document.getElementById("tldid");
			var tldid = e.options[e.selectedIndex].text
		
			
			if(laneStatus=="Temporarily close"&&$('#tldid').val()!="000"){
				
				document.getElementById("laneSta").innerHTML =tldid+" is Temporarily Close";
			}else{
				document.getElementById("laneSta").innerHTML ="";
			}
			
			
			
			
		}
	
	
	
		function getAllEquipmenteByEquipmenteType(){
			var eqtype=document.getElementById("eqtype").value;
			//alert(calibrationDate);
			 		$.ajax({

			 		    type: 'POST',
			 		    url: "getEquipmentByType", 
			 		   data: {"eqtype" : eqtype},
			 	        success: function(data){
				            var slctSubcat=$('#eqid'), option="";
				            slctSubcat.empty();
				            option="<option value='000'>--SELECT--</option>"
				            for(var i=0; i<data.length; i++){
				                option = option + "<option value='"+data[i].equipmentID+ "'>"+data[i].serialNo + "</option>";
				               
				            }
				            slctSubcat.append(option);
			 	        	
			 	        },
			 	        error:function(data){
			 	        //	alert(data.responseText);
				           
			 	        }
			 		 });
			 		}	
	
	
		function getapoiment(etr) {
		
			$.ajax({

			    type: 'POST',
			    url: "getLaneAppointment",
			    data: {"lane":etr},
		        success: function(data){
		            var slctSubcat=$('#apoimentData'), option="";
		            slctSubcat.empty();
		    
		        	for(var i=0; i<data.length; i++){
		
		        		selected_option = "<div class='row'style=''>"+
	 					
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

	 					"</div>"+
	 					
	 					
	 					"<hr/></div><hr/>";
		        		
		        		
		            	 slctSubcat.append(selected_option);	
		            	 
		    	         
		        	}

			        	
			        },
			        error:function(){
			        //	alert("Error");
			        }
				 });
		        		
		        		
		        		
		}
		
		
		function saveEquimentIssue() {

			var request_method = $("#eqissue").attr("method"); //get form GET/POST method

			// Get form
			var form = $('#eqissue')[0];

			// Create an FormData object
			var data = new FormData(form);

			//alert("Error "+form_data);
			$.ajax({

				url : "saveEquipmentsIssue",
				type : request_method,
				enctype : 'multipart/form-data',
				data : data,
				processData : false,
				contentType : false,
				cache : false,

				success : function(data) {
				
					if (data == "0") {
						swal("Good job!", "You clicked the button!", {
							icon : "error",
							buttons : {
								confirm : {
									className : 'btn btn-danger'
								}
							},
						});
						
						

					} else {
						swal("Good job!", "Ticket No : "+data, {
							icon : "success",
							buttons : {
								confirm : {
									className : 'btn btn-success'
								}
							},
						});
					}
					document.getElementById("eqissue").reset();
				},
				error : function(e) {
					swal("Good job!", "You clicked the button! err", {
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